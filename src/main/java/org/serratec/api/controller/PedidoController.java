package org.serratec.api.controller;

import jakarta.validation.Valid;

import java.util.List;
import org.serratec.api.domain.Pedido;
import org.serratec.api.exception.RecursoNaoEncontradoException;
import org.serratec.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public ResponseEntity<Pedido> inserir(@Valid @RequestBody Pedido pedido) {
        return ResponseEntity.status(201).body(repository.save(pedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        Pedido p = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pedido " + id + " não encontrado"));
        return ResponseEntity.ok(p);
    }


    @GetMapping
    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

}