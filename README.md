
# 🚀 FórumHub API <img src="https://raw.githubusercontent.com/LuandaLl/Alura-Forum/main/Badge-Spring.png" alt="Simbolo spring 2d" width="45" align="center">


O FórumHub é uma API REST desenvolvida em Java com Spring Boot, criada como um desafio (Challenge) para replicar o funcionamento de um fórum de discussões. A aplicação foca no gerenciamento de tópicos (CRUD) e possui um sistema robusto de autenticação e segurança utilizando tokens JWT.
🛠️ Tecnologias Utilizadas

    Java 17/21

    Spring Boot 3

    Spring Security (Autenticação e Autorização)

    JSON Web Token (JWT)

    Spring Data JPA

    MySQL (Banco de dados)

    Flyway (Migrações de banco de dados)

    Lombok

    Maven

📌 Funcionalidades
Tópicos (/topicos)

    Cadastrar: Criação de novos tópicos (bloqueia duplicatas com mesmo título e mensagem).

    Listar: Listagem paginada e ordenada por data de criação.

    Detalhar: Visualização de um tópico específico por ID.

    Atualizar: Edição de título e mensagem.

    Excluir: Remoção lógica ou física do banco de dados.

Segurança

    Autenticação: Login via /login que retorna um Token JWT.

    Proteção: Todos os endpoints de tópicos exigem o cabeçalho Authorization: Bearer <token>.

⚙️ Como rodar o projeto

1. Pré-requisitos

    * JDK 17 ou superior.

    * MySQL Server rodando.

    * VS Code (ou IntelliJ/Eclipse).
   

3. Configuração do Banco de Dados

* Crie o banco de dados no seu terminal MySQL:
SQL

* CREATE DATABASE forumhub_db;

3. Variáveis de Ambiente

Crie um arquivo .env na raiz do projeto e preencha com suas credenciais:
Snippet de código

DB_URL=jdbc:mysql://localhost:3306/forumhub_db
|-----------------------------------------------|

DB_USERNAME=seu_usuario
|-----------------------------------------------|

DB_PASSWORD=sua_senha
|-----------------------------------------------|

JWT_SECRET=sua_chave_secreta_super_segura
|-----------------------------------------------|

4. Execução

No terminal do projeto, execute:
Bash

mvn spring-boot:run

🧪 Testes

Para rodar os testes unitários e de integração:
Bash

mvn test

📜 Endpoints Principais
| Método | Endpoint | Descrição | Autenticação |
| :--- | :--- | :--- | :---: |
| POST | `/login` | Gera o token JWT | Não |
| POST | `/topicos` | Cadastra um tópico | Sim |
| GET | `/topicos` | Lista tópicos (paginado) | Sim |
| GET | `/topicos/{id}` | Detalha um tópico | Sim |
| PUT | `/topicos/{id}` | Atualiza um tópico | Sim |
| DELETE | `/topicos/{id}` | Exclui um tópico | Sim |

👨‍💻 Autor

Desenvolvido por [Luanda].
