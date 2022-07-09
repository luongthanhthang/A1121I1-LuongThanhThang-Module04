package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("customer")
    public Customer init() {
        return new Customer();
    }

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

    //    @PostMapping("/create")
//    public String create(@ModelAttribute("customer") Customer customer) {
//        customerService.create(customer);
//        return "redirect:/customer/list";
//    }
    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer) {
        customerService.create(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("customer") Customer customer) {
        customerService.update(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Customer> customerList = customerService.search(name);
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }
}
