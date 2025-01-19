package com.example.demo.insa.service;

import java.util.List;

public interface EmployeesService {
	public boolean register(EmployeesDTO emp);
	public List<EmployeesDTO> getList(EmployeeSearchDTO searchDTO);
	public List<JobsDTO> getJobList();
	public int getCount(EmployeeSearchDTO searchDTO);
}
