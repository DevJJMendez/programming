# Estructuras de control
Las estructuras de control son bloques fundamentales en la programación que permiten controlar el flujo de ejecución de un programa dependiendo de condiciones o valores.

## ¿Qué son las estructuras de control?
Son mecanismos que permiten alterar la secuencia lineal de ejecución de un programa. Estas estructuras permiten que el programa tome decisiones basadas en condiciones específicas o realice acciones diferentes según el estado de las variables.

* `if`

* `if-else`

* `else if`

* `switch`

## ¿Para qué sirven?
Sirven para tomar decisiones dentro de un programa, haciendo que este ejecute diferentes bloques de código dependiendo de ciertas condiciones. Esto es fundamental para hacer que el software sea dinámico, flexible y adaptado a diferentes escenarios.

## ¿Qué resuelven?
Resuelven la necesidad de que el programa:

Ejecute acciones específicas dependiendo de una condición.
Tome decisiones complejas evaluando múltiples opciones.
Determine el flujo de ejecución basándose en datos proporcionados por el usuario, resultados de cálculos, o cualquier otra entrada.

**Por ejemplo:**
* En un sistema de autenticación, decidir si un usuario tiene acceso o no dependiendo de sus credenciales.

* En un ecommerce, determinar el descuento que se aplica según el tipo de cliente.

## ¿Cómo lo resuelven?
Lo resuelven evaluando expresiones lógicas o valores específicos para decidir qué bloque de código ejecutar. Se utiliza:

* Condiciones que devuelven valores booleanos (`true` o `false`).

* Comparaciones entre valores utilizando operadores como `==`, `<`, `>`, `<=`, `>=`, `!=`.

* Casos específicos con valores constantes en estructuras como `switch`.

## Tipos de estructuras de control
1. if (Condición simple)
La estructura if permite ejecutar un bloque de código si una condición es verdadera.
```c#
int edad = 20;
if (edad >= 18) {
    System.out.println("Eres mayor de edad.");
}
```

2. if-else (Condición con alternativas)
Permite ejecutar un bloque si la condición es verdadera y otro bloque si es falsa.
```c#
int temperatura = 25;
if (temperatura > 30) {
    System.out.println("Hace mucho calor.");
} else {
    System.out.println("El clima es agradable.");
}
```

3. else if (Múltiples condiciones)
Útil para manejar más de dos opciones al evaluar varias condiciones en orden.
```c#
int nota = 85;
if (nota >= 90) {
    System.out.println("Excelente.");
} else if (nota >= 70) {
    System.out.println("Bueno.");
} else {
    System.out.println("Necesitas mejorar.");
}
```

4. switch (Selección múltiple)
Evalúa el valor de una expresión y ejecuta el bloque de código que corresponde a ese valor.
```c#
int dia = 3;
switch (dia) {
    case 1:
        System.out.println("Lunes");
        break;
    case 2:
        System.out.println("Martes");
        break;
    case 3:
        System.out.println("Miércoles");
        break;
    default:
        System.out.println("Día no válido.");
}
```


## Conceptos clave que debes saber
1. Condiciones lógicas: Las estructuras de control se basan en expresiones lógicas que evalúan si algo es true o false. Por ejemplo:
```c#
int x = 10, y = 20;
if (x < y) {
    System.out.println("x es menor que y");
}
```

2. Operadores relacionales:
   * `==` : Igual a

   * `!=` : Diferente de

   * `<` : Menor que

   * `>` : Mayor que

   * `<=` : Menor o igual que

   * `>=` : Mayor o igual que

3. Operadores lógicos:
   * `&&` : Y lógico (AND)

   * `||` : O lógico (OR)

   * `!` : Negación lógica (NOT)

4. Bloques de código:

Cada bloque asociado a una estructura de control debe estar delimitado por llaves {} si tiene más de una línea.
Si el bloque contiene una sola línea, las llaves son opcionales
```c#
if (edad >= 18)
    System.out.println("Eres mayor de edad.");
```

5. break en switch: Detiene la ejecución del siguiente caso. Si no se coloca, continuará evaluando los demás casos (caída en cascada).

6. Estructura default: En switch, es el bloque que se ejecuta si no se cumple ningún caso.

## Operador Ternario
El operador ternario es un operador compacto y conciso que se utiliza para evaluar una condición y devolver uno de dos valores posibles, dependiendo de si la condición es verdadera o falsa. Es una alternativa abreviada a una estructura if-else.

En C#, el operador ternario se conoce como el operador condicional y está representado por el símbolo ? :.

**Estructura**
```c#
resultado = condición ? valor_si_verdadero : valor_si_falso;
```
* condición: Es una expresión que se evalúa como true o false.

* valor_si_verdadero: Es el valor que se asigna si la condición es true.

* valor_si_falso: Es el valor que se asigna si la condición es false.

## ¿Para qué sirve?
Sirve para:

Simplificar el código al reducir múltiples líneas de un if-else a una sola línea.
Tomar decisiones rápidas que solo implican dos posibles resultados.
Asignar valores a una variable basándose en una condición.

## ¿Qué resuelve?
Resuelve la necesidad de realizar asignaciones o decisiones rápidas en el flujo del programa sin tener que escribir estructuras más largas como if-else.

Por ejemplo:

Decidir si mostrar un mensaje de "Mayor de edad" o "Menor de edad" basado en una variable.
Calcular un valor dependiendo de una condición (como aplicar un descuento).

## ¿Cómo lo resuelve?
Lo resuelve evaluando una condición lógica y devolviendo un valor específico dependiendo de si la condición es verdadera o falsa. Todo esto ocurre en una única línea de código, haciendo que el programa sea más compacto y legible.

```c#
int edad = 20;
string mensaje = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
Console.WriteLine(mensaje);
```
Si edad es mayor o igual a 18, el mensaje será "Mayor de edad".
Si no, el mensaje será "Menor de edad".

## ¿Cuándo usar el operador ternario?
El operador ternario es ideal para situaciones en las que:

Hay solo dos resultados posibles.
La expresión es sencilla y fácil de leer.
No es necesario realizar varias operaciones dentro de la condición.

```c#
int numero = 5;
string paridad = (numero % 2 == 0) ? "Par" : "Impar";
Console.WriteLine(paridad);

```

## Ejemplo avanzado: Operador ternario anidado
Es posible usar operadores ternarios anidados, pero debes evitar abusar de esta práctica, ya que puede disminuir la legibilidad del código.

```c#
int nota = 85;
string calificacion = (nota >= 90) ? "Excelente" :
                      (nota >= 70) ? "Bueno" :
                      "Necesita mejorar";
Console.WriteLine(calificacion);
```

## Limitaciones del operador ternario
Complejidad: Si necesitas evaluar condiciones más complejas o realizar varias acciones, es mejor usar if-else para mantener la legibilidad.
Acciones múltiples: El operador ternario no se usa para ejecutar bloques de código con múltiples sentencias; solo para devolver valores.
Legibilidad: Aunque compacto, el código puede volverse menos claro si se abusa del operador o si las expresiones son largas.