# 🧠 Memórias e Aprendizados: Auth-Core

## [2026-05-31] Estabilização de Infraestrutura e Implementação do Core

### 🛠️ Aprendizados Principais
- **Spring Boot Executable JAR:** O erro `no main manifest attribute` foi resolvido garantindo a presença do `spring-boot-maven-plugin` e a definição da `Main-Class` no `pom.xml`. Sem isso, o Maven gera um JAR de biblioteca simples, incapaz de iniciar via `java -jar`.
- **Conectividade MySQL 8 no Docker:** Identificamos que o Hibernate 6.x pode falhar com `NullPointerException` se tentar autodetectar o dialeto antes do MySQL estar totalmente pronto. A solução foi explicitar o `MySQLDialect` e o `Driver` via variáveis de ambiente no `docker-compose.yml`.
- **Herança JPA (JOINED):** Validamos que a estratégia `JOINED` é a mais adequada para o domínio Querino, permitindo que `Admin` e `UserGuest` tenham tabelas próprias mantendo o vínculo relacional com a tabela base `User`.
- **Placeholder de Aplicação:** Resolvido erro de inicialização causado pela ausência da variável `SPRING_APPLICATION_NAME` no container.
- **Placeholder de Aplicação:** Resolvido o erro de placeholder não resolvido para `SPRING_APPLICATION_NAME` garantindo que a variável de ambiente seja injetada via Docker Compose.
- **Gestão de Projeto:** Repositório GitHub definido como `CaioQuerino/sistema-de-autenticacao`. Epic #1 refinada para incluir Critérios de Aceite (DoD) e Objetivos de Negócio.

### ⚖️ Decisões Registradas
- **[DECISÃO CRÍTICA] Segurança de Credenciais:** Implementado `BCryptPasswordEncoder` (Spring Security) para hash de senhas no `UserService`. Nenhuma senha será armazenada em texto plano, respeitando a Regra de Ouro #1.
- **[DECISÃO CRÍTICA] Docker Multi-stage:** Optamos por build multi-stage no `Dockerfile` para reduzir o tamanho da imagem final e isolar o ambiente de compilação (Maven) do ambiente de execução (JRE).
- **[DECISÃO CRÍTICA] Unicidade de Identidade:** Validações de `email` e `userName` foram movidas para a camada de Service antes da criptografia para otimizar o fluxo de erro.
- **[PADRÃO] Respostas REST:** Todas as respostas da API devem ser encapsuladas no objeto `ApiResponse<T>` para consistência de interface.

### 📈 Status das Tarefas
- [x] Configuração Maven/Docker para JAR Executável.
- [x] Orquestração de Banco de Dados com Healthcheck.
- [x] Mapeamento de Repositórios JPA Polimórficos.
- [x] Implementação do `UserService` com Registro e Criptografia.
- [x] Implementação do `UserController` e Endpoints REST. #2
- [x] Handler Global de Exceções e Padronização de DTOs. #4
- [x] Configuração de Filtro JWT para Autenticação. #3 (JwtService e Filtros implementados)

## [Atual] Conclusão do Épico #1 e Nova Base Documental

### 🛠️ Aprendizados Principais
- **Documentação Estratégica:** A separação clara entre a visão de negócios (`user-flow.md`), arquitetura (`architecture.md`) e DevOps (`ci-cd-explanation.md`) demonstrou ser fundamental para a clareza do projeto e compatibilidade com o Synapos Framework.
- **Refatoração Semântica:** A substituição de `RequestLoginDTO`/`ResponseLoginDTO` por `AuthenticationRequest`/`AuthenticationResponse` aumentou a consistência do código de autenticação.

### ⚖️ Decisões Registradas
- **[DECISÃO CRÍTICA] Estrutura de Memórias por Épico:** Adotada a segregação de memórias (`memories.md`) por épico/feature (ex: `docs/_memory/epics/profile/memories.md`) para otimizar o uso de tokens e manter o foco contextual das inteligências artificiais.
- **[DECISÃO] Transição de Épicos:** O fluxo principal de autenticação foi validado. O **Epic #2 (Gestão de Perfil)** foi oficialmente aberto para consumir o JWT e entregar valor ao usuário final.

### 📈 Status das Tarefas
- [x] Geração das documentações de Negócio (User Flow) e Técnicas (Arquitetura, Stack).
- [x] Criação do guia de CI/CD (GitHub Actions) com build Maven/Java 17.
- [x] Planejamento da Epic de Gestão de Perfil (Issue #10: `GET /api/users/me`).

## [CONCLUÍDO] Epic #2: Gestão de Perfil

### ⚖️ Decisões Registradas
- **[SEGURANÇA] UserDetails Integration:** A entidade `User` passou a implementar `UserDetails` explicitamente, vinculando o `email` ao `getUsername()`. Isso estabilizou a validação de tokens JWT.
- **[SEGURANÇA] ID Abstraction:** Confirmada a diretriz de não utilizar IDs em rotas de recursos próprios (`/me`), prevenindo vulnerabilidades de Broken Object Level Authorization (BOLA).
- **[UX/API] White-listing DTO:** O uso de `ProfileUpdateDTO` garante que apenas campos não sensíveis sejam alterados, ignorando silenciosamente tentativas de modificar `email` ou `roles`.

### 📈 Status das Tarefas
- [x] Implementação de Consulta, Atualização e Troca de Senha.
- [x] Padronização de erros 401/403 com retorno JSON (ApiResponse).

---
*Registro gerado via protocolo synapos:memory*
