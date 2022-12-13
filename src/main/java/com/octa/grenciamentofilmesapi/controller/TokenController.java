/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.octa.grenciamentofilmesapi.controller;

import com.octa.grenciamentofilmesapi.config.property.SpringApiProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Impostos
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {

    private final SpringApiProperty springApiProperty;
    public TokenController(SpringApiProperty springApiProperty) {
        this.springApiProperty = springApiProperty;
    }

    @DeleteMapping("/revoke")
    public void revoke(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("refreshToken", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(springApiProperty.getSeguranca().isEnableHttps());
        cookie.setPath(request.getContextPath() + "/oauth/token");
        cookie.setMaxAge(0);

        response.addCookie(cookie);
        response.setStatus(HttpStatus.NO_CONTENT.value());

    }
}
