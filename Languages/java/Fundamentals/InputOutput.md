# Entrada y Salida de datos - Input / Output
La entrada y salida de datos (I/O) en Java se maneja principalmente a través de clases en el paquete `java.io` y, a partir de Java 7, en el paquete `java.nio`. Aquí se describen las clases y métodos más comunes para manejar la entrada y salida de datos en Java.

## Entrada de datos

- Clase `Scanner`

La clase **Scanner** en el paquete `java.util` se utiliza comúnmente para leer la entrada desde la consola.

Ejemplo de uso:
```java
import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        
        scanner.close();
    }
}
```

- Clase `BufferedReader`

La clase **BufferedReader** se utiliza para leer texto de una secuencia de entrada de manera eficiente.

Ejemplo de uso:
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderExample {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter your name: ");
        String name = reader.readLine();
        
        System.out.print("Enter your age: ");
        int age = Integer.parseInt(reader.readLine());
        
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
```

## Salida de datos

- Clase `System.out`

El objeto **System.out** es una instancia de `PrintStream` que se utiliza para imprimir datos a la consola.

Ejemplo de uso:
```java
public class OutputExample {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.print("Enter your name: ");
    }
}
```

## Lectura y Escritura de Archivos

- Clase `FileReader` y `FileWriter`

Estas clases se utilizan para leer y escribir caracteres en archivos.

Ejemplo de Uso de **FileReader**:
```java
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("input.txt")) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Ejemplo de Uso de **FileWriter**:
```java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write("Hello, World!\n");
            writer.write("This is an example of FileWriter.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Input y Casting
El casting al ingresar datos en Java se usa comúnmente cuando se obtienen entradas del usuario y se necesita convertir esas entradas de tipo **String** a otros tipos de datos, como **enteros**, **flotantes**, **dobles**, etc. Esto se hace generalmente utilizando clases de envoltura (wrapper classes) como Integer, Double, Float, etc., que proporcionan métodos para convertir cadenas en tipos de datos primitivos.

- **Ingresar Datos Usando `Scanner`**

Ejemplo y tipos de datos:
```java
import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer un entero
        System.out.print("Ingrese un número entero: ");
        String intInput = scanner.nextLine();
        int intValue = Integer.parseInt(intInput);
        System.out.println("El número entero es: " + intValue);

        // Leer un número de punto flotante
        System.out.print("Ingrese un número de punto flotante: ");
        String floatInput = scanner.nextLine();
        float floatValue = Float.parseFloat(floatInput);
        System.out.println("El número de punto flotante es: " + floatValue);

        // Leer un doble
        System.out.print("Ingrese un número doble: ");
        String doubleInput = scanner.nextLine();
        double doubleValue = Double.parseDouble(doubleInput);
        System.out.println("El número doble es: " + doubleValue);

        // Leer un booleano
        System.out.print("Ingrese un valor booleano (true/false): ");
        String booleanInput = scanner.nextLine();
        boolean booleanValue = Boolean.parseBoolean(booleanInput);
        System.out.println("El valor booleano es: " + booleanValue);

        scanner.close();
    }
}
```

-  **Uso de `Scanner` para Ingresar Directamente Diferentes Tipos de Datos**

La clase **Scanner** también proporciona métodos específicos para leer directamente tipos de datos primitivos sin necesidad de realizar conversiones manuales.

Ejemplo:
```java
import java.util.Scanner;

public class DirectInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer un entero directamente
        System.out.print("Ingrese un número entero: ");
        int intValue = scanner.nextInt();
        System.out.println("El número entero es: " + intValue);

        // Leer un número de punto flotante directamente
        System.out.print("Ingrese un número de punto flotante: ");
        float floatValue = scanner.nextFloat();
        System.out.println("El número de punto flotante es: " + floatValue);

        // Leer un doble directamente
        System.out.print("Ingrese un número doble: ");
        double doubleValue = scanner.nextDouble();
        System.out.println("El número doble es: " + doubleValue);

        // Leer un booleano directamente
        System.out.print("Ingrese un valor booleano (true/false): ");
        boolean booleanValue = scanner.nextBoolean();
        System.out.println("El valor booleano es: " + booleanValue);

        scanner.close();
    }
}
```

## Consideraciones y Buenas Prácticas

- **Manejo de Excepciones**: Siempre es una buena práctica manejar posibles excepciones que puedan surgir durante la conversión, como NumberFormatException, para asegurar que el programa no se detenga inesperadamente debido a una entrada inválida.
    ```java
    import java.util.Scanner;

    public class SafeInputExample {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Ingrese un número entero: ");
                String intInput = scanner.nextLine();
                int intValue = Integer.parseInt(intInput);
                System.out.println("El número entero es: " + intValue);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero válido.");
            }
            scanner.close();
        }
    }
    ```

- **Validación de Entrada**: Validar la entrada del usuario antes de intentar convertirla puede ayudar a evitar errores y mejorar la experiencia del usuario.

    ```java
    import java.util.Scanner;

    public class InputValidationExample {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese un número entero: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero válido.");
                scanner.next(); // Descartar la entrada inválida
            }
            int intValue = scanner.nextInt();
            System.out.println("El número entero es: " + intValue);

            scanner.close();
        }
    }
    ```