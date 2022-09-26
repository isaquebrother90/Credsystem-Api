package br.com.credsystem.credsystemapp.repositories;

import br.com.credsystem.credsystemapp.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findClienteByCpf(String cpf);
}
