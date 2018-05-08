package com.yarr.employee.repository.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.yarr.employee.presentation.EmployeeInfo;

@Entity
public class Employee implements EmployeeInfo {

	private String name;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String gender;
	private String phone;
	private String address;
	private Integer age;
	private Date createDate;
	private Date amendDate;

	public Employee() { }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getAmendDate() {
		return amendDate;
	}

	public void setAmendDate(Date amendDate) {
		this.amendDate = amendDate;
	}

}
