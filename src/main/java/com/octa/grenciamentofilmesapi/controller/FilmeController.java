package com.octa.grenciamentofilmesapi.controller;

import com.octa.grenciamentofilmesapi.model.Filme;
import com.octa.grenciamentofilmesapi.repository.FilmeRepository;
import com.octa.grenciamentofilmesapi.repository.filter.FilmeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filme")
public class FilmeController {
  private final FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @GetMapping
    public Page<Filme> filtrar(FilmeFilter filmeFilter, Pageable pageable){
        return filmeRepository.filtrar(filmeFilter, pageable);
    }
}
