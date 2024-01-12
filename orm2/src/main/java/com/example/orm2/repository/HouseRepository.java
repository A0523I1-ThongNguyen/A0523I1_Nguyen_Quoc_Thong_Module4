package com.example.orm2.repository;

import com.example.orm2.model.House;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class HouseRepository implements IHouseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<House> findAll() {
        String sql = "select h from House h";
        TypedQuery<House> query = entityManager.createQuery(sql,House.class);
        return query.getResultList();
    }


    @Override
    @Transactional
    public void add(House house) {
        entityManager.persist(house);
    }


}
