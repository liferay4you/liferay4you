package org.liferay4you.form;

public class LoginForm extends AbstractForm{

	/* *******************************
	 ********* Form Fields ***********
	 ****************************** */
	
	private String userMail;
	private String password;
	
	/* *******************************
	 ********* Form Names ************
	 ****************************** */
	
	public static final String USER_MAIL = "login.usermail";
	public static final String USER_PASSWORD = "login.password";
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public String getUserMail() { return userMail; }
	public void setUserMail(String userMail) { this.userMail = userMail; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	/* *******************************
	 ************ toString() *********
	 ******************************* */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n__________LoginForm__________\n");
		sb.append("userMail: " + userMail + "\n");
		
		return sb.toString();
	}
	
}
