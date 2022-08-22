package com.codegym.service.impl;

import com.codegym.entity.News;
import com.codegym.repository.NewsRepository;
import com.codegym.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    NewsRepository newsRepository;


    @Override
    public Page<News> findAll(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Override
    public Page<News> search(String title, String category, Pageable pageable) {
        return newsRepository.search("%" + title + "%", "%" + category + "%", pageable);
    }

    @Override
    public News findById(Integer id) {
        return newsRepository.findById(id).orElse(null);
    }

    @Override
    public void create(News news) {
        newsRepository.save(news);
    }

    @Override
    public void delete(Integer id) {
        newsRepository.deleteById(id);
    }
}
