package org.liferay4you.helper;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.liferay4you.form.CreateAccountForm;
import org.liferay4you.form.LoginForm;
import org.liferay4you.local.service.UserLocalService;
import org.liferay4you.model.User;
import org.liferay4you.util.Constants;
import org.liferay4you.util.ParamUtil;
import org.liferay4you.util.StringPool;
import org.liferay4you.util.Validator;
import org.liferay4you.view.CreateAccountView;
import org.liferay4you.view.LoginView;

public class CredentialsControllerHelper {

	private static Log log = LogFactory.getLog(CredentialsControllerHelper.class);
	
	/* *******************************
	 ******** Public Methods *********
	 ****************************** */
	
	/**
	 * ### Create account ###
	 * 
	 * Fills the form with the parameters from the request and validates it
	 * @param request
	 * @return
	 */
	public static CreateAccountForm processCreateAccountForm(HttpServletRequest request) {
		CreateAccountForm form = new CreateAccountForm();
		form.setValidated(false);
		
		try {
			
			// Retrieving values
			
			String userMail = ParamUtil.getString(
					request, CreateAccountForm.USER_MAIL, StringPool.BLANK);
			
			String password = ParamUtil.getString(
					request, CreateAccountForm.USER_PASSWORD, StringPool.BLANK);
			
			String passwordRepeated = ParamUtil.getString(
					request, CreateAccountForm.USER_PASSWORD_REPEAT, StringPool.BLANK);
			
			// Filling the bean
			
			form.setUserMail(userMail);
			form.setPassword(password);
			form.setPasswordRepeat(passwordRepeated);
			form.setValidated(validateCreateAccountForm(form));
			
		} catch (Exception e) {
			log.error("Error on processCreateAccountForm(HttpServletRequest request)", e);
		}
		
		return form;
	}
	
	/**
	 * ### Create account ###
	 * 
	 * Checks the form is correctly filled
	 * @param form
	 * @return
	 */
	public static boolean validateCreateAccountForm(CreateAccountForm form) {
		boolean validated = true;
		
		if (Validator.equals(form.getUserMail(), StringPool.BLANK)) { return false; }
		if (Validator.equals(form.getPassword(), StringPool.BLANK)) { return false; }
		if (Validator.equals(form.getPasswordRepeat(), StringPool.BLANK)) { return false; }
		// !Important to check both passwords are the same
		if (!Validator.equals(form.getPassword(), form.getPasswordRepeat())) { return false; }
		
		return validated;
	}

	/**
	 * ### Create account ###
	 * 
	 * Fills the CreateAccountView object with the info from the object -form-
	 * @param form
	 * @param userLocalService
	 * @return
	 */
	public static CreateAccountView createCreateAccountView(CreateAccountForm form, UserLocalService userLocalService) {
		CreateAccountView view = new CreateAccountView();
		
		// Normal view
		if (form == null) {
			view.setType(CreateAccountView.TYPE_NEW);
			return view;
		}
		
		// form submitted
		if (form.isValidated()) {
			try {
				
				boolean exists = userLocalService.existsUserMail(form.getUserMail());
				if (exists) {
					view.setType(CreateAccountView.TYPE_FAIL);
					view.setMessage("-FAIL- The user is already created");
				}
				else {
					User user = new User();
					user.setMail(form.getUserMail());
					user.setPassword(form.getPassword());
					userLocalService.updatePassword(user, user.getPassword());
					
					view.setType(CreateAccountView.TYPE_SUCCES);
					view.setMessage("-SUCCES- Your account has been created succesfully");
				}
				
			} catch (Exception e) {
				log.error("Error while cheking user info", e);
				view.setType(CreateAccountView.TYPE_FAIL);
				view.setMessage("-FAIL- There's been a error, please try again");
			}
		}
		else {
			view.setType(CreateAccountView.TYPE_FAIL);
			view.setMessage("-FAIL- The form is not correcty filled");
		}
		return view;
	}
	
	/**
	 * ### Login ###
	 * 
	 * Fills the form with the parameters from the request and validates it
	 * @param request
	 * @return
	 */
	public static LoginForm processLoginForm(HttpServletRequest request, UserLocalService userLocalService) {
		LoginForm form = new LoginForm();
		form.setValidated(false);
		
		try {
			
			// Retrieving values
			
			String userMail = ParamUtil.getString(
					request, LoginForm.USER_MAIL, StringPool.BLANK);
			
			String password = ParamUtil.getString(
					request, LoginForm.USER_PASSWORD, StringPool.BLANK);
			
			// Filling the bean
			
			form.setUserMail(userMail);
			form.setPassword(password);
			form.setValidated(validateLoginForm(form, userLocalService));
			
		} catch (Exception e) {
			log.error("Error on processLoginForm(HttpServletRequest request," +
					" UserLocalService userLocalService)", e);
		}
		
		return form;
	}
	
	/**
	 * ### Login ###
	 * 
	 * Checks the form is correctly filled
	 * @param form
	 * @param userLocalService 
	 * @return
	 */
	public static boolean validateLoginForm(LoginForm form, UserLocalService userLocalService) {
		boolean validated = true;
		
		if (Validator.equals(form.getUserMail(), StringPool.BLANK)) { return false; }
		if (Validator.equals(form.getPassword(), StringPool.BLANK)) { return false; }
		// !Important to check both passwords are the same
		if (!userLocalService.checkPssw(form.getUserMail(), form.getPassword())) { return false; }
		
		return validated;
	}

	/**
	 * ### Login ###
	 * 
	 * Fills the CreateAccountView object with the info from the object -form-
	 * @param form
	 * @param userLocalService
	 * @return
	 */
	public static LoginView createLoginView(LoginForm form, UserLocalService userLocalService, HttpServletRequest request) {
		LoginView view = new LoginView();
		
		// Normal view
		if (form == null) {
			view.setType(CreateAccountView.TYPE_NEW);
			return view;
		}
		
		// form submitted
		if (form.isValidated()) {
			try {
				
				boolean exists = userLocalService.existsUserMail(form.getUserMail());
				if (!exists) {
					view.setType(CreateAccountView.TYPE_FAIL);
					view.setMessage("-FAIL- The user does not exists");
				}
				else {
					User user = userLocalService.loginUser(form.getUserMail());
					request.getServletContext().setAttribute(Constants.SESSION_USER, user);
					view.setType(CreateAccountView.TYPE_SUCCES);
					view.setMessage("-SUCCES- You have logged in");
				}
				
			} catch (Exception e) {
				log.error("Error while cheking user info", e);
				view.setType(CreateAccountView.TYPE_FAIL);
				view.setMessage("-FAIL- There's been a error, please try again");
			}
		}
		else {
			view.setType(CreateAccountView.TYPE_FAIL);
			view.setMessage("-FAIL- User mail or password are wrong");
		}
		return view;
	}
	
}
