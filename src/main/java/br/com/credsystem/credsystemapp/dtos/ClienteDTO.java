package br.com.credsystem.credsystemapp.dtos;

import br.com.credsystem.credsystemapp.entities.Cliente;
import lombok.Getter;

@Getter
public class ClienteDTO {
    private Long id;
    private String cpf;
    private Double salario;

    public Cliente transformaParaObjeto(){
        return new Cliente(id, cpf, salario);
    }
}
