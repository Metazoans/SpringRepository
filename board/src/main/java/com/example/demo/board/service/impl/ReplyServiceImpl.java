package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	// @RequiredArgsConstructor 사용하는 경우 mapper에 final 넣기 / @AllArgsConstructor mapper final 제외
	private final ReplyMapper replyMapper;
	private final BoardMapper boardMapper;

	@Override
	@Transactional
	public boolean register(ReplyDTO vo) {
		if(replyMapper.insert(vo) == 1) {
			boardMapper.updateReplyCnt(vo.getBno(), 1);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modify(ReplyDTO vo) {
		return replyMapper.update(vo) == 1 ? true : false;
	}

	@Override
	@Transactional
	public boolean remove(Long rno) {
		ReplyDTO rdto = replyMapper.read(rno);
		if(replyMapper.delete(rno) == 1) {
			boardMapper.updateReplyCnt(rdto.getBno(), -1);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public ReplyDTO get(Long rno) {
		return replyMapper.read(rno);
	}

	@Override
	public ReplyPageDTO getList(ReplySearchDTO replySearch, Long bno) {
		Paging paging = new Paging();
		int cnt = replyMapper.getCountByBno(bno);
		
		// paging - 전체건수, pageUnit, page
		paging.setPage(replySearch.getPage());
		paging.setPageUnit(replySearch.getAmount());
		paging.setTotalRecord(cnt);
		
		return new ReplyPageDTO(
					cnt,
					paging,
					replyMapper.getList(replySearch, bno)
				);
	}
}
