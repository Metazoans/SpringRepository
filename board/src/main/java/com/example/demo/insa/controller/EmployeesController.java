package com.example.demo.insa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.common.Paging;
import com.example.demo.insa.service.DeptService;
import com.example.demo.insa.service.EmployeeSearchDTO;
import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.EmployeesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/emp/*")
public class EmployeesController {
	private final EmployeesService employeesService;
	private final DeptService deptService;
	
	@GetMapping("/list")
	public void list(Model model, EmployeeSearchDTO searchDTO, Paging paging) {
		// 페이징처리
		paging.setTotalRecord(employeesService.getCount(searchDTO));
		
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());
		
		model.addAttribute("empList", employeesService.getList(searchDTO));
		
		model.addAttribute("jobList", employeesService.getJobList());
		model.addAttribute("deptList", deptService.getList(null));
	}
	
	@GetMapping("/register")
	public void register(EmployeesDTO emp, Model model) {
		model.addAttribute("jobList", employeesService.getJobList());
		model.addAttribute("deptList", deptService.getList(null));
	}
	
	@PostMapping("/register")
	public String register(EmployeesDTO emp,
			               BindingResult bindingResult,
			               RedirectAttributes rttr) {
		
		if(bindingResult.hasErrors()) {
			return "emp/register";
		}
		
		employeesService.register(emp);
		
		rttr.addFlashAttribute("result", true);
		return "redirect:/emp/list";
	}
}
