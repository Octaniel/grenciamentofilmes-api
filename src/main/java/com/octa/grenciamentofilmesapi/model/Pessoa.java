package com.octa.grenciamentofilmesapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
public class Pessoa extends BaseEntity{

    @NotNull(message = "O nome é obrigatorio")
    private String nome;

    @NotNull(message = "O apelido é obrigatorio")
    private String apelido;

    @NotNull(message = "O email é obrigatorio")
    private String email;

    private String contacto;

    private Integer idade;
}
