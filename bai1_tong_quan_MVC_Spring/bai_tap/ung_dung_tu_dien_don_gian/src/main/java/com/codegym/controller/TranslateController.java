package com.codegym.controller;

import com.codegym.model.entity.EnglishLanguage;
import com.codegym.model.entity.VietnamLanguage;
import com.codegym.model.service.ITranslateService;
import com.codegym.model.service.impl.TranslateServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TranslateController {
    ITranslateService translateService = new TranslateServiceImpl();

    @GetMapping("/display")
    public String display() {
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String translate(Model model, @RequestParam String english) {
        Map<EnglishLanguage, VietnamLanguage> translateServiceDictionary = translateService.getDictionary();
        if (translateServiceDictionary.containsKey(new EnglishLanguage(english))) {
            model.addAttribute("vietnam", (translateServiceDictionary.get(new EnglishLanguage(english))).getLanguage());
        } else {
            model.addAttribute("error", "Khong tim thay trong tu dien");
        }
        model.addAttribute("english", english);
        return "dictionary";
    }
}
