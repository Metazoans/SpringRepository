package com.example.demo.exam.service;

import java.util.List;

public interface BookService {
	public boolean register(BookDTO book);
	public List<BookDTO> getList();
	public Long getLastNo();
}
