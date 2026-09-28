# Docker
Docker es una plataforma de contenerización que permite ejecutar aplicaciones en entornos aislados llamados **contenedores**.

Se utiliza para automatizar el despliegue de aplicaciones dentro de contenedores de software, proporcionando una capa adicional de abstracción y automatización de virtualización de aplicaciones en múltiples sistemas operativos.

## ¿Para qué sirve Docker?
Docker permite:
* Empaquetar una aplicación con todas sus dependencias en un solo contenedor

* Ejecutar la aplicación en cualquier entorno (local, servidor, nube, CI/CD, Kubernetes)

* Reducir problemas de compatibilidad entre sistemas operativos y configuraciones

* Facilitar el despliegue y escalabilidad de aplicaciones

* Optimizar el uso de recursos en comparación con máquinas virtuales

**Se usa en microservicios, CI/CD, despliegues en la nube, desarrollo local y pruebas.**

## Caracteristicas de Docker
- **Portabilidad y consistencia**: Docker permite empaquetar una aplicación con todas sus dependencias en un contenedor, lo que garantiza que se ejecute de la misma manera en cualquier ambiente donde se despliegue. Esto mejora la consistencia y la portabilidad de las aplicaciones.

- **Despliegue rápido y eficiente**: Al usar Docker, los desarrolladores y los equipos de operaciones (DevOps) pueden desplegar rápidamente aplicaciones en cualquier entorno sin preocuparse por las diferencias de configuración o dependencias. Esto acelera el proceso de desarrollo y despliegue.

- **Aislamiento**: Los contenedores de Docker proporcionan aislamiento entre las aplicaciones, lo que significa que cada contenedor funciona como una unidad independiente. Esto evita conflictos entre aplicaciones y mejora la seguridad.

- **Eficiencia de recursos**: Docker utiliza los recursos del sistema de manera eficiente al compartir recursos del sistema operativo subyacente. Esto significa que se pueden ejecutar múltiples contenedores en una misma máquina sin el peso de múltiples sistemas operativos completos.

- **Escalabilidad**: Docker facilita la escalabilidad de aplicaciones, ya que se pueden agregar o quitar contenedores según la demanda de la aplicación. Esto permite manejar picos de tráfico de manera más sencilla y eficiente.

## ¿Qué problemas resuelve Docker?
1. ***"En mi máquina funciona, pero en producción no"***
   * Las diferencias en dependencias y configuraciones entre entornos hacen que el código funcione en un lugar, pero falle en otro.

   * **Solución**: Docker encapsula la aplicación con sus dependencias, asegurando que se ejecute de manera consistente en cualquier sistema.

2. **Desperdicio de recursos con Máquinas Virtuales (VMs)**
   * Las VMs requieren un sistema operativo completo, consumiendo más CPU, RAM y espacio en disco.

   * **Solución**: Docker usa contenedores ligeros que comparten el mismo kernel del SO anfitrión, reduciendo el uso de recursos.

3. **Despliegues lentos y complicados**
   * Desplegar aplicaciones requiere muchas configuraciones manuales y ajustes en servidores.

   * **Solución**: Docker permite automatizar despliegues con contenedores preconfigurados que se ejecutan en segundos.

4. **Dificultad para escalar aplicaciones**
   * Aumentar la capacidad de una aplicación manualmente es complejo.

   * **Solución**: Docker, junto con Kubernetes, permite escalar servicios automáticamente según la demanda.

## ¿Cómo lo resuelve Docker?
Docker resuelve estos problemas mediante:

* **Imágenes y Contenedores**
  * Una imagen Docker es una plantilla inmutable con el sistema de archivos y dependencias necesarias.

  * Un contenedor es una instancia en ejecución de una imagen.

  * Se pueden crear múltiples contenedores desde una misma imagen.

* **Portabilidad y Compatibilidad**
  * Un contenedor Docker puede ejecutarse en Windows, Linux, macOS, servidores, nubes y Kubernetes sin cambios.

  * Basado en estándares abiertos (OCI - Open Container Initiative).

* **Automatización y CI/CD**
  * Integrado con herramientas de CI/CD como GitHub Actions, GitLab CI, Jenkins, etc.

  * Se pueden construir y desplegar aplicaciones automáticamente con Dockerfiles y Docker Compose.

