package br.com.cadmin.enumeracao;

public enum Perfil {

    ADMINISTRADOR("1", "ADMINISTRADOR"), CLIENTE("0", "CLIENTE");

    private String valor;
    private String descricao;

    Perfil(String valor, String descricao) {
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
