package br.com.credsystem.credsystemapp.exceptions;

public class ClienteJaExisteException extends RuntimeException {
    public ClienteJaExisteException(String exception) {
        super(exception);
    }
}
