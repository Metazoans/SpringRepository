package com.example.demo.board.service;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	private Long bno; // list.html bno
	
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	@NotBlank
	private String writer;
	
	private Date regdate;
	
//	@Pattern("0\\d{3,4}-")
	
	
	

}
