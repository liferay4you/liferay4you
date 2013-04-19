package org.liferay4you.bean;

import java.util.List;

import org.liferay4you.util.BeanToString;

public class TestBean extends BeanToString<TestBean>{

	private String string1;
	
	private boolean boolean1;
	
	private List<Long> list1;

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public boolean getBoolean1() {
		return boolean1;
	}

	public void setBoolean1(boolean boolean1) {
		this.boolean1 = boolean1;
	}

	public List<Long> getList1() {
		return list1;
	}

	public void setList1(List<Long> list1) {
		this.list1 = list1;
	}
	
}
