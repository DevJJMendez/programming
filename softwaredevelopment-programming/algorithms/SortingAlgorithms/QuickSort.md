# Quick Sort
Quick Sort es un algoritmo de ordenamiento basado en el paradigma divide y vencerás. Es uno de los algoritmos más rápidos y eficientes para ordenar grandes cantidades de datos, particularmente en promedio. A diferencia de otros algoritmos de ordenamiento como el Bubble Sort o Selection Sort, que tienen una complejidad peor, Quick Sort generalmente logra mejores tiempos de ejecución.

## ¿Qué resuelve?
Quick Sort resuelve el problema de ordenar eficientemente listas o arrays, especialmente cuando se trabaja con grandes volúmenes de datos. Es ampliamente utilizado debido a su buena eficiencia en la mayoría de los casos. Quick Sort es especialmente efectivo en situaciones en las que el tiempo de ejecución es crucial.

## ¿Cómo lo resuelve?
Quick Sort funciona seleccionando un elemento llamado pivote. Luego, divide el array en dos sublistas:

* Elementos menores o iguales al pivote.

* Elementos mayores que el pivote.

El algoritmo aplica de forma recursiva este mismo proceso a las sublistas, reorganizando y ordenando los elementos.

## Paso a paso del algoritmo:
* Elegir el pivote: Elige un elemento del array para ser el pivote (puede ser el primero, el último, uno aleatorio o el central).

* Particionar: Rearranga el array de tal manera que todos los elementos menores o iguales al pivote estén a la izquierda, y los mayores a la derecha.

* Recursión: Aplica recursivamente Quick Sort en las dos sublistas (a la izquierda y a la derecha del pivote).

* Combinación: Al final, cuando todas las sublistas estén ordenadas, el array completo estará ordenado.

Complejidad:
* Tiempo promedio: O(n log n)

* Peor caso: O(n2), ocurre cuando el pivote es el elemento más pequeño o más grande en cada partición (generalmente se puede evitar usando técnicas como elegir pivotes aleatorios o medianos).

* Espacio: O(logn) en el caso ideal debido a la recursión.

## Implementación
```java
import java.util.Arrays;

public class QuickSort {
    
    // Método principal que implementa QuickSort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Índice del pivote tras la partición
            int pivotIndex = partition(array, low, high);

            // Ordenar los elementos a la izquierda y derecha del pivote
            quickSort(array, low, pivotIndex - 1); // Sublista izquierda
            quickSort(array, pivotIndex + 1, high); // Sublista derecha
        }
    }

    // Método para realizar la partición del array
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Seleccionamos el último elemento como pivote
        int i = low - 1; // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (array[j] <= pivot) {
                i++;
                // Intercambiar array[i] con array[j]
                swap(array, i, j);
            }
        }

        // Intercambiar el pivote con el siguiente elemento mayor
        swap(array, i + 1, high);
        
        return i + 1; // Retorna el índice del pivote
    }

    // Método para intercambiar dos elementos en el array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Método principal para ejecutar QuickSort
    public static void main(String[] args) {
        int[] array = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("Array original:");
        System.out.println(Arrays.toString(array));

        // Llamar a QuickSort
        quickSort(array, 0, array.length - 1);

        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(array));
    }
}
```
### Estructura del algoritmo:
Método quickSort():

Es el método recursivo que divide el array en dos partes y aplica la ordenación a cada parte.
Tiene dos parámetros clave: low y high, que representan el rango del array que se está procesando.
Método partition():

Este es el corazón de Quick Sort. Se selecciona un pivote (en este caso, el último elemento del array) y reorganiza los elementos en dos grupos: los menores o iguales al pivote a la izquierda, y los mayores a la derecha.
Devuelve el índice del pivote para que los subarrays puedan ser procesados recursivamente.
Método swap():

Es un método auxiliar que intercambia dos elementos en el array.

### Puntos clave:
Selección del pivote:

El pivote puede seleccionarse de varias maneras (primero, último, aleatorio, o la mediana). La selección afecta el rendimiento, especialmente en el peor caso.
En este ejemplo, se usa el último elemento como pivote, pero en implementaciones más optimizadas se puede elegir un pivote aleatorio para mejorar el rendimiento en el peor de los casos.
Partición:

En cada paso, la función partition() asegura que los elementos menores que el pivote estén a su izquierda y los mayores a la derecha. Después de cada partición, el pivote está en su posición final.
Recursión:

Tras la partición, Quick Sort se aplica recursivamente en las dos sublistas (izquierda y derecha). Al finalizar todas las llamadas recursivas, el array estará ordenado.
Intercambio (swap):

El proceso de intercambio es crucial para mover los elementos alrededor del pivote durante la partición. Esto asegura que los elementos estén en la sección correcta del array.

### Ejemplo paso a paso:
Para el array {10, 80, 30, 90, 40, 50, 70}:

