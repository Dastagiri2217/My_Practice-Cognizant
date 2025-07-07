package com.example.employee_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // save() is available from JpaRepository
}

