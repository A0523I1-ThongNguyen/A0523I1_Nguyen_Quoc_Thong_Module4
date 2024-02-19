package com.example.ss8_test_music.model;

import com.example.ss8_test_music.dto.MusicDTO;
import jakarta.persistence.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Entity
public class Music  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMusic;
    private String nameSong;
    private String singer;
    private int view;
    private String file;

    private String type;

    public Music() {
    }

    public Music(int idMusic, String nameSong, String singer, int view, String file, String type) {
        this.idMusic = idMusic;
        this.nameSong = nameSong;
        this.singer = singer;
        this.view = view;
        this.file = file;
        type = type;
    }

    public int getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(int idMusic) {
        this.idMusic = idMusic;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }


}
