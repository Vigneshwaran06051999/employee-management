package com.tahr.employee.service;

import com.tahr.employee.entity.Employee;
import com.tahr.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(getEmployeeToSave(employee));
    }

    private Employee getEmployeeToSave(Employee employee) {
        Employee emp = new Employee();
        emp.setDepartment(employee.getDepartment());
        emp.setId(employee.getId());
        emp.setEmail(employee.getEmail());
        emp.setName(employee.getName());
        emp.setNumber(employee.getNumber());
        emp.setSalary(employee.getSalary());
        return emp;
    }

    public Employee getEmployee(int id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }

    public Employee updateEmployee(int id, Employee receivedObj) {
       Employee employee = getEmployee(id);
       employee.setDepartment(receivedObj.getDepartment());
       employee.setEmail(receivedObj.getEmail());
       employee.setName(receivedObj.getName());
       employee.setNumber(receivedObj.getNumber());
       employee.setSalary(receivedObj.getSalary());
       return employeeRepo.save(employee);
    }
}
