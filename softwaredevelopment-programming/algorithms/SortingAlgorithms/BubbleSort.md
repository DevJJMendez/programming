#SortingAlgorithms
# Bubble Sort
Bubble Sort es un algoritmo de ordenamiento por comparación e intercambio que recorre repetidamente la lista, comparando pares adyacentes y haciendo swap cuando están en el orden equivocado. Tras cada pasada, el mayor (o menor según la dirección) “burbujea” hacia su posición final. Es uno de los algoritmos más simples y didácticos, pero poco eficiente para grandes entradas.

## Puntos clave
* **Eficiencia**: Tiene una complejidad temporal de `O(n2)` en el peor caso, por lo que no es adecuado para grandes volúmenes de datos.

* **Facilidad de implementación**: Es un algoritmo muy simple de implementar y entender.

* **In-place**: No necesita espacio extra, ya que los intercambios se realizan dentro del mismo arreglo.

* **Estabilidad**: Es un algoritmo estable, lo que significa que mantiene el orden relativo de los elementos iguales.

## ¿Qué resuelve?
Bubble Sort resuelve el problema de organizar un conjunto de datos de manera ordenada (ascendente o descendente). Se utiliza cuando el **volumen de datos es pequeño** o cuando la simplicidad de implementación es prioritaria sobre la eficiencia.

## ¿Cómo lo resuelve?
El algoritmo recorre el arreglo varias veces. En cada iteración, compara los elementos consecutivos e intercambia aquellos que están en el orden incorrecto. Al final de cada iteración, el elemento más grande (o más pequeño) termina en su posición correcta, reduciendo efectivamente el tamaño del arreglo que necesita ordenarse en cada pasada.

### Implementación
```java
public class BubbleSort {
  public static void main(String[] args) {
    int[] numbersList = { 9, 2, 3, 1, 8, 5, 0, 4, 10, 6, 7 };
    int arrayLength = numbersList.length;
    for (int i = 0; i < arrayLength; i++) {
      for (int j = i + 1; j < arrayLength; j++) {
        if (numbersList[i] > numbersList[j]) {
          int temporalSlot = numbersList[i];
          numbersList[i] = numbersList[j];
          numbersList[j] = temporalSlot;
        }
      }
    }
    printArray(numbersList);
  }
  
  public static void printArray(int[] array) {
    for (int numbers : array) {
      System.out.println(numbers + " ");
    }
    System.out.println();
  }
}
```
Salida esperada:
```bash
0 
1 
2 
3 
4 
5 
6 
7 
8 
9 
10
```