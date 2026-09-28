# Insertion Sort
Insertion Sort es un algoritmo de ordenamiento simple que construye el array ordenado elemento por elemento. Es eficiente para listas pequeñas y cuando los elementos están casi ordenados. La idea básica es que el array se divide en dos partes: una parte ordenada y otra desordenada. Los elementos de la parte desordenada se toman uno a uno e insertan en su posición correcta dentro de la parte ordenada.

## ¿Qué resuelve?
* Problema: Ordenar una lista o array de elementos en un orden específico (ascendente o descendente).

* Solución: Recorre la lista de izquierda a derecha y toma cada elemento de la lista desordenada, insertándolo en su posición correcta dentro de la parte que ya está ordenada.

## ¿Cómo lo resuelve?
El algoritmo de Insertion Sort funciona al tratar el array como dos sublistas:

* Sublista ordenada: Inicialmente solo contiene el primer elemento.

* Sublista desordenada: Contiene el resto de los elementos del array.

**Para cada nuevo elemento de la sublista desordenada:**
1. Compara ese elemento con los elementos de la sublista ordenada (de derecha a izquierda).

2. Desplaza los elementos de la sublista ordenada hacia la derecha hasta encontrar la posición correcta.

3. Inserta el elemento en la posición adecuada.

## Pasos clave de Insertion Sort:
Empezamos desde el segundo elemento (porque el primer elemento ya está considerado como ordenado).
Comparamos el elemento actual con los elementos anteriores.
Desplazamos los elementos mayores un lugar a la derecha.
Insertamos el elemento en la posición adecuada.
Repetimos este proceso para cada elemento hasta que todo el array esté ordenado.

## Implementación
```java
import java.util.Arrays;

public class InsertionSort {
    
    // Método para realizar el algoritmo Insertion Sort
    public static void insertionSort(int[] array) {
        // Comenzamos desde el segundo elemento (posición 1) hasta el final
        for (int i = 1; i < array.length; i++) {
            int currentElement = array[i];  // El elemento a insertar en la parte ordenada
            int j = i - 1;  // Comenzamos a comparar con el elemento anterior
            
            // Desplazamos los elementos mayores que el currentElement hacia la derecha
            while (j >= 0 && array[j] > currentElement) {
                array[j + 1] = array[j];  // Mover el elemento una posición a la derecha
                j--;  // Continuar comparando con los elementos anteriores
            }
            
            // Insertamos el currentElement en su posición correcta
            array[j + 1] = currentElement;
        }
    }
    
    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};
        
        System.out.println("Array original:");
        System.out.println(Arrays.toString(array));
        
        // Llamar a la función de Insertion Sort
        insertionSort(array);
        
        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(array));
    }
}
```
### Explicación del código:
Método insertionSort:

Recorremos el array desde el segundo elemento (i = 1).
El currentElement es el elemento que queremos colocar en su posición correcta dentro de la parte ya ordenada.
Comparamos currentElement con los elementos anteriores. Mientras el elemento anterior sea mayor que currentElement, lo desplazamos una posición a la derecha.
Una vez que encontramos la posición correcta, colocamos currentElement allí.
Comparación y desplazamiento:

El bucle while compara el currentElement con los elementos de la parte ordenada.
Los elementos que son mayores que currentElement se mueven una posición hacia la derecha.
Cuando encontramos la posición correcta, insertamos currentElement.
Método main:

Inicializamos un array de ejemplo {12, 11, 13, 5, 6}.
Llamamos al método insertionSort.
Imprimimos el array antes y después del ordenamiento.

### Ejemplo de Ejecución:
Dado el array {12, 11, 13, 5, 6}, el proceso de Insertion Sort se vería así:

Primer paso (i = 1):

currentElement = 11.
Comparar con 12, como 11 < 12, desplazamos 12 hacia la derecha.
Insertar 11 en la posición correcta.
Array: {11, 12, 13, 5, 6}.
Segundo paso (i = 2):

currentElement = 13.
Comparar con 12, como 13 > 12, no se necesita hacer cambios.
Array: {11, 12, 13, 5, 6}.
Tercer paso (i = 3):

currentElement = 5.
Comparar con 13, como 5 < 13, desplazamos 13 hacia la derecha.
Comparar con 12, como 5 < 12, desplazamos 12.
Comparar con 11, como 5 < 11, desplazamos 11.
Insertar 5 en la posición correcta.
Array: {5, 11, 12, 13, 6}.
Cuarto paso (i = 4):

currentElement = 6.
Comparar con 13, como 6 < 13, desplazamos 13.
Comparar con 12, como 6 < 12, desplazamos 12.
Comparar con 11, como 6 < 11, desplazamos 11.
Insertar 6 en la posición correcta.
Array: {5, 6, 11, 12, 13}.