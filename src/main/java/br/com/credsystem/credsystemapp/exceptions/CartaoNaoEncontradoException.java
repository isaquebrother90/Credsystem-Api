package br.com.credsystem.credsystemapp.exceptions;

public class CartaoNaoEncontradoException extends RuntimeException {
    public CartaoNaoEncontradoException(String exception) {
        super(exception);
    }
}
