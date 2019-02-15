package br.com.cadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadmin.modelo.Observacao;

public interface ObservacaoDAO extends JpaRepository<Observacao, Long> {

}
