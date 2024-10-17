package com.projeto.barbearia.controller;

import com.projeto.barbearia.entities.Servico;
import com.projeto.barbearia.services.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/servico")
public class ServicoController {
    private final ServicoService service;

    @PostMapping
    public ResponseEntity<Servico> create(@RequestBody Servico servico){
        return ResponseEntity.ok(this.service.createAndUpdate(servico));
    }

    @PatchMapping
    public ResponseEntity<Servico> update(@RequestBody Servico servico){
        return ResponseEntity.ok(this.service.createAndUpdate(servico));
    }

    @GetMapping
    public ResponseEntity<List<Servico>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> findById(@PathVariable UUID id){
        return ResponseEntity.ok(this.service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable UUID id){
        return ResponseEntity.ok(this.service.delete(id));
    }

    
}
