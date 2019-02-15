package br.com.cadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadmin.modelo.Morador;

public interface MoradorDAO extends JpaRepository<Morador, Long> {

}
