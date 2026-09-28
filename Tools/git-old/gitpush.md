# Git Push
Se utiliza para enviar cambios locales a un repositorio remoto. 

Es una operación fundamental para la colaboración en equipo y la gestión de proyectos distribuidos, ya que permite que los commits realizados en tu repositorio local se reflejen en el repositorio remoto.

## Conceptos Clave de `git push`
- **Repositorio Local** vs. **Remoto**:
  - El repositorio local es donde trabajas y haces cambios en tu máquina. El repositorio remoto es una copia del repositorio local que puede estar alojada en servicios como GitHub, GitLab, Bitbucket, entre otros.

- **Rama Remota**:
  - Una rama remota es una referencia a una rama en el repositorio remoto. Por convención, las ramas remotas se prefijan con el nombre del remoto, como `origin/main`.

## Sintaxis Básica
```bash
git push [opciones] [<remoto>] [<rama>]
```
- `<remoto>`: El nombre del repositorio remoto (por defecto, suele ser origin)
- `<rama>`: El nombre de la rama que deseas enviar al repositorio remoto (por defecto, la rama actual).

## Sintaxis
* Rama Remota
```bash
git push <remoto> <rama>
```
* Empuja (push) la rama actual al repositorio remoto predeterminado (origin), junto con sus objetos relacionados.
* Envía una rama específica al remoto especificado. Por ejemplo,`git push origin main` enviará la rama main al remoto `origin`.

```bash
git push -u <remoto> <rama>

git push --set-upstream <remoto> <rama>
```
* Establece una rama `upstream` para la rama actual. Esto vincula la rama local con la rama remota para que en futuros `git push` y `git pull`, Git sepa automáticamente de dónde obtener y a dónde enviar cambios.

```bash
git push --force
```
* Fuerza la actualización de la rama remota. Esto puede ser útil en casos donde necesitas sobrescribir el historial en la rama remota. Debe usarse con precaución, ya que puede sobrescribir y eliminar commits en el repositorio remoto.

```bash
git push --tags
```
* Envía todas las etiquetas (tags) locales al repositorio remoto. Las etiquetas son útiles para marcar versiones específicas en el historial del proyecto.

```bash
git push --delete <remoto> <rama>
```
* Elimina una rama en el repositorio remoto. Por ejemplo, `git push origin --delete feature-branch` eliminará la rama feature-branch en el remoto **origin**.

## Errores Comunes y Cómo Resolverlos
### `non-fast-forward Error`:
Este error ocurre cuando los cambios en el repositorio remoto están adelante de los cambios en tu repositorio local. Git no puede empujar los cambios porque no puede aplicar los commits sin perder commits en el remoto.

**Solución**: Primero haz un `git pull` para integrar los cambios del remoto en tu rama local. Luego, intenta hacer `git push` de nuevo.

```bash
git pull origin main
git push origin main
```

### **Autenticación Fallida**:
Ocurre cuando tus credenciales (nombre de usuario y contraseña o token de acceso) no son correctas o han caducado.

**Solución**: Verifica y actualiza tus credenciales. Si estás utilizando HTTPS, asegúrate de tener el token de acceso correcto. Para SSH, asegúrate de que tu llave SSH esté configurada y añadida a tu cuenta de Git.

### **Permisos Denegados**
Esto sucede cuando no tienes permisos para empujar cambios al repositorio remoto.

**Solución**: Asegúrate de que tienes los permisos correctos en el repositorio remoto. Si es un repositorio privado, es posible que necesites solicitar acceso al administrador del repositorio.
