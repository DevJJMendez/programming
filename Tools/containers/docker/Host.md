# Host
En el contexto de Docker, el término "host" hace referencia a la máquina física o virtual donde se ejecuta el motor de Docker y los contenedores. El host puede ser el sistema operativo del usuario, un servidor en la nube o incluso una máquina virtual dentro de un clúster.

## ¿Qué es el Host en Docker?
El host en Docker es la máquina que ejecuta el Docker Engine, proporcionando los recursos necesarios (CPU, memoria, red, almacenamiento) para ejecutar los contenedores.

El host puede ser:

* Un servidor físico o virtual con Linux, Windows o MacOS.
* Un servidor en la nube (AWS, Azure, GCP, etc.).
* Un nodo en un clúster de Kubernetes o Docker Swarm.

Docker aísla los contenedores del host mediante namespaces y cgroups, asegurando que cada contenedor tenga su propio entorno sin afectar al sistema principal.

## ¿Para qué sirve el Host en Docker?
El host es fundamental en la ejecución de contenedores porque:

* Proporciona los recursos necesarios (CPU, memoria, almacenamiento y red).
* Ejecuta el Docker Engine, permitiendo la gestión de imágenes y contenedores.
* Define la conectividad entre contenedores y el sistema externo.
* Almacena los volúmenes y datos persistentes de los contenedores.

## ¿Qué problemas resuelve el Host en Docker?
1. Evita la necesidad de configurar entornos manualmente
   * Antes de Docker, las aplicaciones requerían instalaciones complejas en el sistema operativo del servidor.
   * Solución: Con Docker, los contenedores se ejecutan en el host sin afectar el sistema principal.

2. Asegura la portabilidad de las aplicaciones
   * Las aplicaciones que dependen de un sistema operativo específico pueden no ejecutarse en otros entornos.
   * Solución: Docker abstrae el sistema operativo del host y proporciona un entorno uniforme.

3. Optimiza el uso de recursos
   * Las máquinas virtuales requieren múltiples instancias de sistemas operativos.
   * Solución: Docker usa un solo kernel compartido, reduciendo el consumo de memoria y CPU.

## Tipos de Redes en Docker y su Relación con el Host
Docker proporciona diferentes redes para conectar los contenedores con el host y entre sí:

1. Bridge (Red por defecto)
   * Cada contenedor tiene su propia IP dentro de una red virtual creada por Docker.

   * Permite comunicación entre contenedores en la misma red.

   * Los puertos deben ser expuestos manualmente para ser accesibles desde el host.
```bash
docker network create my_bridge
docker run --network=my_bridge -d nginx
```

2. Host (Sin aislamiento de red)
   * El contenedor usa directamente la red del host.

   * No se necesita mapear puertos manualmente.

   * Puede causar conflictos si dos contenedores intentan usar el mismo puerto.
```bash
docker run --network=host -d nginx
```
El servidor Nginx en este caso usará directamente los puertos del host.

3. None (Sin acceso a red)
   * El contenedor no tiene acceso a la red, solo a sí mismo.

   * Útil para aplicaciones que no requieren conectividad externa.
```bash
docker run --network=none -d nginx
```

## Relación entre el Host y los Volúmenes en Docker
El host también es clave en el almacenamiento de datos. Docker permite que los contenedores usen volúmenes para persistencia de datos, lo que evita la pérdida de información al detener un contenedor.

Montaje de volúmenes en el host
Un volumen permite que los datos persistan incluso si el contenedor es eliminado.

Ejemplo:
```bash
docker volume create my_volume
docker run -v my_volume:/data -d nginx
```
Aquí, los archivos en /data dentro del contenedor se almacenarán en el host.

También se pueden usar bind mounts para mapear una carpeta del host dentro del contenedor:
```bash
docker run -v /home/user/data:/app/data -d nginx
```
Esto permite que los archivos en /home/user/data del host sean accesibles dentro del contenedor en /app/data.