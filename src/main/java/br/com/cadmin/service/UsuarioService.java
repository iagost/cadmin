package br.com.cadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadmin.dao.UsuarioDAO;
import br.com.cadmin.modelo.Usuario;

@Service
public class UsuarioService {

    private final UsuarioDAO dao;

    @Autowired
    public UsuarioService(UsuarioDAO dao) {
	this.dao = dao;
    }

    public void inserir(Usuario usuario) {
	dao.save(usuario);
    }

    public Usuario getUsuario(Long id) {

	if (dao.findById(id).isPresent()) {
	    return dao.findById(id).get();
	}

	return null;
    }

    public boolean existsUsuario(String email) {
	Usuario usuario = dao.findByLogin(email);
	if (usuario != null) {
	    return true;
	}
	return false;
    }

    public Usuario autenticar(String cpf, String senha) {
	Usuario usuario = dao.autenticar(cpf, senha);

	if (usuario != null) {
	    return usuario;
	}

	return null;
    }

}
