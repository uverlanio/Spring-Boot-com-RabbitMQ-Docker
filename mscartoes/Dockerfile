FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar

ARG RABBITMQ_SERVER=rabbitmq-host
ARG EUREKA_SERVER=localhost
## determnindo com qual perfil .yml vai executar
ENTRYPOINT java -jar -Dspring.profiles.active=production  app.jar

## docker build --tag cursoms-cartoes .
## docker run --name cursoms-cartoes --network cursoms-network -e RABBITMQ_SERVER=cursoms-rabbitmq -e EUREKA_SERVER=cursoms-eureka -d cursoms-cartoes