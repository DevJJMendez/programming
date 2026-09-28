# Arrays
Un array es una estructura de datos que almacena una colección de **elementos del mismo tipo** en posiciones contiguas de memoria.

**Ejemplo conceptual:** Imagina una fila de casillas numeradas (índices) donde cada casilla almacena un valor:
```makefile
Índices:   [ 0  , 1  , 2  , 3  , 4  ]
Valores:   [ 10 , 20 , 30 , 40 , 50 ]
```
Aquí, el array tiene 5 elementos y cada uno está asociado con un índice.

**Los arrays son una de las estructuras de datos más utilizadas en programación, ya que permiten almacenar múltiples valores en una sola variable de manera eficiente.**

## ¿Para qué sirven los Arrays?
Los arrays permiten:

* Almacenar y manipular grandes conjuntos de datos de manera eficiente.

* Acceder rápidamente a elementos individuales usando su índice.

* Optimizar la memoria, ya que los elementos se almacenan en posiciones contiguas.

* Representar estructuras más complejas como matrices, tablas y vectores.

**Casos de uso en la vida real:**
* Un carrito de compras en un ecommerce (lista de productos).

* Un ranking de jugadores en un videojuego.

* Datos de sensores en una aplicación de IoT.

* Un calendario, donde cada día es un índice en el array.

## ¿Cuál es su estructura?
Un array tiene los siguientes componentes:

1. **Nombre** → El identificador del array.

2. **Tamaño (longitud)** → La cantidad de elementos que puede almacenar.

3. **Índices** → Números que identifican cada posición dentro del array.

4. **Valores** → Los datos almacenados en cada posición del array.

Ejemplo en Java
```java
int[] numeros = {10, 20, 30, 40, 50};
```
* numeros es el nombre del array.
* Tiene 5 elementos.
* Se accede a cada elemento con su índice (numeros[0] es 10, numeros[4] es 50).

**Declaración y creación de un array vacío:**
```java
int[] edades = new int[5]; // Array de tamaño 5, inicializado con valores 0
```

## ¿Qué resuelven los Arrays?
Los arrays permiten almacenar y organizar grandes volúmenes de datos de manera eficiente.

* Evitan el uso de variables individuales → En lugar de declarar int a, b, c, d;, usamos un array int[] valores = new int[4];.

* Acceso rápido a los elementos → Podemos acceder a cualquier elemento en O(1) con su índice (arr[i]).

* Facilitan la manipulación de datos → Son útiles para operaciones como ordenamiento, búsqueda y filtrado.

## ¿Cómo lo resuelven?
Los arrays solucionan el almacenamiento de datos mediante memoria contigua y acceso indexado.

Ejemplo de acceso, modificación e iteración en Java:
```java
public class ArrayEjemplo {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};

        // Acceder a un elemento
        System.out.println("Elemento en índice 2: " + numeros[2]); // 30

        // Modificar un elemento
        numeros[2] = 99;
        System.out.println("Elemento en índice 2 modificado: " + numeros[2]); // 99

        // Recorrer el array con un bucle
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Índice " + i + ": " + numeros[i]);
        }
    }
}
```
## Tipos de Arrays
1. Arrays Unidimensionales → Una sola fila de datos.
```java
int[] edades = {25, 30, 35, 40};
```

2. Arrays Multidimensionales (Matrices) → Datos organizados en filas y columnas.
```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```
Acceder a un elemento: matriz[1][2] devuelve 6 (fila 1, columna 2).

3. Arrays Dinámicos (Listas en Java) → Usamos ArrayList para evitar definir un tamaño fijo.
```java
import java.util.ArrayList;

ArrayList<String> nombres = new ArrayList<>();
nombres.add("Juan");
nombres.add("María");
```
# `Arrays Class`
La clase `Arrays` en Java es una clase utilitaria que forma parte del paquete `java.util`. No se utiliza para crear arrays propiamente dichos, sino que ofrece una serie de métodos estáticos para manipular y operar sobre arrays. Esencialmente, facilita el trabajo con arrays en Java proporcionando una variedad de funciones como ordenar, buscar, comparar, copiar y convertir arrays a cadenas.

