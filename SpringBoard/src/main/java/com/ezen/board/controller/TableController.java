package com.ezen.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.board.service.BoardService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class TableController {
	
	@Autowired
	BoardService boardservice;
	
	@GetMapping("/spring/table")
	public String getTable(Model model) {
		log.info("GET table");
		boardservice.list(model);
		return "/spring/table";
	}
	
	@GetMapping("/spring/write")
	public String write() {
		log.info("GET write");
		return "/spring/write";
	}
	
	@PostMapping("/spring/table")
	public String postTable(Model model) {
		log.info("POST table");
		boardservice.list(model);
		return "/spring/table";
	}
	
	
	
}
