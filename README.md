# 🛡️ Auth-Core

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.0-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue)](https://www.docker.com/)
[![Synapos](https://img.shields.io/badge/Framework-Synapos-purple)](https://github.com/synapos)

O **Auth-Core** é o serviço central de identidade e autenticação da infraestrutura **Querino**. Ele foi projetado para ser um ecossistema de alta confiabilidade, permitindo a gestão polimórfica de usuários (Admin, Comum e Guest) através de uma arquitetura relacional baseada na estratégia de herança `JOINED`.

## 🚀 Tecnologias

- **Backend:** Java 17 (Eclipse Temurin)
- **Framework:** Spring Boot 3.3.0
- **Persistência:** Spring Data JPA / Hibernate
- **Banco de Dados:** MySQL 8.0
- **Segurança:** Spring Security / BCrypt
- **Infraestrutura:** Docker & Docker-compose
- **Padronização:** Synapos Framework

## 🏗️ Arquitetura e Modelagem

O projeto utiliza a estratégia `InheritanceType.JOINED` para mapear a hierarquia de usuários no banco de dados, garantindo integridade referencial e separação de atributos específicos:

- **User (Base):** Contém credenciais e dados básicos.
- **Admin:** Usuário com privilégios de sistema.
- **UserComum:** Usuário padrão da plataforma.
- **UserGuest:** Usuário temporário com rastreamento de IP.

## 🛠️ Como Executar

### Pré-requisitos
- Docker e Docker Compose instalados.
- Node.js (para execução dos protocolos Synapos).

### Passo a Passo

1. **Inicialize o contexto do projeto:**
   ```bash
   npm run synapos:init
   ```

2. **Suba a infraestrutura via Docker:**
   ```bash
   docker-compose up -d --build
   ```

A aplicação estará disponível em `http://localhost:8080` e o banco de dados em `localhost:3306`.
Você também pode acessar o **phpMyAdmin** em `http://localhost:8081` para visualizar as tabelas.

## 🔐 Regras de Ouro

Conforme definido no company.md:
1. **Segurança em Primeiro Lugar:** Senhas são sempre criptografadas com BCrypt antes da persistência.
2. **Integridade de Dados:** O banco de dados deve refletir fielmente a hierarquia de classes Java.
3. **Padronização:** Todas as respostas da API seguem o contrato `ApiResponse<T>`.

## 📂 Estrutura do Projeto

```text
src/main/java/br/com/querino/autenticacao/
├── config/      # Configurações de Segurança e Beans
├── controller/  # Endpoints da API (REST)
├── dto/         # Objetos de transferência e validação
├── enums/       # Definições de Role e Status
├── model/       # Entidades JPA (Hierarquia de User)
├── repository/  # Interfaces Spring Data JPA
└── service/     # Lógica de negócio e criptografia
```

## 📄 Documentação

Para detalhes mais profundos sobre requisitos e histórico de decisões, consulte a pasta `/docs`:
- PRD (Requisitos)
- Memória Técnica

---
Desenvolvido por **Querino** sob o protocolo **Synapos Codex**.