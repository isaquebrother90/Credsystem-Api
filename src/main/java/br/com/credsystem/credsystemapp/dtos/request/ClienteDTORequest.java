package br.com.credsystem.credsystemapp.dtos.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteDTORequest {

    @ApiModelProperty(value = "Id do Cliente")
    private Long id;

    @CPF(message = "O documento é inválido.")
    @ApiModelProperty(value = "Documento do Cliente")
    private String cpf;

    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "Salário do Cliente")
    private Double salario;
}
