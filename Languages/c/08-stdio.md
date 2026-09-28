## Standart Input and Output
La librería `<stdio.h>` en C es una de las más utilizadas, ya que proporciona funciones de entrada y salida estándar, permitiendo a los programas interactuar con el sistema mediante operaciones como leer y escribir datos desde y hacia la consola, archivos, y otros dispositivos de E/S.

### Funcionalidades Principales de `<stdio.h>`
Esta librería maneja principalmente operaciones de entrada y salida a través de las siguientes funciones y macros:

1. Operaciones de entrada y salida en la consola:
   
   * `printf()`: Imprime texto en la consola.
   * `scanf()`: Lee la entrada de la consola.
   * `puts()`: Imprime una cadena en la consola con un salto de línea al final.
   * `gets()`: Lee una línea de texto de la consola (ya no es recomendable por problemas de seguridad).
   * `putchar()`: Imprime un carácter en la consola.
   * `getchar()`: Lee un carácter de la consola.

2. Operaciones con archivos:

   * `fopen()`: Abre un archivo.
   * `fclose()`: Cierra un archivo.
   * `fread()`: Lee un bloque de datos de un archivo.
   * `fwrite()`: Escribe un bloque de datos en un archivo.
   * `fgetc()`: Lee un carácter de un archivo.
   * `fputc()`: Escribe un carácter en un archivo.
   * `fprintf()`: Imprime datos en un archivo (similar a `printf()` pero para archivos).
   * `fscanf()`: Lee datos de un archivo (similar a `scanf()` pero para archivos).
   * `feof()`: Verifica si se ha llegado al final del archivo.
   * `fseek()`: Establece la posición del cursor en un archivo.
   * `ftell()`: Devuelve la posición actual del cursor en un archivo.
   * `rewind()`: Restablece el cursor de archivo al principio del archivo.

3. Errores y Manejo de Buffer:

   * `perror()`: Imprime un mensaje de error basado en el último error de la biblioteca C.
   * `fflush()`: Fuerza el vaciado del buffer de salida.
   * `setbuf()` y `setvbuf()`: Controlan el comportamiento del buffer de archivos.

### Modos de Apertura de Archivos
* **"`r`"**: Abre el archivo en modo lectura.
* **"`w`"**: Abre el archivo en modo escritura, sobrescribiendo el contenido existente.
* **"`a`"**: Abre el archivo en modo anexar (agregar al final del archivo).
* **"`r+`"**: Abre el archivo en modo lectura y escritura.
* **"`w+`"**: Abre el archivo en modo lectura y escritura, sobrescribiendo el contenido existente.
* **"`a+`"**: Abre el archivo en modo anexar y lectura.

## `scanf()`
La función **scanf()** en C se utiliza para leer datos desde la entrada estándar (generalmente el teclado) y almacenarlos en variables. Para lograr esto, **scanf()** necesita saber el tipo de dato que va a leer y la dirección de memoria donde almacenará ese dato.

### Parámetros de **scanf()**
1. **`format` (obligatorio)**: Es una cadena de texto que especifica el tipo de dato que se va a leer. Esta cadena contiene **especificadores de formato (format specifiers)** como `%d`, `%f`, `%c`, etc., que indican el tipo de dato que el usuario debe proporcionar.

2. Lista de argumentos adicionales: La función también recibe una lista de variables donde se almacenarán los datos ingresados. Cada variable debe ser pasada **por referencia**, lo que significa que debes pasar su dirección de memoria (de ahí el uso del `&`).

* **Ejemplo**
```c
#include <stdio.h>

int main() {
    int age;
    float height;
    
    printf("Enter your age: ");
    scanf("%d", &age);  // Lee un entero y lo almacena en 'age'

    printf("Enter your height in meters: ");
    scanf("%f", &height);  // Lee un flotante y lo almacena en 'height'

    printf("You are %d years old and %.2f meters tall.\n", age, height);
    
    return 0;
}
```
### ¿Por qué Usar el Símbolo `&` en **scanf()**?
En **C**, las variables **almacenan valores en ubicaciones de memoria específicas**. Para que **scanf()** almacene un valor en una variable, necesita **conocer la dirección de memoria** de esa variable.

* El símbolo `&` es el operador de referencia en **C**. Se utiliza para obtener la dirección de memoria de una variable.

Cuando llamas a `scanf("%d", &age);`, lo que le estás pasando a **scanf()** no es el valor actual de `age`, sino la **dirección de memoria** donde está almacenada la variable `age`. De este modo, **scanf()** puede colocar el valor leído desde la entrada en esa ubicación de memoria.

### ¿Qué Pasa si No Usas el &?
Si no pasas la dirección de memoria usando el `&`, estarías pasando una copia del valor actual de la variable. Como **scanf()** necesita modificar directamente la variable (colocar el valor leído en ella), no podría hacerlo sin la dirección de memoria. Esto produciría un error de compilación o un comportamiento inesperado.

### Excepción: Cadenas de Caracteres (Arrays de Caracteres)
En el caso de las cadenas de caracteres, no necesitas usar el operador `&` porque el nombre del array ya representa su dirección en memoria:

```c
char name[50];
scanf("%s", name);  // No se usa el operador '&' porque 'name' ya es un puntero
```
Esto se debe a que los arrays en **C** decaen automáticamente a punteros cuando se pasan a funciones, como **scanf()**.

## `fgets()`
La función **fgets()** en **C** se utiliza para leer una línea de texto desde un archivo o desde la entrada estándar (como el teclado) y almacenarla en un array de caracteres (cadena).
**fgets()**
```c
char *fgets(char *str, int n, FILE *stream)
```

### Parámetros
1. **`str`**: Es un puntero al array de caracteres donde se almacenará la cadena de texto leída.

2. **`n`**: Es el número máximo de caracteres que se leerán, incluyendo el carácter nulo (**\0**) que marca el final de la cadena.

3. **`stream`**: Es el flujo de entrada desde donde se leerán los caracteres. Este puede ser un archivo (puntero FILE *) o la entrada estándar (`stdin`).

### Comportamiento de **fgets()**
* fgets() lee hasta n - 1 caracteres del flujo y luego coloca un carácter nulo (\0) al final de la cadena para indicar el final de la misma.

* La función se detiene cuando encuentra un salto de línea (\n), cuando alcanza el número máximo de caracteres (n - 1), o cuando encuentra un EOF (End Of File) si está leyendo de un archivo.

* **Devuelve**: Un puntero a str si la lectura fue exitosa, o NULL si ocurre un error o se llega al final del archivo.

**Ejemplo**
```c
#include <stdio.h>

int main() {
    char buffer[100];

    printf("Enter a line of text: ");
    fgets(buffer, 100, stdin);  // Lee hasta 99 caracteres o hasta un salto de línea

    printf("You entered: %s", buffer);  // Imprime la cadena leída

    return 0;
}
```
En este caso, la función fgets() leerá una línea de texto desde la consola, almacenará hasta 99 caracteres en el array buffer, y luego añadirá un carácter nulo (\0) al final para indicar el fin de la cadena. Si el usuario presiona Enter antes de alcanzar los 99 caracteres, fgets() terminará de leer en ese punto.

Hablemos de las Estructuras de control de flujo, comencemos por el if, ¿que es? ¿que resuelve? ¿como lo resuelve?