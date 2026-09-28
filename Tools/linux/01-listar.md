* **`ls`**: Se utiliza para listar el contenido de un directorio. Es una herramienta básica pero poderosa para explorar el sistema de archivos.

```bash
ls
# 00-linux.md  01-comandos.md  assets
```

* **`ls -a, --all`**: Muestra todos los archivos, incluidos los ocultos que comienzan con `.` (archivos ocultos).

```bash
ls -a

# 00-linux.md  01-comandos.md  assets  .git
```

* **`ls -l`**: Muestra una lista detallada que incluye permisos, número de enlaces, propietario, grupo, tamaño, fecha de modificación y nombre del archivo.

```bash
ls -l

# -rw-rw-r-- 1 usuario usuario 5841 may 12 11:01 00-linux.md
# -rw-rw-r-- 1 usuario usuario  606 may 12 11:11 01-comandos.md
# drwxrwxr-x 2 usuario usuario 4096 may 12 10:26 assets
```

* **`ls -h, --human-readable`**: Muestra tamaños de archivo en un formato legible para humanos (por ejemplo, "1K", "2M", "3G").

```bash
ls --human-readable

# 00-linux.md  01-comandos.md  assets
```

* **`ls -r, --reverse`**: Muestra los archivos en orden inverso.
```bash
ls -r

# assets  01-comandos.md  00-linux.md
```

* **`ls -S`**: Ordena los archivos por tamaño, de mayor a menor.

```bash
ls -S

# 00-linux.md  assets  01-comandos.md
```

* **`ls -t`**: Ordena los archivos por fecha y hora de modificación, de más reciente a más antiguo.

```bash
ls -t

# 01-comandos.md  00-linux.md  assets
```

* `ls -d, --directory`: Lista solo los directorios y no su contenido.

```bash
ls -d
```

* **`ls -i, --inode`**: Muestra el número de `nodo-i` (identificador único de archivo) de cada archivo.

```bash
ls -i

4075439 00-linux.md  4075449 01-comandos.md  4075467 assets
```

* **`ls -R, --recursive`**: Lista de manera recursiva el contenido de los subdirectorios.

```bash
ls -R

.:
00-linux.md  01-comandos.md  assets

./assets:
linux-arbol-directorios.jpg
```

* **`ls -F, --classify`**: Agrega un carácter al final de cada nombre de archivo para indicar el tipo de archivo (por ejemplo, "/" para directorios, "*" para archivos ejecutables).

```bash
ls -F
```