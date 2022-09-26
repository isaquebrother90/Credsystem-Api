package br.com.credsystem.credsystemapp.handler;

import br.com.credsystem.credsystemapp.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ControllerHandler {
    @ExceptionHandler({ClienteNaoEncontradoException.class})
    public ResponseEntity<?> clientNotFound(ClienteNaoEncontradoException clientNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(clientNotFoundException.getMessage());
    }

    @ExceptionHandler({CartaoNaoEncontradoException.class})
    public ResponseEntity<?> cardNotFound(CartaoNaoEncontradoException cardNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(cardNotFoundException.getMessage());
    }

    @ExceptionHandler({ClienteJaExisteException.class})
    public ResponseEntity<?> clientAlreadyExists(ClienteJaExisteException clientAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(clientAlreadyExistsException.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Objects.requireNonNull(methodArgumentNotValidException.getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler({SenhaIncorretaException.class})
    public ResponseEntity<?> passwordNotMatch(SenhaIncorretaException passwordNotMatchException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(passwordNotMatchException.getMessage());
    }

    @ExceptionHandler({SaldoInsuficienteException.class})
    public ResponseEntity<?> insufficientFounds(SaldoInsuficienteException insufficientFundsException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(insufficientFundsException.getMessage());
    }
}