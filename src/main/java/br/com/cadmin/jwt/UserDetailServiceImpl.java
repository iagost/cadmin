package br.com.cadmin.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.cadmin.dao.UsuarioDAO;
import br.com.cadmin.modelo.Usuario;

public class UserDetailServiceImpl implements UserDetailsService {

    private final UsuarioDAO dao;

    @Autowired
    public UserDetailServiceImpl(UsuarioDAO dao) {
	this.dao = dao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Usuario usuario = dao.findByLogin(username);
	if (usuario == null) {
	    throw new UsernameNotFoundException(username);
	}
	return new User(usuario.getEmail(), usuario.getSenha(), new ArrayList<>());
    }

}
