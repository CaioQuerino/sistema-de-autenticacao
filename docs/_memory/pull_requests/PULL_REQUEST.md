# PR: Implementação do Core de Identidade e Fluxo JWT

## 📝 Descrição
Este PR implementa a base de segurança e gestão de usuários do projeto **Auth-Core**. Foram integrados os serviços de criptografia, autenticação stateless via JWT e o fluxo de registro polimórfico.

## 🛠️ Alterações Realizadas
- **Segurança:** Configuração do Spring Security com filtros customizados para interceptação de tokens JWT (#3).
- **Registro:** Implementação do `UserController` e lógica de persistência para Admin, Comum e Guest utilizando estratégia `JOINED` (#2).
- **Qualidade & Erros:** Padronização de respostas com `ApiResponse` e tratamento global de exceções de negócio (#4).
- **Infraestrutura:** Ajuste nas variáveis de ambiente do Docker para suportar o nome da aplicação e segredos do JWT.

## 🎯 Vínculos
- Finaliza a **Epic #1** do Fluxo de Autenticação.
- Closes #2, Closes #3, Closes #4.

## 🧪 Como Testar
1. Certifique-se de que o banco MySQL está rodando via `docker-compose up -d`.
2. Realize um POST para `/api/users/register` com o seguinte JSON:
   ```json
   {
     "email": "tester@querino.com",
     "password": "strong_password",
     "userName": "tester_dev",
     "userRole": "COMUM"
   }
   ```
3. Verifique se a resposta segue o padrão `ApiResponse` e se a senha está criptografada no banco.
4. Tente acessar um endpoint inexistente ou protegido para validar o retorno `403 Forbidden` ou `401 Unauthorized` devido à falta do token.

## ✅ Checklist de Qualidade
- [x] Senhas nunca são armazenadas em texto plano.
- [x] Não há vazamento de hashes de senha nos DTOs de saída.
- [x] O código segue o padrão de injeção por construtor via Lombok.
- [x] As dependências do JWT foram adicionadas ao `pom.xml`.

---
*Gerado automaticamente para o repositório CaioQuerino/sistema-de-autenticacao.*
