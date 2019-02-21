package br.com.rm.exceptions;

public class DateUtilsException extends Exception {

	private static final long serialVersionUID = 9045638656335752652L;

	public DateUtilsException() {
		super("Erro ao fazer o parse da Data.");
	}
	
}
