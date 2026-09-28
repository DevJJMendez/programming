# `supplier<>`
`Supplier<T>` es una interfaz funcional en Java que se utiliza para proveer un resultado sin aceptar ningún parámetro de entrada. A diferencia de otras interfaces funcionales, como `Consumer` o `BiConsumer`, que consumen valores sin retornar resultados, el `Supplier` hace lo opuesto: genera o provee un valor, pero no consume ninguno.

**Definición de la interfaz**
```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```

## ¿Qué es Supplier<T>?
* `Supplier<T>` es una interfaz funcional que representa una función que no toma parámetros y devuelve un resultado de tipo `T`.

* **Tiene un único método abstracto**: `T get()`, que se encarga de devolver el valor que ha generado o provisto.

* Se utiliza en situaciones donde necesitas una fuente de valores o datos predefinidos sin pasar argumentos, por ejemplo, al generar objetos, números aleatorios o cargar configuraciones.

## ¿Para qué sirve?
El `Supplier<T>` es útil cuando quieres obtener un valor sin necesidad de pasar ningún parámetro. Sirve como una fuente de datos, que puede ser estática o dinámica, según cómo se implemente el método `get()`. Algunas situaciones típicas donde se usa incluyen:

* **Generación de valores**: Crear valores que pueden ser constantes, generados aleatoriamente o derivados de alguna lógica.

* **Carga perezosa (Lazy Loading)**: Se usa cuando deseas retrasar la creación de un objeto hasta que sea necesario.

* **Testeo**: Proveer datos de prueba en tests unitarios de forma flexible y reutilizable.

## ¿Qué resuelve?
Resuelve la necesidad de proveer valores de forma flexible sin necesidad de argumentos de entrada. Es especialmente útil en escenarios donde se necesitan generar o obtener valores sin depender de entradas externas, o cuando deseas encapsular la lógica de generación de valores dentro de una función reutilizable.

## ¿Cómo lo resuelve?
Lo resuelve mediante el método `get()`, que devuelve un valor generado o calculado de tipo `T`. Puedes definir la lógica de cómo obtener o generar este valor dentro de la implementación de este método.

## Ejemplo básico
A continuación, un ejemplo sencillo en el que se utiliza Supplier<T> para generar un número aleatorio:
```java
import java.util.function.Supplier;
import java.util.Random;

public class EjemploSupplier {
    public static void main(String[] args) {
        // Supplier que genera un número aleatorio
        Supplier<Integer> numeroAleatorio = () -> new Random().nextInt(100); // Genera un número entre 0 y 99

        // Usar el Supplier para obtener un número
        System.out.println("Número aleatorio: " + numeroAleatorio.get());
    }
}
```
Salida
```plaintext
Número aleatorio: 42 (por ejemplo, ya que es aleatorio)
```

## Ejemplo práctico
Supongamos que tenemos una clase `Empleado` y queremos un `Supplier` que cree instancias de empleados de forma perezosa (es decir, solo cuando se necesiten):

```java
import java.util.function.Supplier;

class Empleado {
    private String nombre;
    private int edad;

    public Empleado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Empleado {Nombre: " + nombre + ", Edad: " + edad + "}";
    }
}

public class EjemploSupplier {
    public static void main(String[] args) {
        // Supplier que crea un nuevo empleado
        Supplier<Empleado> crearEmpleado = () -> new Empleado("Juan", 25);

        // Usar el Supplier para crear un empleado
        Empleado empleado = crearEmpleado.get();
        System.out.println(empleado);
    }
}
```
Salida
```plaintext
Empleado {Nombre: Juan, Edad: 25}
```

## Supplier en combinación con otros conceptos
* **Uso de `Supplier` con `Optional`:** A menudo, **Supplier** se combina con clases como **Optional** para generar valores solo cuando es necesario, especialmente cuando existe la posibilidad de que el valor no esté presente.

```java
import java.util.Optional;

public class EjemploSupplier {
    public static void main(String[] args) {
        // Crear un Optional vacío
        Optional<String> nombreOptional = Optional.empty();

        // Usar un Supplier para proporcionar un valor predeterminado si el Optional está vacío
        String nombre = nombreOptional.orElseGet(() -> "Nombre por defecto");

        System.out.println(nombre);  // Salida: Nombre por defecto
    }
}
```
En este ejemplo, `orElseGet()` toma un Supplier para proporcionar un valor por defecto si el **Optional** está vacío.