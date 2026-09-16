#fundamentals
# `git init`
El comando `git init` es uno de los comandos más fundamentales en Git. Se utiliza para inicializar un nuevo repositorio Git dentro de un directorio, lo que significa que transforma un directorio normal en un repositorio Git donde puedes rastrear cambios en archivos, realizar commits, y manejar la historia del proyecto.

Al ejecutarlo en un directorio, Git crea una subcarpeta oculta llamada `.git`, que contiene toda la información y metadatos necesarios para gestionar el historial de versiones del proyecto.

---
**Inicializar un repositorio nuevo**: Para comenzar un nuevo proyecto con Git, puedes navegar al directorio deseado y ejecutar:

```bash
git init
```

## La estructura del directorio .git
El directorio .git es el núcleo de cualquier repositorio de Git. Contiene varios subdirectorios y archivos que Git utiliza para gestionar el proyecto.

```plaintext
.git/
├── branches
├── config
├── description
├── HEAD
├── hooks/
├── info/
├── objects/
├── refs/
└── logs/
```
1. `branches/` (Obsoleto en versiones actuales de Git):

   * Este directorio solía almacenar referencias a las ramas locales, pero en versiones modernas de Git ya no se utiliza. Las ramas se almacenan en el directorio `refs/`.

2. `config`:

   * Este archivo contiene la configuración específica de este repositorio. Puede incluir configuraciones como el nombre de la rama por defecto o la URL de un repositorio remoto.
   
   * Ejemplo de configuración
    ```bash
    [core]
      repositoryformatversion = 0
      filemode = true
      bare = false
      logallrefupdates = true
    ```

3. `description`:

   * Solo es relevante para repositorios bare. Contiene una descripción del repositorio que puede mostrarse en interfaces como GitWeb.

4. `HEAD`:

   * Este archivo apunta a la rama activa o commit actual en el que estás trabajando.

   * Cuando estás en la rama main, el contenido de HEAD sería algo así:

    ```bash
    ref: refs/heads/main
    ```

5. `hooks/`:

   * Este directorio contiene scripts que se pueden ejecutar en ciertos eventos del ciclo de vida de Git (por ejemplo, antes de un commit o después de una fusión). Los hooks son útiles para automatizar tareas como ejecutar pruebas antes de permitir un commit.

   * Algunos ejemplos de hooks son: `pre-commit`, `pre-push`, `post-merge`.

6. `info/`:

   * Contiene información adicional como el archivo exclude, que permite definir patrones de archivos que no se deben rastrear (similar a .gitignore pero específico para este repositorio).

7. `objects/`:

   * Este es uno de los directorios más importantes de Git. Aquí se almacenan todos los objetos que representan los commits, árboles (directorios), blobs (contenido de los archivos), y etiquetas (tags). Git utiliza una base de datos de objetos para rastrear el historial de versiones de manera eficiente.

   * Ejemplo de estructura dentro de objects/:

    ```plaintext
    objects/
    ├── 4a/
    │   └── 7e989fadb18ee301f4ac91522e119b8c36d70b
    └── 8b/
        └── 3ef7a3d3e6a139f5b2526debbf6bda16ccbbd6
    ```

8. `refs/`:

   * Contiene referencias a ramas (`refs/heads/`), etiquetas (`refs/tags/`), y remotos (`refs/remotes/`). Estas referencias apuntan a commits específicos.

   * Ejemplo de archivos en refs/heads/

    ```plaintext
    refs/
    ├── heads/
    │   └── main  (Este archivo contiene el hash del commit más reciente en la rama "main")
    └── tags/
    ```

9. `logs/`:

   * Almacena un registro de las actualizaciones realizadas a las referencias (como HEAD o ramas). Esto permite a Git rastrear cómo se han movido las ramas a lo largo del tiempo.

   * Cada vez que cambias de rama o realizas un commit, Git actualiza estos logs. Esto es útil para recuperar cambios accidentales con comandos como git reflog.