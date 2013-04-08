package org.liferay4you.repository;

import org.liferay4you.model.Permission;
import org.liferay4you.model.id.PermissionId;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, PermissionId>{

}
