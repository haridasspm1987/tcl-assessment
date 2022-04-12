package com.tcl.activity.student.rest.exception;

import com.tcl.activity.student.rest.util.SystemCode;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode(callSuper = false)
public class RestServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1223419051811061524L;

	private String code;

	protected String systemCodeClass;
	
	private boolean propagate;
	
	private Object[] messageArguments;

	private boolean rollback = true;

	public RestServiceException(RestServiceException e) {
		this(e.getCode(), e.getMessage(), e.isRollback());
		if (e.getSystemCodeClass() != null) {
			this.systemCodeClass = e.getSystemCodeClass();
		}
	}

	@Deprecated
	public RestServiceException(String code, String message, boolean rollback) {
		super(message);
		this.code = code;
		this.rollback = rollback;
	}

	@Deprecated
	public RestServiceException(String code, String message) {
		super(message);
		this.code = code;
	}

	public RestServiceException(SystemCode systemCode, String message) {
		this(systemCode.getCode(), message != null ? message : systemCode.getDefault());
		if (systemCode != null) {
			this.systemCodeClass = systemCode.getClass().getName();
			log.debug("[CONSTRUCTOR RestServiceException-SystemCode-String] systemCodeClass = " + systemCodeClass);
		}
	}

	public RestServiceException(SystemCode systemCode, String message, boolean rollback) {
		this(systemCode.getCode(), message != null ? message : systemCode.getDefault());
		if (systemCode != null) {
			this.systemCodeClass = systemCode.getClass().getName();
			log.debug("[CONSTRUCTOR RestServiceException-SystemCode-String] systemCodeClass = " + systemCodeClass
					+ ", rollback = " + rollback);
		}
		this.rollback = rollback;
	}

	public RestServiceException(SystemCode systemCode) {
		this(systemCode.getCode(), systemCode.getDefault());
		if (systemCode != null) {
			this.systemCodeClass = systemCode.getClass().getName();
			log.debug("[CONSTRUCTOR RestServiceException-SystemCode] systemCodeClass = " + systemCodeClass);
		}
	}

	public RestServiceException(SystemCode systemCode, boolean rollback) {
		this(systemCode.getCode(), systemCode.getDefault());
		if (systemCode != null) {
			this.systemCodeClass = systemCode.getClass().getName();
			log.debug("[CONSTRUCTOR RestServiceException-SystemCode] systemCodeClass = " + systemCodeClass
					+ ", rollback = " + rollback);
		}
		this.rollback = rollback;
	}

}
