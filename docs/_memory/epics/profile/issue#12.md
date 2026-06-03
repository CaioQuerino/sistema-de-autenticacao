# Alteração de Senha Segura #12

**Objetivo:** Criar um fluxo para que o usuário possa trocar a própria senha.
- **Rota:** `PUT /api/users/me/password`
- **Payload Sugerido:** `UpdatePasswordRequest` (oldPassword, newPassword)
- **Regra:** Verificar a senha atual com `BCrypt` antes de realizar o hash e salvar a nova.

## 🚀 Critérios de Aceite
- Nenhuma das rotas deste Épico deve receber o parâmetro `{id}` via Path Variable. A identidade é 100% abstraída do JWT.
- Requisições não autenticadas ou com JWT expirado devem retornar `401 Unauthorized`.