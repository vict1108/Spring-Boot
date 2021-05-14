package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepositary extends CrudRepository<Employee,Integer> {

    Employee findEmployeeById(Integer id);
}
