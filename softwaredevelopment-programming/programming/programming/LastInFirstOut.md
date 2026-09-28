# Last In, First Out
La estructura LIFO (Last In, First Out - Último en Entrar, Primero en Salir) es un principio fundamental en informática y estructuras de datos. Se basa en que el último elemento agregado es el primero en ser retirado, como ocurre con una pila de platos apilados en una cocina.

## ¿Qué es LIFO?
LIFO es una estrategia de organización y acceso a datos donde el último elemento ingresado es el primero en salir.

* Ejemplo del mundo real: Imagina una pila de libros. Si colocas un libro nuevo encima, será el primero en ser retirado antes que los demás.

* Ejemplo en programación: La memoria Stack sigue el principio LIFO. Cuando una función se ejecuta, se coloca en la parte superior del Stack y es eliminada cuando finaliza.

## ¿Para qué sirve LIFO?
LIFO es útil en situaciones donde el orden de los elementos importa y se necesita que el último elemento agregado sea procesado primero. Algunos usos comunes incluyen:

* Gestión de memoria (Stack): Almacena variables locales y direcciones de retorno en lenguajes como Java, C, C++.

* Control de llamadas a funciones: Manejo de recursión y ejecución de funciones mediante la memoria Stack.

* Estructuras de datos (Pilas): Implementación de algoritmos como backtracking, deshacer/rehacer en editores de texto.

* Evaluación de expresiones: Parsing de expresiones matemáticas y lenguajes de 

## ¿Cuál es su estructura?
LIFO se implementa comúnmente con pilas (`stacks`), que pueden ser:

* **Pilas estáticas**: Tamaño fijo, implementadas con arreglos.

* **Pilas dinámicas**: Tamaño variable, implementadas con listas enlazadas.

![lifo](images/lifo.jpg)

### Operaciones principales de una pila (LIFO):
| Operación      | Descripción                                                    |
| -------------- | -------------------------------------------------------------- |
| Push(x)        | Agrega un elemento x a la pila (al tope).                      |
| Pop()          | Elimina el último elemento agregado (el de la cima).           |
| Peek() / Top() | Devuelve el último elemento sin eliminarlo.                    |
| isEmpty()      | Verifica si la pila está vacía.                                |
| isFull()       | Verifica si la pila está llena (en caso de una pila estática). |

Ejemplo visual de operaciones en una pila:
* **`Push(10) → [10]`**
* **`Push(20) → [10, 20]`**
* **`Push(30) → [10, 20, 30]`**
* **`Pop() → [10, 20]` (Se elimina 30)**

## Características de LIFO
* Último en entrar, primero en salir (Last In, First Out): Siempre se elimina el último elemento agregado antes que los demás.

* Acceso controlado: Solo se puede acceder al elemento en la cima de la pila (no permite acceso aleatorio).

* Eficiente en memoria y procesamiento: Operaciones Push y Pop se ejecutan en O(1), lo que lo hace rápido.

* Uso en memoria Stack: Funciones y variables locales usan LIFO en la gestión de la pila del sistema.

* Reversibilidad: Útil en algoritmos donde se necesita revertir una secuencia de operaciones.

## ¿Qué problemas resuelve LIFO?
LIFO se usa en varias aplicaciones para resolver problemas donde el orden de procesamiento es crucial:

* Recursión: Manejo eficiente de llamadas recursivas sin pérdida de datos.

* Backtracking (retroceso en algoritmos): Como en búsqueda en profundidad (DFS), resolver laberintos, Sudoku, etc.

* Deshacer/rehacer en editores de texto: Almacena las últimas acciones realizadas y permite revertirlas en orden inverso.

* Evaluación de expresiones matemáticas: Parsing de expresiones infijas a posfijas, como en calculadoras y compiladores.

* Historial de navegación en navegadores: Cuando retrocedes en páginas visitadas, el navegador usa una pila.

## ¿Cómo lo resuelve?
LIFO resuelve estos problemas mediante su estructura y operaciones eficientes:

✅ Ejemplo 1: Implementación de una pila en Java
```java
import java.util.Stack;

public class LifoExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10); // Agregar 10
        stack.push(20); // Agregar 20
        stack.push(30); // Agregar 30

        System.out.println("Pila actual: " + stack);
        
        int topElement = stack.pop(); // Eliminar el último elemento agregado (30)
        System.out.println("Elemento eliminado: " + topElement);
        System.out.println("Pila después de Pop: " + stack);
    }
}
```
Salida
```bash
Pila actual: [10, 20, 30]  
Elemento eliminado: 30  
Pila después de Pop: [10, 20]  
```

✅ Ejemplo 2: Simulación de deshacer/rehacer con una pila
```java
import java.util.Stack;

public class UndoRedoExample {
    public static void main(String[] args) {
        Stack<String> undoStack = new Stack<>();
        Stack<String> redoStack = new Stack<>();

        undoStack.push("Acción 1");
        undoStack.push("Acción 2");
        undoStack.push("Acción 3");

        System.out.println("Acciones: " + undoStack);

        // Deshacer acción
        String lastAction = undoStack.pop();
        redoStack.push(lastAction);
        System.out.println("Después de deshacer: " + undoStack);

        // Rehacer acción
        String redoAction = redoStack.pop();
        undoStack.push(redoAction);
        System.out.println("Después de rehacer: " + undoStack);
    }
}
```
Salida
```bash
Acciones: [Acción 1, Acción 2, Acción 3]  
Después de deshacer: [Acción 1, Acción 2]  
Después de rehacer: [Acción 1, Acción 2, Acción 3]  
```

✅ Ejemplo 3: Invertir una cadena usando una pila (LIFO)
```java
public class ReverseString {
    public static void main(String[] args) {
        String input = "LIFO";
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println("Cadena original: " + input);
        System.out.println("Cadena invertida: " + reversed);
    }
}
```
Salida
```bash
Cadena original: LIFO  
Cadena invertida: OFIL  
```