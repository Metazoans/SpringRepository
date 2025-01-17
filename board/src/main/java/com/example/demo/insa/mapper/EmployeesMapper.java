package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.EmployeesDTO;

public interface EmployeesMapper {
	public int insert(EmployeesDTO emp);
	public List<EmployeesDTO> getList();
}
