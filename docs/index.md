# 🛡️ Auth-Core | Central de Documentação

Bem-vindo ao centro de conhecimento do **Auth-Core**, um ecossistema de autenticação escalável desenvolvido com Java 17 e Spring Boot. Este projeto segue os protocolos do **Synapos Framework** para garantir qualidade e consistência arquitetural.

## 🗺️ Mapa de Navegação

### 1. Visão de Produto e Negócio
*   **[Documento de Requisitos (PRD)](pre-prd.md)**: Definição de escopo, requisitos funcionais (RF), não funcionais (RNF) e critérios de aceite.
*   **[Fluxo de Usuários](.squads/sessions/{feature-slug}/user-flow.md)**: Regras de negócio, perfis de usuários e jornadas de Registro, Login e Autorização.

### 2. Arquitetura e Decisões Técnicas
*   **Arquitetura do Sistema**: Detalhamento da arquitetura em camadas e segurança Stateless (JWT).
*   **Stack Tecnológica**: Ferramentas, frameworks, banco de dados e bibliotecas utilizadas.
*   **Memória do Projeto (Memories)**: Registro de decisões arquiteturais, rastreamento de bugs corrigidos e histórico de desenvolvimento.

### 3. Operação, Infraestrutura e CI/CD
*   **Guia de CI/CD (GitHub Actions)**: Explicação do fluxo de Integração Contínua e automação de testes.
*   **Configuração Docker**: Detalhes do ambiente de containers (App + MySQL 8.0).
*   **Orquestração Synapos**: Protocolos de automação e comandos `synapos:*`.

## 🚀 Quick Start (Desenvolvimento)

Siga os passos abaixo para subir o ambiente localmente:

```bash
# Inicializa o contexto do Synapos
npm run synapos:init

# Sobe os containers de Banco de Dados e Aplicação
docker-compose up -d
```

## 🏗️ Arquitetura Resumida

- **Backend:** Java 17+, Spring Boot, JPA/Hibernate.
- **Banco de Dados:** Estratégia de tabela por classe (`InheritanceType.JOINED`).
- **Segurança:** Autenticação baseada em papéis (`ADMIN`, `USER`, `GUEST`).
- **DTOs:** Padronização de entrada/saída para evitar vazamento de dados sensíveis.

## 🛠️ Stack Tecnológica

- **Lombok:** Redução de boilerplate code.
- **Jakarta Validation:** Validação de DTOs.
- **Synapos Codex:** Orquestração de tarefas de engenharia via IA.

---
*Última atualização: Atualizado com fluxos de Autenticação JWT, CI/CD e Arquitetura.*
*Protocolo: Synapos:Complete*