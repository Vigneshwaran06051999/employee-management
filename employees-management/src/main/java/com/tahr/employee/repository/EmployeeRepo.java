package com.tahr.employee.repository;

import com.tahr.employee.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee, Integer> {
}
