FROM maven:3.8.7 AS maven

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN mvn package -DskipTests

FROM eclipse-temurin:17-alpine

ARG JAR_FILE=spring-boot-mailpublisher-api.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","spring-boot-mailpublisher-api.jar"]


