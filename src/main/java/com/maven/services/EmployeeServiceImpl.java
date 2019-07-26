package com.maven.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.maven.dao.EmployeeDAO;
import com.maven.models.Employee;

//@Transactional
//@Repository
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public Employee get(Double id) {
		return employeeDao.get(id);
	}

	@Override
	public void add(Employee employee) {
		employeeDao.add(employee);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}
}
