package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService iProductService;

    @ModelAttribute("product")
    public Product initProduct(){
        return new Product();
    }

    @GetMapping("/list")
    public String display(Model model) {
        List<Product> productList =iProductService.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(Model model, @PathVariable("id") String id) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "product/view";
    }

    @GetMapping("/create")
    public String viewCreate(){
        return "product/create";
    }
//
//    @PostMapping("/create")
//    public String create(
//            @RequestParam("id") String id,
//            @RequestParam("name") String name,
//            @RequestParam("describe") String describe
//    ) {
//        Product product = new Product(id, name, describe);
//        iProductService.create(product);
//        return "redirect:/list";
//    }

//    ---------sử dụng @ModelAttribute---------
    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product) {
        iProductService.create(product);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        iProductService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") String id, Model model){
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "product/edit";
    }

    @PostMapping("/edit")
    public String edit(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("describe") String describe
    ) {
        Product product = new Product(id, name, describe);
        iProductService.update(product);
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchName") String searchName, Model model) {
        List<Product> productList = iProductService.findByName(searchName);
        model.addAttribute("productList", productList);
        return "product/list";
    }

//    @PostMapping("/delete")
//    public String delete(Customer customer, RedirectAttributes redirect) {
//        customerService.remove(customer.getId());
//        redirect.addFlashAttribute("success", "Removed customer successfully!");
//        return "redirect:/customer";
//    }
}
