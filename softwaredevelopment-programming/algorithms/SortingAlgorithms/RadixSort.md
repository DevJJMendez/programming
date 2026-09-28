# Radix Sort
Radix Sort es un algoritmo de ordenamiento no comparativo que ordena los números procesando dígito por dígito. El algoritmo clasifica los números agrupándolos por sus dígitos más significativos o menos significativos, dependiendo de la implementación. Es útil para ordenar números enteros o cadenas de texto de longitud fija.

## ¿Qué resuelve?
Radix Sort resuelve el problema de ordenar conjuntos de datos numéricos o cadenas de caracteres de manera eficiente, especialmente cuando los datos tienen un rango limitado de valores posibles o cuando los números tienen una longitud fija de dígitos. A diferencia de algoritmos comparativos (como QuickSort o MergeSort), Radix Sort tiene una complejidad de tiempo lineal relativa al número de elementos y la longitud de los números o cadenas que ordena.

## ¿Cómo lo resuelve?
Radix Sort funciona al procesar cada dígito del número, de menor a mayor significancia (para el caso de LSD - Least Significant Digit) o viceversa (para MSD - Most Significant Digit). Normalmente, se usa otro algoritmo de ordenación estable, como el Counting Sort, para ordenar los dígitos individuales.

## Estrategia de ordenamiento:
* Least Significant Digit (LSD) Radix Sort: Se ordena comenzando desde el dígito menos significativo (la unidad).

* Most Significant Digit (MSD) Radix Sort: Se ordena comenzando desde el dígito más significativo (la posición de mayor valor).

## Funcionamiento paso a paso (LSD Radix Sort):
1. Seleccionar el dígito menos significativo (unidad) de cada número.

2. Ordenar los números basándose en ese dígito usando Counting Sort (u otro algoritmo de ordenamiento estable).

3. Repetir el proceso para el siguiente dígito más significativo (decenas, centenas, etc.).

4. Continuar hasta que todos los dígitos de los números hayan sido procesados.

5. El array estará ordenado después de procesar el dígito más significativo.

Complejidad:
* Tiempo: O(d*(n+k)), donde:
  * n es el número de elementos,
  * d es la cantidad de dígitos en el número más grande,
  * k es el rango de los valores posibles de los dígitos (en el caso de números decimales, k=10)

* Espacio: O(n+k) ya que se requiere espacio adicional para realizar el Counting Sort.

## Implementación
```java
import java.util.Arrays;

public class RadixSort {
    // Función principal que ordena usando Radix Sort
    public static void radixSort(int[] array) {
        // Encontrar el número máximo para saber el número de dígitos
        int maxValue = getMax(array);

        // Aplicar Counting Sort para cada dígito
        // El exponente exp es 10^i donde i es el dígito actual (unidad, decena, centena...)
        for (int exp = 1; maxValue / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    // Función para obtener el valor máximo del array
    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Counting Sort modificado para ordenar según el dígito representado por exp
    private static void countingSort(int[] array, int exp) {
        int length = array.length;
        int[] output = new int[length]; // Array de salida
        int[] count = new int[10];      // Array para almacenar el conteo de dígitos (0 a 9)

        // Inicializar el array de conteo con ceros
        Arrays.fill(count, 0);

        // Contar las ocurrencias de cada dígito en el exp actual
        for (int i = 0; i < length; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }

        // Cambiar count[] para que contenga las posiciones reales en output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir el array de salida
        for (int i = length - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copiar el array de salida a array[], de modo que ahora contiene los números ordenados
        for (int i = 0; i < length; i++) {
            array[i] = output[i];
        }
    }

    // Método principal para probar Radix Sort
    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Array original:");
        System.out.println(Arrays.toString(array));

        radixSort(array);

        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(array));
    }
}
```
### Explicación paso a paso:
1. Encontrar el valor máximo: Esto es necesario para determinar el número de dígitos del número más grande, lo cual define cuántas iteraciones de ordenamiento basadas en dígitos se realizarán.

2. Counting Sort adaptado:
   
   * En cada iteración, ordenamos los números basándonos en un dígito específico (unidad, decena, centena, etc.). El valor de `exp` define qué dígito se está ordenando. Para la primera iteración, `exp = 1`(ordenar por unidades), luego `exp = 10` (ordenar por decenas), y así sucesivamente.

   * Usamos Counting Sort para garantizar que el algoritmo sea estable.

3. Proceso iterativo: Repetimos el proceso para cada dígito del número, empezando desde las unidades hasta el dígito más significativo.

### Puntos clave:
* Counting Sort se utiliza como subrutina en cada paso para ordenar los números basados en sus dígitos.

* Estabilidad: El algoritmo es estable porque mantiene el orden relativo de números con dígitos iguales. Esto es esencial para que Radix Sort funcione correctamente.

* Complejidad temporal: Radix Sort tiene una complejidad lineal O(d⋅(n+k)), donde d es el número de dígitos, n es el número de elementos en la lista, y k es el rango de los dígitos (en este caso, 10, ya que estamos trabajando en base 10).

* Limitaciones: Es más eficiente cuando se trabaja con números de longitud fija o cadenas cortas. Para grandes números o cadenas, la complejidad puede aumentar.

### Comparación con otros algoritmos:
Ventajas:

Es eficiente para datos con un número fijo de dígitos o un rango limitado de valores.
Tiene un tiempo de ejecución lineal en ciertos casos, lo que lo hace más rápido que otros algoritmos comparativos para este tipo de problemas.
Desventajas:

Requiere espacio adicional para almacenar los conteos y los datos intermedios, lo que puede ser un problema para grandes conjuntos de datos.
No es aplicable a datos que no puedan representarse de manera sencilla como enteros de base 10 o cadenas de caracteres.
