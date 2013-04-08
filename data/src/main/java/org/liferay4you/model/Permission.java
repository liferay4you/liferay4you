package org.liferay4you.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.liferay4you.model.id.PermissionId;

@Entity
@Table(name = "PERMISSION")
@IdClass(PermissionId.class)
public class Permission {

	/* *******************************
	 ******** Table Fields ***********
	 ****************************** */
	
	@Id
	@Column(name = "ACTION", length = 64)
	private String action;
	
	@Id
	@Column(name = "TYPE")
	private int type;
	
	@Column(name = "IS_PUBLIC")
	private boolean isPublic;

	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */

	public String getAction() { return action; }
	public void setAction(String action) { this.action = action; }

	public int getType() { return type; }
	public void setType(int type) { this.type = type; }

	public boolean isPublic() { return isPublic; }
	public void setPublic(boolean isPublic) { this.isPublic = isPublic; }
	
	/* *******************************
	 ************ toString() *********
	 ******************************* */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n__________PERMISSION__________\n");
		sb.append("action: " + action + "\n");
		sb.append("type: " + type + "\n");
		sb.append("isPublic: " + isPublic + "\n");
		
		
		return sb.toString();
	}
	
}
