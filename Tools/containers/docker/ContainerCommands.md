# Ejecutar o Levantar un Contenedor
```bash
docker container run [opciones] nombre_de_la_imagen [comando]
```
se utiliza para crear y ejecutar un contenedor basado en una imagen específica. Es uno de los comandos más fundamentales y utilizados en Docker, ya que permite tomar una imagen, crear un contenedor a partir de ella, y ejecutar una aplicación dentro de ese contenedor.

## Opciones comunes
- `-d`: Ejecuta el contenedor en segundo plano (detached mode).

- `-it`: Asigna un terminal interactivo al contenedor, útil para ejecutar comandos interactivos.

- `-p`: Mapea puertos del host al contenedor (por ejemplo, -p 8080:80).

- `--name`: Asigna un nombre al contenedor.

- `-e`: Define variables de entorno dentro del contenedor.

- `--volume` o `-v`: Monta volúmenes del host al contenedor.
  
## Funcionamiento
- **Creación y ejecución de contenedores**:
  * Este comando toma una imagen Docker y crea un contenedor a partir de ella. También permite especificar opciones como puertos, volúmenes, variables de entorno, entre otros.

- **Uso básico**:
```bash
docker container run [opciones] nombre_de_la_imagen [comando]
```

- **[opciones]**: Son las opciones que puedes especificar, como puertos, volúmenes, variables de entorno, etc.

- **nombre_de_la_imagen**: Es el nombre o ID de la imagen a partir de la cual se creará el contenedor.

- **[comando]**: Opcionalmente, puedes especificar un comando que se ejecutará dentro del contenedor al iniciar.
  - Ejemplo
```bash
docker container run -p 8080:80 --name mi_contenedor nginx
```
Este comando crea un nuevo contenedor basado en la imagen oficial de Nginx, exponiendo el puerto 80 del contenedor al puerto 8080 del host, y le asigna el nombre "mi_contenedor".


## Utilidad
- **Ejecución de aplicaciones**: Esencialmente, `docker container run` te permite ejecutar aplicaciones y servicios dentro de contenedores Docker de manera rápida y sencilla.

- **Pruebas y desarrollo**: Es útil para probar aplicaciones en un entorno aislado y reproducible. Los contenedores se pueden eliminar y recrear fácilmente sin afectar al sistema host.

- **Despliegue**: Para desplegar aplicaciones en producción, puedes usar docker container run con las opciones adecuadas para configurar el entorno de manera específica.
  
# Listar Contenedores en Ejecución
```bash
docker ps
docker ls
```

- Muestra todos los contenedores, incluidos los detenidos.
```bash
docker ps -all
docker ps -a
```

# Estados de un Contenedor
- **CREATED**: El contenedor ha sido creado pero aún no ha sido iniciado.

- **RUNNING**: El contenedor está en ejecución y su aplicación está activa.

- **PAUSED**: El contenedor ha sido pausado, lo que significa que su ejecución ha sido detenida temporalmente. La aplicación dentro del contenedor no está corriendo.

- **EXITED**: El contenedor ha sido detenido y ya no está en ejecución. Esto puede ocurrir después de que la aplicación dentro del contenedor termine su ejecución de manera normal.

- **RESTARTING**: El contenedor está en proceso de reinicio. Docker está intentando reiniciar el contenedor después de un fallo o de haber sido detenido manualmente.

## Descripcion de los estados
- **CREATED**: Este estado ocurre inmediatamente después de que se crea un contenedor con el comando docker container create, pero antes de que se inicie con docker container start.

- **RUNNING**: Indica que el contenedor está en ejecución y su aplicación está activa y funcionando. Puedes acceder a la aplicación y los servicios que proporciona el contenedor.

- **PAUSED**: Cuando un contenedor se pausa con docker container stop, se detiene temporalmente su ejecución. Esto puede ser útil para conservar el estado de la aplicación sin detener completamente el contenedor.

- **EXITED**: Este estado indica que el contenedor ha terminado su ejecución y ha salido. Puede haber salido después de completar su tarea o debido a un error en la aplicación dentro del contenedor.

- **RESTARTING**: Este estado indica que el contenedor está en proceso de reinicio. Puede ocurrir después de que se configure el contenedor para reiniciarse automáticamente en caso de fallo, o después de que el contenedor se reinicie manualmente.

# Detener un Contenedor
```bash
docker container stop nombre_del_contenedor_o_ID
```

# Iniciar un Contenedor detenido
```bash
docker container start nombre_del_contenedor_o_ID
```

# Eliminar un Contenedor
```bash
docker container rm nombre_del_contenedor_o_ID
```

# Eliminar los Contenedores Detenidos
```bash
docker container prune
```

# Mostrar Información de un Contenedor
```bash
docker inspect nombre_del_contenedor_o_ID
```

# docker container exec
se utiliza para **ejecutar comandos dentro de un contenedor que ya está en ejecución**. Esto es útil cuando necesitas interactuar con un contenedor en tiempo de ejecución, como ejecutar comandos, acceder a una terminal interactiva, o realizar tareas de mantenimiento y administración.

- Uso Básico de docker exec:
```bash
docker exec [opciones] nombre_del_contenedor comando
```
- `[opciones]`: Son las opciones que puedes especificar, como -it para asignar un terminal interactivo.
- `nombre_del_contenedor`: Es el nombre o ID del contenedor en el que deseas ejecutar el comando.
- `comando`: Es el comando que deseas ejecutar dentro del contenedor.

