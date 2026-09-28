# Git Pull
Se utiliza para actualizar la rama actual con los cambios más recientes de una rama remota correspondiente. Este comando es una combinación de dos comandos: git fetch y git merge. Primero obtiene los cambios del repositorio remoto y luego los fusiona con la rama local.

## Sintaxis Básica

```bash
git pull [<opciones>] [<remoto> [<rama>]]
```
- `<remoto>`: El nombre del repositorio remoto (por defecto, suele ser origin).
- `<rama>`: El nombre de la rama que deseas fusionar en tu rama actual (por defecto, la rama actual del remoto).
  
## Comandos Relacionados

- `git fetch`
  - Este comando solo obtiene los cambios del repositorio remoto y los almacena en tus ramas de seguimiento remoto (remote tracking branches), sin fusionarlos.
    ```bash
    git fetch <remoto>
    ```
- `git merge`
  - Combina los cambios obtenidos por `git fetch` con la rama actual.
    ```bash
    git merge <remoto>/<rama>
    ```
## Opciones Comunes de `git pull`

- git pull:
  - El uso básico sin opciones específicas fusionará la rama actual con su contraparte remota.
    ```bash
    git pull
    ```
- `git pull <remoto> <rama>`
  - Especifica el remoto y la rama que deseas fusionar con tu rama actual.
    ```bash
    git pull origin main
    ```
- `git pull --rebase`
  - En lugar de realizar una fusión, aplica tus cambios locales sobre los cambios obtenidos del remoto, reescribiendo el historial de commits. Esto puede resultar en un historial más limpio.
    ```bash
    git pull --rebase
    ```
- `git pull --no-commit`
  - Obtiene y fusiona los cambios, pero no crea un commit de fusión automáticamente. Esto te permite revisar y ajustar los cambios antes de confirmar la fusión.
    ```bash
    git pull --no-commit
    ```
- `git pull --squash`
  - Fusiona los cambios del remoto en un solo commit en lugar de mantener todos los commits individuales del remoto.
    ```bash
    git pull --squash
    ```