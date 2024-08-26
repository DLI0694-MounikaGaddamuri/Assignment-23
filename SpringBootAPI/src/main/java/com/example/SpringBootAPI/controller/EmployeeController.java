package com.example.SpringBootAPI.controller;

import com.example.SpringBootAPI.model.Employee;
import com.example.SpringBootAPI.services.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Transactional
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee emp){
        return service.createEmployee(emp);

    }

    @GetMapping("/employees/{employee_id}")
    public Employee getEmployeeById(@PathVariable long employee_id){
        return  service.getEmployeeById(employee_id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id,@RequestBody Employee emp1){
        service.updateEmployee(id,emp1);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable long id){
        service.deleteEmployee(id);
    }

}
