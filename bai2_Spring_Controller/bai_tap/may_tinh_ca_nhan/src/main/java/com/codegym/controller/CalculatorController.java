package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/display")
    public String calculatorView() {
        return "index";
    }

    @PostMapping("calculator")
    public String calculator(@RequestParam("number1") Double number1, @RequestParam("number2") Double number2
            , @RequestParam("operator") String operator, Model model) {
        Double result = 0.0;
        String equal = "=";
        switch (operator) {
            case "+":
                result = number1 + number2;
                model.addAttribute("number1", number1);
                model.addAttribute("number2", number2);
                model.addAttribute("operator", operator);
                model.addAttribute("result", result);
                model.addAttribute("equal", equal);
                break;
            case "-":
                result = number1 - number2;
                model.addAttribute("number1", number1);
                model.addAttribute("number2", number2);
                model.addAttribute("operator", operator);
                model.addAttribute("result", result);
                model.addAttribute("equal", equal);
                break;
            case "*":
                result = number1 * number2;
                model.addAttribute("number1", number1);
                model.addAttribute("number2", number2);
                model.addAttribute("operator", operator);
                model.addAttribute("result", result);
                model.addAttribute("equal", equal);
                break;
            case "/":
                if (number2 == 0) {
                    String error = "Error Number Division 0";
                    model.addAttribute("error", error);
                } else {
                    result = number1 / number2;
                    model.addAttribute("number1", number1);
                    model.addAttribute("number2", number2);
                    model.addAttribute("operator", operator);
                    model.addAttribute("result", result);
                    model.addAttribute("equal", equal);
                    break;
                }
        }
        return "index";
    }
}
