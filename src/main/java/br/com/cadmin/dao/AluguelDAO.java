package br.com.cadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadmin.modelo.Aluguel;

public interface AluguelDAO extends JpaRepository<Aluguel, Long> {

}
