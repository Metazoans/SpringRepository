package com.example.demo.posts.web.dto;

import com.example.demo.posts.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//등록 시에는 제목, 내용, 작성자
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
	private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    
    // 사용자 입력 파라미터 => Dto => Entity
    public Posts toEntity() {
    	return Posts.builder()
    			.title(title)
    			.content(content)
    			.author(author)
    			.build();
    }
    
}
