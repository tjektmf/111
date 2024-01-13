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
	// /WEB-INF/views 이하에 /hello가 나오면 이 클래스로 연결됨 

	private static Logger log = LogManager.getLogger(HelloController.class);

	@RequestMapping("/index")
	String index(HttpServletRequest request, HttpServletResponse response) {
		// /WEB-INF/views/hello 이하에 /index가 나오면 이 메서드로 연결됨

		request.setAttribute("dept", new Department());

		// /WEB-INF/views 와 확장자 .jsp를 제외한 주소를 리턴하면 알맞은 뷰를 찾아감
		// servlet-context.xml에 관련 설정이 있음
		return "/////hello/index"; 
		// hello/index 이거도 되고
		// /hello/index 이거도 됨

	//	String 타입으로 리턴하면 앞에는 /WEB-INF/views/ 뒤에는 .jsp를 붙여줌 
	//	servlet-context.xml 에서 설정가능함
	//	<beans:property name="prefix" value="/WEB-INF/views/" />
	//	<beans:property name="suffix" value=".jsp" />
	}

	@RequestMapping(value = { "/hi", "/greetings" })
	String greetings() {
		// @RequestMapping에 배열 형식으로 value 값을 여러개 추가할 수 있음 
		// HelloController 클래스로 들어오는 URI가 /hello/ 임
		// /hello/hi or /hello/greetings 둘 다 이 메서드로 포워딩함

		return "//hello/greetings";
	}

	@RequestMapping(value = "/parameter", method = RequestMethod.GET)
	String paraForm() {
		// 확장자 jsp는 적지 않음
		// .jsp를 리턴값에 적으면 설정에 의해 
		// 실제로는 hello/parameter.jsp.jsp 의 주소로 포워딩이 되어 오류가 발생함
		// servlet-context.xml 에 리턴값 맨 뒤에 .jsp를 붙여주는 설정이 있음
		// 리턴에 / 많이써도 한개쓴거로 바꿔주는 메서드가 오버라이드 되어 있는듯
		return "//////////hello/parameter";
	}

	@RequestMapping(value = "/parameter", method = RequestMethod.POST)
	String para(DepartMont dept) {
		// 매개변수는 model 패키지에 들어있는 클래스임
		// 같은 value 라도 get post에 따라 다른 메서드로 포워딩됨
		// 폼으로 이동하는 메서드는 get 형식으로 사용하고 메서드 이름에 폼을 붙이고
		// 폼을 통해 정보를 보내는건 post로 메서드 이름에 폼을 제외하는게 일반적인 형식인듯
		// request.getParameter()를 하지 않았는데 그냥 다해줌
		// request.setAttribute()로 추가하지 않아도 저절로 됨
		log.info(dept);
		log.info("이젠 sysout 대신 로그를 활용");
		return "hello/paraResult";
	}

	@RequestMapping(value = "/para2", method = RequestMethod.POST)
	String para2(Integer employee_id) {
		// 그냥 주소값에 para2를 치고 들어가면 get 방식이라 "Request method 'GET' not supported" 오류 발생
		// "요청 행에 포함된 해당 메소드는, origin 서버에 의해 인지되었으나, 대상 리소스에 의해 지원되지 않습니다." 오류 발생
		// 폼 태그의 서밋을 통한 데이터 전달은 포스트로 하는게 일반적인듯
		// 대충 콘솔값만 찍어보려고 만든거임 리턴되는 주소값의 jsp 파일이 없음
		// null이 안나옴 jsp에서의 name과 같아서 자동으로 바인딩해줌
		// get.parameter()로 값을 불러오면 String 타입이지만 integer로 바꿔줌
		// 폼에 보낸 input tag's name이 employee_id로 이 메서드의 매개변수와 같기 때문에 자동 바인딩됨
		// 로그로 찍어보면 매개변수가 바로 나오는걸 알 수 있음
		// 원래같으면 매개변수를 request로 받아서
		// int employee_id = Integer.parseInt(request.getparameter("employee_id"));
		// 이런 형식으로 써야 출력이 가능했음
		log.info("employee_id : " + employee_id);
		return "//////////hello/result2";
	}

	@RequestMapping(value = "/para3", method = RequestMethod.POST)
	String para3(@ModelAttribute("employee_id") Integer emp_id) {
		// @ModelAttribute 을 활용하면 다른 이름으로 바인딩이 가능하지만 대체로 사용하지 않음 굳이?
		// 이건 ㄹㅇ 무쓸모
		log.info("employee_id : " + emp_id);
		return "//////////hello/result3";
		// String 의 리턴값은 앞에 /WEB-INF/views/ 이걸 붙이고 뒤에는 .jsp 를 붙여줌
		// 파일간 경로를 구성하는 / 는 실수로 두개치고 이런거를 어느정도 보정해주는듯
		// 바로 위 리턴값도 문제없이 포워딩됨
	}
	
	@RequestMapping(value="/cookie/")
	String cookieIndex() {
		return "hello/cookie/index";
		// 헬로컨트롤러 클래스 자체가 /hello 를 가져오는 서블릿이라 
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
