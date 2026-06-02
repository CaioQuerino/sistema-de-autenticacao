# Plano de Commits - Fluxo de Autenticação

Siga esta ordem para garantir que cada commit seja atômico e funcional.

### 1. Infraestrutura e Ambiente
**Mensagem:** `chore: configuração spring application nome e docker environment`
**Arquivos:**
- `docker-compose.yml`
**Execução:**
```bash
git add docker-compose.yml
git commit -m "chore: configuração spring application nome e docker environment"
```

### 2. Padronização de Respostas (DTOs)
**Mensagem:** `feat: implementei ApiResponse e ProfileDTO para padronizar comunicação`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/dto/ApiResponse.java`
- `src/main/java/br/com/querino/autenticacao/dto/ProfileDTO.java`
**Execução:**
```bash
git add src/main/java/br/com/querino/autenticacao/dto/ApiResponse.java src/main/java/br/com/querino/autenticacao/dto/ProfileDTO.java
git commit -m "feat: implementei ApiResponse e ProfileDTO para padronizar comunicação"
```

### 3. Gestão de Exceções de Negócio
**Mensagem:** `feat: criei BusinessException para domain-specific exceptions`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/exception/BusinessException.java`
**Execução:**
```bash
git add src/main/java/br/com/querino/autenticacao/exception/BusinessException.java
git commit -m "feat: criei BusinessException para domain-specific exceptions"
```

### 4. Refatoração da Camada de Serviço
**Mensagem:** `feat: refatoração do UserService para usar BusinessException para validações`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/service/UserService.java`
**Execução:**
```bash
git add src/main/java/br/com/querino/autenticacao/service/UserService.java
git commit -m "feat: refatoração do UserService para usar BusinessException para validações"
```

### 5. Controller e Tratamento Global
**Mensagem:** `feat: implementei UserController e GlobalExceptionHandler`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/controller/UserController.java`
- `src/main/java/br/com/querino/autenticacao/exception/GlobalExceptionHandler.java`
**Execução:**
```bash
git add src/main/java/br/com/querino/autenticacao/controller/UserController.java src/main/java/br/com/querino/autenticacao/exception/GlobalExceptionHandler.java
git commit -m "feat: implementei UserController e GlobalExceptionHandler"
```

### 6. Documentação de Memória
**Mensagem:** `docs: Atualização de memories com authentication e authorization`
**Arquivos:**
- `docs/_memory/memories.md`
**Execução:**
```bash
git add docs/_memory/memories.md
git commit -m "docs: Atualização de memories com authentication e authorization"
```

### 7. Segurança: Dependências e Provedor JWT
**Mensagem:** `feat: implementei JwtService e adicionei dependências para gerar JWT`
**Arquivos:**
- `pom.xml`
- `src/main/java/br/com/querino/autenticacao/service/JwtService.java`
**Execução:**
```bash
git add pom.xml src/main/java/br/com/querino/autenticacao/service/JwtService.java
git commit -m "feat: implement JwtService and add JWT dependencies"
```

### 8. Segurança: Configuração Spring Security
**Mensagem:** `feat: configuração do Spring Security beans, filters e rules`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/config/ApplicationConfig.java`
- `src/main/java/br/com/querino/autenticacao/config/JwtAuthenticationFilter.java`
- `src/main/java/br/com/querino/autenticacao/config/SecurityConfig.java`
**Execução:**
```bash
git add src/main/java/br/com/querino/autenticacao/config/ApplicationConfig.java src/main/java/br/com/querino/autenticacao/config/JwtAuthenticationFilter.java src/main/java/br/com/querino/autenticacao/config/SecurityConfig.java
git commit -m "feat: configuração do Spring Security beans, filters e rules"
```

### 9. Infraestrutura e Refatoração de Injeção
**Mensagem:** `chore: atualiza docker environment e refatoração de PasswordEncoder injection`
**Arquivos:**
- `.env`
- `docker-compose.yml`
- `src/main/java/br/com/querino/autenticacao/service/UserService.java`
**Execução:**
```bash
git add .env docker-compose.yml src/main/java/br/com/querino/autenticacao/service/UserService.java
git commit -m "chore: atualiza docker environment e refatoração de PasswordEncoder injection"
```

### 10. Documentação do PR e Epic
**Mensagem:** `docs: adiciona Pull Request template e refina Auth Epic`
**Arquivos:**
- `PULL_REQUEST.md`
- `docs/_memory/epics/EPIC_AUTH_FLOW.md`
**Execução:**
```bash
git add PULL_REQUEST.md docs/_memory/epics/EPIC_AUTH_FLOW.md
git commit -m "docs: add Pull Request template and refine Auth Epic"

