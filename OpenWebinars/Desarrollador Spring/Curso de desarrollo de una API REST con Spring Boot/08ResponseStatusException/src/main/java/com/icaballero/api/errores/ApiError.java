package com.icaballero.api.errores;

import java.time.LocalDateTime;



import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class ApiError {
	@NonNull
	private HttpStatus estado;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyy hh:mm:ss")
	private LocalDateTime fecha;
	@NonNull
	private String mensaje;
	
}
