## String functions
Las funciones de cadenas (string functions) en C son un conjunto de funciones que permiten realizar diversas operaciones con cadenas de caracteres. Las cadenas en C son arreglos de caracteres que terminan con un carácter nulo ('\0'), lo que indica el final de la cadena. Para trabajar con ellas, C proporciona varias funciones definidas en la librería estándar `<string.h>`.

### Operaciones comunes con cadenas
Las funciones de cadenas permiten realizar operaciones como:

* Determinar la longitud de una cadena.
* Copiar una cadena a otra.
* Comparar dos cadenas.
* Concatenar cadenas.
* Buscar caracteres o subcadenas dentro de una cadena.

### Principales funciones de cadenas en C
strlen(): Obtiene la longitud de una cadena.: Devuelve la cantidad de caracteres de la cadena, excluyendo el carácter nulo.

```c
#include <stdio.h>
#include <string.h>

int main() {
    char cadena[] = "Hola, mundo";
    printf("La longitud de la cadena es: %lu\n", strlen(cadena));  // Salida: 11
    return 0;
}
```

strcpy(): Copia una cadena a otra.: Copia el contenido de la cadena src a la cadena dest. La cadena de destino debe ser lo suficientemente grande como para contener la cadena fuente.

```c
#include <stdio.h>
#include <string.h>

int main() {
    char destino[20];
    char fuente[] = "Hola";
    strcpy(destino, fuente);
    printf("Destino: %s\n", destino);  // Salida: "Hola"
    return 0;
}
```

strncpy(): Copia los primeros n caracteres de una cadena a otra.
```c
char destino[20];
strncpy(destino, "Hola", 3);
printf("%s\n", destino);  // Salida: "Hol"
```

strcmp(): Compara dos cadenas.
Devuelve 0 si las cadenas son iguales.
Devuelve un número positivo si str1 es mayor que str2.
Devuelve un número negativo si str1 es menor que str2.
```c
int resultado = strcmp("Hola", "Mundo");
if (resultado < 0) {
    printf("Hola es menor que Mundo\n");
} else if (resultado > 0) {
    printf("Hola es mayor que Mundo\n");
} else {
    printf("Las cadenas son iguales\n");
}
```

strcat(): Concatenar dos cadenas, Añade la cadena src al final de la cadena dest. La cadena de destino debe ser lo suficientemente grande para contener ambas cadenas.
```c
char destino[20] = "Hola, ";
strcat(destino, "mundo!");
printf("%s\n", destino);  // Salida: "Hola, mundo!"
```

strncat(): Concatenar los primeros n caracteres de una cadena.
```c
char destino[20] = "Hola, ";
strncat(destino, "mundo!", 5);  // Sólo agrega los primeros 5 caracteres
printf("%s\n", destino);  // Salida: "Hola, mundo"
```

strchr(): Busca un carácter en una cadena.
```c
char *resultado = strchr("Hola, mundo", 'm');
if (resultado != NULL) {
    printf("Se encontró 'm' en la cadena: %s\n", resultado);  // Salida: "mundo"
}
```

strstr(): Busca una subcadena dentro de otra cadena.
```c
char *resultado = strstr("Hola, mundo", "mundo");
if (resultado != NULL) {
    printf("Se encontró la subcadena: %s\n", resultado);  // Salida: "mundo"
}
```
