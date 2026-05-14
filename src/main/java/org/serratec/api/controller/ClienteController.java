package org.serratec.api.controller;

import org.serratec.api.domain.Cliente;
import org.serratec.api.exception.RecursoNaoEncontradoException;
import org.serratec.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("/buscar")
    public List<Cliente> buscarPorNome(@RequestParam String nome) {
        return repository.findAll().stream()
                .filter(c -> c.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> pesquisar(@PathVariable Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente com ID " + id + " não encontrado."));

        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public Cliente inserir(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }
}