package com.example.ss8_validate_music.service.type;

import com.example.ss8_validate_music.model.Type;

import java.util.List;

public interface ITypeService {
    List<Type> findAll();
    Type findById(int id);
}
