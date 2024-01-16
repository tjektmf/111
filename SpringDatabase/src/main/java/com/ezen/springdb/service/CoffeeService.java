package com.ezen.springdb.service;

import org.springframework.ui.Model;

import com.ezen.springdb.dto.CoffeeDTO;

public interface CoffeeService {
	
	int updateForm(Model model, int coffee_number);

	void list(Model model);
	
	int update(CoffeeDTO dto);
}
