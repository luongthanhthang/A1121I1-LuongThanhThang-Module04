package com.codegym.controller;

import com.codegym.entity.Factory;
import com.codegym.entity.Product;
import com.codegym.service.IFactoryService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @Autowired
    IFactoryService iFactoryService;
//
//    @GetMapping(value = "/list")
//    public String display(Model model) {
//        List<Product> productList = iProductService.findAll();
//        model.addAttribute("productList", productList);
//        return "product/list";
//    }

//    @GetMapping("/view/{student_id}")
//    public String viewStudent(@PathVariable("student_id") String id, Model model) {
//        Student student = service.findById(id);
//        model.addAttribute("student", student);
//        return "/student/view";
//    }

//    // Dùng formatter
//    @GetMapping("/view/{product_id}")
//    public String viewStudent(@PathVariable("product_id") Product product, Model model) {
//        model.addAttribute("product", product);
//        return "product/view";
//    }

    @GetMapping("/edit/{product_id}")
    public String viewUpdate(@PathVariable("product_id") String id, Model model) {
        List<Factory> factoryList = iFactoryService.findAll();
        Product product = iProductService.findById(id);
        model.addAttribute("factoryList", factoryList);
        model.addAttribute("product", product);
        return "product/create";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("product") Product product, Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        iProductService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") String id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "product/view";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<Factory> factoryList = iFactoryService.findAll();
        Product product = new Product();
        product.setFactory(new Factory());
        model.addAttribute("product", product);
        model.addAttribute("factoryList", factoryList);
        return "product/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        iProductService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xoá thành công ");
        return "redirect:/product/list";
    }



    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        iProductService.create(product);
        return "redirect:/product/list";
    }

    //    @PostMapping("/create2")
//    public String create2(@RequestParam("id") String id,
//                          @RequestParam("name") String name
//                          , RedirectAttributes redirectAttributes
//    ) {
//        Product product = new Product(id, name);
//        service.create(product);
//        System.out.println("Create student success");
//        redirectAttributes.addFlashAttribute("students", service.findAll());
//        return "redirect:/student/list2";
//    }

    @GetMapping(value = "/list")
    public String listPaging(Model model, @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<Product> productList = iProductService.findAll(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("productList", productList);
        int totalPages = productList.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "product/listPaging";
    }
}
