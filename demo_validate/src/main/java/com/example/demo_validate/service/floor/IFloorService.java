package com.example.demo_validate.service.floor;

import com.example.demo_validate.model.Floor;
import com.example.demo_validate.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFloorService {
    List<Floor> findAll();
    Floor findById(int id);
}
