# `git log`
El comando `git log` es una de las herramientas más importantes en Git, ya que te permite explorar el historial de commits en un repositorio. Te ayuda a revisar lo que ha cambiado, cuándo y quién realizó los cambios. Es útil para ver el desarrollo del proyecto a lo largo del tiempo, rastrear bugs, y analizar el código desde cualquier commit.

##  Uso básico de `git log`
Cuando ejecutas `git log` sin argumentos, muestra una lista de los commits más recientes en la rama actual:

```bash
git log
```
**La salida básica de `git log` se ve algo así:**
```plaintext
commit 83db48f1bf4ae34c1d7d5b299e44e6f7bafe0379 (HEAD -> main)
Author: Juan Pérez <juan.perez@example.com>
Date:   Mon Sep 27 12:34:56 2024 +0200

    Agregado archivo de configuración inicial
```
Esto muestra:

* **Hash del commit**: Identificador único del commit (como `83db48f1bf4ae34c1d7d5b299e44e6f7bafe0379`).

* **Rama actual**: Indica la rama en la que se encuentra el commit (en este caso, main).

* **Autor**: La persona que realizó el commit.

* **Fecha**: Fecha y hora en que se realizó el commit.

* **Mensaje del commit**: La descripción breve que el autor proporcionó para describir los cambios.

## Opciones comunes del comando `git log`
* **Limitar el número de commits**: Puedes limitar el número de commits que se muestran en el log. Por ejemplo, para mostrar solo los últimos 3 commits:

  ```bash
  git log -n 3
  ```

* **Mostrar cambios de un autor específico**: Si deseas ver solo los commits realizados por un autor en particular, puedes filtrar por nombre o correo electrónico:

  ```bash
  git log --author="Juan Pérez"
  ```

* **Ver los cambios en un archivo específico**: Para ver el historial de cambios de un archivo en particular, usa el nombre del archivo:

  ```bash
  git log -- index.html
  ```
  Esto te muestra todos los commits que afectaron al archivo `index.html`.

* **Mostrar diferencias junto con el historial**: Puedes usar `git log` junto con `git diff` para ver las diferencias (el contenido del cambio) que se introdujeron en cada commit:

  ```bash
  git log -p
  ```
  Esto incluirá los cambios exactos hechos en cada commit.

## Formatos de salida de `git log`
* **Formato abreviado (oneline)**:Si quieres ver el historial de commits en una sola línea por commit, usa:

  ```bash
  git log --oneline
  ```
  Ejemplo de salida:
  ```plaintext
  83db48f1 (HEAD -> main) Agregado archivo de configuración inicial
  b2c3d4e7 Mejorado el rendimiento de la consulta
  c5f6g7h2 Refactorizado componente de usuario
  ```
  Cada commit se muestra con su hash abreviado y el mensaje del commit.

* `Mostrar el gráfico de ramas`: Para ver el historial en un formato gráfico que muestre las ramas y fusiones (merges) del proyecto, puedes usar:

  ```bash
  git log --graph --oneline
  ```
  Ejemplo de salida:
  ```plaintext
  * 83db48f1 (HEAD -> main) Agregado archivo de configuración inicial
  | * c5f6g7h2 (feature) Refactorizado componente de usuario
  |/
  * b2c3d4e7 Mejorado el rendimiento de la consulta
  ```
  Aquí puedes visualizar las bifurcaciones (como la rama feature) y los puntos de fusión.

* **Mostrar fechas y cambios de archivos**: Para incluir el nombre de los archivos que se modificaron en cada commit:

  ```bash
  git log --stat
  ```
  Ejemplo de salida:
  ```plaintext
  commit 83db48f1bf4ae34c1d7d5b299e44e6f7bafe0379 (HEAD -> main)
  Author: Juan Pérez <juan.perez@example.com>
  Date:   Mon Sep 27 12:34:56 2024 +0200

      Agregado archivo de configuración inicial

  index.html | 2 +-
  style.css  | 1 +
  2 files changed, 3 insertions(+), 1 deletion(-)
  ```
  Esto te da una visión rápida del impacto de cada commit en términos de archivos y líneas modificadas.

* **Mostrar el historial en un rango de fechas**: Puedes limitar el historial de commits a un rango de fechas específicas:

  ```bash
  git log --since="2024-09-01" --until="2024-09-27"
  ```
  Esto te mostrará los commits realizados entre el 1 de septiembre de 2024 y el 27 de septiembre de 2024.

## Filtrar commits en Git
* **Filtrar por palabra clave en los mensajes de commit**: Si recuerdas una palabra clave específica del mensaje del commit, puedes buscarla en el historial:

  ```bash
  git log --grep="configuración"
  ```
  Esto te mostrará los commits cuyo mensaje contiene la palabra "configuración".

* **Filtrar commits que modificaron un archivo específico**: Si quieres ver qué commits afectaron a un archivo específico, puedes usar el nombre del archivo:

  ```bash
  git log -- index.html
  ```
  Esto te dará una lista de los commits que cambiaron ese archivo.

* **Filtrar por un rango de commits**: Para ver el historial entre dos commits específicos:
  
  ```bash
  git log <commit1>..<commit2>
  ```
  Esto mostrará los commits entre esos dos puntos.

## Revisando commits con `git log`
* **Ver commits antiguos**: Puedes navegar en el historial utilizando varias opciones, como buscar el último commit modificado por un autor, ver commits en un archivo específico o usar fechas y mensajes de commits.

* **Revisar antes de hacer un merge o rebase**: Antes de realizar una operación compleja como un merge o un rebase, es común revisar el historial para asegurarte de que estás en la rama correcta o que no hay cambios inesperados.

* **Trazabilidad y depuración**: Cuando trabajas en un proyecto grande, el historial de commits es esencial para entender cuándo se introdujo un bug o cómo se modificaron ciertas funcionalidades. Puedes utilizar `git log` junto con `git bisect` para rastrear errores introducidos en el código.