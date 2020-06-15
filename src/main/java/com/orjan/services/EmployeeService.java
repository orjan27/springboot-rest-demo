package com.orjan.services;

import com.orjan.entities.Employee;

public interface EmployeeService {

    Iterable<Employee> findAll();

    Employee findOne(Integer id);

    Employee save(Employee employee);

    void delete(Integer id);

}
