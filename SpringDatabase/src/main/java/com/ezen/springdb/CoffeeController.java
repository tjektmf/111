package com.ezen.springdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.springdb.mapper.CoffeeMapper;


@Controller
public class CoffeeController {

	@Autowired
	CoffeeMapper coffeeMapper;
	
	// @GetMapping, @PostMapping 등으로 @RequestMapping 을 줄여 사용할 수 있다
	@GetMapping("/coffee/list")
	public void list(Model model) {
		model.addAttribute("coffee", coffeeMapper.getAll());
		
	}
}
