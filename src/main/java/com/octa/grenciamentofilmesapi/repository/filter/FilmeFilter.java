package com.octa.grenciamentofilmesapi.repository.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class FilmeFilter {
    private String nome;
    private String diretor;
    private String genero;
}
