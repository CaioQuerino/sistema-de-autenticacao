# Entendendo o GitHub Actions (CI/CD)

O código YAML analisado é um **Workflow do GitHub Actions**. 

## 🎯 Para que serve?
Ele serve para automatizar tarefas de desenvolvimento. Sempre que alguém do time enviar um código novo para o repositório (via `push` ou `pull_request`), o GitHub vai "alugar" um computador virtual na nuvem, baixar o seu código, instalar o Java e tentar compilar o projeto.

Isso garante que **nenhum código quebrado vá para a branch principal (`main`)**. Se a compilação falhar, o GitHub bloqueia o Pull Request avisando que há um erro.

---

## 🧩 Explicando o código linha a linha

- `name: Java CI`: É o nome do seu workflow que vai aparecer na aba "Actions" do GitHub.
- `on: push: / pull_request:`: São os "Gatilhos" (Triggers). Diz ao GitHub: *"Rode este script toda vez que fizerem um push ou abrirem um PR para a branch `main`"*.
- `runs-on: ubuntu-latest`: É o sistema operacional do computador virtual (runner) que o GitHub vai disponibilizar gratuitamente para rodar o seu teste.
- `steps`: É a receita de bolo. O passo a passo que o computador deve seguir:
  1. `actions/checkout@v4`: Baixa os arquivos do seu repositório para dentro do computador virtual.
  2. `actions/setup-java@v4`: Instala a linguagem Java (no exemplo, a versão 11).
  3. `run: ant -noinput -buildfile build.xml`: Roda o comando de build no terminal para compilar o projeto (no exemplo, usando a ferramenta Ant).

---

## 🚀 Como usar no seu projeto

Para que o GitHub reconheça esse arquivo, você deve criar uma pasta oculta chamada `.github/workflows/` na raiz do seu projeto e salvar o arquivo lá dentro (por exemplo: `.github/workflows/build.yml`).

### ⚠️ ATENÇÃO: Ajuste para o seu projeto atual!
O script que você compartilhou foi feito para projetos muito antigos que usam o **Apache Ant** e **Java 11**. 
Como o seu projeto atual (Auth-Core) foi construído com **Maven** e **Java 17** (conforme visto no seu `pom.xml`), você deve usar o código abaixo em vez do original:

```yaml
name: Spring Boot CI

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - name: Baixar o código do repositório
      uses: actions/checkout@v4
      
    - name: Configurar o Java 17
      uses: actions/setup-java@v4
      with:
        java-version: '17'
        distribution: 'temurin'
        cache: maven # Acelera os próximos builds fazendo cache das dependências
        
    - name: Compilar e Testar com Maven
      run: mvn clean install
```

### Próximos Passos:
1. Crie a pasta `.github/workflows/` na raiz do seu repositório.
2. Crie um arquivo chamado `ci.yml` com o código ajustado acima.
3. Faça um `git push`.
4. Vá até o seu repositório no GitHub, clique na aba **Actions** e veja a mágica acontecer! O GitHub irá compilar o seu projeto do zero e mostrar um ✅ verde no final.