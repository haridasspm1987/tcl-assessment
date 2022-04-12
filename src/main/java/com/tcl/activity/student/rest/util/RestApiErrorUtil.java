package com.tcl.activity.student.rest.util;

import com.tcl.activity.student.rest.exception.RestServiceException;

public class RestApiErrorUtil {

	public static RestApiError createRestApiError(RestServiceException e) {
		RestApiError apiError = new RestApiError();
		apiError.setCode(e.getCode());
		apiError.setMessage(e.getMessage());
		return apiError;
	}
}
