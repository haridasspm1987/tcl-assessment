package com.tcl.activity.student.rest.util;

public interface SystemCode {

	default String getCode() {
		return this.toString();
	}

	abstract String getDefault();

}
