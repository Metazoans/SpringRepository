package com.example.demo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.Paging;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	private BoardService service;
	
	@GetMapping("/list")	
	public void list(Model model, BoardSearchDTO searchDTO, Paging paging) {
		log.info("list");
		
		// 페이징처리
		paging.setTotalRecord(service.getCount(searchDTO));
		
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());
		
		model.addAttribute("list", service.getList(searchDTO));	//html tr 반복 <tr th:each=" : ${list 같아야함}">
	}
	
	
	// 등록 페이지
	@GetMapping("/register")
	public void register(BoardDTO board) {}
	
	// 등록 처리
	@PostMapping("/register")
	public String register(@Validated BoardDTO board,
						   BindingResult bindingResult,
						   RedirectAttributes rttr) {
		if(bindingResult.hasErrors()) {
			return "board/register";
		}
		
		log.info("register:" + board);
		service.register(board); // -> mapper -> insert 
		
		rttr.addFlashAttribute("result", true); //addFlashAttribute 딱한번 어럴트 보임
		return "redirect:/board/list";
	}
	
	//수정
	@GetMapping({"/modify","get"})
	public void modify(@RequestParam(name="bno") Long bno, Model model) {
		BoardDTO board = service.get(bno);
		model.addAttribute("board", board);
	}
	
	//수정
	@PostMapping("/modify")
	public String modify(BoardDTO board, RedirectAttributes rttr) {
		log.info("modify:" + board);
		service.modify(board); // -> mapper -> insert 
		
		rttr.addFlashAttribute("result", true); //addFlashAttribute 딱한번 어럴트 보임
		return "redirect:/board/list";
	}

	//삭제
		@PostMapping("/remove")
		public String remove(Long board, RedirectAttributes rttr) {
			log.info("remove:" + board);
			service.remove(board); 
			
			rttr.addFlashAttribute("result", true); //addFlashAttribute 딱한번 어럴트 보임
			return "redirect:/board/list";
		}
}
