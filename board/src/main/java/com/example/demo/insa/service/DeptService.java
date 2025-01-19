package com.example.demo.insa.service;

import java.util.List;

public interface DeptService {
	public DepartmentDTO get(Long departmentId);
	public List<DepartmentDTO> getList(DeptSearchDTO searchDTO);
}
