package com.example.ss3_listening_to_music.service;

import com.example.ss3_listening_to_music.model.Music;
import com.example.ss3_listening_to_music.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
    @Autowired
    private IMusicRepository repository;


    @Override
    public List<Music> getAll() {
        return repository.getAll();
    }

    @Override
    public void add(Music music) {
        repository.add(music);
    }
}
