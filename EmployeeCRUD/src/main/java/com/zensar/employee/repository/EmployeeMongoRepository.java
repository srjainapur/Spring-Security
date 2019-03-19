package com.zensar.employee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zensar.employee.entity.Employee;

@Repository
public interface EmployeeMongoRepository extends MongoRepository<Employee, Integer>{
	public Employee findByFirstName(String firstName);
	public Employee findByLastName(String lastName);
	public Employee findByEmail(String email);
	public Employee findByFirstNameAndLastName(String firstName, String lastName);
}
