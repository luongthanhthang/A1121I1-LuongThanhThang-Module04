package com.codegym.controller;

import com.codegym.entity.Category;
import com.codegym.entity.News;
import com.codegym.service.ICategoryService;
import com.codegym.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    INewsService newsService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 5) Pageable pageable,
                          @RequestParam("title") Optional<String> title,
                          @RequestParam("categoryId") Optional<String> categoryId
    ) {
        Page<News> newsList;
        String condition = "";

        if (title.isPresent() || categoryId.isPresent()) {
            newsList = newsService.search(title.get(), categoryId.get(), pageable);
            model.addAttribute("newsList", newsList);
        }

        if (title.isPresent()) {
            condition += "&title=" + title.get();
            model.addAttribute("title", title.get());
        }
        if (categoryId.isPresent()) {
            condition += "&categoryId=" + categoryId.get();
            model.addAttribute("categoryId", categoryId.get());
        } else {
            newsList = newsService.findAll(pageable);
            model.addAttribute("newsList", newsList);
        }

        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("condition", condition);
        return "list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        newsService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<Category> categoryList = categoryService.findAll();
        News news = new News();
        news.setCategory(new Category());
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("news", news);
        return "create";
    }

    @PostMapping("/create")
    public String create(
            @Valid
            @ModelAttribute("news") News news,
            BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            news.setCategory(new Category());
            List<Category> categoryList = categoryService.findAll();

            model.addAttribute("categoryList", categoryList);
            model.addAttribute("news", news);
            return "create";
        }
        newsService.create(news);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        News newsView = newsService.findById(id);
        model.addAttribute("newsView", newsView);
        return "list";
    }


}
