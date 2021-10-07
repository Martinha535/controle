package com.example.controle.models;

import javax.persistence.*;

@Table(name = "prontuarios")
@Entity
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}