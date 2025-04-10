package com.gabim.agendamento_api.controller;

import com.gabim.agendamento_api.model.Agendamento;
import com.gabim.agendamento_api.service.AgendamentoService;
import com.gabim.agendamento_api.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService service;
    private final AgendamentoRepository agendamentoRepository;

    @Autowired
    public AgendamentoController(AgendamentoService service, AgendamentoRepository agendamentoRepository) {
        this.service = service;
        this.agendamentoRepository = agendamentoRepository;
    }

    @PostMapping
    public ResponseEntity<Agendamento> criar(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = service.criarAgendamento(agendamento);
        return ResponseEntity.ok(novoAgendamento);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listar() {
        List<Agendamento> lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}/confirmar")
    public ResponseEntity<Agendamento> confirmar(@PathVariable Long id) {
        Agendamento agendamentoConfirmado = service.confirmarAgendamento(id);
        return ResponseEntity.ok(agendamentoConfirmado);
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

    @PutMapping("/{id}/desmarcar")
    public ResponseEntity<Agendamento> desmarcarComoConcluido(@PathVariable Long id) {
        Optional<Agendamento> optional = agendamentoRepository.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Agendamento agendamento = optional.get();
        agendamento.setConcluido(false);
        agendamentoRepository.save(agendamento);

        return ResponseEntity.ok(agendamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}
