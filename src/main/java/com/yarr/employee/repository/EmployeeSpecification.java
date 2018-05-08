package com.yarr.employee.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.yarr.employee.repository.entity.Employee;

public class EmployeeSpecification {

	public static Specification<Employee> hasName(String name) {
	    return new Specification<Employee>() {
			private static final long serialVersionUID = -6830310738671317979L;

			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return (name == null) ? cb.conjunction() : cb.equal(root.get("name"), name);
			}
	    };
	}

	public static Specification<Employee> hasId(String id) {
	    return new Specification<Employee>() {
			private static final long serialVersionUID = -7663692617611231739L;

			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return (id == null) ? cb.conjunction() : cb.equal(root.get("id"), id);
			}
	    };
	}

}
