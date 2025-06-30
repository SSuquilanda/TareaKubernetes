# Etapa de construcción
FROM node:18-bullseye AS build
WORKDIR /app
COPY . .
RUN npm install && npm run build --prod

# Etapa de despliegue con nginx
FROM nginx:stable
COPY --from=build /app/dist/frontend/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
