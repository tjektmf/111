package com.ezen.springrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	@RequestMapping(value = "/v1", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String value1() {
		log.info(log);
		return "<h1>ㅇㅅㅇ/</h1>";
	}

	@RequestMapping(value = "/v2", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public String value2() {
		log.info(log);
		// 여기선 produces = "text/html; 에 의해 <h1>을 html 태그로 해석함
		return "<h1>hi hi bye bye</h1>";
	}

	// jackson-databind : DTO 를 응답하면 자동으로 json 형식으로 만들어서 응답해준다
	@GetMapping(value = "/v3", produces = "application/json; charset=UTF-8")
	public EmployeeDTO value3() {

		EmployeeDTO emp = new EmployeeDTO();

		emp.setEmployee_id(11);
		emp.setFirst_name("뭉망");
		emp.setLast_name("김");
		return emp;
	}

	@GetMapping(value = "/v4", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeDTO value4() {

		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmployee_id(15);
		emp.setFirst_name("곰곰");
		emp.setLast_name("김");
		log.info(emp);
		return emp;
	}

	// jackson-dataformat-xml : DTO를 XML 형식 문자열로 응답해주는 라이브러리
	@GetMapping(value = "/v5", produces = MediaType.APPLICATION_XML_VALUE)
	public EmployeeDTO value5() {

		EmployeeDTO emp = new EmployeeDTO();

		emp.setEmployee_id(22);
		emp.setFirst_name("포");
		emp.setLast_name("세이돈");
		return emp;
	}

	// jackson-databind 는 List<DTO>로 리턴해도 잘 변환해줌
	@GetMapping(value = "/v6", produces = MediaType.APPLICATION_XML_VALUE)
	public List<EmployeeDTO> value6() {

		List<EmployeeDTO> emps = new ArrayList<>();
		EmployeeDTO emp1 = new EmployeeDTO();

		emp1.setEmployee_id(221);
		emp1.setFirst_name("포1");
		emp1.setLast_name("세이돈1");

		EmployeeDTO emp2 = new EmployeeDTO();

		emp2.setEmployee_id(222);
		emp2.setFirst_name("포2");
		emp2.setLast_name("세이돈2");

		EmployeeDTO emp3 = new EmployeeDTO();

		emp3.setEmployee_id(223);
		emp3.setFirst_name("포3");
		emp3.setLast_name("세이돈3");
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		return emps;
	}

	@GetMapping(value = "/v7", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeDTO> value7() {

		List<EmployeeDTO> emps = new ArrayList<>();
		EmployeeDTO emp1 = new EmployeeDTO();

		emp1.setEmployee_id(221);
		emp1.setFirst_name("포1");
		emp1.setLast_name("세이돈1");

		EmployeeDTO emp2 = new EmployeeDTO();

		emp2.setEmployee_id(222);
		emp2.setFirst_name("포2");
		emp2.setLast_name("세이돈2");

		EmployeeDTO emp3 = new EmployeeDTO();

		emp3.setEmployee_id(223);
		emp3.setFirst_name("포3");
		emp3.setLast_name("세이돈3");
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		return emps;
	}
	
	// jackson-databind 는 List<DTO>로 리턴해도 잘 변환해줌
		@GetMapping(value = "/v8", produces = MediaType.APPLICATION_XML_VALUE)
		public List<EmployeeDTO> value8() {

			List<EmployeeDTO> emps = new ArrayList<>();
			EmployeeDTO emp1 = new EmployeeDTO();

			emp1.setEmployee_id(221);
			emp1.setFirst_name("포1");
			emp1.setLast_name("세이돈1");

			EmployeeDTO emp2 = new EmployeeDTO();

			emp2.setEmployee_id(222);
			emp2.setFirst_name("포2");
			emp2.setLast_name("세이돈2");

			EmployeeDTO emp3 = new EmployeeDTO();

			emp3.setEmployee_id(223);
			emp3.setFirst_name("포3");
			emp3.setLast_name("세이돈3");
			emps.add(emp1);
			emps.add(emp2);
			emps.add(emp3);
			return emps;
		}

	@GetMapping("/entity1")
	public ResponseEntity<String> entity1() {
		ResponseEntity<String> resp = ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_HTML)
				.body("<h1>:)</h1>");

		return resp;
	}

	// ResponseEntity 는 원하는 에러코드를 만들 때가 아니면 사용할 일은 없음 아마도
	@GetMapping("/entity2")
	public ResponseEntity<String> entity2() {
		return ResponseEntity.ok("dz");
	}

	// jackson-databind의 JSON 형식 데이터 응답을 수동으로 구현
	@GetMapping("/entity3")
	public ResponseEntity<String> entity3() {
		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON)
				.body("{\"first_name\":\"틀린\", \"last_name\":\"코\" }");
	}

	@GetMapping("/entity4")
	public ResponseEntity<EmployeeDTO> entity4() {
		EmployeeDTO emp = new EmployeeDTO();

		emp.setEmployee_id(33);
		emp.setFirst_name("포");
		emp.setLast_name("세이돈");

		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(emp);
	}

}
