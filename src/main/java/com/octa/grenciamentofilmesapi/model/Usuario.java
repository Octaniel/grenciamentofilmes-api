package com.octa.grenciamentofilmesapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario extends BaseEntity{

    @Size(min = 6, message = "A palavra passe tem que ter no minimo 6 caracteres")
    private String password;

    @Column(name = "password_confirm")
    private String passwordConfirm;

    @NotNull(message = "Tens que selecionar uma pessoa")
    @JoinColumn(name = "person_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Grupo grupo;

}
