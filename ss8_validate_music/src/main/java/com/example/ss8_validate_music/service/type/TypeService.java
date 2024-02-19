package com.example.ss8_validate_music.service.type;

import com.example.ss8_validate_music.model.Type;
import com.example.ss8_validate_music.repository.type.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService{
    @Autowired
    private ITypeRepository typeRepository;
    @Override
    public List<Type> findAll()  {
        return typeRepository.findAll();
    }

    @Override
    public Type findById(int id) {
        return typeRepository.findById(id).orElse(null);
    }
}
