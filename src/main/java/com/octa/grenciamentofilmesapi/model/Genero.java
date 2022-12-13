package com.octa.grenciamentofilmesapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "genero")
@Getter
@Setter
public class Genero extends BaseEntity {
    private String nome;
}
