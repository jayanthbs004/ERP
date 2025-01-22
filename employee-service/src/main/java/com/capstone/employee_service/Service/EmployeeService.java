package com.capstone.employee_service.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.capstone.employee_service.Model.Employee;
import com.capstone.employee_service.Repository.EmployeeRepository;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(String id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    public Mono<String> getProjectDetails(String projectId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/projects/" + projectId)
                .retrieve()
                .bodyToMono(String.class);
    }
}
