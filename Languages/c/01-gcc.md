-o # GNU Compiler Collection
GCC (GNU Compiler Collection) es una herramienta fundamental en el desarrollo de software, especialmente en sistemas basados en Unix como Linux. Es un compilador muy utilizado para varios lenguajes de programación, incluido `C`, `C++`, `Objective-C`, `Fortran`, `Ada`, y otros.

## ¿Qué es GCC?
1. **Compilador multipropósito**: Originalmente, **GCC** fue creado para compilar programas escritos en el lenguaje `C`, pero con el tiempo se ha expandido para admitir otros lenguajes. Su principal función es traducir el código fuente escrito en un lenguaje de programación de alto nivel (como `C`) a código máquina ejecutable por el procesador.

2. **Parte del proyecto GNU**: GCC es un proyecto del sistema GNU y es software libre, lo que significa que cualquier persona puede usarlo, modificarlo y distribuirlo bajo los términos de la Licencia Pública General de GNU (GPL). Esto ha contribuido a su adopción masiva y a su mejora continua.

3. **Plataformas soportadas**: GCC está disponible en la mayoría de las plataformas y sistemas operativos, incluidas todas las distribuciones de Linux, macOS (a través de Xcode), y sistemas BSD, y puede generar código para varias arquitecturas de procesadores, lo que lo convierte en una herramienta muy versátil.

## ¿Qué hace GCC?
Cuando se utiliza GCC para compilar un programa en C, se sigue un proceso de varias etapas:

1. **Preprocesado**: El compilador procesa directivas del preprocesador (como #include y #define). El resultado es un archivo de código fuente con el preprocesamiento aplicado.

2. **Compilación**: GCC convierte el código fuente preprocesado en código ensamblador, que es un lenguaje de bajo nivel específico de la arquitectura del procesador.

3. **Ensamblaje**: El código ensamblador generado es convertido a código objeto (un formato binario intermedio) por el ensamblador. Esto aún no es un ejecutable completo.

4. **Enlazado**: Finalmente, GCC enlaza el código objeto con las bibliotecas estándar necesarias (como la biblioteca estándar de C libc) y otros archivos objeto que hayas generado para producir un archivo ejecutable.

## Ejemplos de comandos comunes en GCC
* Compilar un archivo simple:

```bash
gcc -o appMain main.c
```
Esto compila el archivo `main.c` y genera un ejecutable llamado `appMain`

* Compilar con depuración habilitada

```bash
gcc -g -o appMain main.c
```
La opción `-g` permite incluir información de depuración en el ejecutable, útil para herramientas como `gdb` (el depurador de GNU).

* Compilar con optimización
```bash
gcc -02 -o appMain main.c
```
Niveles de optimizació:
* `-O0`: No optimiza (por defecto).

* `-O1`: Optimización ligera.

* `-O2`: Optimización moderada (balance entre velocidad y tamaño del código).

* `-O3`: Optimización agresiva (aumenta el tamaño del código para mejorar el rendimiento).

* `-Os`: Optimización enfocada a reducir el tamaño del binario.


* Compilar varios archivos
```bash
gcc -o appMain main.c functions.c -Iinclude/
```
Esto compila varios archivos fuente (`main.c` y `funciones.c`) e incluye los archivos de cabecera de la carpeta `include/`.

* Diagnóstico y control de advertencias
```bash
gcc -Wall -o appMain main.c
```
Muestra un conjunto estándar de advertencias sobre posibles problemas en tu código.

* Mostrar todas la advertencias
```bash
gcc -Wextra appMain

gcc -Wall -Wextra -o appMain main.c
```

## Extensiones del archivo de salida
Cuando compilas un programa en C utilizando gcc, la extensión del archivo resultante depende del tipo de archivo que estás generando y el propósito del mismo.

1. **Archivo ejecutable**: Al compilar un programa para obtener un ejecutable, no es obligatorio usar una extensión. De hecho, en sistemas Unix/Linux, los archivos ejecutables normalmente no llevan extensión.
```bash
gcc -o compiledFile CFile.c
```
Esto genera un ejecutable llamado `compiledFile`. En Linux, los ejecutables no necesitan una extensión como en Windows (donde usan `.exe`). Sin embargo, a veces los usuarios añaden la extensión `.out` o algo similar para identificar más fácilmente el archivo como un ejecutable.

* **Sin extensión**: Se recomienda no utilizar extensión para ejecutables en Linux, como es la convención común en este sistema operativo.

* **Con `.out`**: Algunos usuarios prefieren agregar `.out` como convención, pero esto es opcional y solo para diferenciación visual.
```bash
gcc -o programa.out main.c

./programa.out
```

* Archivo objeto (`.o`)
Cuando generas archivos objeto, que son compilaciones parciales del código (sin ser ejecutables aún), se utiliza la extensión .o (de "object").
```bash
gcc -c CFile.c
```
Esto genera un archivo objeto llamado `CFile.o`. Los archivos objeto son intermediarios y se usan generalmente en proyectos más grandes, donde se compilan múltiples archivos `.c` por separado y luego se enlazan para formar el ejecutable final.

* Uso de `.o`: El archivo `.o` no es ejecutable por sí mismo. Se utiliza para enlazarlo con otros archivos objeto o con bibliotecas para generar un ejecutable completo.

**Ejemplo**
```bash
gcc -c funciones.c  # Genera funciones.o
gcc -c main.c       # Genera main.o
gcc -o programa main.o funciones.o
./programa
```