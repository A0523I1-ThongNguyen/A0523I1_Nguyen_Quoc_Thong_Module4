package com.example.ss5_t_music.service;

import com.example.ss5_t_music.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void add(Music music);
    Music findById(int id);
    void delete(int id);
    void update(Music musicUpdate);
}
