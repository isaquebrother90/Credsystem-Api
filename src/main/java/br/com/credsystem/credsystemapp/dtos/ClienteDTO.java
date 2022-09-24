package br.com.credsystem.credsystemapp.dtos;

import br.com.credsystem.credsystemapp.entities.Cliente;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Getter
@Setter
public class ClienteDTO {
    private Long id;
    @CPF(message = "O documento é inválido.")
    private String cpf;
    private Double salario;
}
