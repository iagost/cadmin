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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Morador implements Serializable {

    /**
     * @author iago
     */
    private static final long serialVersionUID = 7942247366679238692L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Aluguel> alugueis;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Observacao> observacoes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CASA_MORADOR", joinColumns = { @JoinColumn(name = "CASA_ID") }, inverseJoinColumns = {
	    @JoinColumn(name = "MORADOR_ID") })
    @JsonBackReference
    private List<Casa> casas;

    @OneToMany(mappedBy = "morador", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Contrato> contratos;

    @Column(length = 1, nullable = false)
    private String situacao;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public List<Aluguel> getAlugueis() {
	return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
	this.alugueis = alugueis;
    }

    public List<Observacao> getObservacoes() {
	return observacoes;
    }

    public void setObservacoes(List<Observacao> observacoes) {
	this.observacoes = observacoes;
    }

    public List<Casa> getCasas() {
	return casas;
    }

    public void setCasas(List<Casa> casas) {
	this.casas = casas;
    }

    public List<Contrato> getContratos() {
	return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
	this.contratos = contratos;
    }

    public String getSituacao() {
	return situacao;
    }

    public void setSituacao(String situacao) {
	this.situacao = situacao;
    }

}
