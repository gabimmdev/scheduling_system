package com.gabim.agendamento_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente é obrigatório.")
    @Size(min = 3, max = 50, message = "O nome do cliente deve ter entre 3 e 50 caracteres.")
    private String cliente;

    @NotNull(message = "O horário do agendamento é obrigatório.")
    //@Future(message = "O horário do agendamento deve ser no futuro.")
    @FutureOrPresent(message = "O horário do agendamento deve ser no futuro.")
    private LocalDateTime horario;

    private boolean confirmado = false;

    private boolean concluido = false;

    // Validação entre concluído e confirmado
    @AssertTrue(message = "Um agendamento só pode ser concluído se estiver confirmado.")
    public boolean isConcluidoAposConfirmado() {
        return !concluido || confirmado;
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
