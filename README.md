# 🚀 Sistema de Gestão de Projetos e Demandas

API RESTful desenvolvida em **Java 17 + Spring Boot 3+** para gerenciar projetos e tarefas com segurança, boas práticas e alta qualidade de código.

---

## ✨ Funcionalidades

- ✅ Criação e listagem de **projetos**
- ✅ Criação, listagem, atualização de status e exclusão de **tarefas**
- 🔐 Autenticação via **JWT** (JSON Web Token)
- 🗺️ Mapeamento automático **DTO ↔ Entidade** com **MapStruct**
- 🧪 Testes automatizados (unitários + integração)
- 📚 Documentação interativa com **Swagger/OpenAPI**
- 🐳 Suporte a **Docker** e **docker-compose**
- ⚠️ Tratamento global de erros com mensagens amigáveis
- 🧹 Código limpo, validações com **Bean Validation** e uso de **records**

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.5.6**
- **Spring Data JPA** + **Hibernate**
- **H2 Database** (desenvolvimento) / **PostgreSQL** (produção)
- **Spring Security** + **JWT**
- **MapStruct** (mapeamento DTO)
- **Swagger UI** (documentação)
- **Maven**
- **Docker**

---

##  Como Rodar Localmente

### Pré-requisitos
- JDK 17+
- Maven
- (Opcional) Docker

---

### Passo a passo

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/desafio-gestao-projetos.git
   cd desafio-gestao-projetos

2. Compile o projeto:

./mvnw clean package -DskipTests

3. Execute:
    
java -jar target/*.jar


4. Acesse:

**Swagger:** http://localhost:8080/swagger-ui.html

**H2 Console:** http://localhost:8080/h2-console

→ **JDBC URL:** jdbc:h2:mem:desafio_db

→ **User:** sa

→ **Password:** (deixe em branco)

---


### 🔐 Autenticação

1. **Faça login:**

curl -X POST http://localhost:8080/auth/login \

  -H "Content-Type: application/json" \
  
  -d '{"username":"admin","password":"123456"}'
  
2. **Use o token retornado nos headers das requisições:**

Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.xxxxx

Credenciais padrão: admin / 123456 

---

### 🐳 Com Docker

1. docker-compose up --build
   
2. A API estará disponível em: http://localhost:8080

---

### 🧪 Testes

**Execute os testes com:**

./mvnw test

Inclui:

- Testes unitários com Mockito
- Testes de integração com MockMvc e H2 em memória

---

### 📌 Endpoints Principais

**POST**    /auth/login         Autenticação (retorna JWT)

**POST**     /projects           Criar projeto  

**GET**     /projects            Listar projetos

**POST**    /tasks               Criar tarefa

**GET**     /tasks?status=&priority=&projectId= Filtrar tarefas

**PUT**     /tasks/{id}/status         Atualizar   apenas o status

**DELETE**     /tasks/{id}             Excluir tarefa
