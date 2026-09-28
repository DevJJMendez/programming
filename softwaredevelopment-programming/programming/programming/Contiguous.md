## Contiguo
El término contiguo se refiere a la disposición de los datos en bloques consecutivos de memoria, es decir, que están almacenados uno junto al otro sin espacios entre ellos. En el contexto de la programación y las estructuras de datos, como los arrays, el concepto de contiguo significa que todos los elementos del array están almacenados en ubicaciones adyacentes dentro de la memoria del sistema.

Cuando se dice que los elementos de un array están almacenados de manera contigua, implica que:

* Si el primer elemento del array está almacenado en una dirección de memoria particular (digamos la dirección A), el segundo elemento estará almacenado en la siguiente posición de memoria disponible, la cual es **A + tamaño del primer elemento**, y así sucesivamente.

* No hay saltos ni espacios entre los elementos; cada uno está seguido inmediatamente por el siguiente.

### Ejemplo en un array de enteros:
En un array de enteros, donde cada entero ocupa, por ejemplo, 4 bytes en memoria (en muchas arquitecturas de hardware), si el primer entero está en la posición de memoria 1000, el siguiente estará en la posición 1004, el siguiente en 1008, y así sucesivamente.

```java
int[] numbers = {10,20,30,40};
```
Si el primer valor (10) está almacenado en la dirección de memoria 1000, el segundo valor (20) estaría en 1004, el tercero (30) en 1008, y así sucesivamente.

## No Contiguo
El concepto de no contiguo en programación y estructuras de datos se refiere a una disposición de los datos donde los elementos no están almacenados de manera consecutiva en memoria. En lugar de estar organizados uno tras otro, como en los arrays, los elementos de estructuras de datos no contiguas están distribuidos en diferentes lugares de la memoria y suelen estar conectados mediante referencias o punteros que permiten acceder a ellos.

### ¿Qué es "No Contiguo" en programación?
En una estructura de datos no contigua, los elementos no están en posiciones adyacentes de memoria, lo que significa que puede haber saltos o huecos entre ellos. Esto se da generalmente en estructuras que necesitan ser dinámicas, donde el tamaño puede crecer o disminuir fácilmente, o en las que se necesita más flexibilidad al agregar y eliminar elementos. Para manejar esta dispersión en la memoria, se usan referencias o punteros que conectan un elemento con el siguiente.

### Ejemplos de estructuras de datos no contiguas:
#### **Listas Enlazadas (Linked Lists)**:
Una lista enlazada es un ejemplo clásico de una estructura de datos no contigua. En una lista enlazada, cada nodo contiene dos partes:

* El valor del nodo (el dato).

* Una referencia o puntero al siguiente nodo en la lista (o en algunos casos al anterior también, en listas doblemente enlazadas).

Cada nodo puede estar almacenado en cualquier parte de la memoria, y lo que hace posible recorrer la lista es el uso de punteros para "enlazar" un nodo con el siguiente.

#### Árboles (Trees):
Un árbol es otra estructura de datos no contigua donde cada nodo puede tener referencias a varios otros nodos. Por ejemplo, en un árbol binario, cada nodo tiene un valor, un puntero a su hijo izquierdo y otro puntero a su hijo derecho. Los nodos pueden estar en ubicaciones dispares en la memoria, pero la estructura jerárquica se mantiene mediante estos punteros.

#### Grafos (Graphs):
Un grafo es una estructura aún más flexible, donde cada nodo puede tener referencias a varios otros nodos sin una disposición predefinida. Los grafos pueden ser altamente dispersos en la memoria, y los punteros entre los nodos son lo que define las conexiones o aristas entre ellos.

### Ventajas de las estructuras no contiguas:
1. **Flexibilidad**: Las estructuras no contiguas son dinámicas, lo que significa que es más fácil agregar y eliminar elementos sin la necesidad de mover otros elementos de la estructura. Esto las hace ideales para situaciones en las que el tamaño de la estructura cambia frecuentemente.

   * En una lista enlazada, por ejemplo, se puede insertar o eliminar un nodo en cualquier lugar sin necesidad de desplazar los otros nodos.

2. **Optimización de memoria**: Estas estructuras pueden aprovechar mejor la memoria, ya que no necesitan reservar un bloque contiguo de memoria al momento de la creación. Pueden crecer según sea necesario.

3. **Fácil redimensionamiento**: Al contrario de los arrays, que tienen un tamaño fijo y necesitan ser recreados si se quiere cambiar su tamaño, las estructuras no contiguas pueden crecer y reducirse de manera más sencilla, ya que solo requieren ajustar los punteros para agregar o eliminar elementos.

### Desventajas de las estructuras no contiguas:
1. **Acceso más lento**: El principal inconveniente de las estructuras no contiguas es que el acceso a los elementos es más lento que en los arrays. Mientras que un array permite acceso directo en O(1), una lista enlazada, por ejemplo, requiere recorrer los nodos secuencialmente, lo que significa que el acceso a un elemento específico tiene una complejidad de O(n) en el peor de los casos.

2. **Mayor uso de memoria**: Aunque puede parecer más eficiente en cuanto al uso de memoria cuando se trata de redimensionar, las estructuras no contiguas utilizan memoria adicional para almacenar los punteros o referencias entre los elementos.

3. **Complejidad en la gestión**: Las estructuras no contiguas, como las listas enlazadas, requieren más gestión manual en cuanto a la memoria y las referencias, lo que puede llevar a errores como fugas de memoria o referencias nulas si no se manejan correctamente.