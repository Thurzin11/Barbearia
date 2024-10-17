package com.projeto.barbearia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Barbearia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    @OneToMany
    private List<User> barbeiros;
    private String rua = "";
    private int numero = 0;
    private String cep = "";
    private String bairro = "";
    private String cidade = "";
}
