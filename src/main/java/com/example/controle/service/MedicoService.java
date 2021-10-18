package com.example.controle.service;

import java.util.List;

import com.example.controle.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controle.models.Medico;
import com.example.controle.repositories.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> perquisarPorNome(String nome) {
        return medicoRepository.findByNome(nome);
    }

    public Medico salvar( Medico medico) {
        Medico medicoCriado = medicoRepository.save(medico);
        return medicoCriado;
    }

    public Medico atualizar(Medico medico) {
        Medico medicoAtualizado = medicoRepository.save(medico);
        return medicoAtualizado;
    }

    public void deletarPorId(Long id) throws Exception {
        Medico medicoExclusao = medicoRepository.findById(id)
                .orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
        medicoRepository.deleteById(id);
    }

    public Medico buscarPorId(Long id) throws Exception {
        return medicoRepository.findById(id).orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
    }

    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

}
