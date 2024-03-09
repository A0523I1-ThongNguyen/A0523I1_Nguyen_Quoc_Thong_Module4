package com.example.test_ss9_validate_oap_exception.controller;

import com.example.test_ss9_validate_oap_exception.dto.CarDTO;

import com.example.test_ss9_validate_oap_exception.exception.ErrorDoXang;
import com.example.test_ss9_validate_oap_exception.exception.GlobalExceptionHandler;
import com.example.test_ss9_validate_oap_exception.model.Brand;
import com.example.test_ss9_validate_oap_exception.model.Car;
import com.example.test_ss9_validate_oap_exception.model.Fuel;
import com.example.test_ss9_validate_oap_exception.service.brand.IBrandService;
import com.example.test_ss9_validate_oap_exception.service.car.ICarService;
import com.example.test_ss9_validate_oap_exception.service.fuel.IFuelService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarService iCarService;
    @Autowired
    private IBrandService iBrandService;
    @Autowired
    private IFuelService iFuelService;

    @ModelAttribute("listBrand")
    public List<Brand> showListBrand() {
        return iBrandService.findAll();
    }

    @ModelAttribute("listFuel")
    public List<Fuel> showListFuel() {
        return iFuelService.findAll();
    }

    @GetMapping("")
    public String showPageCar(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("price").descending();
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Car> pageCar = iCarService.findAll(pageable);
        model.addAttribute("pageCar", pageCar);
        return "/list";
    }

    @GetMapping("/view-create")
    public String showViewCreate(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "/create";
    }

    @PostMapping("/create-post")
    public String createPost(@Valid @ModelAttribute("carDTO") CarDTO carDTO, BindingResult bindingResult) {
        new CarDTO().validate(carDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Car carX = new Car();
        BeanUtils.copyProperties(carDTO, carX);
        Brand brand = iBrandService.findById(carDTO.getFkBrandCar());
        Fuel fuel = iFuelService.findById(carDTO.getFkFuelCar());
        carX.setBrandCar(brand);
        carX.setFuelCar(fuel);

        iCarService.update(carX);
        return "redirect:/car";
    }

//    @ExceptionHandler(cz.class)
//    public String number0() {
//        return "/loi1";
//    }
//    @ExceptionHandler(NullPointerException.class)
//    public String number2() {
//        return "/loi2";
//    }
    @GetMapping("/doxang")
    public String doXang(@RequestParam int id,int idGasoline, Model model) throws GlobalExceptionHandler   {
        Car carX = iCarService.findById(id); // đối tượng đã có trong csdl , k thể đối khóa chính id (setIdCar) đã có sẵn dc
        Fuel fuelX = iFuelService.findById(idGasoline) ;
        if (carX.getGasoline() <= 90) {
            carX.setMaGuixe(iCarService.randomIdCar()); // Không thể setIdCar khóa chính đã tồn tại, vì PM là duy nhất
            carX.setGasoline(carX.getGasoline() + 10);
            iCarService.update(carX); // Không thể update khóa chính của đối tượng có sẵn trong CSDL
            fuelX.setQuantityFuel(fuelX.getQuantityFuel()-10);
            iFuelService.update(fuelX);
            return "redirect:/car";
        } else {
            throw  new GlobalExceptionHandler();
//         throw new GlobalExceptionHandler();
             // Gây ra lỗi NullPointerException
//            return "redirect:/car";
        }
    }

    @GetMapping("/guixe")
    public String doXang(@RequestParam int idGuixe){
        Car carGuixe = new Car();
        carGuixe.setMaGuixe(iCarService.randomIdCar());
        carGuixe.setNameCar(iCarService.getRandomCode());

        return "redirect:/car";


        //        this.idCar = idCar;
        //        this.maGuixe = maGuixe;
        //        NameCar = nameCar;
        //        this.price = price;
        //        this.gasoline = gasoline;
        //        this.image = image;
        //        this.brandCar = brandCar;
        //        this.fuelCar = fuelCar;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int idCar){
        iCarService.delete(idCar);
        return "redirect:/car";
    }

    @GetMapping("/view-update")
    public String viewUpdate(Model model){
        model.addAttribute("carDTO",new CarDTO());
        return "/view-update";
    }



}

