package com.example.ss8_validate_music.model;

import jakarta.persistence.*;

@Entity
public class Music {
    @Id
    private int idMusic;
    private String nameSong;
    private String singer;
    private int view;
    private String file;
    @ManyToOne
    @JoinColumn(name = "id_type")

    private Type knType;

    public Music() {
    }

    public Music(int idMusic, String nameSong, String singer, String file, Type knType) {
        this.idMusic = idMusic;
        this.nameSong = nameSong;
        this.singer = singer;
        this.file = file;
        this.knType = knType;
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

    public Type getKnType() {
        return knType;
    }

    public void setKnType(Type knType) {
        this.knType = knType;
    }
}
