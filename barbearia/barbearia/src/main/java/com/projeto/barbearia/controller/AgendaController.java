package com.projeto.barbearia.controller;

import com.projeto.barbearia.entities.Agenda;
import com.projeto.barbearia.services.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agenda")
public class AgendaController {
    private final AgendaService service;

    @PostMapping
    public ResponseEntity<Agenda> createAgenda(@RequestBody Agenda agenda) {
        return ResponseEntity.ok(this.service.create(agenda));
    }
    @GetMapping
    public ResponseEntity<List<Agenda>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<Agenda> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(this.service.findById(id));
    }
    @PatchMapping
    public ResponseEntity<Agenda> updateAgenda(@RequestBody Agenda agenda) {
        return ResponseEntity.ok(this.service.update(agenda.getId(),agenda));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteAgenda(@RequestBody UUID id) {
        return ResponseEntity.ok(this.service.delete(id));
    }

}
