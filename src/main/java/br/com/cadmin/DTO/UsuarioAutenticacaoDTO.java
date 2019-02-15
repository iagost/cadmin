package br.com.cadmin.DTO;

import javax.validation.constraints.NotEmpty;

public class UsuarioAutenticacaoDTO {

    @NotEmpty
    private String login;
    @NotEmpty
    private String senha;

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

}
