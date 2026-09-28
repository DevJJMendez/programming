# `cat`
El comando `cat` en Ubuntu (y en otros sistemas Unix/Linux) se utiliza para concatenar y mostrar el contenido de archivos. Es una herramienta simple pero versátil, a menudo utilizada para visualizar archivos de texto y combinar múltiples archivos. 

**Argumentos**
* `[archivo1] [archivo2] ...`: Especifica los nombres de los archivos cuyos contenidos deseas mostrar o concatenar. Puedes proporcionar uno o más nombres de archivos separados por espacios.

**Opciones**
1. `-A`, `--show-all`: Muestra caracteres no imprimibles en formato de control y finales de línea. Es una combinación de las opciones `-v`, `-E` y `-T`.

2. `-b`, `--number-nonblank`: Numera solo las líneas no en blanco en el archivo.

3. `-e`: Muestra el final de cada línea con el símbolo $ y utiliza -v para mostrar caracteres no imprimibles.

4. `-E`, `--show-ends`: Muestra el símbolo $ al final de cada línea para indicar el final de la línea.

5. `-n`, `--number`: Numera todas las líneas del archivo, incluidas las líneas en blanco.

6. `-s`, `--squeeze-blank`: Suprime las líneas en blanco repetidas, mostrando solo una línea en blanco en lugar de múltiples líneas en blanco consecutivas.

7. `-T`, `--show-tabs`: Muestra los caracteres de tabulación (TAB) como ^I.

8. `-v`, `--show-nonprinting`: Muestra caracteres no imprimibles, excepto los caracteres de espacio y tabulación, como secuencias ^ y M-.

## Ejemplos de Uso:
1. Mostrar el contenido de un archivo:
```bash
cat archivo.txt
```
Muestra el contenido del archivo "archivo.txt" en la terminal.

2. Concatenar y mostrar el contenido de varios archivos
```bash
cat archivo1.txt archivo2.txt
```
Muestra el contenido de "archivo1.txt" seguido por el contenido de "archivo2.txt".

3. Guardar el contenido de varios archivos en nuevo archivo
```bash
cat archivo1.txt archivo2.txt > archivo_combined.txt
```
Combina el contenido de "archivo1.txt" y "archivo2.txt" y lo guarda en "archivo_combined.txt".

4. Numera todas las líneas del archivo:
```bash
cat -n archivo.txt
```
Muestra el contenido de "archivo.txt" con todas las líneas numeradas.

5. Mostrar el final de cada línea:
```bash
cat -E archivo.txt
```
Muestra el contenido de "archivo.txt" con el símbolo $ al final de cada línea.

6. Suprimir líneas en blanco repetidas:
```bash
cat -s archivo.txt
```
Muestra el contenido de "archivo.txt" suprimiendo las líneas en blanco repetidas.

7. Mostrar caracteres no imprimibles:
```bash
cat -v archivo.txt
```
Muestra el contenido de "archivo.txt" con caracteres no imprimibles representados por secuencias ^ y M-.

## Consideraciones
* El comando cat es útil para visualizar archivos y combinar contenido, pero no está diseñado para editar archivos.

* La combinación de opciones te permite personalizar la visualización de contenido según tus necesidades.

# `less`
Es una herramienta utilizada para visualizar el contenido de archivos de texto de manera paginada. A diferencia de `cat`, que muestra todo el contenido de un archivo de una vez, `less` permite navegar por el archivo hacia adelante y hacia atrás, lo que es útil para archivos largos. Es especialmente útil para leer archivos de **`log`**, **`scripts`** o cualquier archivo de texto grande.

## Características Principales de less
* **Paginación**: less carga el archivo por partes, permitiéndote moverte por el archivo sin cargarlo todo en la memoria.

* **Búsqueda**: Permite buscar texto dentro del archivo.

* **Interactividad**: Ofrece comandos interactivos para navegar y manipular la visualización del archivo.

### Uso Básico
```bash
less archivo.txt
```
Esto abrirá archivo.txt en modo de paginación. Podrás desplazarte usando las teclas de flecha, **Page Up**, **Page Down**, **Home**, **End**, o los comandos interactivos que se describen a continuación.

## Comandos y Opciones de Navegación
Una vez dentro de less, puedes usar varios comandos para navegar por el archivo:

* `q`: Salir de less.

* `f` o **Ctrl+F**: Avanza una pantalla hacia adelante.

* `b` o **Ctrl+B**: Retrocede una pantalla hacia atrás.

* `/texto`: Busca hacia adelante en el archivo la palabra o cadena de texto "texto".

* `?texto`: Busca hacia atrás en el archivo la palabra o cadena de texto "texto".

* `n`: Repite la última búsqueda en la misma dirección.

* `N`: Repite la última búsqueda en la dirección opuesta.

