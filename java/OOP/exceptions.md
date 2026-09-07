## Exceptions
Las excepciones en Java son eventos anómalos que ocurren durante la ejecución de un programa, interrumpiendo el flujo normal de instrucciones. Estas anomalías pueden deberse a errores en el código, situaciones inesperadas en tiempo de ejecución, o condiciones especiales que necesitan ser gestionadas.

### Try and Catch
El bloque `try-catch` es una estructura de control en Java utilizada para manejar excepciones. El código que puede generar una excepción se coloca dentro del bloque `try`, y las posibles excepciones que se pueden generar son capturadas y manejadas en el bloque `catch`.

```java
try {
    // Código que puede lanzar una excepción
} catch (TipoDeExcepcion e) {
    // Código para manejar la excepción
}
```
**Ejemplo**
```java
public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int divisor = 0;
            int result = 10 / divisor; // Esto lanzará ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero.");
        }
    }
}
```
En este ejemplo, el código dentro del bloque `try` lanza una `ArithmeticException` cuando intenta dividir por cero. La excepción es capturada y manejada en el bloque `catch`, evitando que el programa termine abruptamente.

### Bloque Finally
El bloque `finally` es una parte opcional de la estructura `try-catch` que se ejecuta siempre, independientemente de si se lanzó una excepción o no. Se utiliza generalmente para liberar recursos como archivos, conexiones a bases de datos, etc.

```java
try {
    // Código que puede lanzar una excepción
} catch (TipoDeExcepcion e) {
    // Código para manejar la excepción
} finally {
    // Código que se ejecuta siempre
}
```
**Ejemplo**
```java
import java.io.*;

public class FinallyExample {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("archivo.txt"));
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
    }
}
```

### ¿Cuándo Usar Try and Catch?
- **Errores de I/O**: Al trabajar con operaciones de entrada/salida como leer o escribir archivos.

- **Operaciones de Red**: Al realizar operaciones de red donde pueden ocurrir problemas de conectividad.

- **Operaciones con Bases de Datos**: Al interactuar con bases de datos, donde pueden ocurrir errores de conexión, tiempo de espera, etc.

- **Conversión de Tipos**: Al convertir tipos de datos que pueden generar excepciones (por ejemplo, convertir un String a un número).

- **Operaciones Críticas**: Donde es crucial manejar errores para evitar la interrupción del programa.

### Cuándo No Usarlo:

- **Errores de Programación**: Para errores que deben ser corregidos en el código y no manejados en tiempo de ejecución (por ejemplo, **NullPointerException**).

- **Pequeñas Operaciones**: Para operaciones muy simples y frecuentes donde el manejo de excepciones puede ser un sobrecosto innecesario.

- **Lógica de Control**: No utilizar **try-catch** como mecanismo de control de flujo normal del programa.

### Impacto en el Rendimiento
El manejo de excepciones puede tener un impacto en el rendimiento debido a la sobrecarga asociada con la captura y manejo de excepciones. Sin embargo, el impacto es generalmente insignificante a menos que se lancen y capturen excepciones frecuentemente en secciones críticas de rendimiento.

### Excepciones Personalizadas con Throw
la palabra clave `throw` se utiliza para lanzar una excepción de manera explícita. Esto es útil cuando deseas indicar que ha ocurrido una condición anómala en tu programa. Además, puedes crear tus propias excepciones personalizadas para manejar situaciones específicas de tu aplicación.

**Uso de throw**

La sintaxis para usar throw es bastante sencilla:
```java
throw new ExceptionType("Mensaje de error");
```

Aquí hay un ejemplo básico:
```java
public class ThrowExample {
    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }

    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Edad no permitida para votar.");
        } else {
            System.out.println("Edad permitida para votar.");
        }
    }
}
```
En este ejemplo, se lanza una `IllegalArgumentException` si la edad es menor a 18.

### Crear Excepciones Personalizadas
Puedes crear tus propias excepciones personalizadas extendiendo la clase **Exception** (o cualquier subclase de Exception). Esto te permite definir condiciones específicas y mensajes de error más significativos para tu aplicación.

**Pasos para Crear Excepciones Personalizadas:**
- **Crear una Clase que Extienda Exception**: Define una nueva clase que extienda Exception.

- **Añadir Constructores**: Añade constructores para inicializar la excepción con un mensaje de error y, opcionalmente, con otra excepción como causa.

**Ejemplo de Excepción Personalizada**
```java
// Definición de la excepción personalizada
class EdadNoValidaException extends Exception {
    public EdadNoValidaException(String mensaje) {
        super(mensaje);
    }
}

// Uso de la excepción personalizada
public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            verificarEdad(15);
        } catch (EdadNoValidaException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }

    public static void verificarEdad(int edad) throws EdadNoValidaException {
        if (edad < 18) {
            throw new EdadNoValidaException("Edad no permitida para votar.");
        } else {
            System.out.println("Edad permitida para votar.");
        }
    }
}
```
En este ejemplo, la clase EdadNoValidaException extiende Exception y se utiliza para lanzar una excepción personalizada si la edad es menor a 18.

### Excepciones Anidadas
El anidamiento de excepciones permite asociar una excepción interna con otra externa, proporcionando una cadena de excepciones que puede ayudar a diagnosticar problemas en diferentes niveles de abstracción.

**¿Por Qué Usar el Anidamiento de Excepciones?**
- **Rastreo Completo**: Permite mantener un rastro completo de la secuencia de errores, desde el error original hasta la excepción final.

- **Diagnóstico Mejorado**: Proporciona más contexto sobre las excepciones, ayudando a los desarrolladores a diagnosticar problemas más fácilmente.

**Cómo Anidar Excepciones**: Puedes anidar excepciones utilizando los constructores de las clases de excepción que aceptan otra excepción como causa. Aquí hay un ejemplo:
```java
public class ChainedExceptionExample {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("Excepción capturada: " + e);
            Throwable causa = e.getCause();
            while (causa != null) {
                System.out.println("Causa: " + causa);
                causa = causa.getCause();
            }
        }
    }

    public static void method1() throws Exception {
        try {
            method2();
        } catch (Exception e) {
            throw new Exception("Error en method1", e);
        }
    }

    public static void method2() throws Exception {
        try {
            method3();
        } catch (Exception e) {
            throw new Exception("Error en method2", e);
        }
    }

    public static void method3() throws Exception {
        throw new Exception("Error en method3");
    }
}
```
**En este ejemplo:**
- method3 lanza una excepción.

- method2 captura esta excepción y lanza una nueva excepción, encapsulando la excepción original como su causa.

- method1 hace lo mismo, creando una cadena de excepciones.