package Exceptions;

public class BusinessException extends Exception {
	public BusinessException(String mensagemDeErro){
		super(mensagemDeErro);
	}
}
