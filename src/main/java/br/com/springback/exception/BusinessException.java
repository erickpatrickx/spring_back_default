package br.com.springback.exception;

import java.util.List;

public class BusinessException extends RuntimeException {
	
	List erros;
	
	public BusinessException() {
	    super();
	 }
	public BusinessException(String msg) {
	    super(msg);
	 }
	public BusinessException(List erros) {
	    super();
		this.erros = erros;
	 }
	public List getErros() {
		return erros;
	}
	public void setErros(List erros) {
		this.erros = erros;
	}
	
	
	
	
}
