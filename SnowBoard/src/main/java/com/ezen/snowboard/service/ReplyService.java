package com.ezen.snowboard.service;

import org.springframework.ui.Model;

import com.ezen.snowboard.dto.ReplyDTO;

public interface ReplyService {
	
	void count(int board_id, Model model);
	
	int add(ReplyDTO dto);
	
	void getAll(int board_id, Model model);

}
