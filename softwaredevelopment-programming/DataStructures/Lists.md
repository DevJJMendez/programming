# List
Una lista es una colección ordenada de elementos donde podemos agregar, eliminar y acceder a los datos de manera eficiente.

A diferencia de los arrays, que tienen un tamaño fijo, las listas pueden cambiar de tamaño dinámicamente.

**Ejemplo conceptual**: Una lista es como una fila de clientes en un banco. Los clientes pueden llegar, irse o cambiar de posición sin problemas.

## ¿Para qué sirven las Listas?
Las listas son utilizadas para gestionar conjuntos de datos donde el número de elementos es variable.

* Facilitan el almacenamiento dinámico de datos sin preocuparse por el tamaño.

* Permiten agregar y eliminar elementos fácilmente sin necesidad de reestructurar la memoria.

* Son fundamentales para muchas estructuras de datos avanzadas como pilas, colas y grafos.

**Casos de uso en la vida real**:
* Lista de tareas en una aplicación de productividad.

* Historial de navegación en un navegador web.

* Mensajes en un chat de una aplicación móvil.

* Carrito de compras en un e-commerce.

## ¿Cuál es su estructura?
Existen dos tipos principales de listas en programación:

### 1. Listas Enlazadas (Linked Lists)
   * Cada elemento (nodo) de la lista contiene:
     1. Un valor (los datos que almacena).

     2. Una referencia (puntero) al siguiente nodo en la lista.

   * Ejemplo de una lista enlazada en memoria:
```css
[10] -> [20] -> [30] -> [40] -> null
```
Cada nodo almacena un valor y una referencia al siguiente nodo.

**Tipos de listas enlazadas**
* Lista simplemente enlazada: Cada nodo apunta al siguiente.

* Lista doblemente enlazada: Cada nodo apunta al anterior y al siguiente.

* Lista circular: El último nodo apunta de nuevo al primero.

### Listas Dinámicas (ArrayList, List en Python, etc.)
* Son implementaciones más avanzadas que manejan automáticamente la memoria.

* Son utilizadas cuando se necesita flexibilidad con operaciones eficientes de acceso aleatorio.

* Son una alternativa a los arrays tradicionales en lenguajes como Java y C#.

## ¿Qué resuelven las Listas?
Las listas resuelven problemas donde necesitamos manejar colecciones de datos con tamaño dinámico.

* Evitan la limitación de los arrays (que tienen tamaño fijo).

* Permiten insertar y eliminar elementos sin necesidad de desplazar datos.

* Facilitan la implementación de estructuras más complejas como pilas y colas.

**Ejemplo de problema resuelto:**
* **Imagina que desarrollas una aplicación de chat donde los mensajes deben guardarse en una lista. Si usáramos un array, tendríamos que definir un tamaño máximo desde el inicio, lo que es ineficiente.
Con una lista, podemos almacenar los mensajes dinámicamente y agregar más sin preocuparnos por un límite predefinido.**

## ¿Cómo lo resuelven?
Las listas resuelven estos problemas a través de sus diferentes implementaciones:

* Con listas enlazadas:
  * Los elementos se almacenan en nodos separados en memoria.

  * Se pueden agregar y eliminar elementos sin desplazar otros.

* Con listas dinámicas:
  * Se almacena en un array interno, pero crece automáticamente según sea necesario.

  * Permite acceso rápido a los elementos mediante índices.

# `ArrayList`
La clase `ArrayList` en Java es parte del paquete java.util y es una implementación de la interfaz `List`. Es una estructura de datos dinámica que permite almacenar una lista de elementos, similar a un array, pero con la capacidad de ajustar su tamaño automáticamente a medida que se agregan o eliminan elementos. Esto la convierte en una opción flexible y fácil de usar cuando se necesita trabajar con una colección de elementos cuyo tamaño no es fijo.

## ¿Qué es la clase ArrayList?
ArrayList es una estructura de datos basada en arrays que se puede redimensionar automáticamente. Almacena elementos de forma secuencial y permite acceder a ellos de manera eficiente usando índices. A diferencia de los arrays normales en Java, que tienen un tamaño fijo, el ArrayList puede crecer o reducirse dinámicamente según se agreguen o eliminen elementos.

## ¿Para qué sirve la clase ArrayList?
La clase ArrayList se utiliza cuando necesitas:

