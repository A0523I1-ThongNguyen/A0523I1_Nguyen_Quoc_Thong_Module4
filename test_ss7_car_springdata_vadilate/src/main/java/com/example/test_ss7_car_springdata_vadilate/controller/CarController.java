package com.example.test_ss7_car_springdata_vadilate.controller;

import com.example.test_ss7_car_springdata_vadilate.model.Brand;
import com.example.test_ss7_car_springdata_vadilate.model.Car;
import com.example.test_ss7_car_springdata_vadilate.model.CarDTO;
import com.example.test_ss7_car_springdata_vadilate.service.brand.IBrandService;
import com.example.test_ss7_car_springdata_vadilate.service.car.ICarService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarService iCarService;
    @Autowired
    @Qualifier("brandService")
    private IBrandService iBrandService;


    @ModelAttribute("listBrand")
    public List<Brand> showListBrand() {
        return iBrandService.findAll();
    }

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("brand").descending();
        Pageable phanTrang = PageRequest.of(page, 3, sort);
        Page<Car> carPage = iCarService.findAll2(phanTrang);
        //
        List<Integer> listNumber = new ArrayList<>();
        for (int i = 0; i < carPage.getTotalPages(); i++) {
            listNumber.add(i);
        }
        model.addAttribute("listNumber", listNumber);
        model.addAttribute("carPage", carPage);
//        List<Brand> brandList = iBrandService.findAll();
//        model.addAttribute("brandList", brandList);
        return "/list";
    }

    @GetMapping("/create-brand-view")
    public String createBrandView(Model model) {
        model.addAttribute("brand", new Brand());
        return "/create-brand-view";
    }

    @PostMapping("/create-brand-post")
    public String createBrandPost(@ModelAttribute Brand brand) {
        iBrandService.add(brand);
        return "redirect:/car";
    }

    @GetMapping("/create-car-view")
    public String createCarView(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        model.addAttribute("listBrand", iBrandService.findAll());
        return "/create-car-view";
    }

    @PostMapping("/create-car-post")
    public String createCarPost(@Valid @ModelAttribute("carDTO") CarDTO carDTO, BindingResult bindingResult) {
        new CarDTO().validate(carDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create-car-view";
        }
        Car car = new Car();
        Brand brand = iBrandService.findById(carDTO.getKnBrand());
        car.setBrand(brand);
        BeanUtils.copyProperties(carDTO, car);
        iCarService.add(car);
        return "redirect:/car";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long idCar) {
        iCarService.delete(idCar);
        return "redirect:/car";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Long id, Model model) {
        model.addAttribute("carDetail", iCarService.findById(id));
        return "/detail";
    }

    @GetMapping("/update")
    public String update(@RequestParam Long id, Model model) {
        CarDTO carDTO = new CarDTO();
        Car car = iCarService.findById(id);
        carDTO.setKnBrand(car.getBrand().getIdBrand());
        BeanUtils.copyProperties(car,carDTO);
        model.addAttribute("carDTO", carDTO);
        return "/update";
    }

    @PostMapping("updatePost")
    public String updatePost(@ModelAttribute("carDTO") CarDTO carDTO, BindingResult bindingResult) {
        new CarDTO().validate(carDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/update";
        }
        Car car = new Car();
        Brand brand = iBrandService.findById(carDTO.getKnBrand());
        car.setBrand(brand);
        BeanUtils.copyProperties(carDTO, car);
        iCarService.update(car);
        return "redirect:/car";
    }

    @GetMapping("getSearch")
    public String getSearch(@RequestParam String searchName,Model model){
        List<Car> carList = iCarService.listSearchcar(searchName);
        model.addAttribute("carPage",carList);
        return "/list";
    }

//    @GetMapping("getSearch")
//    public String getSearch2(@RequestParam(defaultValue = "0", required = false) int page, String searchName,Model model){
//        Pageable pageable = PageRequest.of(page, 2);
//        Page<Car> carPage = iCarService.listSearchcar2(pageable,searchName);
//        model.addAttribute("carPage",carPage);
//        return "/list";
//    }
}
