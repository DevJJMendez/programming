# Stacks
Un Stack es una estructura de datos lineal que almacena elementos en orden secuencial y permite realizar operaciones solo en un extremo llamado tope (top).

**Principio LIFO:**
* El último elemento agregado es el primero en salir.

  * Similar a una pila de platos:
    * Agregar un plato: Se coloca en la parte superior.

    * Sacar un plato: Se toma desde la parte superior.

## ¿Para qué sirve un Stack?
Los stacks se usan en muchos escenarios informáticos, como:

* Gestión de llamadas en programación recursiva (Cada llamada se apila y se desapila al retornar).

* Deshacer/Rehacer en editores de texto (Cada acción se guarda en una pila).

* Evaluación de expresiones matemáticas (Expresiones postfijas o prefijas).

* Navegación en un navegador web (Historial de páginas visitadas).

## Estructura de un Stack
Un Stack se puede implementar con:
✔️ Arrays (Pila estática, tamaño fijo).
✔️ Listas Enlazadas (Pila dinámica, tamaño variable).

La estructura general de un Stack tiene:

Un puntero top que indica el elemento superior.
Operaciones principales:
push(valor): Agregar un elemento al tope.
pop(): Eliminar el elemento superior.
peek(): Ver el elemento superior sin eliminarlo.
isEmpty(): Verificar si la pila está vacía.

Ejemplo visual
```css
    [30] ← TOP  
    [20]  
    [10]  
    ------
```

## ¿Qué resuelve un Stack?
Los stacks resuelven problemas donde se requiere manejo de datos en orden inverso.
Por ejemplo:

* Recursión: Se usa para almacenar el estado de llamadas.

* Evaluación de expresiones: Convierte expresiones infijas a postfijas.

* Backtracking: Se usa en problemas como laberintos, Sudoku, etc.

## ¿Cómo se implementa un Stack en Java?
Implementación con Array
```java
class StackArray {
    private int top;
    private int maxSize;
    private int[] stack;

    public StackArray(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1; // Indica que la pila está vacía
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow!");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (top == -1) return -1;
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
```

Implementación con Lista Enlazada
```java
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackLinkedList {
    private Node top;

    public StackLinkedList() {
        this.top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        return (top == null) ? -1 : top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
```