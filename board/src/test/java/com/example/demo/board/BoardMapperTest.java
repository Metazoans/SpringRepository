package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest

public class BoardMapperTest {

	@Autowired BoardMapper boardMapper;
	
	@Test
	@DisplayName("게시글 등록")
	public void register() {
		// given
		// new BoardDTO == builder
		String title = "등록";
		BoardDTO board = BoardDTO.builder()
			.title(title)
			.content("내용")
			.writer("작성자")
			.build();
		
		// when
		int cnt = boardMapper.insert(board);
		
		// then
		assertThat(cnt).isEqualTo(cnt);
		
	}
	
	@Test
	@DisplayName("게시글 수정")
	public void testUpdate() {
		// given
		// new BoardDTO == builder
		long bno = 8L;
		String title = "수정";
		BoardDTO board = BoardDTO.builder()
			.bno(bno)
			.title(title)
			.content("수정한 내용")
			.writer("수정한 작성자")
			.build();
		
		// when
		int cnt = boardMapper.update(board);
		
		// then
		assertThat(cnt).isEqualTo(cnt);
		
	}
	

	@Test
	@DisplayName("게시글 삭제")
	public void testDelete() {
		// given
		// new BoardDTO == builder
		long bno = 6L;
		
		// when
		int cnt = boardMapper.delete(bno);
		
		// then
		log.info("delete cnt : " + cnt); // Slf4j 사용한 로그 확인
		assertThat(cnt).isEqualTo(cnt);
		
	}
	
	@Test
	@DisplayName("게시글 상세조회")
	public void testRead() {
		// given
		long bno = 5L;
		
		// when
		BoardDTO board = boardMapper.read(bno);
		
		// then
		log.info(board.toString());
//		assertEquals(board.getBno(), bno);
//		assertThat(bno).isEqualTo(board.getBno());
		assertThat(board).isNotNull();
		
		
	}
	
	@Test
	@DisplayName("게시글 전체조회")
	public void testGetList() {
		// given
		
		// when
		List<BoardDTO> list = boardMapper.getList();
		
		// then
		list.forEach(board -> log.info(board.toString()));
		//assertNotNull(list);
		assertThat(list).isNotNull();
		
		
	}
}
