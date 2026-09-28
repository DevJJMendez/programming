# `map(Function<T, R> mapper)`
El método map es una operación intermedia en la API de Streams de Java que permite transformar los elementos de un Stream en otro tipo de elementos. Es extremadamente útil para convertir datos, aplicar funciones a los elementos y crear un nuevo Stream basado en las transformaciones aplicadas.

## ¿Qué es?
* `map` es un método que acepta una interfaz funcional `Function<T, R>`, donde:
  
  * `T` es el tipo de los elementos en el Stream original.

  * `R` es el tipo de los elementos que se devolverán en el nuevo Stream.

* El método aplica la función proporcionada a cada elemento del Stream y devuelve un nuevo Stream que contiene los resultados de esas transformaciones.

* `map` es una operación intermedia, lo que significa que se puede encadenar con otras operaciones de Stream y no finaliza el procesamiento del Stream.

## ¿Para Qué Sirve?
1. **Transformación de datos**: Convierte los elementos de un Stream de un tipo a otro. Por ejemplo, transformar una lista de Strings en una lista de sus longitudes, o transformar objetos complejos en uno de sus atributos.

2. **Encadenamiento de operaciones**: Permite transformar datos y luego continuar procesándolos a través de otras operaciones intermedias o terminales.

3. **Manipulación declarativa**: Ofrece una forma concisa y declarativa de aplicar transformaciones a los datos sin la necesidad de bucles explícitos.

## ¿Qué Resuelve?
1. **Reduce la verbosidad en la transformación de datos**: Evita la necesidad de usar bucles explícitos y estructuras repetitivas para transformar datos.

2. **Proporciona un enfoque funcional**: Facilita la aplicación de funciones a los elementos de un Stream, alineándose con el paradigma funcional, lo que resulta en un código más claro, conciso y fácil de mantener.

3. **Encadenamiento fluido**: Permite que múltiples transformaciones se realicen en una sola expresión, evitando la necesidad de crear estructuras temporales.

## ¿Cómo Funciona?
* **Sintaxis**:
```java
Stream<R> newStream = originalStream.map(element -> {
    // Transformación que deseas aplicar
});
```
**Flujo de trabajo:**

* Se crea un Stream original de elementos de tipo `T`.

* Se llama al método `map`, proporcionando una función que transforma cada elemento.

* `map` aplica la función a cada elemento, devolviendo un nuevo Stream de tipo R con los resultados de las transformaciones.

## Ejemplos de Uso:
1. Transformar una lista de cadenas a mayúsculas:
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("juan", "ana", "luis");

        List<String> nombresMayuscula = nombres.stream()
                                               .map(nombre -> nombre.toUpperCase())
                                               .collect(Collectors.toList());

        System.out.println(nombresMayuscula);
    }
}
```
**Salida**
```plaintext
[JUAN, ANA, LUIS]
```
**Explicación**:

* Aquí, `map` toma cada elemento del **Stream** y aplica la función `toUpperCase` para convertirlos a mayúsculas, generando un nuevo Stream de resultados transformados.

2. Transformar una lista de números a sus cuadrados:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapSquareExample {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> cuadrados = numeros.stream()
                                         .map(numero -> numero * numero)
                                         .collect(Collectors.toList());

        System.out.println(cuadrados);
    }
}
```
**Salida**
```plaintext
[1, 4, 9, 16, 25]
```
**Explicación**:

* `map` toma cada número del **Stream** original y lo eleva al cuadrado, devolviendo un nuevo **Stream** con los valores transformados.

3. Extraer atributos de objetos:
```java
import java.util.Arrays;
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
}

public class MapObjectExample {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
            new Persona("Juan", 25),
            new Persona("Ana", 30),
            new Persona("Luis", 22)
        );

        List<String> nombres = personas.stream()
                                       .map(Persona::getNombre)
                                       .collect(Collectors.toList());

        System.out.println(nombres);
    }
}
```
**Salida**
```plaintext
[Juan, Ana, Luis]
```
**Explicación**:

* `map` utiliza una referencia a método (`Persona::getNombre`) para extraer el nombre de cada objeto `Persona` y devuelve un **Stream** de nombres.

## Consideraciones Importantes:
1. **Mapeo uno a uno**: Cada entrada del Stream original se transforma en una única salida en el Stream resultante. Si deseas generar múltiples resultados a partir de un solo elemento, considera usar `flatMap`.

2. **Evitación de efectos secundarios**: `map` está diseñado para transformar datos sin modificar el estado externo. Si necesitas realizar efectos secundarios, como imprimir valores, usa `peek` o `forEach` en su lugar.

3. **Encadenamiento**: Puedes encadenar múltiples llamadas a map para aplicar múltiples transformaciones en secuencia.