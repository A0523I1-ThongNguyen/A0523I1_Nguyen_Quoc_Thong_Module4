package com.example.validate_music_p.repository;



import com.example.validate_music_p.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface IMusicRepository extends JpaRepository<Music,Integer> {

}