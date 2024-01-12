package com.example.ss3_listening_to_music.service;

import com.example.ss3_listening_to_music.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> getAll();
    void add(Music music);
}
