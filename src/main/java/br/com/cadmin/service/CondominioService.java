package br.com.cadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadmin.dao.CondominioDAO;
import br.com.cadmin.modelo.Condominio;

@Service
public class CondominioService {

    private final CondominioDAO dao;

    @Autowired
    public CondominioService(CondominioDAO dao) {
	this.dao = dao;
    }

    public void inserir(Condominio condominio) {
	dao.save(condominio);
    }

    public Condominio getCondominio(Long id) {

	if (dao.findById(id).isPresent()) {
	    return dao.findById(id).get();
	}

	return null;
    }

    public boolean existsCondominio(String nome) {

	Condominio condominio = dao.findByNome(nome);
	if (condominio == null) {
	    return false;
	}

	return true;

    }

}
