package org.liferay4you.model.id;

import java.io.Serializable;

public class PermissionId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/* *******************************
	 ****** Table Fields Ids *********
	 ****************************** */
	private String action;
	private int type;
	
	/* *******************************
	 ********** Constructors *********
	 ******************************* */
	
	public PermissionId() {}
	
	public PermissionId(String action, int type) {
		this.action = action;
		this.type = type;
	}
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public String getAction() { return action; }
	public void setAction(String action) { this.action = action; }
	
	public int getType() { return type; }
	public void setType(int type) { this.type = type; }
	
}
