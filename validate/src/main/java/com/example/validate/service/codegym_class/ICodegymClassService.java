package com.example.validate.service.codegym_class;

import com.example.validate.model.CodegymClass;

import java.util.List;

public interface ICodegymClassService {
    List<CodegymClass> showList();
    CodegymClass findById(Long id);
}
