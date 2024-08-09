FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
ARG EUREKA_SERVER=localhost
ARG KEYCLOAK_SERVER=localhost
ARG KEYCLOAK_PORT=8081

ENTRYPOINT java -jar -Dspring.profiles.active=production app.jar

## docker build -t cursoms-gateway .
## docker run --name cursoms-gateway -p 8080:8080 -e EUREKA_SERVER=cursoms-eureka -e KEYCLOAK_SERVER=cursoms-keycloak -e KEYCLOAK_PORT=8080 --network cursoms-network -d cursoms-gateway