package br.com.credsystem.credsystemapp.repositories;

import br.com.credsystem.credsystemapp.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
