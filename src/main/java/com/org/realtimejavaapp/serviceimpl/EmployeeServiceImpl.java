package com.org.realtimejavaapp.serviceimpl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.realtimejavaapp.dto.EmployeeDto;
import com.org.realtimejavaapp.entity.Employee;
import com.org.realtimejavaapp.exceptions.EmptyInputException;
import com.org.realtimejavaapp.exceptions.NoRecordsFoundException;
import com.org.realtimejavaapp.exceptions.NodetailsFoundException;
import com.org.realtimejavaapp.mapper.EmployeeMapper;
import com.org.realtimejavaapp.repository.EmployeeRepository;
import com.org.realtimejavaapp.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		if (employee.getEmpId() != 0 || employee.getEmpName().isEmpty()) {
			throw new EmptyInputException("600", "given input is empty");
		} else if (employee.getDepartmentName().isEmpty() || employee.getPlatform().length() == 0) {
			throw new NodetailsFoundException("780", "No Details Found");
		}
		return employeeRepository.save(employee);

	}

	@Override
	public Employee updateEmployeeDetails(Employee employee) {
		List<Employee> list = employeeRepository.findAll();
		List<Integer> empIds = list.stream().map(s1 -> s1.getEmpId()).collect(Collectors.toList());
		if (!empIds.contains(employee.getEmpId())) {
			throw new EmptyInputException("5000", "no data available");
		}
		return employeeRepository.save(employee);

	}

	@Override
	public Employee deleteEmployeeDetails(Employee employee) {
		List<Employee> list = employeeRepository.findAll();
		List<Integer> empIds = list.stream().map(s1 -> s1.getEmpId()).collect(Collectors.toList());
		if (!empIds.contains(employee.getEmpId())) {
			throw new EmptyInputException("5000","no data available");
		}
		employeeRepository.delete(employee);
		return employee;
	}

	@Override
	public List<EmployeeDto> findAllEmployeeDetails() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		if (list.isEmpty()) {
			throw new EmptyInputException("600", "given input is empty");
		}
		List<EmployeeDto> listDto = list.stream().map(s1 -> EmployeeMapper.INSTANCE.mapEmployeeToEmployeeDto(s1))
				.collect(Collectors.toList());
		return listDto;

	}

	@Override
	public List<Employee> findByEmployeNameDeatails(String name) {
	List<Employee> Names=	employeeRepository.findByEmpName(name);
	if(Names.contains(name)||Names.isEmpty()) {
		throw new EmptyInputException("600", "given input is empty");	
	}
	return Names;
		
	}

	@Override
	public List<Employee> findByEmployedeptNameDeatails(String deptName) {
		List<Employee> deptNames=	employeeRepository.findByDepartmentName(deptName);
		if(deptNames.contains(deptName)||deptNames.isEmpty()) {
			throw new EmptyInputException("600", "given input is empty");	
		}
		return deptNames;
			
		}

	@Override
	public List<Employee> findByEmployeeSalaryAscDeatails() {
		List<Employee> list = employeeRepository.findAll();
		if(list.isEmpty()||list.contains(null)) {
			throw new EmptyInputException("600", "given input is empty");
		}
		List<Employee> naturalOrder= list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
		return naturalOrder;
	}

	@Override
	public List<Employee> findByEmployeeSalaryDscDeatails() {
		List<Employee> list = employeeRepository.findAll();
		if(list.isEmpty()||list.contains(null)) {
			throw new EmptyInputException("600", "given input is empty");
		}
		List<Employee> reverseOrder= list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());
		return reverseOrder;
	}

	@Override
	public List<Employee> findByEmployeeIdEvenDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<Employee>evenIdsList=list.stream().filter(s1->s1.getEmpId()%2==0).collect(Collectors.toList());
		return evenIdsList;
	}

	@Override
	public List<Employee> findByEmployeeIdOddDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<Employee>evenIdsList=list.stream().filter(s1->s1.getEmpId()%2!=0).collect(Collectors.toList());
		return evenIdsList;
	}

	@Override
	public Employee findByMaxSalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		if(list.isEmpty()||list.contains(null)) {
			throw new EmptyInputException("600", "given input is empty");
		}
		Employee maxSalary= list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst().get();
		return maxSalary;
	}


	@Override
	public Employee findByMinSalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		if(list.isEmpty()||list.contains(null)) {
			throw new EmptyInputException("600", "given input is empty");
		}
		Employee minSalary= list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).findFirst().get();
		return minSalary;
	}

	@Override
	public double findBySumSalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		double sumSalaries=list.stream().mapToDouble(s1->s1.getSalary()).summaryStatistics().getSum();
		return sumSalaries;
	}

	@Override
	public double findByCountSalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		double countSalaries=list.stream().mapToDouble(s1->s1.getSalary()).summaryStatistics().getCount();
		return countSalaries;
	}

	@Override
	public List<Employee> findParticularRecordsDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<Employee> particularRecords=list.stream().skip(0).limit(3).collect(Collectors.toList());
		if(particularRecords.isEmpty()) {
			throw new EmptyInputException("600", "given input is empty");
		}
		return particularRecords;
	}

	@Override
	public Set<Employee> printDublicateRecordsDeatails() {
		Set<Double> set = new HashSet<Double>();
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> dublicates= list.stream().filter(s1->!set.add(s1.getSalary())).collect(Collectors.toSet());
		if(dublicates.isEmpty()) {
			throw new NoRecordsFoundException("550","there is no rercords found");
		}
		return dublicates;
	}

	@Override
	public Set<Employee> printWithoutDublicateRecordsDeatails() {
		Set<Employee> set=new HashSet<Employee>();
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> dublicates= list.stream().filter(s1->!set.add(s1)).collect(Collectors.toSet());
		return set;
	}

	@Override
	public List<Employee> findParticularRecordsAscsDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<Employee> ascParticularRecords= list.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1).limit(3).collect(Collectors.toList());
		return ascParticularRecords;
	}

	@Override
	public List<Employee> findParticularRecordsDscDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<Employee> dscParticularRecords= list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).limit(3).collect(Collectors.toList());
		return dscParticularRecords;
	}

	@Override
	public List<String> mapNamesDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<String> Names= list.stream().map(s1->s1.getEmpName()).collect(Collectors.toList());
		return Names;
	}

	@Override
	public Map<String, Long> findStringOccurenceDeatails() {
		// TODO Auto-generated method stub
		String str = null;
		List<Employee> list = employeeRepository.findAll();
		List<String> names = list.stream().map(s1 -> s1.getEmpName()).sorted().collect(Collectors.toList());
		System.out.println(names);
		for (String string : names) {
			if (string.equals("sreenivasarao")) {
				str = "sreenivasarao";
				break;
			}

		}
		
		Map<String, Long> occurence=Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		return occurence;
		
	}

	@Override
	public Map<Double, List<Employee>> groupBySalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		Map<Double, List<Employee>> groupSalaries= list.stream().collect(Collectors.groupingBy(Employee::getSalary,LinkedHashMap::new,Collectors.toList()));
		return groupSalaries;
	}

	@Override
	public Map<String, List<Employee>> groupByNamesDeatails() {
		List<Employee> list = employeeRepository.findAll();
		Map<String, List<Employee>> groupNames= list.stream().collect(Collectors.groupingBy(Employee::getEmpName,LinkedHashMap::new,Collectors.toList()));
		return groupNames;
	}

	@Override
	public Employee findByNameAndDeptNameDeatails(String name, String deptName) {
		Employee nameAnddeptDetails = employeeRepository.findByEmpNameAndDepartmentName(name,deptName);
		return nameAnddeptDetails;
	}

	@Override
	public Employee findByEmpIdAndNameAndDeptNameDeatails(int empId, String name, String deptName) {
		Employee idAndnameAnddeptDetails = employeeRepository.findByEmpIdAndEmpNameAndDepartmentName(empId,name,deptName);
		return idAndnameAnddeptDetails;
	}

	@Override
	public String firstnonRepeactedCharacterInStringDeatails() {
		String str = null;
		List<Employee> list = employeeRepository.findAll();
		List<String> names = list.stream().map(s1 -> s1.getEmpName()).sorted().collect(Collectors.toList());
		System.out.println(names);
		for (String string : names) {
			if (string.equals("sreenivasarao")) {
				str = "sreenivasarao";
				break;
			}
		}
		String firstnonRepeatedCharacter=Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream().filter(s1->s1.getValue()==1).findFirst().get().getKey();
		return firstnonRepeatedCharacter;
		
	}

	@Override
	public String firstRepeactedCharacterInStringDeatails() {
		String str = null;
		List<Employee> list = employeeRepository.findAll();
		List<String> names = list.stream().map(s1 -> s1.getEmpName()).sorted().collect(Collectors.toList());
		System.out.println(names);
		for (String string : names) {
			if (string.equals("sreenivasarao")) {
				str = "sreenivasarao";
				break;
			}
		}
		String firstRepeatedCharacter=Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream().filter(s1->s1.getValue()>1).findFirst().get().getKey();
		return firstRepeatedCharacter;
		
	}

	@Override
	public List<String> printDublicatesInStringDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<String> namesList = list.stream().map(s1 -> s1.getEmpName()).sorted().collect(Collectors.toList());
		List<String> dublicateStrings=namesList.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream().filter(s1->s1.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
		return dublicateStrings;
	}

	@Override
	public List<String> uniquerecordsInStringDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<String> namesList = list.stream().map(s1 -> s1.getEmpName()).sorted().collect(Collectors.toList());
		List<String> uniqStrings=namesList.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream().filter(s1->s1.getValue()==1).map(Map.Entry::getKey).collect(Collectors.toList());
		return uniqStrings;
	}

	@Override
	public String longestStringDeatails() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		List<String> namesList = list.stream().map(s1 -> s1.getEmpName()).sorted().collect(Collectors.toList());
	    String longest=	namesList.stream().reduce((word1,word2)->word1.length()>word2.length()?word1:word2).get();
		return longest;
	}

	@Override
	public String smallestStringDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<String> namesList = list.stream().map(s1 -> s1.getEmpName()).sorted().collect(Collectors.toList());
	    String smallest=	namesList.stream().reduce((word1,word2)->word1.length()<word2.length()?word1:word2).get();
		return smallest;
	}

	@Override
	public List<String> filterDepartmentIdsDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<Integer> namesList = list.stream().map(s1 -> s1.getEmpId()).sorted().collect(Collectors.toList());
		List<String> departmentIds=namesList.stream().map(s1->s1 +"").filter(s2->s2.startsWith("2")).collect(Collectors.toList());
		return departmentIds;
	}

	@Override
	public String stringReverseJava8Deatails() {
		// TODO Auto-generated method stub
		String str="sreenivasarao";
		String reverse=Arrays.stream(str.split(" ")).map(s1->new StringBuilder(s1).reverse().toString()).collect(Collectors.toList()).get(0);
		
		return reverse;
	}

	@Override
	public Employee secondHigestSalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		Employee secondHigestSalary= list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
		return secondHigestSalary;
	}

	@Override
	public Employee secondListSalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		Employee secondListSalary= list.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1).findFirst().get();
		return secondListSalary;
	}

	@Override
	public List<Employee> indexRangesDeatails(int fromIndex, int toIndex) {
		List<Employee> list = employeeRepository.findAll();
		List<Employee> ranges = list.subList(fromIndex, toIndex);
		return ranges;
	}

	@Override
	public String joiningNamesDeatails() {
		List<Employee> list = employeeRepository.findAll();
		String joinNames = list.stream().map(s1 -> s1.getEmpName()).collect(Collectors.joining(","));
		return joinNames;
	}

	@Override
	public Set<Employee> listToSetCoversion() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> set = list.stream().collect(Collectors.toSet());
		return set;
	}

	@Override
	public Map<Integer, Employee> listToMapCoversion() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		Map<Integer, Employee> listToMapConversion = list.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		return listToMapConversion;
	}

	@Override
	public List<Employee> setToListConversion() {
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> set = list.stream().collect(Collectors.toSet());
		List<Employee> setToList = set.stream().collect(Collectors.toList());
		return setToList;
	}

	@Override
	public Map<Integer, Employee> setToMapConversionDetails() {
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> set = list.stream().collect(Collectors.toSet());
		// TODO Auto-generated method stub
		Map<Integer, Employee> setToMap = set.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		return setToMap;
	}

	@Override
	public List<Entry<Integer, Employee>> mapToListConversionDetails() {
		List<Employee> list = employeeRepository.findAll();
		Map<Integer, Employee> listToMapConversion = list.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		List<Entry<Integer, Employee>> mapToList = listToMapConversion.entrySet().stream().collect(Collectors.toList());
		return mapToList;
	}

	@Override
	public Set<Entry<Integer, Employee>> mapToSetConversionDetails() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		Map<Integer, Employee> listToMapConversion = list.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		Set<Entry<Integer, Employee>> mapToSet = listToMapConversion.entrySet().stream().collect(Collectors.toSet());
		return mapToSet;
	}
	@Override
	public Optional<Employee> findByEmployeeIdDeatails(int empId) {
		Optional<Employee> emp=employeeRepository.findByEmpId(empId);
		// TODO Auto-generated method stub
		return emp;
	}
	@Override
	public List<Employee> findByDepartmentDetails(String deptName){
	List<Employee> deptNames=employeeRepository.findByDepartmentName(deptName);
	return deptNames;
		
	}

	@Override
	public String leftRotationStringDeatails() {
		
		String originalString="sreenivasarao";
		int rotateCharacters=4;
		String leftRotation=originalString.substring(rotateCharacters)+originalString.substring(0,rotateCharacters);
		return leftRotation;
	}

	@Override
	public String rightRotationStringDeatails() {
		// TODO Auto-generated method stub
		String originalString="sreenivasarao";
		int rotatechar=3;
		int partion=originalString.length()-rotatechar;
		String rightRotation=originalString.substring(partion)+originalString.substring(0,partion);
		return rightRotation;
	}

	@Override
	public List<EmployeeDto> findByEmployeeBetweenSalaryDeatails() {
		List<Employee> list=employeeRepository.findAll();
	List<Employee> empList=	list.stream().filter(s1->s1.getSalary()>65000 & s1.getSalary()<90000).collect(Collectors.toList());
	List<EmployeeDto> empDtoList= empList.stream().map(s1->EmployeeMapper.INSTANCE.mapEmployeeToEmployeeDto(s1)).collect(Collectors.toList());
		return empDtoList;
	}

	@Override
	public Map<String, Long> findBygroupCountDeatails() {
		// TODO Auto-generated method stub
		List<Employee> list=employeeRepository.findAll();
		List<EmployeeDto> dtoList=list.stream().map(s1->EmployeeMapper.INSTANCE.mapEmployeeToEmployeeDto(s1)).collect(Collectors.toList());
		
		Map<String, Long> deptDeatils=dtoList.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartmentName,Collectors.counting()));
	
		
		return deptDeatils;	}

}