#fundamentals
# `main`
El punto de entrada en una aplicación Java es el lugar desde donde el programa comienza a ejecutarse. Este punto es clave para cualquier aplicación y tiene una estructura específica que Java sigue para iniciar el flujo de la aplicación.

1. **`main Method`, el Punto de Entrada**: El método main es el punto de entrada para cualquier aplicación Java estándar. Este es el método que la Java Virtual Machine (JVM) busca cuando se inicia la aplicación. La firma exacta del método es:

```java
public static void main(String[] args)
```
**Descomposición de la Firma del Método `main`:**
* `public`: Este modificador indica que el método es accesible desde cualquier parte. La JVM necesita poder acceder a este método, por lo que debe ser público.

* `static`: Esto significa que el método pertenece a la clase, no a una instancia específica de la clase. La JVM puede llamar al método `main` sin crear una instancia de la clase.

* `void`: El método no devuelve ningún valor.

* `main`: El nombre del método que la JVM reconoce como el punto de entrada.

* `String[] args`: Un arreglo de objetos String que representa los argumentos de línea de comandos que se pasan a la aplicación. Esto permite que el programa reciba parámetros al iniciarse.

2. **Uso de Argumentos de Línea de Comandos (`args`)**: El parámetro `args` del método `main` permite que tu aplicación acepte argumentos de línea de comandos. Por ejemplo:

```java
public class MiPrograma {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Primer argumento: " + args[0]);
        } else {
            System.out.println("No se proporcionaron argumentos.");
        }
    }
}
```

3. **¿Qué Pasa si el Método main no es `public`, `static` o `void`?**
   * Si el método no es `public`, la JVM no podrá acceder a él y lanzará un error de acceso.

   * Si el método no es `static`, la JVM necesitaría crear una instancia de la clase para ejecutarlo, lo que no es el comportamiento esperado.

   * Si el método no es `void`, no generará un error, pero no tiene sentido devolver un valor desde main porque la JVM no sabe qué hacer con él.

# Estructura básica de un programa Java
Un programa Java típico consiste en una o más clases. Cada clase se guarda en un archivo con el mismo nombre que la clase y la extensión `.java`. La clase principal de un programa Java contiene el método `main`, que es el **punto de entrada del programa**.

- **Ejemplo básico**
  
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

## Clases y Objetos
Java es un lenguaje orientado a objetos, lo que significa que se basa en clases y objetos.

- **Declaración de Clases**
```java
public class Car {

    // Campos (Variables de instancia)
    private String color;
    private String model;
    
    // Constructor
    public Car(String color, String model) {
        this.color = color;
        this.model = model;
    }

    // Métodos
    public void displayDetails() {
        System.out.println("Car model: " + model + ", color: " + color);
    }
}
```

- **Creación de Objetos**
```java
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Red", "Toyota");
        myCar.displayDetails();
    }
}
```

## Ejemplo básico de un programa Java
```java
public class helloWorld{
    public static void main(String[] args){
        System.out.println("¡Hola, Mundo!");
    }
}
```

## Programas con Múltiples Clases
Aunque una aplicación puede tener múltiples clases, solo una clase debe tener el método main que actúe como punto de entrada. Por ejemplo:
```java
public class ClasePrincipal {
    public static void main(String[] args) {
        OtraClase.imprimirMensaje();
    }
}

class OtraClase {
    public static void imprimirMensaje() {
        System.out.println("¡Hola desde OtraClase!");
    }
}
```

# Comentarios
son anotaciones en el código que son ignoradas por el compilador y el intérprete. Se utilizan para explicar y documentar el código, lo cual facilita su mantenimiento y comprensión tanto para ti como para otros desarrolladores que puedan trabajar con el mismo código en el futuro. Java soporta tres tipos de comentarios:

### Tipos de Comentarios en Java

- **Comentarios de una sola línea**

Se utilizan para comentarios breves que caben en una sola línea. Se inician con dos barras diagonales `//`.

**Ejemplo**:
```java
public class Main {
    public static void main(String[] args) {
        // Esto es un comentario de una sola línea
        System.out.println("Hello, World!"); // Este comentario explica esta línea de código
    }
}
```
- **Comentarios de múltiples líneas**

Se utilizan para comentarios más largos que abarcan varias líneas. Se inician con `/*` y terminan con `*/`.
```java
public class Main {
    public static void main(String[] args) {
        /*
         * Esto es un comentario de múltiples líneas.
         * Puedes usarlo para describir bloques de código más grandes o agregar información adicional.
         */
        System.out.println("Hello, World!");
    }
}
```
- **Comentarios de documentación**
  
Los comentarios de documentación se utilizan para generar documentación HTML automáticamente utilizando la herramienta Javadoc de Java. Se inician con /** y terminan con */. Estos comentarios se colocan generalmente antes de las clases, métodos y variables para describir su propósito, parámetros y valor de retorno.

**Ejemplo**:
```java
/**
 * La clase HelloWorld imprime "Hello, World!" en la consola.
 */
public class HelloWorld {
    
    /**
     * El método main es el punto de entrada de la aplicación.
     * 
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
    
    /**
     * Este método suma dos números.
     * 
     * @param a El primer número.
     * @param b El segundo número.
     * @return La suma de a y b.
     */
    public int add(int a, int b) {
        return a + b;
    }
}
```

## Buenas Prácticas para Comentarios

- Sé claro y conciso: Los comentarios deben ser fáciles de entender y no demasiado largos. Evita comentarios innecesarios que no aportan valor.

