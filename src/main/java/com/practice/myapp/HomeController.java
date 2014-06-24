package com.practice.myapp;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.user.dao.GradeDao;
import springbook.user.domain.Grade;
import springbook.user.process.GradeProcess;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private GradeProcess gradeProcess;
	private GradeDao gradeDao;
	
	public void setGradeProcess(GradeProcess gradeProcess){
		this.gradeProcess = gradeProcess;
	}
	public void setGradeDao(GradeDao gradeDao){
		this.gradeDao = gradeDao;
	}
	
	@RequestMapping(value = "/gradeMain", method = RequestMethod.GET)
	public String gradeMain(Locale locale, Model model) throws ClassNotFoundException, SQLException{
		List<Grade> list = new ArrayList<Grade>();
		list = this.gradeDao.getStudent();
		
		model.addAttribute("list", list);
		
		return "gradeMain";
	}
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
