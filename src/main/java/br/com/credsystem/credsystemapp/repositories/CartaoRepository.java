package br.com.credsystem.credsystemapp.repositories;

import br.com.credsystem.credsystemapp.entities.Cartao;
import br.com.credsystem.credsystemapp.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    Cartao findCartaoByNumero(String numero);
}
