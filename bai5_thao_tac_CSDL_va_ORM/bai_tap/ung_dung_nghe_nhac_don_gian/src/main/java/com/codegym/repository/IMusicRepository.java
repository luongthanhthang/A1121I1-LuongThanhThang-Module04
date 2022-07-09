package com.codegym.repository;


import com.codegym.entity.Music;

import java.util.List;

public interface IMusicRepository {
    void create(Music music);

    void update(Music music);

    void delete(String name);

    List<Music> findAll();

    Music findById(String name);
}
