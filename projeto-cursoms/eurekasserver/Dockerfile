FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
EXPOSE 8761
ENTRYPOINT java -jar app.jar

## docker build --tag cursoms-eureka .
## docker run --name teste-eureka -p 8761:8761 cursoms-eureka

###########################################################

## Criar imagem da aplicação no Docker
## openkdk para execução do .jar
## criar pasta com workdir
## copiar o .jar da aplicação e nomear com app.jar
## porta 8761
## no terminal
## docker build --tag cursoms-eureka .
## docker run --name teste-eureka -p 8761:8761 cursoms-eureka
## teste-eureka é o nome do container
## cursoms-eureka é o nome da imagem

#FROM openjdk:11
#WORKDIR /app
#COPY ./target/eurekasserver-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8761
#ENTRYPOINT java -jar app.jar