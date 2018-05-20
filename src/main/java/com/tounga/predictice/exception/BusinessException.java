package com.tounga.predictice.exception;

import org.springframework.http.HttpStatus;

import com.tounga.predictice.enumeration.BusinessErrorCode;

public class BusinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BusinessErrorCode businessCode;
	private HttpStatus status;
	
	public BusinessException(BusinessErrorCode errorCode, HttpStatus status) {
		super();
		this.businessCode = errorCode;
		this.status= status;			
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BusinessErrorCode getBusinessCode() {
		return businessCode;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
}
