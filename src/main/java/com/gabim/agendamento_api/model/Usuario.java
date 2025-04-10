package com.gabim.agendamento_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    @NotBlank(message = "A URL do LinkedIn é obrigatória.")
    private String linkedin;

    private String fotoUrl;

    // Getters e Setters

    @PrePersist
    public void definirFotoPadrao() {
        if (this.fotoUrl == null || this.fotoUrl.isBlank()) {
            // Gerar imagem de avatar com base no nome
            this.fotoUrl = "https://ui-avatars.com/api/?name=" + this.nome.replace(" ", "+") + "&background=random";
        }
    }

    // getters e setters omitidos para brevidade
}
