package com.example.demo6.service.floor;

import com.example.demo6.model.Floor;

import java.util.List;

public interface IFloorService {
    List<Floor> findAll();
    Floor findById(int id);
}
