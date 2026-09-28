# `BinaryOperator<T>`
`BinaryOperator<T>` es una interfaz funcional en Java que representa una operación sobre dos operandos del mismo tipo, produciendo un resultado del mismo tipo que los operandos. Es una especialización de la interfaz `BiFunction<T, T, T>`, donde tanto los dos argumentos de entrada como el resultado tienen el mismo tipo.

**Definición de la interfaz**
```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> {
    // Métodos adicionales pueden estar definidos aquí
}
```

## ¿Qué es `BinaryOperator<T>`?
`BinaryOperator<T>` es una interfaz funcional que toma dos argumentos de tipo `T` y devuelve un resultado del mismo tipo `T`. Esto lo hace ideal para operaciones binarias que involucran el mismo tipo de entrada y salida, como sumar, restar, multiplicar o comparar objetos del mismo tipo.

## ¿Para qué sirve?
`BinaryOperator<T>` se utiliza principalmente para definir operaciones que toman dos operandos del mismo tipo y devuelven un resultado del mismo tipo. Se utiliza a menudo en algoritmos de reducción, donde los elementos de una colección se combinan de dos en dos hasta obtener un solo resultado.

## ¿Qué resuelve?
`BinaryOperator<T> `resuelve la necesidad de realizar operaciones binarias sobre dos valores del mismo tipo de una manera clara y funcional. Puede ser útil en tareas como combinar dos valores en una operación matemática o elegir un valor basado en una comparación.

## ¿Cómo lo resuelve?
Lo resuelve proporcionando una interfaz funcional que encapsula operaciones binarias, lo que permite la creación de expresiones más concisas y reutilizables. Con `BinaryOperator<T>`, puedes evitar la necesidad de escribir bloques de código repetitivos para operaciones comunes y, en su lugar, usar una operación reutilizable.

## Ejemplo básico de `BinaryOperator<T>`:
Veamos un ejemplo básico de cómo sumar dos números utilizando `BinaryOperator<Integer>`:

```java
import java.util.function.BinaryOperator;

public class EjemploBinaryOperator {
    public static void main(String[] args) {
        // Definir un BinaryOperator para sumar dos enteros
        BinaryOperator<Integer> sumar = (a, b) -> a + b;

        // Probar el BinaryOperator
        System.out.println(sumar.apply(5, 10));  // 15
    }
}
```
**Salida**
```plaintext
15
```
En este ejemplo, hemos definido un `BinaryOperator<Integer>` que suma dos números enteros. El método `apply(T t, T u)` se utiliza para realizar la operación.

## Métodos útiles en BinaryOperator:
Además de heredar el método `apply(T t, T u)` de `BiFunction<T, T, T>`, **BinaryOperator** tiene algunos métodos útiles definidos en la clase BinaryOperator:

**`minBy(Comparator<T> comparator)`**: Devuelve un **BinaryOperator** que compara dos valores usando un comparador dado y devuelve el menor de los dos.

**`maxBy(Comparator<T> comparator)`**: Devuelve un **BinaryOperator** que compara dos valores usando un comparador dado y devuelve el mayor de los dos.

**Ejemplo**
```java
import java.util.function.BinaryOperator;
import java.util.Comparator;

public class EjemploBinaryOperatorMinMax {
    public static void main(String[] args) {
        // Definir un Comparator para comparar dos enteros
        Comparator<Integer> comparador = Integer::compareTo;

        // Usar maxBy para encontrar el mayor de dos números
        BinaryOperator<Integer> mayor = BinaryOperator.maxBy(comparador);
        System.out.println(mayor.apply(10, 20));  // 20

        // Usar minBy para encontrar el menor de dos números
        BinaryOperator<Integer> menor = BinaryOperator.minBy(comparador);
        System.out.println(menor.apply(10, 20));  // 10
    }
}
```
**Salida**
```plaintext
20
10
```
En este ejemplo, utilizamos maxBy y minBy con un Comparator para encontrar el mayor y menor de dos números, respectivamente.

## Uso en situaciones más complejas:
`BinaryOperator<T>` es especialmente útil en operaciones que involucran la combinación de dos valores en algoritmos de reducción o acumulación. Por ejemplo, en la API de Streams de Java, BinaryOperator puede ser utilizado con el método `reduce()` para combinar los elementos de una lista.

**Ejemplo**
```java
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class EjemploBinaryOperatorReduce {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // Definir un BinaryOperator para sumar
        BinaryOperator<Integer> sumar = (a, b) -> a + b;

        // Usar reduce() con BinaryOperator
        int sumaTotal = numeros.stream().reduce(0, sumar);
        System.out.println(sumaTotal);  // 15
    }
}
```
**Salida**
```plaintext
15
```
En este ejemplo, usamos `BinaryOperator<Integer>` dentro del método `reduce()` para sumar todos los números en una lista.