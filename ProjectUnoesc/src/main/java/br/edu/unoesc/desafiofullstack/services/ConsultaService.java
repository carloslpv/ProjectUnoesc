package br.edu.unoesc.desafiofullstack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.unoesc.desafiofullstack.entities.EntityContato;
import br.edu.unoesc.desafiofullstack.entities.EntityEndereco;
import br.edu.unoesc.desafiofullstack.entities.EntityPessoa;
import br.edu.unoesc.desafiofullstack.repositories.ContatoRepository;
import br.edu.unoesc.desafiofullstack.repositories.EnderecoRepository;
import br.edu.unoesc.desafiofullstack.repositories.PessoaRepository;

@Service
public class ConsultaService {

	
	@Autowired
	private ContatoRepository contatoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	/**
	 * Busca o endereço associado a uma pessoa no banco de dados.
	 * @param pessoa Objeto `EntityPessoa` representando a pessoa da qual deseja-se obter o endereço.
	 * @return EntityEndereco contendo as informações do endereço associado à pessoa.
	 */
	public EntityEndereco buscaEndereco(EntityPessoa pessoa) {
		EntityEndereco endereco = enderecoRepository.findById(pessoa.getCodigo()).get();
	return endereco;
	}
	
	/**
	 * Busca o contato associado a uma pessoa no banco de dados.
	 * @param pessoa Objeto `EntityPessoa` representando a pessoa da qual deseja-se obter o contato.
	 * @return EntityContato contendo as informações do contato associado à pessoa.
	 */
	public EntityContato buscaContato(EntityPessoa pessoa) {
		EntityContato contato = contatoRepository.findById(pessoa.getCodigo()).get();
		return contato;	
	}
	
	/**
	 * Busca uma pessoa no banco de dados pelo seu código.
	 * @param codigo Código da pessoa que deseja-se obter.
	 * @return EntityPessoa contendo as informações da pessoa encontrada.
	 */
	public EntityPessoa buscaPessoa(@PathVariable Long codigo) {
		EntityPessoa pessoa = pessoaRepository.findById(codigo).get(); //findById retorna um optional, get é usado para capturar o usuário dentro deste optional
		return pessoa;
	}
}
