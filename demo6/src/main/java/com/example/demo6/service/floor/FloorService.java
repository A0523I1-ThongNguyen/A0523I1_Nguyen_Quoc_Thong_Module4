package com.example.demo6.service.floor;

import com.example.demo6.model.Floor;
import com.example.demo6.repository.floor.IFloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
