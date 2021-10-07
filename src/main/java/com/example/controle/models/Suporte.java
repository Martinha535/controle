package com.example.controle.models;

import javax.persistence.*;

@Table(name = "suportes")
@Entity
public class Suporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}