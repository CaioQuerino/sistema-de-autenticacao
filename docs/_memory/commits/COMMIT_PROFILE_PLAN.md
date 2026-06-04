# Plano de Commits - Gestão de Perfil (Epic #2)

Siga esta ordem para garantir que cada commit seja atômico e funcional.

### 1. Entidade e Segurança Core
**Mensagem:** `feat(model): implementar UserDetails na entidade User para integração com Spring Security`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/model/User.java`

### 2. Lógica de Serviço
**Mensagem:** `feat(service): adicionar método para recuperar perfil do usuário autenticado via SecurityContext`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/service/UserService.java`

### 3. Endpoint REST
**Mensagem:** `feat(controller): expor endpoint GET /api/users/me para consulta de perfil`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/controller/UserController.java`

### 4. Refinamento de Segurança e Debug
**Mensagem:** `feat(security): configurar handlers de 401/403 e logs de debug no filtro JWT`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/config/SecurityConfig.java`
- `src/main/java/br/com/querino/autenticacao/config/JwtAuthenticationFilter.java`

### 5. Serviço de Autenticação
**Mensagem:** `fix(service): corrigir mapeamento de userName para username no ProfileDTO`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/service/AuthenticationService.java`

### 6. Documentação e Rastreabilidade da Epic #1
**Mensagem:** `docs(auth): atualizar status da epic e memorias do modulo de autenticacao`
**Arquivos:**
- `docs/_memory/epics/EPIC_AUTH_FLOW.md`
- `docs/_memory/epics/auth/issue#2.md`
- `docs/_memory/epics/auth/issue#3.md`
- `docs/_memory/epics/auth/issue#4.md`

### 7. Documentação e Rastreabilidade da Epic #2
**Mensagem:** `docs(profile): atualizar status da epic e memorias do modulo de perfil`
**Arquivos:**
- `docs/_memory/epics/EPIC_PROFILE_MANAGEMENT.md`
- `docs/_memory/commits/COMMIT_PROFILE_PLAN.md`
- `docs/_memory/epics/profile/memories.md`
- `docs/_memory/epics/profile/issue#11.md`
- `docs/_memory/epics/profile/issue#12.md`
- `docs/_memory/epics/profile/issue#13.md`

### 8. Atualização de Perfil (Issue #12)
**Mensagem:** `feat(profile): adicionar endpoint para atualização do perfil do usuário autenticado`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/controller/UserController.java`
- `src/main/java/br/com/querino/autenticacao/service/UserService.java`
- `src/main/java/br/com/querino/autenticacao/dto/ProfileDTO.java`

### 9. Correção de Erro de Token JWT
**Mensagem:** `fix(auth): substituir print de erro por comentário para falha silenciosa no processamento de token JWT`
**Arquivos:**
- `src/main/java/br/com/querino/autenticacao/config/JwtAuthenticationFilter.java`

### 10. Atualização do Plano de Commits
**Mensagem:** `feat(profile): atualizar plano de commits e corrigir descrição da atualização de dados cadastrais`
**Arquivos:**
- `docs/_memory/commits/COMMIT_PROFILE_PLAN.md`
- `docs/_memory/epics/profile/issue#13.md`
- `docs/_memory/memories.md`
- `docs/_memory/pull_requests/pull_request_template.md`

---

## Comandos para Execução Rápida:
```bash
git add src/main/java/br/com/querino/autenticacao/model/User.java && git commit -m "feat(model): implementar UserDetails na entidade User para integração com Spring Security"
git add src/main/java/br/com/querino/autenticacao/service/UserService.java && git commit -m "feat(service): adicionar método para recuperar perfil do usuário autenticado via SecurityContext"
git add src/main/java/br/com/querino/autenticacao/controller/UserController.java && git commit -m "feat(controller): expor endpoint GET /api/users/me para consulta de perfil"
git add src/main/java/br/com/querino/autenticacao/config/SecurityConfig.java src/main/java/br/com/querino/autenticacao/config/JwtAuthenticationFilter.java && git commit -m "feat(security): configurar handlers de 401/403 e logs de debug no filtro JWT"
git add docs/_memory/epics/EPIC_PROFILE_MANAGEMENT.md docs/_memory/epics/profile/memories.md docs/_memory/commits/COMMIT_PROFILE_PLAN.md && git commit -m "docs(profile): atualizar status da epic e memorias do modulo de perfil"
```
