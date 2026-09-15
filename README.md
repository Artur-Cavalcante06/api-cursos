# API de Cursos

## Atividade 01 — Fluxo cliente e servidor

Quando um cliente consulta o endpoint `GET /cursos`, acontece o seguinte fluxo:

1. O cliente envia uma requisição HTTP `GET` para o endereço `/cursos`.
2. O servidor recebe essa requisição no back-end.
3. O back-end processa a solicitação.
4. O servidor prepara uma resposta HTTP contendo os dados solicitados.
5. A resposta HTTP é devolvida ao cliente.

### Fluxo da aplicação

Cliente → Requisição HTTP → Back-end → Processamento → Resposta HTTP → Cliente

### Identificação

- **Cliente:** programa ou aplicação que faz a requisição HTTP.
- **Servidor:** aplicação back-end responsável por receber e processar a requisição.
- **Request:** requisição `GET /cursos` enviada pelo cliente.
- **Processamento:** o back-end recebe e processa a solicitação.
- **Response:** resposta HTTP devolvida pelo servidor ao cliente.
- ## Atividade 02 — Responsabilidades do back-end

Ao receber um cadastro de curso, o back-end deverá:

1. Receber os dados enviados pelo cliente.
2. Transformar os dados em um objeto Java.
3. Verificar as regras do curso.
4. Salvar o curso.
5. Devolver uma resposta ao cliente.

O back-end é responsável por processar a solicitação recebida e executar as regras necessárias antes de devolver uma resposta ao cliente.
## Atividade 03 — Contrato inicial da API

A API de cursos oferecerá as seguintes operações:

| Método HTTP | Endpoint | Operação | Resultado esperado |
|---|---|---|---|
| GET | `/cursos` | Listar todos os cursos | 200 OK |
| GET | `/cursos/{id}` | Buscar um curso pelo ID | 200 OK ou 404 Not Found |
| POST | `/cursos` | Cadastrar um curso | 201 Created |
| PUT | `/cursos/{id}` | Atualizar um curso | 200 OK ou 404 Not Found |
| DELETE | `/cursos/{id}` | Remover um curso | 204 No Content ou 404 Not Found |

Esses endpoints formam o CRUD da API de cursos.
## Atividade 04 — Arquitetura em camadas

O projeto foi organizado em camadas para separar as responsabilidades da aplicação:

- **Controller:** recebe as requisições HTTP e devolve as respostas.
- **Service:** contém as regras de negócio da aplicação.
- **Repository:** responsável pelo acesso aos dados.
- **Model:** representa a entidade Curso.

### Estrutura do projeto

```text
br.edu.nassau.apicursos
├── controller
│   └── CursoController.java
├── model
│   └── Curso.java
├── repository
│   └── CursoRepository.java
└── service
    └── CursoService.java
O Controller não acessa diretamente o banco de dados. As requisições passam pelo Service, que utiliza o Repository para realizar as operações de persistência.

## Atividade 05 — PostgreSQL e JPA

A aplicação foi configurada para utilizar o PostgreSQL como banco de dados.

Banco utilizado:

- **Nome:** api_cursos
- **SGBD:** PostgreSQL
- **Tabela:** cursos

A entidade `Curso` foi configurada com JPA utilizando `@Entity`, `@Table`, `@Id` e `@GeneratedValue`.

O acesso ao banco é realizado pelo `CursoRepository`, que utiliza `JpaRepository`.

## Endpoints da API

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/cursos` | Lista todos os cursos |
| GET | `/cursos/{id}` | Busca um curso pelo ID |
| POST | `/cursos` | Cadastra um curso |
| PUT | `/cursos/{id}` | Atualiza um curso |
| DELETE | `/cursos/{id}` | Exclui um curso |

## Testes realizados

Foram realizados testes dos principais endpoints da API:

- Cadastro de curso com `POST /cursos`.
- Listagem com `GET /cursos`.
- Busca por ID com `GET /cursos/{id}`.
- Atualização com `PUT /cursos/{id}`.
- Exclusão com `DELETE /cursos/{id}`.
- Verificação do código HTTP `204` após exclusão.
- Verificação dos dados diretamente no PostgreSQL.

## Persistência dos dados

Foi realizado um teste de persistência:

1. Um curso foi cadastrado na API.
2. O registro foi confirmado no PostgreSQL.
3. A aplicação Spring Boot foi encerrada.
4. A aplicação foi iniciada novamente.
5. O curso continuou disponível através do endpoint `GET /cursos`.

Esse teste confirmou que os dados estão sendo persistidos no PostgreSQL e não apenas mantidos em memória.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- Git