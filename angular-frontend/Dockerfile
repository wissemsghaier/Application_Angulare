# Étape 1 : Utiliser l'image officielle Node.js (version LTS)
FROM node:14 AS build

# Étape 2 : Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Étape 3 : Copier les fichiers package.json et package-lock.json (ou yarn.lock)
# pour installer les dépendances
COPY package.json package-lock.json ./

# Étape 4 : Installer les dépendances du projet Angular
RUN npm install

# Étape 5 : Copier le reste des fichiers du projet Angular dans le conteneur
COPY . .

# Étape 6 : Construire l'application Angular (version de production)
RUN npm run build --prod

# Étape 7 : Étape de production - Serveur Nginx pour héberger l'application Angular construite
FROM nginx:alpine

# Étape 8 : Copier les fichiers construits dans le dossier Nginx
COPY --from=build /app/dist/angular-frontend /usr/share/nginx/html

# Étape 9 : Exposer le port 80 pour accéder à l'application via HTTP
EXPOSE 80

# Étape 10 : Lancer Nginx pour servir l'application
CMD ["nginx", "-g", "daemon off;"]

