package com.infoSecurity.dto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.infoSecurity.Types.TypeRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UsuarioDto implements UserDetails {

	private static final long serialVersionUID = -2457417851518896765L;
	
	private String login;
    private String password;
    private TypeRole baseAcessoSolicitada;
        
	public UsuarioDto(String login, String password, TypeRole baseAcessoSolicitada) {
		this.login = login;
		this.password = password;
		this.baseAcessoSolicitada = baseAcessoSolicitada;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(TypeRole.BASEA,TypeRole.BASEB,TypeRole.BASEC);
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
	@Override
	public String getPassword() {
		return password;
	}
	
    public TypeRole getBaseAcessoSolicitada() {
		return baseAcessoSolicitada;
	}

	public void setBaseAcessoSolicitada(TypeRole baseAcessoSolicitada) {
		this.baseAcessoSolicitada = baseAcessoSolicitada;
	}

	public static UsuarioDto build() {

        BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();

        String senhaCriptografada = criptografar.encode("1234");

        return new UsuarioDto("teste",senhaCriptografada, TypeRole.BASEA);
    }
}
