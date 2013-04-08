package org.liferay4you.persistence;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.liferay4you.model.Permission;
import org.liferay4you.model.id.PermissionId;
import org.liferay4you.parent.DatabaseConectionTest;
import org.liferay4you.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;

public class PermissionRepositoryTest extends DatabaseConectionTest{

	@Autowired
	PermissionRepository permissionRepository;
	
	@Test(expected = JpaSystemException.class)
	public void primaryKeyExceptionTest() {
		Permission newPermission = new Permission();
		permissionRepository.save(newPermission);
	}
	
	
	@Test
	public void permissionTests() {
		
		String testString= String.valueOf(new Date().getTime());
		String actionName = "TestAction"+testString;
		int permissionType = 99;
		
		Permission permission = new Permission();
		permission.setAction(actionName);
		permission.setType(permissionType);
		permission.setPublic(true);
		
		Permission newPermission = permissionRepository.save(permission);
		
		assertEquals(actionName, newPermission.getAction());
		assertEquals(permissionType, newPermission.getType());
		assertTrue(permission.isPublic());
		
		PermissionId permissionId = new PermissionId(actionName, permissionType);
		newPermission = null;
		newPermission = permissionRepository.findOne(permissionId);
		
		assertNotNull(newPermission);
		
		permissionRepository.delete(newPermission);
		
	}
	
}
