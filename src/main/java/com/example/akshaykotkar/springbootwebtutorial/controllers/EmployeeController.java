package com.example.akshaykotkar.springbootwebtutorial.controllers;

import com.example.akshaykotkar.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

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

   url: http://localhost:8080/employees/1
{
  "id": 1,
  "name": "Akshay",
  "email": "ak@gmail.com",
  "age": 21,
  "dateOfJoining": "2024-11-15",
  "active": true
}
     */

    @GetMapping(path="/employees") // (path="/employees") we can use it for parent so no need to declare it every time
    //Using @RequestMapping(path="/employees") need to use for it.
    public  String getAllEmployees(@RequestParam(required = false) Integer age,@RequestParam(required = false) String sortBy)
    {
        return  "Hi age "+age+" "+sortBy;
    }
    /*
    http://localhost:8080/employees?age=21
    o/p= Hi age 21 null
    http://localhost:8080/employees?age=21&sortBy=name
    O/p=Hi age 21 name

     */
}
