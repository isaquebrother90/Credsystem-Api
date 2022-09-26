package br.com.credsystem.credsystemapp.exceptions;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String exception) {
        super(exception);
    }
}
