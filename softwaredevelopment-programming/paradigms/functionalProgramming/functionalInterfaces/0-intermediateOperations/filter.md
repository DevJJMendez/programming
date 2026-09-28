# `filter(Predicate<T> predicate)`
Es una operación intermedia de la API de Streams en Java. Es fundamental para realizar filtrados de datos dentro de un flujo (Stream) de elementos. Permite crear un subconjunto del Stream original, seleccionando solo aquellos elementos que cumplan una condición específica definida por un Predicate.

## ¿Qué es?
* `filter()` es un método intermedio de la clase Stream en Java.

* Recibe como argumento un `Predicate<T>`, que es una interfaz funcional que representa una condición booleana.

* El Predicate evalúa cada elemento del Stream y retorna un booleano (`true` o `false`).

* Solo los elementos que satisfacen la condición (`true`) pasan a través del filtro y continúan en el Stream.

## ¿Para qué sirve?
* Filtrar datos de un conjunto de elementos (colección, arreglo, etc.) en función de un criterio específico.

* Reducir el conjunto de datos seleccionando solo aquellos elementos que cumplen ciertas condiciones.

* Facilitar operaciones como búsqueda, selección y depuración al manejar colecciones de datos más grandes.

## ¿Qué problema resuelve?
* **Seleccionar y extraer** solo aquellos elementos que cumplen con una condición específica, sin tener que escribir manualmente bucles o estructuras de control.

* **Evitar bucles `for` o `while` complejos**, haciendo el código más limpio, legible y fácil de mantener.

* Procesar datos de forma eficiente, ya que permite trabajar con grandes colecciones de forma funcional, inmutable y perezosa (**lazy**).

## ¿Cómo lo resuelve?
* **Función lambda o referencia a método**: La condición para filtrar se pasa como una lambda o referencia a método que implementa la interfaz funcional Predicate.

* **Procesamiento perezoso (lazy)**: La operación `filter()` no procesa los datos inmediatamente. Solo cuando una operación terminal se aplica al Stream (como `collect()`, `forEach()`, etc.), se realiza el filtrado.

* **Iteración interna**: `filter()` utiliza iteración interna, lo que significa que no necesitas preocuparte por los bucles explícitos. Java se encarga de manejar la iteración por ti.

## Ejemplo de uso con `Predicate<T>` y Lambdas
Supongamos que tenemos una lista de nombres y queremos filtrar solo los nombres que tienen más de 4 letras:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        List<String> longNames = names.stream()
                                      .filter(name -> name.length() > 4)
                                      .collect(Collectors.toList());

        System.out.println(longNames); // Output: [Alice, Charlie, David]
    }
}
```
**Explicación del código**
* `names.stream()`: Crea un **Stream** a partir de la lista de nombres.

* `.filter(name -> name.length() > 4)`: Utiliza una lambda que implementa `Predicate<String>` para filtrar solo los nombres cuya longitud sea mayor que 4.

* `.collect(Collectors.toList())`: Recoge el resultado del filtrado en una nueva lista.

## Composición de Predicados
Java permite la composición de predicados para realizar múltiples condiciones en una sola operación `filter()` mediante métodos como `.and()`, `.or()` y `.negate()`:

```java
List<String> filteredNames = names.stream()
                                  .filter(name -> name.startsWith("A"))
                                  .filter(name -> name.length() > 3)
                                  .collect(Collectors.toList());
```
**Ejemplo**
```java
Predicate<String> startsWithA = name -> name.startsWith("A");
Predicate<String> hasLengthGreaterThanThree = name -> name.length() > 3;

List<String> filteredNames = names.stream()
                                  .filter(startsWithA.and(hasLengthGreaterThanThree))
                                  .collect(Collectors.toList());
```