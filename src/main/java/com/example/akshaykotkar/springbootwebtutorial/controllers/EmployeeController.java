package com.example.akshaykotkar.springbootwebtutorial.controllers;

import com.example.akshaykotkar.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")// This is parent url which will be used for this controller
public class EmployeeController {
//    @GetMapping(path="/getSecretMessage")
//    public String getMySuperSecretMessage()
//    {
//        return  "Secret Message: abc@123";
//    }
    //@GetMapping("employees/{employeeId}")// OLd way before using @RequestMapping
    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeId(@PathVariable Long employeeId)
    {
        return new EmployeeDTO(employeeId,"Akshay","ak@gmail.com",21, LocalDate.of(2024,11,15), true);
    }
    /*
    Here in above func we need to use   @GetMapping(path = "/{employeeId}")
    employeeId this variable name inside a func name as para if we change it will give error
     public EmployeeDTO getEmployeeId(@PathVariable Long employeeId)
     Then How to resolve issue?
solution->
@GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeId(@PathVariable(name="employeeId") Long id)
    {
        return new EmployeeDTO(id,"Akshay","ak@gmail.com",21, LocalDate.of(2024,11,15), true);
    }
    Here in this case I'm assigning new Name of employeeId as id .
     */
//
//    @GetMapping(path = "/{employeeId}")
//    public EmployeeDTO getEmployeeId(@PathVariable(name="employeeId") Long id)
//    {
//        return new EmployeeDTO(id,"Akshay","ak@gmail.com",21, LocalDate.of(2024,11,15), true);
//    }
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
// Old way
    //@GetMapping(path="/employees") // (path="/employees") we can use it for parent so no need to declare it every time
    //Using @RequestMapping(path="/employees") need to use for it.
    //New Way
    @GetMapping
    public  String getAllEmployees(@RequestParam(required = false) Integer age,@RequestParam(required = false) String sortBy)
    {
        return  "Hi age "+age+" "+sortBy;
    }
    /*
     Same variable name Change
     How to resolve it?
Ans->
     @GetMapping
    public  String getAllEmployees(@RequestParam(required = false,name="inputAge") Integer age,@RequestParam(required = false) String sortBy)
    {
        return  "Hi age "+age+" "+sortBy;
    }
    Here in above code used an inputAge as new variable instead of age

    URL:
    http://localhost:8080/employees?inputAge=21&sortBy=name
    o/p:Hi age 21 name
     */

    /*
    http://localhost:8080/employees?age=21
    o/p= Hi age 21 null
    http://localhost:8080/employees?age=21&sortBy=name
    O/p=Hi age 21 name

     */
//    @PostMapping
//    public String createNewEmployee()
//    {
//        return  "Hello From Post";
//    }
    /*
      @PostMapping
    public String createNewEmployee()
    {
        return  "Hello From Post";
    }
    as for PostMapping and GetMapping Url is same then when we hit url
    as
    URL:localhost:8080/employees
    will get result of GetMapping because for Post We need FE or Postman to get Result
Choose Method as Post:
   URL in postman: http://localhost:8080/employees
O/p:
Hello From Post
     */

    @PutMapping
    public String updateEmployeeById(){
        return  "Hello From Put";
    }
    /*
    Choose Put
    hit url:http://localhost:8080/employees
    o/p:Hello From Put
     */
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee)
    {
        inputEmployee.setId(100L);
        return inputEmployee;
    }
    /*
    Here
       @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee)
    {
        inputEmployee.setId(100L);
        return inputEmployee;
    }
    in this code creating a Employee for all fields.
     Url:
     http://localhost:8080/employees
     when we hit this Url this will give an 400 status code as Bad request
{"timestamp":"2024-11-15T16:36:13.623+00:00","status":400,"error":"Bad Request","path":"/employees"}

Now go to Body->raw and Choose JSON

input :
{
    "name":"Akshay",
    "email":"Akshay@gmail.com",
    "age":21
}
o/p
{
"id":100,
"name":"Akshay",
"email":"Akshay@gmail.com",
"age":21,
"dateOfJoining":null,
"active":null
}
As Passed only 4 fields remaining two will be taken as null by default
     */
}
