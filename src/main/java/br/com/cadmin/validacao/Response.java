package br.com.cadmin.validacao;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

    private T data;
    private List<String> errors;

    public Response() {

    }

    public void setData(T data) {
	this.data = data;
    }

    public T getData() {
	return this.data;
    }

    public List<String> getErrors() {
	if (this.errors == null) {
	    this.errors = new ArrayList<String>();
	}
	return errors;
    }

    public void setErrors(List<String> errors) {
	this.errors = errors;
    }

}
