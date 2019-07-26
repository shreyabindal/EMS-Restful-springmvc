package com.maven.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.maven.models.Employee;

@Repository("employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "employees";

	@Override
	public List<Employee> getAll() {
		return mongoTemplate.findAll(Employee.class, COLLECTION_NAME);
	}

	@Override
	public Employee get(Double id) {
		return mongoTemplate.findById(id, Employee.class, COLLECTION_NAME);
	}

	@Override
	public void add(Employee employee) {
		mongoTemplate.insert(employee, COLLECTION_NAME);
	}

	@Override
	public void update(Employee employee) {
		mongoTemplate.save(employee, COLLECTION_NAME);
	}

	@Override
	public void delete(Employee employee) {
		mongoTemplate.remove(employee, COLLECTION_NAME);
	}
}
