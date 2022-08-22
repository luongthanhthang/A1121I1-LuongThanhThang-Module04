package com.codegym.service;

import com.codegym.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INewsService {
    Page<News> findAll(Pageable pageable);
    Page<News> search(String title, String category, Pageable pageable);
    News findById(Integer id);
    void create(News news);
    void delete(Integer id);
}
