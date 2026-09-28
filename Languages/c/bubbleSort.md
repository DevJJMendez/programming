## Bubble Sort
Bubble Sort es un algoritmo de ordenamiento simple, **pero ineficiente para grandes volúmenes de datos**. Funciona comparando elementos adyacentes en un array o lista y los intercambia si están en el orden incorrecto. Este proceso se repite varias veces hasta que la lista esté completamente ordenada.

Se llama "bubble" (burbuja) porque los elementos "burbujearán" hacia arriba a medida que se mueven hacia su posición correcta.

### ¿Qué resuelve?
Bubble Sort resuelve el problema de ordenar una secuencia de elementos de una lista o array. El objetivo es organizar los elementos en orden ascendente o descendente, lo que permite búsquedas y análisis más eficientes. Aunque es fácil de entender e implementar, es ineficiente para listas grandes debido a su complejidad.

### Cómo lo resuelve?
Lógica:

Recorre la lista comparando pares de elementos adyacentes.
Si el primer elemento es mayor que el segundo (en el caso de un orden ascendente), intercambia sus posiciones.
Repite este proceso hasta que no haya más intercambios, lo que indica que la lista está ordenada.

Pasos del algoritmo:

Comienza desde el principio del array y compara el primer par de elementos.
Si el primer elemento es mayor que el segundo, los intercambia.
Luego, mueve el índice al siguiente par de elementos adyacentes y repite el proceso.
Cuando llega al final de la lista, los elementos más grandes estarán "burbujando" hacia el final.
Vuelve al inicio y repite todo el proceso hasta que no se realicen más intercambios.

### Cuando se usa
Bubble Sort es uno de los algoritmos más básicos y no se recomienda para situaciones en las que el rendimiento es importante, ya que tiene una complejidad temporal de O(n²) en el peor y promedio de los casos. Es útil para:

Listas pequeñas: Puede ser usado en listas pequeñas o cuando la simplicidad del código es una prioridad.
Datos casi ordenados: Puede ser útil cuando los datos ya están casi ordenados, ya que Bubble Sort puede detectar si la lista está ordenada y terminar rápidamente.
Aprendizaje: Se utiliza como un ejemplo introductorio para entender algoritmos de ordenación debido a su simplicidad.

Ejemplo
```c
#include <stdio.h>

void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n-1; i++) {
        // Bucle interno para hacer comparaciones
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                // Intercambio de elementos
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

int main() {
    int arr[] = {5, 2, 9, 1, 5, 6};
    int n = sizeof(arr)/sizeof(arr[0]);

    bubbleSort(arr, n);

    printf("Array ordenado: \n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}

```