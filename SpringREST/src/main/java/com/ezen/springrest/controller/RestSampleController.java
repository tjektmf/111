package com.ezen.springrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.springrest.dto.EmployeeDTO;

import lombok.extern.log4j.Log4j;

// @RestController : 내부의 모든 메서드들에 @ResponseBody가 적용됨
@Log4j
@RequestMapping("/rest")
@RestController
public class RestSampleController {
	
	// produces : 응답 헤더의 Context-type을 변경함 (브라우저의 해석 방식 변경)
	
	@RequestMapping(value="/v1" , method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String value1() {
		log.info(log);
		return "<h1>hi hi bye bye</h1>";
	}
	
	@RequestMapping(value="/v2" , method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public String value2() {
		log.info(log);
		// 여기선 produces = "text/html; 에 의해 <h1>을 html 태그로 해석함
		return "<h1>hi hi bye bye</h1>";
	}
	
	// jackson-databind : DTO 를 응답하면 자동으로 json 형식으로 만들어서 응답해준다
	@GetMapping(value="/v3", produces = "application/json; charset=UTF-8")
	public EmployeeDTO value3() {
		
		EmployeeDTO emp = new EmployeeDTO();
		
		emp.setEmployee_id(11);
		emp.setFirst_name("뭉망");
		emp.setLast_name("김");
		return emp;
		
	}

}
