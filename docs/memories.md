# Memória do Projeto: Sistema de Autenticação

## 📌 Visão Geral
O projeto é um sistema de autenticação robusto utilizando Java, Spring Boot e JPA. A arquitetura foca em herança de entidades e separação de responsabilidades via DTOs.

## 🗂️ Estrutura de Pacotes e Caminhos
- **Base do Projeto:** `br.com.querino.autenticacao` (Padronizado para unificar local).
- **Localização dos Arquivos:** 
    - `.../model/`: Entidades JPA (`User`, `Admin`, `UserComum`).
    - `.../dto/`: Objetos de transferência (`UserRegisterDTO`, `UserUpdate`, `ApiResponse`, etc).
    - `.../enums/`: Definições de `UserRole` e `UserStatus`.

## 🧬 Modelo de Dados (JPA)
- **Estratégia de Herança:** `InheritanceType.JOINED`.
    - Tabela Pai: `users` (Contém campos comuns: email, password, userName, active).
    - Tabelas Filhas: `admins` e `users_comum` (Ligadas via `@PrimaryKeyJoinColumn` no campo `user_id`).
- **Discriminador:** Coluna `user_role_type` na tabela `users` para identificar o tipo de classe em tempo de execução.

## 🛠️ Regras de Negócio Identificadas
1. **Admin:** Sempre criado com `UserRole.ADMIN` e `UserStatus.ACTIVE`.
2. **UserComum:** Sempre criado com `UserRole.USER`.
3. **Segurança:** 
    - Emails e UserNames devem ser únicos (`unique = true`).
    - Senhas em `UserUpdate` são opcionais (permite atualizar perfil sem trocar senha).
4. **Resposta da API:** Padronizada através da classe `ApiResponse`, contendo uma mensagem e um objeto de dados.

## ⚠️ Pontos de Atenção (Bugs Corrigidos/Identificados)
- **Discriminadores:** Adicionado `@DiscriminatorValue` em todas as subclasses para evitar erros de busca polimórfica no JPA.
- **Inconsistência de Construtores:** O `UserComum` tentava passar um parâmetro extra (`userId`) para o `super()`, que foi ajustado para bater com a assinatura da classe `User`.
- **Pacotes:** Alinhamento necessário entre os diretórios do OneDrive e os diretórios locais para evitar erros de importação.
- **Validações:** O `UserUpdate` não deve exigir senha obrigatória (`@NotBlank`) para permitir edições parciais.
- **Novos DTOs:** Implementados `ProfileDTO` e `ApiResponse` conforme requisitos do PRD.

---
*Documento gerado para persistência de contexto pelo Gemini Code Assist.*