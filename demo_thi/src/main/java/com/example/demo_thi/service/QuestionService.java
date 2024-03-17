package com.example.demo_thi.service;

import com.example.demo_thi.model.QuestionContent;
import com.example.demo_thi.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService{
    @Autowired
    private IQuestionRepository iQuestionRepository;

    @Override
    public Page<QuestionContent> findAll(Pageable pageable) {
        return iQuestionRepository.findAll(pageable);
    }

    @Override
    public void save(QuestionContent questionContent) {
        iQuestionRepository.save(questionContent);
    }

    @Override
    public void delete(QuestionContent questionContent) {
        iQuestionRepository.delete(questionContent);
    }

    @Override
    public QuestionContent findById(Long id) {
        return iQuestionRepository.findById(id).orElse(null);
    }

    @Override
    public List<QuestionContent> findAll() {
        return iQuestionRepository.findAll();
    }
}