# Queue
Una Queue (Cola) es una estructura de datos FIFO (First In, First Out), lo que significa que el primer elemento que entra es el primero en salir.

**Ejemplo de una Cola en la vida real**: Imagina una fila en un banco. La persona que llega primero es atendida primero, y los que llegan después deben esperar su turno.

**Representación de una Queue:**
```css
[FRENTE] 10 <- 20 <- 30 <- 40 <- 50 [FINAL]
```
* Encolamiento (enqueue): Agrega un elemento al final.

* Desencolamiento (dequeue): Remueve el elemento del frente.

## ¿Para qué sirve una Queue?
Las colas son útiles cuando los datos deben procesarse en orden secuencial, manteniendo una estructura de prioridad FIFO.

**Casos de uso en la vida real**:
* Sistemas operativos: Manejo de procesos en cola (planificación Round Robin).

* Colas de impresión: Los documentos se imprimen en el orden en que fueron enviados.

* Manejo de eventos en juegos o GUI: Procesamiento de eventos en orden de llegada.

* Sistemas de mensajería: Ejemplo, colas de mensajes en RabbitMQ o Kafka.

## Estructura de una Queue
Un nodo en una cola contiene:

1. Dato (valor almacenado).

2. Puntero al siguiente nodo (para saber qué sigue).

```java
class Nodo {
    int dato;
    Nodo next;

    public Nodo(int dato) {
        this.dato = dato;
        this.next = null;
    }
}
```
 Se declaran dos variables de tipo Nodo:

frente (front): Apunta al primer elemento de la cola.
finalCola (rear): Apunta al último elemento de la cola.
📌 ¿Por qué se necesitan dos punteros?

frente nos permite eliminar elementos del frente de la cola (FIFO).
finalCola nos permite agregar elementos al final de la cola de manera eficiente (O(1)).

Estructura general de una Queue:
```java
class Queue {
    Nodo frente, finalCola; // Punteros al primer y último elemento

    public Queue() {
        this.frente = this.finalCola = null;
    }
}
```
**Se define un constructor que inicializa `frente` y `finalCola` en `null`.**
   * Esto significa que la cola inicia vacía, sin elementos.

   * Cuando se agregue el primer elemento, frente y finalCola apuntarán al mismo nodo.

## ¿Qué problemas resuelve una Queue?
* Evita el acceso aleatorio, manteniendo el orden de llegada.

* Eficiencia en procesamiento de datos en flujo continuo.

* Evita bloqueos al gestionar tareas en sistemas concurrentes.

## Implementación
Implementación con Lista Enlazada
```java
class Queue {
    Nodo frente, finalCola;

    public Queue() {
        this.frente = this.finalCola = null;
    }

    // Método para agregar (enqueue)
    public void enqueue(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (finalCola == null) { 
            frente = finalCola = nuevo;
            return;
        }
        finalCola.next = nuevo;
        finalCola = nuevo;
    }

    // Método para remover (dequeue)
    public int dequeue() {
        if (frente == null) throw new IllegalStateException("La cola está vacía");
        
        int dato = frente.dato;
        frente = frente.next;

        if (frente == null) finalCola = null; // Si la cola queda vacía
        return dato;
    }

    // Método para imprimir la cola
    public void imprimir() {
        Nodo temp = frente;
        while (temp != null) {
            System.out.print(temp.dato + " <- ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Queue cola = new Queue();
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.imprimir(); // 10 <- 20 <- 30 <- NULL
        System.out.println("Elemento eliminado: " + cola.dequeue()); 
        cola.imprimir(); // 20 <- 30 <- NULL
    }
}
```
Salida esperada:
```yaml
10 <- 20 <- 30 <- NULL
Elemento eliminado: 10
20 <- 30 <- NULL
```
**Complejidad**:
* Enqueue: O(1) (agrega al final).

* Dequeue: O(1) (elimina del frente).

Implementación con Array (Arreglo) Definición de Queue usando un array con capacidad fija:
```java
class ArrayQueue {
    int arr[];
    int frente, finalCola, capacidad;

    public ArrayQueue(int tamaño) {
        capacidad = tamaño;
        arr = new int[tamaño];
        frente = finalCola = -1;
    }

    // Método para agregar (enqueue)
    public void enqueue(int dato) {
        if (finalCola == capacidad - 1) throw new IllegalStateException("Cola llena");
        if (frente == -1) frente = 0;
        arr[++finalCola] = dato;
    }

    // Método para remover (dequeue)
    public int dequeue() {
        if (frente == -1 || frente > finalCola) throw new IllegalStateException("Cola vacía");
        return arr[frente++];
    }

    // Método para imprimir la cola
    public void imprimir() {
        if (frente == -1 || frente > finalCola) {
            System.out.println("Cola vacía");
            return;
        }
        for (int i = frente; i <= finalCola; i++) {
            System.out.print(arr[i] + " <- ");
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ArrayQueue cola = new ArrayQueue(5);
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.imprimir(); // 10 <- 20 <- 30 <- NULL
        System.out.println("Elemento eliminado: " + cola.dequeue());
        cola.imprimir(); // 20 <- 30 <- NULL
    }
}
```
Salida esperada:
```yaml
10 <- 20 <- 30 <- NULL
Elemento eliminado: 10
20 <- 30 <- NULL
```
Complejidad:
* Enqueue: O(1)
* Dequeue: O(1)

Desventaja: El array es estático y puede llenarse.

## Tipos de Queue
* Cola simple: FIFO básico.

