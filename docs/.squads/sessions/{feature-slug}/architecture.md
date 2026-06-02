# Arquitetura do Sistema

O projeto segue o padrão de **Arquitetura em Camadas (Layered Architecture)**, desenhado para isolar responsabilidades, facilitar a manutenção e promover a reutilização de código.

## 1. Visão Geral das Camadas

### 1.1. Camada de Apresentação (Controllers)
- **Responsabilidade:** Expor endpoints REST (`@RestController`), receber requisições HTTP e retornar respostas HTTP apropriadas.
- **Características:**
  - Utiliza DTOs (Data Transfer Objects) para entrada e saída.
  - Realiza validações iniciais via anotações (`@Valid`, `@NotBlank`, `@Email`).
  - Padroniza respostas usando a classe `ApiResponse`.

### 1.2. Camada de Negócio (Services)
- **Responsabilidade:** Conter a lógica de negócio principal da aplicação.
- **Características:**
  - Transforma regras de negócio em código.
  - Lança exceções de domínio (`BusinessException`) quando as regras são violadas.
  - Orquestra integrações entre diferentes repositórios e provedores (ex: `AuthenticationService` chama o `UserRepository` e o `JwtService`).

### 1.3. Camada de Acesso a Dados (Repositories)
- **Responsabilidade:** Interagir com o banco de dados.
- **Características:**
  - Interfaces estendendo `JpaRepository`.
  - Oculta a complexidade das queries SQL do restante da aplicação.

### 1.4. Camada de Domínio (Models)
- **Responsabilidade:** Representar as entidades de negócio e o schema do banco de dados.
- **Características:**
  - Anotadas com anotações JPA (`@Entity`, `@Table`, etc.).

## 2. Preocupações Transversais (Cross-Cutting Concerns)

### 2.1. Segurança
- Arquitetura **Stateless**: Não há sessões armazenadas no servidor.
- Validação baseada em Token (JWT): O `JwtAuthenticationFilter` intercepta requisições, extrai o token, valida a assinatura e autentica o usuário no `SecurityContextHolder`.

### 2.2. Tratamento de Exceções
- Centralizado via `GlobalExceptionHandler` (`@RestControllerAdvice`).
- Captura exceções como `BusinessException`, `MethodArgumentNotValidException` e `AuthenticationException`, garantindo que a API sempre retorne o formato padronizado do `ApiResponse` em vez de stack traces expostos.