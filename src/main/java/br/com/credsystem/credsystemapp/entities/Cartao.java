package br.com.credsystem.credsystemapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCartao;

    private String número;

    private String senha;

    private Double limiteLiberado;

    private Double limiteTotal;

    @ManyToOne(fetch = FetchType.LAZY)//Varios tipos de cartão podem estar associados há apenas um cliente que irá gerar.
    private Cliente cliente;
}
