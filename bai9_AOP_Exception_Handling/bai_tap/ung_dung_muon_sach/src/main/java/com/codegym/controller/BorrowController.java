package com.codegym.controller;

import com.codegym.entity.Borrow;
import com.codegym.exception.BookException;
import com.codegym.service.IBookService;
import com.codegym.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    IBorrowService borrowService;

    @Autowired
    IBookService bookService;

    @GetMapping("/create/{id}")
    public String borrow(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id) throws BookException {

        if (bookService.findById(id).getQuantity() <= 0) {
            redirectAttributes.addFlashAttribute("mess", "Sách đã hết, không được mượn");
            throw new BookException("Book quantity bé hơn 0");
        }



        borrowService.create(new Borrow(), id);
        redirectAttributes.addFlashAttribute("mess", "Mượn sách thành công");
        return "redirect:/book/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("maTraSach") String idBorrow, RedirectAttributes redirectAttributes) {
        if (borrowService.findByBorrowId(idBorrow) == null) {
            redirectAttributes.addFlashAttribute("mess", "Không tìm thấy mã sách");
            return "redirect:/book/list";
        }

        borrowService.delete(idBorrow);
        redirectAttributes.addFlashAttribute("mess", "Trả sách thành công");
        return "redirect:/book/list";
    }

    @ExceptionHandler(BookException.class)
    public String errorHandler(BookException e, Model model)  {
        model.addAttribute("message", e.getMessage());
        System.out.println("=============Book controller============");
        return "error";
    }
}
