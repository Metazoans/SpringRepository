package com.example.demo.insa.service;

import java.util.List;

public interface DeptService {
	public DeptDTO get(Long departmentId);
	public List<DeptDTO> getList(DeptSearchDTO searchDTO);
}
