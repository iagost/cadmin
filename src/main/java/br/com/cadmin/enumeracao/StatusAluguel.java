package br.com.cadmin.enumeracao;

public enum StatusAluguel {

    PAGO("1", "ATIVO"), PENDENTE("0", "INATIVO");

    private String valor;
    private String descricao;

    StatusAluguel(String valor, String descricao) {
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
