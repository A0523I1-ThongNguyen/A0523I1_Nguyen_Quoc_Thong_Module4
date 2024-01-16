package com.example.p_blog.repository;



import com.example.p_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByTitleContaining(Pageable pageable,String searchTitle);
    @Query(value = "select * from Blog  where category_id = :categoryId", nativeQuery = true)
    Page<Blog> showListCategoryId(Pageable pageable,@Param("categoryId") int categoryId);
}