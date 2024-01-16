package com.ezen.springdb.mapper;

import java.util.List;

import com.ezen.springdb.dto.CoffeeDTO;

public interface CoffeeMapperXML {
	
	List<CoffeeDTO> getAll();
	
	CoffeeDTO get(int coffee_number);

	int add(CoffeeDTO dto);
	
	int update(CoffeeDTO dto);
	
	int delete(int coffee_number);

}
