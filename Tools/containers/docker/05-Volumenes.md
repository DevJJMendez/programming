# Volumenes
Un volumen Docker es un directorio especial en el sistema de archivos del host que Docker gestiona y que se monta en un contenedor. Los volúmenes permiten almacenar datos generados y utilizados por contenedores y son útiles para persistir datos, compartir información entre contenedores y realizar copias de seguridad.

Los volúmenes en Docker son un mecanismo que permite persistir datos generados por contenedores, separados del ciclo de vida del contenedor en sí. Son una forma de almacenar y compartir datos de manera segura entre contenedores o entre el host y los contenedores

**¿Cómo Funcionan los Volúmenes?**

1. **Persistencia**:

   * Los datos en un volumen persisten incluso si el contenedor que los usa se elimina. Esto es útil para bases de datos y otros servicios que necesitan conservar datos.

2. **Separación**:

   * Los volúmenes están separados del sistema de archivos del contenedor. Esto significa que los datos en un volumen no se perderán cuando el contenedor se elimine o se reconstruya.

3. **Compartición**:

   * Los volúmenes se pueden montar en varios contenedores simultáneamente, permitiendo la compartición de datos entre contenedores.

**¿Para qué Sirven los Volúmenes en Docker?**

- **Persistencia de Datos**: 
  
  * Los volúmenes permiten que los datos generados por los contenedores se conserven incluso después de que el contenedor se detenga o se elimine. Esto es crucial para aplicaciones que requieren almacenamiento persistente, como bases de datos.

- **Compartir Datos entre Contenedores**: 
  
  * Los volúmenes pueden ser compartidos entre múltiples contenedores, lo que facilita la comunicación y el intercambio de información entre ellos.

- **Backups y Restauración**: 
  
  * Los volúmenes proporcionan un método conveniente para realizar copias de seguridad de los datos de los contenedores y restaurarlos en caso de pérdida de datos o errores.

- **Facilitar el Desarrollo**: 
  
  * Al usar volúmenes, puedes modificar el código o los archivos en el host y ver los cambios reflejados inmediatamente en el contenedor sin necesidad de reconstruirlo.

- **Optimización del Espacio**:
  
  * Los volúmenes pueden ser más eficientes en el uso de espacio que la copia completa de datos dentro de los contenedores, ya que solo los cambios y diferencias se almacenan en el volumen.

### Crear Volumen

```bash
docker volume create nombre_del_volumen
```
### Listar volumenes

```bash
docker volume ls
```

### Informacion del volumen

```bash
docker volume inspect nombreVolumen
```
### Eliminar un Volumen

```bash
docker volume rm nombreVolumen
```
## Docker Inspect
Para obtener información sobre un volumen en Docker, puedes utilizar el comando `docker volume inspect`. Este comando te proporcionará detalles sobre el volumen, como su nombre, etiquetas, punto de montaje y opciones de configuración. 

```bash
docker volume inspect nombre_volumen
```

Esto devolverá un **JSON** con detalles sobre el volumen. Aquí hay un ejemplo simplificado de cómo podría verse la salida:

```json
[
    {
        "CreatedAt": "2022-02-20T12:00:00Z",
        "Driver": "local",
        "Labels": {
            "com.docker.compose.project": "mi_proyecto",
            "com.docker.compose.version": "1.29.2",
            "com.docker.compose.volume": "mi_volumen"
        },
        "Mountpoint": "/var/lib/docker/volumes/mi_volumen/_data",
        "Name": "mi_volumen",
        "Options": {},
        "Scope": "local"
    }
]
```
### Información que Puedes Obtener:

* `CreatedAt`: La fecha y hora en que se creó el volumen.

* `Driver`: El controlador de almacenamiento utilizado por el volumen (como local para volúmenes locales).

* `Labels`: Etiquetas asociadas al volumen, que pueden ser útiles para identificación y organización.

* `Mountpoint`: El punto de montaje en el host donde está almacenado el contenido del volumen.

* `Name`: El nombre del volumen.

* `Options`: Opciones de configuración del volumen, como modo de acceso, tamaño, etc.

* `Scope`: El alcance del volumen (por lo general "local" para volúmenes no compartidos).

## Montar Volumen en un Contenedor

El montaje de volúmenes en contenedores Docker es una técnica esencial para gestionar datos persistentes y compartidos entre contenedores y el host. Los volúmenes Docker son una forma especial de almacenamiento gestionado por Docker que se diferencia de los montajes de directorios locales por su capacidad para persistir datos de manera independiente de los ciclos de vida de los contenedores.

Para utilizar un volumen en un contenedor, lo montas durante la ejecución del contenedor con la opción `-v` o `--mount`:

```bash
docker run -d -v mi_volumen:/app/datos imagen
```
* `mi_volumen` es el nombre del volumen.

* `/app/datos` es la ruta en el contenedor donde se montará el volumen.

**Usando `mount`**

```bash
docker run -d --mount type=volume,source=mi_volumen,target=/app/datos imagen
```
**Opciones de `--mount`**
* `type`: El tipo de montaje, que puede ser `volume`, `bind`, o `tmpfs`.

* `source`: El nombre del volumen o la ruta en el host (para montajes bind).

* `target`: El punto de montaje dentro del contenedor.
  
### Verificación de Volumen Montado:
Puedes verificar que el volumen se haya montado correctamente dentro del contenedor usando `docker inspect`:

```bash
docker inspect nombre_del_contenedor
```