package com.ezen.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.ezen.springdb.dto.CoffeeDTO;
import com.ezen.springdb.mapper.CoffeeMapper;
import com.ezen.springdb.mapper.CoffeeMapperXML;

import lombok.extern.log4j.Log4j;

@Log4j
@Repository
public class CoffeeServiceImpl implements CoffeeService {

	// 이 기능은 컨트롤러가 아닌 서비스 부분에서 만들어져야 함
	
	@Autowired
	CoffeeMapperXML coffeeMapper;
	
	//@Autowired
	//CountryMapper countryMapper

	@Override
	public int updateForm(Model model, int coffee_number) {
		log.info("1");
		CoffeeDTO coffee = coffeeMapper.get(coffee_number);
		log.info("2");

		if (coffee == null) {
			return -1;
		}
		
		model.addAttribute("coffee", coffee);
		// model.addAttribute("countries", countryMapper.getAll());
		return 1;
	}
	
	@Override
	public void list(Model model) {
		List<CoffeeDTO> list = coffeeMapper.getAll();
		model.addAttribute("coffee", list);
	}
	
	@Override
	public int update(CoffeeDTO dto) {
		coffeeMapper.update(dto);
		return 0;
	}
}
