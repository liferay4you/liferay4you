package org.liferay4you.local.service;

import org.liferay4you.model.Permission;
import org.liferay4you.model.id.PermissionId;

/**
 * Implements Permission Repository in a static way
 * @author vass
 */
public interface PermissionLocalService {
	
	/**
	 * Updates or creates a new permission
	 * @param entry
	 * @return
	 */
	public Permission updatePermission(Permission entry);
	
	/**
	 * Tries to find a permission by its id, if no value is found then null is returned
	 * @param id
	 * @return
	 */
	public Permission findById(PermissionId id);
	
}
