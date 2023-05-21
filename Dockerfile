FROM maven:3-eclipse-temurin-11 AS BUILD

RUN addgroup demogroup; adduser  --ingroup demogroup --disabled-password demo

USER demo

WORKDIR /app

COPY ./ ./

RUN mvn clean install

FROM eclipse-temurin:11-jdk AS RUN

RUN addgroup demogroup; adduser  --ingroup demogroup --disabled-password demo

USER demo

WORKDIR /app

EXPOSE 8080

COPY --from=BUILD /app/target/recipes-*.jar /app/recipes.jar

ENTRYPOINT ["java", "-jar", "/app/recipes.jar" ]