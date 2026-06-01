# 🧠 Memórias e Aprendizados: Auth-Core

## [2026-05-31] Estabilização de Infraestrutura e Implementação do Core

### 🛠️ Aprendizados Principais
- **Spring Boot Executable JAR:** O erro `no main manifest attribute` foi resolvido garantindo a presença do `spring-boot-maven-plugin` e a definição da `Main-Class` no `pom.xml`. Sem isso, o Maven gera um JAR de biblioteca simples, incapaz de iniciar via `java -jar`.
- **Conectividade MySQL 8 no Docker:** Identificamos que o Hibernate 6.x pode falhar com `NullPointerException` se tentar autodetectar o dialeto antes do MySQL estar totalmente pronto. A solução foi explicitar o `MySQLDialect` e o `Driver` via variáveis de ambiente no `docker-compose.yml`.
- **Herança JPA (JOINED):** Validamos que a estratégia `JOINED` é a mais adequada para o domínio Querino, permitindo que `Admin` e `UserGuest` tenham tabelas próprias mantendo o vínculo relacional com a tabela base `User`.
- **Placeholder de Aplicação:** Resolvido erro de inicialização causado pela ausência da variável `SPRING_APPLICATION_NAME` no container.
- **Placeholder de Aplicação:** Resolvido o erro de placeholder não resolvido para `SPRING_APPLICATION_NAME` garantindo que a variável de ambiente seja injetada via Docker Compose.
- **Gestão de Projeto:** Repositório GitHub definido como `CaioQuerino/sistema-de-autenticacao`. Fluxo de autenticação decomposto em sub-tarefas vinculadas à Epic #1.

### ⚖️ Decisões Registradas
- **[DECISÃO CRÍTICA] Segurança de Credenciais:** Implementado `BCryptPasswordEncoder` (Spring Security) para hash de senhas no `UserService`. Nenhuma senha será armazenada em texto plano, respeitando a Regra de Ouro #1.
- **[DECISÃO CRÍTICA] Docker Multi-stage:** Optamos por build multi-stage no `Dockerfile` para reduzir o tamanho da imagem final e isolar o ambiente de compilação (Maven) do ambiente de execução (JRE).
- **[DECISÃO CRÍTICA] Unicidade de Identidade:** Validações de `email` e `userName` foram movidas para a camada de Service antes da criptografia para otimizar o fluxo de erro.

### 📈 Status das Tarefas
- [x] Configuração Maven/Docker para JAR Executável.
- [x] Orquestração de Banco de Dados com Healthcheck.
- [x] Mapeamento de Repositórios JPA Polimórficos.
- [x] Implementação do `UserService` com Registro e Criptografia.
- [x] Implementação do `UserController` e Endpoints REST. #2
- [x] Handler Global de Exceções e Padronização de DTOs. #4
- [ ] Configuração de Filtro JWT para Autenticação. #3

---
*Registro gerado via protocolo synapos:memory*
