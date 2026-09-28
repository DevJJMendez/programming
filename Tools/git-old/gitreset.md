# `git reset`
El comando **`git reset`** es una de las herramientas más poderosas y, a veces, peligrosas en Git, ya que te permite **manipular el historial de commits y modificar el área de preparación** (**`staging area`**) y el directorio de trabajo. 

**Este comando se utiliza para deshacer cambios en `commits`, **branchs** o para modificar el área de preparación.**

Dependiendo de las opciones que uses, `git reset` puede afectar tu directorio de trabajo, el área de preparación y el historial de commits.

##  ¿Qué hace git reset?
El comando `git reset` mueve el puntero **HEAD** a un commit específico, permitiéndote deshacer commits recientes.

## Tipos de Reset en Git
El comando git reset tiene tres modos principales, que afectan diferentes partes del flujo de trabajo:
| Modo                  | HEAD (Historial) | Staging (Index) | Working Directory |
| --------------------- | ---------------- | --------------- | ----------------- |
| --soft                | Se mueve         | No cambia       | No cambia         |
| --mixed (Por defecto) | Se mueve         | Se borra        | No cambia         |
| --hard                | Se mueve         | Se borra        | Se borra          |

### `git reset --soft HEAD~1`
Deshacer el último commit (sin perder cambios)

Si hiciste un commit pero quieres modificarlo, usa `--soft`.
```bash
git reset --soft HEAD~1
```
* El commit desaparece del historial, pero los archivos siguen en staging.
* Luego puedes hacer un nuevo git commit con las correcciones.

### `git reset --mixed HEAD~1`
Deshacer el último commit y sacar los archivos de staging

Si quieres deshacer el último commit y sacar los archivos del área de staging, usa `--mixed`:
```bash
git reset --mixed HEAD~1
```
* El commit desaparece del historial.
* Los archivos no se pierden, pero vuelven a ser archivos modificados sin añadir.
* Ahora puedes revisarlos con `git status` y hacer `git add` nuevamente si es necesario.

### `git reset --hard HEAD~1`
Eliminar commit y borrar cambios

Este es el más peligroso: elimina el commit y borra los cambios de staging y el working directory.
```bash
git reset --hard HEAD~1
```
* ¡Cuidado! Se pierde todo lo que estaba en el commit y en el directorio de trabajo.
* Úsalo solo si estás 100% seguro de que no necesitas los cambios.

## Resetear a un commit específico
Si quieres volver a un commit anterior, usa el ID del commit:
```bash
git reset --soft <commit_id>
```
```bash
git reset --hard <commit_id>
```
* `--soft` mantiene los cambios en staging.
* `--hard` borra todo y deja el código exactamente como en ese commit.

## Casos Especiales
Resetear archivos individuales (sin afectar otros cambios)

Si solo quieres sacar un archivo de staging sin modificar el commit:
```bash
git reset <archivo>
```
El archivo vuelve a estar como "modificado" sin estar en staging.

## ¿Cómo recuperar un commit eliminado con `git reset --hard`?
Si eliminaste un commit por error, revisa el reflog para ver su ID:
```bash
git reflog
```
Luego puedes restaurarlo con:
```bash
git reset --hard <commit_id>
```
**`git reflog` es tu salvavidas en Git.**

---
[[gitreflog]](gitreflog.md)