FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
COPY ../../../Parquimetro_JavaApp-master/Parquimetro_JavaApp-master/src /app/src
COPY ../../../Parquimetro_JavaApp-master/Parquimetro_JavaApp-master/pom.xml /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]