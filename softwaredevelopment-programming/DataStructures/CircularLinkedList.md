# Circular Linked List
Una Lista Enlazada Circular es una variación de las listas enlazadas donde el último nodo se conecta al primero, formando un ciclo.

Puede ser:
1. Circular Simply Linked List (lista simplemente enlazada circular):
   * Cada nodo apunta al siguiente, y el último nodo apunta al primer nodo.

2. Circular Doubly Linked List (lista doblemente enlazada circular):
   * Cada nodo apunta al siguiente y al anterior, formando un ciclo en ambas direcciones.

Ejemplo visual de una Lista Simplemente Enlazada Circular:
```css
[10] → [20] → [30] → [40] → (vuelve a [10])
```

Ejemplo visual de una Lista Doblemente Enlazada Circular:
```css
[10] ↔ [20] ↔ [30] ↔ [40] ↺ (vuelve a [10])
```

## ¿Para qué sirven las Listas Enlazadas Circulares?
Las listas circulares son útiles cuando se necesita un acceso cíclico a los datos, como en estructuras donde los elementos se reutilizan de manera continua.

**Casos de uso en la vida real**:
* Sistemas operativos: Algoritmos de planificación de procesos (Round Robin).

* Juegos: Gestión de turnos de jugadores.

* Reproductores de música: Listas de reproducción en bucle.

* Buffers circulares: Para manejar datos en streaming.

## Estructura de una Circular Linked List
Un nodo de una lista circular contiene:

1. Dato (información almacenada).

2. Puntero al siguiente nodo (next).

3. (Opcional en listas doblemente enlazadas: Puntero al nodo anterior (prev)).

**Ejemplo en Java - Nodo de Lista Circular:**
```java
class Nodo {
    int dato;
    Nodo next;  // Puntero al siguiente nodo

    public Nodo(int dato) {
        this.dato = dato;
        this.next = null;
    }
}
```

Ejemplo en Java - Nodo de Lista Doblemente Circular:
```java
class Nodo {
    int dato;
    Nodo next, prev;

    public Nodo(int dato) {
        this.dato = dato;
        this.next = this.prev = null;
    }
}
```

## ¿Qué problemas resuelve una Circular Linked List?
* Evita nodos nulos, ya que siempre se puede recorrer de manera circular.

* Reutilización eficiente de datos, útil en ciclos o buffers.

* Mayor eficiencia en algunos casos, ya que no hay que manejar condiciones de inicio/fin.

## ¿Cómo se implementa una Circular Linked List?
1. Implementación de Circular Simply Linked List en Java
```java
class CircularLinkedList {
    Nodo cabeza = null;
    Nodo cola = null;

    // Método para agregar un nodo al final
    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cola.next = cabeza; // Se conecta al primer nodo
        } else {
            cola.next = nuevo;
            cola = nuevo;
            cola.next = cabeza; // Se cierra el ciclo
        }
    }

    // Método para imprimir la lista
    public void imprimir() {
        if (cabeza == null) return;

        Nodo temp = cabeza;
        do {
            System.out.print(temp.dato + " → ");
            temp = temp.next;
        } while (temp != cabeza);
        System.out.println("(vuelve a " + cabeza.dato + ")");
    }

    public static void main(String[] args) {
        CircularLinkedList lista = new CircularLinkedList();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(40);
        lista.imprimir();
    }
}
```
Salida
```css
10 → 20 → 30 → 40 → (vuelve a 10)
```

2. Implementación de Circular Doubly Linked List en Java
```java
class CircularDoublyLinkedList {
    Nodo cabeza = null;

    // Método para agregar un nodo al final
    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.next = cabeza;
            cabeza.prev = cabeza;
        } else {
            Nodo ultimo = cabeza.prev;
            nuevo.next = cabeza;
            nuevo.prev = ultimo;
            ultimo.next = nuevo;
            cabeza.prev = nuevo;
        }
    }

    // Método para imprimir la lista
    public void imprimir() {
        if (cabeza == null) return;

        Nodo temp = cabeza;
        do {
            System.out.print(temp.dato + " ↔ ");
            temp = temp.next;
        } while (temp != cabeza);
        System.out.println("(vuelve a " + cabeza.dato + ")");
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList lista = new CircularDoublyLinkedList();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(40);
        lista.imprimir();
    }
}
```
Salida esperada:
```css
10 ↔ 20 ↔ 30 ↔ 40 ↔ (vuelve a 10)
```