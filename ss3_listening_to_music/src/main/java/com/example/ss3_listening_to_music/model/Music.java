package com.example.ss3_listening_to_music.model;

public class Music {
    private String nameSong;
    private String single;
    private String[] type;
    private String path;

    public Music(String nameSong, String single, String[] type, String path) {
        this.nameSong = nameSong;
        this.single = single;
        this.type = type;
        this.path = path;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Music() {
    }
}
