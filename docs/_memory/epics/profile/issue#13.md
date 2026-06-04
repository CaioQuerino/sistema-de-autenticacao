# Atualização de Dados Cadastrais

**Objetivo:** Permitir que o usuário atualize seu nome ou outras informações secundárias.
- **Rota:** `PUT /api/users/me`
- **Payload Sugerido:** `ProfileUpdateRequest`
- **Regra:** Não permitir a alteração do e-mail ou perfil de acesso (`ROLE`) através desta rota.
## 🚀 Critérios de Aceite
- [ ] Nenhuma das rotas deste Épico deve receber o parâmetro `{id}` via Path Variable. A identidade é 100% abstraída do JWT.
- [ ] Requisições não autenticadas ou com JWT expirado devem retornar `401 Unauthorized`.
- [ ] O endpoint de atualização não permite modificação de e-mail ou `ROLE`.
- [ ] A troca de senha valida corretamente a senha antiga com o hash atual antes de salvar a nova.
- [ ] O sucesso nas operações retorna dados atualizados usando a padronização `ApiResponse<T>`.