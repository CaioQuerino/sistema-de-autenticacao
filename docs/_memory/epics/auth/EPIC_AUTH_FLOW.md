# [Epic] Sistema de Identidade e Fluxo de Autenticação JWT

Esta Epic centraliza o desenvolvimento do ecossistema de identidade do projeto Auth-Core. O objetivo é garantir um fluxo seguro de ponta a ponta, desde a captura de dados cadastrais até a emissão de tokens de acesso (JWT), seguindo as melhores práticas de segurança (Regra de Ouro #1) e padronização REST.

## 🎯 Objetivos de Negócio
- Permitir o registro de diferentes tipos de usuários (Admin, Comum, Guest) com persistência polimórfica.
- Implementar autenticação baseada em tokens (Stateless) para suportar escalabilidade.
- Garantir que erros de autenticação e validação sejam comunicados de forma clara e padronizada ao Frontend.

## 🏗️ Arquitetura Técnica
- **Segurança:** BCrypt para hashing de senhas e Spring Security para filtros de acesso.
- **Comunicação:** Padronização de respostas via DTO `ApiResponse<T>`.
- **Persistência:** Estratégia JPA `JOINED` para herança de usuários.

## 🔗 Tarefas Vinculadas (Child Issues)
- [x] **#2** - Exposição de Endpoints REST para Registro de Usuários.
- [x] **#3** - Implementação do Provedor de Segurança e Serviço JWT.
- [x] **#4** - Padronização Global de Erros e Exceções de Negócio.

## ✅ Critérios de Aceite (DoD)
- [x] Registro de usuário funcional com senha criptografada no banco.
- [ ] Login gerando um token JWT válido e seguro.
- [ ] Tentativas de acesso a rotas protegidas sem token retornando 401 Unauthorized.
- [ ] Erros de validação retornando 400/422 no formato ApiResponse.
- [ ] Cobertura de testes de integração para o caminho feliz e casos de erro.

---
*Documento gerado para rastreabilidade do Auth-Core via Gemini Code Assist.*