* `g`: Va al principio del archivo.

* `G`: Va al final del archivo.

* `h`: Muestra la ayuda de less.

## Opciones de Línea de Comando
Cuando inicias less, puedes usar varias opciones para personalizar su comportamiento:

`-N, --LINE-NUMBERS`: Muestra los números de línea junto a cada línea.
```bash
less -N archivo.txt
```

`-S, --chop-long-lines`: Corta las líneas largas en lugar de envolverlas. Esto muestra las líneas largas en una sola línea sin que se desborden a la siguiente.
```bash
less -S archivo.txt
```

`-X, --no-init`: No borra la pantalla al salir de less, lo que deja el contenido del archivo visible en la terminal.
```bash
less -X archivo.txt
```

`-i, --ignore-case`: Ignora la distinción entre mayúsculas y minúsculas en las búsquedas.
```bash
less -i archivo.txt
```

`-p, --pattern=patrón`: Abre el archivo en la primera coincidencia del patrón de búsqueda.
```bash
less -p "Error" archivo.txt
```

`-r, --RAW-CONTROL-CHARS`: Interpreta los caracteres de control y muestra el formato de texto adecuado.
```bash
less -r archivo_con_colores.txt
```

### Consideraciones
* `less` es ideal para leer archivos grandes porque no carga todo el archivo en memoria, a diferencia de `cat`.

* Puedes combinar less con otros comandos usando pipes, por ejemplo, dmesg | less para ver el mensaje del kernel paginado.

# `nano`
Es un editor de texto de línea de comandos que es simple y fácil de usar. Es una opción excelente para realizar ediciones rápidas en archivos de texto desde la terminal.

## Características Principales de nano
* **Simplicidad**: nano está diseñado para ser intuitivo, con una curva de aprendizaje suave, ideal para usuarios que no están familiarizados con editores más complejos como vi o vim.

* **Interfaz Amigable**: Los comandos básicos se muestran en la parte inferior de la pantalla, lo que facilita su uso sin necesidad de memorizar atajos de teclado.

* **Soporte para Coloreado de Sintaxis**: Aunque es básico, nano ofrece resaltado de sintaxis para varios lenguajes de programación y archivos de configuración.

## Uso Básico
Para abrir un archivo con nano:
```bash
nano nombre_del_archivo.txt
```
Si el archivo no existe, nano lo creará al guardarlo.

## Comandos Básicos Dentro de nano
Aquí hay algunos de los comandos más comunes que puedes usar dentro de nano. La tecla **Ctrl** se representa como `^`:

* `Ctrl + O`: Guarda el archivo (también conocido como "Write Out").

* `Ctrl + X`: Cierra nano. Si has realizado cambios sin guardar, se te pedirá confirmación antes de salir.

* `Ctrl + W`: Busca una cadena de texto dentro del archivo.

* `Ctrl + K`: Corta la línea actual y la guarda en un "portapapeles" interno.

* `Ctrl + U`: Pega la línea cortada anteriormente.

* `Ctrl + G`: Muestra la ayuda de nano.

* `Ctrl + C`: Muestra la posición actual del cursor en el archivo (número de línea, columna).

* `Ctrl + R`: Inserta otro archivo en el archivo que estás editando.

* `Ctrl + T`: Invoca el corrector ortográfico (si está configurado y disponible).

* `Ctrl + _`: Permite ir a una línea específica del archivo.

## Opciones Comunes de nano al Invocarlo
Cuando inicias `nano` desde la terminal, puedes usar varias opciones para personalizar su comportamiento:

`-B, --backup`: Crea una copia de seguridad del archivo antes de editarlo. La copia de seguridad tendrá el mismo nombre que el archivo original, pero con un tilde (`~`) añadido al final.
```bash
nano -B nombre_del_archivo.txt
```

`-C, --backupdir=DIR`: Guarda los archivos de respaldo en el directorio especificado.
```bash
nano -C /ruta/a/respaldo nombre_del_archivo.txt
```

`-m, --mouse`: Habilita el soporte para el uso del ratón.
```bash
nano -m nombre_del_archivo.txt
```

`i, --autoindent`: Habilita la indentación automática, lo que es útil para escribir código.
```bash
nano -i script.sh
```

`-l, --linenumbers`: Muestra los números de línea en el editor.
```bash
nano -l nombre_del_archivo.txt
```

`-R, --readonly`: Abre el archivo en modo de solo lectura.
```bash
nano -R nombre_del_archivo.txt
```

`-S, --smooth`: Habilita el desplazamiento suave, lo que mejora la experiencia de navegación por el archivo.
```bash
nano -S nombre_del_archivo.txt
```

`-Y, --syntax=nombre`: Establece el resaltado de sintaxis para un lenguaje específico.
```bash
nano -Y python script.py
```