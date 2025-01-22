package com.example.demo.exam.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	@NotNull(message = "도서명이 입력되지 않았습니다.")
	private Long bookNo;
	private String bookName;
	private String bookCoverimg;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookDate;
	private Long bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
	private String strDate;
}
