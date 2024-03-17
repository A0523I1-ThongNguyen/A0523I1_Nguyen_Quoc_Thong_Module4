package com.example.demo_thi.service;

import com.example.demo_thi.model.QuestionType;

import java.util.List;

public interface IQuestionTypeService {
    List<QuestionType> listQuestionType();
    public QuestionType listQuestionType(Long id);
}