package com.example.test.service;

import com.example.test.model.Music;
import com.example.test.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MusicService implements IMusicService{
    @Autowired
    IMusicRepository service;
    @Override
    public ArrayList<Music> findALL() {
        return service.findALL();
    }

    @Override
    public void addMusic(Music music) {
        service.addMusic(music);
    }
}