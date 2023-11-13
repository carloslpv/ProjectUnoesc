package br.edu.unoesc.desafiofullstack.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.desafiofullstack.classes.Pessoa;

/*
 * Definição de um controller para a url /pessoa,
 *Ou seja, chegou uma requisição para /pessoa, o spring chamará este controller
 */
@RestController
@RequestMapping("pessoa") 
public class PessoaController {

	//Método para cadastrar pessoa, se chegar uma requisição do tipo Post, deverá chamar o método cadastrarPessoa
	@PostMapping
	//Utilizando o padrão DTO - Data Transfer Object utilizado para representar os dados que chegam e saem da API
	public void cadastroPessoa(@RequestBody Pessoa pessoajson) { //neste caso estou dizendo para a aplicação que deve pegar o corpo da requisição
		System.out.println(pessoajson);
	}
	
}
