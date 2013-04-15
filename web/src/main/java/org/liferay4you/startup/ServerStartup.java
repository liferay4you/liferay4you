package org.liferay4you.startup;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.liferay4you.local.service.PermissionLocalService;
import org.liferay4you.model.Permission;
import org.liferay4you.model.id.PermissionId;
import org.liferay4you.util.PermissionTypes;
import org.springframework.beans.factory.annotation.Autowired;

public class ServerStartup {

	private static Logger log = Logger.getLogger(ServerStartup.class);
	
	@Autowired
	PermissionLocalService permissionLocalService;
	
	/**
	 * This code gets executed when context is loaded
	 * @return 
	 */
	@PostConstruct
	public void start() {
		
		PermissionId permissionId = new PermissionId("/control-panel/", PermissionTypes.PAGE);
		
		Permission controlPanelPermission = permissionLocalService.findById(permissionId);

		if (controlPanelPermission == null) {
			
			controlPanelPermission = new Permission();
			controlPanelPermission.setAction(permissionId.getAction());
			controlPanelPermission.setType(permissionId.getType());
			controlPanelPermission.setPublic(false);
			
			permissionLocalService.updatePermission(controlPanelPermission);
			
			log.info("Control Panel permission has been added");
		}
		else {
			log.info("Control Panel permission was correctly created");
		}
		
	}

}
