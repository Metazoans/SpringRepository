package com.example.demo.insa;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.insa.service.DepartmentDTO;
import com.example.demo.insa.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DeptServiceTest {
	@Autowired
	DeptService deptService;
	
	@Test
	@DisplayName("부서 전체 조회")
	void getList() {
		List<DepartmentDTO> list = deptService.getList(null);
		
		log.debug(list.toString());
	}
	
	@Test
	@DisplayName("부서 단건 조회")
	void get() {
		DepartmentDTO dept = deptService.get(10L);
		
		log.debug(dept.toString());
	}
}
