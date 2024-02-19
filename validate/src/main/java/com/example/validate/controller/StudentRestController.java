package com.example.validate.controller;

import com.example.validate.model.CodegymClass;
import com.example.validate.model.Student;
import com.example.validate.model.StudentDTO;
import com.example.validate.repository.student.IStudentRepository;
import com.example.validate.service.codegym_class.ICodegymClassService;
import com.example.validate.service.student.IStudentService;
import com.example.validate.utils.NotFoundClassException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ICodegymClassService iCodegymClassService;

    @Autowired
    private IStudentRepository iStudentRepository;

    @GetMapping("/page")
    public ResponseEntity<Page<Student>> showPage(@RequestParam(defaultValue = "0", required = false) int page,
                                                  @RequestParam(defaultValue = "3", required = false) int pageSize,
                                                  Model model) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<Student> pageStudent = iStudentService.findAll(pageable);
        int size = pageStudent.getTotalPages();
        List<Integer> listPage = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            listPage.add(i);
        }
        model.addAttribute("pages", listPage);
        return new ResponseEntity<>(pageStudent, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> showList() {
        List<Student> list = iStudentRepository.getStudentList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewStudent(@Valid @RequestBody StudentDTO student,
                                           BindingResult bindingResult) throws NotFoundClassException {
        // Sử dụng để kiểm tra lỗi đối với custom validate
        // anonymous object
        // Garbage Collection -> công cụ dọn rác
        new StudentDTO().validate(student, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Student s = new Student();
        CodegymClass codegymClass = iCodegymClassService.findById(student.getCodeGymClass());
        // Cố tình tạo exception
        if (codegymClass == null) {
            throw new NotFoundClassException();
        }
        // Chuyển đổi dữ liệu từ DTO -> Entity
        BeanUtils.copyProperties(student, s);
        s.setCodeGymClass(codegymClass);
        iStudentService.addNewStudent(s);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}