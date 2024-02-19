package com.example.springboot2.controller;

import com.example.springboot2.model.City;
import com.example.springboot2.model.CityDTO;
import com.example.springboot2.model.Nation;
import com.example.springboot2.service.city.ICityService;
import com.example.springboot2.service.nation.INationSercive;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ct")
public class CityController {
    @Autowired
    private ICityService service;
    @Autowired
    private INationSercive nationSercive;

    @GetMapping("")
    public ModelAndView showView() {
        return new ModelAndView("/list", "list", service.findAll());
    }

    @GetMapping("viewCreate")
    public String showViewCreate(Model model) {
        model.addAttribute("cityDTO", new CityDTO());
        return "/create";
    }

    @PostMapping("createPost")
    public String createPost(@Valid @ModelAttribute("cityDTO") CityDTO cityDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        City city = new City();
        Nation nation = nationSercive.findById(cityDto.getNation());
//Khi bạn gọi phương thức city.setNation(nation), Hibernate sẽ tự động lấy giá trị ID của đối tượng Nation và gán cho cột
// nation_id trong bảng City. Điều này xảy ra vì bạn đã sử dụng annotation @JoinColumn và chỉ định tên cột là nation_id.
//        Nation nation1 = new Nation(3,"KAKA");
        city.setNation(nation);
        BeanUtils.copyProperties(cityDto,city);
        service.add(city);
        return "redirect:/ct";
    }


    @ModelAttribute("listNation")
    public String listNation(Model model) {
        List<Nation> listNation = nationSercive.findAll();
        model.addAttribute("listNation", listNation);
        return "/create";
    }



    @GetMapping("delete")
    public String delete(@RequestParam int id){
        service.deleteById(id);
        return "redirect:/ct";
    }

}
