package com.ezen.springrest.service;

import com.ezen.springrest.dto.CoffeeDTO;

public interface CoffeeService {
	
	int add(CoffeeDTO dto);
	
	int update(CoffeeDTO dto);
	
	int delete(CoffeeDTO dto);

}
