package com.ezen.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ezen.springdb.dto.CoffeeDTO;

public interface CoffeeMapper {
	
	@Select("select * from coffee")
	List<CoffeeDTO> getAll();
	
	@Select("select * from coffee where coffee_size =#{size}")
	CoffeeDTO get(@Param("size") String coffee_size);
	
	@Insert("insert into coffee(coffee_name, coffee_price, coffee_size) values (#{coffee_name}, #{coffee_price}, #{coffee_size})")
	int add(CoffeeDTO dto);
	
	@Delete("delete from coffee where coffee_size =#{size}")
	int delete(@Param("size") String coffee_size);
	
	@Update("update coffee set coffee_name=#{coffee_name}, coffee_price=#{coffee_price}, coffee_size=#{coffee_size}")
	int update(CoffeeDTO dto);

}
