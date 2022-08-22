package com.codegym.repository;

import com.codegym.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    @Query(value = "select * from news where `title` like ?1 and `category_id` like ?2", nativeQuery = true)
    Page<News> search(String title, String category, Pageable pageable);
}
