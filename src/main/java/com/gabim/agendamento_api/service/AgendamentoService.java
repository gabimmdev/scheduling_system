package com.gabim.agendamento_api.service;

import com.gabim.agendamento_api.model.Agendamento;
import com.gabim.agendamento_api.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {
    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public Agendamento criarAgendamento(Agendamento agendamento) {
        agendamento.setConfirmado(false);
        return repository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }

    public Agendamento confirmarAgendamento(Long id) {
        Agendamento ag = repository.findById(id).orElseThrow();
        ag.setConfirmado(true);
        return repository.save(ag);
    }

    public void deletarAgendamento(Long id) {
        repository.deleteById(id);
    }
}
