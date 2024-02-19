package com.example.springboot2.controller;

import com.example.springboot2.model.City;
import com.example.springboot2.model.CityDTO;
import com.example.springboot2.model.Nation;
import com.example.springboot2.service.city.ICityService;
import com.example.springboot2.service.nation.INationSercive;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarRestController {
    @Autowired
    private ICityService service;
    @Autowired
    private INationSercive nationSercive;

    @GetMapping("bt")
    public ModelAndView showView2() {
        return new ModelAndView("/list", "list", service.findAll());
    }


    @GetMapping("/list")
    public ResponseEntity<List<City>> showView() {
        List<City> listCity = service.findAll();
        return new ResponseEntity<>(listCity, HttpStatus.OK);
    }

    @PostMapping("/createPost")
    public ResponseEntity<?> createPost(@Valid @RequestBody CityDTO cityDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        City city = new City();
        Nation nation = nationSercive.findById(cityDto.getNation());
        city.setNation(nation);
        BeanUtils.copyProperties(cityDto, city);
        service.add(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
