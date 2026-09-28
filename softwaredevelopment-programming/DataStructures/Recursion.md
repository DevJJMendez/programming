# Recursion
La recursividad es una técnica de programación en la que una función se llama a sí misma para resolver un problema dividiéndolo en subproblemas más pequeños.

## ¿Para qué sirve?
Sirve para resolver problemas complejos de forma natural y elegante dividiéndolos en versiones más pequeñas del mismo problema.

**Casos de uso comunes:**
* Algoritmos de búsqueda y recorrido en árboles y grafos.

* Algoritmos de ordenamiento como QuickSort y MergeSort.

* Resolución de problemas matemáticos como factorial y Fibonacci.

* Implementación de backtracking, como resolver el problema de las Torres de Hanoi.

## ¿Cuáles son sus características?
* Debe tener una condición de parada (caso base) → Evita llamadas infinitas.

* Cada llamada recursiva se apoya en una versión más simple del problema.

* Utiliza la memoria Stack → Cada llamada recursiva se almacena en la pila de ejecución.

* Puede ser menos eficiente que la iteración si no se optimiza.

## ¿Cuál es su estructura?
La estructura de una función recursiva sigue dos partes esenciales:

1. **Caso base** → Define cuándo la función deja de llamarse a sí misma.

2. **Caso recursivo** → La función se llama a sí misma con un problema más pequeño.

**Ejemplo genérico de estructura recursiva**:
```java
public int funcionRecursiva(int parametro) {
    if (condicionBase) { // Caso base
        return valorBase;
    }
    return funcionRecursiva(nuevoParametro); // Caso recursivo
}
```

## ¿Qué resuelve?
* Permite resolver problemas que tienen una estructura natural recursiva.

* Es útil en problemas donde es difícil mantener un estado intermedio con bucles iterativos.

* Simplifica problemas en estructuras de datos jerárquicas como árboles y grafos.

## ¿Cómo lo resuelve?
1. Divide el problema en partes más pequeñas → Cada llamada recursiva trabaja con una versión más simple del problema.

2. Cada llamada se apila en la memoria Stack → Al llegar al caso base, se empiezan a resolver las llamadas en orden inverso.

3. El resultado final se obtiene tras combinar las soluciones parciales.

### Ejemplos prácticos en Java
**Ejemplo 1: Factorial de un número** 📌 Definición matemática: n!=n×(n−1)! con 0!=1
```java
public class FactorialRecursivo {
    public static int factorial(int n) {
        if (n == 0) { // Caso base
            return 1;
        }
        return n * factorial(n - 1); // Caso recursivo
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 5! = 5*4*3*2*1 = 120
    }
}
```
* Caso base: n == 0, retorna 1.

* Caso recursivo: n * factorial(n-1).

Ejemplo 2: Fibonacci 📌 Definición matemática: F(n)=F(n−1)+F(n−2)conF(0)=0,F(1)=1
```java
public class FibonacciRecursivo {
    public static int fibonacci(int n) {
        if (n == 0) return 0; // Caso base 1
        if (n == 1) return 1; // Caso base 2
        return fibonacci(n - 1) + fibonacci(n - 2); // Caso recursivo
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6)); // 0,1,1,2,3,5,8 → Salida: 8
    }
}
```
* Problema: La versión básica es ineficiente debido a múltiples llamadas repetidas.

* Optimización: Usar memoización o programación dinámica para mejorar el rendimiento.

Ejemplo 3: Recorrer un árbol binario 📌 En estructuras de datos jerárquicas, como árboles, la recursión es natural.
```java
class Nodo {
    int valor;
    Nodo izquierda, derecha;

    public Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
}

public class RecorridoArbol {
    public static void preorden(Nodo nodo) {
        if (nodo == null) return; // Caso base
        System.out.print(nodo.valor + " "); // Visitar nodo
        preorden(nodo.izquierda); // Recorrer subárbol izquierdo
        preorden(nodo.derecha);   // Recorrer subárbol derecho
    }

    public static void main(String[] args) {
        Nodo raiz = new Nodo(1);
        raiz.izquierda = new Nodo(2);
        raiz.derecha = new Nodo(3);
        raiz.izquierda.izquierda = new Nodo(4);
        raiz.izquierda.derecha = new Nodo(5);

        preorden(raiz); // Salida: 1 2 4 5 3
    }
}
```
Explicación:
1️⃣ Visitamos el nodo raíz.
2️⃣ Llamamos recursivamente al subárbol izquierdo.
3️⃣ Llamamos recursivamente al subárbol derecho.

## Optimización de la Recursividad
🔹 Recursión de cola (Tail Recursion):

Es una forma de recursión en la que la llamada recursiva es la última operación que se ejecuta.
Permite que algunos compiladores optimicen la memoria, convirtiéndolo en un simple bucle.
🔹 Memoización:

Almacena los resultados de llamadas previas para evitar cálculos repetitivos.
Es útil en problemas como Fibonacci, donde hay muchas llamadas duplicadas.
🔹 Conversión a Iteración:

A veces es mejor transformar una recursión en un bucle while o for para evitar desbordamiento de pila.