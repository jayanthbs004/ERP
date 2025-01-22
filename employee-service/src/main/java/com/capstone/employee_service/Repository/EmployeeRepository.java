package com.capstone.employee_service.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capstone.employee_service.Model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}