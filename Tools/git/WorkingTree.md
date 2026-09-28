# Working Tree
Es literalmente la carpeta de tu proyecto tal como la ves en tu explorador de archivos. Pero Git no ve "archivos" a secas — cada archivo dentro del working tree cae en uno de estos estados:

```
Untracked   →  Git no lo conoce (nunca hiciste git add)
Tracked:
  ├─ Unmodified  →  igual al último commit
  ├─ Modified    →  cambiaste algo, no está en staging
  └─ Staged      →  ya hiciste git add
```

Git maneja los archivos en tres estados principales: **`untracked`**, **`staged`**, y **`committed`**, y además mantiene un flujo de trabajo a través de tres áreas importantes: 

* **working directory (directorio de trabajo)**
* **staging area (área de preparación o index)**
* **repository (repositorio o base de datos de objetos Git)**. 

**Estos estados y áreas forman el núcleo del sistema de control de versiones en Git.**

1. **`untracked`**: Son archivos o directorios que Git no está rastreando actualmente. Estos archivos no están en el historial de Git y no se incluirán en las confirmaciones a menos que se agreguen explícitamente.

2. **`staged`** **En el área de preparación (`staged` o Staging Area)**: Cuando se agrega un archivo al área de preparación utilizando el comando `git add`, pasa a este estado. Los archivos en el área de preparación están listos para ser confirmados en el repositorio en el próximo commit.

3. **`committed`** **Confirmado (`committed` o Committed State)**: Este estado se refiere a los archivos que ya han sido confirmados en el repositorio Git. Estos archivos están almacenados de forma segura en el historial de Git y representan el estado de los archivos en un punto específico en el tiempo.

4. **`modified`**: Cuando se realiza un cambio en un archivo que Git está rastreando, pero ese cambio aún no se ha agregado al área de preparación, el archivo se considera como modificado. Esto indica que el archivo ha sido editado desde la última confirmación, pero esos cambios aún no se han incluido en la próxima confirmación.

# `git status`
permite conocer el estado actual de tu proyecto. Proporciona un resumen detallado del estado de los archivos en tu directorio de trabajo y en el área de preparación (staging area), permitiéndote entender qué cambios se han hecho, cuáles están preparados para el commit, cuáles no están rastreados y si existen archivos en conflicto.

## Propósito de `git status`
El comando git status te proporciona una visión completa de:

* Archivos modificados en el directorio de trabajo.

* Archivos que han sido añadidos al área de preparación y están listos para ser confirmados.

* Archivos que Git no está rastreando (archivos nuevos no añadidos al control de versiones).

* El estado de tu rama actual.

* Notificaciones sobre commits pendientes, y otras advertencias útiles.

## Estructura básica de `git status`
```bash
git status
```
Cuando ejecutas `git status`, el resultado típico tiene varias secciones:
```bash
On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   archivo_preparado.txt

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   archivo_modificado.txt

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        archivo_nuevo.txt
```
### On branch main
* La primera línea indica en qué rama estás trabajando: `On branch main`.

* Además, te informa si tu rama está actualizada con respecto a la rama remota (`origin/main`), si estás adelantado o si hay commits pendientes que necesitas hacer un `pull` o `push`.

### Changes to be committed
* **Cambios para ser confirmados (`Staged`)**

   * La sección `Changes to be committed` muestra los archivos que están en el área de preparación. Estos archivos serán incluidos en el próximo `commit`.

   * En este ejemplo, el archivo `archivo_preparado.txt` ha sido modificado y está en el área de preparación, listo para ser confirmado.

   * Git te sugiere que, si quieres quitarlo del área de preparación, uses `git restore --staged <file>`.

### Unstaged
**Cambios no preparados para el commit (`Unstaged`)**

   * La sección `Changes not staged for commit` muestra archivos que han sido modificados en el directorio de trabajo, pero que aún no han sido añadidos al área de preparación.

   * En el ejemplo, `archivo_modificado.txt` ha sido modificado, pero no está en el área de preparación. Para añadirlo, puedes usar `git add archivo_modificado.txt`, o puedes restaurarlo a su estado original con `git restore <file>` si no quieres mantener los cambios.

### Untracked
* **Archivos no rastreados (`Untracked`)**

  * La sección `Untracked files` lista los archivos que están presentes en tu directorio de trabajo, pero que Git no está rastreando todavía. Estos archivos son nuevos y nunca se han añadido al control de versiones.

  * En este caso, `archivo_nuevo.txt` es un archivo que Git no está rastreando. Para incluirlo en el control de versiones, debes ejecutar `git add archivo_nuevo.txt`.

# Opciones útiles del comando `git status`
* `git status -s (short status)`: La opción `-s` muestra un resumen más compacto del estado. Esto es útil cuando deseas un vistazo rápido a los cambios sin tanto detalle. La salida usa símbolos para representar el estado de los archivos.

  ```
  git status -s
  ```
  Salida típica:
  ```plaintext
  M  archivo_preparado.txt
   M archivo_modificado.txt
  ?? archivo_nuevo.txt
  ```
  * `M` antes de un archivo indica que ha sido modificado.

  * Un espacio vacío a la izquierda significa que el archivo no ha sido añadido al área de preparación (`staged`).

  * `??` indica que el archivo es untracked (no rastreado).

* `git status --ignored`: Este comando muestra también los archivos que han sido ignorados mediante reglas definidas en el archivo `.gitignore`. Es útil cuando quieres verificar si Git está ignorando correctamente ciertos archivos.

* `git status --branch`: Esta opción muestra el estado de todas las ramas locales. Te permite ver qué ramas locales tienes, cuál es la rama actual y si está sincronizada con el repositorio remoto.