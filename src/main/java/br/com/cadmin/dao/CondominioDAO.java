package br.com.cadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cadmin.modelo.Condominio;

public interface CondominioDAO extends JpaRepository<Condominio, Long> {

    @Query(value = "SELECT * FROM CONDOMINIO WHERE NOME = ?1", nativeQuery = true)
    public Condominio findByNome(String nome);

}
