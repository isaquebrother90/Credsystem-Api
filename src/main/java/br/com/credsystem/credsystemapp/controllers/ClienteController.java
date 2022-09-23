package br.com.credsystem.credsystemapp.controllers;

import br.com.credsystem.credsystemapp.dtos.ClienteDTO;
import br.com.credsystem.credsystemapp.entities.Cliente;
import br.com.credsystem.credsystemapp.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listAll(){
        return ResponseEntity.ok(clienteService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> searchById(@PathVariable ("id") Long id){
        return ResponseEntity.ok(clienteService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteDTO clienteDTO){
        clienteService.save(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
   @PutMapping
    public ResponseEntity<ClienteDTO> update(@RequestBody @Valid ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteService.update(clienteDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
