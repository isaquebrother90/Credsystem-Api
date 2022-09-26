package br.com.credsystem.credsystemapp.dtos.response;

import br.com.credsystem.credsystemapp.entities.Cartao;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTOResponse {

    @ApiModelProperty(value = "Id do Cliente")
    private Long id;

    @CPF(message = "O documento é inválido.")
    @ApiModelProperty(value = "Documento do cliente")
    private String cpf;

    @ApiModelProperty(value = "Salário do cliente")
    private Double salario;

    @ApiModelProperty(value = "Cartões do cliente")
    private List<Cartao> cartoes;
}
