package br.com.credsystem.credsystemapp.repositories;

import br.com.credsystem.credsystemapp.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findClientByCpf(String cpf);
}
