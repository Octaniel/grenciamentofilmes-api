package com.octa.grenciamentofilmesapi.repository.usuario;

import com.octa.grenciamentofilmesapi.model.Usuario;
import com.octa.grenciamentofilmesapi.repository.filter.UsuarioFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioRepositoryQuery {
    Page<Usuario> findAllP(UsuarioFilter usuarioFilter, Pageable pageable);
}
