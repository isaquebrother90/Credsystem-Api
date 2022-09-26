package br.com.credsystem.credsystemapp.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoDTORequest {

    private String numero;

    private String senha;

    private Double valor;

    private boolean autorizado;
}
