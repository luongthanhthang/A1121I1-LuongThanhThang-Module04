package com.codegym.controller;

import com.codegym.model.entity.Mailbox;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailboxController {
    static Mailbox mailboxStatic = new Mailbox();
    @GetMapping("/display")
    public ModelAndView displayForm() {
        // dữ liệu list
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");

        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(100);

        ModelAndView modelAndView = new ModelAndView("mailbox-form");
        if (mailboxStatic.getLanguages() == null && !mailboxStatic.isSpamsFilter() && mailboxStatic.getPageSizes() == null && mailboxStatic.getSignature() == null) {
            modelAndView.addObject("mailbox", new Mailbox());
        } else {
            modelAndView.addObject(mailboxStatic);
        }
        modelAndView.addObject("languageList", languages);
        modelAndView.addObject("pageSizeList", pageSize);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("mailbox") Mailbox mailbox) {
        // dữ liệu list
        mailboxStatic = mailbox;
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");

        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(100);
        ModelAndView modelAndView = new ModelAndView("mailbox-detail", "mailbox", mailbox);
        return modelAndView;
    }
}
