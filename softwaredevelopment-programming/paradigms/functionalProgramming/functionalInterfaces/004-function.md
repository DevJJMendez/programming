# `function<>`
`Function<T, R>` es una interfaz funcional que representa una función que acepta un argumento de tipo `T` y devuelve un resultado de tipo `R`. Se utiliza principalmente cuando quieres aplicar una transformación o realizar alguna operación sobre un valor de entrada para obtener un resultado.

**Definición de la interfaz**
```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```

## ¿Qué es Function<T, R>?
* `Function<T, R>` es una interfaz funcional que recibe un parámetro de tipo **`T` (el tipo de entrada)** y devuelve un valor de tipo **`R`(el tipo de salida)**.

* Tiene un único método abstracto: `R apply(T t)`, el cual realiza la operación sobre el argumento de entrada y retorna el resultado.

## ¿Para qué sirve?
La interfaz Function se utiliza cuando necesitas **transformar o procesar** un dato y devolver un nuevo resultado basado en esa transformación. Es útil en una amplia variedad de situaciones, como:

* **Transformación de datos**: Aplicar una operación que convierta un tipo de dato a otro.

* **Mapeo de datos**: Convertir valores de un tipo a otro dentro de una colección (por ejemplo, una lista de enteros a una lista de strings).

* **Aplicación de lógica**: Encapsular lógica específica que transforma una entrada en una salida.

## ¿Qué resuelve?
Resuelve la necesidad de aplicar operaciones que transforman datos de un tipo a otro o que generan un nuevo valor basado en una entrada existente. En esencia, simplifica el proceso de aplicar funciones matemáticas, transformar objetos o cualquier tipo de procesamiento de datos que necesite un `input` y devuelva un `output`.

## ¿Cómo lo resuelve?
Lo resuelve proporcionando una interfaz genérica y flexible para realizar transformaciones. La implementación del método `apply(T t)` permite encapsular la lógica de la transformación, de modo que se pueda reutilizar y pasar como argumento a otras funciones que acepten interfaces funcionales.

## Ejemplo básico
A continuación, un ejemplo simple donde se transforma un `String` en su longitud:

```java
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {
        // Función que transforma un String en su longitud
        Function<String, Integer> obtenerLongitud = s -> s.length();

        // Aplicar la función
        String texto = "Hola Mundo";
        int longitud = obtenerLongitud.apply(texto);
        System.out.println("La longitud de '" + texto + "' es: " + longitud);
    }
}
```
Salida
```plaintext
La longitud de 'Hola Mundo' es: 10
```
En este caso, `Function<String, Integer>` es una función que acepta un `String` y devuelve un `Integer` (la longitud de ese `String`).

## Métodos adicionales de la interfaz Function:
Además del método principal `apply()`, la interfaz Function tiene otros métodos útiles que permiten componer funciones:

1. `andThen()`: Te permite encadenar funciones. Aplica la función original y luego pasa el resultado a otra función.

  ```java
  Function<Integer, Integer> cuadrado = x -> x * x;
  Function<Integer, String> convertirEnTexto = x -> "El resultado es: " + x;

  // Aplica primero la función de elevar al cuadrado y luego convierte el resultado en texto
  Function<Integer, String> funcionCompuesta = cuadrado.andThen(convertirEnTexto);

  System.out.println(funcionCompuesta.apply(5)); // Salida: El resultado es: 25
  ```

2. `compose()`: Similar a `andThen()`, pero en lugar de aplicar la función original primero, aplica primero la función pasada como argumento a `compose()`, y luego la función original.

  ```java
  Function<Integer, Integer> duplicar = x -> x * 2;
  Function<Integer, Integer> cuadrado = x -> x * x;

  // Aplica primero la función de duplicar y luego eleva al cuadrado
  Function<Integer, Integer> funcionCompuesta = cuadrado.compose(duplicar);

  System.out.println(funcionCompuesta.apply(5)); // Salida: 100
  ```
  En este caso, primero se duplica el valor `(5 * 2 = 10)` y luego se eleva al cuadrado `(10 * 10 = 100)`.

3. `identity()`: Este es un método estático que devuelve una función que simplemente devuelve su argumento. Útil cuando necesitas una función que no transforme el valor de entrada.

  ```java
  Function<String, String> identidad = Function.identity();

  System.out.println(identidad.apply("Hola")); // Salida: Hola
  ```

## Ejemplo práctico:
Supongamos que tienes una lista de objetos Empleado, y necesitas una función que convierta el nombre del empleado en mayúsculas.

```java
import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Empleado {
    private String nombre;
    private int edad;

    public Empleado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
}

public class EjemploFunction {
    public static void main(String[] args) {
        // Lista de empleados
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Juan", 25));
        empleados.add(new Empleado("Ana", 30));

        // Función que transforma el nombre del empleado en mayúsculas
        Function<Empleado, String> nombreEnMayusculas = empleado -> empleado.getNombre().toUpperCase();

        // Usar la función en una lista de empleados
        List<String> nombresEnMayusculas = empleados.stream()
                .map(nombreEnMayusculas)
                .collect(Collectors.toList());

        // Imprimir los nombres
        nombresEnMayusculas.forEach(System.out::println);
    }
}
```

## Function en APIs de Java:
`Function<T, R>` es ampliamente utilizada en las APIs de Java, especialmente en el contexto de Streams. Por ejemplo, el método `map()` en **Streams** usa Function para transformar cada elemento de la secuencia.

Ejemplo
```java
import java.util.Arrays;
import java.util.List;

public class EjemploMapFunction {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Juan", "Ana", "Pedro");

        // Usar map() con una función que transforma los nombres a mayúsculas
        List<String> nombresEnMayusculas = nombres.stream()
                .map(nombre -> nombre.toUpperCase())
                .toList();

        nombresEnMayusculas.forEach(System.out::println);
    }
}
```
Salida
```plaintext
JUAN
ANA
PEDRO
```