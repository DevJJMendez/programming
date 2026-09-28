# Selection Sort
Selection Sort es un algoritmo de ordenamiento sencillo que funciona **dividiendo** el array en dos partes: una parte ordenada y una parte no ordenada. A medida que avanza, selecciona repetidamente el elemento mínimo de la parte no ordenada y lo intercambia con el primer elemento de la parte no ordenada, moviéndolo a la parte ordenada.

## ¿Qué es Selection Sort?
Es un algoritmo de ordenamiento basado en el principio de encontrar el elemento mínimo en una lista no ordenada y moverlo a su posición correcta en la lista ordenada. Es un algoritmo **`in-place`**, lo que significa que no requiere almacenamiento adicional (más allá de unas pocas variables).

## ¿Qué resuelve?
El algoritmo Selection Sort resuelve el problema de ordenar un conjunto de elementos (normalmente números) en orden ascendente o descendente. Es especialmente útil cuando se tiene un pequeño conjunto de datos, ya que su simplicidad lo hace fácil de implementar. Sin embargo, no es adecuado para grandes conjuntos de datos debido a su complejidad O(n²) en el peor de los casos.

## ¿Cómo lo resuelve?
* Recorre el array de izquierda a derecha.

* Para cada elemento en la lista, busca el valor mínimo en la parte no ordenada del array.

* Una vez encontrado el valor mínimo, lo intercambia con el primer valor de la parte no ordenada.

* La parte no ordenada del array se reduce en una posición, y el proceso se repite hasta que todo el array esté ordenado.

## Implementación
```java
public class SelectionSort {
    // Método para ordenar un array usando Selection Sort
    public static void selectionSort(int[] array) {
        int totalElements = array.length;

        // Recorremos todo el array
        for (int currentIndex = 0; currentIndex < totalElements - 1; currentIndex++) {
            // Encontramos el índice del valor mínimo en la parte no ordenada
            int minIndex = currentIndex;
            
            // Buscar el menor elemento en la parte no ordenada
            for (int nextIndex = currentIndex + 1; nextIndex < totalElements; nextIndex++) {
                if (array[nextIndex] < array[minIndex]) {
                    minIndex = nextIndex;  // Actualizamos el índice del menor valor
                }
            }

            // Si encontramos un valor más pequeño, lo intercambiamos
            if (minIndex != currentIndex) {
                swapElements(array, currentIndex, minIndex);
            }
        }
    }

    // Método auxiliar para intercambiar dos elementos
    private static void swapElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Método principal para probar la ordenación
    public static void main(String[] args) {
        int[] unsortedArray = {29, 10, 14, 37, 13};
        
        System.out.println("Array original: ");
        System.out.println(java.util.Arrays.toString(unsortedArray));
        
        selectionSort(unsortedArray);
        
        System.out.println("Array ordenado: ");
        System.out.println(java.util.Arrays.toString(unsortedArray));
    }
}
```
### Estructura y puntos clave
1. Recorrido externo (for (currentIndex = 0; currentIndex < totalElements - 1; currentIndex++))

   * Este bucle representa las iteraciones a través de cada posición en el array.

   * Se detiene antes del último elemento porque en cada iteración estamos colocando un elemento en su lugar correcto, y el último ya estará ordenado cuando se haya recorrido todo el array.

2. Búsqueda del elemento mínimo (for (nextIndex = currentIndex + 1; nextIndex < totalElements; nextIndex++))

   * Este bucle busca el elemento más pequeño en la parte no ordenada del array (la parte después de currentIndex).

   * Si encuentra un valor más pequeño, actualiza el índice minIndex.

3. Intercambio de elementos (swapElements)

   * Una vez que se ha encontrado el elemento mínimo, si está en una posición distinta de la actual, se intercambia con el elemento en la posición currentIndex.

   * El método auxiliar swapElements se utiliza para intercambiar los elementos y mantener el código limpio y legible.

## Ejemplo paso a paso:
Supongamos que tenemos el siguiente array:
```java
int[] array = {29, 10, 14, 37, 13};
```
En la primera iteración (cuando currentIndex = 0):

Busca el menor valor en {29, 10, 14, 37, 13}. Encuentra 10 y lo intercambia con 29.
El array ahora es {10, 29, 14, 37, 13}.
En la segunda iteración (cuando currentIndex = 1):

Busca el menor valor en {29, 14, 37, 13}. Encuentra 13 y lo intercambia con 29.
El array ahora es {10, 13, 14, 37, 29}.
En la tercera iteración (cuando currentIndex = 2):

Busca el menor valor en {14, 37, 29}. No se hace ningún intercambio porque 14 ya está en la posición correcta.
En la cuarta iteración (cuando currentIndex = 3):

Busca el menor valor en {37, 29}. Encuentra 29 y lo intercambia con 37.
El array ahora es {10, 13, 14, 29, 37}.