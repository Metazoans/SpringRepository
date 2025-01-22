package com.example.demo.posts.web.dto;

import com.example.demo.posts.domain.Posts;

import lombok.Getter;

@Getter
public class PostResponseDto {
	
	private Long id;
	private String title;
    private String content;
    private String author;

    // 단건조회 entity ==> dto 변환
    public PostResponseDto(Posts entity) {
    	this.id = entity.getId();
    	this.title = entity.getTitle();
    	this.content = entity.getContent();
    	this.author = entity.getAuthor();
    }
}
