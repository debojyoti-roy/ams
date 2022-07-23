package com.drps.ams.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.drps.ams.dto.ApiResponseEntity;
import com.drps.ams.util.ApiConstants;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidEmailException.class)
    public ApiResponseEntity handleInvalidEmailException(InvalidEmailException exception, WebRequest webRequest) {
    	ApiResponseEntity response = new ApiResponseEntity(ApiConstants.RESP_STATUS_INVALID_EMAIL_EXCEPTION, exception.getMessage());      
        return response;
    }
	
	@ExceptionHandler(NoRecordFoundException.class)
    public ApiResponseEntity handleNoRecordFoundException(NoRecordFoundException exception, WebRequest webRequest) {
    	ApiResponseEntity response = new ApiResponseEntity(ApiConstants.RESP_STATUS_NO_RECORD_FOUND_EXCEPTION, exception.getMessage());      
        return response;
    }
	
	@ExceptionHandler(RecordIdNotFoundException.class)
    public ApiResponseEntity handleRecordIdNotFoundException(NoRecordFoundException exception, WebRequest webRequest) {
    	ApiResponseEntity response = new ApiResponseEntity(ApiConstants.RESP_STATUS_NO_RECORD_FOUND_EXCEPTION, exception.getMessage());      
        return response;
    }
	
	@ExceptionHandler(Exception.class)
    public ApiResponseEntity handleExceptions(Exception exception, WebRequest webRequest) {
    	ApiResponseEntity response = new ApiResponseEntity(ApiConstants.RESP_STATUS_EXCEPTION, exception.getMessage());      
        return response;
    }

}
