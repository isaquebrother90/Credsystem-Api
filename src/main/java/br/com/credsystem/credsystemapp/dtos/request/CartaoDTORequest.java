package br.com.credsystem.credsystemapp.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoDTORequest {

    @JsonIgnore
    private String numero;

    @JsonIgnore
    private String senha;

    @JsonIgnore
    private Double limiteLiberado;

    @JsonIgnore
    private Double limiteTotal;

    private Long clienteId;
}
