package com.ezen.springrest.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.springrest.dto.EmployeeDTO;
import com.ezen.springrest.mapper.EmployeeMapperXML;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeMapperXML employeemapper;

	
	public void list10(Model model) {
		log.info("list");
		List<EmployeeDTO> list = employeemapper.getAll();
		Collections.shuffle(list);
		List<EmployeeDTO> list10 = list.subList(0, 9);
		model.addAttribute("list10", list10);
	};
}
