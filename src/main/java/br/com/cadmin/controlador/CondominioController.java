package br.com.cadmin.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadmin.modelo.Condominio;
import br.com.cadmin.service.CondominioService;
import br.com.cadmin.validacao.Response;

@RestController
@RequestMapping("/cadmin/cdm")
public class CondominioController {

    private final CondominioService service;

    @Autowired
    public CondominioController(CondominioService service) {
	this.service = service;
    }

    @PostMapping
    public ResponseEntity<Response<Condominio>> inserir(@Valid @RequestBody Condominio condominio,
	    BindingResult result) {
	Response<Condominio> response = new Response<Condominio>();

	if (result.hasErrors()) {
	    result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
	    return ResponseEntity.badRequest().body(response);
	}

	if (service.existsCondominio(condominio.getNome()) == false) {
	    service.inserir(condominio);
	} else {
	    response.getErrors().add("Já existe um condominio com a mesma descrição");
	    return ResponseEntity.badRequest().body(response);
	}

	response.setData(condominio);

	return ResponseEntity.ok(response);
    }

}
