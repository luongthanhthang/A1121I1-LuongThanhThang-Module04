package com.codegym.controller;

import com.codegym.entity.User;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public String display(Model model) {
        List<User> userList =userService.findAll();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "user/create";
        }
        userService.create(user);
        return "redirect:/list";
    }
}
