package com.ezen.springrest.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.springrest.dto.CoffeeDTO;
import com.ezen.springrest.dto.EmployeeDTO;
import com.ezen.springrest.service.CoffeeService;
import com.ezen.springrest.service.EmployeeService;

import lombok.extern.log4j.Log4j;

// @RestController : 내부의 모든 메서드들에 @ResponseBody가 적용됨
@Log4j
@RequestMapping("/rest")
@RestController
public class RestSampleController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	CoffeeService coffeeService;

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
	public List<EmployeeDTO> value7(Model model) {

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

		EmployeeDTO emp4 = new EmployeeDTO();
		emp4.setEmployee_id(224);
		emp4.setFirst_name("포4");
		emp4.setLast_name("세이돈4");

		EmployeeDTO emp5 = new EmployeeDTO();
		emp5.setEmployee_id(225);
		emp5.setFirst_name("포5");
		emp5.setLast_name("세이돈5");

		EmployeeDTO emp6 = new EmployeeDTO();
		emp6.setEmployee_id(226);
		emp6.setFirst_name("포6");
		emp6.setLast_name("세이돈6");
		emps.add(emp4);
		emps.add(emp5);
		emps.add(emp6);

		Collections.shuffle(emps);

		employeeService.list10(model);
		List<EmployeeDTO> ans = (List<EmployeeDTO>) model.getAttribute("list10");
		log.info(ans);

		return ans;
	}

	// jackson-databind 는 List<DTO>로 리턴해도 잘 변환해줌
	@GetMapping(value = "/v8", produces = MediaType.APPLICATION_XML_VALUE)
	public List<EmployeeDTO> value8(Model model) {

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

		employeeService.list10(model);
		List<EmployeeDTO> ans = (List<EmployeeDTO>) model.getAttribute("list10");
		log.info(ans);

		return ans;
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

	@PutMapping("/emp")
	public ResponseEntity<EmployeeDTO> updateEmp(@RequestBody EmployeeDTO dto) {
		log.info("PUT : " + dto);

		// DB에 업데이트 후 결과를 얻어 온다고 가정
		int result = (int) (Math.random() * 2);

		if (result == 1) {
			// 업데이트가 성공적으로 되었을 때 상태코드 200과 업데이트된 행을 응답한다
			// xml 타입이 디폴트인지 json.parse 에서 오류가 생김
			// contentType(MediaType.APPLICATION_JSON) 을 사용해 타입을 설정해줌
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(dto);
		} else {
			// 업데이트가 실패했을 때는
			// 상태코드 400과 null을 응답한다
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}

	@PostMapping("postCafe")
	public ResponseEntity<CoffeeDTO> postCafe(@RequestBody CoffeeDTO dto) {
		coffeeService.add(dto);
		log.info("POST, insert : " + dto);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@PutMapping("putCafe")
	public ResponseEntity<CoffeeDTO> putCafe(@RequestBody CoffeeDTO dto) {
		coffeeService.update(dto);
		log.info("PUT, update : " + dto);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@DeleteMapping("deleteCafe")
	public ResponseEntity<CoffeeDTO> deleteCate(@RequestBody CoffeeDTO dto) {
		coffeeService.delete(dto);
		log.info("DELETE, delete : " + dto);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@PostMapping("cafe2")
	public ResponseEntity<String> insertCoffee(@RequestBody CoffeeDTO dto) {
		log.info("성공");
		return ResponseEntity.ok("String Type");
	}

	// PutMapping 의 cafe2 와 PostMapping 의 cafe2 는 완전 다른 주소임
	@PutMapping("cafe2/{coffee_number}")
	public ResponseEntity<String> updateCoffee(
			@PathVariable("coffee_number") Integer coffee_number,
			@RequestBody CoffeeDTO dto) {
		// 굳이 Service.update에 coffee_number 매개변수를 넣을 필요가 없었음
		// dto 게터에 dto.getCoffee_number로 사용하는듯?
		coffeeService.update(dto);
		log.info("PathVariable : " + coffee_number);
		log.info("CoffeeDTO : " + dto);
		log.info("numberGeter : " + dto.getCoffee_number());
		
		return ResponseEntity.ok("String Type");
	}
	
	
}
