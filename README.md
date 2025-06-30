# Proyecto Kubernetes

Este proyecto es una aplicación web full-stack que utiliza Spring Boot para el backend y Angular para el frontend. La aplicación permite gestionar personas y los productos que compra, y ha sido desplegada correctamente sobre Kubernetes.

---

## Tecnologías Utilizadas

### Backend:

- Spring Boot 
- Maven
- PostgreSQL
- Spring Data JPA

### Frontend:
- Angular 
- TypeScript
- HTML + SCSS
- Font Awesome

### Contenerización y Orquestación:
- Docker
- Docker Hub
- Kubernetes (Minikube)

---

## Arquitectura

- **Frontend:** Angular servido desde un contenedor NGINX.
- **Backend:** API RESTful desarrollada en Spring Boot.
- **Base de Datos:** PostgreSQL con almacenamiento persistente (PVC).

---

## Despliegue con Kubernetes

### 1. Requisitos
- Docker Desktop con Kubernetes o Minikube
- `kubectl` instalado
- Imágenes en Docker Hub:
    - `ssuquilanda/backend-k8s:latest`
    - `ssuquilanda/frontend-k8s:latest`

### 2. Manifiestos en `k8s-manifests/`
- `frontend-deployment.yaml`
- `frontend-service.yaml`
- `backend-deployment.yaml`
- `backend-service.yaml`
- `db-deployment.yaml`
- `db-service.yaml`
- `pgdata-persistentvolumeclaim.yaml`

### 3. Aplicar manifiestos


`kubectl apply -f k8s-manifests/`

### 4. Verificar recursos

`kubectl get pods`
`kubectl get services`
`kubectl get pvc`

### 5. Acceso a la Aplicación

- Frontend:
  `minikube service frontend --url`
- o usando port-forward:

  `kubectl port-forward service/frontend 4200:4200`
- Accede vía navegador: http://127.0.0.1:52476/
- Backend: Accesible dentro del clúster en http://backend:8080.
- Base de datos: Accesible en db:5432 para los pods.


### 6. Despliegue local con Docker Compose

Clonar el repositorio:

git clone https://github.com/SSuquilanda/TareaKubernetes.git
### 7. Errores Comunes y Soluciones

- URL must start with 'jdbc' →  Se resolvió pasando correctamente las variables de entorno al contenedor (SPRING_DATASOURCE_URL, etc).
- ImagePullBackOff →  Solucionado tras subir correctamente las imágenes a Docker Hub.
- Frontend CrashLoopBackOff →  Error de imagen mal referenciada (backend-k8s en lugar de frontend-k8s).
- Service frontend does not have port 80 →  Se corrigió la exposición del contenedor en el puerto 80 y se ajustó el Service a targetPort: 80.
