package com.example.demo.board.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardServiceTest {
	@Autowired
	BoardService boardService;
	
	@Test
	@DisplayName("게시글 수정")
	  public void testUpdate() {
	    //given
	    // 실행전 존재하는 번호인지 확인할 것
	    BoardDTO board = BoardDTO.builder()
	          .bno(5L)
	          .title("수정된 제목5")
	          .content("수정된 내용")
	          .writer("user00")
	          .build();

	    //when
	    boolean result = boardService.modify(board);

	    //then	  
	    assertThat(result).isEqualTo(true);
	  }
	
	@Test
	@DisplayName("게시글 상세조회")
	public void testRead() {
		//given
	    long bno = 5L;

	    //when
	    BoardDTO board = boardService.get(bno);

	    //then
	    log.info(board.toString());
	    assertThat(board).isNotNull();
		
		
	}

}
