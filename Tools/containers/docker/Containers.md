# Containers
Un container (contenedor) es una unidad de software ligera y portátil que empaqueta una aplicación junto con todas sus dependencias (bibliotecas, configuraciones, archivos necesarios, etc.), asegurando que se ejecute de manera idéntica en cualquier entorno.

* Un contenedor es una instancia ejecutable de una imagen. Puedes crear, iniciar, detener, mover o eliminar un contenedor mediante la API o CLI de Docker.
* Puedes conectar un contenedor a una o más redes, adjuntarle almacenamiento o incluso crear una nueva imagen basada en su estado actual.

**Los contenedores permiten:**
* Empaquetar aplicaciones con todas sus dependencias
* Ejecutar aplicaciones de forma consistente en cualquier entorno (local, servidores, nubes)
* Reducir conflictos de compatibilidad entre entornos de desarrollo, prueba y producción
* Optimizar el uso de recursos en comparación con máquinas virtuales
* Facilitar el escalado y la implementación rápida de aplicaciones
* Orquestar microservicios con Kubernetes

**Son ampliamente utilizados en desarrollo de software, despliegues en la nube, CI/CD, microservicios y más.**

**Un contenedor incluye:**
* Código de la aplicación
* Dependencias y bibliotecas necesarias
  * Un contenedor se define por su imagen, así como por las opciones de configuración que le proporciona cuando lo crea o inicia. 
* Configuraciones y variables de entorno
* Un sistema de archivos propio
  * Cuando se elimina un contenedor, cualquier cambio en su estado que no esté almacenado en un almacenamiento persistente desaparece.

De forma predeterminada, un contenedor está relativamente bien aislado de otros contenedores y de su máquina host. Puedes controlar qué tan aislados están de la red, el almacenamiento u otros subsistemas subyacentes de un contenedor con respecto a otros contenedores o de la máquina host.

## Caracteristicas:
- **Unidades de aislamiento**:
  * Los contenedores proporcionan un entorno aislado para que las aplicaciones se ejecuten. Esto significa que cada contenedor tiene sus propios archivos del sistema, bibliotecas y configuraciones, separados de otros contenedores y del sistema operativo subyacente.

- **Ligeros y eficientes**:
  - Los contenedores son ligeros en comparación con las máquinas virtuales tradicionales. Utilizan los recursos del sistema de manera más eficiente al compartir el mismo kernel del sistema operativo subyacente.

- **Portabilidad**:
  - Los contenedores son portables, lo que significa que puedes ejecutar el mismo contenedor en diferentes ambientes, como desarrollo, pruebas y producción, sin preocuparte por las diferencias de configuración.

- **Empaquetado completo**:
  - Un contenedor contiene todo lo necesario para que una aplicación se ejecute, incluyendo el código, las bibliotecas, las dependencias y las configuraciones. Esto facilita el despliegue de aplicaciones y asegura que funcionen de manera consistente en cualquier lugar.

## Componentes Claves de los Containers
- **Imagen**:
  - Un contenedor se crea a partir de una imagen, que es un paquete que contiene todo lo necesario para ejecutar una aplicación. La imagen incluye el sistema operativo, las bibliotecas y el código de la aplicación.

- **Contenedor**:
  - Cuando se inicia un contenedor a partir de una imagen, se crea una instancia en tiempo de ejecución de esa imagen. Este contenedor es un entorno aislado y ejecuta la aplicación de manera independiente.
  - Se puede iniciar, detener, pausar y reiniciar fácilmente.

-  **Dockerfile**
   -  Archivo que define cómo construir una imagen contenedorizada.

- **Registry (Docker Hub, AWS ECR, GitHub Container Registry)**
  - Repositorio donde se almacenan y distribuyen imágenes de contenedores.

- **Orquestador (Kubernetes, Docker Swarm)**
  - Gestiona múltiples contenedores en producción, asegurando disponibilidad y escalabilidad.

## docker cp
El comando docker cp permite copiar archivos o directorios entre el sistema de archivos del **host** y un contenedor.

1. Copiar Datos desde el Contenedor Fuente al Host:

```bash
docker cp contenedor1:/data/archivo.txt /tmp/archivo.txt
```

2. Copiar Datos desde el Host al Contenedor de Destino:

```bash
docker cp /tmp/archivo.txt contenedor2:/data/
```