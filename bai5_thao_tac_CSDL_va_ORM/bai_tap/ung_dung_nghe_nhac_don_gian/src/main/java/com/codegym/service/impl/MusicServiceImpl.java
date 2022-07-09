package com.codegym.service.impl;

import com.codegym.entity.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    IMusicRepository musicRepository;

    @Override
    public void create(Music music) {
        musicRepository.create(music);
    }

    @Override
    public void update(Music music) {
        musicRepository.update(music);
    }

    @Override
    public void delete(String name) {
        musicRepository.delete(name);
    }

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findById(String name) {
        return musicRepository.findById(name);
    }
}
