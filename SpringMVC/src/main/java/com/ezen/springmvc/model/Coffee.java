package com.ezen.springmvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@RequiredArgsConstructor 
@NoArgsConstructor
public class Coffee {

	@NonNull
	private Integer coffee_id;
	private String coffee_name;
	private double coffee_price;
	private String country_id;
	
}
