package com.ezen.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springrest.dto.CoffeeDTO;
import com.ezen.springrest.mapper.CoffeeMapperXML;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class CoffeeServiceImpl implements CoffeeService{
	
	@Autowired
	CoffeeMapperXML coffeeMapper;
	
	@Override
	public int add(CoffeeDTO dto) {
		
		coffeeMapper.post(dto);
		log.info("insert, POST");

		return 1;
	}
	
	@Override
	public int update(CoffeeDTO dto) {
		
		coffeeMapper.put(dto);
		log.info("update, PUT");

		return 1;
	}
	
	@Override
	public int delete(CoffeeDTO dto) {
		
		coffeeMapper.delete(dto.getCoffee_number());
		log.info("delete, DELETE");

		return 1;
	}

}
