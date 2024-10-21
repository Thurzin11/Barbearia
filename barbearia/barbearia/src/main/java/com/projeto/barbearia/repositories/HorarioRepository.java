package com.projeto.barbearia.repositories;

import com.projeto.barbearia.entities.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, String> {
}
