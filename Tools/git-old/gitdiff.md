# `git diff`
El comando `git diff` te permite inspeccionar las diferencias entre distintos estados del código en un repositorio. 

Su principal utilidad es comparar cambios que han ocurrido en tu código, ya sea antes de realizar un commit, entre diferentes ramas, o entre commits específicos.

## ¿Qué hace git diff?
Este comando compara dos versiones de un archivo o conjunto de archivos y muestra las diferencias en formato de "**diff**" (líneas eliminadas con `-`, líneas añadidas con `+`).

## Propósito de git diff
git diff te ayuda a:

* Ver qué cambios se han hecho en el directorio de trabajo que aún no están preparados.

* Comparar los cambios entre el directorio de trabajo y el área de preparación (staging area).

* Comparar el área de preparación con los últimos commits.

* Comparar diferentes ramas, commits o incluso archivos específicos.

## Uso básico de `git diff`
Cuando ejecutas `git diff` sin ningún argumento, Git compara el directorio de trabajo con el área de preparación (**`staging area`**). Esto te muestra qué cambios aún no han sido añadidos para el próximo commit.

```bash
git diff
```

## Entendiendo la salida de git diff
La salida de `git diff` puede parecer compleja al principio, pero es bastante clara una vez comprendes su estructura.

**Ejemplo**
```plaintext
diff --git a/index.html b/index.html
index 83db48f..bf4ae34 100644
--- a/index.html
+++ b/index.html
@@ -1,4 +1,5 @@
 <!DOCTYPE html>
 <html>
+<head>
     <title>Mi sitio web</title>
 </head>
```
En este ejemplo:

* Las líneas con `---` y `+++` indican qué archivo se está comparando: `a/index.html` (antes) y b/`index.html` (después).

* Las líneas que comienzan con un `+` son líneas nuevas que se añadieron (como `<head>`).

* Las líneas que comienzan con un `-` son líneas eliminadas.

* Las demás líneas no cambian y se muestran para dar contexto.

## Opciones comunes del comando `git diff`
* **Comparar directorio de trabajo con el área de preparación**: Para ver los cambios en tu directorio de trabajo que aún no han sido añadidos al área de preparación, puedes usar el comando básico:

  ```bash
  git diff
  ```
  Este comando te muestra las diferencias entre tu copia de trabajo y el área de preparación.

* **Comparar el área de preparación con el último commit**: Para ver las diferencias entre los archivos que ya has preparado (staged) y el último commit en tu rama actual:

  ```bash
  git diff --staged
  ```
  Este comando es útil para revisar los archivos que están listos para ser confirmados antes de ejecutar git commit.

* **Comparar entre dos commits**: Puedes usar `git diff` para comparar dos commits específicos. Esto es útil cuando quieres ver qué cambios se introdujeron entre dos puntos en el tiempo.

  ```bash
  git diff <commit1> <commit2>
  ```
  **Ejemplo**
  ```bash
  git diff 83db48f bf4ae34
  ```
  Esto mostrará las diferencias entre los commits con las referencias `83db48f` y `bf4ae34`.


* **Comparar cambios entre ramas**: Para comparar las diferencias entre dos ramas:

  ```bash
  git diff <branch1> <branch2>
  ```
  Esto te permitirá ver qué cambios existen entre dos ramas, lo que es útil antes de hacer un `merge` o `rebase`.

* **Comparar un archivo específico**: Puedes restringir git diff a un solo archivo para ver sus cambios:

  ```bash
  git diff <file>
  ```
  **Ejemplo**
  ```bash
  git diff index.html
  ```
  Esto mostrará solo las diferencias en el archivo `index.html` en tu directorio de trabajo en comparación con el área de preparación.

* **Comparar con un commit específico**: Si deseas ver los cambios entre tu directorio de trabajo y un commit específico, puedes usar:

  ```bash
  git diff <commit>
  ```
  Esto mostrará las diferencias entre tu estado actual y el commit indicado.

## Otras opciones y configuraciones de `git diff`
* **Mostrar diferencias a nivel de palabras en lugar de líneas**: De forma predeterminada, `git diff` muestra las diferencias línea por línea, pero puedes verlo a nivel de palabras para obtener un análisis más detallado.

  ```bash
  git diff --word-diff
  ```
  Esto es útil cuando los cambios dentro de una misma línea son pequeños y difíciles de detectar.

* **Mostrar estadísticas de los cambios**: Puedes obtener un resumen de cuántas líneas se han añadido, eliminado o modificado en lugar de mostrar todas las diferencias de los archivos.

  ```bash
  git diff --stat
  ```
  **Salida de ejemplo**
  ```bash
  index.html |  2 +-
  style.css  |  1 +
  2 files changed, 2 insertions(+), 1 deletion(-)
  ```
  Este resumen es muy útil para obtener una visión rápida del alcance de los cambios sin examinar los detalles.

* **Ignorar espacios en blanco**: Si deseas ignorar los cambios relacionados solo con espacios en blanco, puedes usar:

  ```bash
  git diff -w
  ```
  Esto es útil cuando alguien ha reestructurado código (por ejemplo, cambiado la indentación) sin modificar el contenido lógico.