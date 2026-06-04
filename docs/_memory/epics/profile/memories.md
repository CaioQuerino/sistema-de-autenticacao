<!-- SUMMARY -->
(Início do Épico de Gestão de Perfil. Baseado na infraestrutura de Autenticação JWT já estabelecida e documentada.)
<!-- /SUMMARY -->

<!-- RECENTES -->
## [backend · planejamento]
[DECISÃO CRÍTICA] As rotas de gestão de perfil (`/api/users/me`) **nunca** devem receber o `{id}` do usuário via parâmetro (Path Variable ou Query). A identidade deve ser abstraída 100% do `SecurityContextHolder` alimentado pelo JWT, prevenindo ataques de BOLA/IDOR.

## [backend · segurança]
O endpoint de atualização cadastral (`PUT /api/users/me`) é restrito a dados secundários (nome, etc.). Ele **não pode** permitir a alteração do `email` ou `userRole` para evitar escalação de privilégios.

## [backend · segurança]
A alteração de senha deve ocorrer em endpoint isolado (`PUT /api/users/me/password`) e obrigatoriamente validar a senha atual usando `BCrypt` contra o hash do banco antes de persistir a nova senha.

## [backend · fix]
Identificado que a entidade `User` precisava implementar `UserDetails` explicitamente para que o Spring Security conseguisse validar o Token JWT corretamente contra o campo `email` (getUsername).

## [backend · observabilidade]
Adicionados handlers de `authenticationEntryPoint` e `accessDeniedHandler` no `SecurityConfig` para garantir que erros de autenticação retornem JSON padronizado em vez de corpo vazio.

## [backend · segurança]
[REGRAS DE OURO] A troca de senha (`changePassword`) implementa a validação obrigatória da credencial atual via `passwordEncoder.matches()` antes de permitir o re-hash da nova senha, prevenindo ataques de sequestro de sessão física.
<!-- /RECENTES -->