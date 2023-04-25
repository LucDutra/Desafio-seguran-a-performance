package com.infoSecurity.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infoSecurity.Types.TypeRole;
import com.infoSecurity.dto.UsuarioDto;
import com.infoSecurity.service.TokenService;

@Component
public class TokenFactory {

	
	@Autowired
	TokenService tokenService;
	
	public String geraToken(UsuarioDto usuario) {
		
		if(TypeRole.BASEA.equals(usuario.getBaseAcessoSolicitada())) {
			
			return tokenService.geraTokenBaseA(usuario);
			
		}else if(TypeRole.BASEB.equals(usuario.getBaseAcessoSolicitada())) {
			
			return tokenService.geraTokenB(usuario);
			
		}else if(TypeRole.BASEC.equals(usuario.getBaseAcessoSolicitada())) {
			
			return tokenService.geraTokenC(usuario);
		}
		
		return "Não foi informado a base de dados";
	}
}
