package com.gabim.agendamento_api.controller;

import com.gabim.agendamento_api.model.Agendamento;
import com.gabim.agendamento_api.service.AgendamentoService;
import com.gabim.agendamento_api.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@SpringBootApplication(scanBasePackages = "com.gabim.agendamento_api")
@RestController
@RequestMapping("/agendamento")
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

    @GetMapping("/teste")
    public String testar() {
        return "Funcionando!";
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
