package com.gabim.agendamento_api.repository;

import com.gabim.agendamento_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}