package com.codegym.controller;

import com.codegym.entity.Cart;
import com.codegym.entity.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error-404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if(action.equals("reduce")) {
            cart.reduceProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if(action.equals("delete")) {
            cart.deleteProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }

        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("view/{id}")
    public String viewDetail(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()) {
            return "error-404";
        }
        model.addAttribute("product",product.get());
        return "view";
    }

}
