package com.octa.grenciamentofilmesapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "filme")
@Getter
@Setter
public class Filme extends BaseEntity{

    private String nome;

    private String descricao;

    private String diretor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "filme_pessoa", joinColumns = @JoinColumn(name = "filme_id")
            , inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
    private List<Pessoa> pessoas;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @Column(name = "id_usuario_criou")
    private Long idUsuarioCriou;

    @Column(name = "id_usuario_alterou")
    private Long idUsuarioAlterou;
}
