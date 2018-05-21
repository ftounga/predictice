package com.tounga.predictice.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tounga.predictice.bean.ErrorResponse;
import com.tounga.predictice.enumeration.BusinessErrorCode;

@ControllerAdvice
public class PredicticeControllerAdvice {

	@Autowired
	private Environment env;
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex){
		
		ErrorResponse error = new ErrorResponse();
		error.setCode(ex.getBusinessCode().getCode());
		error.setStatus(ex.getStatus().value());
		error.setMessage(env.getProperty(ex.getBusinessCode().getLabel()));
		ResponseEntity<ErrorResponse> response = new ResponseEntity<ErrorResponse>(error,ex.getStatus());
		return response;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleOtherException(Exception ex){
		
		ErrorResponse error = new ErrorResponse();
		error.setCode(BusinessErrorCode.TECHNICAL_ERROR.getCode());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		ResponseEntity<ErrorResponse> response = new ResponseEntity<ErrorResponse>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}
}
