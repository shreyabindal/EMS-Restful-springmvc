package com.maven.models;

import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

	@Id
	private double id;

	@NotBlank(message = "Please enter a valid name")
	private String name;

	private String lastName;

	private String birthDate;

	@Size(min = 1, max = 10)
	private String role;

	@Size(min = 1, max = 10)
	private String department;

	@Email()
	@Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
	private String email;

	private static final AtomicLong counter = new AtomicLong(121);

	public Employee() {
		super();
		this.id = (double) counter.incrementAndGet();
	}

	// public Employee(String name, String lastName, String birthDate, String role,
	// String department, String email,
	// double id) {
	// this.name = name;
	// this.lastName = lastName;
	// this.birthDate = birthDate;
	// this.role = role;
	// this.department = department;
	// this.email = email;
	// this.id = id;
	// }

	@JsonCreator
	public Employee(@JsonProperty("name") String name, @JsonProperty("lastName") String lastName,
			@JsonProperty("birthDate") String birthDate, @JsonProperty("role") String role,
			@JsonProperty("department") String department, @JsonProperty("email") String email,
			@JsonProperty("id") Double id) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.role = role;
		this.department = department;
		this.email = email;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", role=" + role + ", department=" + department + ", email=" + email + "]";
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}