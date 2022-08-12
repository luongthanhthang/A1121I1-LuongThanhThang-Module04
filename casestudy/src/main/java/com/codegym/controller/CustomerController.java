package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.entity.CustomerType;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 4) Pageable pageable,
                          @RequestParam("nameSearch") Optional<String> nameSearch,
                          @RequestParam("emailSearch") Optional<String> emailSearch,
                          @RequestParam("typeSearch") Optional<String> typeSearch
    ) {
        Page<Customer> customerList;
        String condition = "";

        if (nameSearch.isPresent() || emailSearch.isPresent() || typeSearch.isPresent()) {
            customerList = customerService.searchCustomer(nameSearch.get(), emailSearch.get(), typeSearch.get(), pageable);
            model.addAttribute("customerList", customerList);
        }

        if (nameSearch.isPresent()) {
            condition += "&nameSearch=" + nameSearch.get();
            model.addAttribute("nameSearch", nameSearch.get());
        }
        if (emailSearch.isPresent()) {
            condition += "&emailSearch=" + emailSearch.get();
            model.addAttribute("emailSearch", emailSearch.get());
        }
        if (typeSearch.isPresent()) {
            condition += "&typeSearch=" + typeSearch.get();
            model.addAttribute("typeSearch", typeSearch.get());
        } else {
            customerList = customerService.findAllCustomer(pageable);
            model.addAttribute("customerList", customerList);
        }

        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("condition", condition);
        return "customer/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        Customer customer = new Customer();
        customer.setTypeId(new CustomerType());
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customer", customer);
        return "customer/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            customer.setTypeId(new CustomerType());
            List<CustomerType> customerTypeList = customerTypeService.findAll();

            model.addAttribute("customerTypeList", customerTypeList);
            model.addAttribute("customer", customer);
            return "customer/create";
        }
        customerService.insertCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(Model model, @PathVariable("id") Integer id) {
        Customer customer = customerService.selectCustomer(id);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.updateCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Edit thành công");
        return "redirect:/customer/list";
    }
}
