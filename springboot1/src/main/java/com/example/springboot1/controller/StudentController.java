package com.example.springboot1.controller;

import com.example.springboot1.model.CodegymClass;
import com.example.springboot1.model.Student;
import com.example.springboot1.service.codegym_class.ICodegymClassService;
import com.example.springboot1.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/st")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ICodegymClassService iCodegymClassService;

    @ModelAttribute("listClass")
    public List<CodegymClass> showListCodegymClass() {
        return iCodegymClassService.showList();
    }

    @GetMapping("")
    public ModelAndView showList() {
        return new ModelAndView("/list", "list", iStudentService.showList());
    }

    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/create", "student", new Student());
    }

    @PostMapping("/add")
    public String addNewStudent(Student student) {
        CodegymClass codegymClass = new CodegymClass();
        codegymClass.setName("Abc");
        student.setCodeGymClass(codegymClass);
        iStudentService.addNewStudent(student);
        return "redirect:/st";
    }



    @GetMapping("deleteAll")
    public String delAll() {
        iStudentService.delAll();
        return "redirect:/st";
    }

    @GetMapping("deleteObj/{id}")
    public String deleteObj(@PathVariable Long id) {
        iStudentService.deleteById(id);
        return "redirect:/st";
    }

    @GetMapping("chitiet")
    public String chiTiet(@RequestParam Long id,Model model) {
        Student student = iStudentService.findById(id);
        model.addAttribute("student",student);
        return "/chitiet";
    }
}
