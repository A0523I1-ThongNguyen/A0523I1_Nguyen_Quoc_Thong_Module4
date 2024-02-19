package com.example.ss7_check_blog.repository.blog;

import com.example.ss7_check_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
}
