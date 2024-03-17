package com.example.demo_thi.repository;

import com.example.demo_thi.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<QuestionContent,Long> {
//    Page<QuestionContent> findQuestionContentBy
}