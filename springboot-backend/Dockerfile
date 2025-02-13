# Étape 1 : Utilisation de l'image officielle OpenJDK 17
FROM openjdk:17-jdk-slim
# Étape 2 : Définir les variables d'environnement pour le dossier d'application
ENV APP_HOME=/app
WORKDIR $APP_HOME
# Étape 3 : Copier le fichier JAR de l'application dans le conteneur
COPY target/springboot-backend-0.0.1-SNAPSHOT.jar app.jar

# Étape 4 : Exposer le port sur lequel l'application s'exécute (ex: 8080)
EXPOSE 8088

# Étape 5 : Commande de lancement de l'application
CMD ["java", "-jar", "app.jar"]

