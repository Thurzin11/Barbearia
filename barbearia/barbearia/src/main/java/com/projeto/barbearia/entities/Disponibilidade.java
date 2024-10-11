package com.projeto.barbearia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date date;
    @OneToMany
    private List<Horario> horarios;
}
