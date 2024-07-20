package com.org.realtimejavaapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.realtimejavaapp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByEmpName(String name);

	List<Employee> findByDepartmentName(String deptName);

	Employee findByEmpNameAndDepartmentName(String name, String deptName);

	Employee findByEmpIdAndEmpNameAndDepartmentName(int empId, String name, String deptName);

	Optional<Employee> findByEmpId(int empId);

	

}