- Actualiza los comentarios: Mantén los comentarios actualizados con el código. Comentarios desactualizados pueden ser peores que no tener comentarios.

- Usa comentarios para explicar el 'por qué', no el 'qué': El código debe ser autoexplicativo en la medida de lo posible. Usa comentarios para explicar la intención detrás de un bloque de código, no para describir lo que hace el código en sí mismo.

- Documenta clases y métodos públicos: Utiliza Javadoc para documentar todas las clases y métodos públicos. Esto ayuda a otros desarrolladores a entender cómo usar tu código.

- Evita comentar código obsoleto: Si necesitas desactivar partes del código, considera eliminarlo en lugar de comentarlo. Usa un sistema de control de versiones para mantener el historial del código.

**Ejemplo:**
```java
/**
 * La clase Calculator proporciona métodos para realizar operaciones aritméticas básicas.
 */
public class Calculator {
    
    /**
     * Suma dos números.
     * 
     * @param a El primer número.
     * @param b El segundo número.
     * @return La suma de a y b.
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Resta el segundo número del primero.
     * 
     * @param a El primer número.
     * @param b El segundo número.
     * @return La diferencia entre a y b.
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Multiplica dos números.
     * 
     * @param a El primer número.
     * @param b El segundo número.
     * @return El producto de a y b.
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Divide el primer número por el segundo.
     * 
     * @param a El numerador.
     * @param b El denominador.
     * @return El cociente de a y b.
     * @throws ArithmeticException Si b es cero.
     */
    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}
```

# Nomenclaturas
Las buenas prácticas de nomenclatura en Java son fundamentales para garantizar que el código sea legible, mantenible y comprendido fácilmente por otros desarrolladores. 

- **Nombre del Proyecto**
  - **Convención**: Usa nombres que describan claramente el propósito del proyecto.
  - **Ejemplo**: `EcommercePlatform`, `WeatherForecastingSystem`.

- **Nombre de Paquetes**
  - **Convención**: Los nombres de los paquetes deben estar en minúsculas y evitar el uso de guiones bajos. Generalmente, se utiliza la convención de dominio invertido para garantizar la unicidad.
  - **Ejemplo**: `com.mycompany.myapp`, `org.example.project`.

- **Nombre de Variables y Parámetros**
  - **Convención**: Usa camelCase y elige nombres que describan claramente el propósito de la variable.
  - **Ejemplo**: `totalPrice`, `customerList`, `orderDate`.

- **Nombre de Constantes**
  - **Convención**: Usa letras mayúsculas con palabras separadas por guiones bajos.
  - **Ejemplo**: `MAX_USERS`, `DEFAULT_TIMEOUT`, `PI`.

- **Nombre de Clases**
  - **Convención**: Usa PascalCase (cada palabra comienza con una letra mayúscula).
  - **Ejemplo**: `Customer`, `OrderProcessor`, `InvoiceService`.

- **Nombre de Interfaces**
  - **Convención**: Usa PascalCase como para las clases, y es común (pero no obligatorio) que el nombre describa un comportamiento.
  - **Ejemplo**: `Serializable`, `Comparable`, `EventListener`.

- **Nombre de Métodos**
  - **Convención**: Usa camelCase (la primera letra es minúscula y cada palabra subsiguiente comienza con una letra mayúscula). Los nombres de los métodos deben ser verbos o frases verbales.
  - **Ejemplo**: `calculateTotalPrice`, `sendEmailNotification`, `findUserById`.

- **Nombre de Enums**
  - **Convención**: Usa PascalCase para el nombre del enum y letras mayúsculas con guiones bajos para los valores.
  - **Ejemplo**:
  ```java
  public enum OrderStatus {
      PENDING,
      COMPLETED,
      CANCELLED;
  }
  ```

- **Nombre de Paquetes Internos o Módulos**
  - **Convención**: Usa nombres descriptivos en minúsculas, a menudo separados por puntos para indicar jerarquía.
  - **Ejemplo**: `com.mycompany.myapp.service`, `org.example.project.utilities`.

-  **Nombre de Test Cases y Métodos de Pruebas**
  - **Convención**: Usa nombres descriptivos que indiquen claramente lo que se está probando. Para las clases de test, usa Test como sufijo.
    ```java
    public class OrderProcessorTest {
      @Test
      public void testCalculateTotalPrice() {
          // test implementation
      }
    }
    ```
## Consejos adicionales

- **Coherencia**:
Mantén la coherencia en el uso de las convenciones de nombres en todo el proyecto. Esto facilita la lectura y el mantenimiento del código.

- **Claridad sobre Concisión**:
Prefiere la claridad sobre la brevedad. Un nombre de variable más largo que describe su propósito es mejor que uno corto que puede ser ambiguo.

- **Evitar Abreviaturas**:
Usa nombres completos y evita abreviaturas a menos que sean muy comunes y ampliamente comprendidas (por ejemplo, URL, HTTP).

- **Contexto Importa**:
Asegúrate de que el nombre del elemento dé suficiente contexto por sí mismo. Por ejemplo, en lugar de temp (temporal), usa `temporaryFile` si se refiere a un archivo temporal.

- **Prefijo en Interfaces de Facturación (Opcional)**:
Algunas convenciones incluyen el uso del prefijo **I** para interfaces (por ejemplo, **ICustomerService**), aunque esta práctica es menos común en Java moderno.

- **Comentarios y Documentación**:
Complementa los nombres claros con comentarios y documentación cuando sea necesario, especialmente para métodos complejos o con lógica no evidente.