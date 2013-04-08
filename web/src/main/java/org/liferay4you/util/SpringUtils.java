package org.liferay4you.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class with util methods to improve Spring integration
 * @author Yaden
 */
public class SpringUtils {

	private static Log log = LogFactory.getLog(SpringUtils.class);
	
	/**
	 * Model and Vie factory
	 * @param jspPath
	 * @param viewName
	 * @param viewObject
	 * @return
	 */
	public static ModelAndView createMv(String jspPath, String viewName, String viewObject) {
		return new ModelAndView(jspPath, viewName, viewObject);
	}

	/**
	 * Makes an HTTP 301 redirection
	 * @param response
	 * @param path
	 */
	public static void sendRedirect(HttpServletResponse response, String path) {
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader(Constants.LOCATION, path);
	}

	/**
	 * Sends an error HTTP 403 : Forbidden
	 * @param response
	 */
	public static void sendError(HttpServletResponse response) {
		try {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		} catch (IOException e) {
			log.error(e);
		}
	}

	/**
	 * Sends an error HTTP 403 : Forbidden with a message
	 * @param response
	 */
	public static void sendError(HttpServletResponse response, String message) {
		try {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, message);
		} catch (IOException e) {
			log.error(e);
		}
	}
	
}
