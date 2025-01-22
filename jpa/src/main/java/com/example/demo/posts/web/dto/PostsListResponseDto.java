package com.example.demo.posts.web.dto;

import java.time.LocalDateTime;

import com.example.demo.posts.domain.BaseTimeEntity;
import com.example.demo.posts.domain.Posts;

import lombok.Getter;

@Getter
public class PostsListResponseDto {

	private Long id;
	private String title;
    private String author;
    private LocalDateTime modifiedDate;

    // 전체조회 entity ==> dto 변환
    public PostsListResponseDto(Posts entity) {
    	this.id = entity.getId();
    	this.title = entity.getTitle();
    	this.author = entity.getAuthor();
    	this.modifiedDate = entity.getModifiedDate();
    }
}
