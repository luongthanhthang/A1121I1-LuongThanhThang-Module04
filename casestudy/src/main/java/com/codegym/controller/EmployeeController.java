package com.codegym.controller;

import com.codegym.entity.*;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;


    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 4) Pageable pageable,
                          @RequestParam("nameSearch") Optional<String> nameSearch,
                          @RequestParam("emailSearch") Optional<String> emailSearch,
                          @RequestParam("divisionSearch") Optional<String> divisionSearch
    ) {
        Page<Employee> employeeList;
        String condition = "";

        if (nameSearch.isPresent() || emailSearch.isPresent() || divisionSearch.isPresent()) {
            employeeList = employeeService.search(nameSearch.get(), emailSearch.get(), divisionSearch.get(), pageable);
            model.addAttribute("employeeList", employeeList);
        }

        if (nameSearch.isPresent()) {
            condition += "&nameSearch=" + nameSearch.get();
            model.addAttribute("nameSearch", nameSearch.get());
        }
        if (emailSearch.isPresent()) {
            condition += "&emailSearch=" + emailSearch.get();
            model.addAttribute("emailSearch", emailSearch.get());
        }
        if (divisionSearch.isPresent()) {
            condition += "&divisionSearch=" + divisionSearch.get();
            model.addAttribute("divisionSearch", divisionSearch.get());
        } else {
            employeeList = employeeService.findAll(pageable);
            model.addAttribute("employeeList", employeeList);
        }

        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        model.addAttribute("positionList", positionList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("condition", condition);
        return "employee/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/employee/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        Employee employee = new Employee();
        employee.setPositionId(new Position());
        employee.setEducationDegreeId(new EducationDegree());
        employee.setDivisionId(new Division());
        Account username = new Account();

        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        model.addAttribute("positionList", positionList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("employee", employee);
        model.addAttribute("username", username);
        return "employee/create";
    }

    @PostMapping("/create")
    public String create(
            @Valid
            @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            employee.setPositionId(new Position());
            employee.setEducationDegreeId(new EducationDegree());
            employee.setDivisionId(new Division());
            employee.setUsername(new Account());

            List<Position> positionList = positionService.findAll();
            List<Division> divisionList = divisionService.findAll();
            List<EducationDegree> educationDegreeList = educationDegreeService.findAll();

            model.addAttribute("positionList", positionList);
            model.addAttribute("divisionList", divisionList);
            model.addAttribute("educationDegreeList", educationDegreeList);
            model.addAttribute("employee", employee);
            return "employee/create";
        }

        employee.setUsername(new Account(employee.getEmail(), "$2a$10$Iypxa0LTSedLPKNLINrMBex.Y.UyCxZfb/izg7TsS1BlO7bQlHrLy"));
        employeeService.insert(employee);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/employee/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(Model model, @PathVariable("id") Integer id) {
        Employee employee = employeeService.selectEmployee(id);
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        model.addAttribute("positionList", positionList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.update(employee);
        redirectAttributes.addFlashAttribute("mess", "Edit thành công");
        return "redirect:/employee/list";
    }
}
