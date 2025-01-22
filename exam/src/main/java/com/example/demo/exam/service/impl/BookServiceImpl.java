package com.example.demo.exam.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exam.mapper.BookMapper;
import com.example.demo.exam.service.BookDTO;
import com.example.demo.exam.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookMapper bookMapper;
	
	@Override
	public boolean register(BookDTO book) {
		return bookMapper.insert(book) == 1;
	}

	@Override
	public List<BookDTO> getList() {
		return bookMapper.getList();
	}

	@Override
	public Long getLastNo() {
		return bookMapper.getLastNo();
	}
}
