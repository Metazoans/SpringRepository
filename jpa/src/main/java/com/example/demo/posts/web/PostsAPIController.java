package com.example.demo.posts.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.posts.service.PostsService;
import com.example.demo.posts.web.dto.PostResponseDto;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;
import com.example.demo.posts.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostsAPIController {
	
	final PostsService postsService;
	
	//등록
	@PostMapping("/api/v1/posts")
	public PostsSaveRequestDto save(@RequestBody PostsSaveRequestDto dto) {
		postsService.save(dto);
		return dto;
	}
	
	//수정
	@PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable(name="id") Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }
	
	//단건조회
//	@GetMapping("/api/v1/posts/{id}")
//	public PostResponseDto findById (@PathVariable Long id) {
//		return postsService.findById(id);
//	}
	
	//삭제
//	@DeleteMapping("/api/v1/posts/{id}")
//	public delete(@PathVariable(name="id") Long id) {
//		return postsService.delete(id);
//	}
	
}
