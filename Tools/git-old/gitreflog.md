# `git reflog`
**`git reflog` (Reference Log)** es un comando que muestra un historial de todas las referencias de HEAD en tu repositorio. Es una herramienta clave para recuperar commits "perdidos", especialmente si usaste `git reset --hard` o hiciste un `checkout` accidental.

**Piensa en `git reflog` como el historial privado de los movimientos de `HEAD` en tu máquina local.**

## ¿Para qué sirve git reflog?
* **Recuperar commits eliminados con `git reset --hard`**
  * Si hiciste un `git reset --hard` y perdiste commits, `git reflog` te permite encontrarlos y restaurarlos.

* **Volver a una versión anterior del código**
  * Puedes moverte a cualquier estado anterior de `HEAD` sin preocuparte de haber perdido el commit.

* **Ver todos los movimientos de `HEAD`**
  * Muestra cada cambio de `branch`, cada `commit`, `merge`, `reset`, `revert` y más.

## Uso básico
Para ver el historial de referencias de `HEAD`:
```bash
git reflog
```
Ejemplo de salida:
```bash
a1b2c3d HEAD@{0}: commit: Fix login bug
e4f5g6h HEAD@{1}: reset: moving to HEAD~1
i7j8k9l HEAD@{2}: commit: Add new feature
m2n3o4p HEAD@{3}: checkout: moving from develop to main
```
Cada línea muestra un identificador de commit, una referencia de tiempo (HEAD@{n}) y una descripción de la acción.

## Cómo recuperar un commit perdido
Si hiciste un `git reset --hard` y perdiste commits, usa `git reflog` para encontrar el ID del commit perdido y restaurarlo:

1. **Encuentra el commit perdido en el `reflog`**
```bash
git reflog
```
Ejemplo de salida:
```bash
e4f5g6h HEAD@{1}: reset: moving to HEAD~1
```
Aquí, e4f5g6h es el commit perdido.

2. **Restaurarlo con `git reset`**
```bash
git reset --hard e4f5g6h
```
**Commit recuperado**

### Otras opciones útiles de `git reflog`
* **Moverse a un estado anterior sin perder historial**
```bash
git checkout HEAD@{3}
```
Esto mueve tu código a la versión exacta que tenía HEAD en ese momento.

* **Restaurar un estado anterior sin modificar el código actual**
```bash
git reset --soft HEAD@{2}
```
Esto mueve HEAD a un estado anterior, pero mantiene los cambios en staging.

### Borrar el reflog (Uso avanzado)
Si quieres limpiar el historial del reflog:
```bash
git reflog expire --expire=now --all
git gc --prune=now
```
Esto elimina definitivamente el historial de movimientos de HEAD. Úsalo con cuidado.