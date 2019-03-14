package br.com.springback.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClienteExceptionController {
	
   @ExceptionHandler(value = BusinessException.class)
   public ResponseEntity<Object> exception(BusinessException exception) {
	   
	if(exception.getErros() != null) {
			CustomError customError = new CustomError();
	        customError.setErrors(new HashMap<String,String[]>());
	        String[] errorArray = new String[exception.getErros().size()];
	        errorArray = (String[]) exception.getErros().toArray(errorArray);
			customError.getErrors().put("Atenção: ",errorArray);
		   return new ResponseEntity<>(customError, HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
   }
   
   
}