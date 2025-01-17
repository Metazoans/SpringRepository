package com.example.demo.insa.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.insa.service.EmployeesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/emp/*")
public class EmployeesController {
	private final EmployeesService employeesService;
	
	@GetMapping("list")
	public void list(Model model) {
		model.addAttribute("list", employeesService.getList());
	}
	
	@GetMapping("register")
	public void register() {
		//
	}
}
