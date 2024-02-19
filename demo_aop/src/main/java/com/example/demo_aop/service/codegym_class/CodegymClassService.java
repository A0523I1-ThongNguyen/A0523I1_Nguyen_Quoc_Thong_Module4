package com.example.demo_aop.service.codegym_class;

import com.example.demo_aop.model.CodegymClass;
import com.example.demo_aop.repository.codegym_class.ICodegymClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CodegymClassService implements ICodegymClassService{
    @Autowired
    private ICodegymClassRepository iCodegymClassRepository;
    @Override
    public List<CodegymClass> showList() {
        return iCodegymClassRepository.findAll();
    }

    @Override
    public CodegymClass findById(Long id) {
        return iCodegymClassRepository.findById(id).orElse(null);
    }
}
