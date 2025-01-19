package com.example.demo.insa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.insa.service.DepartmentDTO;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dept/*")
public class DeptController {
	private final DeptService deptService;
	
	@GetMapping("list")
	public List<DepartmentDTO> list() {
		return deptService.getList(null);
	}
	
	@GetMapping("get")
	public DepartmentDTO get(@RequestParam(name="departmentId") long deptId) {
		return deptService.get(deptId);
	}
}
