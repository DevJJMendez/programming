# Binary Search
El algoritmo de búsqueda binaria o Binary Search es un algoritmo eficiente utilizado para encontrar la posición de un elemento en una lista ordenada. A diferencia de la búsqueda lineal, que recorre todos los elementos uno por uno, la búsqueda binaria reduce el espacio de búsqueda a la mitad en cada paso, lo que lo hace mucho más eficiente para listas grandes.

## ¿Qué es Binary Search?
Binary Search es un algoritmo de búsqueda que encuentra la posición de un elemento en un array o lista ordenada dividiendo repetidamente la lista en dos mitades y comparando el valor objetivo con el valor del elemento central.

## ¿Qué resuelve?
Binary Search resuelve el problema de buscar un elemento dentro de una lista ordenada de manera mucho más eficiente que la búsqueda secuencial. Al reducir el espacio de búsqueda a la mitad en cada paso, el número de comparaciones es significativamente menor, lo que hace que el algoritmo sea más rápido, especialmente en listas grandes.

## ¿Cómo lo resuelve?
1. Dado un array ordenado, Binary Search selecciona el elemento central de la lista y lo compara con el valor que se busca.

2. Si el valor coincide, el algoritmo devuelve la posición del elemento.

3. Si el valor es menor que el elemento central, el algoritmo repite el proceso en la mitad izquierda de la lista.

4. Si el valor es mayor que el elemento central, el proceso se repite en la mitad derecha de la lista.

5. Este proceso se repite hasta que se encuentra el valor o hasta que no quedan más elementos para buscar.

## Estructura del algoritmo
El algoritmo se implementa típicamente en dos versiones: iterativa y recursiva.

Versión iterativa:

Utiliza un bucle para reducir el espacio de búsqueda.
Tiene una mejor gestión de la memoria, ya que no utiliza la pila de llamadas.
Versión recursiva:

Divide el array mediante llamadas recursivas.
Más intuitiva en términos de descomposición del problema, pero puede tener un mayor costo en memoria debido a la pila de recursión.

## Implementación
**Versión Iterativa**
```java
public class BinarySearch {
    
    // Método de búsqueda binaria iterativa
    public static int binarySearch(int[] array, int target) {
        int low = 0;  // Límite inferior
        int high = array.length - 1;  // Límite superior

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Calcular el índice del medio

            // Comparar el elemento medio con el objetivo
            if (array[mid] == target) {
                return mid;  // Elemento encontrado, retornar índice
            }

            // Si el objetivo es mayor, ignorar la mitad izquierda
            if (array[mid] < target) {
                low = mid + 1;
            } else {
                // Si el objetivo es menor, ignorar la mitad derecha
                high = mid - 1;
            }
        }

        return -1;  // Elemento no encontrado
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 10, 14, 20, 30, 40, 50};
        int target = 30;

        int result = binarySearch(array, target);

        if (result != -1) {
            System.out.println("Elemento encontrado en el índice: " + result);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
}
```

**Versión Recursiva**
```java
public class BinarySearchRecursive {
    
    // Método de búsqueda binaria recursiva
    public static int binarySearch(int[] array, int low, int high, int target) {
        if (low <= high) {
            int mid = low + (high - low) / 2;  // Calcular el índice del medio

            // Comparar el elemento medio con el objetivo
            if (array[mid] == target) {
                return mid;  // Elemento encontrado, retornar índice
            }

            // Si el objetivo es mayor, buscar en la mitad derecha
            if (array[mid] < target) {
                return binarySearch(array, mid + 1, high, target);
            } else {
                // Si el objetivo es menor, buscar en la mitad izquierda
                return binarySearch(array, low, mid - 1, target);
            }
        }

        return -1;  // Elemento no encontrado
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 10, 14, 20, 30, 40, 50};
        int target = 30;

        int result = binarySearch(array, 0, array.length - 1, target);

        if (result != -1) {
            System.out.println("Elemento encontrado en el índice: " + result);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
}
```