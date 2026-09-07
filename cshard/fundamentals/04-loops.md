# Bucles
Los bucles son estructuras fundamentales en programación que permiten repetir un bloque de código varias veces, dependiendo de una condición. En C#, se utilizan para realizar tareas repetitivas de manera eficiente y controlada.

## ¿Qué son los bucles?
Los bucles son estructuras de control que repiten un bloque de código mientras se cumpla una condición específica. Ayudan a automatizar procesos repetitivos sin necesidad de escribir el mismo código varias veces.

* `for`

* `while`

* `do-while`

## ¿Para qué sirven?
Automatizar tareas repetitivas: Por ejemplo, recorrer una lista o procesar elementos en un rango de valores.
Iterar sobre datos: Como colecciones, arreglos, o cadenas.
Reducir la redundancia: Evitan tener que escribir el mismo bloque de código múltiples veces.
Optimizar operaciones repetitivas: Mejoran la eficiencia al manejar grandes cantidades de datos.

## ¿Qué resuelven?
Repeticiones innecesarias en el código: En lugar de escribir el mismo bloque de instrucciones varias veces, se usa un bucle.
Procesar datos iterativamente: Como calcular la suma de números, filtrar elementos, o realizar operaciones repetitivas en bases de datos o listas.
Controlar tareas dinámicas: Donde la cantidad de repeticiones depende de una condición que puede cambiar durante la ejecución.

## ¿Cómo lo resuelven?
Cada tipo de bucle en C# tiene su forma de trabajar:

for: Diseñado para iteraciones controladas, donde se conoce la cantidad de repeticiones de antemano.
while: Repite el bloque de código mientras se cumpla una condición.
do-while: Similar a while, pero siempre ejecuta el bloque al menos una vez antes de verificar la condición.

## Tipos de bucles en C#: Estructura y Ejemplos
1. `for`: El bucle for se utiliza cuando se conoce el número exacto de iteraciones que se deben realizar.

**Estructura:**
```c#
for (inicialización; condición; actualización) {
    // Bloque de código a repetir
}
```
* Inicialización: Se ejecuta una sola vez al inicio, normalmente para inicializar una variable de control.

* Condición: Evalúa si el bucle debe continuar ejecutándose.

* Actualización: Modifica la variable de control después de cada iteración.

**Ejemplo**
```c#
for (int i = 0; i < 5; i++) {
    Console.WriteLine($"Iteración {i}");
}
```
**Salida**
```bash
Iteración 0
Iteración 1
Iteración 2
Iteración 3
Iteración 4
```

2. `while`: El bucle while se utiliza cuando no se conoce de antemano el número de iteraciones y depende de una condición.

**Estructura:**
```c#
while (condición) {
    // Bloque de código a repetir
}
```
La condición se evalúa antes de cada iteración.
Si la condición es false desde el inicio, el bucle no se ejecuta.

**Ejemplo**
```c#
int contador = 0;
while (contador < 5) {
    Console.WriteLine($"Iteración {contador}");
    contador++;
}
```
**Salida**
```bash
Iteración 0
Iteración 1
Iteración 2
Iteración 3
Iteración 4
```

3. Bucle do-while
¿Qué es?
El bucle do-while es similar a while, pero asegura que el bloque de código se ejecute al menos una vez antes de verificar la condición.

Estructura:
```c#
do {
    // Bloque de código a repetir
} while (condición);
```
**Ejemplo**
```c#
int contador = 0;
do {
    Console.WriteLine($"Iteración {contador}");
    contador++;
} while (contador < 5);
```
**Salida**
```bash
Iteración 0
Iteración 1
Iteración 2
Iteración 3
Iteración 4
```

# `break`
El comando break se utiliza para salir inmediatamente de un bucle o una estructura switch. Cuando se ejecuta, termina la ejecución del bloque actual y salta al siguiente bloque de código después del bucle o switch.

## ¿Para qué sirve break?
Finalizar un bucle: Detener la ejecución de un bucle antes de que se cumpla su condición.
Salir de un switch: Evitar que se ejecuten otros casos en una estructura switch.

## ¿Qué resuelve break?
Condiciones inesperadas dentro de un bucle: Por ejemplo, si se encuentra un valor específico y no es necesario seguir iterando.
Evitar ejecutar múltiples casos en un switch.

## ¿Cómo lo resuelve?
Al detectar la instrucción break, el control del programa abandona inmediatamente el bucle o switch. Esto permite:

Optimizar la ejecución al evitar iteraciones innecesarias.
Simplificar la lógica al permitir salidas tempranas.

```c#
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        Console.WriteLine("Se encontró el valor 5, saliendo del bucle...");
        break;
    }
    Console.WriteLine($"Valor actual: {i}");
}
```
**Salida**
```bash
Valor actual: 0
Valor actual: 1
Valor actual: 2
Valor actual: 3
Valor actual: 4
Se encontró el valor 5, saliendo del bucle...
```

# `continue`
El comando continue se utiliza dentro de bucles para saltar a la siguiente iteración del bucle, omitiendo las instrucciones restantes en el bloque actual. A diferencia de break, no finaliza el bucle, sino que continúa con la siguiente iteración.

