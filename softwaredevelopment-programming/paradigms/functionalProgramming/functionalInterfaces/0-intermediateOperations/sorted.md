# `sorted()`
Es una operación intermedia en la API de Streams de Java que se utiliza para ordenar los elementos de un Stream. Esta operación devuelve un nuevo **Stream** con los elementos ordenados según el orden natural de los elementos o utilizando un **Comparator** personalizado. Es una herramienta esencial para la manipulación y organización de datos en aplicaciones que requieren ordenamiento.

## ¿Qué es sorted()?
* `sorted()` es un método que se utiliza para ordenar los elementos de un Stream.

* **Hay dos variantes**:
  * `sorted()`: Ordena los elementos utilizando el orden natural de los mismos (es decir, el orden definido por la implementación de Comparable).

  * `sorted(Comparator<T> comparator)`: Ordena los elementos utilizando un Comparator proporcionado por el usuario, lo que permite definir un orden específico.

* Es una operación intermedia, lo que significa que se puede encadenar con otras operaciones y el Stream resultante seguirá siendo procesable.

## ¿Para Qué Sirve?
* **Ordenar colecciones de datos**: Permite organizar datos en un Stream de manera ascendente o personalizada para realizar análisis, reportes o simplificar la búsqueda de información.

* **Preparar datos para el procesamiento**: Asegura que los datos estén en el orden adecuado antes de aplicar operaciones adicionales, como búsquedas binarias o agregaciones.

* **Facilitar el uso de funciones que dependen del orden**: Funciones como `distinct()` o ciertas operaciones de búsqueda pueden beneficiarse de tener datos ordenados.

## ¿Qué Resuelve?
1. **Ordenamiento de datos sin modificar la colección original**: A diferencia de métodos de ordenamiento tradicionales que pueden modificar la colección original, `sorted()` trabaja sobre Streams y no altera la fuente de datos.

2. **Facilidad en la organización de datos**: Simplifica el proceso de ordenar grandes volúmenes de datos de manera eficiente.

3. **Flexibilidad en el ordenamiento**: Permite usar el orden natural o un **Comparator** personalizado, lo que brinda versatilidad al desarrollar aplicaciones que necesiten diferentes criterios de orden.

## ¿Cómo Funciona?
* **Sintaxis básica**:
  ```java
  Stream<T> orderedStream = originalStream.sorted();
  ```
  * Usa el orden natural de los elementos. Los elementos deben implementar la interfaz Comparable.

* **Sintaxis con `Comparator`**:
  ```java
  Stream<T> orderedStream = originalStream.sorted(Comparator.comparing(T::getSomeProperty));
  ```
  Se utiliza un `Comparator` personalizado para definir el criterio de ordenación.

## Ejemplos de Uso:
1. Ordenar números en orden natural:
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(5, 3, 8, 1, 2);
        List<Integer> numerosOrdenados = numeros.stream()
                                                .sorted()
                                                .collect(Collectors.toList());

        System.out.println(numerosOrdenados);
    }
}
```
**Salida**
```plaintext
[1, 2, 3, 5, 8]
```
**Explicación**:

* Aquí, `sorted()` ordena los números en el orden natural ascendente.

2. **Ordenar objetos usando un `Comparator`**:
```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}

