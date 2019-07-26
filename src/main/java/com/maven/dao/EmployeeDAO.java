package com.maven.dao;

import java.util.List;

import com.maven.models.Employee;

public interface EmployeeDAO {
	public List<Employee> getAll();

	public Employee get(Double id);

	public void add(Employee employee);

	public void update(Employee employee);

	public void delete(Employee employee);
}
