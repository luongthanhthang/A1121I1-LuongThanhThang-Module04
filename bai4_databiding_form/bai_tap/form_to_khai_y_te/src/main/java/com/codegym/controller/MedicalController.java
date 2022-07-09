package com.codegym.controller;

import com.codegym.model.entity.Person;
import com.codegym.model.service.ElementFormServiceImpl;
import com.codegym.model.service.IElementFormService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MedicalController {

    IElementFormService elementFormService = new ElementFormServiceImpl();

    @GetMapping("display")
    public ModelAndView display(@ModelAttribute("person") Person person) {
        ModelAndView modelAndView = new ModelAndView("medical-form");
        modelAndView.addObject("yearOfBirthList", new String[]{"1990", "1995", "2000"});

        modelAndView.addObject("sexList", elementFormService.genderList());
        modelAndView.addObject("travelList", elementFormService.nationalityList());
        modelAndView.addObject("nationList", elementFormService.travelInfoList());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("person") Person person) {
        Map<String, String> mapError = elementFormService.checkData(person);
        ModelAndView modelAndView = null;


        if (mapError.isEmpty()) {
            modelAndView = new ModelAndView("info");
            modelAndView.addObject("person", person);
        } else {
            modelAndView = new ModelAndView("medical-form");
            modelAndView.addObject("yearOfBirthList", new String[]{"1990", "1995", "2000"});
            modelAndView.addObject("person", person);
            modelAndView.addObject("mapError", mapError);

            modelAndView.addObject("mapError", mapError);
            modelAndView.addObject("sexList", elementFormService.genderList());
            modelAndView.addObject("travelList", elementFormService.nationalityList());
            modelAndView.addObject("nationList", elementFormService.travelInfoList());
        }
        return modelAndView;
    }
}
