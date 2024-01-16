package com.ezen.board.mapper;

import java.util.List;

import com.ezen.board.dto.BoardDTO;

public interface BoardMapperXML {
	
	List<BoardDTO> getAll();
	int add(BoardDTO dto);

}
