package com.org.realtimejavaapp.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private int age;
	private double salary;
	private String departmentName;
	private String workPlace;
	private String platform;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date joiningDate;
	private String geneder;
	private String projectName;

}
