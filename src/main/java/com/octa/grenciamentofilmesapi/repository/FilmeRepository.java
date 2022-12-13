package com.octa.grenciamentofilmesapi.repository;

import com.octa.grenciamentofilmesapi.model.Filme;
import com.octa.grenciamentofilmesapi.repository.filme.FilmeRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long>, FilmeRepositoryQuery {
}
