package org.liferay4you.form;

public class CreateAccountForm extends AbstractForm{
	
	/* *******************************
	 ********* Form Fields ***********
	 ****************************** */
	
	private String userMail;
	private String password;
	private String passwordRepeat;
	
	/* *******************************
	 ********* Form Names ************
	 ****************************** */
	
	public static final String USER_MAIL = "create-account.usermail";
	public static final String USER_PASSWORD = "create-account.password";
	public static final String USER_PASSWORD_REPEAT = "create-account.password-repeat";
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public String getUserMail() { return userMail; }
	public void setUserMail(String userMail) { this.userMail = userMail; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public String getPasswordRepeat() { return passwordRepeat; }
	public void setPasswordRepeat(String passwordRepeat) { this.passwordRepeat = passwordRepeat; }
	
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
