package com.example.ss8_test_music.service.music;

import com.example.ss8_test_music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    Page<Music> findAll(Pageable pageable);
    void save(Music music);
    void delete(int id);
    Music findById(int id);
//    Page<Music> findByNameSongContaining(Pageable pageable,String name);
    Page<Music> searchSingerAndSong(Pageable pageable, String singer,String nameSong);
    Page<Music> searchForeignKeyOfMusic(Pageable pageable, int idType);
}
