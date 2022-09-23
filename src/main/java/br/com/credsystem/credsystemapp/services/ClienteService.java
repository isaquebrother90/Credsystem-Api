package br.com.credsystem.credsystemapp.services;

import br.com.credsystem.credsystemapp.dtos.ClienteDTO;
import br.com.credsystem.credsystemapp.entities.Cliente;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listAll();
    void save(ClienteDTO salvar);
    ClienteDTO searchById(Long id);

    ClienteDTO update(ClienteDTO clienteDTO);

    void delete(Long id);


}
