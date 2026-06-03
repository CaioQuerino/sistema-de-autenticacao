# [Epic] Gestão de Perfil (Profile Management)

Esta Epic centraliza o desenvolvimento do módulo de gestão de perfis do projeto Auth-Core. O objetivo é permitir que usuários autenticados possam consultar e gerenciar seus próprios dados cadastrais e credenciais de forma segura e autônoma, utilizando o token JWT como única prova de identidade confiável.

## 🎯 Objetivos de Negócio
- Permitir consulta de dados do próprio perfil sem exposição de IDs na URL.
- Possibilitar a atualização de dados básicos do usuário (ex: nome, informações secundárias).
- Fornecer um mecanismo seguro para a troca de senha.
- Impedir a alteração de e-mail e perfil de acesso (`ROLE`) via rotas de atualização comuns para evitar escalação de privilégios.

## 🏗️ Arquitetura Técnica
- **Segurança:** Utilização do `SecurityContextHolder` para abstrair a identidade do JWT e validação de senhas antigas com `BCrypt` antes de atualizações.
- **Comunicação:** Rotas padronizadas sob `/api/users/me` utilizando o DTO `ApiResponse<T>`.

## 🔗 Tarefas Vinculadas (Child Issues)
- [x] **Issue 1** - Implementação da Consulta de Perfil Logado (`GET /api/users/me`).
- [ ] **Issue 2** - Implementação da Atualização de Dados Cadastrais (`PUT /api/users/me`).
- [ ] **Issue 3** - Implementação da Alteração de Senha Segura (`PUT /api/users/me/password`).

## 🚀 Critérios de Aceite
- [ ] Nenhuma das rotas deste Épico deve receber o parâmetro `{id}` via Path Variable. A identidade é 100% abstraída do JWT.
- [ ] Requisições não autenticadas ou com JWT expirado devem retornar `401 Unauthorized`.
- [ ] O endpoint de atualização não permite modificação de e-mail ou `ROLE`.
- [ ] A troca de senha valida corretamente a senha antiga com o hash atual antes de salvar a nova.
- [ ] O sucesso nas operações retorna dados atualizados usando a padronização `ApiResponse<T>`.

---
*Documento gerado para rastreabilidade do Auth-Core via Gemini Code Assist.*
