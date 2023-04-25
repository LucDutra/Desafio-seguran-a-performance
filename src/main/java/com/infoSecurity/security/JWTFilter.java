package com.infoSecurity.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoSecurity.Types.TypeRole;
import com.infoSecurity.dto.ErroDto;
import com.infoSecurity.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Component
public class JWTFilter extends OncePerRequestFilter {

    public static final String HEADER_ATRIBUTO = "Authorization";
    public static final String ATRIBUTO_PREFIXO = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String atributo = request.getHeader(HEADER_ATRIBUTO);

        if(atributo == null || !atributo.startsWith(ATRIBUTO_PREFIXO)){
           
        	chain.doFilter(request,response);
        	return;
        }

        String token = atributo.replace(ATRIBUTO_PREFIXO, "");
        
        UsernamePasswordAuthenticationToken authenticationToken = null;

        try {
        	
        	authenticationToken = getAuthenticationToken(token);
        	
		} catch (Exception e) {
			
			ErroDto erro = new ErroDto(401, "Usuario nao autorizado, token invalido");
			
			response.setStatus(erro.getStatus());
	    	response.setContentType("application/json");
	    	ObjectMapper mapper = new ObjectMapper();
	    	response.getWriter().print(mapper.writeValueAsString(erro));
	    	response.getWriter().flush();   
	    	
		}

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);

    }	


	private UsernamePasswordAuthenticationToken getAuthenticationToken (String token) throws Exception{

        Map<String, Claim> dadosToken = JWT.require(Algorithm.HMAC512(TokenService.TOKEN_SENHA))
                         .build()
                        .verify(token)
                        .getClaims();

        if(dadosToken == null){
            return null;
        }
        
        String usuario = dadosToken.get("Usuario").asString();
        List<TypeRole> rotasLiberadas = TypeRole.converteLista(dadosToken.get(usuario).asList(String.class));
	      	
        return new UsernamePasswordAuthenticationToken(usuario, null, rotasLiberadas);
    }
}
