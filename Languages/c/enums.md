## Enums
Los **Enums** o Enumeraciones en **C** son un tipo de dato que permite definir un conjunto de constantes enteras con nombres más significativos. Este tipo de dato es útil cuando se necesita representar un conjunto de valores relacionados con nombres más legibles que simples números enteros, lo que mejora la legibilidad y el mantenimiento del código.

### ¿Qué son los enum?
Un **enum** es una forma de asignar nombres a valores constantes enteros. Se utiliza para representar valores finitos y conocidos, como los días de la semana, los estados de una máquina de estados, colores, etc. En términos técnicos, un **enum** es una lista de identificadores que representan números enteros.

### ¿Qué resuelven los enum?
Los **enum** resuelven problemas relacionados con la legibilidad y mantenibilidad del código. Al utilizar un **enum**, en lugar de manejar números enteros "mágicos", se usan nombres con significado. Además, permiten la fácil agrupación de un conjunto de constantes que están relacionadas entre sí.

* **Legibilidad del código**: En lugar de usar números sin contexto, se utilizan nombres que indican claramente el propósito.

* **Mantenimiento**: Los enum agrupan valores relacionados en un solo lugar, facilitando la modificación o ampliación del conjunto de valores.

* **Evitar valores incorrectos**: Al utilizar constantes nombradas, es menos probable cometer errores al usar valores enteros.

### ¿Cómo lo resuelven?
Los **enum** asignan automáticamente números enteros secuenciales a los identificadores listados, comenzando desde 0 (por defecto). Si es necesario, también puedes asignar valores específicos a los identificadores.

### ¿Cuándo se utilizan?
Se utilizan cuando:

* Necesitas un conjunto de valores constantes relacionados.
* Deseas mejorar la legibilidad del código y evitar el uso de números sin significado.
* Quieres manejar estados, opciones o categorías con valores específicos pero sin perder claridad en el código.

### Sintaxis de enum
Para definir un **enum**, se utiliza la siguiente sintaxis:
```c
#include <stdio.h>

enum DiasSemana {
    LUNES,     // 0
    MARTES,    // 1
    MIERCOLES, // 2
    JUEVES,    // 3
    VIERNES,   // 4
    SABADO,    // 5
    DOMINGO    // 6
};

int main() {
    enum DiasSemana hoy = MIERCOLES;

    if (hoy == MIERCOLES) {
        printf("Hoy es miércoles.\n");
    }
    return 0;
}
```

### Asignación de valores personalizados
Por defecto, los valores asignados a los identificadores comienzan en 0 y se incrementan en 1, pero puedes cambiar ese comportamiento asignando valores específicos a los identificadores:
```c
enum Meses {
    ENERO = 1,
    FEBRERO = 2,
    MARZO = 3,
    ABRIL = 4,
    MAYO = 5,
    JUNIO = 6,
    JULIO = 7,
    AGOSTO = 8,
    SEPTIEMBRE = 9,
    OCTUBRE = 10,
    NOVIEMBRE = 11,
    DICIEMBRE = 12
};
```
En este ejemplo, el primer mes (ENERO) recibe el valor de 1, y los meses siguientes se asignan secuencialmente.

### Operaciones con enum
Internamente, los valores de un enum son tratados como enteros, lo que significa que puedes realizar operaciones aritméticas y comparaciones:
```c
#include <stdio.h>

enum NivelAlerta {
    BAJO = 1,
    MEDIO = 2,
    ALTO = 3
};

int main() {
    enum NivelAlerta alerta = MEDIO;

    if (alerta < ALTO) {
        printf("Alerta no crítica.\n");
    }
    
    return 0;
}
```

### Peligros de los enum
Aunque los enum son muy útiles, tienen algunos inconvenientes:

1. **Sin comprobación estricta**: Los valores de los enum son tratados como enteros, lo que significa que puedes asignarles valores fuera del rango sin advertencias. Esto puede causar problemas si no tienes cuidado.
    
    ```c
    enum Dias { LUNES, MARTES, MIERCOLES };
    enum Dias dia = 5;  // Esto es válido en C, pero no tiene sentido lógico.
    ```

2. **Limitación a enteros**: Los enum solo pueden contener valores enteros. No se pueden utilizar para otros tipos de datos, como cadenas o floats.