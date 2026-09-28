# Permisos
Los permisos en Linux son fundamentales para garantizar la seguridad y el control del acceso a archivos y directorios. Este modelo de permisos se basa en el propietario del archivo, el grupo al que pertenece y otros usuarios (todos los demás). 

## Estructura de los Permisos
Cada archivo o directorio tiene una estructura de permisos que puedes visualizar con el comando `ls -l`:

```bash
ls -l file.txt
```
**Salida**
```bash
-rw-r--r-- 1 usuario grupo 1024 Jan 22 10:00 file.txt
```
**Desglose:**
1. **`-rw-r--r--`**:
   * `-`: Tipo de archivo.
   
     * `-`: Archivo regular.
   
     * `d`: Directorio.

     * `l`: Enlace simbólico.

   * `rw-`: Permisos para el propietario (usuario).
     * `r`: Lectura (read).

     * `w`: Escritura (write).

     * `x`: Ejecución (execute).

   * `r-`-: Permisos para el grupo.

   * `r--`: Permisos para otros usuarios.

2. `1`: Número de enlaces duros al archivo.

3. `usuario`: Propietario del archivo.

4. `grupo`: Grupo al que pertenece el archivo.

5. `1024`: Tamaño del archivo en bytes.

6. `Jan 22 10:00`: Fecha y hora de última modificación.

7. `file.txt`: Nombre del archivo.

## Tipos de Permisos
* **Archivos**:
  * **`r` (read)**: Permite leer el contenido del archivo.

  * **`w` (write)**: Permite modificar el contenido del archivo.

  * **`x` (execute)**: Permite ejecutar el archivo si es un programa o script.

* **Directorios**:
  * **`r` (read)**: Permite listar los contenidos del directorio (con ls).

  * **`w` (write)**: Permite crear, eliminar o renombrar archivos en el directorio.

  * **`x` (execute)**: Permite entrar al directorio (navegar con cd).

# Comandos para gestionar permisos
## `chmod`
El comando **`chmod` (short for Change Mode)** en Linux se utiliza para modificar los permisos de archivos y directorios. Es una herramienta esencial para gestionar el acceso y la seguridad en un sistema.

**Sintaxis**
```bash
chmod [opciones] permisos archivo/directory
```
* `permisos`: Pueden especificarse en forma simbólica (letras) o numérica (octal).

* `archivo/directory`: Especifica el archivo o directorio cuyos permisos deseas cambiar.

# Modos de Permisos
## Modo Simbólico
En Linux, la representación simbólica de los permisos es una forma descriptiva de visualizar y modificar los permisos asociados a archivos y directorios. Estos permisos determinan quién puede leer, escribir o ejecutar un archivo o directorio.

## Estructura de Permisos Simbólicos
La representación simbólica se organiza en 10 caracteres en la salida del comando ls -l o al asignar permisos con chmod.

Ejemplo de salida de ls -l:
```bash
-rwxr-xr--
```
### Significado de los caracteres
1. Primer carácter: Indica el tipo de archivo:
   * - : Archivo regular.

   * d : Directorio.

   * l : Enlace simbólico.

   * b : Archivo de dispositivo de bloques.

   * c : Archivo de dispositivo de caracteres.

   * s : Socket.

   * p : Tubo (pipe) con nombre.

2. Siguientes 9 caracteres: Indican los permisos divididos en 3 grupos de 3 caracteres:
   * Usuario (Owner): Permisos del propietario del archivo.

   * Grupo (Group): Permisos para el grupo al que pertenece el archivo.

   * Otros (Others): Permisos para todos los demás usuarios.

3. Permisos básicos, Cada grupo contiene tres permisos básicos:
   * r: Lectura (Read).

   * w: Escritura (Write).

   * x: Ejecución (eXecute).

   * Si no hay un permiso, aparece -.

**Ejemplo**
```bash
-rwxr-xr--
```
* `rwx`: Usuario puede leer, escribir y ejecutar.

* `r-x`: Grupo puede leer y ejecutar.

* `r--`: Otros solo pueden leer.

### Modificar Permisos con Representación Simbólica
El comando chmod permite cambiar permisos simbólicos. La sintaxis básica es:
```bash
chmod [categoría][operador][permiso] archivo
```
Categorías
u: Usuario (propietario).
g: Grupo.
o: Otros.
a: Todos (usuario, grupo y otros).
Operadores
+: Añade un permiso.
-: Remueve un permiso.
=: Establece permisos exactos, eliminando los anteriores.

Ejemplo
1. Dar permisos de escritura al grupo:
```bash
chmod g+w archivo
```

2. Eliminar permisos de ejecución para otros:
```bash
chmod o-x archivo
```

3. Establecer permisos exactos:
```bash
chmod u=rwx,g=rx,o=r archivo
```
## Modo Numérico (Octal)
En Linux, los permisos de archivos y directorios pueden representarse tanto en forma simbólica (rwx) como en números octales. Los números octales son útiles para configurar permisos de manera rápida y precisa utilizando comandos como chmod.

### Estructura de Permisos
**División de Permisos**, Los permisos se dividen en tres categorías:
* Usuario (`u`): El propietario del archivo.

* Grupo (`g`): El grupo al que pertenece el archivo.

* Otros (`o`): Todos los demás usuarios.

**Cada categoría tiene tres tipos de permisos:**
* Lectura (`r`): Representado por el número **`4`**.

* Escritura (`w`): Representado por el número **`2`**.

* Ejecución (`x`): Representado por el número **`1`**.

**La combinación de estos números define los permisos para cada categoría.**

### Cálculo de los Permisos Octales
Para calcular el valor octal de los permisos en cada categoría, suma los valores correspondientes a los permisos habilitados:

| Permiso       | Valor Octal |
| ------------- | ----------- |
| Lectura (r)   | 4           |
| Escritura (w) | 2           |
| Ejecución (x) | 1           |

**Ejemplo**
* `rwx` **= 4 (lectura) + 2 (escritura) + 1 (ejecución) =** **`7`**

* `rw-` **= 4 (lectura) + 2 (escritura) =** **`6`**

* `r--` **= 4 (lectura) =** **`4`**

**Representación Completa**, La representación octal combina los valores para usuario, grupo y otros en un número de tres dígitos:
| Categoria | Permisos Simbólicos | Valor Octal |
| --------- | ------------------- | ----------- |
| Usuario   | rwx                 | 7           |
| Grupo     | r--                 | 4           |
| Otros     | ---                 | 0           |
Permisos finales: 740

**Ejemplos de Permisos Comunes**
| Representación Simbólica | Valor Octal | Descripción                                                  |
| ------------------------ | ----------- | ------------------------------------------------------------ |
| rwxrwxrwx                | 777         | Todos tienen permisos completos.                             |
| rw-r--r--                | 644         | Usuario: lectura/escritura, otros: solo lectura.             |
| rw-rw-r--                | 664         | Usuario/grupo: lectura/escritura, otros: solo lectura.       |
| rwx------                | 700         | Solo el usuario tiene permisos completos.                    |
| rwxr-xr-x                | 755         | Usuario: completo, grupo/otros: lectura/ejecución.           |
| rwxr-x---                | 750         | Usuario: completo, grupo: lectura/ejecución, otros: ninguno. |

## Uso de Permisos Octales con chmod
Puedes establecer permisos utilizando chmod con la representación octal:
```bash
chmod 755 archivo
```
Cambia los permisos de archivo a rwxr-xr-x.

Para aplicarlo a directorios y su contenido:
```bash
chmod -R 755 directorio
```
El modificador -R hace que el cambio sea recursivo (incluye todos los archivos y subdirectorios).