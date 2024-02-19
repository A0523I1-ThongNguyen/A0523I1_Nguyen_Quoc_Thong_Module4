package com.example.ss7_next_level_blog.repository;

import com.example.ss7_next_level_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByTitleContaining(Pageable pageable,String nameSearch);
    Page<Blog> findByContentContaining(Pageable pageable , String nameContent);
    @Query(value = "select * from Blog  where category_id = :CategoryID", nativeQuery = true)
    Page<Blog> showListCategoryId(Pageable pageable,@Param("CategoryID") int categoryId);
    @Query(value = "select * from Blog  where category_id = :CategoryID", nativeQuery = true)
    List<Blog> listBlogQuery(Pageable pageable, @Param("CategoryID") int categoryId);

}
