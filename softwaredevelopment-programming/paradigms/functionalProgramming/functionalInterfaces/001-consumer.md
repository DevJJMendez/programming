# `consumer<>`
La interfaz funcional **`Consumer<T>`** es parte del paquete `java.util.function` y representa una operación que acepta un solo argumento de tipo `T`, pero no devuelve ningún valor. Básicamente, es un "consumidor" de datos: recibe un argumento, lo procesa, pero no produce nada.

**Firma de la interfaz `consumer<T>`**
```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```
El único método abstracto es `accept(T t)`, que toma un argumento de **tipo T** y no devuelve nada (tipo `void`).

## ¿Para qué sirve?
El **`Consumer<T>`** se utiliza principalmente para realizar operaciones laterales o efectos secundarios, como imprimir datos, registrar información, modificar objetos, etc. No está diseñado para devolver un resultado, sino para procesar datos de alguna manera.

Es muy útil cuando necesitas aplicar una operación sobre un conjunto de datos sin modificar ni devolver nada. En estructuras como **Stream** o en el procesamiento de listas, es común usar **`Consumer<T>`** para aplicar operaciones en elementos individuales.

## ¿Qué resuelve?
`Consumer<T>` resuelve la necesidad de ejecutar operaciones que afectan o consumen datos sin la necesidad de devolver un resultado. En lugar de tener que implementar clases anónimas o métodos auxiliares, `Consumer<T>` te permite usar expresiones lambda para definir de manera concisa lo que quieres hacer con cada elemento.

## ¿Cómo lo resuelve?
`Consumer<T>` lo resuelve mediante la implementación del método `accept(T t)`, lo que permite especificar una acción sobre un elemento sin esperar un valor de retorno. Al trabajar con lambdas, puedes implementar operaciones de una forma muy compacta y eficiente.

## Ejemplo de uso
magina que tienes una lista de enteros y deseas imprimir cada número. Puedes usar un `Consumer<Integer>` con una expresión lambda para hacer esto:

```java
import java.util.List;
import java.util.function.Consumer;

public class EjemploConsumer {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);

        // Usamos una expresión lambda para definir un Consumer que imprime cada número
        Consumer<Integer> imprimirNumero = (Integer numero) -> System.out.println(numero);

        // Aplicamos el Consumer a cada elemento de la lista
        numeros.forEach(imprimirNumero);
    }
}
```
**Explicación**:

* Se crea una lista de números.

* El `Consumer<Integer>` se define mediante una lambda `numero -> System.out.println(numero)`, que imprime cada número en la lista.

* La lista tiene el método `forEach()` que toma un `Consumer<T>` como argumento y lo aplica a cada elemento de la lista.

El resultado será la impresión de cada número en la lista.

## Ejemplo con referencias de métodos:
También puedes utilizar referencias de métodos en lugar de lambdas para simplificar el código. El ejemplo anterior puede reescribirse como:

```java
import java.util.List;

public class EjemploConsumer {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);

        // Usamos una referencia de método para simplificar el Consumer
        numeros.forEach(System.out::println);
    }
}
```
Aquí, `System.out::println` es una referencia de método que actúa como un `Consumer<Integer>`, consumiendo cada número de la lista y pasándolo al método `println()`.

## Ejemplo con objetos personalizados:
Veamos un ejemplo en el que aplicamos un Consumer a una lista de objetos personalizados:

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

public class EjemploConsumerObjetos {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan"));
        personas.add(new Persona("Maria"));
        personas.add(new Persona("Pedro"));

        // Consumer para imprimir el nombre de cada persona
        Consumer<Persona> imprimirNombre = persona -> System.out.println(persona.getNombre());

        // Aplicamos el Consumer a cada persona en la lista
        personas.forEach(imprimirNombre);
    }
}
```
En este ejemplo, se define un `Consumer<Persona>` que imprime el nombre de cada objeto Persona en la lista.

## Métodos adicionales en Consumer<T>
`Consumer<T>` también tiene un método por defecto llamado `andThen()` que permite encadenar múltiples operaciones Consumer para aplicarlas secuencialmente.

**Ejemplo**
```java
import java.util.function.Consumer;

public class EjemploAndThen {
    public static void main(String[] args) {
        Consumer<String> imprimir = s -> System.out.println("Imprimiendo: " + s);
        Consumer<String> guardarEnBD = s -> System.out.println("Guardando en la BD: " + s);

        // Encadenamos los Consumers
        Consumer<String> procesar = imprimir.andThen(guardarEnBD);

        // Ejecutamos el Consumer encadenado
        procesar.accept("Registro 1");
    }
}
```
**Explicación**:

* Se definen dos `Consumer<String>`: uno para imprimir un valor y otro para "guardar en la base de datos" (simulado).

* El método `andThen()` se utiliza para crear un `Consumer<String>` que aplica ambas operaciones en secuencia.

* Al ejecutar `procesar.accept("Registro 1")`, primero se imprime el valor y luego se simula el guardado en la base de datos.

## ¿Cuándo usar `Consumer<T>`?
Usa `Consumer<T>` cuando necesites aplicar una operación sobre un valor o colección de valores, pero no necesitas un valor de retorno. Algunos ejemplos típicos de uso incluyen:

* Imprimir o registrar información.

* Modificar el estado de un objeto.

* Realizar una acción sobre cada elemento de una colección, como en los métodos `forEach()` de listas o flujos (**Streams**).
