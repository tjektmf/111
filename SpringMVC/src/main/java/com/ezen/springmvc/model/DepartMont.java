package com.ezen.springmvc.model;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DepartMont {
	
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;

}