1. **Una colección** dinámica de elementos donde el tamaño puede cambiar durante la ejecución del programa.

2. **Acceso rápido** a los elementos por su índice, similar a cómo se accedería a un array.

3. **Agregar o eliminar elementos** sin tener que preocuparte por el manejo manual del tamaño del array.

4. **Manejar colecciones heterogéneas** de objetos (pero deben ser objetos, no tipos primitivos).

## ¿Qué resuelve la clase ArrayList?
ArrayList soluciona varios problemas que los arrays normales presentan:

1. **Limitaciones de tamaño fijo**: Con los arrays, debes especificar el tamaño al momento de la creación. ArrayList elimina esta limitación al redimensionarse automáticamente.

2. **Inserción y eliminación complejas**: Manipular arrays para agregar o eliminar elementos puede ser tedioso y propenso a errores. ArrayList simplifica estas operaciones.

3. **Gestión manual del tamaño**: No necesitas preocuparte por la gestión del tamaño o la copia manual de datos. El ArrayList maneja todo esto internamente.

## ¿Cómo lo resuelve la clase ArrayList?
Internamente, ArrayList utiliza un array de objetos que se expande automáticamente cuando se alcanza su capacidad. Cuando se agrega un nuevo elemento y no hay espacio disponible, ArrayList:

1. Crea un nuevo array con mayor capacidad (generalmente, el doble del tamaño actual).

2. Copia los elementos del array antiguo al nuevo.

3. Añade el nuevo elemento.

Este mecanismo asegura que el proceso de agregar elementos siga siendo eficiente.

## Métodos importantes de la clase ArrayList
1. **Crear un `ArrayList`**
```java
ArrayList<String> names = new ArrayList<>();
```
También se puede especificar una capacidad inicial para optimizar el rendimiento si se sabe cuántos elementos se van a añadir:
```java
ArrayList<String> names = new ArrayList<>(100); // Capacidad inicial de 100 elementos
```

2. **Agregar elementos (`add`)**
```java
names.add("Alice");
names.add("Bob");
```
También puedes agregar un elemento en una posición específica:
```java
names.add(1, "Charlie"); // Añade "Charlie" en el índice 1
```

3. **Acceder a elementos (`get`)**
```java
String name = names.get(0); // Devuelve "Alice"
```

4. **Modificar elementos (`set`)**
```java
names.set(1, "David"); // Cambia "Bob" a "David"
```

5. **Eliminar elementos (`remove`)**
```java
names.remove(1); // Elimina el elemento en el índice 1 ("David")  
```
También puedes eliminar por el valor:
```java
names.remove("Alice"); // Elimina "Alice" si está presente
```

6. **Obtener el tamaño (`size`)**
```java
int size = names.size(); // Devuelve el número de elementos en el `ArrayList`
```

7. **Verificar si contiene un elemento (`contains`)**
```java
boolean exists = names.contains("Alice"); // Devuelve `true` si "Alice" está en la lista
```

8. **Limpiar el ArrayList (`clear`)**
```java
names.clear(); // Elimina todos los elementos del `ArrayList`
```

9. **Convertir a array (`toArray`)**
```java
String[] namesArray = names.toArray(new String[0]);
```

# `LinkedList`
La clase LinkedList en Java es parte del paquete java.util y es una implementación de la interfaz List y Deque. Es una estructura de datos dinámica que permite almacenar una lista de elementos que están conectados entre sí mediante nodos. A diferencia de los arrays y ArrayList, que almacenan elementos en bloques contiguos de memoria, LinkedList almacena elementos como una secuencia de nodos donde cada nodo apunta al siguiente (y en algunos casos, también al anterior). Esto proporciona ciertas ventajas en términos de inserción y eliminación de elementos, pero puede ser menos eficiente para el acceso aleatorio.

## ¿Qué es la clase LinkedList?
LinkedList es una estructura de datos que utiliza nodos para almacenar elementos. Cada nodo contiene dos partes:

1. El valor del elemento.

2. Una referencia (puntero) al siguiente nodo (y en el caso de una lista doblemente enlazada, una referencia al nodo anterior).

La clase LinkedList en Java representa una lista doblemente enlazada. Esto significa que cada nodo no solo tiene un puntero al siguiente nodo, sino también un puntero al nodo anterior, lo que permite recorrer la lista en ambas direcciones.

