package br.com.cadmin.enumeracao;

public enum Situacao {

    ATIVO("1", "ATIVO"), INATIVO("0", "INATIVO");

    private String valor;
    private String descricao;

    Situacao(String valor, String descricao) {
	this.valor = valor;
	this.descricao = descricao;
    }

    public String getDescricao() {
	return descricao;
    }

    public String getValor() {
	return valor;
    }

}
