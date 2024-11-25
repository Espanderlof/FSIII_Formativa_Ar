# Usar una imagen base de JDK para construir la aplicación
FROM eclipse-temurin:17-jdk-focal AS buildstage 

RUN apt-get update && apt-get install -y maven

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo pom.xml primero para aprovechar la caché de Docker
COPY pom.xml .

# Copiar el código fuente
COPY src /app/src

# Copiar la carpeta de la wallet
COPY Wallet_RNDBN3TSBMN53C36 /app/Wallet_RNDBN3TSBMN53C36

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

# Copia el archivo jar y la wallet al contenedor final
COPY --from=buildstage /app/target/back_libros-1.0-SNAPSHOT.jar /app/app.jar
COPY --from=buildstage /app/Wallet_RNDBN3TSBMN53C36 /app/Wallet_RNDBN3TSBMN53C36

# Exponer el puerto 8081
EXPOSE 8081

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]