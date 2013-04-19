package org.liferay4you.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


@SuppressWarnings(value = {"rawtypes", "unchecked"})
public abstract class BeanToString<T extends Object> {

	/* *******************************
	 ****** Overridden toString ******
	 ******************************* */
	
	@Override
	public String toString() {
		
		Class clazz =  getClass();
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {

			String fieldName = upperCaseFirstLetter(field.getName());
			
			System.out.println(fieldName + " : " + getFieldValue(clazz, field, this));
			
		}
		
		return clazz.toString();
	}
	
	/* *******************************
	 ******** Private methods ********
	 ******************************* */
	
	/**
	 * Uppercases first letter 
	 * @param s
	 * @return
	 */
	private static String upperCaseFirstLetter(String s) {
		return s.substring(0,1).toUpperCase() + s.substring(1);
	}
	
	/**
	 * Checks if the class is Boolean or boolean
	 * @param clazz
	 * @return
	 */
	private static boolean isBoolean(Class clazz) {
		return (clazz.equals(Boolean.class) || clazz.equals(boolean.class)) ? true : false;
	}
	
	/**
	 * Checks the method name exists in the given class
	 * @param methodName
	 * @param clazz
	 * @return
	 */
	private static Method checkMethod(String methodName, Class clazz) {
		try {
			return clazz.getMethod(methodName);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Gets the field value given its class, the desired field and an instance
	 * @param clazz
	 * @param field
	 * @param obj
	 * @return
	 */
	private static String getFieldValue(Class clazz, Field field, Object obj) {
		String fieldValue = null;
		
		try {
			
			String fieldName = upperCaseFirstLetter(field.getName());
			
			if (isBoolean(field.getType())) {
				Method fieldGetter = checkMethod(IS + fieldName, clazz); 
				if (fieldGetter == null) {
					fieldGetter = checkMethod(GET + fieldName, clazz);
				}
				Object returnObj = fieldGetter.invoke(obj);
				return (returnObj == null) ? NULL : returnObj.toString();
			}
			else {
				Method fieldGetter = clazz.getDeclaredMethod(GET + fieldName);
				Object returnObj = fieldGetter.invoke(obj);
				return (returnObj == null) ? NULL : returnObj.toString();
			}
		} catch (Exception e) {
			fieldValue = NO_GETTER;
		}
		
		return fieldValue;
	}
	
	/* *******************************
	 ******* Private Constants *******
	 ******************************* */
	
	private static final String GET = "get";
	private static final String IS = "is";
	private static final String NULL = "null";
	private static final String NO_GETTER = "No getter defined";
}
