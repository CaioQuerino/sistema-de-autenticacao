# Documentação de Negócios: Fluxo de Usuários

Este documento descreve os fluxos de negócio fundamentais da infraestrutura do **Querino Auth-Core**, mapeando a jornada de identidade e as regras de segurança envolvidas.

## 1. Perfis de Usuário (Atores)
O sistema utiliza herança relacional polimórfica (estratégia `JOINED`) para suportar múltiplos perfis, compartilhando uma tabela base, mas permitindo dados específicos:
- **Comum (`USER_COMUM`):** Usuário padrão da plataforma com permissões baseadas em seu perfil.
- **Admin (`ADMIN`):** Administrador do sistema, responsável por gestão e permissões elevadas.
- **Guest (`GUEST`):** Visitante ou convidado com acesso a um subconjunto estrito de funcionalidades.

## 2. Fluxo de Registro (Onboarding)
O fluxo de criação de contas garante a integridade e segurança dos dados na entrada do usuário.

**Regras de Negócio:**
1. **Captura:** O solicitante envia e-mail, senha, nome de usuário e o perfil associado via POST em `/api/users/register`.
2. **Unicidade:** O serviço intercepta e valida se o e-mail ou o nome de usuário já existem na base de dados, prevenindo duplicidade de contas.
3. **Criptografia (Regra de Ouro #1):** A senha recebida em texto claro é submetida ao algoritmo de hash `BCrypt` antes de qualquer persistência, garantindo que o banco de dados armazene apenas resumos matemáticos irreversíveis.
4. **Confirmação:** A conta é persistida de acordo com o papel escolhido e o Frontend recebe uma resposta estruturada de sucesso (formato `ApiResponse`).

## 3. Fluxo de Autenticação (Login)
O login opera de maneira veloz, escalável e completamente *Stateless*.

**Regras de Negócio:**
1. **Tentativa:** O usuário envia suas credenciais para `/api/auth/login`.
2. **Validação Blindada:** O sistema busca o e-mail e aplica o `BCrypt` para verificar a senha. Em caso de falha de qualquer um dos dois, o erro gerado é genérico ("E-mail ou senha inválidos"). Isso bloqueia ataques de enumeração de e-mails válidos.
3. **Emissão de Identidade:** Validado com sucesso, o provedor de identidade gera um **Token JWT** contendo a assinatura do servidor e uma data de expiração (Time to Live).
4. **Handoff de Interface:** A resposta da API não devolve apenas o Token, mas injeta o `ProfileDTO` com dados públicos (ID, Nome, E-mail, Role). Isso impede que o Frontend tenha que fazer um request adicional (overhead) só para pintar o header com a foto/nome do usuário recém-logado.

## 4. Fluxo de Autorização (Navegação Protegida)
Uma vez logado, o usuário navega com seu "crachá digital" (JWT).

**Regras de Negócio:**
1. O cliente anexa o JWT via header HTTP: `Authorization: Bearer <TOKEN>`.
2. O `JwtAuthenticationFilter` da aplicação intercepta todas as rotas (exceto `/auth/**` e `/register`).
3. Ele valida ativamente: A assinatura criptográfica (garantindo que o token não foi adulterado no meio do caminho) e o prazo de expiração (para revogar acessos velhos).
4. **Stateless Scale:** O banco de dados NÃO é consultado para cada validação de sessão, eliminando o gargalo tradicional e permitindo que o Auth-Core decole em tráfego sem derrubar o banco MySQL.