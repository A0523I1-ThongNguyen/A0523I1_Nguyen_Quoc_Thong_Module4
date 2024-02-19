package com.example.ss8_validate_music.service.music;

import com.example.ss8_validate_music.model.Music;
import com.example.ss8_validate_music.repository.music.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return musicRepository.findAll(pageable);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void delete(int id) {
        musicRepository.deleteById(id);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id).orElse(null);
    }

//    @Override
//    public Page<Music> findByNameSongContaining(Pageable pageable, String name) {
//        return musicRepository.findByNameSongContaining(pageable,name);
//    }

    @Override
    public Page<Music> searchSingerAndSong(Pageable pageable, String singer,String nameSong) {
        return musicRepository.searchSingerAndSong(pageable,singer, nameSong);
    }

    @Override
    public Page<Music> searchForeignKeyOfMusic(Pageable pageable, int idType) {
        return musicRepository.searchForeignKeyOfMusic(pageable,idType);
    }

    @Override
    public Page<Music> listType2(Pageable pageable) {
        return musicRepository.listType2(pageable);
    }
}
