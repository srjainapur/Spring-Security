package com.zensar.employee.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.employee.entity.Employee;
import com.zensar.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static final Logger LOG = Logger.getLogger(EmployeeController.class.getName());
	
	@Autowired
	private EmployeeService employeeService;
	
	// GET Employee by ID
	@RequestMapping(value="/employee/{empId}", method=RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("empId") Integer empId) {
		
		LOG.info("Employee Controller class : getEmployeeById : empId " + empId);
		
		return employeeService.getEmployeeById(empId);
	}
	
	// Get Employee by firstName
	@RequestMapping(value="/employeeByFName/{firstName}")
	public Employee getEmployeeByFirstName(@PathVariable("firstName") String firstName) {
		
		LOG.info("Employee Controller class : getEmployeeByFirstName : firstName " + firstName);
		
		return employeeService.getEmployeeByFirstName(firstName);
	}
	
	// Get Employee by Last Name
	@RequestMapping(value="/employeeByLName/{lastName}")
	public Employee getEmployeeByLastName(@PathVariable("lastName") String lastName) {
		
		LOG.info("Employee Controller class : getEmployeeByLastName : lastName " + lastName);
		
		return employeeService.getEmployeeByLastName(lastName);
	}
	
	// Get Employee by email
	@RequestMapping(value="/employeeByEmail/{email}")
	public Employee getEmployeeByEmail(@PathVariable("email") String email) {
		
		LOG.info("Employee Controller class : getEmployeeByEmail : email " + email);
		
		return employeeService.getEmployeeByEmail(email);
	}
	
	// Get Employee by First & Last Name
	@RequestMapping(value="/empByFirstAndLastName/{firstName}/{lastName}")
	public Employee getEmployeeByFirstAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		
		LOG.info("Employee Controller class : getEmployeeByFirstAndLastName : firstName " + firstName + " lastName " + lastName);
		
		return employeeService.getEmployeeByFirstAndLastName(firstName, lastName);
	}
	
	// GET All Employee
	@RequestMapping(value="/allEmployee", method=RequestMethod.GET)
	public List<Employee> findAllEmployee() {
		
		LOG.info("Employee Controller class : findAllEmployee : ");
		
		return employeeService.findAllEmployee();
	}
	
	// Insert Employee
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public List<Employee> createEmployee(@RequestBody Employee employee) {		
		LOG.info("Employee Controller class : createEmployee : employee " + employee);		
		return employeeService.createEmployee(employee);		
	}
	
	// Update Employee
	@RequestMapping(value="/employee/{empId}", method=RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable("empId") Integer empId, @RequestBody Employee employee) {
		
		LOG.info("Employee Controller class : updateEmployee : empId : " + empId + " employee " + employee);
		
		return employeeService.updateEmployee(empId, employee);
	}
	
	// Delete Employee by Id
	@RequestMapping(value="/employee/{empId}", method=RequestMethod.DELETE)
	public List<Employee> deleteByEmployeeId(@PathVariable("empId") Integer empId) {
		
		LOG.info("Employee Controller class : deleteByEmployeeId : empId : " + empId);
		return employeeService.deleteByEmployeeId(empId);
	}	
	
}
