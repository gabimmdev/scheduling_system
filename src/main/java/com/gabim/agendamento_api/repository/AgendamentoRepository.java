package com.gabim.agendamento_api.repository;

import com.gabim.agendamento_api.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    
}
