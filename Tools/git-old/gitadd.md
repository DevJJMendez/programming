# `git add`
El comando **`git add`** es una de las primeras acciones que se realiza en Git para registrar los cambios en un repositorio. Su propósito es agregar archivos o modificaciones al **área de preparación (`staging area`)**, lo que indica a Git que deseas incluir estos cambios en el próximo commit. Es un paso clave en el flujo de trabajo de Git, ya que permite controlar qué cambios exactos se registrarán cuando realices un commit.

## Concepto básico de git add
Cuando haces cambios en un repositorio, Git los clasifica en diferentes estados:

* **Untracked (No rastreados)**: Archivos nuevos que Git aún no está rastreando.

* **Modified (Modificados)**: Archivos existentes que han sido cambiados, pero esos cambios aún no han sido preparados.

* **Staged (Preparados)**: Cambios que han sido agregados al área de preparación y están listos para ser confirmados (commiteados).

El comando `git add` mueve archivos desde el estado de `untracked` o `modified` al estado `staged`.

## Uso básico de git add
El uso más básico es agregar archivos o cambios específicos al área de preparación. Algunos ejemplos comunes son:

```bash
git add index.html
```
Este comando agrega los cambios en el archivo `index.html` al área de preparación.

* **Agregar múltiples archivos**: Puedes agregar varios archivos a la vez separándolos por espacio:

  ```bash
  git add index.html style.css script.js
  ```

* **Agregar todos los archivos cambiados en el directorio actual**: Para agregar todos los archivos modificados y nuevos al área de preparación, usa:

  ```bash
  git add .
  ```
  Esto agrega todos los cambios realizados en el directorio de trabajo actual, incluyendo subdirectorios.

* **Agregar un directorio completo**: Si quieres agregar todos los archivos dentro de un directorio:

  ```bash
  git add <directorio>
  ```
  **Ejemplo**
  ```bash
  git add src/
  ```
  Este comando agregará todos los archivos y subdirectorios dentro de `src/` al área de preparación.

## Tipos de cambios que `git add` puede manejar
Git rastrea tres tipos de cambios en los archivos:

1. **Archivos nuevos (`Untracked`)**: Cuando creas un archivo nuevo, Git no lo rastrea automáticamente. Necesitas decirle explícitamente a Git que comience a rastrearlo con git add. Ejemplo:

  ```bash
  touch nuevo_archivo.txt
  git add nuevo_archivo.txt
  ```
  Esto agregará el archivo nuevo al área de preparación, y ahora Git comenzará a rastrear los cambios en él.

2. **Archivos modificados**: Cuando modificas un archivo existente que Git ya está rastreando, el archivo pasa al estado de "modificado". Necesitas usar `git add` para mover esos cambios al área de preparación:

  ```bash
  git add archivo_modificado.txt
  ```

3. **Archivos eliminados**: Si has eliminado un archivo en tu directorio de trabajo, necesitas ejecutar `git add` para registrar la eliminación. Usa:

  ```bash
  git rm archivo_eliminado.txt
  git add archivo_eliminado.txt
  ```
  Alternativamente, `git rm` ya maneja el proceso de eliminación y preparación en un solo paso.

## Uso avanzado de `git add`
* **Agregar partes de un archivo (`Staging parcial`)**: Una característica poderosa de Git es la capacidad de preparar solo partes de un archivo en lugar de todo el archivo. Esto es útil si has hecho múltiples cambios en un archivo y solo quieres agregar algunos de ellos al área de preparación.

Para hacer esto, usa la opción **`-p` (patch)**:

```bash
git add -p <archivo>
```
Git te mostrará cada porción de cambios y te preguntará si quieres agregarla o no. Algunas opciones comunes durante este proceso son:

  * **`y` (yes)**: Agrega la parte mostrada al área de preparación.

  * **`n` (no)**: No la agrega.

  * **`s` (split)**: Divide la parte actual en partes más pequeñas.

  * **`q` (quit)**: Sal del modo interactivo.

* **Agregar archivos coincidentes por patrón**: Puedes usar comodines para agregar múltiples archivos que coincidan con un patrón. Ejemplo:

  ```bash
  git add *.html
  ```
  Esto agregará todos los archivos `.html` al área de preparación.