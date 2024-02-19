package com.example.ss7_check_blog.repository.blog;

import com.example.ss7_check_blog.model.Blog;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public  class  blll implements JpaRepository<Blog, Integer> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Blog> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Blog> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Blog> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Blog getOne(Integer integer) {
        return null;
    }

    @Override
    public Blog getById(Integer integer) {
        return null;
    }

    @Override
    public Blog getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Blog> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Blog> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Blog> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Blog> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Blog> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Blog> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Blog, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Blog> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Blog> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Blog> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Blog> findAll() {
        return null;
    }

    @Override
    public List<Blog> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Blog entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Blog> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Blog> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return null;
    }
}
