package com.orjan.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orjan.dto.EmployeeDto;
import com.orjan.entities.Employee;
import com.orjan.exception.ResourceNotFoundException;
import com.orjan.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	private static final Logger LOGGER = Logger.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		final List<Employee> employees = (List<Employee>) employeeService.findAll();
		final List<EmployeeDto> employeesDto = employees.stream().map(e -> new EmployeeDto(e)).collect(Collectors.toList());
		

		
		return ResponseEntity.ok().body(employeesDto);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") int employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeService.findOne(employeeId);
		if (null == employee) {
			throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
		}

		return ResponseEntity.ok().body(new EmployeeDto(employee));
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		employeeService.save(employee);
		return ResponseEntity.ok().body(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		final Employee employee = employeeService.findOne(employeeId);
		if (null == employee) {
			throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
		}

		final Employee updatedEmployee = employeeService.save(employeeDetails);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
			throws ResourceNotFoundException {
		final Employee employee = employeeService.findOne(employeeId);
		if (null == employee) {
			throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
		}

		employeeService.delete(employee.getEmployeeId());
		final Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/employees/contactInfo/{id}")
	public Map<String, Boolean> deleteEmployeeContactInfo(@PathVariable(value = "id") Integer contactInfoId)
			throws ResourceNotFoundException {
		final Employee employee = employeeService.findOne(contactInfoId);
		if (null == employee) {
			throw new ResourceNotFoundException("Employee not found for this id :: " + contactInfoId);
		}

		employeeService.delete(employee.getEmployeeId());
		final Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
