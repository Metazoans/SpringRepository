package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.DepartmentDTO;
import com.example.demo.insa.service.DeptSearchDTO;

public interface DeptMapper {
	DepartmentDTO read(Long departmentId);
	List<DepartmentDTO> getList(DeptSearchDTO searchDTO);
}
