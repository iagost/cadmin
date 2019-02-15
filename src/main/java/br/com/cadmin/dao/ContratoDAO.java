package br.com.cadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadmin.modelo.Contrato;

public interface ContratoDAO extends JpaRepository<Contrato, Long> {

}
