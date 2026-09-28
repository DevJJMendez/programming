# Alias
Un alias es una forma de crear un comando personalizado que se expande a un comando o una secuencia de comandos más largos. Los alias son particularmente útiles para abreviar comandos complejos o para establecer versiones personalizadas de comandos comunes. Esto puede ahorrar tiempo y hacer que tu experiencia en la terminal sea más eficiente.

## Creación de Alias Temporales
Para crear un alias temporal (que estará disponible solo en la sesión actual de la terminal), puedes usar el comando alias de la siguiente manera:

```bash
alias alias_name='comando'
```

**Ejemplos**
* Alias para un comando de navegación rápida:
```bash
alias ll='ls -la'
```
Aquí, `ll` ejecutará `ls -la`, mostrando un listado detallado de todos los archivos y directorios en el directorio actual.

* Alias para actualizar el sistema:
```bash
alias update='sudo apt update && sudo apt upgrade'
```
Este alias, update, ejecutará la actualización del sistema con un solo comando.

## Alias Permanentes
Para hacer un alias permanente (es decir, que persista entre sesiones), debes agregar el alias a un archivo de configuración de la shell. En Ubuntu, esto se suele hacer en el archivo `~/.bashrc` o `~/.bash_aliases` si usas `Bash`, o en ~/.`zshrc` si usas `Zsh`.

**Pasos para Crear Alias Permanentes:**
1. Abre el archivo de configuración de tu shell:
```bash
nano ~/.bashrc
```
o si prefieres, usa `~/.bash_aliases`:
```bsh
nano ~/.bash_aliases
```

2. Agrega tu alias al final del archivo:
```bash
alias alias_name='comando'
```

3. Guarda y cierra el archivo.

4. Aplica los cambios con:
```bash
source ~/.bashrc
```

## Eliminar Alias
Si necesitas eliminar un alias temporal durante la sesión actual, puedes usar el comando unalias:
```bash
unalias nombre_alias
```
Si deseas eliminar todos los alias temporales:
```bash
unalias -a
```

## Alias Avanzados
### Alias con Argumentos
Aunque los alias no permiten argumentos directamente, puedes usar una función en la shell para simular este comportamiento.
```bash
alias busca='grep -r --color=auto'
```
Aquí, puedes usar busca seguido de un argumento:
```bash
busca "texto" .
```

Sin embargo, para más flexibilidad, se pueden usar funciones en lugar de alias:
```bash
busca() {
  grep -r --color=auto "$1" "$2"
}
```
Con esta función, puedes usar:
```bash
busca "texto" .
```