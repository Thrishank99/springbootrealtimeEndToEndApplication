package com.org.realtimejavaapp.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.org.realtimejavaapp.dto.EmployeeDto;
import com.org.realtimejavaapp.entity.Employee;

@Service
public interface EmployeeService {

	Employee saveEmployeeDetails(Employee employee);
	
	Employee updateEmployeeDetails(Employee employee);

	List<EmployeeDto> findAllEmployeeDetails();

	Employee deleteEmployeeDetails(Employee employee);
	
	List<Employee> findByEmployeNameDeatails(String name);

	List<Employee> findByEmployedeptNameDeatails(String deptName);

	List<Employee> findByEmployeeSalaryAscDeatails();

	List<Employee> findByEmployeeSalaryDscDeatails();

	List<Employee> findByEmployeeIdEvenDeatails();

	List<Employee> findByEmployeeIdOddDeatails();

	Employee findByMaxSalaryDeatails();

	Employee findByMinSalaryDeatails();

	double findBySumSalaryDeatails();

	double findByCountSalaryDeatails();

	List<Employee> findParticularRecordsDeatails();

	Set<Employee> printDublicateRecordsDeatails();

	Set<Employee> printWithoutDublicateRecordsDeatails();

	List<Employee> findParticularRecordsAscsDeatails();

	List<Employee> findParticularRecordsDscDeatails();

	List<String> mapNamesDeatails();

	Map<String, Long> findStringOccurenceDeatails();

	Map<Double, List<Employee>> groupBySalaryDeatails();

	Map<String, List<Employee>> groupByNamesDeatails();

	Employee findByNameAndDeptNameDeatails(String name, String deptName);

	Employee findByEmpIdAndNameAndDeptNameDeatails(int empId, String name, String deptName);

	String firstnonRepeactedCharacterInStringDeatails();

	String firstRepeactedCharacterInStringDeatails();

	List<String> printDublicatesInStringDeatails();

	List<String> uniquerecordsInStringDeatails();

	String longestStringDeatails();

	String smallestStringDeatails();

	List<String> filterDepartmentIdsDeatails();

	String stringReverseJava8Deatails();

	Employee secondHigestSalaryDeatails();

	Employee secondListSalaryDeatails();

	List<Employee> indexRangesDeatails(int fromIndex, int toIndex);

	String joiningNamesDeatails();

	Set<Employee> listToSetCoversion();

	Map<Integer, Employee> listToMapCoversion();

	List<Employee> setToListConversion();

	Map<Integer, Employee> setToMapConversionDetails();

	List<Entry<Integer, Employee>> mapToListConversionDetails();

	Set<Entry<Integer, Employee>> mapToSetConversionDetails();

	Optional<Employee> findByEmployeeIdDeatails(int empId);

	List<Employee> findByDepartmentDetails(String deptName);

	String leftRotationStringDeatails();

	String rightRotationStringDeatails();

	List<EmployeeDto> findByEmployeeBetweenSalaryDeatails();

	Map<String, Long> findBygroupCountDeatails();

	

	

}
