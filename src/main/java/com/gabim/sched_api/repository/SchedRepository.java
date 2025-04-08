package com.gabim.sched_api.repository;

import com.gabim.sched_api.model.Sched;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedRepository extends JpaRepository<Sched, Long> {
    
}
