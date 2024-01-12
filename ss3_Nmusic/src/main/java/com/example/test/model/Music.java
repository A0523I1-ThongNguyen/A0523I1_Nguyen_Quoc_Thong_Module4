package com.example.test.model;

public class Music {
    private int id;
    private String name;
    private String singer;
    private String category;
    private String path;

    public Music(int id, String name, String singer, String category, String path) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
