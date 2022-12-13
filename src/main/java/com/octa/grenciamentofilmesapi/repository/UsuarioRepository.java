package com.octa.grenciamentofilmesapi.repository;

import com.octa.grenciamentofilmesapi.model.Usuario;
import com.octa.grenciamentofilmesapi.repository.usuario.UsuarioRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryQuery {
    Optional<Usuario> findBypessoaEmail(String email);

}
