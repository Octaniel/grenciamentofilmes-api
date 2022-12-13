package com.octa.grenciamentofilmesapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario_criou")
    private Long idUsuarioCriou;

    @Column(name = "id_usuario_alterou")
    private Long idUsuarioAlterou;

    @Column(name = "dt_dria")
    private LocalDateTime dtCria;

    @Column(name = "dt_alter")
    private LocalDateTime dtAlter;

    @Column(name = "dt_remove")
    private LocalDateTime dtRemove;

    @PrePersist
    public void antesSalvar(){
        dtCria = LocalDateTime.now();
        dtAlter = LocalDateTime.now();
    }

    @PreUpdate
    public void antesAtualizar(){
        dtAlter = LocalDateTime.now();
    }
}
