package com.tahr.employee.controller;

import com.tahr.employee.entity.Employee;
import com.tahr.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        try {
            Employee createdEmployee = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable int id) {
        try {
            Employee employee = employeeService.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee( @RequestBody Employee employee) {
        try {
            Employee savedEmployee = employeeService.updateEmployee(employee.getId(), employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
