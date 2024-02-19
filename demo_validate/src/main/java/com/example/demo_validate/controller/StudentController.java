package com.example.demo_validate.controller;

import com.example.demo_validate.model.Floor;
import com.example.demo_validate.model.Student;
import com.example.demo_validate.model.StudentDTO;
import com.example.demo_validate.service.floor.IFloorService;
import com.example.demo_validate.service.student.IStudentService;
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
@RequestMapping("/st")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    IFloorService floorService;
    @ModelAttribute("listFloor")
    public List<Floor> showListFloor(){
        return floorService.findAll();
    }

    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0",required = false) int page, Model model){
        Sort sort = Sort.by("nameStudent").descending();
        Pageable pageable = PageRequest.of(page,1,sort);
        Page<Student> pageStudent = studentService.findAll(pageable);
        model.addAttribute("pageStudent",pageStudent);
        return "/list";
    }

    @GetMapping("/create")
    public String showViewCreate(Model model){
        model.addAttribute("studentDTO",new StudentDTO());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@Valid @ModelAttribute("studentDTO")  StudentDTO studentDTO , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/create";
        }
        Student student = new Student();
        Floor floor = floorService.findById(studentDTO.getKnFloor());
        BeanUtils.copyProperties(studentDTO,student);
        student.setKnFloor(floor);
        studentService.save(student);
        return "redirect:/st";
    }

}
