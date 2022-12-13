package com.octa.grenciamentofilmesapi.security;

import com.octa.grenciamentofilmesapi.model.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

public class UsuarioSistema extends org.springframework.security.core.userdetails.User {

    private final Usuario usuario;

    public UsuarioSistema(Usuario usu, Collection<? extends GrantedAuthority> authorities, String email) {
        super(email, usu.getPassword(), authorities);
        usuario = usu;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Long getUsuarioId() {
        return usuario.getId();
    }

    public static String email() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return (String) authentication.getPrincipal();
    }
}
