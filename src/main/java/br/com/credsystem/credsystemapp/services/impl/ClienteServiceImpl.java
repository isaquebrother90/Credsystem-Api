package br.com.credsystem.credsystemapp.services.impl;

import br.com.credsystem.credsystemapp.dtos.ClienteDTO;
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
    public List<ClienteDTO> listAll() {
        return repository.findAll().stream().map(this::toClienteDTO).collect(Collectors.toList());
    }

    @Override
    public void save(ClienteDTO clienteDTO) {
        Cliente cliente = repository.findClienteByCpf(clienteDTO.getCpf());
        if (nonNull(cliente)) {
            throw new ClienteJaExisteException("O cliente já existe.");
        }
        repository.save(toCliente(clienteDTO));
    }
    @Override
    public ClienteDTO update(ClienteDTO clienteDTO){
        Optional<Cliente> cliente = repository.findById(clienteDTO.getId());
        if (!cliente.isPresent()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }
       repository.save(toCliente(clienteDTO));
        return null;
    }

    @Override
    public ClienteDTO searchById(Long id) {
        Optional<Cliente> cliente = repository.findById(id);

        if (!cliente.isPresent()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }

        return toClienteDTO(cliente);
    }

    @Override
    public void delete(Long id) {
        Optional<Cliente> cliente = repository.findById(id);

        if (!cliente.isPresent()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }

        repository.deleteById(id);
    }

    private ClienteDTO toClienteDTO(Optional<Cliente> cliente) {
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    private ClienteDTO toClienteDTO(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    private Cliente toCliente(ClienteDTO clienteDTO) {
        return modelMapper.map(clienteDTO, Cliente.class);
    }
}
