package com.infoSecurity.controller;

import com.infoSecurity.dto.UsuarioDto;
import com.infoSecurity.factory.TokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    TokenFactory tokenFactory;


    @PostMapping("/login")
    public String login(@RequestBody UsuarioDto usuario){

        return tokenFactory.geraToken(usuario);
    }
}
