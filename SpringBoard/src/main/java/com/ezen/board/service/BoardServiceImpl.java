package com.ezen.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.ezen.board.dto.BoardDTO;
import com.ezen.board.mapper.BoardMapperXML;

import lombok.extern.log4j.Log4j;

@Log4j
@Repository
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapperXML boardMapper;
	
	@Override
	public void list(Model model) {
		List<BoardDTO> board = boardMapper.getAll();
		model.addAttribute("board", board);
	}
	
	@Override
	public int add(BoardDTO dto) {
		boardMapper.add(dto);
		return 1;
	}

}
