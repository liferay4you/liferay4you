package org.liferay4you.repository;

import java.util.List;

import org.liferay4you.model.Permission;
import org.liferay4you.model.id.PermissionId;
import org.springframework.data.repository.CrudRepository;


public interface PermissionRepository extends CrudRepository<Permission, PermissionId>{

	List<Permission> findByActionAndTypeLike(String action, int type);
	
	List<Permission> findByType(int type);
}
