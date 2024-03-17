package com.example.demo_thi.repository;

import com.example.demo_thi.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType,Long> {
}