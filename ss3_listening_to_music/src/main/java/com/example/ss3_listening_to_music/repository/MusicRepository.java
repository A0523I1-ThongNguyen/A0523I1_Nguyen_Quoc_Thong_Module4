package com.example.ss3_listening_to_music.repository;

import com.example.ss3_listening_to_music.model.Music;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository{
    private static List<Music> listMusic = new ArrayList<>();
    static {
        listMusic.add(new Music("Hua voi em nha","YLing",new String[]{"Tinh cam,","Nhe nhang"},"x.mp3"));
        listMusic.add(new Music("Beo dat may troi","Thai",new String[]{"Tru tinh"},"y.mp3"));
        listMusic.add(new Music("Zutter","GD&Top",new String[]{"Rap,","Cool"},"z.mp3"));
    }
    @Override
    public List<Music> getAll() {
        return listMusic;
    }

    @Override
    public void add(Music music) {
        listMusic.add(music);
    }
}
