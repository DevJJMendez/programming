# `UnaryOperator<>`
`UnaryOperator<T>`es una interfaz funcional en Java que representa una operación sobre un solo operando del mismo tipo, y devuelve un resultado del mismo tipo. Es una especialización de la interfaz `Function<T, T>`, pero está diseñada específicamente para situaciones en las que tanto el argumento de entrada como el resultado son del mismo tipo.

**Definición de la interfaz**
```java
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
    // Métodos adicionales pueden estar definidos aquí
}
```

## ¿Qué es `UnaryOperator<T>`?
`UnaryOperator<T>` es una interfaz funcional que toma un único argumento de tipo `T` y devuelve un resultado también de tipo `T`. Esto significa que el tipo del argumento y el tipo del resultado son exactamente el mismo, lo que lo convierte en una versión especializada de `Function<T, R>`, donde `T` y `R` son iguales.

## ¿Para qué sirve?
`UnaryOperator<T>` sirve para definir operaciones que toman un solo operando y producen un resultado del mismo tipo. Es útil en situaciones en las que deseas aplicar una transformación a un valor sin cambiar su tipo, por ejemplo, para modificar, transformar o validar el estado de un objeto o valor, manteniendo su tipo de dato.

## ¿Qué resuelve?
`UnaryOperator<T>` resuelve la necesidad de realizar operaciones unarias (operaciones con un solo argumento) en las que el argumento y el resultado son del mismo tipo. Ayuda a evitar la necesidad de escribir clases o métodos repetitivos para este tipo de operaciones, y en su lugar permite usar funciones reutilizables y concisas.

## Ejemplo básico de UnaryOperator<T>:
Veamos un ejemplo básico donde multiplicamos un número entero por 2 utilizando un `UnaryOperator<Integer>`:

```java
import java.util.function.UnaryOperator;

public class EjemploUnaryOperator {
    public static void main(String[] args) {
        // Definir un UnaryOperator para duplicar el valor de un entero
        UnaryOperator<Integer> duplicar = x -> x * 2;

        // Probar el UnaryOperator
        System.out.println(duplicar.apply(5));  // 10
    }
}
```
**Salida**
```plaintext
10
```
En este ejemplo, hemos definido un `UnaryOperator<Integer>` que toma un número entero y lo multiplica por 2. El método `apply(T t)` se utiliza para realizar la operación.

## Métodos útiles en UnaryOperator:
Además de heredar el método `apply(T t)` de `Function<T, T>`, **UnaryOperator** también tiene algunos métodos auxiliares útiles que hereda de Function:

* `andThen(Function<T, T> after)`: Este método permite encadenar otro **UnaryOperator** o Function que se ejecutará después de la operación original.

* `compose(Function<T, T> before)`: Este método permite encadenar otro **UnaryOperator** o Function que se ejecutará antes de la operación original.

Estos métodos son útiles para componer operaciones y encadenar varias transformaciones en secuencia.

**Ejemplo**
```java
import java.util.function.UnaryOperator;

public class EjemploUnaryOperatorAndThen {
    public static void main(String[] args) {
        // Definir dos UnaryOperators
        UnaryOperator<Integer> duplicar = x -> x * 2;
        UnaryOperator<Integer> sumarTres = x -> x + 3;

        // Componer operaciones usando andThen (primero duplicar, luego sumar 3)
        UnaryOperator<Integer> operacionCombinada = duplicar.andThen(sumarTres);

        // Probar la operación compuesta
        System.out.println(operacionCombinada.apply(5));  // 13
    }
}
```
**Salida**
```plaintext
13
```
En este ejemplo, hemos combinado dos **UnaryOperators**: uno para duplicar un número y otro para sumar 3. Usamos `andThen()` para encadenar las dos operaciones, de modo que primero se duplica el número y luego se le suma 3.

## Uso de UnaryOperator en Streams:
En la API de Streams, `UnaryOperator<T>` puede ser útil para aplicar transformaciones a los elementos de una colección de datos. A continuación, un ejemplo usando un UnaryOperator en un Stream:

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class EjemploUnaryOperatorStream {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // Definir un UnaryOperator para incrementar cada número en 10
        UnaryOperator<Integer> incrementarDiez = x -> x + 10;

        // Aplicar el UnaryOperator en un Stream
        List<Integer> resultados = numeros.stream()
                                          .map(incrementarDiez)
                                          .collect(Collectors.toList());

        // Imprimir los resultados
        System.out.println(resultados);  // [11, 12, 13, 14, 15]
    }
}
```
**Salida**
```plaintext
[11, 12, 13, 14, 15]
```
En este caso, el `UnaryOperator<Integer> `se utiliza en combinación con el método `map()` de un Stream para incrementar cada número en 10.