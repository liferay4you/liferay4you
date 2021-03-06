package org.liferay4you.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	/* *******************************
	 ******** Table Fields ***********
	 ****************************** */
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "USER_NAME", length = 32, unique = true)
	private String userName;
	
	@Column(name = "USER_MAIL", length = 64, unique = true)
	private String mail;

	@Column(name = "USER_PSSW", length = 60)
	private String password;

	@Column(name = "IS_ADMIN")
	private boolean admin;
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public long getUserId() { return userId; }
	public void setUserId(long userId) { this.userId = userId; }

	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }

	public String getMail() { return mail; }
	public void setMail(String mail) { this.mail = mail; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public boolean isAdmin() { return admin; }
	public void setAdmin(boolean admin) { this.admin = admin; }
	
	/* *******************************
	 ************ toString() *********
	 ******************************* */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n__________USER__________\n");
		sb.append("userId: " + userId + "\n");
		sb.append("userName: " + userName + "\n");
		sb.append("mail: " + mail + "\n");
		sb.append("isAdmin: " + admin + "\n");
		
		return sb.toString();
	}
	
}
