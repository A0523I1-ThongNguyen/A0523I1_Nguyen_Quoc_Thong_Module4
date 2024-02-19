package com.example.demo_validate.service.floor;

import com.example.demo_validate.model.Floor;
import com.example.demo_validate.model.Student;
import com.example.demo_validate.repository.floor.IFloorRepository;
import com.example.demo_validate.repository.student.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService implements IFloorService {
    @Autowired
    private IFloorRepository floorRepository;


    @Override
    public List<Floor> findAll() {
        return floorRepository.findAll();
    }

    @Override
    public Floor findById(int id) {
        return floorRepository.findById(id).orElse(null);
    }
}
