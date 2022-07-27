package com.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.codegym.entity.Product;
import com.codegym.service.IProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @ModelAttribute("product")
    public Product initProduct() {
        return new Product();
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        return "/create";
    }

    @PostMapping("/create")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("mess","Updated product successfully!");
        return "redirect:/product/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("product") Product product, RedirectAttributes redirect) {
        redirect.addFlashAttribute("mess", "Removed product successfully!");
        productService.remove(product.getId());
        return "redirect:/product/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("nameSearch") String nameSearch, Model model){
        List<Product> productList = productService.search(nameSearch);
        if (productList.isEmpty()){
           model.addAttribute("mess", "Not found product");
        } else {
            model.addAttribute("productList", productList);
        }
        return "/list";
    }
}

