package com.ezen.snowboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.snowboard.dto.ReplyDTO;
import com.ezen.snowboard.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	ReplyMapper replyMapper;
	
	@Override
	public void count(int board_id, Model model) {
		int count = replyMapper.count(board_id);
		log.info(count);
		
		model.addAttribute("count", count);
	}
	
	@Override
	public int add(ReplyDTO dto) {
		replyMapper.add(dto);
		log.info("add reply");
		return dto.getBoard_id();
	}
	
	@Override
	public void getAll(int board_id, Model model) {
		log.info("getAll : "+ replyMapper.getAll(board_id).size());
		model.addAttribute("reply", replyMapper.getAll(board_id));
		model.addAttribute("count", replyMapper.getAll(board_id).size() );
	}

}
