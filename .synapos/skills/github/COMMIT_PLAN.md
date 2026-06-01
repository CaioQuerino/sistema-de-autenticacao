# Plano de Commits - Fluxo de Autenticação

Siga esta ordem para garantir que cada commit seja atômico e funcional.

### 1. Infraestrutura e Ambiente
**Mensagem:** `chore: configuração spring application nome e docker environment`
**Arquivos:**
- `docker-compose.yml`

### 2. Padronização de Respostas (DTOs)
**Mensagem:** `feat: implementei ApiResponse e ProfileDTO para padronizar comunicação`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/dto/ApiResponse.java`
- `src/main/java/br/com/querino/autenticacao/dto/ProfileDTO.java`

### 3. Gestão de Exceções de Negócio
**Mensagem:** `feat: criei BusinessException para domain-specific exceptions`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/exception/BusinessException.java`

### 4. Refatoração da Camada de Serviço
**Mensagem:** `feat: refatoração do UserService para usar BusinessException para validações`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/service/UserService.java`

### 5. Controller e Tratamento Global
**Mensagem:** `feat: implementei UserController e GlobalExceptionHandler`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/controller/UserController.java`
- `src/main/java/br/com/querino/autenticacao/exception/GlobalExceptionHandler.java`

### 6. Documentação de Memória
**Mensagem:** `docs: Atualização de memories com authentication e authorization`
**Arquivos:**
- `docs/_memory/memories.md`
- `.synapos/skills/github/memories.md`

---
*Dica: Use `git add <arquivo>` para adicionar apenas os arquivos de cada grupo antes de rodar o `git commit -m "..."`.*
