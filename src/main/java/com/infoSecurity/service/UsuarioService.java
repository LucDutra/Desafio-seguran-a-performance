package com.infoSecurity.service;

import com.infoSecurity.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    @Autowired
    AuthenticationManager authenticationManager;

    public UsuarioDto validaUsuario(UsuarioDto usuario){

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(usuario.getLogin(), usuario.getPassword());

        Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

       return (UsuarioDto) authenticate.getPrincipal();
    }
}
