# `while`
se utiliza para ejecutar repetidamente un bloque de código mientras se cumpla una condición específica. Es una estructura de control que permite la iteración basada en una expresión booleana, evaluada antes de cada iteración del bucle.

## Sintaxis del Bucle while
La sintaxis básica del bucle while es la siguiente:

```java
while (condición) {
    // Bloque de código a ejecutar
}
```
- **Donde**:
  - **condición** es una expresión booleana que se evalúa antes de cada iteración del bucle.
  - **Si** la condición es `true`, se ejecuta el bloque de código.
  - **Si** la condición es `false`, el bucle termina y se continúa con la ejecución del código que sigue al bucle.

## Ejemplo Básico
```java
public class WhileExample {
    public static void main(String[] args) {
        int i = 1;

        while (i <= 5) {
            System.out.println("Número: " + i);
            i++;
        }
    }
}
```
En este ejemplo, el bucle while imprime los números del 1 al 5. La variable i se incrementa en cada iteración, y el bucle termina cuando i es mayor que 5.

## Ejemplo con una Condición Compleja
```java
public class WhileComplexCondition {
    public static void main(String[] args) {
        int number = 10;

        while (number > 0) {
            if (number % 2 == 0) {
                System.out.println(number + " es par.");
            } else {
                System.out.println(number + " es impar.");
            }
            number--;
        }
    }
}
```
En este ejemplo, el bucle while cuenta hacia atrás desde 10 y determina si cada número es par o impar.

## `while` y Entradas del Usuario
El bucle while es útil para leer entradas del usuario hasta que se cumpla una condición de terminación específica.
```java
import java.util.Scanner;

public class WhileUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Escribe 'exit' para salir: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Ingresaste: " + input);
        }

        scanner.close();
    }
}
```
En este ejemplo, el bucle while sigue solicitando entradas del usuario hasta que el usuario escribe "exit".

## Bucle `while` Infinito
Un bucle while sin una condición de terminación puede volverse un bucle infinito. Esto puede ser útil en ciertas aplicaciones, como servidores que deben estar siempre en ejecución, pero generalmente debe evitarse a menos que esté justificado y controlado adecuadamente.

```java
while (true) {
    // Código que se ejecuta infinitamente
}
```

## do-while
A diferencia del bucle `while`, el bucle `do-while` garantiza que el bloque de código se ejecute al menos una vez, ya que la condición se evalúa después de la ejecución del bloque de código.

- **Sintaxis del `do-while`**
  ```java
  do {
      // Bloque de código a ejecutar
  } while (condición);
  ```
- **Ejemplo de `do-while`**
```java
public class DoWhileExample {
    public static void main(String[] args) {
        int i = 1;

        do {
            System.out.println("Número: " + i);
            i++;
        } while (i <= 5);
    }
}
```
En este ejemplo, el bloque de código dentro del do-while se ejecuta primero, y luego se evalúa la condición. Esto asegura que el bloque de código se ejecute al menos una vez.

## Buenas Prácticas

- **Condiciones Claras**: Asegúrate de que la condición del bucle while eventualmente se vuelva false para evitar bucles infinitos no deseados.
- **Incrementos/Decrementos**: Si usas una variable de control, como en los ejemplos con i y number, asegúrate de actualizarla adecuadamente dentro del bucle.
- **Condiciones de Terminación**: En bucles que dependen de entradas del usuario, incluye una condición clara para salir del bucle, como la palabra clave "exit".
- **Legibilidad**: Mantén el cuerpo del bucle while lo más simple y legible posible. Si el cuerpo del bucle es complejo, considera refactorizarlo en métodos separados.


---

# for loop
es una estructura de control que permite ejecutar repetidamente un bloque de código un número determinado de veces. Es especialmente útil cuando se conoce de antemano cuántas veces debe repetirse la operación. La sintaxis del bucle for en Java es más compacta y estructurada que la de un bucle while, lo que facilita la escritura y la comprensión de bucles con contadores.

## Sintaxis del Bucle for
La sintaxis básica de un `bucle for` es la siguiente:

```java
for (inicialización; condición; actualización) {
    // Bloque de código a ejecutar
}
```
- **Donde**:
  - **Inicialización**: Se ejecuta una sola vez al comienzo del bucle y se usa para declarar e inicializar variables de control.
  - **Condición**: Se evalúa antes de cada iteración del bucle. Si es true, se ejecuta el bloque de código; si es false, el bucle termina.
  - **Actualización**: Se ejecuta al final de cada iteración y se usa para actualizar la variable de control.

## Ejemplo Básico
```java
public class ForExample {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Número: " + i);
        }
    }
}
```
En este ejemplo, el bucle for imprime los números del 0 al 4. La variable i se inicializa en 0, y en cada iteración se incrementa en 1 hasta que i sea menor que 5.

