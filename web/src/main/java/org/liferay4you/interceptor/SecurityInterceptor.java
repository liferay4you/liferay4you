package org.liferay4you.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.liferay4you.constant.PermissionConstants;
import org.liferay4you.local.service.PermissionLocalService;
import org.liferay4you.model.Permission;
import org.liferay4you.util.Mappings;
import org.liferay4you.util.SpringUtils;
import org.liferay4you.util.StringPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityInterceptor implements HandlerInterceptor{

	/* *******************************************************
	 * ********************** Pre Handle *********************
	 * *******************************************************/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String requestUri = request.getRequestURI();
		
		// We don't want to check the resources
		if (!requestUri.startsWith(Mappings.RESURCE)) {
			
			List<Permission> mappingPermissions = permissionLocalService.findByType(PermissionConstants.TYPE_MAPPING);
			
			for (Permission permission : mappingPermissions) {
				if (checkPattern(requestUri, permission)) {
					// TODO
					// En un futuro se tiene que revisar que el usuario este entre
					// la lista de usuarios o entre los grupos con permisos
					SpringUtils.sendError(response);
					return false;
				}
			}
			
		}
		
		return true;
	}

	/* *******************************************************
	 * ********************* Post Handle *********************
	 * *******************************************************/
	@Override
	public void postHandle( HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		
	}
	
	/* *******************************************************
	 * ******************* After Completion ******************
	 * *******************************************************/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {
		
	}
	
	/* *******************************
	 ******* Private Methods *********
	 ****************************** */
	
	private boolean checkPattern(String requestUri, Permission permission) {
		
		String pattern = StringPool.CARET + permission.getAction();
		pattern = pattern.replace(StringPool.STAR, StringPool.PERIOD + StringPool.STAR);
		if (!pattern.endsWith(StringPool.STAR)) { pattern = pattern + StringPool.STAR; }
		
//		System.out.println("\n*****************\n" + requestUri + "\n"  + pattern +
//		"\n" + requestUri.matches(pattern) +"\n*****************\n");
		
		return requestUri.matches(pattern);
	}
	
	/* *******************************
	 ******** Repositories ***********
	 ****************************** */
	
	@Autowired
	PermissionLocalService permissionLocalService;
	
}
