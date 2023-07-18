package com.app.custom_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ApiResponse;

import java.util.*;
import java.util.stream.Collectors;
@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
	{
		Map<String,String> m=e.getFieldErrors()
				.stream()
				.collect(Collectors.toMap(f->f.getField(), f->f.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
	}
}
