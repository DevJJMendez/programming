## `sizeof()`
La función sizeof en C es un operador que devuelve el tamaño, en bytes, de una variable o de un tipo de dato. Es ampliamente utilizado para trabajar con la memoria y garantizar que las asignaciones sean del tamaño adecuado, especialmente cuando se trabaja con estructuras de datos, arrays y tipos definidos por el usuario.

```c
sizeof(tipo_de_dato);
sizeof(variable);
```
### ¿Qué resuelve sizeof?
La función sizeof resuelve la necesidad de conocer el tamaño en bytes de un tipo de dato o de una variable en tiempo de compilación. Esto es particularmente importante en C, donde el tamaño de los tipos de datos puede variar según la arquitectura del sistema (32 bits, 64 bits, etc.).

### ¿Cuándo se utiliza?
Se utiliza en los siguientes casos:

* **Asignación de memoria dinámica**: Para asegurarte de que estás reservando el número correcto de bytes.
* **Manipulación de arrays y estructuras**: Para obtener el tamaño total de una estructura de datos o la cantidad de elementos de un array.
* **Compatibilidad con distintas arquitecturas**: Para escribir código portable que funcione en arquitecturas de 32 bits y 64 bits.

### Ejemplos de uso
1. Obtener el tamaño de un tipo de dato
```c
#include <stdio.h>

int main() {
    printf("El tamaño de un int es: %lu bytes\n", sizeof(int));
    printf("El tamaño de un char es: %lu bytes\n", sizeof(char));
    printf("El tamaño de un float es: %lu bytes\n", sizeof(float));
    printf("El tamaño de un double es: %lu bytes\n", sizeof(double));

    return 0;
}
/*
El tamaño de un int es: 4 bytes
El tamaño de un char es: 1 byte
El tamaño de un float es: 4 bytes
El tamaño de un double es: 8 bytes
*/
```

2. Obtener el tamaño de una variable
```c
int a = 10;
printf("El tamaño de la variable a es: %lu bytes\n", sizeof(a));
```
3. Obtener el tamaño de un array
Cuando sizeof se usa en un array, devuelve el tamaño total del array (número de elementos multiplicado por el tamaño de cada elemento).
```c
int array[10];
printf("El tamaño del array es: %lu bytes\n", sizeof(array));  // 10 elementos * 4 bytes (tamaño de int)
```
Para obtener el número de elementos de un array:
```c
int array[10];
int numElementos = sizeof(array) / sizeof(array[0]);
printf("El número de elementos en el array es: %d\n", numElementos);
```
4. Uso con estructuras
Cuando se trabaja con estructuras de datos, sizeof es útil para conocer el tamaño total que ocupan en memoria.
```c
#include <stdio.h>

struct Persona {
    char nombre[50];
    int edad;
    float altura;
};

int main() {
    struct Persona persona;
    printf("El tamaño de la estructura Persona es: %lu bytes\n", sizeof(persona));

    return 0;
}
```
## ¿Cómo lo resuelve?
sizeof evalúa en tiempo de compilación, lo que significa que no incurre en ningún costo de rendimiento en tiempo de ejecución. Retorna el tamaño correcto dependiendo del tipo de dato o de la variable.