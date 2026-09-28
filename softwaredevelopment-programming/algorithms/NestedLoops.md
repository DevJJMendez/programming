# Nested Loops
Los bucles anidados son bucles que se encuentran dentro de otros bucles. Esto significa que por cada iteración del bucle externo, el bucle interno completa todas sus iteraciones. Este patrón es común cuando se trabaja con estructuras de datos que tienen múltiples dimensiones, como arreglos bidimensionales (matrices), o cuando se realizan comparaciones múltiples, como en algoritmos de ordenamiento.

## Funcionamiento de los bucles anidados
La idea central es que el bucle interno completa todas sus iteraciones cada vez que el bucle externo da un paso. Es decir, por cada iteración del bucle externo, el bucle interno se ejecuta desde el principio hasta el final.

Sintaxis general de un bucle anidado:
```java
for (int i = 0; i < limit1; i++) {      // Bucle externo
    for (int j = 0; j < limit2; j++) {  // Bucle interno
        // Bloque de código que se ejecuta en cada iteración del bucle interno
    }
}
```
* El bucle externo (`for (int i = 0; i < limit1; i++)`) controla las iteraciones globales.

* El bucle interno (`for (int j = 0; j < limit2; j++)`) se ejecuta completamente para cada iteración del bucle externo.

### Ejemplo básico de bucles anidados
Imaginemos que queremos imprimir una tabla de números usando bucles anidados:
```java
public class NestedLoopsExample {
    public static void main(String[] args) {
        // Bucle externo
        for (int row = 1; row <= 3; row++) {
            // Bucle interno
            for (int col = 1; col <= 3; col++) {
                System.out.print(row * col + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }
}
```
Salida
```bash
1 2 3 
2 4 6 
3 6 9 
```
**Explicación**:
* El bucle externo controla las filas de la tabla.

* El bucle interno controla las columnas.

* En cada iteración del bucle externo, el bucle interno se ejecuta desde col = 1 hasta col = 3. Después de que el bucle interno termina, el bucle externo incrementa su valor (row) y el proceso se repite.

### Profundización: complejidad de los bucles anidados
Los bucles anidados incrementan la cantidad total de operaciones que se ejecutan. Si ambos bucles tienen una cantidad de iteraciones de tamaño n, el número total de operaciones será proporcional a n * n, es decir, O(n2), lo que indica que el algoritmo tiene una complejidad cuadrática.

**Ejemplo de complejidad en bucles anidados**

Supongamos que tenemos un array unidimensional y queremos encontrar todos los pares posibles de elementos en ese array.
```java
public class NestedLoopsPairs {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};

        // Bucle externo recorre cada elemento
        for (int i = 0; i < numbers.length; i++) {
            // Bucle interno recorre cada elemento, partiendo del siguiente al índice del externo
            for (int j = i + 1; j < numbers.length; j++) {
                System.out.println("Pair: (" + numbers[i] + ", " + numbers[j] + ")");
            }
        }
    }
}
```
Salida
```bash
Pair: (1, 2)
Pair: (1, 3)
Pair: (1, 4)
Pair: (2, 3)
Pair: (2, 4)
Pair: (3, 4)
```
**Explicación del flujo:**
* El bucle externo (i) selecciona un número del array.

* El bucle interno (j) selecciona el siguiente número del array que no haya sido emparejado con el número actual.

* Esto genera todos los pares posibles de números sin repetir combinaciones.