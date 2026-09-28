# Stack Memory
La memoria Stack es una de las áreas más importantes de la memoria en la ejecución de programas. Se usa para manejar la ejecución de funciones, almacenar variables locales y administrar el flujo de control del programa de manera eficiente.

El Stack es una región de memoria reservada para gestionar automáticamente:
* llamadas a funciones (métodos),
* variables locales,
* parámetros,
* direcciones de retorno,
* contexto de ejecución.

La memoria Stack es una estructura de datos en forma de pila **`LIFO` **(Last In, First Out)**** utilizada por los programas para almacenar información temporal de manera organizada. Cada vez que se llama a una función, se crea un nuevo marco en el Stack para almacenar sus variables locales y otros datos asociados a la ejecución.

## ¿Para qué sirve?
La memoria Stack tiene varios propósitos clave en la ejecución de programas:

* **Gestión de funciones y llamadas recursivas**: Cada vez que una función es llamada, se asigna un nuevo bloque de memoria en el Stack con sus variables locales.
  
  * Cada vez que llamas a un método:
    * se crea un `stack frame`,
    * el programa “salta” a ese método,
    * al terminar, el **frame** se destruye automáticamente.

* **Manejo de variables locales**: Permite almacenar valores temporales usados dentro de funciones sin afectar otras partes del programa.

```java
void f(int x) {
    int y = x + 1; // x y y viven en el stack
}
```

* **Administración del flujo de ejecución**: Controla el seguimiento de las funciones activas mediante los registros de direcciones de retorno.

* **Optimización del acceso a datos**: La memoria **Stack** es extremadamente rápida, ya que opera en la **RAM** y su acceso es directo a través de registros del procesador.
  * El stack es:
    * contiguo en memoria,
    * pequeño,
    * administrado por punteros simple **avance/retroceso**.

## Características de la memoria Stack
* **Estructura `LIFO`**: El último elemento en ser agregado es el primero en ser eliminado **(Last In, First Out)**.

* **El tamaño del stack es limitado**
  * En la JVM suele ser:
    * `512 KB`
    * `1 MB`
    * `2 MB`
  * configurable con: **`-Xss`**

* **La recursión consume stack**
  * Cada llamada recursiva añade un frame.
  * Un algoritmo recursivo poco controlado → `StackOverflowError`.

* **Solo guarda PRIMITIVOS y REFERENCIAS**
```java
int x = 10;         // vive en stack
Person p = new Person(); // p vive en stack, el objeto vive en heap
```

* No almacena objetos, solo referencias
  * Muchos estudiantes se confunden con esto.

```java
List<Integer> list = new ArrayList<>();
```
  * `list` → referencia en stack
  * `ArrayList` → vive en **heap**
  * los elementos del array interno → también en **heap**

* **Almacenamiento temporal**: Se usa para datos de corta duración, como variables locales y direcciones de retorno.

* **Gestión automática**: No es necesario que el programador gestione manualmente la memoria Stack; se asigna y libera automáticamente cuando una función es llamada o finaliza.

* **Tamaño limitado**: La memoria Stack tiene un límite de tamaño fijo determinado por el sistema operativo, lo que puede causar errores como Stack Overflow si se excede.

* **Alto rendimiento**: Es más rápida que la memoria Heap debido a su organización estructurada y acceso directo.

## Cuál es su estructura?
Imagina una pila de cajas; cada llamada crea una nueva caja encima:
```bash
    +--------------------+
    | Frame de función C | ← ejecución actual (parte superior)
    +--------------------+
    | Frame de función B |
    +--------------------+
    | Frame de función A |
    +--------------------+
    |   ...              |
    +--------------------+
```
Cada **stack frame** contiene:
* **Dirección de retorno**
  * Dónde continuar cuando el método termine.

* **Parámetros del método**
  * Copias de los argumentos (recuerda: Java es **pass by value**).

* **Variables locales**
* Primitivos o referencias a objetos del `heap`.

* **Espacio para valores temporales**
  * Expresiones intermedias del compilador/JVM.

* **Datos de la JVM necesarios para ejecución**

## ¿Cómo funciona la memoria Stack?
Ejemplo de ejecución paso a paso

```java
public class StackExample {
    public static void main(String[] args) {
        int a = 10; 
        int b = 20;
        int result = sum(a, b);
        System.out.println("Resultado: " + result);
    }

    public static int sum(int x, int y) {
        int res = x + y;
        return res;
    }
}
```
### Paso a paso en la memoria Stack:
1. **Inicio del programa**
   * Se crea un **Stack Frame** para `main()`.

   * Se almacenan las variables locales `a` y `b`.

2. **Llamada a la función `sum()`**
   * Se crea un nuevo **Stack Frame** para `sum()`.

   * Se almacenan los parámetros `x` y `y`, `y` la variable `res`.

3. **Retorno de la función `sum()`**
   * Se elimina el **Stack Frame** de `sum()`.

   * Su valor de retorno se asigna a `result` en `main()`.

4. **Fin del programa**
   * Se elimina el **Stack Frame** de `main()`.

   * La memoria **Stack** queda vacía.

### Ejemplo visual
```java
int a = 5;

int r = f(a);

int f(int x) {
    int y = x * 2;
    return g(y);
}

int g(int z) {
    return z + 3;
}
```
**Stack** en ejecución durante la llamada a `g`:
```bash
+---------------------------+
| Frame g                   |
|  z = 10                   |
+---------------------------+
| Frame f                   |
|  x = 5, y = 10            |
+---------------------------+
| Frame main                |
|  a = 5, r (pendiente)     |
+---------------------------+
```

## Stack Overflow: el problema de sobrecarga de la pila
Cuando se excede la capacidad de la memoria Stack, ocurre un Stack Overflow, causando un error crítico en el programa.
```java
public class StackOverflowExample {
    public static void recurse() {
        recurse(); // Llamada recursiva infinita
    }

    public static void main(String[] args) {
        recurse();
    }
}
```
Este código genera un `StackOverflowError` porque la función `recurse()` nunca deja de llamarse a sí misma, llenando la pila de memoria.