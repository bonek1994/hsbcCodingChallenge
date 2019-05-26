package com.example.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private String surname;
	@Positive
	private Integer age;
	@Positive
	private Integer grade;
	public Integer getAge() {
		return age;
	}
	public Integer getGrade() {
		return grade;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
