package br.com.cadmin.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.cadmin.enumeracao.StatusCasa;

@Entity
public class Casa implements Serializable {

    /**
     * @author iago
     */
    private static final long serialVersionUID = -5684859725738629998L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String numero;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonBackReference
    private Condominio condominio;

    @Column(length = 1)
    private String status;

    @Column(length = 1, nullable = false)
    private String situacao;

    public String getDescricaoStatus() {
	if (status.equals(StatusCasa.ALUGADA.getValor())) {
	    return StatusCasa.ALUGADA.getDescricao();
	}
	return StatusCasa.NAO_ALUGADA.getDescricao();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Condominio getCondominio() {
	return condominio;
    }

    public void setCondominio(Condominio condominio) {
	this.condominio = condominio;
    }

    public String getNumero() {
	return numero;
    }

    public void setNumero(String numero) {
	this.numero = numero;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getSituacao() {
	return situacao;
    }

    public void setSituacao(String situacao) {
	this.situacao = situacao;
    }

}
