package br.com.cadmin.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadmin.DTO.UsuarioAutenticacaoDTO;
import br.com.cadmin.modelo.Usuario;
import br.com.cadmin.service.UsuarioService;
import br.com.cadmin.validacao.Response;

@RestController
@RequestMapping("/cadmin/usuario")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
	this.service = service;
    }

    @PostMapping
    public ResponseEntity<Response<Usuario>> inserir(@Valid @RequestBody Usuario usuario, BindingResult result) {
	Response<Usuario> response = new Response<Usuario>();

	if (result.hasErrors()) {
	    result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
	    return ResponseEntity.badRequest().body(response);
	}

	if (service.existsUsuario(usuario.getCpf()) == false) {
	    service.inserir(usuario);
	} else {
	    response.getErrors().add("Já existe um usuário cadastrado com esse cpf");
	    return ResponseEntity.badRequest().body(response);
	}

	response.setData(usuario);

	return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Usuario>> getUsuario(@PathVariable Long id) {

	Response<Usuario> response = new Response<Usuario>();

	Usuario u = service.getUsuario(id);
	if (u == null) {
	    response.getErrors().add("nenhum registro encontrado");
	    return ResponseEntity.badRequest().body(response);
	}

	response.setData(u);

	return ResponseEntity.ok(response);
    }

    @PostMapping("/autenticar")
    public ResponseEntity<Response<Usuario>> autenticar(@Valid @RequestBody UsuarioAutenticacaoDTO usuarioDTO,
	    BindingResult result) {
	Response<Usuario> response = new Response<Usuario>();

	if (result.hasErrors()) {
	    result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
	    return ResponseEntity.badRequest().body(response);
	}

	Usuario usuario = service.autenticar(usuarioDTO.getLogin(), usuarioDTO.getSenha());
	if (usuario == null) {
	    response.getErrors().add("login ou senha incorretos");
	    return ResponseEntity.badRequest().body(response);
	}

	response.setData(usuario);

	return ResponseEntity.ok(response);

    }

}
