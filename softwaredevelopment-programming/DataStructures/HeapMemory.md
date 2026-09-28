# Heap Memory
El Heap es la región de memoria donde se almacenan objetos creados dinámicamente durante la ejecución del programa.

**Su uso es crucial en la gestión de datos dinámicos y estructuras de datos complejas.**

En Java, cada vez que haces:
```java
new Object()
```
Ese objeto se crea en el **Heap**.

**Definición precisa: El Heap es una zona de memoria grande, dinámica y gestionada por el Garbage Collector, usada para almacenar objetos cuyo tiempo de vida NO está determinado por el alcance local de una función.**

*Mientras que el Stack es ordenado y funciona en LIFO, el Heap es desordenado, flexible y mucho más grande.*

```
La memoria Heap es una región de la memoria RAM que se utiliza para el almacenamiento dinámico de datos. A diferencia del Stack, donde la memoria se asigna y libera automáticamente, en el Heap la memoria es administrada manualmente por el programador o el recolector de basura del sistema.
```
---

## ¿Para qué sirve?
La memoria Heap es útil en situaciones donde el tamaño de los datos no se conoce en tiempo de compilación y se necesita una asignación de memoria más flexible.

* **Almacenar objetos y estructuras de datos dinámicas**: En lenguajes como Java y C++, los objetos creados con new se almacenan en el Heap.

* **Asignación de memoria a largo plazo**: A diferencia del Stack, donde la memoria se libera automáticamente al salir de un ámbito, en el Heap los datos persisten hasta que se liberan manualmente o por el recolector de basura.

* **Compartir memoria entre funciones**: Un objeto en el Heap puede ser accedido por múltiples funciones sin problemas de alcance (scope).

* **Crear estructuras de datos complejas**
  * Arrays
  * Listas enlazadas
  * Árboles
  * HashMaps
  * Heaps
  * Graphs
  * Streams
  * Objetos de usuario
  * Casi todo lo que usas en Java

* **Evitar desbordamientos del Stack (Stack Overflow)**: Cuando se manejan datos grandes o muchas llamadas recursivas, la memoria **Stack** puede agotarse rápidamente, mientras que el Heap tiene más espacio disponible.

* Guardar datos que deben vivir más allá de una función
  * Ejemplo:
```java
List<Integer> list = new ArrayList<>();
```
  * El list (la referencia) vive en stack, pero el objeto ArrayList vive en el heap y su array interno también vive en el heap.

* **Permitir modelos de datos dinámicos**
  * El Heap permite:
    * crecer o reducir estructuras.
    * diseñar árboles, grafos, buffers.
    * reservar grandes cantidades de memoria.
    * almacenar objetos de larga duración.

## Características de la memoria Heap
1. **Asignación dinámica de memoria**
   * La memoria se asigna y libera manualmente en lenguajes como **C/C++** (`malloc()` / `free()`).

   * En lenguajes como Java, Python y C#, el recolector de basura administra la memoria Heap.

2. **Más espacio disponible que el Stack**: El Heap suele ser más grande que el Stack y puede almacenar estructuras de datos extensas.

3. **Acceso más lento que el Stack**: La asignación en el Heap requiere más tiempo porque el sistema operativo debe buscar un bloque libre de memoria, mientras que el Stack sigue un orden secuencial (**LIFO**).

4. **Puede causar fragmentación**: Si se asigna y libera memoria de forma desordenada, pueden quedar huecos inutilizables en la memoria Heap, lo que reduce su eficiencia.

5. **Necesita recolección de basura o liberación manual**
   * En C/C++, el programador debe liberar la memoria (`free()` o `delete`), o puede haber fugas de memoria (**memory leaks**).

   * En Java y Python, el Garbage Collector se encarga de liberar memoria cuando los objetos ya no son referenciados.

6. **Persistencia de datos entre funciones**: Los datos en el Heap pueden ser accedidos desde cualquier parte del programa mientras haya un puntero/referencia a ellos.

## ¿Cuál es su estructura?
A diferencia del Stack, el Heap NO es una pila ni una cola.

Es:
* una gran región de memoria,
* dividida en áreas,
* administrada por el Garbage Collector en Java.

En Java (HotSpot), la estructura típica es:
```bash
Heap
+---------------------------+
| Young Generation          |
|  +-- Eden                 |
|  +-- Survivor S0          |
|  +-- Survivor S1          |
+---------------------------+
| Old Generation            |
+---------------------------+
| Metaspace (Fuera del heap)|
+---------------------------+
```
* Young Generation (donde nacen los objetos)
  * La JVM asume que:
    * La mayoría de los objetos mueren jóvenes.

  * Por eso hay una región rápida para asignarlos:
    * Eden (donde nacen los objetos)
    * Survivor 0 y 1 (donde pasan tras una GC menor)

  * Objetos que sobreviven varios ciclos → pasan a Old Generation.

* Old Generation
  * Aquí van los objetos de “larga vida”:
    * caches
    * colecciones grandes
    * árboles que crecen
    * objetos singleton
    * estructuras persistentes

* Metaspace (fuera del heap)
  * Contiene:
    * información de clases
    * metadata
    * bytecode
    * descriptores

  * No confundir con Heap.

## ¿Qué problemas resuelve?
El Heap resuelve:

1. Almacenamiento dinámico flexible
   * Cualquier estructura compleja necesita:
     * nodos,
      * punteros,
      * arrays dinámicos,
      * objetos anidados,
      * memoria variable.

   * El Stack NO puede con eso.

