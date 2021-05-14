package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;


@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepositary employeeRepositary;


    @PostMapping("/add")
    public String addEmployee(@RequestParam("firstName")String firstName,
                              @RequestParam("lastName") String lastName,@RequestParam("age") Integer age){

        Employee employee = new Employee();
        employee.setAge(age);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        if (age != null){
            employeeRepositary.save(employee);
            return "Added new Employee";
        }else{
            return "age param should be in integer";
        }
    }


    @GetMapping("/listOfEmployee")
    public Iterable<Employee> getEmployee(){
        return employeeRepositary.findAll();
    }

    @GetMapping("/find/{id}")
    public Employee findEmployeeById(@PathVariable Integer id){
        return employeeRepositary.findEmployeeById(id);
    }
}