public class SortedObjectExample {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
            new Persona("Juan", 25),
            new Persona("Ana", 30),
            new Persona("Pedro", 20)
        );

        List<Persona> personasOrdenadas = personas.stream()
                                                  .sorted(Comparator.comparing(Persona::getEdad))
                                                  .collect(Collectors.toList());

        System.out.println(personasOrdenadas);
    }
}
```
**Salida**
```lua
[Pedro (20 años), Juan (25 años), Ana (30 años)]
```
**Explicación**:

* Se usa un `Comparator` para ordenar las personas por edad de manera ascendente.

## Consideraciones Importantes:
1. **Orden natural vs. `Comparator`**: El método sin parámetros depende del orden natural (definido por Comparable), mientras que la versión con Comparator permite especificar cualquier criterio de orden.

* **Ordenamiento estable**: `sorted()` es estable, lo que significa que mantiene el orden relativo de elementos iguales.

* **Procesamiento perezoso**: Aunque `sorted()` es una operación intermedia, el ordenamiento solo se realiza cuando una operación terminal (como `collect()`) se aplica al Stream.

# `distinct()`
Es una operación intermedia en la API de Streams de Java que se utiliza para eliminar elementos duplicados de un Stream. Este método devuelve un nuevo Stream que contiene solo los elementos únicos, es decir, aquellos que no se repiten en la secuencia. Es particularmente útil para filtrar datos redundantes de forma sencilla y eficiente.

## ¿Qué es?
* `distinct()` es un método de la clase Stream que permite eliminar duplicados.

* Se basa en el uso de `equals()` para determinar si dos elementos son iguales.

* Es una operación intermedia, por lo que puede encadenarse con otras operaciones y el Stream resultante puede seguir siendo procesado.

## ¿Para Qué Sirve?
1. **Eliminar elementos duplicados**: Permite reducir una colección de datos a solo los valores únicos, lo cual es útil para análisis y procesamiento de datos.

2. **Simplificar conjuntos de datos**: Facilita la limpieza de datos antes de realizar operaciones adicionales, como conteos, agrupaciones o transformaciones.

3. **Optimizar resultados**: Cuando se necesita trabajar con un conjunto específico de elementos únicos sin tener que escribir código adicional para verificar duplicados.

## ¿Qué Resuelve?
1. **Redundancia de datos**: Si una colección contiene valores repetidos que no son necesarios para el procesamiento final, `distinct()` puede limpiarlos.

2. **Facilita el procesamiento de datos**: Permite evitar la necesidad de usar estructuras de datos adicionales (como `Set`) para asegurarse de que los elementos sean únicos.

3. **Mejora la legibilidad del código**: Simplifica el código, ya que elimina la necesidad de implementar manualmente la lógica para eliminar duplicados.

## ¿Cómo Funciona?
Sintaxis básica:
```java
Stream<T> uniqueStream = originalStream.distinct();
```
* Internamente, `distinct()` utiliza el método `equals()` para determinar la igualdad entre los elementos del Stream. Por lo tanto, es importante asegurarse de que la clase de los elementos tenga correctamente implementado `equals()` (y `hashCode()`).

## Ejemplos de Uso:
1. Eliminar números duplicados:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctExample {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
        List<Integer> numerosUnicos = numeros.stream()
                                             .distinct()
                                             .collect(Collectors.toList());

        System.out.println(numerosUnicos);
    }
}
```
**Salida**
```plaintext
[1, 2, 3, 4, 5]
```
**Explicación**:

* `distinct()` elimina las ocurrencias adicionales de los números, dejando solo los valores únicos.

## Consideraciones Importantes:
1. **Implementación de `equals()` y `hashCode()`**: Para clases personalizadas, es crucial que se implementen correctamente equals() y hashCode() para que distinct() funcione como se espera.

2. **Operación intermedia**: `distinct()` es una operación intermedia y no realizará el filtrado hasta que se aplique una operación terminal (como `collect()`, `forEach()`, etc.).

3. **Orden de los elementos**: `distinct()` mantiene el orden de aparición original de los elementos que son únicos.

# `limit(long maxSize)`
Es una operación intermedia de la API de Streams de Java que se utiliza para restringir el tamaño del Stream a un número máximo de elementos. Es útil cuando solo se necesita procesar una cantidad específica de elementos y se desea ignorar el resto.

## ¿Qué es?
* `limit(maxSize)` toma un **Stream** y devuelve un nuevo **Stream** que contiene como máximo maxSize elementos.

* Es una operación intermedia y perezosa, lo que significa que no se realiza hasta que se aplique una operación terminal (como `collect()` o `forEach()`).

