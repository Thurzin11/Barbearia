package com.projeto.barbearia.services;

import com.projeto.barbearia.entities.Horario;
import com.projeto.barbearia.repositories.HorarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HorarioService {
    private final HorarioRepository repository;

    public Horario create(Horario horario) {
        return this.repository.save(horario);
    }
    public List<Horario> findAll() {
        return this.repository.findAll();
    }
    public Horario findById(String id) {
        return this.repository.findById(id).orElse(null);
    }
    public Horario update(Horario horario) {
        var horarioFound = this.findById(horario.getId());
        if (horarioFound == null)
            return null;
        BeanUtils.copyProperties(horario, horarioFound);
        return this.repository.save(horarioFound);
    }
    public Boolean delete(String id) {
        var horarioFound = this.findById(id);
        if (horarioFound == null)
            return false;
        this.repository.deleteById(id);
        return true;
    }
}
