package com.example.test_validate.controller;

import com.example.test_validate.model.Brand;
import com.example.test_validate.model.Car;
import com.example.test_validate.model.CarDTO;
import com.example.test_validate.service.brand.IBrandService;
import com.example.test_validate.service.car.ICarService;
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
public class CarController {
    @Autowired
    private IBrandService brandService;
    @Autowired
    private ICarService carService;
    @ModelAttribute("listBrand")
    public List<Brand> listBrand(){
        List<Brand> listBrand = brandService.findAll();
        return listBrand;
    }
    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0",required = false) int page, Model model){
        Sort sort = Sort.by("price");
        Pageable pageable = PageRequest.of(page,2,sort);
        Page<Car> pageCar = carService.findAll(pageable);
        model.addAttribute("pageCar",pageCar);
        return "/list";
    }

    @GetMapping("/createBrand")
    public String showViewBrand(Model model){
        model.addAttribute("brand",new Brand());
        return "/create_brand";
    }
    @PostMapping("/createPostBrand")
    public String createPostBrand(@ModelAttribute Brand brand){
        brandService.save(brand);
        return "redirect:/";
    }

    @GetMapping("/createCar")
    public String createCar(Model model){
        model.addAttribute("carDTO",new CarDTO());
        return "/create_car";
    }
    @PostMapping("createPostCar")
    public String createPostCar(@Valid @ModelAttribute("carDTO") CarDTO carDTO , BindingResult bindingResult){
        new CarDTO().validate(carDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return "/create_car";
        }
        Car car = new Car();
        Brand brand = brandService.findById(carDTO.getKnIdBrand()); // lay ra 1 record . Một record (bản ghi) trong bảng sẽ tương ứng với một instance (thể hiện) của đối tượng đó.
        car.setKnIdBrand(brand); //sử dụng  car.setKnIdBrand(brand);, tương ứng với việc lấy ID của đối tượng Brand được truyền vào và gán cho cột kn_id_brand của bảng car trong cơ sở dữ liệu.
        BeanUtils.copyProperties(carDTO,car);
        carService.save(car);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        carService.delete(id);
        return "redirect:/";
    }
}
// Create Validate data
//Đúng, trong ví dụ bạn đưa ra, có hai lớp là Car và Brand và bạn đang thực hiện việc ánh xạ giữa chúng trong ORM.
//
//Dòng mã Brand brand = brandService.findById(carDTO.getKnIdBrand()); thực hiện việc lấy một bản ghi từ bảng Brand dựa trên id được truyền vào từ carDTO. Kết quả là một instance của lớp Brand, tương ứng với một record trong bảng Brand trong cơ sở dữ liệu.
//
//Dòng mã car.setKnIdBrand(brand); gán instance brand vào thuộc tính knIdBrand của đối tượng car. Điều này tương ứng với việc lấy id của đối tượng Brand được truyền vào và gán cho cột kn_id_brand của bảng car trong cơ sở dữ liệu. Điều này sẽ thiết lập quan hệ giữa đối tượng Car và Brand thông qua cột kn_id_brand trong bảng car, dựa trên id của bản ghi Brand.
//
//Tóm lại, thông qua việc gán instance brand cho thuộc tính knIdBrand của đối tượng car, bạn đang thực hiện việc ánh xạ id của Brand vào cột kn_id_brand trong bảng car của cơ sở dữ liệu.