## ¿Qué es la clase `Arrays`?
La clase `Arrays` es una colección de métodos estáticos que actúa sobre arrays de tipos primitivos (como int, double, etc.) y arrays de objetos. Todos los métodos que ofrece esta clase son estáticos, lo que significa que se acceden directamente desde la clase sin necesidad de crear una instancia de ella.

## ¿Para qué sirve la clase `Arrays`?
La clase `Arrays` facilita la manipulación y el manejo de arrays en Java. Algunas de las operaciones más comunes que puedes realizar usando esta clase incluyen:

1. **Ordenar arrays (`sort`)**.

2. **Buscar elementos en un array (`binarySearch`)**.

3. **Rellenar arrays con un valor específico (`fill`)**.

4. **Copiar arrays o partes de arrays (`copyOf`, `copyOfRange`)**.

5. **Comparar arrays para ver si son iguales (`equals`)**.

6. **Convertir arrays a cadenas de texto (`toString`, `deepToString`)**.

## ¿Qué resuelve la clase `Arrays`?
Manipular arrays en Java puede ser tedioso y propenso a errores si se hace manualmente. La clase `Arrays` resuelve estos problemas al proporcionar métodos optimizados que:

1. **Facilitan la manipulación de arrays**, sin la necesidad de escribir código repetitivo.

2. **Aumentan la legibilidad** del código, ya que los métodos son descriptivos y fáciles de entender.

3. **Reducen errores** al manejar tareas comunes de forma optimizada y segura.

4. **Mejoran el rendimiento**, ya que la mayoría de los métodos están altamente optimizados para el procesamiento de arrays.

## ¿Cómo lo resuelve la clase `Arrays`?
La clase `Arrays` ofrece una variedad de métodos para abordar problemas comunes de manipulación de arrays.

## Métodos importantes de la clase `Arrays`
1. **Ordenar un array (`sort`)**: Ordena los elementos de un array en orden ascendente. Funciona tanto para tipos primitivos como para objetos que implementen la interfaz `Comparable`.
```java
import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 9};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers)); // Salida: [1, 3, 5, 8, 9]
    }
}
```

2. **Buscar en un array (`binarySearch`)**: Realiza una búsqueda binaria en un array ordenado para encontrar la posición de un elemento. Si el elemento no está presente, devuelve un valor negativo.
```java
int[] numbers = {1, 3, 5, 7, 9};
int index = Arrays.binarySearch(numbers, 5);
System.out.println(index); // Salida: 2
```

3. **Rellenar un array (`fill`)**: Llena un array completo con un valor específico.
```java
int[] numbers = new int[5];
Arrays.fill(numbers, 7);
System.out.println(Arrays.toString(numbers)); // Salida: [7, 7, 7, 7, 7]
```

4. **Copiar un array (`copyOf` y `copyOfRange`)**: Copia el array original en uno nuevo, permitiendo especificar el tamaño del nuevo array. También se puede copiar un rango específico del array.
```java
int[] original = {1, 2, 3, 4, 5};
int[] copy = Arrays.copyOf(original, 3); // Copia los primeros 3 elementos
System.out.println(Arrays.toString(copy)); // Salida: [1, 2, 3]
```
```java
int[] rangeCopy = Arrays.copyOfRange(original, 1, 4); // Copia desde el índice 1 hasta 4 (exclusivo)
System.out.println(Arrays.toString(rangeCopy)); // Salida: [2, 3, 4]
```

5. **Comparar arrays (`equals`)**: Compara dos arrays y devuelve true si ambos son iguales (misma longitud y mismos elementos en el mismo orden).

```java
int[] array1 = {1, 2, 3};
int[] array2 = {1, 2, 3};
boolean areEqual = Arrays.equals(array1, array2);
System.out.println(areEqual); // Salida: true
```

6. **Convertir un array a una cadena (`toString` y `deepToString`)**: Convierte un array a una representación de cadena. `deepToString` se utiliza para arrays multidimensionales.
```java
int[] numbers = {1, 2, 3};
System.out.println(Arrays.toString(numbers)); // Salida: [1, 2, 3]

int[][] multiArray = {{1, 2}, {3, 4}};
System.out.println(Arrays.deepToString(multiArray)); // Salida: [[1, 2], [3, 4]]
```