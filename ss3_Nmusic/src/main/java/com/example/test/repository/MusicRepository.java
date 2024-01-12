package com.example.test.repository;

import com.example.test.model.Music;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class MusicRepository implements IMusicRepository {
    private static ArrayList<Music> musicList = new ArrayList<Music>();
    static{
        musicList.add(new Music(1,"Missing You","G-Dragon","K-Pop","tn.mp3"));
        musicList.add(new Music(1,"Just Us 2","Sehun-Chanyel","K-Pop","tp.mp3"));
    }
    public ArrayList<Music> findALL(){
        return musicList;
    }
    public void addMusic(Music music){
        musicList.add(music);
    }
}
