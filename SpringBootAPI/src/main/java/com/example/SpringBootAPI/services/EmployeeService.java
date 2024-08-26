package com.example.SpringBootAPI.services;

import com.example.SpringBootAPI.model.Employee;
import com.example.SpringBootAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Employee createEmployee(Employee emp) {
       return repository.save(emp);
    }

    public Employee getEmployeeById(long employee_id) {
       return repository.findById(employee_id).orElse(new Employee());
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public void updateEmployee(long id,Employee emp1) {

        Employee existingEmployee = repository.findById(id).orElseThrow();
        existingEmployee.setEmail(emp1.getEmail());
        existingEmployee.setEmployee_firstName(emp1.getEmployee_firstName());
        existingEmployee.setEmployee_lastName(emp1.getEmployee_lastName());
        existingEmployee.setSalary(emp1.getSalary());
        existingEmployee.setDepartment(emp1.getDepartment());
        // Update other fields as necessary
         repository.save(existingEmployee);


    }

    public void deleteEmployee(long id) {
        repository.deleteById(id);
    }
}
