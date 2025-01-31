package com.example.demo.posts.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.posts.domain.Posts;
import com.example.demo.posts.service.PostsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
	
	final PostsService postsService;
	
	@GetMapping("/")
	public String index(Model model) {
		// 목록조회
		model.addAttribute("posts", postsService.findAll());
		return "index";
	}
	
	@GetMapping("/save")
	public String save() {
		return "posts-insert";
	}
	
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable(name="id") Long id) {
		// 단건조회
		model.addAttribute("post", postsService.findById(id));
		
		return "posts-update";
	}
}
