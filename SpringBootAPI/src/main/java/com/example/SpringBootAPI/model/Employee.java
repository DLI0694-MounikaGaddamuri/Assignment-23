package com.example.SpringBootAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long employee_id;
    private String employee_firstName;
    private String employee_lastName;

    @Valid
    @Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;
    private String department;
    private double salary;

}
