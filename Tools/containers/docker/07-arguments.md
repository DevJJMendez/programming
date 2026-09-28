### argumentos más comunes utilizados en el comando **docker run**

- **-d** (detach):
  Se utiliza para ejecutar el contenedor en segundo plano (modo detach).

  **Ejemplo:**
  ```bash
  docker run -d imagen
  ```

- **-p** (publish):
  Permite mapear puertos entre el host y el contenedor. Esto es esencial cuando se ejecuta un servicio en un contenedor que necesita ser accesible desde fuera del contenedor, como una aplicación web o un servidor de base de datos. 
  **Ejemplo:**

  ```bash
  docker run -p 80:8080 imagen
  ```
  Esto mapea el puerto 8080 del contenedor al puerto 80 del host. Ahora, cuando accedas al puerto 80 en el host, se redirigirá al puerto 8080 dentro del contenedor donde está ejecutándose la aplicación web.

- **-v** (volume):

  Monta un volumen entre el host y el contenedor, permitiendo persistencia de datos.

  Ejemplo:

  ```bash
  docker run -v directorio_host:directorio_contenedor imagen
  ```

- **-it**:

  Utilizado para interactuar con el contenedor en modo interactivo.

  Ejemplo:

  ```bash
  docker run -it imagen
  ```

- **-e** (environment):

  Permite definir variables de entorno dentro del contenedor.

  Ejemplo:

  ```bash
  docker run -e VARIABLE=valor imagen
  ```

- **--name**:

  Permite especificar un nombre para el contenedor.

  Ejemplo:

  ```bash
  docker run --name nombre_contenedor imagen
  ```

- **--rm**:

  Elimina el contenedor automáticamente después de detenerlo.

  Ejemplo:

  ```bash
  docker run --rm imagen
  ```

- **--network**:

  Especifica la red a la que se conectará el contenedor.

  Ejemplo:

  ```bash
  docker run --network nombre_red imagen
  ```

- **--link**:

  Conecta un contenedor a otro, permitiendo la comunicación entre ellos.

  Ejemplo:

  ```bash
  docker run --link nombre_contenedor:alias_contenedor imagen
  ```

- **--volume-from**:

  Monta un volumen desde otro contenedor.

  Ejemplo:

  ```bash
  docker run --volume-from contenedor_fuente imagen
  ```

- **--restart**:

  Especifica la política de reinicio del contenedor.

  Ejemplo:

  ```bash
  docker run --restart always imagen
  ```

- **--privileged**:

  Permite al contenedor tener acceso a todos los dispositivos del host.

  Ejemplo:

  ```bash
  docker run --privileged imagen
  ```

- **--detach-keys**:

  Permite cambiar las teclas de control para salir del modo detach.

  Ejemplo:

  ```bash
  docker run --detach-keys teclas imagen
  ```

- **--dns**:

  Especifica el servidor DNS a utilizar dentro del contenedor.

  Ejemplo:

  ```bash
  docker run --dns servidor_dns imagen
  ```

- **--hostname**:

  Especifica el nombre de host del contenedor.

  Ejemplo:

  ```bash
  docker run --hostname nombre_host imagen
  ```
- `--entrypoint`: Permite especificar un comando de entrada (entrypoint) para el contenedor.
```bash
docker run --entrypoint comando_de_entrada imagen
```
- `--user`: Especifica el nombre de usuario o UID (User ID) bajo el cual se ejecutará el contenedor.
```bash
docker run --user nombre_usuario imagen
```

- `--workdir`: Establece el directorio de trabajo dentro del contenedor.
```bash
docker run --workdir directorio imagen
```

- `--memory`: Limita la cantidad de memoria que puede utilizar el contenedor.
```bash
docker run --memory 1g imagen
```
- `--cpu-shares`: Asigna una proporción de CPU para el contenedor en relación con otros contenedores en el mismo sistema.
```bash
docker run --cpu-shares 512 imagen
```
- `--env-file`: Permite especificar un archivo que contiene variables de entorno.
```bash
docker run --env-file archivo.env imagen
```
- `--label`: Asigna etiquetas (labels) al contenedor para facilitar la identificación y organización.
```bash
docker run --label key=value imagen
```
- `--read-only`: Monta el sistema de archivos del contenedor en modo de solo lectura.
```bash
docker run --read-only imagen
```
- `--link`: Conecta el contenedor a otro contenedor en la misma red.
```bash
docker run --link nombre_contenedor:alias_contenedor imagen
```
- `--cap-add` y `--cap-drop`: Permite agregar o eliminar capacidades de los procesos dentro del contenedor.
```bash
docker run --cap-add NET_ADMIN imagen
```
- `--log-driver`: Especifica el controlador de registro (log driver) a utilizar para los logs del contenedor.
```bash
docker run --log-driver syslog imagen
```
- `--security-opt`: Especifica opciones de seguridad para el contenedor, como SELinux o AppArmor.
```bash
docker run --security-opt seccomp=unconfined imagen
```
- `--storage-opt`: Especifica opciones de almacenamiento para el contenedor, como tamaño máximo de disco.
```bash
docker run --storage-opt size=10G imagen
```
- `--tmpfs`: Monta un directorio como un sistema de archivos temporal en la memoria del contenedor.
```bash
docker run --tmpfs /tmp:size=512m imagen
```
- `--device`: Permite acceder a dispositivos del host desde el contenedor.
```bash
docker run --device=/dev/sda:/dev/xvda imagen
```