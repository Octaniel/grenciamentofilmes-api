package com.octa.grenciamentofilmesapi.repository.filme;

import com.octa.grenciamentofilmesapi.model.Filme;
import com.octa.grenciamentofilmesapi.repository.filter.FilmeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmeRepositoryQuery {
    Page<Filme> filtrar(FilmeFilter filmeFilter, Pageable pageable);
}