## ¿Para qué sirve la clase LinkedList?
La clase LinkedList se utiliza cuando necesitas:

1. Agregar y eliminar elementos de la lista de forma frecuente, especialmente en posiciones diferentes al final. Las operaciones de inserción y eliminación son más eficientes en LinkedList que en ArrayList cuando se hacen en el medio de la lista.

2. Implementar estructuras de datos más complejas como colas y pilas, ya que LinkedList también implementa la interfaz Deque, lo que permite tratarla como una cola doble (añadir y quitar elementos tanto por el inicio como por el final de la lista).

3. Recorrer la lista en ambas direcciones, ya que es una lista doblemente enlazada.

## ¿Qué resuelve la clase LinkedList?
LinkedList aborda algunos problemas que las estructuras de datos basadas en arrays presentan:

1. **Dificultad para agregar o eliminar elementos en posiciones específicas**: En un ArrayList, para insertar o eliminar un elemento en una posición específica, hay que mover todos los elementos a la derecha o a la izquierda, lo que puede ser ineficiente. En una LinkedList, solo se actualizan los punteros de los nodos, lo que permite estas operaciones de forma más rápida.

2. **Capacidad de la lista**: Los arrays tienen un tamaño fijo. Aunque ArrayList maneja el redimensionamiento de manera interna, LinkedList no requiere redimensionarse en absoluto, ya que se pueden añadir o quitar nodos sin necesidad de reorganizar o copiar la lista completa.

## ¿Cómo lo resuelve la clase LinkedList?
La implementación de LinkedList en Java permite:

1. **Inserción y eliminación eficiente**: Las operaciones de agregar o eliminar elementos en cualquier posición son rápidas, ya que solo requieren actualizar los punteros de los nodos adyacentes.

2. **Flexibilidad para actuar como diferentes estructuras**: Implementa la interfaz Deque, por lo que se puede utilizar como lista, cola (FIFO), pila (LIFO), y cola doble (permitiendo insertar y remover elementos de ambos extremos).

## Métodos importantes de la clase LinkedList
1. Crear un LinkedList
```java
LinkedList<String> names = new LinkedList<>();
```

2. **Agregar elementos al final (`add`)**
```java
names.add("Alice");
names.add("Bob");
```

3. Agregar elementos al inicio (`addFirst`) y al final (`addLast`)
```java
names.addFirst("Charlie");
names.addLast("David");
```

4. Acceder a elementos (`get`)
```java
String name = names.get(1); // Devuelve "Alice"
```

5. **Eliminar elementos**

   * **Eliminar por índice (`remove`)**:
    ```java
    names.remove(2); // Elimina el elemento en el índice 2
    ```

   * **Eliminar el primer y último elemento**:
    ```java
    names.removeFirst(); // Elimina "Charlie"
    names.removeLast(); // Elimina "David"
    ```

7. **Verificar el tamaño (`size`)**
```java
int size = names.size(); // Devuelve el número de elementos en el `LinkedList`
```

8. **Verificar si contiene un elemento (`contains`)**
```java
boolean exists = names.contains("Eve"); // Devuelve `true` si "Eve" está en la lista
```

9. **Convertir a array (`toArray`)**
```java
Object[] namesArray = names.toArray();
```

## Ventajas del uso de LinkedList
1. **Inserción y eliminación eficientes**: Las operaciones para agregar o eliminar elementos en el medio de la lista son más rápidas que en un ArrayList, ya que solo requieren actualizar referencias de nodos.

2. **Implementación de estructuras de datos complejas**: Como `LinkedList` implementa `Deque`, puede actuar fácilmente como una cola, pila o lista.

3. **No se necesita gestión de capacidad**: LinkedList puede crecer y reducirse sin preocuparse por el tamaño del array subyacente, ya que cada nodo está individualmente conectado.

## Desventajas del uso de LinkedList
1. **Acceso aleatorio lento**: Para acceder a un elemento en una posición específica, LinkedList debe recorrer la lista desde el principio o el final, lo que puede ser lento. Esto es diferente a ArrayList, que tiene acceso en tiempo constante.

2. **Mayor consumo de memoria**: Cada nodo tiene una referencia adicional (al nodo siguiente y al nodo anterior), lo que incrementa el consumo de memoria en comparación con un array simple.