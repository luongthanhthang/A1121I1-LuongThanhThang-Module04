package com.codegym.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler
    public String errorHandler(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        System.out.println("=============Error controller============");
        return "error";
    }
}
