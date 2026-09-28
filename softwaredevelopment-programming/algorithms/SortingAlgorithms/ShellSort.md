# Shell Sort
Shell Sort es un algoritmo de ordenamiento basado en Insertion Sort, pero optimizado para mejorar el rendimiento. La principal diferencia radica en que Shell Sort comienza comparando y ordenando elementos que están a una cierta "distancia" entre sí (determinada por una secuencia de "gaps") en lugar de elementos adyacentes. Luego, la distancia entre los elementos comparados disminuye gradualmente hasta que finalmente se realiza una ordenación final como en Insertion Sort.

## ¿Qué resuelve?
Shell Sort resuelve el problema de mejorar el tiempo de ejecución en comparación con Insertion Sort, especialmente en listas de tamaño grande o moderado. Mientras que Insertion Sort puede ser lento para listas grandes debido a que solo mueve un elemento a la vez, Shell Sort permite que los elementos se muevan más rápidamente hacia sus posiciones correctas al reducir progresivamente las distancias entre los elementos a comparar.

## ¿Cómo lo resuelve?
Shell Sort divide el array en varios subgrupos basados en una secuencia de "gaps" o intervalos. Estos subgrupos se ordenan utilizando Insertion Sort, pero en lugar de elementos adyacentes, se comparan los elementos separados por un número de posiciones determinado por el tamaño del "gap". A medida que se reduce el valor del "gap", los subgrupos se vuelven más pequeños, hasta que el "gap" es igual a 1, lo que hace que el algoritmo realice una pasada final como Insertion Sort.

## Pasos Claves:
1. Gap Sequence (Secuencia de brechas): El algoritmo comienza con una "brecha" o "gap" que representa la distancia entre los elementos a comparar. La secuencia de brechas se reduce en cada iteración.

2. Insertion Sort adaptado: Dentro de cada grupo separado por el "gap", se aplica un ordenamiento por inserción.

3. Reducción del gap: Después de cada pasada, el valor del "gap" se reduce, haciendo que los elementos se comparen con sus vecinos más cercanos.

4. Finalización: Cuando el "gap" se reduce a 1, se ejecuta una pasada final similar a Insertion Sort, pero con un array casi ordenado, lo que mejora la eficiencia.

## Implementación
```java
import java.util.Arrays;

public class ShellSort {

    // Método para realizar el algoritmo Shell Sort
    public static void shellSort(int[] array) {
        int n = array.length;

        // Inicializamos el valor del gap, empezando con la mitad del tamaño del array
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Realizamos el ordenamiento por inserción para cada subarray definido por el gap
            for (int i = gap; i < n; i++) {
                int currentElement = array[i];  // El elemento a ser insertado
                int j = i;

                // Desplazamos elementos del subarray hacia la derecha si son mayores que el currentElement
                while (j >= gap && array[j - gap] > currentElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                // Insertamos el currentElement en su posición adecuada
                array[j] = currentElement;
            }
        }
    }

    // Método principal para probar el algoritmo Shell Sort
    public static void main(String[] args) {
        int[] array = {12, 34, 54, 2, 3};
        
        System.out.println("Array original:");
        System.out.println(Arrays.toString(array));

        // Llamar a la función shellSort
        shellSort(array);

        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(array));
    }
}
```
### Explicación del código:
Método shellSort:

La variable gap se inicializa como la mitad de la longitud del array (n / 2) y se reduce a la mitad en cada iteración hasta llegar a gap = 1.
Dentro de cada intervalo de gap, se realiza un ordenamiento por inserción.
El bucle interno usa un desplazamiento de elementos para reorganizar el array.
Gap Sequence:

El gap se divide sucesivamente por 2 en cada iteración (esta es una secuencia clásica de Shell). Otras secuencias de brechas pueden mejorar el rendimiento, pero la más simple es dividir el tamaño del array por 2.
Comparación y desplazamiento:

En cada paso del bucle interno, se compara array[j - gap] con currentElement. Si es mayor, se mueve hacia la derecha.
Esto permite que los elementos más grandes se muevan rápidamente hacia el final del array sin tener que pasar por cada elemento adyacente.
Finalización:

Cuando el gap se reduce a 1, el algoritmo realiza una pasada final similar a Insertion Sort, pero en un array que ya está parcialmente ordenado, lo que mejora la eficiencia.

### Ejemplo de Ejecución:
Dado el array {12, 34, 54, 2, 3}, el proceso de Shell Sort se vería así:

Gap = 2:

Comenzamos comparando y ordenando elementos separados por 2 posiciones.
Comparar {12, 54}, como 12 < 54, no se intercambian.
Comparar {34, 2}, como 34 > 2, intercambiamos.
Array: {12, 2, 54, 34, 3}.
Gap = 1:

Ahora hacemos una pasada final similar a Insertion Sort con elementos adyacentes.
Comparar {12, 2}, intercambiamos.
Comparar {12, 54}, no se intercambian.
Comparar {54, 34}, intercambiamos.
Comparar {54, 3}, intercambiamos.
Array: {2, 3, 12, 34, 54}.
