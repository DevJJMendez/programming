# `flatMap(Function<T, Stream<R>> mapper)`
El método `flatMap` es una operación intermedia en la API de Streams de Java que permite transformar cada elemento de un **Stream** en otro **Stream**, y luego "aplanar" esos **Streams** en un único **Stream** continuo de elementos. Es muy útil cuando se trabaja con estructuras de datos anidadas o para manejar situaciones en las que cada elemento de entrada se convierte en múltiples elementos de salida.

## ¿Qué es?
* **flatMap** es un método que acepta una interfaz funcional `Function<T, Stream<R>>`, donde:
  * `T` es el tipo de los elementos en el Stream original.

  * `R` es el tipo de los elementos en el Stream resultante.

* La función proporcionada toma un elemento de tipo `T` y devuelve un `Stream<R>`. Luego, **flatMap** aplanará todos los **Streams** resultantes en un solo **Stream** continuo de tipo `R`.

* Es una operación intermedia, por lo que puede encadenarse con otras operaciones en el Stream.

## ¿Para Qué Sirve?
1. **Aplanar estructuras anidadas**: Convierte listas de listas en una lista única de elementos, simplificando la manipulación de datos anidados.

2. **Transformación múltiple**: Permite que un único elemento de entrada se transforme en múltiples elementos de salida, cosa que no es posible con el método map.

3. **Encadenamiento y reducción de Streams complejos**: Facilita el trabajo con estructuras de datos complejas, como listas de listas o matrices, permitiendo aplicar transformaciones y aplanarlas en un solo flujo de datos.

## ¿Qué Resuelve?
1. **Evita la anidación de Streams**: Con map, terminarías obteniendo un Stream de Streams cuando trabajas con estructuras anidadas. flatMap resuelve esto al aplanar estos Streams en un solo Stream.

2. **Simplificación de operaciones**: Permite transformar y expandir datos en una operación clara y concisa, evitando la necesidad de usar bucles adicionales para combinar o aplanar estructuras.

3. **Manipulación de colecciones anidadas**: Facilita la transformación de colecciones complejas y la extracción de datos internos de forma más directa.

## ¿Cómo Funciona?
* **Sintaxis**:
```java
Stream<R> newStream = originalStream.flatMap(element -> {
    // Transforma 'element' en un Stream<R>
});
```
**Flujo de trabajo:**

* El Stream original contiene elementos de tipo `T`.

* Se llama a `flatMap` y se proporciona una función que toma cada elemento `T` y devuelve un `Stream<R>`.

* `flatMap` aplanará todos los `Stream<R>` resultantes en un único `Stream<R>`

## Ejemplos de Uso:
1. Convertir listas de listas en una lista única de elementos:
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> listaDeListas = Arrays.asList(
            Arrays.asList("manzana", "naranja"),
            Arrays.asList("pera", "plátano"),
            Arrays.asList("cereza", "fresa")
        );

        List<String> listaAplanada = listaDeListas.stream()
                                                  .flatMap(lista -> lista.stream())
                                                  .collect(Collectors.toList());

        System.out.println(listaAplanada);
    }
}
```
Salida:
```plaintext
[manzana, naranja, pera, plátano, cereza, fresa]
```
**Explicación**:

* `flatMap` toma cada lista interna y devuelve un Stream de sus elementos. Luego, estos Streams se aplanan en un solo Stream continuo de Strings.

2. Transformar cadenas en listas de palabras:
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapStringExample {
    public static void main(String[] args) {
        List<String> frases = Arrays.asList(
            "Aprender Java es divertido",
            "Streams son poderosos",
            "flatMap aplanará los Streams"
        );

        List<String> palabras = frases.stream()
                                      .flatMap(frase -> Arrays.stream(frase.split(" ")))
                                      .collect(Collectors.toList());

        System.out.println(palabras);
    }
}
```
**Salida**
```plaintext
[Aprender, Java, es, divertido, Streams, son, poderosos, flatMap, aplanará, los, Streams]
```
**Explicación**:

* Aquí, `flatMap` toma cada frase, la divide en palabras usando `split` y crea un Stream de palabras. Los Streams resultantes se combinan en un único Stream de palabras.

## Consideraciones Importantes:
1. **Evitar la anidación**: flatMap simplifica la obtención de elementos en estructuras de datos anidadas, como listas de listas, al evitar la creación de Streams anidados.

2. **No modifica el contenido**: flatMap no cambia los elementos, sino que solo aplana los resultados.

3. **Transformaciones complejas**: Puede aplicar transformaciones complejas que devuelvan múltiples resultados y manejarlos eficientemente al aplanarlos.