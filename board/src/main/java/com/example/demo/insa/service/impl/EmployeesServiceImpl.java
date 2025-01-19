package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.EmployeesMapper;
import com.example.demo.insa.service.EmployeeSearchDTO;
import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.EmployeesService;
import com.example.demo.insa.service.JobsDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeesService {

	private final EmployeesMapper employeesMapper;
	
	@Override
	public boolean register(EmployeesDTO emp) {
		return employeesMapper.insert(emp) == 1;
	}

	@Override
	public List<EmployeesDTO> getList(EmployeeSearchDTO searchDTO) {
		return employeesMapper.getList(searchDTO);
	}

	@Override
	public List<JobsDTO> getJobList() {
		return employeesMapper.getJobList();
	}

	@Override
	public int getCount(EmployeeSearchDTO searchDTO) {
		return employeesMapper.getCount(searchDTO);
	}

}
