package org.liferay4you.local.service.impl;

import org.liferay4you.local.service.PermissionLocalService;
import org.liferay4you.model.Permission;
import org.liferay4you.model.id.PermissionId;
import org.liferay4you.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionLocalServiceImpl implements PermissionLocalService{
	

	/* *******************************
	 ******* Implementation **********
	 ****************************** */
	
	@Override
	public Permission updatePermission(Permission entry) {
		return prePermissionRepository.save(entry);
	}

	@Override
	public Permission findById(PermissionId id) {
		return prePermissionRepository.findOne(id);
	}
	
	/* *******************************
	 ******** Repositories ***********
	 ****************************** */
	
	PermissionRepository prePermissionRepository;
	
	/* *******************************
	 ********* Constructor ***********
	 ****************************** */
	
	@Autowired
	public PermissionLocalServiceImpl(PermissionRepository prePermissionRepository) {
		this.prePermissionRepository = prePermissionRepository;
	}
	
}
