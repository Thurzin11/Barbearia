package com.projeto.barbearia.repositories;

import com.projeto.barbearia.entities.Barbearia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarbeariaRepository extends JpaRepository<Barbearia, String> {
}
