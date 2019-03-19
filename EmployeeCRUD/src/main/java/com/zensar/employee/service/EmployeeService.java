package com.zensar.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.employee.entity.Employee;
import com.zensar.employee.exception.EmployeeInsertException;
import com.zensar.employee.exception.EmployeeNotFoundException;
import com.zensar.employee.repository.EmployeeMongoRepository;

@Service
public class EmployeeService {
	
	private static final Logger LOG = Logger.getLogger(EmployeeService.class.getName());
	
	@Autowired
	private EmployeeMongoRepository employeeRepository;
	
	public Employee getEmployeeById(Integer empId)  {
		
		LOG.info("Employee Service class : getEmployeeById : empId " + empId);
		
		Optional<Employee> findById = employeeRepository.findById(empId);
		if(!findById.isPresent()) {
			throw new EmployeeNotFoundException();
		}		
		return findById.get();
	}

	public List<Employee> createEmployee(Employee employee) {
		
		LOG.info("Employee Service class : createEmployee : employee  " + employee);
		
		Employee emp = employeeRepository.insert(employee);
		if(emp == null) {
			throw new EmployeeInsertException();
		} 
		return employeeRepository.findAll();
	}

	public List<Employee> findAllEmployee() {
		
		LOG.info("Employee Service class : findAllEmployee : ");
		
		List<Employee> findAll = employeeRepository.findAll();
		
		if(findAll == null || findAll.size() == 0) {
			throw new EmployeeNotFoundException();
		}
		
		return findAll;
	}

	public Employee updateEmployee(Integer empId, Employee employee) {
		
		LOG.info("Employee Service class : updateEmployee : empId " + empId + " Employee " + employee);
		
		Optional<Employee> findById = employeeRepository.findById(empId);
		if(!findById.isPresent()) {
			throw new EmployeeNotFoundException();
		} else {
			employeeRepository.deleteById(empId);
		}
		
		Employee employee2 = findById.get();
		if(employee.getFirstName() != null) {
			employee2.setFirstName(employee.getFirstName());			
		}
		
		if(employee.getLastName() != null) {
			employee2.setLastName(employee.getLastName());			
		}
		
		if(employee.getEmail() != null) {
			employee2.setEmail(employee.getEmail());			
		}
		
		return employeeRepository.insert(employee2);
	}

	public List<Employee> deleteByEmployeeId(Integer empId) {
		
		LOG.info("Employee Service class : deleteByEmployeeId : empId " + empId);
		
		if(employeeRepository.existsById(empId)) {
			employeeRepository.deleteById(empId);			
		} else {
			throw new EmployeeNotFoundException();
		}
		
		return employeeRepository.findAll();
	}

	public Employee getEmployeeByFirstName(String firstName) {
		
		LOG.info("Employee Service class : getEmployeeByFirstName : firstName : " + firstName);
		
		Employee findByFirstName = employeeRepository.findByFirstName(firstName);
		if(findByFirstName == null) {
			throw new EmployeeNotFoundException();
		}
		return findByFirstName;
	}

	public Employee getEmployeeByLastName(String lastName) {
		
		LOG.info("Employee Service class : getEmployeeByLastName : lastName : " + lastName);
		
		Employee findByLastName = employeeRepository.findByLastName(lastName);
		if(findByLastName == null) {
			throw new EmployeeNotFoundException();
		}
		return findByLastName;
	}

	public Employee getEmployeeByEmail(String email) {
		
		LOG.info("Employee Service class : getEmployeeByEmail : email : " + email);
		
		Employee findByEmail = employeeRepository.findByEmail(email);
		if(findByEmail == null) {
			throw new EmployeeNotFoundException();
		}		
		return findByEmail;
	}
	
	public Employee getEmployeeByFirstAndLastName(String firstName, String lastName) {
		
		LOG.info("Employee Service class : getEmployeeByFirstAndLastName : firstName : " + firstName + " lastName " + lastName);
		
		Employee findByFirstNameAndLastName = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		if(findByFirstNameAndLastName == null) {
			throw new EmployeeNotFoundException();
		}
		
		return findByFirstNameAndLastName;
	}

}
