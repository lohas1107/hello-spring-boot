package com.yarr.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.yarr.employee.presentation.EmployeeInfo;
import com.yarr.employee.presentation.EmployeeView;
import com.yarr.employee.repository.entity.Employee;
import com.yarr.employee.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	/**
	 * Add or update a new employee.
	 * @param employee
	 * @return employeeId
	 */
	@PostMapping("/v1/employees")
	@JsonView(EmployeeView.Id.class)
	@ResponseBody
	public ResponseEntity<EmployeeInfo> addEmployee(@RequestBody Employee employee) {
		EmployeeInfo employeeInfo = employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeInfo);
	}

	/**
	 * Update the existing employee with the given id.
	 * @param id
	 * @param employee
	 * @return EmployeeInfo
	 * @throws Exception 
	 */
	@PutMapping("/v1/employees/{id}")
	@ResponseBody
	public ResponseEntity<EmployeeInfo> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) throws Exception {
		EmployeeInfo employeeInfo = employeeService.updateEmployee(id, employee);
		return ResponseEntity.status(HttpStatus.OK).body(employeeInfo);
	}

	/**
	 * Deletes the employee with the given id.
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@DeleteMapping("/v1/employees/{id}")
	@JsonView(EmployeeView.Id.class)
	@ResponseBody
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) throws Exception {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	} 

	/**
	 * Find all employee with column name, employeeId and gender.
	 * @param name
	 * @return Employee List
	 */
	@GetMapping("/v1/employees")
	@JsonView(EmployeeView.List.class)
	@ResponseBody
	public ResponseEntity<List<Employee>> findAllEmployeeByCriteria(@RequestParam(required = false) String name, @RequestParam(required = false) String id) {
		List<Employee> employeeList = employeeService.findAllEmployeeByCriteria(name, id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeList);
	}

	/**
	 * Find employee list in pages.
	 * @param page
	 * @return Employee List
	 */
	@GetMapping("/v1/employees/page/{page_number}")
	@ResponseBody
	public ResponseEntity<List<Employee>> findAllEmployeeByPage(@PathVariable(value = "page_number")  int pageNumber) {
		List<Employee> employeePageList = employeeService.findAllEmployee(pageNumber);
		return ResponseEntity.status(HttpStatus.OK).body(employeePageList);
	}

}
