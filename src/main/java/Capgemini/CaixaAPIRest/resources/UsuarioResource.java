package Capgemini.CaixaAPIRest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Capgemini.CaixaAPIRest.models.Usuario;
import Capgemini.CaixaAPIRest.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.math.BigDecimal;
import java.util.List;



@RestController
@RequestMapping(value = "/api")
@Api(value="API REST CONTAS")
@CrossOrigin(origins = "*") // Todos os domínios podem acessar
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;

	
	/*
	@ApiOperation(value="Retorna uma lista de usuários")
	@GetMapping("/usuarios")
	public List<Usuario> ListaUsuarios(){
		return usuarioRepository.findAll();
	}
	
	
	@ApiOperation(value="Retorna um usuário específico pelo cpf")
	@GetMapping("/usuario/{id}")
	public Usuario ListaContaUnico(@PathVariable(value = "id") long  id){
		return usuarioRepository.findById(id);
	}
	
	
	
	@ApiOperation(value="Deleta um usuário baseado no CPF")
	@DeleteMapping("/usuario")
	public void deleteUsuario(@RequestBody Usuario usuario){
		usuarioRepository.delete(usuario);
	}
	
	@ApiOperation(value="Atualiza uma conta")
	@PutMapping("/cadastrarUsuario")
	public Usuario UpdateConta(@RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	*/
	
	
	@ApiOperation(value="Cria um novo usuário")
	@PostMapping("/CriarUsuario")
	public Usuario CriarUsuarioConta(@RequestBody Usuario usuario){
		usuario.setSaldo(new BigDecimal(0.0));
		return usuarioRepository.save(usuario);
	}
	
	
	
	@ApiOperation(value="Validar Login")
	@PostMapping("/procurarUsuario")
	public Usuario getUsuario(@RequestBody Usuario login){
		Usuario usuario = usuarioRepository.findBycpf(login.getCpf());
		if(usuario != null ) {
			if(usuario.getSenha().equals(login.getSenha())) {
				return usuario;
			}
		}
		return login;
	}
	
	@ApiOperation(value="Retorna uma lista de usuários")
	@GetMapping("/usuarios")
	public List<Usuario> ListaUsuarios(){
		return usuarioRepository.findAll();
	}
	
	
	
	
	
	
	
	
}
