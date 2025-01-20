package com.example.demo.securing.service;

import lombok.Data;

@Data
public class RoleDTO {
	// user_id number이지만 자동 변환됨
	private String userId;
	private String roleName;
	
	
}
