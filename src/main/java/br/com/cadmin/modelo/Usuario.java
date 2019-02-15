package br.com.cadmin.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Usuario implements Serializable {

    /**
     * @author iago
     */
    private static final long serialVersionUID = -7508494573908631284L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column
    private String email;

    @Column
    private String senha;

    @Column(length = 1, nullable = false)
    private String perfil;

    @Column(length = 1, nullable = false)
    private String situacao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USUARIO_CONDOMINIO", joinColumns = { @JoinColumn(name = "USUARIO_ID") }, inverseJoinColumns = {
	    @JoinColumn(name = "CONDOMINIO_ID") })
    @JsonBackReference
    private List<Condominio> condominios;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getSituacao() {
	return situacao;
    }

    public void setSituacao(String situacao) {
	this.situacao = situacao;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPerfil() {
	return perfil;
    }

    public void setPerfil(String perfil) {
	this.perfil = perfil;
    }

    public List<Condominio> getCondominios() {
	return condominios;
    }

    public void setCondominios(List<Condominio> condominios) {
	this.condominios = condominios;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

}
