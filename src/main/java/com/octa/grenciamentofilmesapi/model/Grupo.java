package com.octa.grenciamentofilmesapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupo")
@Getter
@Setter
public class Grupo extends BaseEntity {

    private String nome;
    private String slug;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "grupo_permissao", joinColumns = @JoinColumn(name = "grupo_id")
            , inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private List<Permissao> permissaos;
}
