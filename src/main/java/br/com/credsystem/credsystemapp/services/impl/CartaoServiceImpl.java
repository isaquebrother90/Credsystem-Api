package br.com.credsystem.credsystemapp.services.impl;

import br.com.credsystem.credsystemapp.dtos.request.CartaoDTORequest;
import br.com.credsystem.credsystemapp.dtos.response.CartaoDTOResponse;
import br.com.credsystem.credsystemapp.dtos.response.ClienteDTOResponse;
import br.com.credsystem.credsystemapp.entities.Cartao;
import br.com.credsystem.credsystemapp.entities.Cliente;
import br.com.credsystem.credsystemapp.exceptions.CartaoNaoEncontradoException;
import br.com.credsystem.credsystemapp.repositories.CartaoRepository;
import br.com.credsystem.credsystemapp.services.CartaoService;
import br.com.credsystem.credsystemapp.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.credsystem.credsystemapp.utils.CartaoUtils.generateCreditCardPassword;
import static br.com.credsystem.credsystemapp.utils.CartaoUtils.maskCreditCardNumber;
import static java.util.Objects.nonNull;
import static net.andreinc.mockneat.unit.financial.CreditCards.creditCards;

@Component
public class CartaoServiceImpl implements CartaoService {

    private final CartaoRepository repository;

    public final ClienteService clienteService;

    private final ModelMapper modelMapper;

    private static final Double limiteMinimo = 300.00;
    private static final Double limiteMaximo = 2000.00;

    public CartaoServiceImpl(CartaoRepository repository, ClienteService clienteService, ModelMapper modelMapper) {
        this.repository = repository;
        this.clienteService = clienteService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CartaoDTOResponse> listAll() {
        return repository.findAll().stream().map(this::toCartaoDTOResponse).collect(Collectors.toList());
    }

    @Override
    public void save(CartaoDTORequest cartaoDTORequest) {

        ClienteDTOResponse clienteDTOResponse = clienteService.searchById(cartaoDTORequest.getClienteId());
        if (nonNull(clienteDTOResponse)) {
            Double limite = getLimite(clienteDTOResponse.getSalario());
            cartaoDTORequest.setNumero(maskCreditCardNumber(creditCards().masterCard().get()));
            cartaoDTORequest.setSenha(generateCreditCardPassword());
            cartaoDTORequest.setLimiteLiberado(limite);
            cartaoDTORequest.setLimiteTotal(limite);
            cartaoDTORequest.setClienteId(clienteDTOResponse.getId());
            repository.save(toCartao(cartaoDTORequest));
        }
    }

    @Override
    public CartaoDTOResponse searchById(Long id) {
        Optional<Cartao> cartao = repository.findById(id);

        if (!cartao.isPresent()) {
            throw new CartaoNaoEncontradoException("Cartão não encontrado.");
        }

        return toCartaoDTOResponse(cartao);
    }

    @Override
    public void delete(Long id) {
        Optional<Cartao> cartao = repository.findById(id);

        if (!cartao.isPresent()) {
            throw new CartaoNaoEncontradoException("Cartão não encontrado.");
        }

        repository.deleteById(id);
    }

    private Cartao toCartao(CartaoDTORequest cartaoDTORequest) {
        return modelMapper.map(cartaoDTORequest, Cartao.class);
    }

    private Double getLimite(Double salario) {
        Double limite = (salario / 100) * 30;
        if (limite < limiteMinimo) {
            limite = limiteMinimo;
        } else if (limite > limiteMaximo) {
            limite = limiteMaximo;
        }
        return limite;
    }

    private CartaoDTORequest toCartaoDTORequest(Optional<Cliente> cliente) {
        return modelMapper.map(cliente, CartaoDTORequest.class);
    }

    private CartaoDTORequest toCartaoDTORequest(Cliente cliente) {
        return modelMapper.map(cliente, CartaoDTORequest.class);
    }

    private CartaoDTOResponse toCartaoDTOResponse(Optional<Cartao> cartao) {
        return modelMapper.map(cartao, CartaoDTOResponse.class);
    }

    private CartaoDTOResponse toCartaoDTOResponse(Cartao cartao) {
        return modelMapper.map(cartao, CartaoDTOResponse.class);
    }

    private Cartao toCartao(CartaoDTOResponse cartaoDTOResponse) {
        return modelMapper.map(cartaoDTOResponse, Cartao.class);
    }
}