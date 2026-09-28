## Structs
En C, las estructuras (o structs) son una forma de agrupar diferentes tipos de datos bajo un mismo nombre. Las estructuras permiten combinar variables de distintos tipos en un solo objeto, lo cual es útil cuando se quiere trabajar con datos que tienen múltiples atributos.

### ¿Qué es un struct?
Un struct es una colección de variables (denominadas members) que pueden ser de diferentes tipos de datos, agrupadas bajo un único nombre. A diferencia de un array, que contiene elementos del mismo tipo, una estructura puede contener varios tipos de datos bajo un mismo contenedor.

### ¿Qué resuelve?
Los structs resuelven el problema de manejar grupos de datos heterogéneos como una sola entidad. Por ejemplo, al manejar información de una persona, es posible que tengas datos como el nombre (cadena de caracteres), edad (entero) y altura (flotante), que no se pueden manejar eficientemente con un solo tipo de datos como un array.

### ¿Cómo lo resuelven?
Mediante la creación de un struct, puedes definir un tipo de dato personalizado que encapsula múltiples atributos. De esta manera, puedes almacenar y manipular todos los atributos relacionados a un objeto en un solo lugar.

### ¿Cuándo se utilizan?
Los structs se utilizan cuando:

* Tienes varios datos relacionados que necesitan ser tratados como un solo bloque.
* Necesitas manejar datos más complejos que un simple array.
* Necesitas crear una estructura de datos para modelar entidades en programas, como empleados, estudiantes, puntos en un gráfico, etc.

### Declaración de un struct
Un struct se declara utilizando la palabra clave struct, seguida del nombre de la estructura y las variables que la componen.
```c
struct Persona {
    char nombre[50];
    int edad;
    float altura;
};
```

### ¿Cómo se utilizan?
Una vez que has declarado un struct, puedes crear variables de este tipo y acceder a sus miembros.

Creación de una variable de tipo struct:
```c
struct Persona persona1;
```
Asignación de valores a los miembros:
```c
strcpy(persona1.nombre, "Juan");
persona1.edad = 30;
persona1.altura = 1.75;
```
Acceso a los miembros de una estructura:
Para acceder a los miembros de una estructura, se utiliza el operador punto (.).
```c
printf("Nombre: %s\n", persona1.nombre);
printf("Edad: %d\n", persona1.edad);
printf("Altura: %.2f\n", persona1.altura);
```

### Inicialización de un struct
Es posible inicializar un struct en el momento de la declaración.
```c
struct Persona persona2 = {"Maria", 25, 1.65};
```

### Anidación de estructuras
Las estructuras pueden contener otros structs, permitiendo la creación de estructuras más complejas.
```c
struct Direccion {
    char calle[50];
    char ciudad[50];
    int codigoPostal;
};

struct Persona {
    char nombre[50];
    int edad;
    struct Direccion direccion;  // Anidación de estructuras
};

struct Persona persona3 = {"Pedro", 28, {"Calle Falsa 123", "Ciudad X", 12345}};

printf("Ciudad: %s\n", persona3.direccion.ciudad);
```

## `typedef`
En C, **typedef** es una palabra clave utilizada para crear un alias o un nombre alternativo para un tipo de datos ya existente. Esto es útil para hacer que el código sea más legible, más fácil de escribir, y para simplificar el manejo de tipos de datos complejos como estructuras, punteros, y arrays.

### ¿Qué es **typedef**?
**typedef** permite definir un nombre alternativo para cualquier tipo de dato, ya sea un tipo de datos básico (como int o float), un puntero, un array, una estructura, o incluso tipos definidos por el usuario.

### ¿Qué resuelve?
**typedef** ayuda a simplificar y mejorar la legibilidad del código, especialmente cuando se trata de tipos de datos complejos como estructuras y punteros. En lugar de tener que escribir nombres largos y complicados para ciertos tipos, puedes usar **typedef** para crear nombres cortos y comprensibles.

### ¿Cómo lo resuelve?
**typedef** permite definir un alias más simple y claro para un tipo de dato existente. Por ejemplo, en lugar de declarar estructuras con el prefijo `struct` o manejar punteros a estructuras complejas, puedes usar un alias más legible.

### ¿Cuándo se utiliza?
Se utiliza cuando:

* Quieres simplificar el uso de tipos de datos complejos.
* Deseas mejorar la legibilidad del código.
* Se está manejando código que requiere reutilizar ciertos tipos de datos, como estructuras o punteros, de manera repetida.

### Sintaxis
```c
typedef tipo_existente nuevo_nombre;
```

**Ejemplos**
```c
typedef unsigned int uint;
uint x = 10; // Ahora puedes usar "uint" en lugar de "unsigned int"

typedef int* int_pointer;
int_pointer p;  // Ahora "p" es un puntero a entero

// sin typedef
struct Persona {
    char nombre[50];
    int edad;
};

struct Persona p1;

// con typedef
typedef struct {
    char nombre[50];
    int edad;
} Persona;

Persona p1;  // Ya no necesitas usar "struct"

typedef int IntArray[10];  // Alias para un array de 10 enteros
IntArray miArray;  // Declarar un array de 10 enteros
```