## ¿Para qué sirve continue?
Omitir ciertas iteraciones: Ignorar el código restante en una iteración cuando se cumple una condición.
Optimizar la lógica del bucle: Al evitar procesar datos irrelevantes o innecesarios.

## ¿Qué resuelve continue?
Evitar ejecutar código irrelevante dentro del bucle: Por ejemplo, cuando un elemento no cumple ciertos criterios.
Simplificar la lógica condicional dentro de un bucle.

## ¿Cómo lo resuelve?
Cuando se encuentra la instrucción continue, el control del programa salta inmediatamente a la siguiente iteración del bucle, evitando la ejecución de las líneas restantes en esa iteración.

```c#
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue; // Saltar los números pares
    }
    Console.WriteLine($"Número impar: {i}");
}
```
**Salida**
```bash
Número impar: 1
Número impar: 3
Número impar: 5
Número impar: 7
Número impar: 9
```

# `foreach()`
El foreach es una estructura de control en C# que permite iterar de manera sencilla sobre elementos de una colección, como arrays, listas, o cualquier estructura que implemente la interfaz `IEnumerable`. Es especialmente útil para recorrer colecciones de datos sin necesidad de manejar índices.

## ¿Cuál es su estructura?
La estructura de un foreach en C# es la siguiente:

```c#
foreach (var elemento in coleccion) {
    // Código que se ejecutará para cada elemento
}
```
* elemento: Es la variable que representa el elemento actual en la iteración.

* coleccion: Es la colección (array, lista, etc.) que se recorre.

* var: Puede ser reemplazado por el tipo específico del elemento si se conoce.

## ¿Para qué sirve foreach?
* Iterar sobre colecciones: Recorre elementos de una colección de forma fácil y segura.

* Simplificar la lógica de iteración: No es necesario manejar índices, lo que reduce errores como desbordamientos.

* Leer elementos: Aunque no permite modificar directamente los elementos de la colección (a menos que sean objetos mutables).

## ¿Qué resuelve foreach?
* Errores comunes de índices: Evita errores como índices fuera de rango al iterar.

* Complejidad en el manejo de bucles: Facilita la iteración sobre estructuras complejas como listas o diccionarios.

* Legibilidad: Hace que el código sea más legible y claro cuando se trabaja con colecciones.

## ¿Cómo lo resuelve?
* Al trabajar directamente con los elementos de la colección, el foreach oculta la lógica interna del manejo de índices o iteradores.

* Implementa de forma transparente el patrón de iteración definido por la interfaz IEnumerable.

## Ejemplos de uso
1. Iterar un array de enteros
```c#
int[] numeros = { 1, 2, 3, 4, 5 };

foreach (int numero in numeros) {
    Console.WriteLine($"Número: {numero}");
}
```
**Salida**
```bash
Número: 1
Número: 2
Número: 3
Número: 4
Número: 5
```

2. Iterar una lista de cadenas
```c#
List<string> nombres = new List<string> { "Alice", "Bob", "Charlie" };

foreach (string nombre in nombres) {
    Console.WriteLine($"Hola, {nombre}!");
}
```
**Salida**
```bash
Hola, Alice!
Hola, Bob!
Hola, Charlie!
```

3. Iterar un diccionario
```c#
Dictionary<int, string> empleados = new Dictionary<int, string> {
    { 1, "Juan" },
    { 2, "María" },
    { 3, "Carlos" }
};

foreach (KeyValuePair<int, string> empleado in empleados) {
    Console.WriteLine($"ID: {empleado.Key}, Nombre: {empleado.Value}");
}
```
**Salida**
```bash
ID: 1, Nombre: Juan
ID: 2, Nombre: María
ID: 3, Nombre: Carlos
```

4. Iterar objetos mutables y modificarlos (indirectamente): Si los elementos de la colección son objetos, puedes modificar sus propiedades dentro del foreach:
```c#
class Producto {
    public string Nombre { get; set; }
    public double Precio { get; set; }
}

List<Producto> productos = new List<Producto> {
    new Producto { Nombre = "Laptop", Precio = 1000 },
    new Producto { Nombre = "Celular", Precio = 500 }
};

foreach (Producto producto in productos) {
    producto.Precio *= 1.10; // Incremento del 10%
    Console.WriteLine($"Producto: {producto.Nombre}, Precio: {producto.Precio}");
}
```
**Salida**
```bash
Producto: Laptop, Precio: 1100
Producto: Celular, Precio: 550
```

## Limitaciones de foreach
Inmutabilidad directa: No puedes reasignar elementos directamente dentro del foreach (es decir, no puedes cambiar elemento).
```c#
int[] numeros = { 1, 2, 3 };
foreach (int numero in numeros) {
    // Esto genera un error:
    // numero = numero * 2;
}
```
* Solo para lectura: Está diseñado principalmente para leer datos. Si necesitas modificar elementos, es mejor usar un for.

* Solo para colecciones que implementen IEnumerable: No se puede usar en tipos que no soporten enumeración.