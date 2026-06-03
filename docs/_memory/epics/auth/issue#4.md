## fix: global exception handling for auth errors #4

Garantir que falhas de autenticação e validação retornem o formato padrão da empresa.

### Critérios de Aceite:
- Implementar `@RestControllerAdvice`.
- Capturar exceções de e-mail duplicado e credenciais inválidas.
- Retornar erro seguindo a estrutura `ApiResponse`.