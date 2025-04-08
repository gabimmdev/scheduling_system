package com.gabim.sched_api.repository;

import com.gabim.sched_api.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    
}
