package com.gabim.agendamento_api.controller;

import com.gabim.agendamento_api.model.Agendamento;
import com.gabim.agendamento_api.service.AgendamentoService;
import com.gabim.agendamento_api.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/agendamentos")
@Repository
public class AgendamentoController {
    private final AgendamentoService service;
    
    @Autowired
    private AgendamentoRepository agendamentoRepository; 

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @PostMapping
    public Agendamento criar(@RequestBody Agendamento agendamento) {
        return service.criarAgendamento(agendamento);

    }

    @GetMapping
    public List<Agendamento> listar() {
        return service.listarTodos();
    }

    @PutMapping("/{id}/confirmar")
    public Agendamento confirmar(@PathVariable Long id) {
        return service.confirmarAgendamento(id);
    }

    @PutMapping("/{id}/concluir")
    public ResponseEntity<Agendamento> marcarComoConcluido(@PathVariable Long id) {
        Optional<Agendamento> optional = agendamentoRepository.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Agendamento agendamento = optional.get();
        agendamento.setConcluido(true);
        agendamentoRepository.save(agendamento);

        return ResponseEntity.ok(agendamento);
    } 

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletarAgendamento(id);
    }
}
