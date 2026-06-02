# Stack Tecnológica

Este documento lista as tecnologias fundamentais utilizadas no projeto de Autenticação.

## Core
- **Linguagem:** Java 17
- **Framework Principal:** Spring Boot 3.3.0
- **Gerenciador de Dependências:** Maven

## Camada de Dados
- **Banco de Dados:** MySQL 8.0
- **ORM & Persistência:** Spring Data JPA / Hibernate
- **Migrations:** (Gerenciado pelo Hibernate DDL Auto temporariamente - update)

## Segurança & Autenticação
- **Autenticação:** Spring Security
- **Tokens:** JWT (JSON Web Token) via biblioteca `io.jsonwebtoken` (v0.11.5)
- **Criptografia:** BCrypt (BCryptPasswordEncoder)

## Infraestrutura & DevOps
- **Containers:** Docker
- **Orquestração Local:** Docker Compose
- **Ferramentas Auxiliares:** phpMyAdmin (para administração local do banco de dados)

## Utilitários
- **Boilerplate Reduction:** Lombok (v1.18.32)
- **Validação:** Spring Boot Validation (`jakarta.validation`)