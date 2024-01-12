package com.example.test.service;

import com.example.test.model.Music;

import java.util.ArrayList;

public interface IMusicService {
    ArrayList<Music> findALL();
    void addMusic(Music music);
}