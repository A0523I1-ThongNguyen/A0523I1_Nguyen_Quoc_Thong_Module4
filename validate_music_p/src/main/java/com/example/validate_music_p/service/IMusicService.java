package com.example.validate_music_p.service;


import com.example.validate_music_p.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void add(Music music);
    Music findById(int id);
    void delete(int id);
}