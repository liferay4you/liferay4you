package org.liferay4you.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.liferay4you.util.Constants;
import org.liferay4you.util.Mappings;
import org.liferay4you.util.SpringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	/* *******************************************************
	 * ********************** Home : "/" *********************
	 * *******************************************************/
	@RequestMapping(value = Mappings.HOME, method = RequestMethod.GET)  
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		
//		ApplicationContext  ctx = new FileSystemXmlApplicationContext("classpath:META-INF/application-context.xml");
		
		return SpringUtils.createMv(Constants.JSP_HOME, "text", new String("TESTTtTing!!!"));
	}
	
	
}
