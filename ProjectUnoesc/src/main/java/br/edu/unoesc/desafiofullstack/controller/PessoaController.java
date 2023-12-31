package br.edu.unoesc.desafiofullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.desafiofullstack.classes.AtualizaContato;
import br.edu.unoesc.desafiofullstack.classes.AtualizaPessoa;
import br.edu.unoesc.desafiofullstack.classes.ConsultaCompleta;
import br.edu.unoesc.desafiofullstack.classes.Endereco;
import br.edu.unoesc.desafiofullstack.classes.Pessoa;
import br.edu.unoesc.desafiofullstack.classes.ViaCepRecord;
import br.edu.unoesc.desafiofullstack.entities.EntityContato;
import br.edu.unoesc.desafiofullstack.entities.EntityEndereco;
import br.edu.unoesc.desafiofullstack.entities.EntityPessoa;
import br.edu.unoesc.desafiofullstack.repositories.ContatoRepository;
import br.edu.unoesc.desafiofullstack.repositories.EnderecoRepository;
import br.edu.unoesc.desafiofullstack.repositories.PessoaRepository;
import br.edu.unoesc.desafiofullstack.services.ConsultaService;
import br.edu.unoesc.desafiofullstack.services.ViaCepService;

/**
 * Controlador responsável pelas operações relacionadas ao cadastro e consulta de pessoas.
 * Utiliza as funcionalidades das classes de serviços e repositórios para interagir com o banco de dados.
 */

@RestController
@RequestMapping(value = "/pessoa") 
public class PessoaController {
	
	//Definição de injeção de dependência,passando objeto para controller automaticamente
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private ContatoRepository contatoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	@Autowired
	private ConsultaService servicoConsulta;
	
	/**
     * Cadastra uma nova pessoa.
     *
     * @param pessoaJson Objeto contendo os dados da pessoa a ser cadastrada.
     */
	@PostMapping(value = "/cadastro")
	public void cadastraPessoa(@RequestBody Pessoa pessoaJson) { 
		pessoaRepository.save(new EntityPessoa(pessoaJson));
	}
	
	/**
     * Lista todas as pessoas cadastradas paginadas.
     *
     * @param paginacao Objeto contendo informações sobre a página atual.
     * @return Página de pessoas cadastradas.
     */
	@GetMapping(value = "/cadastro")
	public Page<Pessoa> listarPessoas(Pageable paginacao){
		return pessoaRepository.findAll(paginacao).map(Pessoa::new);
	}
	
	/**
     * Consulta todas as informações de uma pessoa.
     *
     * @param codigo Código identificador da pessoa.
     * @return Objeto contendo todas as informações da pessoa, contato e endereço.
     */
	@GetMapping(value = "/cadastro/{codigo}")
	public ConsultaCompleta consultaCompleta(@PathVariable Long codigo) {
		EntityPessoa pessoa = pessoaRepository.findById(codigo).get();
		EntityContato contato = servicoConsulta.buscaContato(pessoa);
		EntityEndereco endereco = servicoConsulta.buscaEndereco(pessoa);
		ConsultaCompleta consulta = new ConsultaCompleta(pessoa, endereco, contato);
		return consulta;
	}
	
	/**
     * Atualiza os dados de cadastro de uma pessoa.
     *
     * @param codigo Código identificador da pessoa a ser atualizada.
     * @param consultaJson Objeto contendo os dados a serem atualizados.
     */
	@PutMapping(value = "/cadastro/{codigo}")
	@Transactional
	public void atualizaPessoa(
			@PathVariable Long codigo,
			@RequestBody AtualizaPessoa consultaJson) {
		EntityPessoa pessoa = pessoaRepository.getReferenceById(codigo);
		pessoa.atualizaCadastro(consultaJson);
	}
	
	/**
     * Exclui uma pessoa pelo seu código identificador.
     *
     * @param codigo Código identificador da pessoa a ser excluída.
     */
	@DeleteMapping(value = "/{codigo}")
	public void excluirPessoa(@PathVariable Long codigo){
		EntityPessoa pessoa = pessoaRepository.getReferenceById(codigo);
		pessoaRepository.deleteById(pessoa.getCodigo());
	}
	
