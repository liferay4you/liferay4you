package org.liferay4you.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.liferay4you.form.CreateAccountForm;
import org.liferay4you.form.LoginForm;
import org.liferay4you.helper.CredentialsControllerHelper;
import org.liferay4you.local.service.UserLocalService;
import org.liferay4you.util.Constants;
import org.liferay4you.util.Mappings;
import org.liferay4you.util.SpringUtils;
import org.liferay4you.view.CreateAccountView;
import org.liferay4you.view.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CredentialsController {
	
	/* *******************************************************
	 * ******************** Login : /login ******************* 
	 * *******************************************************/
	
	@RequestMapping(value = Mappings.LOGIN, method = RequestMethod.GET)  
	public ModelAndView viewLogin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("GET");
		LoginView view = CredentialsControllerHelper.createLoginView(null, null, request);
		
		return SpringUtils.createMv(Constants.JSP_LOGIN, Constants.VIEW, view);
	}
	
	@RequestMapping(value = Mappings.LOGIN, method = RequestMethod.POST)  
	public ModelAndView processLogin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("POST");
		LoginForm form = CredentialsControllerHelper.processLoginForm(request, userLocalService);
		LoginView view = CredentialsControllerHelper.createLoginView(form, userLocalService, request);
		
		return SpringUtils.createMv(Constants.JSP_LOGIN, Constants.VIEW, view);
	}
	
	/* *******************************************************
	 * *********** Create account : /create-account **********
	 * *******************************************************/
	
	@RequestMapping(value = Mappings.CREATE_ACCOUNT, method = RequestMethod.GET)  
	public ModelAndView viewCreate(HttpServletRequest request, HttpServletResponse response) {
		
		CreateAccountView view = CredentialsControllerHelper.createCreateAccountView(null, null);
		
		return SpringUtils.createMv(Constants.JSP_CREATE_ACCOUNT, Constants.VIEW, view);
	}
	
	@RequestMapping(value = Mappings.CREATE_ACCOUNT, method = RequestMethod.POST)  
	public ModelAndView processCreate(HttpServletRequest request, HttpServletResponse response) {
		
		CreateAccountForm form = CredentialsControllerHelper.processCreateAccountForm(request);
		CreateAccountView view = CredentialsControllerHelper.createCreateAccountView(form, userLocalService);
		
		return SpringUtils.createMv(Constants.JSP_CREATE_ACCOUNT, Constants.VIEW, view);
	}
	
	
	/* *******************************
	 ******* Injected objects ********
	 ****************************** */
	
	@Autowired
	UserLocalService userLocalService;
	
}
