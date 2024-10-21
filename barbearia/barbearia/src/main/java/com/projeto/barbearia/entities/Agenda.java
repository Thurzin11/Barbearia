package com.projeto.barbearia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private User funcionario;
    @ManyToOne
    private User cliente;
    @ManyToOne
    private Horario horario;
    @ManyToMany
    private List<Servico> servicos;
    private Double valorTotal;

}
