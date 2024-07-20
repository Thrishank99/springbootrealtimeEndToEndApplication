package com.org.realtimejavaapp.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.org.realtimejavaapp.dto.EmployeeDto;
import com.org.realtimejavaapp.entity.Employee;



@Mapper
public interface EmployeeMapper {

	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee mapEmployeetDTOToEmployee(EmployeeDto employeeDto);
    EmployeeDto mapEmployeeToEmployeeDto(Employee employee);

}

