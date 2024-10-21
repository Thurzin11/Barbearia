package com.projeto.barbearia.repositories;

import com.projeto.barbearia.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendaRepository extends JpaRepository<Agenda, UUID> {
}
