#fundamentals
# Casting / Casteo de datos
Es el proceso de convertir un tipo de dato en otro. Hay dos tipos principales de casting: el casting implícito (automático) y el casting explícito (manual). 

## Casting Implícito (Widening)
El casting implícito ocurre cuando Java convierte automáticamente un tipo de dato más pequeño a un tipo de dato más grande. Esto es seguro y no provoca pérdida de información.

```bash
byte -> short -> char -> int -> long -> float -> double
```

Ejemplo:
```java
public class ImplicitCastingExample {
    public static void main(String[] args) {
        int intValue = 42;
        double doubleValue = intValue; // Casting implícito de int a double
        System.out.println("Int value: " + intValue);
        System.out.println("Double value: " + doubleValue);
    }
}
```
En este ejemplo, un **int** se convierte automáticamente en un **double**.

## Casting Explícito (Narrowing)
El casting explícito se utiliza cuando se necesita convertir un tipo de dato más grande a un tipo de dato más pequeño. Este tipo de casting no es seguro y puede provocar pérdida de información, por lo que debe hacerse explícitamente usando paréntesis.

```bash
double -> float -> long -> int -> char -> short -> byte
```

Ejemplo:
```java
public class ExplicitCastingExample {
    public static void main(String[] args) {
        double doubleValue = 42.58;
        int intValue = (int) doubleValue; // Casting explícito de double a int
        System.out.println("Double value: " + doubleValue);
        System.out.println("Int value: " + intValue);
    }
}
```

## Casting entre Tipos de Objetos
En Java, también se puede realizar el casting entre tipos de objetos, especialmente cuando se trabaja con la jerarquía de clases y la herencia.

Ejemplo:
```java
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }
    void fetch() {
        System.out.println("Fetching...");
    }
}

public class ObjectCastingExample {
    public static void main(String[] args) {
        Animal myAnimal = new Dog(); // Upcasting
        myAnimal.makeSound(); // Llamada a makeSound() en Dog

        if (myAnimal instanceof Dog) {
            Dog myDog = (Dog) myAnimal; // Downcasting
            myDog.fetch();
        }
    }
}
```

En este ejemplo, un **Animal** se convierte en un **Dog** mediante upcasting (implícito) y luego se convierte nuevamente en **Dog** mediante downcasting (explícito) para acceder a métodos específicos de **Dog**.

## Buenas Prácticas y Consideraciones
- **Evitar Pérdida de Datos**: Ten cuidado con el casting explícito, ya que puede provocar pérdida de datos. Por ejemplo, convertir un double a un int truncará la parte decimal.

- **Usar instanceof**: Utiliza el operador `instanceof` antes de hacer un downcasting para evitar `ClassCastException`.
  ```java
  if (myAnimal instanceof Dog) {
    Dog myDog = (Dog) myAnimal;
  }
  ```
- **Compatibilidad de Tipos**: Asegúrate de que los tipos son compatibles antes de hacer el casting. No puedes convertir entre tipos no relacionados.

- **Casting en Colecciones**: Cuando trabajes con colecciones genéricas, el casting puede ser necesario debido a la forma en que Java maneja la tipificación en tiempo de compilación y en tiempo de ejecución.

  ```java
  List<Object> list = new ArrayList<>();
  list.add("Hello");
  list.add(10);

  String str = (String) list.get(0);
  Integer num = (Integer) list.get(1);
  ```

## Casting y Tipos Primitivos

**Ejemplo de Widening**:
```java
public class WideningExample {
    public static void main(String[] args) {

        int a = 10;
        float b = a; // int to float
        long c = a;  // int to long
        double d = a; // int to double

        System.out.println("int value: " + a);
        System.out.println("float value: " + b);
        System.out.println("long value: " + c);
        System.out.println("double value: " + d);
    }
}
```

- **Ejemplo de Narrowing**:
```java
public class NarrowingExample {
    public static void main(String[] args) {
        double a = 10.5;
        int b = (int) a; // double to int, pérdida de la parte decimal
        short c = (short) b; // int to short

        System.out.println("double value: " + a);
        System.out.println("int value: " + b);
        System.out.println("short value: " + c);
    }
}
```