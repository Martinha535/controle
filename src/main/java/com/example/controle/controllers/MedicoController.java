package com.example.controle.controllers;

import java.net.URI;
import java.util.List;

import com.example.controle.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.controle.models.Medico;
import com.example.controle.repositories.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> pesquisarPorNome(@RequestParam String nome) {
        return medicoService.perquisarPorNome(nome);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Medico medico) {
        medicoService.salvar(medico);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medico.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public void atualizar(@RequestBody Medico medico) {
        medicoService.atualizar(medico);
    }

    @DeleteMapping(value = "/{id}")
    public void deletar(@PathVariable("id") Long idMedico) throws Exception {
        medicoService.deletarPorId(idMedico);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Medico> buscarPorId(@PathVariable("id") Long idMedico) throws Exception {
        Medico medico = medicoService.buscarPorId(idMedico);
        return ResponseEntity.ok(medico);
    }

}