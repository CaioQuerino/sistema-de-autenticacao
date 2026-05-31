# 🛡️ Auth-Core | Central de Documentação

Bem-vindo ao centro de conhecimento do **Auth-Core**, um ecossistema de autenticação escalável desenvolvido com Java 17 e Spring Boot. Este projeto segue os protocolos do **Synapos Framework** para garantir qualidade e consistência arquitetural.

## 🗺️ Mapa de Navegação

### 1. Visão de Produto e Negócio
*   **[Documento de Requisitos (PRD)](PRD.md)**: Definição de escopo, requisitos funcionais (RF), não funcionais (RNF) e critérios de aceite.

### 2. Arquitetura e Decisões Técnicas
*   **Memória do Projeto (Memories)**: Registro de decisões arquiteturais, bugs corrigidos e o mapeamento da estratégia de herança JPA `JOINED`.

### 3. Operação e Infraestrutura
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
*Última atualização: 2024-05-29*
*Protocolo: Synapos:Complete*