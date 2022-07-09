package com.codegym.controller;

import com.codegym.model.entity.Mailbox;
import com.codegym.model.service.ILanguageService;
import com.codegym.model.service.IPageSizeService;
import com.codegym.model.service.LanguageServiceImpl;
import com.codegym.model.service.PageSizeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailboxController {
    ILanguageService languageService = new LanguageServiceImpl();
    IPageSizeService pageSizeService = new PageSizeServiceImpl();
    @ModelAttribute("mailbox")
    public Mailbox init() {
        return new Mailbox();
    }

    static Mailbox mailboxStatic = new Mailbox();

    @GetMapping("/display")
    public ModelAndView displayForm() {

        ModelAndView modelAndView = new ModelAndView("mailbox-form");
        modelAndView.addObject(mailboxStatic);
        modelAndView.addObject("languageList", languageService.languageList());
        modelAndView.addObject("pageSizeList", pageSizeService.pageSizeList());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("mailbox") Mailbox mailbox) {
        // dữ liệu list
        mailboxStatic = mailbox;
        ModelAndView modelAndView = new ModelAndView("mailbox-detail", "mailbox", mailbox);
        return modelAndView;
    }
}
