package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {

    @GetMapping("/display")
    public String getCurrent() {
        return "currency_conversion";
    }

    @PostMapping("/current")
    public String current(Model model, @RequestParam String usd) {
        int vnd = Integer.parseInt(usd) * 23000;
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        return "currency_conversion";
    }
}
