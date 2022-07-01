package com.codegym.controller;

import com.codegym.model.entity.Customer;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }

    @GetMapping("/view/{id}")
    public String viewStudentByParam(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        customerService.delete(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/create")
    public String viewCreate() {
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer) {
        customerService.create(customer);
        return "redirect:/customer/list";
    }
}
