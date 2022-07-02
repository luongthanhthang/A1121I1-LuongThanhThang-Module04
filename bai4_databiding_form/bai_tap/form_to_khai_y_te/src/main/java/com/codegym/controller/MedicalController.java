package com.codegym.controller;

import com.codegym.model.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> mapError = new HashMap<>();
        if (person.getName().equals("")) {
            mapError.put("name", "Bạn chưa nhập mục này");
        }
        if (person.getYearOfBirth().equals("")) {
            mapError.put("birthday", "Bạn chưa nhập mục này");
        }
        if (person.getIdCard().equals("")) {
            mapError.put("idCard", "Bạn chưa nhập mục này");
        }
        if (person.getTravel() == null) {
            mapError.put("travelInfo", "Bạn chưa nhập mục này");
        }
        if (person.getTravelId().equals("")) {
            mapError.put("numberVehicle", "Bạn chưa nhập mục này");
        }
        if (person.getSeats().equals("")) {
            mapError.put("numberSeat", "Bạn chưa nhập mục này");
        }
        if (person.getStartDate().equals("")) {
            mapError.put("dateStart", "Bạn chưa nhập mục này");
        }
        if (person.getEndDate().equals("")) {
            mapError.put("dateEnd", "Bạn chưa nhập mục này");
        }
        if (person.getAttention().equals("")) {
            mapError.put("extraInfo", "Bạn chưa nhập mục này");
        }
        ModelAndView modelAndView = null;


        if (mapError.isEmpty()) {
            modelAndView = new ModelAndView("info");
            modelAndView.addObject("person", person);
        } else {
            modelAndView = new ModelAndView("medical-form");
            modelAndView.addObject("yearOfBirthList", new String[]{"1990", "1995", "2000"});
            modelAndView.addObject("sexList", new String[]{"nam", "nữ", "khác"});
            modelAndView.addObject("travelList", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác(Ghi rõ)"});
            modelAndView.addObject("nationList", new String[]{"Việt Nam", "Mỹ", "Trung Quốc"});
            modelAndView.addObject("person", person);
            modelAndView.addObject("mapError", mapError);
        }
        return modelAndView;
    }
}
