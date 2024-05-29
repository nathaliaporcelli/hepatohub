
FROM openjdk
WORKDIR /app
#COPY /target/demo-0.0.1-SNAPSHOT.jar ./demo.jar
COPY . .
#COPY ./target/demo-0.0.1-SNAPSHOT.jar ./demo.jar
EXPOSE 8080
# Copiar o arquivo pom.xml e o arquivo .mvn/ para dentro do contêiner
#COPY pom.xml ./
#COPY .mvn/ ./
#COPY mvnw ./
#COPY src ./src
#COPY Dockerfile ./Dockerfile

# Instalar as dependências e compilar a aplicação
RUN ./mvnw clean package -DskipTests
# Comando para executar a aplicação
CMD ["java", "-jar", "./target/demo-0.0.1-SNAPSHOT.jar"]