## ¿Para Qué Sirve?
1. **Restringir la cantidad de resultados**: Permite controlar la cantidad de datos que se procesarán sin tener que recorrer toda la fuente de datos.

2. **Optimizar el rendimiento**: Si no es necesario procesar todos los elementos de una colección grande, `limit()` puede ayudar a reducir el costo computacional al detener el procesamiento después de un número específico de elementos.

3. **Pruebas y depuración**: Facilita la prueba y depuración de código al permitir trabajar con una cantidad limitada de datos.

## ¿Qué Resuelve?
1. **Excesivo procesamiento de datos**: En situaciones en las que se trabaja con grandes volúmenes de datos, `limit()` permite reducir el conjunto de datos a procesar, ahorrando recursos y tiempo.

2. **Evitar resultados innecesarios**: Ayuda a evitar la obtención de más datos de los que se necesitan, lo que puede ser útil en contextos como paginación o extracción de resúmenes.

## Cómo Funciona?
* **Sintaxis básica**:
```java
Stream<T> limitedStream = originalStream.limit(maxSize);
```
* `maxSize` define el número máximo de elementos que el Stream resultante contendrá. Si el Stream original tiene menos elementos que maxSize, el Stream se mantiene igual.

## Ejemplos de Uso:
1. Obtener los primeros 3 elementos de una lista de números:
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitExample {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> primerosTres = numeros.stream()
                                            .limit(3)
                                            .collect(Collectors.toList());

        System.out.println(primerosTres);
    }
}
```
Salida:
```plaintext
[1, 2, 3]
```
Explicación:

* `limit(3)` restringe el Stream a los primeros 3 elementos.

# `skip(long n)`
Es una operación intermedia de la API de Streams de Java que permite omitir un número específico de elementos desde el comienzo del Stream. Es útil cuando se necesita saltar ciertos elementos y procesar solo el resto.

## ¿Qué es?
* `skip(n)` crea un nuevo Stream que omite los primeros n elementos del Stream original.

* Es una operación intermedia y perezosa, lo que significa que no se ejecuta inmediatamente, sino hasta que se realiza una operación terminal (como `collect()` o `forEach()`).

## ¿Para Qué Sirve?
1. **Ignorar un número fijo de elementos**: Permite saltar una cantidad determinada de elementos al inicio del Stream y procesar solo los elementos restantes.

2. **Paginación**: Se puede usar para implementar la paginación al combinarlo con `limit()`, permitiendo seleccionar elementos específicos de una lista en "páginas" de tamaño fijo.

3. **Optimización de datos**: Facilita el procesamiento selectivo de datos al ignorar aquellos que no son relevantes para la operación actual.

## ¿Qué Resuelve?
1. **Procesamiento selectivo de datos**: En casos donde solo se necesitan elementos específicos, `skip(n)` ayuda a ignorar aquellos que no son importantes, optimizando el flujo de datos.

2. **Evitar exceso de datos iniciales**: Útil cuando se sabe que los primeros elementos del Stream no deben ser considerados en la operación que se va a realizar.

## ¿Cómo Funciona?
* **Sintaxis básica**:
```java
Stream<T> skippedStream = originalStream.skip(n);
```
* `n` define el número de elementos que se omitirán. Si el Stream original tiene menos elementos que `n`, el Stream resultante será vacío.

## Ejemplos de Uso:
1. Omitir los primeros 3 elementos de una lista de números:
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkipExample {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> sinLosTresPrimeros = numeros.stream()
                                                  .skip(3)
                                                  .collect(Collectors.toList());

        System.out.println(sinLosTresPrimeros);
    }
}
```
**Salida**
```plaintext
[4, 5, 6, 7, 8, 9]
```
**Explicación**:

* `skip(3)` omite los primeros 3 elementos del Stream, comenzando el procesamiento a partir del cuarto elemento.