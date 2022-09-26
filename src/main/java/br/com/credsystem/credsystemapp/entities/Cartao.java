package br.com.credsystem.credsystemapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cartao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "senha")
    private String senha;

    @Column(name = "limite_liberado")
    private Double limiteLiberado;

    @Column(name = "limite_total")
    private Double limiteTotal;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
}
