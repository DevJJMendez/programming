# `forEach<Consumer<T> action>`
El método `forEach` es una operación terminal de la API de Streams que se utiliza para realizar una acción sobre cada elemento de un Stream. Permite aplicar una `Consumer` a cada elemento sin devolver un resultado, lo que significa que está diseñado principalmente para efectos secundarios, como imprimir valores, registrar datos o realizar operaciones que no afectan la estructura o flujo del Stream.

## ¿Qué es?
* `forEach` es un método que recibe como argumento una interfaz funcional `Consumer<T>`, que representa una operación que acepta un solo argumento y no devuelve ningún valor.

* Es un método terminal, lo que significa que una vez que se llama, no se puede continuar trabajando con el Stream.

* `Consumer<T>` se implementa generalmente a través de una expresión lambda o una referencia a un método.

## ¿Para qué sirve?
1. **Iterar sobre los elementos de una colección**: Facilita la iteración sobre los elementos de un Stream de manera simple y concisa.

2. **Efectos secundarios**: Ejecutar operaciones que tienen efectos secundarios, como imprimir en la consola, registrar en un archivo o actualizar una variable externa.

3. **Simplificación del código**: Reduce la verbosidad en comparación con los bucles tradicionales (`for` o `for-each`), logrando un código más limpio y declarativo.

## ¿Qué Resuelve?
1. **Reduce la verbosidad**: Evita la necesidad de usar bucles explícitos, haciendo que el código sea más claro y conciso.

2. **Efectos secundarios más simples**: Permite aplicar acciones de manera directa sobre cada elemento del Stream.

3. **Paralelismo**: Puede trabajar con Streams paralelos, aplicando acciones a elementos de forma concurrente.

## ¿Cómo Funciona?
* **Sintaxis**:
```java
Stream<T> stream = ...;
stream.forEach(element -> {
    // Acción que deseas realizar con cada elemento
});
```
* **Flujo de trabajo**:

  * Se genera un Stream de elementos.

  * Se llama a `forEach` para aplicar la acción especificada a cada elemento del Stream.

  * `forEach` no devuelve nada y marca el final del uso del Stream.

## Ejemplos de uso
1. Imprimir elementos de una lista:

```java
import java.util.Arrays;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Juan", "Ana", "Luis");

        nombres.stream()
               .forEach(nombre -> System.out.println(nombre));
    }
}
```
**Salida**
```java
Juan
Ana
Luis
```
**Explicación**:

* El método `forEach` toma un `Consumer` que imprime cada nombre en la consola. Este enfoque es más conciso que un bucle tradicional.

## Utilizar una referencia a un método:
```java
import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Juan", "Ana", "Luis");

        // Usando referencia a método
        nombres.stream()
               .forEach(System.out::println);
    }
}
```
**Salida**
```java
import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Juan", "Ana", "Luis");

        // Usando referencia a método
        nombres.stream()
               .forEach(System.out::println);
    }
}
```
Salida:
```plaintext
Juan
Ana
Luis
```
**Explicación**:

* `System.out::println` es una referencia a un método que hace que el código sea aún más limpio y fácil de leer.

## Consideraciones Importantes:
1. **Efectos secundarios**: Como `forEach` es comúnmente usado para efectos secundarios, es importante tener cuidado al modificar variables externas dentro de la operación. Puede causar problemas en un entorno paralelo si no se tiene en cuenta la sincronización.

2. **Orden de ejecución**: `forEach` no garantiza el orden de procesamiento cuando se usa con un parallelStream. Si necesitas preservar el orden, utiliza forEachOrdered.

3. **Operación Terminal**: Después de llamar a `forEach`, el Stream ya no puede usarse, ya que se considera consumido.