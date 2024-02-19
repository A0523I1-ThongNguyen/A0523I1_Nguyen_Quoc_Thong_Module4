package com.example.test_ss7_car_springdata.controller;

import com.example.test_ss7_car_springdata.model.Brand;
import com.example.test_ss7_car_springdata.model.Car;
import com.example.test_ss7_car_springdata.service.brand.IBrandService;
import com.example.test_ss7_car_springdata.service.car.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarService iCarService;
    @Autowired
    @Qualifier("brandService")
    private IBrandService iBrandService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("brand").descending();
        Pageable phanTrang = PageRequest.of(page,3,sort);
        Page<Car> carPage = iCarService.findAll2(phanTrang);
        model.addAttribute("carPage", carPage);
        List<Brand> brandList = iBrandService.findAll();
        model.addAttribute("brandList", brandList);
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
        model.addAttribute("car", new Car());
        model.addAttribute("listBrand",iBrandService.findAll());
        return "/create-car-view";
    }

    @PostMapping("/create-car-post")
    public String createCarPost(@ModelAttribute Car car) {
        iCarService.add(car);
        return "redirect:/car";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id){
        iCarService.delete(id);
        return "redirect:/car";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Long id,Model model){
           model.addAttribute("carDetail",iCarService.findById(id));
           return "/detail";
    }

    @GetMapping("/update")
    public String update(@RequestParam Long id , Model model){
        model.addAttribute("carUpdate",iCarService.findById(id));
        model.addAttribute("listBrand",iBrandService.findAll());
        return "/update";
    }
    @PostMapping("updatePost")
    public String updatePost(@ModelAttribute Car carUpdate){
        iCarService.update(carUpdate);
        return "redirect:/car";
    }
}
