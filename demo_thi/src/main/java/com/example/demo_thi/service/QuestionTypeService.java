package com.example.demo_thi.service;

import com.example.demo_thi.model.QuestionType;
import com.example.demo_thi.repository.IQuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService{
    @Autowired
    private IQuestionTypeRepository iQuestionTypeRepository;

    @Override
    public List<QuestionType> listQuestionType() {
        return iQuestionTypeRepository.findAll();
    }
    public QuestionType listQuestionType(Long id){
        return iQuestionTypeRepository.findById(id).orElse(null);
    }
}