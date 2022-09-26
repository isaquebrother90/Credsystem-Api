package br.com.credsystem.credsystemapp.services.impl;

import br.com.credsystem.credsystemapp.dtos.request.ClienteDTORequest;
import br.com.credsystem.credsystemapp.dtos.response.ClienteDTOResponse;
import br.com.credsystem.credsystemapp.entities.Cliente;
import br.com.credsystem.credsystemapp.exceptions.ClienteJaExisteException;
import br.com.credsystem.credsystemapp.exceptions.ClienteNaoEncontradoException;
import br.com.credsystem.credsystemapp.repositories.ClienteRepository;
import br.com.credsystem.credsystemapp.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    private final ModelMapper modelMapper;

    public ClienteServiceImpl(ClienteRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ClienteDTOResponse> listAll() {
        return repository.findAll().stream().map(this::toClienteDTOResponse).collect(Collectors.toList());
    }

    @Override
    public ClienteDTORequest save(ClienteDTORequest clienteDTORequest) {
        Cliente clienteCPF = repository.findClienteByCpf(clienteDTORequest.getCpf());
        if (nonNull(clienteCPF)) {
            throw new ClienteJaExisteException("O cliente já existe.");
        }
        Cliente cliente = repository.save(toCliente(clienteDTORequest));
        return toClienteDTORequest(cliente);
    }

    @Override
    public ClienteDTORequest update(ClienteDTORequest clienteDTO) {
        Optional<Cliente> idCliente = repository.findById(clienteDTO.getId());
        if (!idCliente.isPresent()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }
        Cliente cliente = repository.save(toCliente(clienteDTO));
        return toClienteDTORequest(cliente);
    }

    @Override
    public ClienteDTOResponse searchById(Long id) {
        Optional<Cliente> cliente = repository.findById(id);

        if (!cliente.isPresent()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }

        return toClienteDTOResponse(cliente);
    }

    @Override
    public void delete(Long id) {
        Optional<Cliente> cliente = repository.findById(id);

        if (!cliente.isPresent()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }

        repository.deleteById(id);
    }

    private ClienteDTORequest toClienteDTORequest(Optional<Cliente> cliente) {
        return modelMapper.map(cliente, ClienteDTORequest.class);
    }

    private ClienteDTORequest toClienteDTORequest(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDTORequest.class);
    }

    private ClienteDTOResponse toClienteDTOResponse(Optional<Cliente> cliente) {
        return modelMapper.map(cliente, ClienteDTOResponse.class);
    }

    private ClienteDTOResponse toClienteDTOResponse(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDTOResponse.class);
    }

    private Cliente toCliente(ClienteDTORequest clienteDTORequest) {
        return modelMapper.map(clienteDTORequest, Cliente.class);
    }

    private Cliente toCliente(ClienteDTOResponse clienteDTOResponse) {
        return modelMapper.map(clienteDTOResponse, Cliente.class);
    }
}
