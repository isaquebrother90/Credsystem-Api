package br.com.credsystem.credsystemapp.utils;

import br.com.credsystem.credsystemapp.dtos.request.ClienteDTORequest;
import br.com.credsystem.credsystemapp.entities.Cartao;
import br.com.credsystem.credsystemapp.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientePayload {
    public static final Long id = 1L;
    public static final String cpf = "394.766.958-54";
    public static final Double salario = 2343.54;

    private static final String numeroCartao = "4556-4545-5454-3434";

    private static final String senhaCartao = "345678";

    private static final Double limiteLiberado = 1045.00;

    private static final Double limiteTotal = 1500.00;


       /* Cliente cliente = new Cliente();
        List<Cliente> clientes = new ArrayList<>();
        cliente.setId(id);
        cliente.setCpf(cpf);
        cliente.setSalario(salario);
        cliente.setCartoes(cartoes());
        clientes.add(cliente);
        return cliente;

    public static ClienteDTORequest clienteDTO(){
        ClienteDTORequest clienteDTO = new ClienteDTORequest();
        List<ClienteDTORequest> clientesDTO = new ArrayList<>();
        clienteDTO.setId(id);
        clienteDTO.setCpf(cpf);
        clienteDTO.setSalario(salario);
        clienteDTO.setCartoes(cartoes());
        clientesDTO.add(clienteDTO);
        return clienteDTO;
    }

    public static List<Cartao> cartoes(){
        Cartao cartao = new Cartao();
        Cliente cliente = new Cliente();
        cliente.setId(id);
        List<Cartao> cartoes = new ArrayList<>();
        cartao.setIdCartao(id);
        cartao.setSenha(senhaCartao);
        cartao.setNumero(numeroCartao);
        cartao.setLimiteTotal(limiteTotal);
        cartao.setLimiteLiberado(limiteLiberado);
        cartoes.add(cartao);
        return cartoes;
    }*/
}
