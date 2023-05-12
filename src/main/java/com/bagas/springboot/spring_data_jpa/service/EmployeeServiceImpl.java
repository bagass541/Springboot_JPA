package com.bagas.springboot.spring_data_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.bagas.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.bagas.springboot.spring_data_jpa.entity.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		Employee employee = null;
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional .isPresent())
		{
			employee = optional .get();
		}
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findAllByName(String name) {
		List<Employee> employees = employeeRepository.findAllByName(name);
		return employees;
	}

}
