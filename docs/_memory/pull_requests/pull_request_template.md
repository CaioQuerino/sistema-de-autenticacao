## 📋 Descrição
Este PR implementa funcionalidades referentes ao **Épico #2 - Gestão de Perfil**.
O foco principal foi: [Ex: Implementação da rota /me e integração com UserDetails]

**Epic vinculada:** #2 (Profile Management)
**Issue(s) relacionada(s):** #1

## 🚀 O que foi feito?
- [x] Implementação de `UserDetails` na entidade `User`.
- [x] Criação do endpoint `GET /api/users/me`.
- [x] Ajustes de segurança no `SecurityConfig` para handlers de erro 401/403.

## 🧪 Como testar?
1. Realizar o registro de um novo usuário via `POST /api/users/register`.
2. Realizar o login via `POST /api/auth/login` e copiar o token JWT.
3. Realizar um `GET /api/users/me` enviando o token no header `Authorization: Bearer <token>`.
4. Verificar se o corpo da resposta contém os dados do perfil sem vazar a senha.

## 🛡️ Checklist de Segurança (Synapos Standard)
- [x] **ID Abstraction:** Nenhuma rota recebe `{id}` via URL; a identidade é extraída do JWT.
- [x] **Data Protection:** Dados sensíveis (senhas, segredos) não são retornados no DTO.
- [x] **Auth Validation:** Tentativas de acesso sem token ou com token inválido retornam 401/403 padronizados.

## 📸 Screenshots / Logs de Teste
<img width="1134" height="689" alt="image" src="https://github.com/user-attachments/assets/51ed7fbc-b8ee-49cf-9100-eff9e725d534" />

<img width="1122" height="756" alt="image" src="https://github.com/user-attachments/assets/e6ab1a28-62f8-4374-99a7-31557c67407d" />

<img width="1127" height="690" alt="image" src="https://github.com/user-attachments/assets/744acbb3-0158-42e5-a863-9601566f12bc" />


## 📖 Documentação
- [x] As memórias do épico em `docs/_memory/epics/profile/memories.md` foram atualizadas?
- [x] O status da Epic em `EPIC_PROFILE_MANAGEMENT.md` foi atualizado?