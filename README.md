# FSIII_Formativa_Ar
Formativa - Trabajaremos con Java Spring Boot - Arquetipo

# Spring
mvn spring-boot:run

# Dockerfile
docker build -t back-libros .
docker run --name back-libros -p 8081:8081 back-libros

# DockerHub
1. Crear repo en https://hub.docker.com/
2. Primero, asegúrate de estar logueado en Docker Hub desde tu terminal
    docker login
3. Identifica tu imagen local. Puedes ver tus imágenes locales con:
    docker images
4. Etiqueta tu imagen local con el formato requerido por Docker Hub:
    Por ejemplo, si tu imagen local se llama "backend-app:1.0", los comandos serían:
    docker tag backend-app:1.0 espanderlof/fs3_formativa_backend:latest
    docker push espanderlof/fs3_formativa_backend:latest

# Play with Docker
1. ir a https://labs.play-with-docker.com/
2. copiar repo de dockerHub
    docker pull espanderlof/fs3_formativa_backend:latest
3. levantar contenedor
    docker run -d --network host --name back-libros espanderlof/fs3_formativa_backend:latest
4. verificar contenedores
    docker ps