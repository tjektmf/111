package com.ezen.snowboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.snowboard.dto.BoardDTO;
import com.ezen.snowboard.mapper.BoardMapper;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public void list(Model model) {
		model.addAttribute("boards", boardMapper.getAll());
	}

	@Override
	public boolean detail(int board_id, Model model) {

		BoardDTO board = boardMapper.get(board_id);
		log.info("board : " + board);

		if (board != null) {
			model.addAttribute("board", board);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int write(BoardDTO dto) {
		// insert 성공시 pk를 반환, 실패시 0을 반환
		int result = boardMapper.insert(dto);

		if (result == 1) {
			return dto.getBoard_id();
		} else {
			return result;
		}
	}

}
