package com.ezen.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springmvc.model.Coffee;
import com.ezen.springmvc.model.Cook;
import com.ezen.springmvc.model.Department;

import commons.Calculator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	private static Logger log = LogManager.getLogger(HomeController.class);

	@Autowired
	Cook cook;

	@Autowired
	Calculator calculator;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Department dept = new Department();
		Coffee coffee = new Coffee();

		log.info(dept);
		log.info(coffee);

		// @NonNull 필드에 null을 넣으려는 경우 익셉션 발생
		coffee.getCoffee_id();
		try {
			coffee.setCoffee_id(null);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		int a = calculator.diff(1, 2);
		log.fatal("Welcome to HomeCotroller ㅇㅅㅇ/");
		log.error("Welcome to HomeCotroller ㅇㅅㅇ/");
		log.warn("Welcome to HomeCotroller ㅇㅅㅇ/");
		log.info("Welcome to HomeCotroller ㅇㅅㅇ/");
		log.debug("Welcome to HomeCotroller ㅇㅅㅇ/");
		log.trace("Welcome to HomeCotroller ㅇㅅㅇ/");

//		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("cook", cook);

		System.out.println(cook);

		return "home";
	}

}
