package br.com.cadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cadmin.modelo.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM USUARIO WHERE EMAIL = ?1", nativeQuery = true)
    public Usuario findByLogin(String email);

    @Query(value = "SELECT * FROM USUARIO WHERE CPF = ?1 AND SENHA = ?2", nativeQuery = true)
    public Usuario autenticar(String cpf, String senha);

}
