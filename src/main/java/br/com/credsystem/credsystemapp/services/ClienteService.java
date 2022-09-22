package br.com.credsystem.credsystemapp.services;

import br.com.credsystem.credsystemapp.dtos.ClienteDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listAll();

    /*void save(ClienteDTO salvar);

    ClienteDTO update(ClientRequest request);

    void delete(Integer id);

    ClienteDTO searchById(Long id);*/
}
