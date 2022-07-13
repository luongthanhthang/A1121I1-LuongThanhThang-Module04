package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.entity.Province;
import com.codegym.service.ICustomerService;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("customer")
    public Customer init() {
        return new Customer();
    }


    @GetMapping("/list")
    public String list(Model model,@PageableDefault(value = 5) Pageable pageable, @RequestParam("name") Optional<String> name) {
        Page<Customer> customerList;
        if(name.isPresent()) {
            customerList = customerService.search(name.get(), pageable);
            model.addAttribute("name", name.get());
        } else {
            customerList = customerService.findAll(pageable);
        }
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
    public String viewCreate(Model model) {
        List<Province> provinceList = provinceService.findAll();
        Customer customer = new Customer();
        customer.setProvince(new Province());
        model.addAttribute("provinceList", provinceList);
        model.addAttribute("customer", customer);
        return "customer/create";
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

//    @GetMapping("/search")
//    public String search(@RequestParam("name") String name, Model model, @PageableDefault(value = 5) Pageable pageable) {
//        Page<Customer> customerList = customerService.search(name, pageable);
//        model.addAttribute("customerList", customerList);
//        return "customer/list";
//    }
}
