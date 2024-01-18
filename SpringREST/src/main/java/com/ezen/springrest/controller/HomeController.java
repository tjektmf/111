package com.ezen.springrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@ResponseBody
	@GetMapping(value="/fruit", produces = "text/plain; charset=UTF-8")
	public String fruit() {
		// 원래 의미 : /WEB-INF/views/fruit.jsp 로 포워딩
		// @ResponseBody 를 붙이면 "fruit"을 응답
		log.info(log);
		return "fruit";
	}
}
