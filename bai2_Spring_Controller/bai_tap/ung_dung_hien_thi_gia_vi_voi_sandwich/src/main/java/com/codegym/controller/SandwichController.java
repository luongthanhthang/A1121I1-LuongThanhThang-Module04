package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping("/save")
    public String saveView(){
        return "sandwich";
    }

    @PostMapping("/save")
    public String save(@RequestParam("condiment") String condiment, Model model){
        model.addAttribute("sandwich",condiment);
        return "sandwich";
    }
}
