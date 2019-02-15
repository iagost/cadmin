package br.com.cadmin.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Aluguel implements Serializable {

    /**
     * @author iago
     */
    private static final long serialVersionUID = 3196620939306978851L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonBackReference
    private Morador morador;

    @Column
    private Date vencimento;

    @Column(length = 1)
    private String situacaoAluguel;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Morador getMorador() {
	return morador;
    }

    public void setMorador(Morador morador) {
	this.morador = morador;
    }

    public Date getVencimento() {
	return vencimento;
    }

    public void setVencimento(Date vencimento) {
	this.vencimento = vencimento;
    }

    public String getSituacaoAluguel() {
	return situacaoAluguel;
    }

    public void setSituacaoAluguel(String situacaoAluguel) {
	this.situacaoAluguel = situacaoAluguel;
    }

}
