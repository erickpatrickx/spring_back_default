package br.com.springback.exception;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

@JsonRootName(value="errors")
@Getter
@Setter
public class CustomError {
	
	private HashMap<String,String[]> errors;
	
}
