package com.codegym.controller;

import com.codegym.entity.Music;
import com.codegym.entity.MusicForm;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:music1.properties")
public class MusicController {
    @Autowired
    IMusicService musicService;

    @Value("${file-upload}")
    private String fileUpload;


    @ModelAttribute("musicForm")
    public MusicForm init() {
        return new MusicForm();
    }
//
//    @ModelAttribute("music")
//    public Music init() {
//        return new Music();
//    }

    @GetMapping("/list")
    public String display(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "music/list";
    }

    @GetMapping("/view/{name}")
    public String viewProduct(Model model, @PathVariable("name") String name) {
        Music music = musicService.findById(name);
        model.addAttribute("music", music);
        return "music/view";
    }

    @GetMapping("/create")
    public String viewCreate() {
        return "music/create";
    }

//    @PostMapping("/create")
//    public String create(@ModelAttribute("music") Music music) {
//
//        musicService.create(music);
//        return "redirect:/list";
//    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("musicForm") MusicForm musicForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "music/create";
        }

        MultipartFile multipartFile = musicForm.getFilePath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getFilePath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(musicForm.getName(), musicForm.getSingerName(), musicForm.getCategory(), fileName);
        musicService.create(music);
        return "redirect:/list";
    }

    @GetMapping("/delete/{name}")
    public String delete(@PathVariable("name") String name, RedirectAttributes redirectAttributes) {
        musicService.delete(name);
        redirectAttributes.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/list";
    }

    @GetMapping("/edit/{name}")
    public String viewEdit(@PathVariable("name") String name, Model model) {
        Music music = musicService.findById(name);
        model.addAttribute("music", music);
        return "music/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("music") Music music) {
        musicService.update(music);
        return "redirect:/list";
    }
}
