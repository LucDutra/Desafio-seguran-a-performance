package com.infoSecurity.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.infoSecurity.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TokenService {

    @Autowired
    UsuarioService  usuarioService;

    public static final String TOKEN_SENHA = "f2fd7df6-e6de-45b7-a547-66acaf004a12";

	public String geraTokenBaseA(UsuarioDto usuario) {
      
		UsuarioDto usuarioAutenticado = usuarioService.validaUsuario(usuario);

        if(usuarioAutenticado == null){
            throw new RuntimeException("Usuario não posssui permissao de login");
        }

        return JWT.create()
                .withIssuer("Base")
                .withClaim("Usuario", usuarioAutenticado.getLogin())
                .withClaim(usuarioAutenticado.getLogin(), List.of(usuario.getBaseAcessoSolicitada().toString()))
                .withExpiresAt(LocalDateTime.now().plusSeconds(30).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC512(TOKEN_SENHA));
	}
	
    public String geraTokenB(UsuarioDto usuario) {

        UsuarioDto usuarioAutenticado = usuarioService.validaUsuario(usuario);

        if(usuarioAutenticado == null){
            throw new RuntimeException("Usuario não posssui permissao de login");
        }

        return JWT.create()
                .withIssuer("Base")
                .withClaim("Usuario", usuarioAutenticado.getLogin())
                .withClaim(usuarioAutenticado.getLogin(), List.of(usuario.getBaseAcessoSolicitada().toString()))
                .withExpiresAt(LocalDateTime.now().plusMinutes(1).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC512(TOKEN_SENHA));
    }
	
    public String geraTokenC(UsuarioDto usuario) {

        UsuarioDto usuarioAutenticado = usuarioService.validaUsuario(usuario);

        if(usuarioAutenticado == null){
            throw new RuntimeException("Usuario não posssui permissao de login");
        }

        return JWT.create()
                .withIssuer("Base")
                .withClaim("Usuario", usuarioAutenticado.getLogin())
                .withClaim(usuarioAutenticado.getLogin(), List.of(usuario.getBaseAcessoSolicitada().toString()))
                .withExpiresAt(LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC512(TOKEN_SENHA));
    }

    
    
}
