# Referencia a Métodos
Las referencias a métodos en Java son una característica introducida en Java 8 como parte del soporte para programación funcional. Una referencia a método proporciona una forma más compacta y legible de referirse a métodos o constructores ya existentes sin tener que usar expresiones lambda de forma explícita. En esencia, son una manera de reutilizar métodos definidos previamente cuando se ajustan al tipo de una interfaz funcional.

## ¿Qué es una referencia a método?
Una referencia a método es una sintaxis que te permite pasar directamente un método ya existente donde se espera una expresión lambda. En lugar de escribir una lambda que simplemente llama a un método, puedes usar una referencia a ese método, lo que hace que el código sea más legible y conciso.

**Sintaxis**
```java
<ClassName>::<methodName>
```
Este formato depende del tipo de método que estés haciendo referencia. Hay cuatro tipos principales de referencias a métodos:

1. Referencia a un método estático

2. Referencia a un método de instancia de un objeto particular

3. Referencia a un método de instancia de un objeto arbitrario de un tipo específico

4. Referencia a un constructor

## ¿Para qué sirven?
Las referencias a métodos sirven para hacer el código más conciso y claro cuando trabajas con interfaces funcionales. En lugar de escribir una lambda innecesariamente larga que simplemente llama a un método, puedes utilizar una referencia a ese método directamente, lo que mejora la legibilidad y reduce la repetición.

## ¿Qué resuelven?
Las referencias a métodos resuelven el problema de la verbosidad en las expresiones lambda cuando solo se necesita llamar a un método ya existente. En lugar de escribir una lambda que llama a un método, puedes utilizar una referencia directa a ese método. Esto mejora la claridad del código y lo hace más fácil de mantener.

## Tipos de referencias a métodos y ejemplos
1. **Referencia a un método estático**: Este tipo de referencia se usa cuando deseas referirte a un método estático de una clase. La sintaxis es:

```java
ClassName::staticMethod
```
**Ejemplo**: Supongamos que tienes un método estático `parseInt` en la clase `Integer`, y deseas usarlo en una lista de `strings` para convertirlos a enteros:

```java
import java.util.List;

public class EjemploReferenciaMetodoEstatico {
    public static void main(String[] args) {
        List<String> numeros = List.of("1", "2", "3", "4");

        // Usamos una referencia a método estático
        numeros.stream()
               .map(Integer::parseInt)  // Reference to static method parseInt
               .forEach(System.out::println);  // Reference to static method println
    }
}
```
Explicación:

* `Integer::parseInt` es una referencia al método estático `parseInt`, que toma un `String` y lo convierte en un `int`.

* `System.out::println` es una referencia al método estático println para imprimir los valores.

2. **Referencia a un método de instancia de un objeto particular**: Este tipo de referencia se utiliza cuando tienes un objeto ya instanciado y deseas referirte a uno de sus métodos. La sintaxis es:
|
```java
instance::instanceMethod
```
**Ejemplo**
```java
public class EjemploReferenciaMetodoInstancia {
    public static void main(String[] args) {
        String mensaje = "Hola Mundo";

        // Referencia a un método de instancia
        Runnable r = mensaje::toUpperCase;

        // Ejecutamos la operación
        r.run();
    }
}
```
**Explicación**:

* `mensaje::toUpperCase` es una referencia al método de instancia `toUpperCase` que convierte un `String` a **mayúsculas**. Aquí, mensaje ya es un objeto instanciado de tipo String.

* Al ejecutar `r.run()`, se llama al método `toUpperCase` en el objeto mensaje.

3. **Referencia a un método de instancia de un objeto arbitrario de un tipo específico**: Este tipo de referencia se usa cuando tienes un tipo de clase, y el método se aplica a cualquier instancia de esa clase. La sintaxis es:

```java
ClassName::instanceMethod
```
**Ejemplo**
```java
import java.util.List;

public class EjemploReferenciaMetodoInstanciaArbitraria {
    public static void main(String[] args) {
        List<String> mensajes = List.of("hola", "mundo");

        // Referencia a un método de instancia de un objeto arbitrario (String)
        mensajes.forEach(String::toUpperCase);
    }
}
```
**Explicación**:

* `String::toUpperCase` es una referencia a un método de instancia de cualquier objeto `String`. En este caso, `toUpperCase` se aplicará a cada string en la lista mensajes.

4. **Referencia a un constructor**: Este tipo de referencia se utiliza cuando necesitas crear una instancia de una clase mediante un constructor. La sintaxis es:

```java
ClassName::new
```
**Ejemplo**
```java
import java.util.function.Supplier;

public class EjemploReferenciaConstructor {
    public static void main(String[] args) {
        // Referencia a un constructor
        Supplier<EjemploReferenciaConstructor> instancia = EjemploReferenciaConstructor::new;

        // Crear una nueva instancia
        EjemploReferenciaConstructor objeto = instancia.get();
        System.out.println("Nueva instancia creada: " + objeto);
    }
}
```
**Explicación**:

* `EjemploReferenciaConstructor::new` es una referencia al constructor de la clase `EjemploReferenciaConstructor`.

* Usamos un `Supplier` para crear una nueva instancia utilizando el constructor referenciado.

## ¿Cómo lo resuelven?
Las referencias a métodos permiten escribir código más conciso y reutilizable. Resuelven la necesidad de escribir expresiones lambda largas que simplemente llaman a métodos ya existentes, haciendo que el código sea más fácil de leer y mantener.

## Comparación entre expresiones Lambda y referencias a métodos
Aquí te muestro cómo una lambda puede ser reemplazada por una referencia a método para mejorar la legibilidad:

**Ejemplo con Lambda**
```java
numeros.stream()
       .map(n -> Integer.parseInt(n))
       .forEach(n -> System.out.println(n));-
```
Reemplazando por referencia a métodos:
```java
numeros.stream()
       .map(Integer::parseInt)
       .forEach(System.out::println);
```
Diferencia:

* En lugar de utilizar una expresión lambda `n -> Integer.parseInt(n)`, usamos la referencia a método `Integer::parseInt`.

* En lugar de `n -> System.out.println(n)`, usamos la referencia a método `System.out::println`.
Esto simplifica y mejora la claridad del código, especialmente en flujos complejos.