package com.codegym.controller;

import com.codegym.entity.News;
import com.codegym.service.ICategoryService;
import com.codegym.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/news")
public class HomeRestController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    INewsService newsService;


    @GetMapping
    public ResponseEntity<Page<News>> findAll(@PageableDefault(value = 5) Pageable pageable) {
        Page<News> newsList = newsService.findAll(pageable);
        if (newsList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(newsList, HttpStatus.OK);
        }
    }
}
