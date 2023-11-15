package br.edu.unoesc.desafiofullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.desafiofullstack.entities.EntityPessoa;
import br.edu.unoesc.desafiofullstack.repositories.PessoaRepository;
/*
 * Definição de um controller para a url /pessoa,
 *Ou seja, chegou uma requisição para /pessoa, o spring chamará este controller
 */
@RestController
@RequestMapping(value = "/pessoa") 
public class PessoaController {
	
	@Autowired //Definição de injeção de dependência, cria o objeto e passa para o controller automaticamente
	private PessoaRepository repository;
	//Método para cadastrar pessoa, se chegar uma requisição do tipo Post, deverá chamar o método cadastrarPessoa
	@PostMapping
	//Utilizando o padrão DTO - Data Transfer Object utilizado para representar os dados que chegam e saem da API
	public EntityPessoa cadastraPessoa(@RequestBody EntityPessoa pessoajson) { //neste caso estou dizendo para a aplicação que deve pegar o corpo da requisição
		//estou passando para o repository salvar os dados do json com base nas entidades
		EntityPessoa result = repository.save(pessoajson);
		return result;
	}
	
	@GetMapping
	public List<EntityPessoa> listarPessoas(){
		List<EntityPessoa> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{codigo}")
	public EntityPessoa buscaCodigo(@PathVariable Long codigo) {
		EntityPessoa result = repository.findById(codigo).get(); //findById retorna um optional, get é usado para capturar o usuário dentro deste optional
		return result;
		
	}
	
}
