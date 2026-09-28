# `git rebase`
El comando git rebase es una poderosa herramienta en Git que te permite reorganizar, mover o reescribir la historia de tus commits.

A diferencia de `git merge`, que une dos ramas y crea un **commit de merge** para conectar sus historias, `git rebase` reorganiza los commits para aplicar los cambios de una rama encima de otra. Esto mantiene el historial de commits lineal y más limpio.

##  ¿Cómo funciona git rebase?
Cuando haces un rebase, Git:

1. Toma los commits de la rama actual (que no están en la base de la nueva rama destino).

2. Los aplica uno por uno sobre la nueva base.

3. Reescribe el historial para que parezca que estos commits ocurrieron después de los últimos de la rama destino.

La idea es que, en lugar de tener un historial que muestra múltiples ramas y merges (que puede ser confuso), el historial sea lineal y fácil de seguir. Esto es particularmente útil para proyectos colaborativos donde es importante mantener un historial claro.

## Ejemplo básico de git rebase
Imagina que tienes dos ramas:

* **`main`**: la rama principal.

* **`feature`**: una rama donde has estado trabajando en una nueva característica.

El historial actual se ve así:
```plaintext
A --- B --- C (main)
       \
        D --- E --- F (feature)
```
Si usas git merge, obtendrás algo así:
```plaintext
A --- B --- C --- M (main)
       \        /
        D --- E --- F (feature)
```
En cambio, si usas git rebase, puedes reorganizar el historial para que sea lineal:
```bash
# Cambia a tu rama de feature
git checkout feature
# Rebasea tu rama feature sobre la última versión de main
git rebase main
```
El resultado será:
```plaintext
A --- B --- C --- D --- E --- F (feature)
```

## Tipos de git rebase
1. **Rebase simple**: Este es el ejemplo más común de `git rebase`. Cuando haces un rebase simple, Git toma los commits de la rama actual y los reaplica encima de la rama base que especifiques.
```bash
git checkout feature
git rebase main
```
Esto aplicará los commits de feature encima de la última versión de `main`.

2. **Rebase interactivo (`git rebase -i`)**: El rebase interactivo te permite manipular los commits antes de aplicar el rebase. Puedes:

* Reordenar commits.

* Combinar (squash) commits en uno solo.

* Eliminar commits que no quieras.

* Editar commits (cambiar el mensaje o el contenido).

Para iniciar un rebase interactivo:
```bash
git rebase -i HEAD~3
```
Esto abrirá un editor de texto con los últimos 3 commits, donde puedes decidir cómo deseas manipularlos.

Ejemplo de lo que verás:
```plaintext
pick 1234567 Añadir funcionalidad X
pick 89abcde Corregir errores menores
pick fedcba9 Mejorar la documentación
```
Comandos que puedes usar:

* **`pick`**: mantener el commit como está.

* **`reword`**: cambiar el mensaje del commit.

* **`edit`**: modificar el contenido del commit.

* **`squash`**: combinar este commit con el anterior.

* **`drop`**: eliminar el commit.

## Evitando problemas al usar git rebase
1. Rebase solo commits que no hayas compartido: Si estás trabajando en tu propia rama de feature, puedes reescribir el historial sin problemas. Pero si has compartido tu rama con otros, usar git rebase puede causar problemas porque reescribe la historia. En esos casos, git merge es más seguro.

2. Resolviendo conflictos durante el rebase: Si hay conflictos, Git pausará el proceso de rebase y te pedirá que los resuelvas. Después de resolver el conflicto en cada archivo, usa:
```bash
git add <archivo>
```
Luego, continúa el proceso de rebase con:
```bash
git rebase --continue
```
Si deseas cancelar el rebase en cualquier momento, puedes usar:
```bash
git rebase --abort
```