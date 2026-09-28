# Merge Sort
El algoritmo Merge Sort es un algoritmo de ordenamiento que sigue la estrategia de divide y vencerás. Es eficiente, estable y tiene una complejidad temporal de O(nlogn), lo que lo convierte en una excelente opción para ordenar grandes volúmenes de datos. Fue desarrollado por John von Neumann en 1945 y es un algoritmo popular por su rendimiento predecible.

## ¿Qué es Merge Sort?
Merge Sort es un algoritmo de ordenamiento que divide el array o lista de datos en mitades más pequeñas, ordena cada mitad de forma recursiva y luego las combina (o "intercala") de manera que la lista resultante esté ordenada.

## ¿Qué resuelve?
Merge Sort resuelve el problema de ordenar una lista o array de manera eficiente. Es particularmente útil para listas grandes, donde otros algoritmos menos eficientes, como el Bubble Sort o Insertion Sort, serían demasiado lentos debido a su complejidad O(n 2).

## ¿Cómo lo resuelve?
1. Divide: El array o lista se divide en dos mitades de forma recursiva hasta llegar a subarrays de tamaño 1, ya que un array de un solo elemento está automáticamente ordenado.

2. Conquista: Luego, se combinan (o intercalan) los subarrays de manera ordenada para formar un array más grande.

3. Combina: Finalmente, el array completamente ordenado se construye al intercalar cada una de las partes ordenadas.

## Estructura del algoritmo
1. División: Divide el array en mitades recursivamente.

2. Intercalación: Combina dos listas ordenadas en una sola lista ordenada.

3. Recursión: Se aplican estas dos operaciones hasta que el array completo esté ordenado.

**Puntos clave**
* Complejidad temporal: Merge Sort tiene una complejidad de O(nlogn), que es mejor que algoritmos simples como Bubble Sort o Selection Sort.

* Estabilidad: Es un algoritmo estable, lo que significa que si dos elementos tienen el mismo valor, su orden relativo no cambiará.

* No es in-place: Merge Sort utiliza memoria adicional para las listas temporales donde se intercalan los elementos, por lo que su complejidad espacial es O(n).

## Implementación
```java
import java.util.Arrays;

public class MergeSort {

    // Método principal que implementa MergeSort
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return; // Si el array tiene 1 elemento, ya está ordenado
        }

        // Dividimos el array en dos mitades
        int mid = array.length / 2;
        int[] leftArray = Arrays.copyOfRange(array, 0, mid);
        int[] rightArray = Arrays.copyOfRange(array, mid, array.length);

        // Llamadas recursivas para ordenar ambas mitades
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Intercalar ambas mitades ordenadas
        merge(array, leftArray, rightArray);
    }

    // Método para intercalar dos subarrays
    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        // Intercalar elementos de ambas mitades
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[mergedIndex++] = leftArray[leftIndex++];
            } else {
                array[mergedIndex++] = rightArray[rightIndex++];
            }
        }

        // Copiar los elementos restantes de la mitad izquierda
        while (leftIndex < leftArray.length) {
            array[mergedIndex++] = leftArray[leftIndex++];
        }

        // Copiar los elementos restantes de la mitad derecha
        while (rightIndex < rightArray.length) {
            array[mergedIndex++] = rightArray[rightIndex++];
        }
    }

    // Método principal para probar MergeSort
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Array original:");
        System.out.println(Arrays.toString(array));

        // Llamar a MergeSort
        mergeSort(array);

        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(array));
    }
}
```
Desglose paso a paso
División recursiva:
El array se divide en dos mitades.
Cada mitad se sigue dividiendo recursivamente hasta que solo quede un elemento en cada subarray.
Intercalación:
Una vez que se ha dividido el array en sus componentes más pequeños, el proceso de intercalación comienza.
Dos subarrays ya ordenados se intercalan comparando los elementos en ambas listas y tomando el menor primero.

## Ejemplo de ejecución
Supongamos que tenemos el array {38, 27, 43, 3, 9, 82, 10}:

División:

Se divide en dos mitades: {38, 27, 43} y {3, 9, 82, 10}.
Luego se siguen dividiendo: {38, 27, 43} se convierte en {38} y {27, 43}, y así sucesivamente hasta obtener arrays de un solo elemento.
Intercalación:

{38} y {27, 43} se ordenan individualmente.
Luego se intercalan para formar {27, 38, 43}.
El mismo proceso ocurre con la otra mitad.
Resultado final:

Tras varias fases de intercalación, los dos arrays ordenados se combinan en uno solo: {3, 9, 10, 27, 38, 43, 82}.

## Ventajas del Merge Sort
Eficiencia en tiempo: Funciona con una complejidad temporal de O(nlogn), lo que lo hace más eficiente que muchos otros algoritmos en casos promedio y en el peor caso.
Estabilidad: Mantiene el orden relativo de los elementos con el mismo valor.
Buen rendimiento con grandes listas: Merge Sort es adecuado para listas grandes, especialmente cuando la estabilidad es importante.
Desventajas del Merge Sort
Consumo de memoria: Utiliza más espacio de memoria que otros algoritmos como Quick Sort, ya que requiere arrays temporales para realizar la intercalación.
No es in-place: A diferencia de Quick Sort, no opera directamente sobre el array original sin usar memoria adicional.