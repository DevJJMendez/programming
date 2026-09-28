#  `touch` 
se utiliza principalmente para crear archivos vacíos o actualizar las marcas de tiempo de los archivos existentes. 
  
* **Argumentos**
  * `[archivo1] [archivo2] ...`: Especifica los nombres de los archivos que deseas crear o actualizar. Si los archivos no existen, touch los crea como archivos vacíos. Si los archivos ya existen, touch actualiza sus marcas de tiempo sin modificar su contenido.

```bash
touch nuevoArchivo.txt nuevoArchivo2.txt
```

---
**`touch -a`** Actualiza solo la marca de tiempo de acceso (`atime`) del archivo, sin modificar la marca de tiempo de modificación (`mtime`).


**`touch -c, --no-create`** No crea archivos nuevos. Si un archivo especificado no existe, `touch` no realiza ninguna acción.


**`touch -m`** Actualiza solo la marca de tiempo de modificación (mtime) del archivo, sin modificar la marca de tiempo de acceso (atime).


**`touch -d, --date=fecha_hora`** Especifica una fecha y hora específicas para establecer como marca de tiempo en lugar de la fecha y hora actual.


**`touch -r, --reference=archivo_referencia`** Utiliza el `archivo_referencia` como referencia para establecer las marcas de tiempo del archivo creado o actualizado. La marca de tiempo del archivo_referencia se copia al archivo especificado en lugar de la fecha y hora actual.

# `rm`
se utiliza para eliminar archivos o directorios del sistema de archivos. Es una herramienta poderosa pero peligrosa, ya que los archivos eliminados con rm no se envían a la papelera de reciclaje y se eliminan permanentemente del sistema.

**ARGUMENTOS**

- `[archivo1]` `[archivo2]` ...: Especifica los nombres de los archivos que deseas eliminar. Puedes proporcionar uno o más nombres de archivos separados por espacios.

**OPCIONES**

- `-f`, `--force`: Elimina los archivos sin pedir confirmación, incluso si el archivo es de solo lectura o si el usuario no tiene permisos para eliminarlo. Esta opción es útil para eliminar varios archivos a la vez sin confirmaciones intermedias.

- `-i`: Solicita confirmación antes de eliminar cada archivo. Puede ser útil para evitar la eliminación accidental de archivos importantes.

- `-r`, `-R`, `--recursive`: Elimina directorios y su contenido de forma recursiva. Esto significa que todos los archivos y subdirectorios dentro del directorio especificado también serán eliminados.

- `-d`: Permite eliminar directorios vacíos. **Por defecto**, `rm` no puede eliminar directorios si contienen archivos o subdirectorios.

- `--preserve-root`: Evita que `rm` elimine el directorio raíz (`/`) y sus subdirectorios, incluso si se proporcionan permisos de escritura.

# `mkdir`
se utiliza para crear directorios en el sistema de archivos. Es una herramienta simple pero esencial para organizar archivos y directorios. 

**ARGUMENTOS**
* `[directorio]`: Especifica el nombre del directorio que deseas crear. Puedes proporcionar uno o más nombres de directorios separados por espacios.
```bash
mkdir nuevoDirectorio otroDirectorio
```

**OPCIONES**
1. `-m`, `--mode=modo`: Establece los permisos del directorio nuevo en el modo especificado. El modo se especifica usando la notación octal (por ejemplo, **755** para permisos completos para el propietario y lectura/ejecución para otros).

2. `-p`, `--parents`: Crea directorios padre si no existen. Esto es útil cuando necesitas crear una estructura de directorios completa en una sola operación. Por ejemplo, `mkdir -p /ruta/a/directorio/nuevo` creará todos los directorios intermedios si no existen.
```bash
mkdir -p directorioPadre/directorioHijo/directorioDelHijo
```
Tambien podemos usar `{}` para crear multiples directorios dentro de un directorio padre
```bash
mkdri -p folder/{folder1,folder2,folder3}
```

3. `-v`, `--verbose`: Muestra un mensaje por cada directorio que se crea. Es útil para verificar qué directorios se están creando durante la operación.

# `rmdir`
se utiliza para eliminar directorios vacíos. Es una herramienta más específica que `rm`, ya que solo puede eliminar directorios si no contienen archivos o subdirectorios.

**ARGUMENTOS**
1. `[directorio]`: Especifica el nombre del directorio que deseas eliminar. Puedes proporcionar uno o más nombres de directorios separados por espacios.

**OPCIONES**
1. `-p`, `--parents`: Elimina un directorio y sus directorios padres si están vacíos. Esto permite eliminar una estructura de directorios vacíos en una sola operación. Por ejemplo, `rmdir -p /ruta/a/directorio/vacio` eliminará "directorio" y sus directorios padres si todos están vacíos.

2. `-v`, `--verbose`: Muestra un mensaje por cada directorio que se elimina. Es útil para verificar qué directorios se están eliminando durante la operación.