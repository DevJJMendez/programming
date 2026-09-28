# `BiConsumer<>`
`BiConsumer<T, U>` es una interfaz funcional en Java que acepta dos parámetros de tipos diferentes y no devuelve ningún resultado. Es útil cuando necesitas realizar una operación que involucra dos objetos pero no necesitas devolver un valor. Al igual que el `Consumer<T>`, es parte del paquete `java.util.function`, y está diseñado para ser utilizado en programación funcional.

**Definición de la interfaz**
```java
@FunctionalInterface
public interface BiConsumer<T, U> {
    void accept(T t, U u);

    default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
        // Código omitido
    }
}
```

## ¿Qué es BiConsumer<T, U>?
* Es una interfaz funcional que toma dos entradas (de tipos `T` y `U`) y realiza alguna acción en ellos sin devolver un valor (es decir, es void).

* La única función abstracta que debe implementar es `accept(T t, U u)`, que ejecuta una operación sobre los dos parámetros recibidos.

## ¿Para qué sirve?
`BiConsumer<T, U>` se utiliza cuando necesitas consumir (o procesar) dos objetos, pero no necesitas devolver un resultado. Esto es útil cuando deseas realizar acciones como impresión, modificación de datos, registro en logs, o cualquier otra operación donde el resultado sea secundario o innecesario.

## ¿Qué resuelve?
Resuelve la necesidad de realizar operaciones en dos entradas al mismo tiempo, de manera que puedas operar sobre ambos sin la obligación de devolver algo. También ofrece una forma clara y concisa de manejar operaciones que involucren dos parámetros, permitiendo un enfoque funcional en el código.

## ¿Cómo lo resuelve?
Lo resuelve proporcionando una interfaz funcional con el método `accept()`, que permite ejecutar una acción sobre dos parámetros sin necesidad de retornar un resultado. Además, ofrece el método `andThen()`, que permite encadenar múltiples acciones (como lo hace `Consumer<T>`), pero con dos parámetros en lugar de uno.

## Ejemplo Básico
Supongamos que queremos procesar dos parámetros: un nombre (cadena) y una edad (entero) y los queremos imprimir en un formato particular:

```java
import java.util.function.BiConsumer;

public class EjemploBiConsumer {
    public static void main(String[] args) {
        BiConsumer<String, Integer> imprimirNombreYEdad = (nombre, edad) -> 
            System.out.println("Nombre: " + nombre + ", Edad: " + edad);

        imprimirNombreYEdad.accept("Juan", 25); // Llamada con un nombre y una edad
    }
}
```
Salida
```plaintext
Nombre: Juan, Edad: 25
```
**Explicación**:
* Se ha creado un `BiConsumer<String, Integer>` que acepta un `String` (nombre) y un `Integer` (edad).

* El método `accept()` se utiliza para ejecutar la operación de imprimir el nombre y la edad.

* El `BiConsumer` permite procesar ambos parámetros sin necesidad de retornar un valor.

## Método andThen()
Al igual que en `Consumer<T>`, el `BiConsumer<T, U>` también ofrece el método `andThen()` para encadenar múltiples `BiConsumer`. Esto te permite realizar una secuencia de operaciones sobre los dos parámetros de manera fluida.

### Ejemplo
Supongamos que además de imprimir el nombre y la edad, también queremos registrar el nombre en mayúsculas:

```java
import java.util.function.BiConsumer;

public class EjemploBiConsumer {
    public static void main(String[] args) {
        // Primer BiConsumer: imprimir nombre y edad
        BiConsumer<String, Integer> imprimirNombreYEdad = (nombre, edad) -> 
            System.out.println("Nombre: " + nombre + ", Edad: " + edad);

        // Segundo BiConsumer: imprimir el nombre en mayúsculas
        BiConsumer<String, Integer> imprimirNombreMayusculas = (nombre, edad) -> 
            System.out.println("Nombre en mayúsculas: " + nombre.toUpperCase());

        // Encadenar ambas operaciones
        BiConsumer<String, Integer> operacionesCombinadas = imprimirNombreYEdad.andThen(imprimirNombreMayusculas);

        // Ejecutar las operaciones combinadas
        operacionesCombinadas.accept("Juan", 25);
    }
}
```
Salida
```plaintext
Nombre: Juan, Edad: 25
Nombre en mayúsculas: JUAN
```

## Beneficios de BiConsumer<T, U>:
* **Flexibilidad**: Puedes operar sobre dos parámetros diferentes, lo que permite un mayor control sobre las operaciones que puedes realizar.

* **Encadenamiento de acciones**: Usando `andThen()`, puedes ejecutar múltiples operaciones secuencialmente sobre los mismos parámetros, lo que promueve la reutilización de código.

* **Simplicidad**: Proporciona una forma limpia y concisa de ejecutar operaciones que no necesitan devolver resultados, eliminando la necesidad de funciones auxiliares o código repetitivo.

## Ejemplo práctico con una lista
Supongamos que tienes una lista de empleados con su nombre y salario, y deseas aplicar dos operaciones:

1. Imprimir el nombre y el salario.

2. Aumentar el salario en un 10% y luego imprimir el nuevo salario.

```java
import java.util.function.BiConsumer;
import java.util.List;
import java.util.Arrays;

public class EjemploBiConsumer {
    public static void main(String[] args) {
        List<String> empleados = Arrays.asList("Juan", "Maria", "Carlos");
        List<Integer> salarios = Arrays.asList(2000, 2500, 3000);

        // Primer BiConsumer: imprimir nombre y salario
        BiConsumer<String, Integer> imprimirNombreYSalario = (nombre, salario) -> 
            System.out.println("Empleado: " + nombre + ", Salario: " + salario);

        // Segundo BiConsumer: incrementar el salario en un 10% y mostrarlo
        BiConsumer<String, Integer> incrementarYMostrarSalario = (nombre, salario) -> {
            int nuevoSalario = (int) (salario * 1.1);
            System.out.println("Nuevo salario de " + nombre + ": " + nuevoSalario);
        };

        // Encadenar ambas operaciones
        BiConsumer<String, Integer> operacionesCombinadas = imprimirNombreYSalario.andThen(incrementarYMostrarSalario);

        // Ejecutar las operaciones para cada empleado y su salario
        for (int i = 0; i < empleados.size(); i++) {
            operacionesCombinadas.accept(empleados.get(i), salarios.get(i));
        }
    }
}
```
Salida
```plaintext
Empleado: Juan, Salario: 2000
Nuevo salario de Juan: 2200
Empleado: Maria, Salario: 2500
Nuevo salario de Maria: 2750
Empleado: Carlos, Salario: 3000
Nuevo salario de Carlos: 3300
```

## Consideraciones:
* `NullPointerException`: Al igual que con `Consumer<T>`, el método `andThen()` lanzará una excepción si se pasa un `BiConsumer` nulo.

* **Parámetros mutables**: Al trabajar con objetos mutables (como listas o arrays), asegúrate de que las operaciones no causen efectos secundarios no deseados.