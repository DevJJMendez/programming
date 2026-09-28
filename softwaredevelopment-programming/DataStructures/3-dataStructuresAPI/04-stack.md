# `Stack`
La clase Stack en Java es una estructura de datos que sigue el principio LIFO (Last In, First Out). Es una implementación que permite almacenar objetos de manera que el último elemento agregado sea el primero en ser retirado. Forma parte del paquete java.util y está basada en la clase Vector, por lo que hereda varias de sus características, incluyendo la capacidad de redimensionarse automáticamente y la sincronización.

## ¿Qué es la clase Stack?
Stack es una colección genérica que permite almacenar elementos en una pila (stack), donde los elementos se agregan (o apilan) y se eliminan (o desapilan) desde el mismo extremo, conocido como la cima (top). Es una subclase de Vector, por lo que también es una colección sincronizada, asegurando que se pueda usar de manera segura en entornos multi-hilo.

## ¿Para qué sirve la clase Stack?
La clase Stack se utiliza cuando necesitas:

1. **Gestionar datos de forma LIFO**: Es útil para almacenar y manejar datos que se necesitan procesar en el orden inverso al que fueron ingresados. Algunos ejemplos comunes incluyen:
   
   * Procesamiento de expresiones matemáticas (por ejemplo, para evaluar expresiones en notación postfija).

   * Control de llamadas a funciones en una aplicación recursiva.

   * Deshacer y rehacer acciones en una aplicación (como en un editor de texto).

2. Almacenar datos temporalmente hasta que se necesiten en el orden inverso de inserción.

## ¿Qué resuelve la clase Stack?
La clase Stack resuelve varios problemas en la programación que requieren gestionar el orden de entrada y salida de datos de manera inversa:

1. **Control de flujo en aplicaciones recursivas**: Cuando se utiliza recursión, cada llamada a una función se apila en una estructura de tipo Stack para llevar un registro de dónde debe regresar el flujo de control una vez que se complete la función.

2. **Algoritmos de procesamiento de datos**: Como el análisis de expresiones matemáticas o el recorrido de estructuras de datos como árboles binarios.

3. **Funcionalidades de deshacer y rehacer**: Implementar un sistema que permita deshacer la última acción realizada por el usuario (como en editores de texto) puede lograrse fácilmente usando una pila.

## ¿Cómo lo resuelve la clase Stack?
1. **Operaciones básicas**: La clase Stack proporciona métodos específicos para manejar los elementos de manera LIFO. Los métodos más importantes son:

* `push(E item)`: Añade un elemento a la cima de la pila.

* `pop()`: Remueve y devuelve el elemento en la cima de la pila.

* `peek()`: Devuelve el elemento en la cima de la pila sin removerlo.

* `empty()`: Verifica si la pila está vacía.

* `search(Object o)`: Busca el objeto en la pila y devuelve su posición.

2. **Añadir elementos (`push`)**
```java
books.push("Java Programming");
books.push("Data Structures");
```

3. **Acceder y remover el elemento en la cima (`pop`)**
```java
String lastBook = books.pop(); // Remueve y devuelve "Data Structures"
```

4. **Ver el elemento en la cima sin removerlo (`peek`)**
```java
String topBook = books.peek(); // Devuelve "Java Programming"
```

5. **Verificar si la pila está vacía (`empty`)**
```java
boolean isEmpty = books.empty(); // Devuelve `false` si hay elementos
```

6. **Buscar un elemento en la pila (`search`)**
```java
int position = books.search("Java Programming"); // Devuelve 1 (posición desde la cima)
```

## Ventajas del uso de Stack
1. **Simplicidad**: Es fácil de entender y usar para gestionar datos de manera LIFO.

2. **Redimensionamiento dinámico**: No es necesario definir un tamaño fijo, ya que crece automáticamente.

3. **Sincronización**: Los métodos están sincronizados, por lo que puede ser usado de manera segura en entornos multi-hilo sin problemas de concurrencia.

## Desventajas del uso de Stack
1. **Rendimiento más lento debido a la sincronización**: Debido a la sincronización automática, Stack puede ser menos eficiente que otras estructuras de datos LIFO no sincronizadas, especialmente en entornos de un solo hilo.

2. **Interfaz obsoleta**: Stack ha sido desplazado por otras colecciones más modernas y eficientes para manejar LIFO, como `Deque` (implementaciones como `ArrayDeque` y `LinkedList`).

## ¿Cuándo usar Stack?
Usa Stack cuando necesites una pila sincronizada para asegurar que múltiples hilos puedan trabajar con la misma estructura de datos sin causar problemas de concurrencia. Sin embargo, en la mayoría de los casos modernos, es preferible optar por Deque u otras estructuras de datos más eficientes para manejar operaciones LIFO, especialmente si no necesitas sincronización.