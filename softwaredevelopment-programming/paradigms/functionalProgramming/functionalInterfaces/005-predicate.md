# `predicate<>`
`Predicate<T> `es una interfaz funcional que representa una función que recibe un argumento de tipo `T` y devuelve un valor booleano (`true` o `false`). Se utiliza para evaluar si una condición es verdadera o falsa sobre un objeto dado. La interfaz Predicate está disponible desde Java 8 y es una parte esencial de las operaciones funcionales y de los Streams.

**Definición de la interfaz:**
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```

## ¿Qué es Predicate<T>?
Un `Predicate<T>` es una función que toma un objeto de tipo `T` y evalúa si cumple o no con una condición determinada. El resultado de esta evaluación es un valor booleano (`true` o `false`). El método principal de esta interfaz es el método `test(T t)`.

## ¿Para qué sirve?
`Predicate<T>` es útil para:

* Filtrar colecciones de datos (por ejemplo, filtrar una lista de objetos).

* Validar condiciones sobre datos de entrada.

* Definir condiciones en operaciones lógicas.

* Aplicar reglas de negocio o validaciones dentro de un código más declarativo.

**Se utiliza comúnmente en la API de Streams para operaciones de filtrado `filter()`, pero también puede ser usado en otras situaciones donde necesites evaluar una condición lógica.**

## ¿Qué resuelve?
Resuelve la necesidad de hacer validaciones o verificaciones en objetos sin la necesidad de escribir código imperativo y repetitivo. Con `Predicate<T>`, puedes expresar de manera clara y declarativa las condiciones lógicas que deben cumplir los objetos de un conjunto de datos.

**Por ejemplo:**

* Filtrar una lista de empleados que tienen un salario superior a cierto umbral.

* Validar si una cadena tiene un cierto patrón.

* Verificar si un número es par o mayor a un valor determinado.

## ¿Cómo lo resuelve?
Lo resuelve proporcionando una interfaz funcional que encapsula la lógica de validación en una función reutilizable. En lugar de escribir manualmente estructuras de control (como if o for), puedes pasar un Predicate como argumento a varios métodos como `filter()` o `removeIf()` para realizar evaluaciones de una manera limpia y concisa.

## Ejemplo básico
Aquí te muestro un ejemplo simple de cómo usar un **Predicate** para verificar si un número es mayor que 10:

```java
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {
        // Definir un Predicate para verificar si un número es mayor a 10
        Predicate<Integer> esMayorQueDiez = numero -> numero > 10;

        // Probar el Predicate
        System.out.println(esMayorQueDiez.test(15));  // true
        System.out.println(esMayorQueDiez.test(8));   // false
    }
}
```
Salida
```plaintext
true
false
```
En este ejemplo, el `Predicate<Integer>` define una condición que verifica si el número es mayor a 10. Luego, con el método `test()`, se evalúa la condición sobre dos números distintos.

## Uso en Streams:
Los Predicate son comúnmente utilizados en la API de Streams, especialmente con el método `filter()`, que filtra los elementos de una colección basándose en la condición del **Predicate**.

Ejemplo de uso con una lista de cadenas:
```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class EjemploPredicateStreams {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Juan", "Ana", "Pedro", "Marta", "Elena");

        // Definir un Predicate para filtrar los nombres que empiezan con "A"
        Predicate<String> empiezaConA = nombre -> nombre.startsWith("A");

        // Usar el Predicate en un Stream para filtrar
        nombres.stream()
               .filter(empiezaConA)
               .forEach(System.out::println);
    }
}
```
**Salida**:
```plaintext
Ana
```
En este caso, el `Predicate<String>` filtra los nombres que empiezan con la letra "A", utilizando el método `filter()` de la API de Streams.

## Métodos útiles en Predicate:
Además del método `test()`, que es el método principal para evaluar una condición, **Predicate** ofrece otros métodos útiles para componer o combinar predicados lógicos:

1. `and()`:

   * Combina dos Predicate en una conjunción lógica (`AND`).

   * Ambos predicados deben ser `true` para que el resultado final sea `true`

```java
Predicate<Integer> esMayorQueDiez = numero -> numero > 10;
Predicate<Integer> esPar = numero -> numero % 2 == 0;

Predicate<Integer> esMayorQueDiezYPar = esMayorQueDiez.and(esPar);
System.out.println(esMayorQueDiezYPar.test(12)); // true
System.out.println(esMayorQueDiezYPar.test(15)); // false
```

2. `or()`:

   * Combina dos Predicate en una disyunción lógica (OR).

   * Si al menos uno de los predicados es `true`, el resultado final será `true`.

```java
Predicate<Integer> esMayorQueDiez = numero -> numero > 10;
Predicate<Integer> esImpar = numero -> numero % 2 != 0;

Predicate<Integer> esMayorQueDiezOImpar = esMayorQueDiez.or(esImpar);
System.out.println(esMayorQueDiezOImpar.test(9));  // true (es impar)
System.out.println(esMayorQueDiezOImpar.test(12)); // true (es mayor a 10)
```

3. `negate()`:

   * Invierte el resultado de un Predicate. Si el predicado original devuelve `true`, `negate()` devuelve `false` y viceversa.

```java
Predicate<Integer> esMayorQueDiez = numero -> numero > 10;

Predicate<Integer> noEsMayorQueDiez = esMayorQueDiez.negate();
System.out.println(noEsMayorQueDiez.test(5));   // true (no es mayor que 10)
System.out.println(noEsMayorQueDiez.test(15));  // false (es mayor que 10)
```

## Ejemplo práctico: Validación de empleados
Supongamos que queremos validar una lista de empleados para encontrar aquellos cuyo salario es mayor a 3000. Usamos Predicate para definir la condición.

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Empleado {
    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return nombre + " con salario de " + salario;
    }
}

public class EjemploPredicateEmpleado {
    public static void main(String[] args) {
        List<Empleado> empleados = Arrays.asList(
            new Empleado("Juan", 2500),
            new Empleado("Ana", 3200),
            new Empleado("Pedro", 2800),
            new Empleado("Elena", 3600)
        );

        // Predicate para verificar si el salario es mayor a 3000
        Predicate<Empleado> salarioMayorA3000 = empleado -> empleado.getSalario() > 3000;

        // Filtrar los empleados que cumplen con la condición
        empleados.stream()
                 .filter(salarioMayorA3000)
                 .forEach(System.out::println);
    }
}
```
**Salida**
```plaintext
Ana con salario de 3200.0
Elena con salario de 3600.0
```