package com.projeto.barbearia.controller;

import com.projeto.barbearia.entities.Horario;
import com.projeto.barbearia.services.HorarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horario")
public class HorarioController {
    private HorarioService service;

    @PostMapping
    public ResponseEntity<Horario> create(@RequestBody Horario horario) {
        return ResponseEntity.ok(this.service.create(horario));
    }
    @GetMapping
    public ResponseEntity<List<Horario>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<Horario> findById(@PathVariable String id) {
        return ResponseEntity.ok(this.service.findById(id));
    }
    @PatchMapping
    public ResponseEntity<Horario> update(@RequestBody Horario horario) {
        return ResponseEntity.ok(this.service.update(horario));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        return ResponseEntity.ok(this.service.delete(id));
    }
}
