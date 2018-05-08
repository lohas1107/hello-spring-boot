package com.yarr.employee.service;

import java.util.List;

import com.yarr.employee.presentation.EmployeeInfo;
import com.yarr.employee.repository.entity.Employee;

public interface EmployeeService {

	public EmployeeInfo addEmployee(Employee employee);
	public EmployeeInfo updateEmployee(Long id, Employee employee) throws Exception;
	public void deleteEmployee(Long id) throws Exception;
	public List<Employee> findAllEmployeeByCriteria(String name, Long id);
	public List<Employee> findAllEmployee(int pageNumber);

}
