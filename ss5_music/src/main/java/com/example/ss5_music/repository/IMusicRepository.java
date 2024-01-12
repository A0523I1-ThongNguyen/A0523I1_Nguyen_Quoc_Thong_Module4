package com.example.ss5_music.repository;

import com.example.ss5_music.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();
    void add(Music music);
    Music findById(int id);
    void update(Music musicUpdate, int id);
    void delete(int id);
}