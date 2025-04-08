package com.gabim.sched_api.controller;

import com.gabim.sched_api.model.Sched;
import com.gabim.sched_api.service.SchedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sched")
@CrossOrigin(origins = "*")
public class SchedController {
    private final SchedService service;

    public SchedController(SchedService service) {
        this.service = service;
    }

    @PostMapping
    public Sched criar(@RequestBody Sched agendamento) {
        return service.criarAgendamento(agendamento);

    }

    @GetMapping
    public List<Sched> listar() {
        return service.listarTodos();
    }

    @PutMapping("/{id}/confirmar")
    public Sched confirmar(@PathVariable Long id) {
        return service.confirmarAgendamento(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletarAgendamento(id);
    }
}
