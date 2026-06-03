## Consulta de Perfil Logado (Endpoint /me) #11

**Objetivo:** Retornar os dados do usuário atual extraindo a identidade diretamente do `SecurityContextHolder` (alimentado pelo JWT), sem expor ou exigir IDs na URL.
- **Rota:** `GET /api/users/me`
- **Retorno:** `ApiResponse<ProfileDTO>`
## 🔗 Tarefas Vinculadas (Child Issues)
- [ ] **#11** - Implementação da Consulta de Perfil Logado (`GET /api/users/me`).
- [ ] **#12** - Implementação da Atualização de Dados Cadastrais (`PUT /api/users/me`).
- [ ] **#13** - Implementação da Alteração de Senha Segura (`PUT /api/users/me/password`).