- Ejemplos de uso:
  - **Ejecutar un Comando Dentro del Contenedor**: Para ejecutar un comando dentro de un contenedor en ejecución, simplemente especifica el nombre del contenedor y el comando que deseas ejecutar. Por ejemplo, para ver los archivos en un contenedor:

```bash
docker exec nombre_del_contenedor ls
```

### **Acceder a una terminal interactiva**
Puedes acceder a una terminal interactiva dentro del contenedor utilizando las opciones `-it`:

```bash
docker exec -it nombre_del_contenedor /bin/bash
```
Esto abrirá una terminal interactiva dentro del contenedor donde puedes ejecutar comandos interactivamente.

### Ventajas de docker exec:
- Interacción con Contenedores en Ejecución: Te permite interactuar con contenedores que ya están en ejecución, lo que es útil para realizar tareas de mantenimiento, administración o depuración.

- Ejecución de Comandos: Puedes ejecutar comandos específicos dentro del contenedor sin necesidad de detenerlo y volver a iniciarlo.

- Depuración y Diagnóstico: Útil para la depuración de problemas dentro del contenedor o para verificar el estado de una aplicación en tiempo de ejecución.

### Ejemplos de Uso Avanzado:
* **Instalación de Paquetes**: Puedes instalar paquetes dentro de un contenedor en ejecución:
```bash
docker exec nombre_del_contenedor apt-get install -y nombre_del_paquete
```

### Importante:
- Recuerda que `docker exec` solo funciona en contenedores **que ya están en ejecución**. Si intentas ejecutarlo en un contenedor detenido, obtendrás un error.

- Puedes especificar opciones como `-it` para obtener una terminal interactiva y `-u` para especificar un usuario dentro del contenedor.

# DIFF
El comando `docker diff` es una herramienta útil en Docker que te permite ver los cambios realizados en el sistema de archivos de un contenedor en comparación con la imagen original del contenedor. Este comando lista las diferencias, mostrando qué archivos o directorios se han agregado, eliminado o modificado desde que se creó el contenedor. Es particularmente útil para depuración y auditoría.

**Sintaxis del Comando**
```bash
docker diff [OPTIONS] CONTAINER
```
- `CONTAINER`: El nombre o ID del contenedor sobre el cual deseas ver los cambios.

**Ejemplo de Uso**

Supongamos que tienes un contenedor en ejecución con el nombre `mi_contenedor`. Puedes ejecutar el siguiente comando para ver los cambios en el sistema de archivos:
```bash
docker diff mi_contenedor
```
**Interpretación de la Salida**

La salida del comando `docker diff` muestra una lista de archivos y directorios que han cambiado, con un prefijo que indica el tipo de cambio:

- **A**: Added (Agregado)
  - Indica que el archivo o directorio ha sido agregado en el contenedor.
- **D**: Deleted (Eliminado)
  - Indica que el archivo o directorio ha sido eliminado del contenedor.
- **C**: Changed (Cambiado)
  - Indica que el archivo o directorio ha sido modificado en el contenedor.

**ejemplo de Salida**
```bash
A /nuevo_archivo.txt
C /etc/hostname
D /archivo_eliminado.txt
```
En este ejemplo:

- `/nuevo_archivo.txt` ha sido agregado al contenedor.
- `/etc/hostname` ha sido modificado.
- `/archivo_eliminado.txt` ha sido eliminado del contenedor.

**Casos de Uso Comunes**

1. **Depuración**: 
   - Ayuda a identificar qué archivos han sido modificados o creados por el proceso que se ejecuta dentro del contenedor.
   - Útil para detectar cambios inesperados en el sistema de archivos del contenedor.

2. **Auditoría**:
   - Permite auditar los cambios en el sistema de archivos del contenedor para asegurarse de que no se han realizado modificaciones no autorizadas.

3. **Desarrollo y Pruebas**:
   - Ayuda a los desarrolladores a entender qué cambios se producen en el contenedor durante el desarrollo y las pruebas de sus aplicaciones.

**Limitaciones**

- **Persistencia de Cambios:**
  - El comando muestra los cambios realizados en el sistema de archivos del contenedor actual. No guarda un historial de cambios a lo largo del tiempo.

- **Granularidad de Cambios:**
  - No muestra detalles sobre qué partes específicas de un archivo han cambiado, solo que el archivo en sí ha sido modificado.

## Docker Diff
El comando `docker diff` es una herramienta útil en Docker que te permite ver los cambios realizados en el sistema de archivos de un contenedor en comparación con la imagen original del contenedor. Este comando lista las diferencias, mostrando qué archivos o directorios se han agregado, eliminado o modificado desde que se creó el contenedor. Es particularmente útil para depuración y auditoría.

```bash
docker diff [OPTIONS] CONTAINER
```

### Interpretación de la Salida
La salida del comando `docker diff` muestra una lista de archivos y directorios que han cambiado, con un prefijo que indica el tipo de cambio:

* `A`: **Added (Agregado)**: Indica que el archivo o directorio ha sido agregado en el contenedor.

* `D`: **Deleted (Eliminado)**: Indica que el archivo o directorio ha sido eliminado del contenedor.

* `C`: **Changed (Cambiado)**: Indica que el archivo o directorio ha sido modificado en el contenedor.

**Salida**
```bash
A /nuevo_archivo.txt
C /etc/hostname
D /archivo_eliminado.txt
```
**En este ejemplo:**

* `/nuevo_archivo.txt` ha sido agregado al contenedor.

* `/etc/hostname` ha sido modificado.

* `/archivo_eliminado.txt` ha sido eliminado del contenedor.