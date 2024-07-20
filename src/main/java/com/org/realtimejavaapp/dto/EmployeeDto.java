package com.org.realtimejavaapp.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
	
	private int empId;
	private String empName;
	private int age;
	private double salary;
	private String departmentName;
	private String workPlace;
	private String platform;
	private Date joiningDate;
	private String geneder;
	private String projectName;


}
