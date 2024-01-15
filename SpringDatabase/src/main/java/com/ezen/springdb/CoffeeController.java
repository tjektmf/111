package com.ezen.springdb;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.springdb.dto.CoffeeDTO;
import com.ezen.springdb.mapper.CoffeeMapper;
import com.ezen.springdb.mapper.CoffeeMapperXML;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CoffeeController {

	@Autowired
	CoffeeMapper coffeeMapper;
	@Autowired
	CoffeeMapperXML coffeeMapperXML;
	
	private static Logger log = LogManager.getLogger(CoffeeController.class);
	// @GetMapping, @PostMapping 등으로 @RequestMapping 을 줄여 사용할 수 있다
	@GetMapping("/coffee/list")
	public void list(Model model) {
	
		log.info("ㅇㅅㅇ/");
		model.addAttribute("coffee", coffeeMapperXML.getAll());
	}
	
	@GetMapping("/coffee/update")
	public void updateForm(Model model, Integer coffee_number) {
		log.info("GET_update");
		model.addAttribute("coffee", coffeeMapper.get(coffee_number));
	}
	
	@PostMapping("/coffee/update")
	public String update(CoffeeDTO dto) {
		log.info("POST_update");
		int row = coffeeMapperXML.updateCoffee(dto);
		return "redirect:/coffee/list";
	}
}
