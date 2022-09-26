package br.com.credsystem.credsystemapp.controllers;

import br.com.credsystem.credsystemapp.dtos.request.CartaoDTORequest;
import br.com.credsystem.credsystemapp.dtos.response.CartaoDTOResponse;
import br.com.credsystem.credsystemapp.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private final CartaoService cartaoService;

    private static final String ID = "/{id}";

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @GetMapping
    public ResponseEntity<List<CartaoDTOResponse>> listAll() {
        return ResponseEntity.ok(cartaoService.listAll());
    }

    @GetMapping(ID)
    public ResponseEntity<CartaoDTOResponse> searchById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cartaoService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CartaoDTORequest cartaoDTORequest) {
        cartaoService.save(cartaoDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(ID)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        cartaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
