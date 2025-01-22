package com.example.demo.exam.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.exam.service.BookDTO;
import com.example.demo.exam.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/book/*")
public class BookController {
	private final BookService bookService;
	
	@GetMapping("/list")
	public void list(Model model) {
		List<BookDTO> list = bookService.getList();
		for(int i = 0; i < list.size(); i++) {
			Date newDate = list.get(i).getBookDate();
	        
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd"); 
			String strDate = simpleDateFormat.format(newDate);
			list.get(i).setStrDate(strDate);
		}
		
		model.addAttribute("bookList", list);
	}

	@GetMapping("/register")
	public void register(BookDTO book, Model model) {
		System.out.println("last num : " + bookService.getLastNo());
		book.setBookNo(bookService.getLastNo() + 1);
	}
	
	@PostMapping("/register")
	public String register(BookDTO book,
			               BindingResult bindingResult,
			               RedirectAttributes rttr) {
		
		if(bindingResult.hasErrors()) {
			return "book/register";
		}
		
		bookService.register(book);
		
		rttr.addFlashAttribute("result", true);
		return "redirect:/book/list";
	}
}
