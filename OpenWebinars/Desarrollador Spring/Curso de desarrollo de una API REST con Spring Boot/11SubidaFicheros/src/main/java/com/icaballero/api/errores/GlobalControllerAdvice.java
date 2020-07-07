package com.icaballero.api.errores;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(ProductoNotFoundException.class)
	public ResponseEntity<ApiError> handlerProductoNoencontrado(ProductoNotFoundException ex) {
//		ApiError apiError = new ApiError();
//		apiError.setEstado(HttpStatus.NOT_FOUND);
//		apiError.setFecha(LocalDateTime.now());
//		apiError.setMensaje(ex.getMessage());
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
		
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		
//		return super.handleExceptionInternal(ex, body, headers, status, request);
		
		ApiError apiError = new ApiError(status, ex.getMessage());
		return ResponseEntity.status(status).headers(headers).body(apiError);
	}
	


}
