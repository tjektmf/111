package com.ezen.board.service;

import org.springframework.ui.Model;

import com.ezen.board.dto.BoardDTO;

public interface BoardService {
	
	void list(Model model);
	
	int add(BoardDTO dto);

}
