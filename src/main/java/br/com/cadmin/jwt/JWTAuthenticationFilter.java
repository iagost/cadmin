package br.com.cadmin.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cadmin.modelo.Usuario;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
	this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
	    throws AuthenticationException {
	try {
	    Usuario creds = new ObjectMapper().readValue(req.getInputStream(), Usuario.class);

	    return authenticationManager.authenticate(
		    new UsernamePasswordAuthenticationToken(creds.getCpf(), creds.getSenha(), new ArrayList<>()));
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
	    Authentication auth) throws IOException, ServletException {
	String token = JWT.create().withSubject(((Usuario) auth.getPrincipal()).getCpf())
		.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstantes.EXPIRATION_TIME))
		.sign(Algorithm.HMAC512(SecurityConstantes.SECRET.getBytes()));
	res.addHeader(SecurityConstantes.HEADER_STRING, SecurityConstantes.TOKEN_PREFIX + token);
    }

}
