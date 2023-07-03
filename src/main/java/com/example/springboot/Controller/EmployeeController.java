package com.example.springboot.Controller;

import com.example.springboot.Model.Employee;
import com.example.springboot.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.lang.module.ResolutionException;
import java.util.Optional;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    // create employee rest API
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){

        return employeeRepository.save(employee);
    }

    // get employee by id rest api
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            return ResponseEntity.ok(employee);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    // update employee by id rest api
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employeeDetails){

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isPresent()){

            Employee updateEmployee = employeeOptional.get();

            updateEmployee.setFristName(employeeDetails.getFristName());
            updateEmployee.setLastname(employeeDetails.getLastname());
            updateEmployee.setEmailId(employeeDetails.getEmailId());

            employeeRepository.save(updateEmployee);

            return ResponseEntity.ok(updateEmployee);

        }
        else {

            return ResponseEntity.notFound().build();

        }



    }


}
