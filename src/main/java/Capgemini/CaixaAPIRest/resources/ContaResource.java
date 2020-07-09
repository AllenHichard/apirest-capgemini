package Capgemini.CaixaAPIRest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Capgemini.CaixaAPIRest.models.Conta;
import Capgemini.CaixaAPIRest.repository.ContaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST CONTAS")
@CrossOrigin(origins = "*") // Todos os domínios podem acessar
public class ContaResource {

	@Autowired
	ContaRepository contaRepository;
	
	@ApiOperation(value="Retorna uma lista de contas")
	@GetMapping("/contas")
	public List<Conta> ListaContas(){
		return contaRepository.findAll();
	}
	
	@ApiOperation(value="Retorna uma conta única")
	@GetMapping("/conta/{id}")
	public Conta ListaContaUnico(@PathVariable(value = "id") long id){
		return contaRepository.findById(id);
	}
	
	@ApiOperation(value="Salva uma conta")
	@PostMapping("/conta")
	public Conta salvarConta(@RequestBody Conta conta){
		return contaRepository.save(conta);
	}
	
	@ApiOperation(value="Deleta uma conta baseado no ID")
	@DeleteMapping("/conta")
	public void deleteConta(@RequestBody Conta conta){
		contaRepository.delete(conta);
	}
	
	@ApiOperation(value="Atualiza uma conta")
	@PutMapping("/conta")
	public Conta UpdateConta(@RequestBody Conta conta){
		return contaRepository.save(conta);
	}
	
	
}
