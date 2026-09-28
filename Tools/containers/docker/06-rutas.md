# Host
En el contexto de Docker, el término **host** se refiere al sistema operativo subyacente en el que se ejecuta el motor Docker. 

1. **Sistema Operativo Host**:

   * Es el sistema operativo real en el que Docker está instalado y ejecutándose. Puede ser una máquina física o una máquina virtual.

   * **Ejemplos**: Ubuntu, CentOS, Windows, macOS, etc.

2. **Sistema de Archivos del Host**:

   * Es el sistema de archivos que reside en el sistema operativo host. Cuando montas un directorio local desde el host en un contenedor Docker, estás refiriéndote a este sistema de archivos.
   
   * **Uso en Docker**: Puedes montar directorios o archivos específicos del host en el contenedor para compartir datos o persistir información. Por ejemplo, `-v /home/usuario/data:/app/data` monta el directorio `/home/usuario/data` del host en el contenedor en la ruta /app/data.

## Rutas Host y Rutas del Contenedor
Al trabajar con volúmenes y contenedores en Docker, **las rutas se definen mediante la especificación de las rutas del sistema de archivos del host y del contenedor**. Al montar un volumen, se establece una conexión entre una ruta en el host y una ruta en el contenedor.

### Definicion de Rutas en Docker:

1. **Ruta en el Host**:

  - La ruta en el host es la ubicación en el sistema de archivos del host desde donde se compartirán los datos con el contenedor.
  
  - Puede ser una ruta absoluta o relativa en el sistema de archivos del host.
  
  - Se puede utilizar cualquier ruta válida en el host, como `/home/usuario/mi_directorio` o `/ruta/completa/del/volumen`

2. **Ruta en el Contenedor**:

   * La ruta en el contenedor es la ubicación donde se montará el volumen dentro del contenedor.

   * También puede ser una ruta absoluta o relativa dentro del sistema de archivos del contenedor.

   * Se utiliza para acceder y manipular los datos que están en el volumen del host.

   * Por ejemplo, puede ser `/app/data` o cualquier otra ruta dentro del contenedor.

## Rutas Relativas y Absolutas:

* **Rutas Absolutas**: Son rutas que comienzan desde la raíz del sistema de archivos del host o del contenedor. Por ejemplo, `/home/usuario/mi_directorio`.

* Rutas Relativas: Son rutas que son relativas al directorio de trabajo actual del host o del contenedor. Por ejemplo, `./mi_directorio` (relativo al directorio actual) o `../otro_directorio` (un nivel hacia arriba en la jerarquía de directorios).

## Montaje de directorios en Contenedores

Montar directorios locales en contenedores Docker es una práctica común para compartir datos entre el sistema de archivos del host y el contenedor. Esto permite que el contenedor acceda y modifique archivos en el host, lo cual es útil para varias situaciones, como desarrollo, pruebas, y persistencia de datos.

El montaje de directorios locales consiste en hacer que una carpeta o archivo en el sistema de archivos del host sea accesible dentro del contenedor en una ruta específica. Esto se realiza utilizando la opción `-v` o `--mount` en el comando `docker run`.

**Sintaxis**

* **Con `-v` (`--volume`)**

    ```bash
    docker run -v /home/usuario/proyecto:/app proyecto_imagen
    ```
    * `/home/usuario/proyecto` es la ruta en el host.

    * `/app` es la ruta en el contenedor donde se montará el directorio.
    
    * **Montaje de un archivo local**
      ```bash
      docker run -v /home/usuario/config.yml:/app/config.yml imagen
      ```
* **Con `--mount`**

    ```bash
    docker run --mount type=bind,source=/home/usuario/proyecto,target=/app imagen
    ```