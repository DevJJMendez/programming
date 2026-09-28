## Estructuras de control de flujo
## `if`
El **if** es una estructura de control de flujo en C (y en muchos otros lenguajes de programación) que permite tomar decisiones dentro de un programa en función de si una condición es verdadera o falsa. Esto es fundamental para realizar acciones diferentes según el estado de las variables o los resultados de operaciones lógicas.

### ¿Qué es `if`?
El **if** es una instrucción condicional que evalúa una expresión booleana (una condición que puede ser verdadera o falsa). Dependiendo de si la expresión es verdadera (true) o falsa (false), el programa ejecutará una serie de instrucciones o las ignorará.

### ¿Qué resuelve?
El **if** resuelve el problema de decisiones y bifurcaciones en el flujo del programa. Esto significa que puedes hacer que el programa tome un camino diferente dependiendo de una condición. Por ejemplo, si quieres ejecutar un código solo si una variable tiene un valor específico, usas **if** para verificar esa condición.

### ¿Cómo lo resuelve?
Lo resuelve de la siguiente manera:

1. **Evaluación de la condición**: El **if** primero evalúa una expresión lógica o relacional (por ejemplo, `x > 5`).

2. **Acción basada en la evaluación**:
   * Si la condición es verdadera (non-zero), ejecuta el bloque de código que sigue al **if**.

   * Si la condición es falsa (zero), ignora ese bloque y pasa al siguiente código o alternativa.

### Sintaxis
```c
if(condicion){
  // Código que se ejecuta si la condición es verdadera
}
```

**Ejemplo**
```c
#include <stdio.h>

int main() {
    int edad = 18;

    if (edad >= 18) {
        printf("Eres mayor de edad.\n");
    }

    return 0;
}
```
En este ejemplo, el programa evalúa si la variable **`edad` es mayor o igual a 18**. Si la condición es verdadera, imprime "Eres mayor de edad." Si no, simplemente continúa con el siguiente código, aunque no hay más instrucciones en este caso.

## `if-else`
El **else** se utiliza junto con **if** para proporcionar una alternativa en caso de que la condición sea falsa. De esta manera, el programa puede realizar una acción si la condición es verdadera y una acción diferente si es falsa.

**Sintaxis**
```c
if (condición) {
    // Código que se ejecuta si la condición es verdadera
} else {
    // Código que se ejecuta si la condición es falsa
}
```

**Ejemplo**
```c
#include <stdio.h>

int main() {
    int edad = 16;

    if (edad >= 18) {
        printf("Eres mayor de edad.\n");
    } else {
        printf("Eres menor de edad.\n");
    }

    return 0;
}
```

## Anidación de `if` (`else if`)
Si tienes múltiples condiciones que deseas verificar, puedes usar `else if`. Esto permite evaluar varias condiciones en secuencia.

**Sintaxis**
```c
if (condición1) {
    // Código si condición1 es verdadera
} else if (condición2) {
    // Código si condición2 es verdadera
} else {
    // Código si ninguna condición es verdadera
}
```

**Ejemplo**
```c
#include <stdio.h>

int main() {
    int temperatura = 30;

    if (temperatura > 30) {
        printf("Hace calor.\n");
    } else if (temperatura >= 15 && temperatura <= 30) {
        printf("El clima es agradable.\n");
    } else {
        printf("Hace frío.\n");
    }

    return 0;
}
```

## ¿Cuándo se utilizan los if?
Se utilizan cuando necesitas realizar una decisión basada en una condición en el flujo de tu programa. Algunas situaciones comunes:

* Verificar si un usuario ha ingresado datos válidos.
* Controlar el flujo en un juego, como verificar si el jugador ha ganado o perdido.
* Determinar qué opción elegir en un menú de aplicación según una entrada del usuario.

## `switch`
El **switch** es una estructura de control de flujo en **C** que se utiliza cuando se necesita tomar decisiones múltiples basadas en el valor de una expresión. Es una alternativa al uso de múltiples **if-else **y se usa cuando hay varias condiciones relacionadas con un valor en particular. Proporciona una forma más limpia y legible para manejar este tipo de situaciones.

### ¿Qué es el switch?
El **switch** evalúa una expresión y selecciona una de varias opciones basadas en el valor de esa expresión. Cada opción está representada por un **caso (case)** que se compara con el resultado de la expresión. Si la expresión coincide con uno de los casos, el programa ejecuta las instrucciones asociadas a ese caso.

### ¿Qué resuelve?
El **switch** resuelve el problema de la selección múltiple. Cuando tienes varias opciones posibles y deseas ejecutar una parte específica del código en función de un valor, el **switch** permite hacerlo de manera más clara y ordenada que una larga cadena de `if-else if`.

### ¿Cómo lo resuelve?
* **Evaluación de la expresión**: El **switch** evalúa una expresión, que generalmente es un entero o un carácter.

* **Comparación con los casos**: Compara el valor de la expresión con los valores definidos en los diferentes case.

* **Ejecución de la coincidencia**: Cuando el valor de la expresión coincide con uno de los **case**, se ejecuta el bloque de código asociado a ese case. Si no hay coincidencias, se ejecuta el bloque **`default`** (si está presente).

* **Termina con `break`**: Cada bloque de código en un case **suele** terminar con la palabra clave `break`, que indica que el programa debe salir del **switch** una vez que se ejecuta ese bloque. Si se omite el break, el programa continuará ejecutando los casos siguientes hasta encontrar un break o llegar al final del switch.

### Sintaxis
```c
switch (expresión) {
    case valor1:
        // Código para el caso 1
        break;
    case valor2:
        // Código para el caso 2
        break;
    case valor3:
        // Código para el caso 3
        break;
    default:
        // Código si ningún caso coincide
}
```
**Ejemplo**
```c
#include <stdio.h>

int main() {
    int dia = 3;

    switch (dia) {
        case 1:
            printf("Lunes\n");
            break;
        case 2:
            printf("Martes\n");
            break;
        case 3:
            printf("Miércoles\n");
            break;
        case 4:
            printf("Jueves\n");
            break;
        case 5:
            printf("Viernes\n");
            break;
        case 6:
            printf("Sábado\n");
            break;
        case 7:
            printf("Domingo\n");
            break;
        default:
            printf("Día no válido\n");
    }

    return 0;
}
```

### ¿Cuándo se utiliza el switch?
El switch se utiliza cuando tienes múltiples valores posibles para una variable o expresión y deseas ejecutar diferentes bloques de código en función de esos valores. Es particularmente útil cuando:

* Tienes que manejar varias condiciones relacionadas con un solo valor.
* El valor que estás evaluando es discreto (enteros o caracteres).
* Quieres evitar una larga cadena de **if-else if**, lo que podría hacer el código menos legible.

## El bloque default
El bloque **default** es opcional y se ejecuta si ninguno de los casos coincide con el valor de la expresión. Es similar al else en una estructura **if-else**. Si no se incluye un bloque **default**, y no hay coincidencias, el **switch** no ejecutará ningún bloque de código.

## El uso de break
El **break** es importante en el **switch** porque detiene la ejecución una vez que se ha encontrado un caso coincidente. Sin el break, el programa continuará ejecutando los bloques de código de los siguientes casos, lo que se conoce como **fall-through**.

## Limitaciones del switch
* Solo admite enteros o caracteres en su expresión. No puede evaluar expresiones con flotantes o strings (en C).

* Puede ser más difícil de manejar si las condiciones no están basadas en un solo valor discreto, ya que un if-else es más flexible para evaluar rangos o expresiones complejas.