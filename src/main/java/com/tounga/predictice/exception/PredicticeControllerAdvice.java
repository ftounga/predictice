package com.tounga.predictice.exception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tounga.predictice.bean.ErrorResponse;
import com.tounga.predictice.dto.ValidationErrorDTO;
import com.tounga.predictice.enumeration.BusinessErrorCode;

@ControllerAdvice
public class PredicticeControllerAdvice {

	@Autowired
	private Environment env;

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {

		ErrorResponse error = new ErrorResponse();
		error.setCode(ex.getBusinessCode().getCode());
		error.setStatus(ex.getStatus().value());
		error.setMessage(env.getProperty(ex.getBusinessCode().getLabel()));
		ResponseEntity<ErrorResponse> response = new ResponseEntity<ErrorResponse>(error, ex.getStatus());
		return response;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleOtherException(Exception ex) {

		ex.printStackTrace();
		ErrorResponse error = new ErrorResponse();
		error.setCode(BusinessErrorCode.TECHNICAL_ERROR.getCode());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		ResponseEntity<ErrorResponse> response = new ResponseEntity<ErrorResponse>(error,
				HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorDTO processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		return processFieldErrors(fieldErrors);
	}

	private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
		ValidationErrorDTO dto = new ValidationErrorDTO();

		for (FieldError fieldError : fieldErrors) {
			dto.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return dto;
	}
}
