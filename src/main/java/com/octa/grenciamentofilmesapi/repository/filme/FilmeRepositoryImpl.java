package com.octa.grenciamentofilmesapi.repository.filme;

import com.octa.grenciamentofilmesapi.model.Filme;
import com.octa.grenciamentofilmesapi.model.Filme_;
import com.octa.grenciamentofilmesapi.model.Genero_;
import com.octa.grenciamentofilmesapi.repository.filter.FilmeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FilmeRepositoryImpl implements FilmeRepositoryQuery {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Filme> filtrar(FilmeFilter filmeFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Filme> criteria = builder.createQuery(Filme.class);
        Root<Filme> root = criteria.from(Filme.class);
//        Root<Person> rootp = criteria.from(Person.class);
        criteria.select(root);
        criteria.where(criarRestricoes(filmeFilter, builder, root));

        TypedQuery<Filme> query = manager.createQuery(criteria);
        int size = query.getResultList().size();
        adicionarRestricoesDePaginacao(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, size);
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistroPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistroPorPagina);
    }

    private Predicate[] criarRestricoes(FilmeFilter filmeFilter, CriteriaBuilder builder, Root<Filme> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (filmeFilter.getNome() != null && !filmeFilter.getNome().isEmpty()) {
            predicates.add(builder.like(builder.lower(root.get(Filme_.nome)), "%" + filmeFilter.getNome().toLowerCase() + "%"));
        }

        if (filmeFilter.getDiretor() != null && !filmeFilter.getDiretor().isEmpty()) {
            predicates.add(builder.like(builder.lower(root.get(Filme_.diretor)), "%" + filmeFilter.getDiretor().toLowerCase() + "%"));
        }

        if (filmeFilter.getGenero() != null && !filmeFilter.getGenero().isEmpty()) {
            predicates.add(builder.like(builder.lower(root.get(Filme_.genero).get(Genero_.nome)), "%" + filmeFilter.getGenero().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[0]);

    }
}
