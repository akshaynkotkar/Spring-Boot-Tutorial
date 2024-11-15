package com.example.akshaykotkar.springbootwebtutorial.controllers;

import com.example.akshaykotkar.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Struct;
import java.time.LocalDate;

@RestController
public class EmployeeController {
//    @GetMapping(path="/getSecretMessage")
//    public String getMySuperSecretMessage()
//    {
//        return  "Secret Message: abc@123";
//    }
    @GetMapping("employees/{employeeId}")
    public EmployeeDTO getEmployeeId(@PathVariable Long employeeId)
    {
        return new EmployeeDTO(employeeId,"Akshay","ak@gmail.com",21, LocalDate.of(2024,11,15), true);
    }
    /*
    {
   url: http://localhost:8080/employees/1
  "id": 1,
  "name": "Akshay",
  "email": "ak@gmail.com",
  "age": 21,
  "dateOfJoining": "2024-11-15",
  "active": true
}
     */
}
