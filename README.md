# FSIII_Formativa_Ar
Formativa - Trabajaremos con Java Spring Boot - Arquetipo

# Spring
mvn spring-boot:run

# Dockerfile
docker build -t back-libros .
docker run --name back-libros -p 8081:8081 back-libros

# Play with Docker
1. ir a https://labs.play-with-docker.com/
2. copiar repo git clone https://github.com/Espanderlof/FSIII_Formativa_Ar
3. entrar al directorio cd FSIII_Formativa_Ar
4. crear imagen de contenedor docker build -t back-libros .
5. ejecutar docker run --name back-libros -p 8081:8081 back-libros