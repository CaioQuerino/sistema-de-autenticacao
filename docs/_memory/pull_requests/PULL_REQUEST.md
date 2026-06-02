# PR: Refatoração e Unificação dos DTOs de Autenticação

## 📝 Descrição
Este PR padroniza os Data Transfer Objects (DTOs) utilizados no fluxo de autenticação. As classes `RequestLoginDTO` e `ResponseLoginDTO` foram removidas e substituídas pelas classes padrão `AuthenticationRequest` e `AuthenticationResponse`, respectivamente. O objetivo é eliminar redundâncias e aumentar a consistência do código.

## 🛠️ Alterações Realizadas
- **Refatoração:** Remoção das classes `RequestLoginDTO` e `ResponseLoginDTO`.
- **Consistência:** Atualização do `AuthenticationController` para utilizar exclusivamente `AuthenticationRequest` e `AuthenticationResponse`.
- **Documentação:** Atualização do plano de commits (`COMMIT_AUTH_PLAN.md`) para refletir a remoção dos DTOs obsoletos.

## 🎯 Vínculos
- Refatora a implementação relacionada à **Epic #1** (Fluxo Completo de Autenticação).

## 🧪 Como Testar
1. Certifique-se de que o banco MySQL está rodando via `docker-compose up -d`.
2. Teste o endpoint de Login enviando um POST para `/api/auth/login` com o corpo no formato `AuthenticationRequest`:
   ```json
   {
     "email": "tester@querino.com",
     "password": "strong_password"
   }
   ```
3. Verifique se a resposta retorna o **Token JWT** com sucesso, no formato `AuthenticationResponse`.
4. Confirme que as classes `RequestLoginDTO.java` e `ResponseLoginDTO.java` foram removidas do projeto.

## ✅ Checklist de Qualidade
- [x] O código compila e os testes de login (manuais ou automatizados) continuam passando.
- [x] As classes DTO redundantes foram completamente removidas.
- [x] O `AuthenticationController` está alinhado com os DTOs padronizados.
- [x] O plano de commits foi atualizado para refletir a refatoração.

---
*Gerado automaticamente para o repositório CaioQuerino/sistema-de-autenticacao.*
