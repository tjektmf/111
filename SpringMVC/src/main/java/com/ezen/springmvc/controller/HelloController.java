package com.ezen.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.springmvc.model.DepartMont;
import com.ezen.springmvc.model.Department;

@RequestMapping("/hello")
@Controller
public class HelloController {

	private static Logger log = LogManager.getLogger(HelloController.class);

	@RequestMapping("/index")
	String index(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("dept", new Department());

		// /WEB-INF/views 와 확장자 .jsp를 제외한 주소를 리턴하면 알맞은 뷰를 찾아감
		// servlet-context,xml에 관련 설정이 있음
		return "hello/index";
	}

	@RequestMapping(value = { "/hi", "/greetings" })
	String greetings() {

		// 메서드의 매개변수를 굳이굳이 넣지않아도 필요하면 다 가져와서 쓰도록 오버라이드 되어있음
		return "//hello/greetings";
	}

	@RequestMapping(value = "/parameter", method = RequestMethod.GET)
	String paraForm() {
		// 확장자 jsp는 적지 않음
		return "//////////hello/parameter";
	}

	@RequestMapping(value = "/parameter", method = RequestMethod.POST)
	String para(DepartMont dept) {

		// request.getParameter()를 하지 않았는데 그냥 다해줌
		// request.setAttribute()로 추가하지 않아도 저절로 됨
		log.info(dept);
		return "hello/paraResult";
	}

	@RequestMapping(value = "/para2", method = RequestMethod.POST)
	String para2(Integer employee_id) {
		// null이 안나옴 jsp에서의 name과 같아서 자동으로 바인딩해줌
		// get.parameter()로 값을 불러오면 String 타입이지만 integer로 바꿔줌
		log.info("employee_id : " + employee_id);
		return "//////////hello/result2";
	}

	@RequestMapping(value = "/para3", method = RequestMethod.POST)
	String para3(@ModelAttribute("employee_id") Integer emp_id) {
		// @ModelAttribute 을 활용하면 다른 이름으로 바인딩이 가능하지만 대체로 사용하지 않음 굳이?
		log.info("employee_id : " + emp_id);
		return "//////////hello/result3";
	}
	
	@RequestMapping(value="/cookie/")
	String cookieIndex() {
		return "hello/cookie/index";
	}
	
	@RequestMapping(value ="/cookie/set")
	String setCookie(HttpServletResponse response) {
		// 쿠키는 문자열로 저장
		Cookie cookie = new Cookie("age", "10");
		response.addCookie(cookie);
		response.addCookie(new Cookie("a2", "22"));
		response.addCookie(new Cookie("a3", "44"));
		response.addCookie(new Cookie("a4", "ㄴㄴ"));
		// Origin 서버가 대상 리소스를 위한 현재의 representation을 찾지 못했거나, 
		// 그것이 존재하는지를 밝히려 하지 않습니다.
		// 이런 오류가 나오면 경로를 확인해야함
		return "redirect:/hello/cookie/";
	}
	
	@RequestMapping(value="/cookie/check")
	String checkCookie(@CookieValue Integer age, @CookieValue String a2,@CookieValue String a3,@CookieValue String a4) {
		log.info("age : " + age);
		log.info("a2 : " + a2);
		log.info("a3 : " + a3);
		log.info("a4 : " + a4);
		return "redirect:/hello/cookie/";
	}
	
	@RequestMapping("/return/void")
	void returnPage() {
		// /WEB-INF/views/hello/return/void.jsp를 찾아감
		// @RequestMapping("/hello") 이 컨트롤러 클래스 자체가 hello를 따라가므로 이건 기본으로 따라가고
		// @RequestMapping("/return/void")를 그대로 따라감
	}
	
	// Model : request가 가진 기능이 많아서 이 기능 중에 하나인 어트리뷰트를 전달하는 역할을 함
	// ModelAndView : 어트리뷰트를 전달하는 역할과 다음페이지로 가는 역할을 둘 다 가진 객체
	@RequestMapping("/return/mnv")
	ModelAndView returnPage2() {
		ModelAndView mnv = new ModelAndView();
		
		// Model의 어트리뷰트를 전달하는 역할
		mnv.addObject("dept", new Department());
		
		// String의 다음페이지로 가는 다음 뷰로 가는 역할
		mnv.setViewName("hello/return/mnv");
		
		return mnv;
	}
	
}
