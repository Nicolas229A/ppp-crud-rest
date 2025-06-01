package br.edu.ifms.ppp_crud_rest.excecao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> tratamentoExcecaoValidacao (MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String atributo = ((FieldError) error).getField();
			String mensagem = error.getDefaultMessage();
			errors.put(atributo, mensagem);
		});
		
		return errors;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(SolicitacaoNotFoundException.class)
	public Map<String, String> solicitacaoNotFoundException (SolicitacaoNotFoundException ex) {
		Map<String, String> errosMap = new HashMap<String, String>();
		errosMap.put("mensagem", ex.getMessage());
		return errosMap;
	}
}