2. Tiempo de vida no predecible
   * Objetos que viven:
     * durante toda la app
     * durante muchas llamadas
     * compartidos entre funciones, hilos o clases

3. Estructuras crecientes
   * Solo el Heap permite:
     * crecer un ArrayList,
     * añadir nodos a un árbol,
     * insertar en un HashMap,
     * almacenar un grafo enorme.

## ¿Cómo lo resuelve? (Mecanismos internos)
* Hay tres mecanismos clave:

1. Heap Allocation (Asignación dinámica)
* Cuando haces:
```java
Node node = new Node();
```
  * Java usa un mecanismo rápido (bump-pointer) para asignar memoria contigua en Eden.
  
  * Es muy eficiente, pero:
    * fragmenta con el tiempo
    * requiere GC

2. Garbage Collector (GC)
   * Java NO libera memoria manualmente.
     * El GC:
       * detecta objetos inusados
       * libera su memoria
       * compacta regiones
       * evita fugas de memoria

   * Esto simplifica el código, pero introduce pausas, latencia y sobrecosto.

3. Compaction (compactación)
   * El Heap se fragmenta (como un disco duro).
   
   * Para optimizar, el GC compacta:
```java
[obj1] [hole] [obj2] [hole] [hole] [obj3]
→
[obj1][obj2][obj3]-------------
```
   * Esto mejora cache locality pero toma tiempo.

## Características esenciales
* **Mucho más grande que el Stack**
  * Típicos tamaños:
    * 128 MB
    * 512 MB
    * 2 GB
    * 8 GB

  * Configuración:
```bash
-Xmx (máximo)
-Xms (mínimo)
```

* **Más lento (MUCHO más lento)**
  * Acceder al heap:
    * requiere seguir punteros,
    * no tiene localidad contigua,
    * afecta caché,
    * GC puede interrumpir.

  * Los accesos a objetos del heap → cache misses frecuentes.

* **Coste real de las estructuras depende del Heap**
  * Ejemplos:
    * LinkedList → nodos dispersos → mal para la caché
    * ArrayList → contiguo → buen rendimiento real
  * HashMap → buckets + nodos → overhead de memoria

* **Heap es compartido entre hilos**
  1. El stack es privado por hilo,
  2. el Heap es global → requiere sincronización.

  * Por eso:
    * colecciones no thread-safe
    * memory visibility issues (Java Memory Model)
    * data races

* **Referencias viven en Stack, objetos en Heap**
  * Ejemplo:
```java
Person p = new Person();
```
  * `p` → **stack**
  * `Person` → **heap**

### Ejemplo visual simple
```java
class Node {
   int value;
   Node next;
}

Node a = new Node();
Node b = new Node();
a.next = b;
```
* Memoria:
  * Stack:
```bash
a → referencia (0x15A030)
b → referencia (0x28B54C)
```
  * Heap:
```bash
0x15A030 → Node { value:0, next:0x28B54C }
0x28B54C → Node { value:0, next:null }
```

## Visión general: Stack vs Heap
| Característica            | Stack                                                 | Heap                                                         |
| ------------------------- | ----------------------------------------------------- | ------------------------------------------------------------ |
| Ubicación                 | Se encuentra en la RAM, gestionada por el sistema.    | Se encuentra en la RAM, gestionada manual o automáticamente. |
| Tipo de memoria           | Automática                                            | Dinámica                                                     |
| Velocidad                 | Muy rápida                                            | Más lenta                                                    |
| Organización              | Continua, orden LIFO                                  | Desordenada, fragmentada                                     |
| Contiene                  | Variables locales, referencias                        | Objetos, arrays, estructuras                                 |
| Tiempo de vida            | Corto, ligado a la función                            | Largo, controlado por GC                                     |
| Tamaño                    | Pequeño (MB)                                          | Grande (GB)                                                  |
| Administrado por          | JVM (push/pop)                                        | JVM (GC)                                                     |
| Influencia en performance | Excelente                                             | Depende de punteros, cache misses                            |
| Uso típico                | Cálculos temporales                                   | Datos estructurados                                          |
| Asignación                | Automática (en compilación o en tiempo de ejecución). | Manual (malloc(), new) o automática (garbage collector).     |
| Alcance de variables      | Local al bloque o función.                            | Global mientras haya una referencia.                         |
| Tamaño                    | Limitado, puede causar Stack Overflow.                | Mayor capacidad, pero puede fragmentarse.                    |
| Liberación de memoria     | Automática cuando se sale del ámbito.                 | Manual (free(), delete) o por Garbage Collector.             |

## ¿Dónde vive cada estructura de datos?
* Esto es clave:
  * Las estructuras de datos SIEMPRE viven en el Heap.
    * Array
    * ArrayList
    * LinkedList
    * HashMap
    * Trees
    * Graphs
    * Stacks/Queues implementados como objetos
    * Heaps (binary heap)
    * Sets, Maps

  * Pero: las referencias a esas estructuras viven en el Stack.

  * Ejemplo
```java
int[] arr = new int[10];
```
* `arr` (referencia) → **Stack**
* el array entero (sus 10 posiciones) → **Heap**

## ¿Por qué importa tanto en algoritmia?
* Porque el layout de memoria determina:
  * la velocidad real del recorrido,
  * cuántos cache hits/misses tendrás,
  * qué tan rápido operan tus algoritmos,
  * la eficiencia de acceso aleatorio,
  * el overhead de nodos y punteros.

* Es decir: No basta con saber `O(n)`. Debes conocer cómo se distribuyen los datos en memoria.