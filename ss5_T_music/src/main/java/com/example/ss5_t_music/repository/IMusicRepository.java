package com.example.ss5_t_music.repository;

import com.example.ss5_t_music.model.Music;

import java.util.List;


public interface IMusicRepository {
    List<Music> findAll();

    void add(Music music);
    Music findById(int id);
    void delete(int id);

    void update(Music musicUpdate);
}
