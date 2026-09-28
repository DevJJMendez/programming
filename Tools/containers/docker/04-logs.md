### Logs
Los logs son registros de eventos y mensajes de salida que son generados por aplicaciones y servicios dentro del contenedor. Estos logs pueden ser útiles para monitorear el estado y el comportamiento de una aplicación, depurar problemas, y realizar análisis de rendimiento.

### ¿Para qué sirven los Logs?
Los logs son registros de eventos y mensajes de salida que son generados por las aplicaciones y servicios dentro del contenedor. Sirven para varios propósitos:

- **Monitoreo**: Los logs proporcionan información sobre el estado y el comportamiento de una aplicación en tiempo de ejecución. Puedes monitorear los logs para asegurarte de que la aplicación está funcionando como se espera.

- **Diagnóstico de Problemas**: Cuando ocurren errores o problemas, los logs pueden ser una herramienta invaluable para diagnosticar y solucionar problemas. Los mensajes de error y advertencias a menudo se registran en los logs.

- **Auditoría y Seguridad**: Los logs pueden utilizarse para realizar auditorías de actividad, rastrear acciones específicas y garantizar la seguridad de la aplicación y los datos.

- **Análisis de Rendimiento**: Al analizar los logs, puedes obtener información sobre el rendimiento de la aplicación, identificar cuellos de botella y optimizar el funcionamiento.

### Listar Logs de un Container
```bash
docker container logs [opciones] nombre_del_contenedor_o_id_del_contenedor
```
- `[opciones]`: Son las opciones que puedes especificar para controlar cómo se muestran los logs, como:

  - `-f` o `--follow`: Sigue los logs en tiempo real.
  
  - `--tail` `[número]`: Muestra las últimas N líneas de logs.
  
  - `nombre_del_contenedor`: Es el nombre o ID del contenedor del cual deseas ver los logs.

### Estados de las lineas de logs

- El estado "A" (**Added**) indica que una línea o un bloque de código ha sido agregado. En el contexto de los logs de Docker, este estado podría significar que se ha añadido un nuevo archivo, configuración, o recurso dentro del contenedor.

  ```bash
  [A] Added new configuration file: nginx.conf
  ```

- El estado "D" (**Deleted**) indica que una línea o un bloque de código ha sido eliminado. En el contexto de los logs de Docker, este estado podría significar que se ha eliminado un archivo, configuración, o recurso dentro del contenedor.

  ```bash
  [D] Deleted unnecessary log files
  ```

- El estado "C" (**Changed**) indica que una línea o un bloque de código ha sido cambiado o modificado. En los logs de Docker, esto podría significar que se ha modificado un archivo, configuración, o recurso dentro del contenedor.

  ```bash
  [C] Changed permissions for database file
  ```

### Ejemplos de uso

- **Ver Todos los Logs**:
  ```bash
  docker container logs nombre_del_contenedor
  ```
- **Ver los Últimos N(número) de Logs**:
  ```bash
  docker container logs --tail 100 nombre_del_contenedor
  ```
  Esto mostrará las últimas 100 líneas de logs del contenedor.


- **Seguir los Logs en Tiempo Real**:
  ```bash
  docker container logs -f nombre_del_contenedor
  ```
### Importante:
- Los logs son información importante para el monitoreo y la administración de contenedores y aplicaciones.

- Puedes usar `docker container logs` para ver logs en tiempo real, las últimas líneas de logs, o todos los logs de un **contenedor en ejecución**.

### Otros Estados

1. **INFO**: Mensajes informativos que indican que un evento ha ocurrido con éxito o se ha completado una tarea. Estos mensajes son generalmente de naturaleza informativa y no indican problemas.
```bash
[INFO] Server started on port 8080
```
2. **DEBUG**: Mensajes de depuración que son útiles para los desarrolladores mientras están depurando o investigando problemas. Contienen información detallada sobre el funcionamiento interno de la aplicación o el contenedor.
```bash
[DEBUG] Processing request from client IP: 192.168.1.1
```
3. **WARNING** (advertencia): Mensajes que indican una situación potencialmente problemática que no es necesariamente un error. Pueden señalar condiciones anormales o advertir sobre problemas que podrían surgir.
```bash
[WARNING] Disk space is running low. Please free up space.
```
4. **ERROR**: Mensajes que indican un error que ocurrió durante la ejecución de la aplicación o el contenedor. Estos mensajes indican que algo salió mal y requiere atención.
```bash
[ERROR] Database connection failed.
```
5. **CRITICAL** (crítico): Mensajes que indican un error grave que probablemente haya detenido el funcionamiento normal de la aplicación o el contenedor. Este estado indica que es necesaria una acción inmediata.
```bash
[CRITICAL] Server is down. Urgent action required!
```
---

- Lista las redes de Docker

```bash
docker network ls
```

- Crea una red de Docker

```bash
docker network create nombre_de_la_red
```

- Conecta un contenedor a una red
```bash
docker network connect nombre_de_la_red nombre_del_contenedor
```