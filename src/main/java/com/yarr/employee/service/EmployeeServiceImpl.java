package com.yarr.employee.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.yarr.employee.presentation.EmployeeInfo;
import com.yarr.employee.repository.EmployeeRepository;
import com.yarr.employee.repository.EmployeeSpecification;
import com.yarr.employee.repository.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public static final int PAGE_SIZE = 10;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeInfo addEmployee(Employee employee) {
		employee.setCreateDate(new Date());
		return employeeRepository.save(employee);
	}

	@Override
	public EmployeeInfo updateEmployee(Long id, Employee employee) throws Exception {
		Employee oldEmployee = employeeRepository.findById(id).orElseThrow(() -> new Exception("Employee not found"));
		employee.setId(id);
		employee.setCreateDate(oldEmployee.getCreateDate());
		employee.setAmendDate(new Date());
		employeeRepository.save(employee);

		return employee;
	}

	@Override
	public void deleteEmployee(Long id) throws Exception {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
		} else {
			throw new Exception("Employee not found");
		}
	}

	@Override
	public List<Employee> findAllEmployeeByCriteria(String name, Long id) {
		return employeeRepository.findAll(EmployeeSpecification.hasName(name).and(EmployeeSpecification.hasId(id)));
	}

	@Override
	public List<Employee> findAllEmployee(@RequestParam int pageNumber) {
		PageRequest request = PageRequest.of(pageNumber - 1, PAGE_SIZE);
		return employeeRepository.findAll(request).getContent();
	}

}
