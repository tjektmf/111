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
	
	@Select("select * from coffee where coffee_number =#{coffee_number}")
	CoffeeDTO get(@Param("coffee_number") int coffee_number);
	
	@Insert("insert into coffee(coffee_number, coffee_name, coffee_price, coffee_size) values (coffee_number_seq.nextval, #{coffee_name}, #{coffee_price}, #{coffee_size})")
	int add(CoffeeDTO dto);
	
	@Delete("delete from coffee where coffee_number =#{coffee_number}")
	int delete(@Param("coffee_number") int coffee_number);
	
	@Update("update coffee set coffee_name=#{coffee_name}, coffee_price=#{coffee_price}, coffee_size=#{coffee_size} where coffee_number =#{coffee_number}")
	int update(CoffeeDTO dto);

}
