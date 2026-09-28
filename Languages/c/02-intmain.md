# `int main()`
```c
#include <stdio.h>
int main(int argc, char const *argv[])
{
  return 0;
}
```
1. `#include <stdio.h>`
   
   * `#include`: Esta es una directiva de preprocesador que indica que se debe incluir el contenido de un archivo de cabecera específico en el programa antes de la compilación.

   * `<stdio.h>`: Es el archivo de cabecera estándar de entrada y salida (**Standard Input Output**). Contiene las declaraciones de funciones útiles como `printf()`, `scanf()`, entre otras, que permiten interactuar con la consola.

2. `int main(int argc, char const *argv[])`: Esta es la función principal de cualquier programa en C. Es el punto de entrada donde comienza la ejecución del programa.
   
   * `int main`: Indica que la función main devuelve un valor de tipo entero (int). Este valor es retornado al sistema operativo cuando finaliza la ejecución del programa.
   
   * Parámetros `argc` y `argv[]`:
     
     * `int argc`: Este parámetro significa "**Argument Count**" (número de argumentos). Es un entero que indica cuántos argumentos se han pasado al programa desde la línea de comandos. El valor mínimo es 1, ya que el primer argumento es siempre el nombre del programa ejecutado.
     
     * `char const *argv[]`: Este es un array de punteros a cadenas de caracteres (char). Cada entrada de este array es un argumento pasado al programa desde la línea de comandos. El primer argumento (argv[0]) es siempre el nombre del programa, y los siguientes (si los hay) son los argumentos proporcionados por el usuario.

   * **Ejemplo**
     * Si ejecuta el programa así

      ```bash
      ./programa arg1 arg2
      ```
      * `argc` sería igual a 3 (nombre del programa + dos argumentos).

      * `argv[0]` sería "**./programa**".

      * `argv[1]` sería "**arg1**".

      * `argv[2]` sería "**arg2**".
  
      Estos parámetros permiten que el programa reciba y procese datos directamente desde la línea de comandos, lo que es útil para programas interactivos o automatizados.

3. `return 0;`: La declaración `return 0;` indica que la función main ha finalizado correctamente y devuelve un valor de **0** al sistema operativo.

   * **Valor de retorno de `main`**: En los programas en **C**, el valor que devuelve **main** se utiliza como código de salida para indicar al sistema operativo si el programa terminó correctamente o si ocurrió algún error.
   
     * **`return 0`**: Indica que el programa terminó exitosamente. Es la convención estándar que se utiliza para señalar una ejecución sin errores.
     
     * **`return 1` (o cualquier otro número)**: Indica que ocurrió algún error durante la ejecución. Este número puede ser utilizado para comunicar al sistema o a otros programas el tipo de error que ocurrió.