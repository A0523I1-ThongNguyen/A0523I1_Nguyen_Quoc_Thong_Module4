package com.example.demo_aop.service.codegym_class;

import com.example.demo_aop.model.CodegymClass;

import java.util.List;

public interface ICodegymClassService {
    List<CodegymClass> showList();
    CodegymClass findById(Long id);
}
