package br.com.credsystem.credsystemapp.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDTOResponse {

    private Long Id;
    private String numero;
    private String senha;
    private Double limiteLiberado;
    private Double limiteTotal;
    private ClienteDTOResponse cliente;
}
