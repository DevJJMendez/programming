# Linear Search
El algoritmo de búsqueda Lineal o Linear Search es uno de los algoritmos de búsqueda más simples y básicos. Se utiliza para encontrar un elemento en un array o lista secuencialmente, revisando cada elemento uno por uno hasta encontrar el elemento buscado o recorrer toda la lista.

## ¿Qué es Linear Search?
Linear Search es un algoritmo que busca un elemento en una lista o array comparando el elemento objetivo con cada uno de los elementos de la lista, uno a uno, en orden secuencial.

## ¿Qué resuelve?
Linear Search resuelve el problema de encontrar un elemento dentro de un array o lista no ordenada. Funciona en cualquier lista o array, sin importar si están ordenados o no. Aunque no es el algoritmo más eficiente para grandes listas, es fácil de implementar y es útil en ciertas circunstancias, como en listas pequeñas o cuando no se tiene garantía de que la lista esté ordenada.

## ¿Cómo lo resuelve?
1. Se comienza desde el primer elemento de la lista o array.

2. Cada elemento se compara con el valor que se busca.

3. Si se encuentra el valor buscado, el algoritmo devuelve la posición o índice de ese elemento.

4. Si no se encuentra el valor tras recorrer toda la lista, el algoritmo indica que el valor no está presente en la lista.

## Estructura del algoritmo
Recorrido secuencial: Linear Search realiza un recorrido secuencial del array o lista, elemento por elemento.
Complejidad:
La complejidad temporal es O(n), donde n es el número de elementos en la lista. Esto se debe a que, en el peor caso, el algoritmo debe revisar todos los elementos del array.
La complejidad espacial es O(1), ya que no requiere espacio adicional aparte de variables simples.

## Implementación
```java
public class LinearSearch {

    // Método para realizar la búsqueda lineal
    public static int linearSearch(int[] array, int target) {
        // Recorre el array elemento por elemento
        for (int index = 0; index < array.length; index++) {
            // Si el elemento en el índice actual es igual al objetivo
            if (array[index] == target) {
                return index; // Retorna el índice donde se encontró el elemento
            }
        }
        // Si el elemento no se encuentra en el array
        return -1;
    }

    // Método principal para probar Linear Search
    public static void main(String[] args) {
        int[] array = {10, 50, 30, 70, 80, 20, 90};
        int target = 70;

        // Llamar a Linear Search
        int result = linearSearch(array, target);

        if (result == -1) {
            System.out.println("Elemento no encontrado en el array.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + result);
        }
    }
}
```
### Desglose paso a paso
Supongamos que tienes el array {10, 50, 30, 70, 80, 20, 90} y estás buscando el valor 70.

Paso 1: El algoritmo comienza revisando el primer elemento del array, que es 10. Como 10 no es igual a 70, pasa al siguiente elemento.
Paso 2: Revisa el siguiente elemento, 50. Nuevamente, no coincide, por lo que sigue buscando.
Paso 3: Repite este proceso con 30.
Paso 4: Cuando llega al elemento 70, se detecta una coincidencia, y el algoritmo devuelve el índice donde se encontró, en este caso, 3.

## Puntos clave de Linear Search
Simplicidad: Linear Search es muy fácil de implementar y entender. Solo requiere recorrer secuencialmente la lista.
Flexibilidad: Funciona para listas de cualquier tipo, ya sea ordenadas o desordenadas.
Desventajas: Para listas largas, puede ser ineficiente, ya que en el peor de los casos, necesitará recorrer todos los elementos. Esto lo hace menos eficiente que otros algoritmos de búsqueda, como Binary Search, en listas grandes.