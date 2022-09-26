package br.com.credsystem.credsystemapp.services;

import br.com.credsystem.credsystemapp.dtos.request.ClienteDTORequest;
import br.com.credsystem.credsystemapp.dtos.response.ClienteDTOResponse;

import java.util.List;

public interface ClienteService {
    List<ClienteDTOResponse> listAll();

    ClienteDTORequest save(ClienteDTORequest clienteDTORequest);

    ClienteDTOResponse searchById(Long id);

    ClienteDTORequest update(ClienteDTORequest clienteDTORequest);

    void delete(Long id);


}
