package com.ezen.snowboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.snowboard.dto.BoardDTO;
import com.ezen.snowboard.dto.ReplyDTO;
import com.ezen.snowboard.service.BoardService;
import com.ezen.snowboard.service.ReplyService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	BoardService boardservice;
	@Autowired
	ReplyService replyservice;

	@GetMapping("/")
	public String index() {
		log.info("GET : /board/index");
		return "/board/index";
	}

	@GetMapping("/list")
	public String list(Model model) {
		log.info("GET : /board/list");
		boardservice.list(model);
		log.info("GET : list on");
		return "/board/list";
	}

	@GetMapping("/detail")
	public String detail(Model model, int board_id) {
		log.info("GET : /board/detail");
		boardservice.detail(board_id, model);
		replyservice.getAll(board_id, model);
		return "/board/detail";
	}

	@GetMapping("/write")
	public String writeForm() {
		log.info("GET : /board/writeForm");
		return "/board/writeForm";
	}

	@PostMapping("/write")
	public String write(BoardDTO dto, RedirectAttributes rattr) {
		log.info("enter write");
		int board_id = boardservice.write(dto);
		if (board_id > 0) {
			rattr.addAttribute("board_id", board_id);
			log.info("POST : redirect:/board/detail");
			return "redirect:/board/detail";
		} else {
			log.info("POST : redirect:/board/writeFail");
			return "redirect:/board/writeFail";
		}
	}
	
	@GetMapping("/replyPop")
	public String replyPop() {
		log.info("GET : /board/replyPop");
		return "/board/replyPop";
	}
	
	// 포스트로 받은 정보를 여기서 다 써먹고 딱히 어트리뷰트에 추가하지 않고 리다이렉트하면서
	// pk인 board_id가 null 값이 나오는 현상이 있었음
	// 댓글을 추가하는 add 매서드에서 dto.getBoard_id 를 리턴해 RedirectAttributes 매개변수를 통해
	// 다시 어트리뷰트에 실어서 리다이렉트해서 이 현상을 해결함
	@PostMapping("/replyAdd")
	public String replyAdd(ReplyDTO dto, RedirectAttributes rattr) {
		log.info(dto.getBoard_id());
		int board_id = replyservice.add(dto);
		log.info("POST : /board/replyAdd");
		rattr.addAttribute("board_id", board_id);
		return "redirect:/board/detail";
	}

}
