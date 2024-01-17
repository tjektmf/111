package com.ezen.snowboard.mapper;

import java.util.List;

import com.ezen.snowboard.dto.ReplyDTO;

public interface ReplyMapper {
	
	int add(ReplyDTO dto);
	
	List<ReplyDTO> getAll(int board_id);
	
}