* Cola circular: El último elemento se conecta con el primero para reutilizar espacio.

* Cola de prioridad: Los elementos con mayor prioridad salen primero (ejemplo: planificación de CPU).

* Cola de doble extremo (Deque - Double-ended Queue): Se puede agregar o eliminar por ambos extremos.

Ejemplo de una Cola Circular en Java:
```java
class CircularQueue {
    int arr[], frente, finalCola, capacidad, tamaño;

    public CircularQueue(int capacidad) {
        this.capacidad = capacidad;
        arr = new int[capacidad];
        frente = finalCola = -1;
        tamaño = 0;
    }

    // Método para agregar (enqueue)
    public void enqueue(int dato) {
        if (tamaño == capacidad) throw new IllegalStateException("Cola llena");
        if (frente == -1) frente = 0;
        finalCola = (finalCola + 1) % capacidad;
        arr[finalCola] = dato;
        tamaño++;
    }

    // Método para remover (dequeue)
    public int dequeue() {
        if (tamaño == 0) throw new IllegalStateException("Cola vacía");
        int dato = arr[frente];
        frente = (frente + 1) % capacidad;
        tamaño--;
        return dato;
    }
}
```
Evita el desperdicio de espacio cuando se usa un array fijo.

# `Queue`
La interfaz Queue en Java forma parte del paquete java.util y representa una colección que sigue la estructura de datos conocida como FIFO (First In, First Out), es decir, el primer elemento en ser añadido es el primero en ser eliminado. Queue es una interfaz que define los métodos que deben implementarse para manejar esta estructura, pero no proporciona una implementación concreta. Algunas clases que implementan Queue incluyen LinkedList, PriorityQueue, ArrayDeque, y más.

## ¿Para qué sirve Queue?
Queue es útil para manejar escenarios donde se necesita procesar elementos en el orden en que se agregan. Algunos casos de uso típicos son:

1. Colas de tareas o trabajos: En sistemas de procesamiento de trabajos donde las tareas deben ejecutarse en el orden en que se reciben.

2. Sistemas de mensajería: Para manejar mensajes de forma secuencial.

3. Impresoras: Las colas de impresión siguen el orden FIFO para imprimir documentos.

4. Aplicaciones de caché y buffers: Para almacenar temporalmente datos en el orden en que se deben consumir.

## ¿Qué resuelve Queue?
Queue resuelve el problema de gestionar datos en orden secuencial y facilita el manejo de datos que requieren ser procesados en el mismo orden en que se ingresaron. Proporciona una forma eficiente de manejar flujos de datos que necesitan ser procesados uno tras otro. Además, ofrece métodos para manejar los extremos de la cola sin necesidad de recorrer todos los elementos, mejorando la eficiencia.

1. Procesamiento en orden: Asegura que las operaciones de inserción y eliminación se realicen en un orden predecible.

2. Optimización del acceso: Los métodos para añadir y eliminar elementos están optimizados para trabajar solo en los extremos de la cola, lo que mejora la eficiencia.

## ¿Cómo lo resuelve Queue?
La interfaz Queue define una serie de métodos que las clases implementan para gestionar el acceso y manipulación de elementos siguiendo el comportamiento FIFO. Algunos de los métodos principales incluyen:

1. **`add(E e)`**: Inserta un elemento al final de la cola. Lanza una excepción si la operación falla.

2. **`offer(E e)`**: Similar a add, pero devuelve false si la operación falla en lugar de lanzar una excepción.

3. **`poll()`**: Recupera y elimina el primer elemento de la cola, devolviendo null si la cola está vacía.

4. **`remove()`**: Elimina el primer elemento de la cola, lanzando una excepción si está vacía.

5. **`peek()`**: Recupera el primer elemento de la cola sin eliminarlo, devolviendo null si la cola está vacía.

6. **`element()`**: Similar a **`peek()`**, pero lanza una excepción si la cola está vacía.

## Ejemplo de uso
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Crear una Queue usando LinkedList
        Queue<String> queue = new LinkedList<>();
        
        // Agregar elementos a la cola
        queue.add("Primer");
        queue.offer("Segundo");
        queue.offer("Tercero");
        
        // Obtener el primer elemento sin eliminarlo
        System.out.println("Elemento en el frente: " + queue.peek());
        
        // Eliminar elementos de la cola
        System.out.println("Eliminando: " + queue.poll());
        System.out.println("Eliminando: " + queue.remove());

        // Ver el estado actual de la cola
        System.out.println("Cola después de eliminar: " + queue);
    }
}
```

## Tipos de Implementaciones de Queue
Existen varias clases que implementan la interfaz Queue, cada una con características y comportamientos específicos:

1. `LinkedList`: Implementa tanto la interfaz List como Queue, y se utiliza cuando se necesita una implementación simple de una cola FIFO.

2. `PriorityQueue`: Es una cola que no sigue estrictamente el orden FIFO. Los elementos se ordenan de acuerdo a su orden natural o un comparador personalizado. Es útil para escenarios donde se requiere priorizar ciertos elementos.

3. `ArrayDeque`: Proporciona una implementación eficiente de Queue que se puede utilizar tanto como una cola FIFO (Queue) o como una pila LIFO (Deque). Es más rápida que LinkedList en muchas operaciones.

4. `ConcurrentLinkedQueue`: Una implementación segura para entornos concurrentes. Es útil para aplicaciones multihilo donde múltiples hilos pueden acceder a la cola simultáneamente.