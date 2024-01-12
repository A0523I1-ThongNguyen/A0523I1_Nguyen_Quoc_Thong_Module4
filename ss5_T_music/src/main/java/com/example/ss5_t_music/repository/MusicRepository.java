package com.example.ss5_t_music.repository;

import com.example.ss5_t_music.model.Music;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class MusicRepository implements IMusicRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Music> findAll() {
        String sql = "select m from Music m";
        TypedQuery<Music> query = entityManager.createQuery(sql, Music.class);
        return query.getResultList();
    }

    @Override
    public void add(Music music) {
        entityManager.persist(music);
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Music music = findById(id);
        entityManager.remove(music);
    }

    @Override
    @Transactional
    public void update(Music musicUpdate) {
//        Music music = findById(id);
        BeanUtils.copyProperties(musicUpdate, musicUpdate);
        entityManager.merge(musicUpdate);
    }



}
