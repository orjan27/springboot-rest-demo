package com.orjan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orjan.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
