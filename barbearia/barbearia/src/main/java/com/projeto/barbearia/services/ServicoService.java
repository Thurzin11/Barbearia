package com.projeto.barbearia.services;

import com.projeto.barbearia.entities.Servico;
import com.projeto.barbearia.repositories.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository repository;

    public List<Servico> findAll(){
        return this.repository.findAll();
    }

    public Servico createAndUpdate(Servico servico){
        return this.repository.save(servico);
    }

    public Servico findById(UUID id){
        return this.repository.findById(id).orElse(null);
    }

    public Boolean delete(UUID id){
        var servicoFound = this.findById(id);
        if (servicoFound!=null){
            this.repository.delete(servicoFound);
            return true;
        }
        return false;
    }



}
