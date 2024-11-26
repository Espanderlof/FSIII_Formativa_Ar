FROM maven:3.8-eclipse-temurin-17 AS buildstage

WORKDIR /app
COPY pom.xml .
COPY src /app/src
COPY Wallet_RNDBN3TSBMN53C36 /app/Wallet_RNDBN3TSBMN53C36

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-focal
WORKDIR /app

COPY --from=buildstage /app/target/back_libros-1.0-SNAPSHOT.jar /app/app.jar
COPY --from=buildstage /app/Wallet_RNDBN3TSBMN53C36 /app/Wallet_RNDBN3TSBMN53C36

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]