* **Almacenamiento y Compartición con Docker Hub**: Las imágenes Docker pueden almacenarse y compartirse en Docker Hub o en registros privados.

## Componentes principales de Docker
1️⃣ Docker Engine
🔹 Motor que permite construir y ejecutar contenedores.

2️⃣ Dockerfile
🔹 Archivo que define cómo construir una imagen Docker.

3️⃣ Docker Images
🔹 Plantillas inmutables que contienen el código y dependencias.

4️⃣ Docker Containers
🔹 Instancias en ejecución de una imagen Docker.

5️⃣ Docker Hub / Docker Registry
🔹 Almacén donde se publican y distribuyen imágenes.

6️⃣ Docker Compose
🔹 Herramienta para definir y ejecutar múltiples contenedores con un solo archivo YAML.

7️⃣ Docker Networking
🔹 Permite la comunicación entre contenedores y con el mundo exterior.

## Arquitectura de Docker
Docker utiliza una arquitectura cliente-servidor. El cliente de Docker se comunica con el demonio Docker, que realiza el trabajo de crear, ejecutar y distribuir sus contenedores Docker. El cliente de Docker y el demonio pueden ejecutarse en el mismo sistema, o puede conectar un cliente Docker a un demonio Docker remoto. El cliente de Docker y el demonio se comunican mediante una API REST, a través de sockets UNIX o una interfaz de red.

![](assets/docker-architecture.webp)

## El Docker Daemon
El demonio de Docker (**dockerd**) escucha las solicitudes de la API de Docker y administra objetos de Docker como imágenes, contenedores, redes y volúmenes. Un demonio también puede comunicarse con otros demonios para administrar los servicios de Docker.

## El cliente Docker
El cliente de Docker (**docker**) es la forma principal en que muchos usuarios de Docker interactúan con Docker. Cuando utiliza comandos como `docker run`, el cliente envía estos comandos a **dockerd**, quien los ejecuta. El comando Docker utiliza la API de Docker. El cliente Docker puede comunicarse con más de un demonio.

## Registro de Docker
Un registro de Docker almacena imágenes de Docker. Por ejemplo Docker Hub es un registro público que cualquiera puede usar y Docker busca imágenes en Docker Hub de forma predeterminada. También puedes utilizar tu propio registro privado.

Cuando utiliza los comandos docker pull o docker run, Docker extrae las imágenes necesarias de su registro configurado. Cuando utiliza el comando docker push, Docker envía su imagen a su registro configurado.

## Docker Info
```bash
docker info
```

El comando `docker info` en Docker sirve para proporcionar información detallada sobre el entorno de Docker en el sistema donde se ejecuta. Al ejecutar este comando, se muestra una variedad de información útil sobre la configuración de Docker y el sistema en el que está instalado.

- **Versión de Docker**: Muestra la versión de Docker que está instalada en el sistema.

- **Número de contenedores**: Indica cuántos contenedores están actualmente en ejecución, así como cuántos contenedores están detenidos.

- **Número de imágenes**: Muestra cuántas imágenes de Docker están disponibles localmente en el sistema.

- **Uso de almacenamiento**: Proporciona información sobre el espacio total utilizado por las imágenes y contenedores en el sistema.

- **Número de CPUs y memoria disponible**: Muestra la cantidad de CPUs y memoria disponible en el sistema host que Docker está utilizando.

- **Versión del sistema operativo**: Muestra el nombre y la versión del sistema operativo en el que Docker está funcionando.

### Uso típico de docker info
- **Verificar estado de Docker**: Puedes usar docker info para comprobar si Docker está funcionando correctamente y obtener una visión general del estado actual del sistema Docker.

- **Diagnóstico**: Cuando se presentan problemas con Docker, docker info puede proporcionar información valiosa para diagnosticar el problema. Por ejemplo, si un contenedor no se está ejecutando correctamente, la información sobre los recursos del sistema y la configuración de Docker pueden ser útiles para identificar la causa del problema.

- **Recopilación de información del sistema**: Si necesitas obtener detalles sobre el sistema Docker para configurar o ajustar el entorno, docker info es una herramienta conveniente para recopilar esa información en un solo lugar.
