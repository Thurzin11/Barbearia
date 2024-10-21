package com.projeto.barbearia.services;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.projeto.barbearia.entities.Agenda;
import com.projeto.barbearia.repositories.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgendaService {
    private final AgendaRepository repository;

    public Agenda create(Agenda agenda) {
        return this.repository.save(agenda);
    }
    public List<Agenda> findAll() {
        return this.repository.findAll();
    }
    public Agenda findById(UUID id) {
        return this.repository.findById(id).orElse(null);
    }
    public Agenda update(UUID id, Agenda agenda) {
        var agendaFound = this.findById(id);
        if (agendaFound == null)
            return null;
        BeanUtils.copyProperties(agenda, agendaFound);
        return this.repository.save(agendaFound);
    }
    public Boolean delete(UUID id) {
        if (this.findById(id) == null)
            return false;
        this.repository.deleteById(id);
        return true;
    }
}
