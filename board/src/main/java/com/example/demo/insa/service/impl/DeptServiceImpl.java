package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.DeptMapper;
import com.example.demo.insa.service.DepartmentDTO;
import com.example.demo.insa.service.DeptSearchDTO;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {
	private final DeptMapper deptMapper;

	@Override
	public DepartmentDTO get(Long departmentId) {
		return deptMapper.read(departmentId);
	}

	@Override
	public List<DepartmentDTO> getList(DeptSearchDTO searchDTO) {
		return deptMapper.getList(searchDTO);
	}
	
	
}
