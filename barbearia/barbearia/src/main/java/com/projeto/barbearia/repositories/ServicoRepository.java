package com.projeto.barbearia.repositories;

import com.projeto.barbearia.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicoRepository extends JpaRepository<Servico, UUID> {
}
