package com.projeto.barbearia.services;

import com.projeto.barbearia.DTO.BarbeariaRegisterDTO;
import com.projeto.barbearia.entities.Barbearia;
import com.projeto.barbearia.repositories.BarbeariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarbeariaService {
    private final BarbeariaRepository barbeariaRepository;

    public Barbearia create(BarbeariaRegisterDTO barbeariaRegisterDTO) {
        Barbearia barbearia = Barbearia.builder()
                .nome(barbeariaRegisterDTO.nome())
                .rua(barbeariaRegisterDTO.rua())
                .bairro(barbeariaRegisterDTO.bairro())
                .cep(barbeariaRegisterDTO.cep())
                .cidade(barbeariaRegisterDTO.cidade())
                .numero(barbeariaRegisterDTO.numero())
                .build();

        return this.barbeariaRepository.save(barbearia);
    }

    public List<Barbearia> findAll() {
        return this.barbeariaRepository.findAll();
    }

    public Barbearia findById(String id) {
        return this.barbeariaRepository.findById(id).orElse(null);
    }

    public Barbearia update(Barbearia barbearia, String id) {
        Barbearia barbeariaFound = this.findById(id);
        if(barbeariaFound == null)
            return null;

        barbeariaFound = barbearia;
        return this.barbeariaRepository.save(barbeariaFound);
    }

    public Boolean delete(String id) {
        Barbearia barbearia = this.findById(id);
        if(barbearia == null)
            return false;

        this.barbeariaRepository.delete(barbearia);
        return true;
    }
}
