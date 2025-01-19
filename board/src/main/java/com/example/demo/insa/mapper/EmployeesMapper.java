package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.EmployeeSearchDTO;
import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.JobsDTO;

public interface EmployeesMapper {
	public int insert(EmployeesDTO emp);
	public List<EmployeesDTO> getList(EmployeeSearchDTO searchDTO);
	public List<JobsDTO> getJobList();
	public int getCount(EmployeeSearchDTO searchDTO);
}
