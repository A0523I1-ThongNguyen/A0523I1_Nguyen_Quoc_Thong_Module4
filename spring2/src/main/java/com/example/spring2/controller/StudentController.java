package com.example.spring2.controller;

import com.example.spring2.model.CodegymClass;
import com.example.spring2.model.Student;
import com.example.spring2.service.codegym_class.ICodegymClassService;
import com.example.spring2.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ICodegymClassService iCodegymClassService;

    @ModelAttribute("listClass")
    public List<CodegymClass> showListCodegymClass(){
        return iCodegymClassService.showList();
    }

//    @{/(page=${list.number -1}
    @GetMapping("/")
    public ModelAndView showList(@RequestParam(defaultValue = "0",required = false) int page,
                                 @RequestParam(defaultValue = "3",required = false) int pageSize,
                                 Model model){
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page,4,sort);
        Page<Student> pageStudent = iStudentService.findAll(pageable);
        int size = pageStudent.getTotalPages();
        List<Integer> listPage = new ArrayList<>();
        for (int i = 1; i <= size ; i++) {
            listPage.add(i);
        }
        model.addAttribute("pages",listPage);

        Page<Student> studentList = iStudentService.findAll(pageable);
        return new ModelAndView("/list", "list",iStudentService.findAll(pageable));
    }

    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/create","student",new Student());
    }

    @PostMapping("/add")
    public String addNewStudent(Student student){
        CodegymClass codegymClass = new CodegymClass();
        codegymClass.setName("Abc");
        student.setCodeGymClass(codegymClass);
        iStudentService.addNewStudent(student);
        return "redirect:/";
    }
}
