package com.octa.grenciamentofilmesapi.config.token;

import com.octa.grenciamentofilmesapi.security.UsuarioSistema;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UsuarioSistema usuarioSistema = (UsuarioSistema) authentication.getPrincipal();

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("user", usuarioSistema.getUsuario());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(stringObjectMap);
        return accessToken;
    }
}
