package com.codegym.service;


import com.codegym.entity.Music;

import java.util.List;

public interface IMusicService {
    void create(Music music);

    void update(Music music);

    void delete(String name);

    List<Music> findAll();

    Music findById(String name);
}
