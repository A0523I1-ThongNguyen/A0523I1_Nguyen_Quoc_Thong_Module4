package com.example.ss3_listening_to_music.repository;

import com.example.ss3_listening_to_music.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> getAll();
    void add(Music music);
}
