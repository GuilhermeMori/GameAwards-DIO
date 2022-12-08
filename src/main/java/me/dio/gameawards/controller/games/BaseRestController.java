package me.dio.gameawards.controller.games;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import me.dio.gameawards.controller.ApiErroDto;
import me.dio.gameawards.service.exception.BusinessException;
import me.dio.gameawards.service.exception.NoContentException;

@RequestMapping("/api")
public abstract class BaseRestController {
	
	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<Void> handlerNoContent(NoContentException exception){
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiErroDto> handlerBusinessException(BusinessException exception){
		ApiErroDto error = new ApiErroDto(exception.getMessage());
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ApiErroDto> handlerUnexpectedException(BusinessException exception){
		exception.printStackTrace();
		ApiErroDto error = new ApiErroDto("Ops ocorreu um erro inesperado.");
		return ResponseEntity.internalServerError().body(error);
	}
}
