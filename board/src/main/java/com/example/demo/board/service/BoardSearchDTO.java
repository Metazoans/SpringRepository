package com.example.demo.board.service;

import lombok.Data;

@Data
public class BoardSearchDTO {
	int start;
	int end;
	
	String type;
	String keyword;
	int pageUnit;
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}
