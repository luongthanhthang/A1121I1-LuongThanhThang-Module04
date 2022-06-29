package com.codegym.controller;

import com.codegym.model.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicalController {
    @GetMapping("display")
    public ModelAndView display(@ModelAttribute("person") Person person) {
        ModelAndView modelAndView = new ModelAndView("medical-form");
        modelAndView.addObject("yearOfBirthList", new String[]{"1990", "1995", "2000"});
        modelAndView.addObject("sexList", new String[]{"nam", "nữ", "khác"});
        modelAndView.addObject("travelList", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác(Ghi rõ)"});
        modelAndView.addObject("nationList", new String[]{"Việt Nam", "Mỹ", "Trung Quốc"});
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("person") Person person) {
        ModelAndView modelAndView = new ModelAndView("info", "person", person);
        return modelAndView;
    }
}
