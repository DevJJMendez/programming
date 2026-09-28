# `git revert`
`git revert` es un comando que te permite **deshacer un commit creando uno nuevo** que revierte los cambios del commit original. A diferencia de `git reset`, no elimina el historial ni mueve **`HEAD`** a un commit anterior, lo que lo hace más seguro para proyectos colaborativos.

**Diferencias entre `git revert` y `git reset`**
| Comando      | Descripción                                                              | ¿Elimina historial? | ¿Modifica commits existentes? |
| ------------ | ------------------------------------------------------------------------ | ------------------- | ----------------------------- |
| `git reset`  | Mueve **`HEAD`** a un commit anterior, eliminando commits si es `--hard` | Sí (en `--hard`)    | Si                            |
| `git revert` | Crea un nuevo commit que deshace los cambios del commit original         | No                  | No                            |

## Uso Básico
*  **Revertir un commit específico**. Si quieres revertir el último commit:
```bash
git revert HEAD
```
Esto creará un nuevo commit que deshace los cambios del commit **`HEAD`**.

* Si quieres revertir un commit anterior sin afectar los demás:
```bash
git revert <commit_id>
```
Ejemplo: Si tienes este historial:
```bash
a1b2c3d (HEAD -> main)  <-- Último commit (error)
e4f5g6h  <-- Funcionalidad correcta
i7j8k9l  <-- Otro commit correcto
```
Si ejecutas:
```bash
git revert a1b2c3d
```
Git creará un nuevo commit que revierte a1b2c3d, pero sin borrar el historial.

### Opciones de `git revert`
1. **Revertir sin abrir el editor de mensajes**. Si no quieres que se abra un editor para escribir un mensaje de commit, usa la opción `--no-edit`:
```bash
git revert HEAD --no-edit
```
Así, Git usará un mensaje por defecto.

2. Revertir múltiples commits. Si necesitas revertir varios commits seguidos, puedes usar:
```bash
git revert HEAD~3..HEAD
```
Esto revierte los últimos 3 commits (de **`HEAD~3`** hasta **`HEAD`**).

**También puedes revertir múltiples commits sin confirmarlos de inmediato:**
```bash
git revert --no-commit HEAD~3..HEAD
```
Esto deja los cambios en staging, y puedes revisarlos antes de confirmar con `git commit`.

### Precauciones al usar git revert
* Si un commit a revertir contiene cambios muy grandes o conflictos, Git pedirá que los resuelvas manualmente antes de hacer el commit de reversión.
* `git revert` no elimina el commit original, solo crea un commit opuesto.
* Si quieres deshacer un git revert, puedes hacer otro git revert sobre el commit de reversión.