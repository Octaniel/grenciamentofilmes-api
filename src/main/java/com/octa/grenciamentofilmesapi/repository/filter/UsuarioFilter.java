package com.octa.grenciamentofilmesapi.repository.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioFilter {
    private String nome;
    private String email;
    private Long grupo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriaDe;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriaAte;
}