### 11. Autenticação: Endpoint de Login e DTOs
**Mensagem:** `feat: implementa login controller, service e dtos de autenticação`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/dto/AuthenticationRequest.java`
- `src/main/java/br/com/querino/autenticacao/dto/AuthenticationResponse.java`
- `src/main/java/br/com/querino/autenticacao/service/AuthenticationService.java`
- `src/main/java/br/com/querino/autenticacao/controller/AuthenticationController.java`
**Execução:**
```bash
git add src/main/java/br/com/querino/autenticacao/dto/AuthenticationRequest.java src/main/java/br/com/querino/autenticacao/dto/AuthenticationResponse.java src/main/java/br/com/querino/autenticacao/service/AuthenticationService.java src/main/java/br/com/querino/autenticacao/controller/AuthenticationController.java
git commit -m "feat: implementa login controller, service e dtos de autenticação"
```

### 12. Segurança: Estabilização e Tratamento de Erros
**Mensagem:** `fix: trata AuthenticationException e melhora robustez do filtro JWT`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/exception/GlobalExceptionHandler.java`
- `src/main/java/br/com/querino/autenticacao/config/JwtAuthenticationFilter.java`
**Execução:**
```bash
git add src/main/java/br/com/querino/autenticacao/exception/GlobalExceptionHandler.java src/main/java/br/com/querino/autenticacao/config/JwtAuthenticationFilter.java
git commit -m "fix: trata AuthenticationException e melhora robustez do filtro JWT"
```

### 13. Segurança: Ajustes de Mapeamento e Referência Circular
**Mensagem:** `fix: resolve circular dependency and UserDetails class cast exception`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/config/ApplicationConfig.java`
- `src/main/java/br/com/querino/autenticacao/service/JwtService.java`
**Execução:**
```bash
git add src/main/java/br/com/querino/autenticacao/config/ApplicationConfig.java src/main/java/br/com/querino/autenticacao/service/JwtService.java src/main/java/br/com/querino/autenticacao/config/SecurityConfig.java
git commit -m "fix: resolve circular dependency and UserDetails class cast exception"
```

### 14. Correção de Healthcheck
**Mensagem:** `fix: corrige comando de healthcheck para o serviço de banco de dados`
**Arquivos:**
- `docker-compose.yml`
**Execução:**
```bash
git add docker-compose.yml
git commit -m "fix: corrige comando de healthcheck para o serviço de banco de dados"
```

### 15. Adição de Endpoint de Login e DTOs de Autenticação
**Mensagem:** `feat: adiciona endpoint de login e DTOs de autenticação`
**Arquivos:**
- `docs/_memory/commits/COMMIT_AUTH_PLAN.md`
**Execução:**
```bash
git add docs/_memory/commits/COMMIT_AUTH_PLAN.md
git commit -m "feat: adiciona endpoint de login e DTOs de autenticação"
```

### 16. Aprimoramento do Script de Inicialização
**Mensagem:** `fix: aprimora script de inicialização do projeto para melhor gerenciamento de containers`
**Arquivos:**
- `START_PROJECT.BAT`
**Execução:**
```bash
git add START_PROJECT.BAT
git commit -m "fix: aprimora script de inicialização do projeto para melhor gerenciamento de containers"
```

