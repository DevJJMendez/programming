# `cp`
se utiliza para copiar archivos y directorios. Es una herramienta versátil que te permite duplicar archivos y estructuras de directorios dentro del sistema de archivos.

**ARGUMENTOS**
- **fuente**: El archivo o directorio que deseas copiar.

- **destino**: La ubicación donde deseas copiar el archivo o directorio / asignar nuevo nombre.

```bash
cp file.txt directorioDestino

# Cambia el nombre
cp file.txt nuevoFile.txt
```

**Opciones**
* `-a`, `--archive`: Copia archivos y directorios de manera recursiva, preservando atributos como permisos, propietarios, marcas de tiempo y enlaces simbólicos. Equivalente a `-dR --preserve=all`.

* `-f`, `--force`: Forza la copia de archivos y sobrescribe los archivos de destino existentes sin pedir confirmación.

* `-i`, `--interactive`: Solicita confirmación antes de sobrescribir un archivo existente en el destino.

* `-r`, `--recursive`: Copia directorios de manera recursiva. Es necesario cuando se copian directorios con contenido.

* `-u`, `--update`: Copia solo si la fuente es más reciente que el archivo de destino o si el archivo de destino no existe.

* `-v`, `--verbose`: Muestra un mensaje detallado por cada archivo o directorio que se copia. Es útil para verificar qué archivos se están copiando.

* `-p`, `--preserve`: Preserva los atributos del archivo, como la propiedad, los permisos y las marcas de tiempo.

* `-d`, `--no-dereference`: Preserva los enlaces simbólicos en lugar de copiar los archivos a los que apuntan.

* `--backup`: Realiza una copia de seguridad de cada archivo existente en el destino antes de copiar el nuevo archivo. Las copias de seguridad se nombran con un sufijo especial.

* `--parents`: Crea la estructura completa de directorios en el destino.

* `-l`, `--link`: Crea enlaces duros en lugar de copiar los archivos.

## Copiar Archivos y Directorios en Rutas Externas
Para copiar archivos a directorios que están fuera del directorio actual en Ubuntu, necesitas especificar la ruta completa del directorio de destino o utilizar rutas relativas adecuadas.

## Usando Rutas Absolutas
Una ruta absoluta es una ruta completa desde el directorio raíz (`/`) del sistema de archivos. Puedes usar rutas absolutas para especificar el directorio de destino, sin importar en qué directorio te encuentres.

### Ejemplo
Si estás en el directorio `/home/usuario/documentos` y deseas copiar un archivo llamado archivo.txt al directorio `/home/usuario/descargas`, usa la ruta absoluta del directorio de destino:

```bash
cp archivo.txt /home/usuario/descargas/
```

## Usando Rutas Relativas
Una ruta relativa es una ruta basada en el directorio actual. Puedes usar `..` para referirte al directorio padre y combinarlo con otros nombres de directorios para navegar fuera del directorio actual.

### Ejemplo:
Supongamos que estás en el directorio `/home/usuario/documentos` y deseas copiar un archivo a `/home/usuario/descargas`, que es un directorio hermano de documentos. Puedes usar la ruta relativa ../descargas para referirte al directorio descargas desde el directorio documentos:

```bash
cp archivo.txt ../descargas/
```