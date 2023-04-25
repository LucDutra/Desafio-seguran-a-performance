package com.infoSecurity.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public enum TypeRole implements GrantedAuthority{

	BASEA,
	BASEB,
	BASEC;
	

	
	@Override
	public String getAuthority() {
        return "ROLE_"+this.toString();
    }

	public static List<TypeRole> converteLista(List<String> rotasDisponiveis) {
		
		if(rotasDisponiveis == null) {
			return new ArrayList<>();
		}
		
		List<TypeRole> rotasConvertidas = new ArrayList<>();
		
		for(String umaRota : rotasDisponiveis) {
			
			rotasConvertidas.add(Enum.valueOf(TypeRole.class, umaRota));
		}

		return rotasConvertidas;
	}	
	
}
