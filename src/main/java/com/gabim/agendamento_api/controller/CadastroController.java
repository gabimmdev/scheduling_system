package com.gabim.agendamento_api.controller;

import com.gabim.agendamento_api.model.Usuario;
import com.gabim.agendamento_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuario")
public class CadastroController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(repository.save(usuario));
    }
}
