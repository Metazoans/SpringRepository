package com.example.demo.insa.service;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptDTO {
	int departmentId;
	String departmentName;
	int managerId;
	int locationId;
}
