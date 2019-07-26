package com.maven.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maven.models.Employee;
import com.maven.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Employee>> employees() {

		HttpHeaders headers = new HttpHeaders();
		List<Employee> employees = employeeService.getAll();

		if (employees == null) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		headers.add("Number Of Records Found", String.valueOf(employees.size()));
		return new ResponseEntity<List<Employee>>(employees, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Double id) {
		Employee employee = employeeService.get(id);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Double id) {
		HttpHeaders headers = new HttpHeaders();
		Employee employee = employeeService.get(id);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		employeeService.delete(employee);
		headers.add("Employee Deleted - ", String.valueOf(id));
		return new ResponseEntity<Employee>(employee, headers, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		employeeService.add(employee);
		headers.add("Employee Created  - ", String.valueOf(employee.getId()));
		return new ResponseEntity<Employee>(employee, headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Double id, @RequestBody Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		Employee isExist = employeeService.get(id);
		if (isExist == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		employeeService.update(employee);
		headers.add("Employee Updated  - ", String.valueOf(id));
		return new ResponseEntity<Employee>(employee, headers, HttpStatus.OK);
	}

}