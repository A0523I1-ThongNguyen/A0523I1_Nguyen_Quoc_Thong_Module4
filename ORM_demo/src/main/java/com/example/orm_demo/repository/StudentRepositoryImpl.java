package com.example.orm_demo.repository;

import com.example.orm_demo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * (C) Copyright 2023 iHub Academy. All Rights Reserved.
 *
 * @author TrungDC
 * @version 1.0
 * @since 12/27/2023
 */
@Repository
public class StudentRepositoryImpl implements IStudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, " Nguyen Van A", true, new String[]{"Java", "C#"}));
        studentList.add(new Student(2, " Nguyen Van B", false, new String[]{"C#"}));
        studentList.add(new Student(3, " Nguyen Van C", true, new String[]{"Java"}));
    }

    @Override
    public List<Student> findAll() {
//        JPQL - java persistence query language
        String sql = "select s from Student s";
        TypedQuery<Student> query = entityManager.createQuery(sql,Student.class);
//        Truyền tham số
//        query.setParameter("name", "%vu%");
        return query.getResultList();
    }

    @Override
    @Transactional //persit , merge, remove
    public void save(Student student) {
        entityManager.persist(student);
//        studentList.add(student);
    }

    @Override
    public List<Student> findByName(String keyword) {
        return null;
    }
}