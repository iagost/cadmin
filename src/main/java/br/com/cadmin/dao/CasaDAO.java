package br.com.cadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadmin.modelo.Casa;

public interface CasaDAO extends JpaRepository<Casa, Long> {

}
