package com.codegym.controller;

import com.codegym.entity.*;
import com.codegym.service.IContractService;
import com.codegym.service.ICustomerService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IServiceService serviceService;
    @Autowired
    IContractService contractService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Contract> contractList = contractService.findAll(pageable);
        List<Employee> employeeList = employeeService.findAllList();
        List<Customer> customerList = customerService.findAllList();
        List<Service> serviceList = serviceService.findAllList();
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("contractList", contractList);
        return "contract/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<Employee> employeeList = employeeService.findAllList();
        List<Customer> customerList = customerService.findAllList();
        List<Service> serviceList = serviceService.findAllList();
        Contract contract = new Contract();
        contract.setEmployeeId(new Employee());
        contract.setCustomerId(new Customer());
        contract.setServiceId(new Service());
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("contract", contract);
        return "contract/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes) {
        contractService.insert(contract);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/contract/list";
    }
}
