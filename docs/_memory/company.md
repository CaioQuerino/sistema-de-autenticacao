# 🏢 Contexto de Negócio: Querino Auth-Core

## 📝 Visão Geral
Este projeto é o núcleo de identidade da infraestrutura **Querino**, focado em fornecer um serviço de autenticação centralizado, seguro e polimórfico para suportar diferentes níveis de acesso (Admin, Usuários Comuns e Guests).

## 🎯 Objetivo do Squad
Desenvolver e manter um ecossistema de autenticação de alta confiabilidade, implementando padrões de segurança modernos e uma arquitetura relacional baseada em herança estratégica (`JOINED`).

## 🛠️ Stack Tecnológica de Referência
- **Linguagem:** Java 17 (OpenJDK/Temurin)
- **Framework:** Spring Boot 3.3.0
- **Persistência:** Spring Data JPA / MySQL 8.0
- **Infraestrutura:** Docker & Docker-Compose

## 📜 Regras de Ouro
1. **Segurança em Primeiro Lugar:** Senhas devem ser criptografadas e nunca expostas em DTOs de leitura.
2. **Integridade de Dados:** O banco de dados MySQL deve refletir fielmente a hierarquia de classes do Java.
3. **Padronização:** Todas as respostas da API devem seguir o contrato definido em `ApiResponse`.
