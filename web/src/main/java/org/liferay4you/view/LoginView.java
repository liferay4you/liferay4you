package org.liferay4you.view;

public class LoginView {
	
	/* *******************************
	 ********* View fields ***********
	 ****************************** */
	
	private int type;
	private String message;
	
	/* *******************************
	 ******* Public Constants ********
	 ****************************** */
	
	public static int TYPE_NEW = 0;
	public static int TYPE_SUCCES = 1;
	public static int TYPE_FAIL = 2;
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public int getType() { return type; }
	public void setType(int type) { this.type = type; }
	
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	
	/* *******************************
	 ************ toString() *********
	 ******************************* */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n__________LoginView__________\n");
		sb.append("type: " + type + "\n");
		sb.append("message: " + message + "\n");
		
		return sb.toString();
	}
	
}
