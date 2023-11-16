# Cadastro de Pessoas

## Observações

- Não foram implementados tratamentos de exceção para operações que podem falhar, como tentar excluir uma pessoa que possui contatos ou endereços vinculados.
- As exceções resultantes de requisições à API ViaCEP não foram tratadas.
- O retorno das requisições JSON não foi detalhadamente documentado.
- Não foi desenvolvido o front-end da aplicação, assim como a tela de login.

## Descrição
Este projeto é uma aplicação web para cadastrar e gerenciar informações de pessoas, contatos e endereços.

## Funcionalidades
- Cadastro de pessoas (Nome, CPF, Data de Nascimento, Gênero).
- Cadastro de contato (Telefone, E-mail).
- Cadastro de endereço com preenchimento automático por CEP via API ViaCEP.
- Consulta, edição e exclusão de cadastros.
- Proteção por login.

## Endpoints Principais

- **Cadastrar Pessoa:** `/pessoa/cadastro` (POST)
- **Listar Pessoas:** `/pessoa/cadastro` (GET)
- **Consultar Pessoa:** `/pessoa/cadastro/{codigo}` (GET)
- **Atualizar Pessoa:** `/pessoa/cadastro/{codigo}` (PUT)
- **Excluir Pessoa:** `/pessoa/{codigo}` (DELETE)

- **Cadastrar Contato:** `/pessoa/{codigo}/contato` (POST)
- **Atualizar Contato:** `/pessoa/{codigo}/contato` (PUT)
- **Excluir Contato:** `/pessoa/{codigo}/contato` (DELETE)

- **Cadastrar Endereço:** `/pessoa/{codigo}/endereco` (POST)
- **Atualizar Endereço:** `/pessoa/{codigo}/endereco` (PUT)
- **Excluir Endereço:** `/pessoa/{codigo}/endereco` (DELETE)

## Classes de Serviço

### ViaCepService

A classe `ViaCepService` é responsável por interagir com a API ViaCEP para validar e obter informações de endereços por meio do CEP.

### ConsultaService

A classe `ConsultaService` é responsável por realizar consultas no banco de dados relacionadas a pessoas, contatos e endereços.

## Como Executar

1. Clone o repositório.
2. Configure as propriedades do banco de dados no arquivo `application.properties`.
3. Execute a aplicação.

## Dependências

Para a implementação deste projeto, foram utilizadas as seguintes dependências:

- Spring Boot Starter Thymeleaf
- Spring Boot Starter Web
- Flyway Core
- Flyway MySQL
- Spring Boot DevTools
- MySQL Connector Java
- Spring Boot Starter Tomcat
- Spring Boot Starter Test
- Jakarta Persistence API
- Spring Boot Starter Data JPA
