package com.ezen.snowboard.mapper;

import java.util.List;

import com.ezen.snowboard.dto.BoardDTO;

public interface BoardMapper {
	
	List<BoardDTO> getAll();
	
	// select myboard.*, 
	// ( select count(reply_id) from myreply where myboard.board_id = myreply.board_id) 
	// as reply_count from myboard order by board_id desc;
	List<BoardDTO> getAllwithReplyCount();
	
	BoardDTO get(int board_id);
	
	// dto에 저장된 내용들, 글내용 글쓴이 비밀번호 등을 db에 등록하고 등록되면 int로 리턴
	int insert(BoardDTO dto);
	
	
}