## Ejemplo con Arreglos

El bucle for es muy útil para iterar sobre arreglos.

```java
public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Número: " + numbers[i]);
        }
    }
}
```
En este ejemplo, el bucle for itera sobre todos los elementos del arreglo numbers y los imprime.

## Bucle for-each

Java también proporciona una variante del bucle `for` llamada `for-each`, que es especialmente útil para iterar sobre arreglos y colecciones de una manera más legible.

## Sintaxis del Bucle for-each
```java
for (tipo elemento : colección) {
    // Bloque de código a ejecutar
}
```

- Ejemplo con `for-each`
```java
public class ForEachExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        for (int number : numbers) {
            System.out.println("Número: " + number);
        }
    }
}
```
En este ejemplo, el bucle for-each itera sobre todos los elementos del arreglo numbers y los imprime.

## Bucle for Anidado

Los bucles for pueden anidarse para iterar sobre estructuras de datos multidimensionales, como matrices.

```java
public class NestedForExample {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Elemento [" + i + "][" + j + "]: " + matrix[i][j]);
            }
        }
    }
}
```
En este ejemplo, los bucles for anidados iteran sobre todos los elementos de una matriz bidimensional y los imprimen.

## Control del Bucle

- **Uso de `break`**

La sentencia **break** se usa para salir del bucle antes de que se complete todas las iteraciones.
```java
public class BreakExample {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println("Número: " + i);
        }
    }
}
```
En este ejemplo, el bucle se interrumpe cuando `i` es igual a 5.

- **Uso de `continue`**

La sentencia **continue** se usa para saltar la iteración actual y pasar a la siguiente iteración del bucle.
```java
public class ContinueExample {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println("Número impar: " + i);
        }
    }
}
```
En este ejemplo, el bucle **for** imprime solo los números impares, saltando las iteraciones donde `i` es un número par.

## Buenas Prácticas
- **Variables Descriptivas**: Usa nombres de variables descriptivos en la inicialización para mejorar la legibilidad del código.
- **Evita Modificar la Variable de Control Dentro del Bucle**: Modificar la variable de control dentro del cuerpo del bucle puede llevar a resultados inesperados y debe evitarse.
- **Condiciones Claras**: Asegúrate de que las condiciones del bucle sean claras y comprensibles para evitar bucles infinitos o errores lógicos.

---

# for-each loop
es una estructura de control diseñada para iterar sobre elementos de colecciones y arreglos de una manera más legible y menos propensa a errores que el bucle **for** tradicional. Simplifica la iteración porque elimina la necesidad de manejar el índice de los elementos manualmente.

## Sintaxis del Bucle `for-each`

La sintaxis básica del bucle **for-each** es:

```java
for (tipo elemento : colección) {
    // Bloque de código a ejecutar
}
```

- **tipo**: El tipo de los elementos en la colección o el arreglo.

- **elemento**: Una variable que tomará el valor de cada elemento en la colección o arreglo durante cada iteración.

- **colección**: La colección o arreglo sobre la cual se está iterando.

## **Ejemplo Básico**
Supongamos que tenemos un arreglo de enteros:
```java
int[] numbers = {1,2,3,5};
```
Iterar sobre este arreglo usando un bucle **for-each** sería:
```java
for (int number : numbers) {
    System.out.println(number);
}
```
**En cada iteración del bucle**:
- La variable `number` toma el valor del siguiente elemento en el arreglo `numbers`.

- El bloque de código dentro del bucle se ejecuta utilizando el valor actual de number.

## Ejemplo con Colección
El bucle **for-each** es muy útil para trabajar con colecciones como listas, conjuntos y mapas.

```java
import java.util.ArrayList;
import java.util.List;

public class ForEachCollectionExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```
En este ejemplo, el bucle **for-each** itera sobre todos los elementos de la lista fruits e imprime cada uno.

## Consideraciones y Limitaciones

- **Solo para Lectura**: La variable elemento en un bucle for-each es de solo lectura respecto al arreglo o colección. No se puede modificar el contenido de la colección o arreglo directamente a través de esta variable.
  
  - Por ejemplo, si se necesita modificar los elementos durante la iteración, se debe usar un bucle for tradicional con índices.

- **Iterables**: El bucle **for-each** funciona con cualquier objeto que implemente la interfaz `Iterable`, como listas, conjuntos y otras colecciones. También funciona con arreglos.

- **No Directamente Modificable**: Para estructuras donde se necesita modificar la colección durante la iteración, el **for-each** no es adecuado. En tales casos, es mejor usar un iterador explícito.