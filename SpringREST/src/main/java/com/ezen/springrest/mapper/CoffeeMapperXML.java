package com.ezen.springrest.mapper;

import com.ezen.springrest.dto.CoffeeDTO;

public interface CoffeeMapperXML {
	
	int post(CoffeeDTO dto);
	
	int put(CoffeeDTO dto);
	
	int delete(int coffee_number);
	

}
