package com.example.check_all_skill_2.controller;

import com.example.check_all_skill_2.dto.StudentDTO;
import com.example.check_all_skill_2.model.School;
import com.example.check_all_skill_2.model.Student;
import com.example.check_all_skill_2.service.School.ISchoolService;
import com.example.check_all_skill_2.service.Student.IStudentService;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ISchoolService schoolService;

    @ModelAttribute("listSchool")
    public List<School> showListCompany() {
        return schoolService.findAll();
    }

    @GetMapping("")
    public String showViewList(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("status").ascending();
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Student> studentList = studentService.findAll(pageable);
        model.addAttribute("studentList", studentList);
        return "/list";
    }

    @GetMapping("/view-create-student")
    public String viewCreate(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute("studentDTO") StudentDTO studentDTO, Model model) {
        Student studentX = new Student();
        BeanUtils.copyProperties(studentDTO, studentX);
        School school = schoolService.findById(studentDTO.getFkSchool());
        studentX.setSchool(school);

        studentService.add(studentX);
        return "redirect:/student";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int idStudent){
        studentService.delete(idStudent);
        return "redirect:/student";
    }
    @GetMapping("/view-create-school")
    public String addSchool(Model model){
        model.addAttribute("newSchool", new School());
        return "/createSchool";
    }

    @PostMapping("/createPostSchool")
    public String createPostSchool(@ModelAttribute ("newSchool") School newSchool){
        schoolService.addSchool(newSchool);
        return "redirect:/student";
    }
}
