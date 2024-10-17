package com.projeto.barbearia.controller;

import com.projeto.barbearia.DTO.BarbeariaRegisterDTO;
import com.projeto.barbearia.entities.Barbearia;
import com.projeto.barbearia.services.BarbeariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("barbearia")
@RequiredArgsConstructor
public class BarbeariaController {
    private final BarbeariaService barbeariaService;

    @PostMapping
    public ResponseEntity<Barbearia> create(@RequestBody BarbeariaRegisterDTO barbeariaRegisterDTO) {
        return ResponseEntity.ok(this.barbeariaService.create(barbeariaRegisterDTO));
    }

    @GetMapping
    public ResponseEntity<List<Barbearia>> findAll() {
        return ResponseEntity.ok(this.barbeariaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbearia> findById(@PathVariable String id) {
        Barbearia barbearia = this.barbeariaService.findById(id);
        if(barbearia == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(barbearia);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Barbearia> update(@PathVariable String id, @RequestBody Barbearia barbearia) {
        Barbearia barbeariaReturn = this.barbeariaService.update(barbearia, id);
        if(barbearia == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(barbeariaReturn);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean deleteReturn = this.barbeariaService.delete(id);
        if(!deleteReturn)
            return ResponseEntity.badRequest().body(false);

        return ResponseEntity.ok(true);
    }
}
