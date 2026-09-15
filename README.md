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