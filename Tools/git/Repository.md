# Repositorio
Un repositorio Git es, fundamentalmente, una carpeta de proyecto que incluye un directorio oculto llamado `.git`; este directorio es lo que transforma una carpeta normal en un repositorio, ya que almacena todo el historial de cambios, configuraciones y metadatos necesarios para el control de versiones.

**Características principales**:
* **Historial completo**: A diferencia de otros sistemas que solo guardan diferencias, Git guarda versiones completas y eficientes de los archivos, permitiendo revisar cualquier punto en el tiempo. ￼

* **Independencia**: Cada repositorio es autónomo; eliminar la carpeta `.git` significa perder todo el historial de cambios del proyecto.

**Tipos de repositorio**:
* **Local**: Vive en tu computadora y funciona sin conexión a internet; se crea con `git init` o se obtiene con `git clone`.

* **Remoto**: Se aloja en un servidor (como GitHub, GitLab o Bitbucket) para permitir la colaboración, el respaldo y el acceso compartido.

Es crucial distinguir que Git es el programa de control de versiones, el repositorio es el espacio que contiene el proyecto y su historial, y GitHub es la plataforma en la nube donde se puede alojar dicho repositorio para compartirlo.

---
# Repositorios remotos
Los repositorios remotos en Git son versiones de tu proyecto que están alojadas en servidores de internet o en una red local. Pueden ser utilizados por múltiples usuarios para colaborar en el mismo proyecto. Los repositorios remotos son fundamentales para la colaboración en equipo y para tener una copia de seguridad del código en un lugar seguro.

## Conceptos Clave

- **Origen Remoto** (`origin`):
  - Por convención, **origin** es el nombre del repositorio remoto predeterminado que se configura al clonar un repositorio. Es el alias comúnmente utilizado para referirse a la URL del repositorio remoto desde el que se clonó el repositorio local.
- **URLs Remotas**:
  - Los repositorios remotos se identifican mediante URLs. Estas pueden ser en formato HTTP(s), SSH, o GIT.
    - **HTTP(s)**: `https://github.com/usuario/repo.git`
    - **SSH**: `git@github.com:usuario/repo.git`
    - **GIT**: `git://github.com/usuario/repo.git`

## Comandos Básicos para Gestionar Repositorios Remotos

- `git remote`
  - Muestra una lista de los remotos configurados.
    ```bash
    git remote
    ```
- `git remote -v`
  - Muestra las URLs asociadas a los remotos configurados.
    ```bash
    git remote -v
    ```
- `git remote add <nombre> <url>`
  - Añade un nuevo repositorio remoto con el nombre dado y la URL especificada.
    ```bash
    git remote add upstream https://github.com/otro-usuario/repo.git
    ```
- `git remote remove <nombre>`
  - Elimina un repositorio remoto.
    ```bash
    git remote remove upstream
    ```
- `git remote rename <viejo_nombre> <nuevo_nombre>`
  - Renombra un remoto existente.
  ```bash
  git remote rename origin upstream
  ```

## Operaciones Comunes con Repositorios Remotos

- **Clonar un Repositorio**:
  - Crea una copia local del repositorio remoto.
    ```bash
    git clone https://github.com/usuario/repo.git
    ```
- **Traer Cambios del Remoto** (Fetch):
  - Obtiene los cambios de las ramas del repositorio remoto sin fusionarlos en la rama actual.
    ```java
    git fetch origin
    ```
- **Fusionar Cambios del Remoto** (`Pull`):
  - Combina `git fetch` y `git merge` en un solo paso. Obtiene los cambios del remoto y los fusiona en la rama actual.
    ```bash
    git pull origin main
    ```
- **Enviar Cambios al Remoto** (`Push`):
  - Envía los commits de la rama local al repositorio remoto.
    ```bash
    git push origin main
    ```
- **Ver Ramas Remotas**:
  - Muestra una lista de las ramas en el repositorio remoto.
    ```bash
    git branch -r
    ```

---
# Repositorio Bare
Un repositorio bare en Git es una versión especial del repositorio que no contiene un directorio de trabajo (**working tree**), lo que significa que no tiene los archivos fuente del proyecto visibles ni editables directamente. En su lugar, solo almacena los datos internos de control de versiones (como las carpetas `objects`, `refs`, `HEAD` y `config`) en el nivel raíz del directorio, en lugar de dentro de una subcarpeta `.git` oculta.

**Características principales**:
* **Uso centralizado**: Está diseñado específicamente para actuar como un repositorio remoto central donde múltiples desarrolladores pueden hacer push de sus cambios y clonar el proyecto. ￼

* **Sin edición directa**: No es posible realizar commits o editar archivos dentro de un repositorio bare, ya que carece de la copia de trabajo necesaria para estas operaciones. ￼

* **Prevención de conflictos**: Al eliminar el directorio de trabajo, se evita que los cambios realizados directamente en el servidor causen inconsistencias o conflictos con el índice de Git. ￼

* **Estructura plana**: Los metadatos de Git que normalmente viven en `.git` aparecen en el nivel superior del directorio del repositorio. 

Los repositorios bare son el estándar utilizado por plataformas de alojamiento como GitHub, GitLab y Bitbucket, así como para servidores Git autoalojados.

Para crearlos, se utiliza el comando `git init --bare`, y para clonarlos, se usa `git clone`. 

Los desarrolladores trabajan localmente en repositorios **no bare** (con directorio de trabajo) y sincronizan sus cambios con el repositorio bare remoto mediante `git push` y `git pull`.