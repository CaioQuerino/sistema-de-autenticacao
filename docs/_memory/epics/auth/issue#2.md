## Integrar o UserService já criado ao UserController #2

### Critérios de Aceite:
- Criar `UserController` no pacote `br.com.querino.autenticacao.controller`.
- Implementar `POST /api/users/register` utilizando o `UserRegisterDTO`.
- Retornar o perfil criado via `ProfileDTO` encapsulado em uma `ApiResponse`.
- Validar campos obrigatórios com `@Valid`.
