package com.example.controle.controllers;

import com.example.controle.models.Medico;
import com.example.controle.repositories.MedicoRepository;
import com.example.controle.repositories.MedicoRepositoryJpa;
import com.example.controle.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;



@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    MedicoRepository repository;
    MedicoService service;

    @GetMapping(path = "/medicos")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Medico>buscarPorId(@PathVariable("id")Long id)throws Exception{
        Medico medico = isso.MedicoService.findById(id);
        retornar ResponseEntity.ok(medico);

        //@GetMapping(path = "/medicos")
        //public String listar (){
        // return "nome, sobrenome, sexo, especialidade, cpf, senha";
        //}

        @PostMapping
        public ResponseEntity<Object> Cadastrar(@RequestBody Medico medico){
            this.repository.save(medico);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(medico.getId()).toUri();

            return ResponseEntity.created(uri).build();
        }

        @PutMapping
        public void Alterar(@RequestBody Medico medico){
            this.repository.save(medico);
        }

        @GetMapping(path = "/{id}")
        public ResponseEntity<Medico> Buscar(@PathVariable("id") Long id){
            return this.repository.findById(id).map(medico ->
                            ResponseEntity.ok(medico))
                    .orElse(ResponseEntity.notFound().build());
        }


        @DeleteMapping(path = "/{id}")
        public void Deletar(@PathVariable Long id){
            this.repository.deleteById(id);
        }

        @GetMapping(value = "/medicos")
        public List<Medico> listar(){
            Medico m1 = new Medico (1l, "Mário","Oliveira", "Masculino","Infectologista", "123456789-0",  "@love#123");
            //Medico["nome", "sobrenome","sexo", "especialidade", "cpf", "senha"] medicos = {m1};

            return Arrays.asList (m1);
        }
}
