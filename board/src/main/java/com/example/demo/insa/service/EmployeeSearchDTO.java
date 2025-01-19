package com.example.demo.insa.service;

import lombok.Data;

@Data
public class EmployeeSearchDTO {
	int start;
	int end;
	
	String dept;
	String job;
	String name;
	
	int pageUnit;
	
	public String[] getTypeArr() {
		return name == null ? new String[] {} : name.split("");
	}
}
