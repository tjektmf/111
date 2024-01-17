package com.ezen.snowboard.service;

import org.springframework.ui.Model;

import com.ezen.snowboard.dto.BoardDTO;

public interface BoardService {
	
	void list(Model model);
	
	// 성공여부 확인을 위해 타입 설정
	boolean detail(int board_id, Model model);
	
	int write(BoardDTO dto);

}
