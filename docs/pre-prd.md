# PRD - Sistema de Autenticação (Auth-Core)

## 1. Visão Geral
O objetivo deste projeto é fornecer uma base sólida e escalável para autenticação e gestão de perfis de usuários, permitindo diferentes níveis de acesso (Admin, Comum, Guest) através de uma arquitetura de banco de dados relacional eficiente.

## 2. Objetivos e Público-Alvo
- **Objetivo:** Centralizar a lógica de segurança, registro e atualização de perfis.
- **Público:** Desenvolvedores que integrarão este módulo em aplicações maiores e usuários finais do sistema.

## 3. Requisitos Funcionais (RF)

| ID | Requisito | Descrição | Prioridade |
|----|-----------|-----------|------------|
| RF01 | Cadastro de Usuário | Permitir que novos usuários se registrem via `UserRegisterDTO`. | Alta |
| RF02 | Autenticação | Validar credenciais (e-mail e senha). | Alta |
| RF03 | Gestão de Perfis | Permitir atualização de dados (bio, avatar, nome) via `UserUpdate`. | Média |
| RF04 | Diferenciação de Papéis | Sistema deve distinguir entre Admin, Usuário Comum e Guest. | Alta |
| RF05 | Rastreamento de Guest | Registrar o endereço IP para usuários do tipo Guest. | Baixa |
| RF06 | Validação de Dados | Garantir e-mails únicos e senhas com mínimo de 6 caracteres. | Alta |

## 4. Requisitos Não Funcionais (RNF)

- **Segurança:** As senhas devem ser criptografadas (BCrypt recomendado).
- **Performance:** O uso de `InheritanceType.JOINED` deve ser otimizado para evitar JOINs excessivos em consultas simples.
- **Padronização:** Todas as respostas da API devem seguir o formato `ApiResponse<T>`.
- **Escalabilidade:** O sistema deve suportar a adição de novos tipos de usuários com impacto mínimo no código existente.

## 5. Arquitetura Técnica

### 5.1. Modelo de Dados
- **Tabela Base (`users`):** Armazena dados de login e status.
- **Tabela `admins`:** Dados específicos de administradores.
- **Tabela `users_comum`:** Perfil padrão de usuário.
- **Tabela `users_guest`:** Temporário, focado em IP e acesso limitado.

### 5.2. Fluxo de Registro
1. Recebe `UserRegisterDTO`.
2. Valida se e-mail/userName já existem.
3. Criptografa a senha.
4. Instancia a subclasse correta (ex: `UserComum`).
5. Persiste e retorna `ProfileDTO`.

## 6. Regras de Negócio
- Um usuário `Admin` não pode ser excluído por outro `Admin` via API pública (regra de proteção).
- O campo `active` determina se o usuário pode realizar login, independentemente do status.
- Alteração de senha no `UserUpdate` é opcional; se nulo, mantém a atual.

## 7. Critérios de Aceite
- [ ] Cadastro retorna status 201 Created.
- [ ] Tentativa de e-mail duplicado retorna 400 Bad Request com mensagem clara.
- [ ] ProfileDTO não vaza o hash da senha.

---
*Documento em constante evolução via Synapos:session.*