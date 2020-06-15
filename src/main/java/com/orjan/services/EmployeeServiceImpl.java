package com.orjan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orjan.entities.Employee;
import com.orjan.repositories.EmployeeRepository;

/**
 * Product service implement.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setProductRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findOne(Integer id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.delete(id);
    }

}
