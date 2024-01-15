package com.ezen.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ezen.springdb.dto.EmployeeDTO;

public interface EmployeeMapper {
	
	@Select("select * from employees")
	List<EmployeeDTO> getAll();
	
}
