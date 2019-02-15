package br.com.cadmin.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Condominio implements Serializable {

    /**
     * @author iago
     */
    private static final long serialVersionUID = 4079735103288052928L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Casa> casas;

    @Column(length = 1, nullable = false)
    private String situacao;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public List<Casa> getCasas() {
	return casas;
    }

    public void setCasas(List<Casa> casas) {
	this.casas = casas;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getSituacao() {
	return situacao;
    }

    public void setSituacao(String situacao) {
	this.situacao = situacao;
    }

}
