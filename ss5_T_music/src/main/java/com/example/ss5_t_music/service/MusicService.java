package com.example.ss5_t_music.service;

import com.example.ss5_t_music.model.Music;
import com.example.ss5_t_music.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
    @Autowired
    IMusicRepository iMusicRepository;
    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void add(Music music) {
        iMusicRepository.add(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        iMusicRepository.delete(id);
    }

    @Override
    public void update(Music musicUpdate) {
            iMusicRepository.update(musicUpdate);
    }
}
