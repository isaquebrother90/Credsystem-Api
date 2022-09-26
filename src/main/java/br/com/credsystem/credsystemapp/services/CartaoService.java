package br.com.credsystem.credsystemapp.services;

import br.com.credsystem.credsystemapp.dtos.request.CartaoDTORequest;
import br.com.credsystem.credsystemapp.dtos.response.CartaoDTOResponse;

import java.util.List;

public interface CartaoService {
    List<CartaoDTOResponse> listAll();

    void save(CartaoDTORequest cartaoDTORequest);

    CartaoDTOResponse searchById(Long id);

    void delete(Long id);
}
