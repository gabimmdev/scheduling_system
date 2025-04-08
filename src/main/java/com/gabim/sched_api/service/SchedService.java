package com.gabim.sched_api.service;

import com.gabim.sched_api.model.Sched;
import com.gabim.sched_api.repository.SchedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedService {
    private final SchedRepository repository;

    public SchedService(SchedRepository repository) {
        this.repository = repository;
    }

    public Sched criarAgendamento(Sched agendamento) {
        agendamento.setConfirmado(false);
        return repository.save(agendamento);
    }

    public List<Sched> listarTodos() {
        return repository.findAll();
    }

    public Sched confirmarAgendamento(Long id) {
        Sched ag = repository.findById(id).orElseThrow();
        ag.setConfirmado(true);
        return repository.save(ag);
    }

    public void deletarAgendamento(Long id) {
        repository.deleteById(id);
    }
}
