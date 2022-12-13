package com.octa.grenciamentofilmesapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "permissao")
@Getter
@Setter
public class Permissao extends BaseEntity {

    private String role;
}
