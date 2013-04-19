package org.liferay4you.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@ElementCollection(targetClass=Long.class, fetch = FetchType.EAGER)
	private List<Long> userIdList;
	
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */

	public String getAction() { return action; }
	public void setAction(String action) { this.action = action; }

	public int getType() { return type; }
	public void setType(int type) { this.type = type; }

	public boolean isPublic() { return isPublic; }
	public void setPublic(boolean isPublic) { this.isPublic = isPublic; }
	
	public List<Long> getUserIdList() { return userIdList; }
	public void setUserIdList(List<Long> userIdList) { this.userIdList = userIdList; }
	
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
		if (userIdList != null && userIdList.size() > 0) {
			sb.append("userIdList: [");
			for (Long l : userIdList) {
				sb.append(l + ",");
			}
			sb.deleteCharAt(sb.length() -1);
			sb.append("]\n");
		}
		else {
			sb.append("userIdList is NULL or empty\n");
		}
		
		
		return sb.toString();
	}
	
}
