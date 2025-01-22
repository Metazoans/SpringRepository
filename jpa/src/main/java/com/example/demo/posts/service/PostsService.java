package com.example.demo.posts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.posts.domain.Posts;
import com.example.demo.posts.domain.PostsRepository;
import com.example.demo.posts.web.dto.PostResponseDto;
import com.example.demo.posts.web.dto.PostsListResponseDto;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;
import com.example.demo.posts.web.dto.PostsUpdateRequestDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    //등록
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    
    //수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    
    //삭제
//    public Long delete(Long id) {
//    	Posts posts = postsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
//    	
//    	posts.delete(id);
//    }
    
    //전체조회
    public List<PostsListResponseDto> findAll() {
    	List<Posts> list = postsRepository.findAll();
    	
//    	List<PostsListResponseDto> dtoList = new ArrayList<PostsListResponseDto>();
//    	list.forEach((post) -> dtoList.add(new PostsListResponseDto(post)));
//    	return dtoList;
    	
    	return list.stream().map(post -> new PostsListResponseDto(post)).collect(Collectors.toList());
    	
    }
    
    //단건조회
    public PostResponseDto findById(Long id) {
    	Optional<Posts> post = postsRepository.findById(id);
    	return new PostResponseDto(post.get());
    }
}