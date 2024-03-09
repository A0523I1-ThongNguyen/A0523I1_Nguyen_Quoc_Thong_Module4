package com.example.check_all_skill.controlller;

import com.example.check_all_skill.dto.EmployeeDTO;
import com.example.check_all_skill.model.Company;
import com.example.check_all_skill.model.Employee;
import com.example.check_all_skill.repository.IEmployeeRepository;
import com.example.check_all_skill.service.EmployeeService;
import com.example.check_all_skill.service.ICompanyService;
import com.example.check_all_skill.service.IEmployeeService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/all")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private ICompanyService companyService;

    @ModelAttribute("listCompany")
    public List<Company> showListCompany(){
        return companyService.findAll();
    }

    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("salary").descending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<Employee> pageEmployee = employeeService.findAll(pageable);

            List<Integer> listNumber = new ArrayList<>();
            for (int i = 0; i < pageEmployee.getTotalPages(); i++) {
                listNumber.add(i);
            }
        model.addAttribute("listNumber", listNumber);
        model.addAttribute("pageEmployee", pageEmployee);
        return "/list";
    }
    @GetMapping("/view-create")
    public String viewCreate(Model model){
        model.addAttribute("emDTO",new EmployeeDTO());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@Valid @ModelAttribute("emDTO") EmployeeDTO employeeDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        Company findCompany = companyService.findById(employeeDTO.getFkCompany());
        employee.setCompany(findCompany);

        employeeService.create(employee);
        return"redirect:/all";
    }

    @GetMapping("/update-view")
    public String viewUpdate(int idEm, Model model){
        Employee employee = employeeService.findById(idEm);

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFkCompany(employee.getCompany().getIdCompany());

        BeanUtils.copyProperties(employee,employeeDTO);

        model.addAttribute("employeeDTO", employeeDTO);
        return "/update";
    }

    @PostMapping("/updatePost")
    public String updatePost(@Valid @ModelAttribute ("employeeDTO") EmployeeDTO employeeDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/update";
        }
        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeDTO,employee);
        Company company = companyService.findById(employeeDTO.getFkCompany());
        employee.setCompany(company);

        employeeService.update(employee);
//        Employee employee2 = new Employee(); tạo một đối tượng Entity tương ứng thêm 1 record vào DB
//        employeeService.update(employee2);
        return "redirect:/all";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int idDel){
            employeeService.delete(idDel);
            return "redirect:/all";
    }

    @GetMapping("/chitiet")
    public String chiTiet(@RequestParam int id , Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "/chitiet";
    }

    @GetMapping("/getSearch")
    public String getSearch(@RequestParam(defaultValue = "0", required = false) int page,@RequestParam String searchNameEmployee, Model model){
        Pageable pageable = PageRequest.of(page,3);
        Page<Employee> pageEmployee = employeeService.searchByName(pageable,searchNameEmployee);
        model.addAttribute("pageEmployee",pageEmployee);
        return "/list";
    }

    @GetMapping("/getSearch2")
    public String getSearch2(@RequestParam String searchNameEmployee ,Model model){
        List<Employee> employeeList = employeeService.searchByName2(searchNameEmployee);
        model.addAttribute("employeeList",employeeList);
        return "/list2";
    }

    @GetMapping("/company/{id}")
    public String searchCompany(@PathVariable int id,Model model){
        List<Employee> employeeList = employeeService.searchByCompany(id);
        model.addAttribute("employeeList",employeeList);
        return "/list2";
    }
}
