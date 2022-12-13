package com.octa.grenciamentofilmesapi.repository.usuario;

import com.octa.grenciamentofilmesapi.model.Group_;
import com.octa.grenciamentofilmesapi.model.Pessoa_;
import com.octa.grenciamentofilmesapi.model.Usuario;
import com.octa.grenciamentofilmesapi.model.Usuario_;
import com.octa.grenciamentofilmesapi.repository.filter.UsuarioFilter;
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

public class UsuarioRepositoryImpl implements UsuarioRepositoryQuery {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Usuario> findAllP(UsuarioFilter usuarioFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
        Root<Usuario> root = criteria.from(Usuario.class);
//        Root<Person> rootp = criteria.from(Person.class);
        criteria.select(root);
        criteria.where(criarRestricoes(usuarioFilter, builder, root, criteria));

        TypedQuery<Usuario> query = manager.createQuery(criteria);
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

    private Predicate[] criarRestricoes(UsuarioFilter usuarioFilter, CriteriaBuilder builder, Root<Usuario> root, CriteriaQuery<Usuario> criteria) {
        List<Predicate> predicates = new ArrayList<>();

        if (usuarioFilter.getNome() != null && !usuarioFilter.getNome().isEmpty()) {
            predicates.add(builder.like(builder.lower(root.get(Usuario_.pessoa).get(Pessoa_.nome)), "%" + usuarioFilter.getNome().toLowerCase() + "%"));
        }

        if (usuarioFilter.getEmail() != null && !usuarioFilter.getEmail().isEmpty()) {
            predicates.add(builder.like(builder.lower(root.get(Usuario_.pessoa).get(Pessoa_.email)), "%" + usuarioFilter.getEmail().toLowerCase() + "%"));
        }

        if (usuarioFilter.getGrupo() != null) {
            predicates.add(builder.equal(root.get(Usuario_.group).get(Group_.id), usuarioFilter.getGrupo()));
        }

        if (usuarioFilter.getDataCriaDe() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get(Usuario_.dtCria), usuarioFilter.getDataCriaDe().atStartOfDay()));
        }

        if (usuarioFilter.getDataCriaAte() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get(Usuario_.dtCria), usuarioFilter.getDataCriaAte().atStartOfDay()));
        }
        return predicates.toArray(new Predicate[0]);

    }
}