	/**
     * Cadastra um novo contato para uma pessoa.
     *
     * @param codigo Código identificador da pessoa.
     * @param contatoJson Objeto contendo os dados do contato a ser cadastrado.
     * @return Objeto contendo os dados do contato cadastrado.
     */
	@PostMapping(value = "/{codigo}/contato")
	public EntityContato cadastraContato(
			@PathVariable Long codigo,
			@RequestBody EntityContato contatoJson) { 
		EntityPessoa pessoa = pessoaRepository.findById(codigo).get();
		contatoJson.setPessoa(pessoa);
		EntityContato contato = contatoRepository.save(contatoJson);
		return contato;
	}
	
	/**
     * Atualiza os dados do contato de uma pessoa.
     *
     * @param codigo Código identificador da pessoa.
     * @param consultaJson Objeto contendo os dados a serem atualizados.
     */
	@PutMapping(value = "/{codigo}/contato")
	public void atualizaContato(
			@PathVariable Long codigo,
			@RequestBody AtualizaContato consultaJson) {
		EntityPessoa pessoa = pessoaRepository.findById(codigo).get();
		EntityContato contato = servicoConsulta.buscaContato(pessoa);
		contato = contatoRepository.getReferenceById(contato.getCodigo());
		contato.atualizaContato(consultaJson);
		contatoRepository.save(contato);
		System.out.println(contato.getTelefone());
	}
	
	/**
     * Exclui o contato de uma pessoa.
     *
     * @param codigo Código identificador da pessoa.
     */
	@DeleteMapping(value = "/{codigo}/contato")
	public void excluirContato(@PathVariable Long codigo){
		EntityPessoa pessoa = pessoaRepository.findById(codigo).get();
		EntityContato contato = servicoConsulta.buscaContato(pessoa);
		contato = contatoRepository.getReferenceById(contato.getCodigo());
		contatoRepository.deleteById(contato.getCodigo());
	}
	
	/**
     * Cadastra um novo endereço para uma pessoa.
     *
     * @param codigo Código identificador da pessoa.
     * @param enderecoJson Objeto contendo os dados do endereço a ser cadastrado.
     * @return Objeto contendo os dados do endereço cadastrado.
     */
	@PostMapping(value = "/{codigo}/endereco")
	@Transactional
	public EntityEndereco cadastraEndereco(
			@PathVariable Long codigo,
			@RequestBody Endereco enderecoJson) {
		EntityPessoa pessoa = pessoaRepository.findById(codigo).get();
		ViaCepRecord validaCep = viaCepService.validaEndereco(enderecoJson);
		EntityEndereco endereco = new EntityEndereco();
		endereco.setPessoa(pessoa);
		endereco.setCep(validaCep.cep());
		endereco.setMunicipio(validaCep.localidade());
		endereco.setEstado(validaCep.uf());
		enderecoRepository.save(endereco);
		return endereco;
	}
	
	/**
     * Atualiza os dados do endereço de uma pessoa.
     *
     * @param codigo Código identificador da pessoa.
     * @param enderecoJson Objeto contendo os dados a serem atualizados.
     */
	@PutMapping(value = "/{codigo}/endereco")
	public void atualizaEndereco(
			@PathVariable Long codigo,
			@RequestBody Endereco enderecoJson) {
		EntityPessoa pessoa = pessoaRepository.findById(codigo).get();
		ViaCepRecord validaCep = viaCepService.validaEndereco(enderecoJson);
		EntityEndereco endereco = new EntityEndereco();
		endereco = servicoConsulta.buscaEndereco(pessoa);
		endereco = enderecoRepository.getReferenceById(endereco.getCodigo());
		endereco.setPessoa(pessoa);
		endereco.setCep(validaCep.cep());
		endereco.setMunicipio(validaCep.localidade());
		endereco.setEstado(validaCep.uf());
		endereco.atualizaEndereco(enderecoJson);
		enderecoRepository.save(endereco);
		System.out.println(endereco.getCep());
	}	
	
	/**
	 * Deleta endereco de pessoa
     *
     * @param codigo Código identificador da pessoa.
     * @param enderecoJson Objeto contendo os dados a serem atualizados.
     */
	@DeleteMapping(value = "/{codigo}/endereco")
	public void excluirEndereco(@PathVariable Long codigo){
		EntityPessoa pessoa = pessoaRepository.findById(codigo).get();
		EntityEndereco endereco = servicoConsulta.buscaEndereco(pessoa);
		endereco = enderecoRepository.getReferenceById(endereco.getCodigo());
		enderecoRepository.deleteById(endereco.getCodigo());
	}
	
}
