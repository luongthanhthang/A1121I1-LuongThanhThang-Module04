package com.codegym.controller;

import com.codegym.entity.*;
import com.codegym.service.IRentTypeService;
import com.codegym.service.IServiceService;
import com.codegym.service.IServiceTypeService;
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
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceTypeService serviceTypeService;
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Service> serviceList = serviceService.findAllService(pageable);
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "service/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        Service service = new Service();
        service.setServiceTypeId(new ServiceType());
        service.setRentTypeId(new RentType());
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("service", service);
        return "service/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("service") Service service, RedirectAttributes redirectAttributes) {
        serviceService.insertService(service);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/service/list";
    }
}