Elegir pivote: Se selecciona el último elemento 70 como pivote.
Particionar:
El array se reorganiza en dos secciones: los elementos menores o iguales al pivote quedan a la izquierda y los mayores a la derecha.
Después de la partición, el array puede verse así: {10, 30, 40, 50, 70, 90, 80} con 70 en su posición final.
Recursión:
Ahora se aplicará Quick Sort recursivamente a las sublistas {10, 30, 40, 50} (izquierda) y {90, 80} (derecha).
Repetir hasta que todas las sublistas estén ordenadas.

## Optimización:
Estrategias de pivote: Elegir un pivote aleatorio o usar la "mediana de tres" (comparar el primer, último y elemento central, y seleccionar la mediana como pivote) puede mejorar el rendimiento.
Tamaño de los subarrays: Para pequeños subarrays, Quick Sort puede ser menos eficiente que otros algoritmos, como Insertion Sort.

## Estrategias de pivote
En Quick Sort, la elección del pivote es crucial, ya que afecta directamente al rendimiento del algoritmo. Dependiendo de cómo se elija el pivote, el tiempo de ejecución puede variar de O(nlogn) en el caso promedio a O(n 2) en el peor de los casos.

1. Último elemento como pivote (Last Element Pivot)
Descripción: El último elemento del array (o subarray) es seleccionado como el pivote.
Ventajas:
Simple de implementar.
Se ajusta bien en muchos casos promedio.
Desventajas:
Si el array ya está ordenado o casi ordenado, esta selección lleva al peor caso de O(n2), ya que el pivote es siempre el mayor o menor valor.
```java
int pivot = array[high]; // Último elemento
```

2. Primer elemento como pivote (First Element Pivot)
Descripción: El primer elemento del array o subarray se elige como pivote.
Ventajas:
También es fácil de implementar.
Desventajas:
Como con el último elemento, puede llevar al peor caso O(n2) si el array ya está ordenado o casi ordenado.
```java
int pivot = array[low]; // Primer elemento
```

3. Pivote aleatorio (Random Pivot)
Descripción: Se elige un pivote de manera aleatoria dentro del rango del array o subarray.
Ventajas:
Reduce la probabilidad de que el algoritmo caiga en el peor caso.
Tiende a mejorar el rendimiento promedio, ya que evita sesgos de datos ya ordenados.
Desventajas:
Añade un ligero costo de tiempo debido a la selección aleatoria.
```java
Random rand = new Random();
int pivotIndex = rand.nextInt(high - low + 1) + low; // Índice aleatorio
int pivot = array[pivotIndex];
```

4. Pivote en el medio (Middle Element Pivot)
Descripción: Se selecciona el elemento del medio del array o subarray.
Ventajas:
Funciona bien si el array tiene cierta simetría o balance.
Es fácil de calcular y evita algunos de los problemas del primer o último elemento como pivote.
Desventajas:
En algunos casos, como cuando el array está muy desbalanceado, puede no ser óptimo.
```java
int pivot = array[low + (high - low) / 2]; // Elemento medio
```

5. Mediana de tres (Median-of-Three)
Descripción: Se elige el pivote calculando la mediana de tres elementos: el primer elemento, el último elemento, y el elemento medio del array.
Ventajas:
Una técnica más avanzada que generalmente mejora el rendimiento del algoritmo.
Reduce las posibilidades de caer en el peor caso cuando el array está parcialmente ordenado.
La mediana de tres tiende a elegir un pivote que es más representativo de los valores del array.
Desventajas:
Involucra más cálculos, por lo que es más compleja que otras técnicas.
```java
int mid = low + (high - low) / 2;
int pivot = medianOf(array[low], array[mid], array[high]);

// Método auxiliar para encontrar la mediana de tres valores
private static int medianOf(int a, int b, int c) {
    if ((a - b) * (c - a) >= 0) return a;
    else if ((b - a) * (c - b) >= 0) return b;
    else return c;
}
```

6. Pivote dual (Dual Pivot Quick Sort)
Descripción: Esta variante selecciona dos pivotes en lugar de uno, y divide el array en tres partes:
Elementos menores que el primer pivote.
Elementos entre los dos pivotes.
Elementos mayores que el segundo pivote.
Ventajas:
Divide el array en más secciones, lo que puede mejorar la eficiencia en algunos casos.
Se utiliza en algunas implementaciones modernas de Quick Sort (como en Java 7).
Desventajas:
Es más complicado de implementar y requiere más swaps.
```java
int pivot1 = array[low];
int pivot2 = array[high];
// El array se divide en tres partes, comparando con dos pivotes.
```

### Comparación de las estrategias
Último/Primero como pivote: Funciona bien en muchos casos promedio, pero es muy sensible a arrays ya ordenados o casi ordenados.

Aleatorio: Distribuye mejor el esfuerzo de la partición, reduciendo las probabilidades de caer en el peor caso.

Mediana de tres: Muy efectivo en arrays desbalanceados o parcialmente ordenados, por lo que es una opción común en implementaciones optimizadas.

Dual Pivot: Ideal para mejorar la eficiencia en ciertos tipos de datos, aunque su complejidad puede ser excesiva para escenarios simples.