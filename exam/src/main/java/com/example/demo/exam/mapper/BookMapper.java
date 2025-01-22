package com.example.demo.exam.mapper;

import java.util.List;

import com.example.demo.exam.service.BookDTO;

public interface BookMapper {
	int insert(BookDTO book);
	List<BookDTO> getList();
	Long getLastNo();
}
