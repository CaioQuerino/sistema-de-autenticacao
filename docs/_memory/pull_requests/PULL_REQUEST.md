# PR: Finalização do Fluxo de Autenticação, Segurança e Documentações

## 📝 Descrição
Este PR finaliza a base de segurança e gestão de usuários do projeto **Auth-Core**. Foram integrados os serviços de criptografia, autenticação stateless completa (Registro e Login) via JWT, resolução de pendências de infraestrutura e adição de documentação técnica e de negócios.

## 🛠️ Alterações Realizadas
- **Segurança & Login:** Implementação do endpoint de login, mapeamento correto do `UserDetails` para evitar erros de cast, e melhorias no tratamento de exceções (`GlobalExceptionHandler`) e robustez no `JwtAuthenticationFilter`.
- **Registro:** Implementação do `UserController` e lógica de persistência para Admin, Comum e Guest utilizando estratégia `JOINED` (#2).
- **Infraestrutura:** Correção do Healthcheck do MySQL no `docker-compose.yml`, evitando cenários de "Race Condition" na inicialização da API.
- **Documentação:** Criação dos artefatos de documentação técnica (arquitetura e stack) e de negócios (fluxo de usuário e regras de auth) na pasta `docs/`.

## 🎯 Vínculos
- Finaliza a **Epic #1** (Fluxo Completo de Autenticação).
- Closes #2, Closes #3, Closes #4.

## 🧪 Como Testar
1. Certifique-se de que o banco MySQL está rodando via `docker-compose up -d`.
2. Realize um POST para `/api/users/register` com o seguinte JSON:
   ```json
   {
     "email": "tester@querino.com",
     "password": "strong_password",
     "userName": "tester_dev",
     "userRole": "USER"
   }
   ```
3. Teste o endpoint de Login enviando um POST para `/api/auth/login`:
   ```json
   {
     "email": "tester@querino.com",
     "password": "strong_password"
   }
   ```
4. Verifique se a resposta retorna o **Token JWT** com sucesso.
5. Tente acessar um endpoint inexistente ou protegido (sem enviar o token) para validar os retornos estruturados `403 Forbidden` ou `401 Unauthorized`.

## ✅ Checklist de Qualidade
- [x] Senhas nunca são armazenadas em texto plano.
- [x] Não há vazamento de hashes de senha nos DTOs de saída.
- [x] O código segue o padrão de injeção por construtor via Lombok.
- [x] Problemas de referência circular na injeção de dependências foram resolvidos.
- [x] As documentações de negócio e técnica foram atualizadas para o time.

---
*Gerado automaticamente para o repositório CaioQuerino/sistema-de-autenticacao.*
