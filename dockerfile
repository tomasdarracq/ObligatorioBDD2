FROM eclipse-temurin:17-jdk-focal
 
# Establece el directorio de trabajo para el backend
WORKDIR /app/backend 
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
 
COPY src ./src
 
# Expone el puerto 8080 para el backend
EXPOSE 8080

# Comando para ejecutar el backend
CMD ["java", "-jar", "app.jar"]

# Cambia a una nueva etapa para construir el frontend
FROM node:20.9.0 as frontend

# Establece el directorio de trabajo para el frontend
WORKDIR /app/frontend

# Copia los archivos necesarios para el frontend (por ejemplo, los archivos de Angular)
COPY frontend .

# Instala las dependencias y construye el frontend
RUN npm install && npm run build

# Combina el frontend construido con un servidor web como Nginx
FROM nginx:alpine

# Copia el frontend construido a la carpeta de Nginx
COPY --from=frontend /app/frontend/dist/tu-aplicacion-angular /usr/share/nginx/html

# Expone el puerto 80 para el servidor web de Nginx
EXPOSE 80
