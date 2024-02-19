package com.example.demo_validate3.controller;

import com.example.demo_validate3.model.Department;
import com.example.demo_validate3.model.Employee;
import com.example.demo_validate3.model.EmployeeDTO;
import com.example.demo_validate3.service.department.IDepartmentService;
import com.example.demo_validate3.service.employee.IEmployeeService;
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
@RequestMapping("/em")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("age").descending();
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Employee> employeePage = employeeService.findAll(pageable);
        model.addAttribute("employeePage", employeePage);
        return "/list";
    }
    @GetMapping("create")
    public String showViewCreate(Model model) {
        model.addAttribute("EmployeeDTO", new EmployeeDTO());
        return "/create";
    }

    //    @GetMapping("create")
//    public String showLiatDepartment(Model model){
//        List<Department> departmentList = departmentService.findAll();
//        model.addAttribute("departmentList",departmentList);
//        return "/create";
//    }
    @ModelAttribute("listDepartment2")
    public List<Department> show() {
        return departmentService.findAll();
    }

    @PostMapping("/createPost")
    public String createPost(@Valid @ModelAttribute("EmployeeDTO") EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Employee employee = new Employee();
        Department department = departmentService.findById(employeeDTO.getDepartment());
        employee.setKnDepartment(department);
        BeanUtils.copyProperties(employeeDTO, employee);
        employeeService.save(employee);
        return "redirect:/em";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id){

    }
}
