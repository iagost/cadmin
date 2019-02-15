package br.com.cadmin.enumeracao;

public enum StatusCasa {

    NAO_ALUGADA("0", "NÃO ALUGADA"), ALUGADA("1", "ALUGADA");

    private String valor;
    private String descricao;

    StatusCasa(String valor, String descricao) {
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
