package com.example.test.repository;

import com.example.test.model.Music;

import java.util.ArrayList;

public interface IMusicRepository {
    ArrayList<Music> findALL();
    void addMusic(Music music);
}