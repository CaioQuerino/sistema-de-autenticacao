# Estágio de Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /build
# Copia apenas o pom.xml para que as dependências sejam baixadas primeiro
COPY pom.xml ./
RUN mvn dependency:go-offline # Baixa todas as dependências para o cache local
# Copia o restante do código-fonte
COPY . .
RUN mvn clean install -DskipTests # Use 'install' para que o jar seja criado na pasta target

# Estágio de Execução
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia o jar gerado (ajuste o nome se o seu artifactId for diferente)
COPY --from=build /build/target/autenticacao-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]