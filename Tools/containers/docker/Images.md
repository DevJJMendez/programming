# Imagen
Una imagen es un paquete que contiene todo lo necesario para ejecutar una aplicación: el código de la aplicación, las bibliotecas, las dependencias, las variables de entorno y las configuraciones necesarias para que la aplicación funcione. Puedes pensar en una imagen como una plantilla o un plano de construcción para crear contenedores.

Una imagen es una plantilla de solo lectura con instrucciones para crear un contenedor Docker. Usualmente, una imagen se basa en otra imagen, con alguna personalización adicional. Por ejemplo, puedes crear una imagen basada en la imagen de Ubuntu, pero con el servidor web Apache y tu aplicación, así como los detalles de configuración necesarios para que tu aplicación se ejecute.

Puedes crear tus propias imágenes o utilizar únicamente aquellas creadas por otros y publicadas en un registro. Para crear tu propia imagen, crea un `Dockerfile` con una sintaxis simple para definir los pasos necesarios para crear la imagen y ejecutala.

## ¿Para qué sirven las Images?
* Empaquetar aplicaciones y sus dependencias
* Ejecutar contenedores de manera confiable y reproducible
* Distribuir aplicaciones en diferentes entornos (local, servidores, nube)
* Versionar y reutilizar software de forma eficiente

Las imágenes facilitan el desarrollo y despliegue en entornos de producción sin preocuparse por dependencias externas.

## ¿Cómo resuelven estos problemas las Images?
1. Portabilidad
   * Una imagen Docker se ejecuta en cualquier sistema con Docker instalado.

   * Compatible con Windows, Linux, macOS, servidores, Kubernetes y nubes.

2. Aislamiento de dependencias
   * Cada imagen tiene su propio entorno, evitando conflictos con otros proyectos.

3. Rápida ejecución y despliegue
   * No es necesario instalar dependencias en cada máquina, solo ejecutar la imagen.

4. Versionado y Reutilización
   * Se pueden versionar y actualizar imágenes sin afectar versiones previas.

   * Permiten crear bases para nuevas imágenes (FROM `<otra-imagen>`).

5. Optimización de Recursos
   * Almacenan capas (layers) en caché, reutilizando partes comunes entre imágenes.

## Componentes Claves de una Image
1. Capas (Layers). Las imágenes están compuestas por capas de solo lectura.
   * Ejemplo de capas en una imagen:
     * Ubuntu Base Layer (Sistema base)

     * Python Installed Layer (Python preinstalado)

     * App Dependencies Layer (Bibliotecas necesarias)

   * Application Code Layer (Código fuente)

Cada capa se almacena en caché y reutiliza en otras imágenes para optimizar espacio.

## Características de una imagen
- **Autosuficiente**:
  - Una imagen es autosuficiente, lo que significa que contiene todo lo necesario para que una aplicación se ejecute. Esto incluye el sistema operativo, las bibliotecas, el código de la aplicación y cualquier otra dependencia que la aplicación requiera.

- **Inmutable**:
  - Las imágenes son inmutables, lo que significa que una vez que se crea una imagen, no se puede cambiar. Si se realizan cambios en una imagen, se crea una nueva versión de esa imagen. Esto garantiza la consistencia y la reproducibilidad en el desarrollo y despliegue de aplicaciones.

- **Basadas en capas**:
  - Las imágenes de Docker están construidas en capas. Cada instrucción en el archivo Dockerfile (el archivo que define cómo se construye una imagen) agrega una capa adicional a la imagen. Esto permite que las imágenes sean eficientes en el almacenamiento y en la transferencia, ya que Docker solo necesita descargar y almacenar las capas que han cambiado.

## Uso de imagenes de Docker
- **Descarga**: Antes de ejecutar un contenedor, debes descargar la imagen desde un registro de Docker, como Docker Hub. Este registro es un repositorio público (o privado) donde se almacenan y comparten imágenes.

- **Construcción**: También puedes construir tus propias imágenes personalizadas utilizando un archivo llamado Dockerfile. En este archivo, especificas todos los pasos necesarios para construir la imagen, como la instalación de paquetes, la configuración de la aplicación, etc.

- **Reutilización**: Una ventaja clave de las imágenes es la capacidad de reutilizarlas. Si tienes una imagen base para una aplicación web, por ejemplo, puedes usarla para crear múltiples contenedores que ejecuten diferentes instancias de esa aplicación.

## Ejemplos de uso
Imagina que estás desarrollando una aplicación web en Node.js. Puedes utilizar una imagen oficial de Node.js como base para tu aplicación. En tu Dockerfile, especificarías que deseas construir tu imagen a partir de la imagen de Node.js y luego agregarías tus archivos de aplicación y las dependencias específicas de tu aplicación. Una vez construida, esta imagen puede ser utilizada para crear y ejecutar múltiples contenedores que ejecuten tu aplicación Node.js de manera consistente y predecible.