package Exceptions;

public class BusinessError extends Exception{
	public BusinessError(String mensagemDeErro){
		super(mensagemDeErro);
	}
}
