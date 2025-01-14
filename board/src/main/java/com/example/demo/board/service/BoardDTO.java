package com.example.demo.board.service;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoardDTO {
  private Long bno;
  private String title;
  private String content;
  private String writer;
  private Date regdate;
}
