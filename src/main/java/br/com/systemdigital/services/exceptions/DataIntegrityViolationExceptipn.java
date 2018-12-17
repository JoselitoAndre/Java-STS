package br.com.systemdigital.services.exceptions;

public class DataIntegrityViolationExceptipn  extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityViolationExceptipn(String msg) {
		super (msg);
	}
	
	public DataIntegrityViolationExceptipn(String msg, Throwable cause) {
		super (msg, cause);
	}

}
