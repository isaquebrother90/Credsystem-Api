package br.com.credsystem.credsystemapp.exceptions;

public class SenhaIncorretaException extends RuntimeException {
    public SenhaIncorretaException(String exception) {
        super(exception);
    }
}
