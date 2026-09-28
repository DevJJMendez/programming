# Tipos de datos
En Java, los datos se dividen en dos categorías principales: datos primitivos y datos no primitivos. Entender la diferencia entre estos tipos es fundamental para trabajar eficazmente en Java y en cualquier lenguaje de programación

## Tipos de Datos Primitivos
Son valores simples, indivisibles, que representan datos básicos del sistema. 

* El valor es el dato, no una referencia. Ejemplos universales:
* Números
* Booleanos
* Caracteres

* **Características clave**
* Tamaño fijo
* No tienen comportamiento
* Copia por valor
* Muy rápidos
* Viven típicamente en el stack

Ejemplo mental
```bash
int x = 5;
```
En memoria:
```bash
x → 00000101
```

Los tipos de datos primitivos en Java son los más básicos y se utilizan para almacenar valores simples. Java tiene ocho tipos de datos primitivos:

- **byte**:
  - Tamaño: 8 bits.
  - Rango: -128 a 127.
  - Uso: Para ahorrar memoria en arrays grandes donde los valores están dentro del rango.
    ```java
    byte a = 10;
    ```
- **short**:
  - Tamaño: 16 bits.
  - Rango: -32,768 a 32,767.
  - Uso: Similar al byte, pero para un rango más amplio de valores.
    ```java
    short b = 1000;
    ```
- **int**:
  - Tamaño: 32 bits.
  - Rango: -2^31 a 2^31-1.
  - Uso: Tipo de dato entero por defecto.
    ```java
    int c = 10000;
    ```
- **long**:
  - Tamaño: 64 bits.
  - Rango: -2^63 a 2^63-1.
  - Uso: Para valores enteros grandes.
    ```java
    long d = 10000000000L;
    ```
- **float**:
  - Tamaño: 32 bits.
  - Rango: Aproximadamente ±3.40282347E+38F.
  - Uso: Para números de punto flotante de precisión simple.
    ```java
    float e = 5.75f;
    ```
- **double**:
  - Tamaño: 64 bits.
  - Rango: Aproximadamente ±1.79769313486231570E+308.
  - Uso: Para números de punto flotante de precisión doble. Es el tipo de punto flotante por defecto.
    ```java
    double f = 19.99;
    ```
- **char**:
  - Tamaño: 16 bits (Unicode).
  - Rango: '\u0000' a '\uffff'.
  - Uso: Para almacenar un solo carácter.
    ```java
    char g = 'A';
    ```
- **boolean**:
  - Tamaño: No definido explícitamente, pero suele ser un bit.
  - Valores: true o false.
  - Uso: Para valores booleanos.
    ```java
    boolean h = true;
    ```
## Tipos de Datos No Primitivos (REFERENCIA)
Son estructuras complejas que viven en memoria dinámica (heap).

La variable no contiene el dato, contiene una referencia al dato. Ejemplos universales:
* Objetos
* Arrays
* Strings (en la mayoría de lenguajes)
* Clases
* Colecciones

Ejemplo mental
```bash
User user = new User("Ana");
```
En memoria:
```bash
user → 0xA12F → [User{name="Ana"}]
```
* **Características clave**
* Pueden tener comportamiento
* Tamaño variable
* Copia por referencia
* Más flexibles
* Más costosos

Los tipos de datos no primitivos (referenciados) incluyen clases, interfaces y arrays. Estos tipos de datos son más complejos que los primitivos y se utilizan para almacenar objetos y estructuras de datos.

- **string**:
  - Uso: Para almacenar cadenas de caracteres.
  - Características: Es una clase en Java, pero se puede usar como un tipo de dato básico.
    ```java
    String str = "Hello, World!";
    ```
- **Arrays**:
  - Uso: Para almacenar múltiples valores del mismo tipo en una sola variable.
  - Características: Los arrays pueden ser de cualquier tipo de dato, incluidos primitivos y no primitivos.
    ```java
    int[] numbers = {1, 2, 3, 4, 5};
    String[] names = {"Alice", "Bob", "Charlie"};
    ```
**Ademas de: Clases, Interfaces, Enums**

## Diferencias Clave entre Primitivos y No Primitivos
- **Almacenamiento en Memoria**:
  - Primitivos: Los valores se almacenan directamente en la memoria.
  - No Primitivos: Los valores se almacenan en el **heap** y las variables contienen referencias a estos objetos.
  
- **Inicialización por Defecto**:
  - Primitivos: Los tipos primitivos tienen valores por defecto (0 para enteros, 0.0 para flotantes, false para booleanos y '\u0000' para char).
  - No Primitivos: Las referencias a objetos tienen un valor por defecto de null.

- **Capacidad de Métodos y Propiedades**:
  - Primitivos: No pueden tener métodos ni propiedades.
  - No Primitivos: Pueden tener métodos y propiedades porque son instancias de clases.

-  **Inmutabilidad**:
  - Primitivos: Los valores son inmutables.
  - No Primitivos: Los valores pueden ser mutables o inmutables, dependiendo de la clase.

### DIFERENCIAS CLAVE
| Aspecto        | Primitivo | No primitivo         |
| -------------- | --------- | -------------------- |
| Qué almacena   | Valor     | Referencia           |
| Tamaño         | Fijo      | Variable             |
| Performance    | Muy alto  | Menor                |
| Mutabilidad    | Inmutable | Generalmente mutable |
| Memoria        | Stack     | Heap                 |
| Comportamiento | ❌         | ✔                    |
| Null           | ❌         | ✔                    |

# Variables
Son espacios en memoria que almacenan datos que pueden cambiar durante la ejecución de un programa. 

- **Declaración e Inicialización**

  ```java
  int number; // Declaración
  number = 10; // Inicialización
  ```

- Se puede hacer en una sola línea:
  ```java
  int number = 10; // Declaración e inicialización
  ```

## Múltiples Variables
Puedes declarar y/o inicializar múltiples variables del mismo tipo en una sola línea.

- **Declaración múltiple**
  ```java
  int a, b, c;
  ```

- **Declaración e Inicialización Múltiple**
  ```java
  int a = 1, b = 2, c = 3;
  ```

## Un Valor para Múltiples Variables
En Java, puedes asignar el mismo valor a múltiples variables utilizando una cadena de asignaciones.

```java
int a, b, c;
a = b = c = 10;
```

# Identificadores
Los identificadores son los nombres utilizados para identificar **variables**, **métodos**, **clases**, etc. en Java. Deben seguir ciertas reglas:

- Comenzar con una letra (a-z, A-Z), un signo de dólar ($) o un guion bajo (_).
- Pueden contener letras, dígitos (0-9), signos de dólar y guiones bajos.
- No pueden ser una palabra reservada.
- Son sensibles a mayúsculas y minúsculas

- **Ejemplos de identificadores válidos**

  ```java
  int age;
  double $salary;
  String _name;
  ```

## Buenas prácticas
- **Nombres Significativos**: Utiliza nombres de variables que describan claramente su propósito.

  ```java
  int age = 25; // Claro y descriptivo
  int a = 25; // No es descriptivo
  ```

- **Camel Case**: Para variables y métodos, utiliza camelCase.

  ```java
  int numberOfStudents; // Correcto
  int number_of_students; // No es la convención en Java
  ```

# Constantes
son valores que, una vez asignados, no pueden cambiar durante la ejecución del programa. Las constantes se definen utilizando la palabra clave `final`, que asegura que la variable no se pueda reasignar una vez inicializada. Además, por convención, los nombres de las constantes se escriben en mayúsculas con guiones bajos para mejorar la legibilidad.

## Definición y Uso de Constantes

- **Constantes Primitivas**
  
Las constantes primitivas son las más comunes y se definen con tipos de datos primitivos.

**Ejemplo**
```java
public class ConstantsExample {
    public static final int MAX_USERS = 100;
    public static final double PI = 3.14159;
    public static final String APP_NAME = "MyApplication";
    
    public static void main(String[] args) {
        System.out.println("Max Users: " + MAX_USERS);
        System.out.println("Value of Pi: " + PI);
        System.out.println("Application Name: " + APP_NAME);
    }
}
```

- **Constantes en Interfaces**

Las constantes también pueden definirse en interfaces. Todas las variables definidas en una interfaz son implícitamente `public`, `static`, y `final`.

**Ejemplo**
```java
public interface ApplicationConstants {
    int MAX_USERS = 100;
    double PI = 3.14159;
    String APP_NAME = "MyApplication";
}

public class ConstantsExample implements ApplicationConstants {
    public static void main(String[] args) {
        System.out.println("Max Users: " + MAX_USERS);
        System.out.println("Value of Pi: " + PI);
        System.out.println("Application Name: " + APP_NAME);
    }
}
```

- Constantes en `enums`

Java también permite definir constantes usando **enum**, que es un tipo especial de clase que representa un grupo de constantes.

**Ejemplo**
```java
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumExample {
    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;
        System.out.println("Today is: " + today);
    }
}
```

## Buenas Prácticas para Definir Constantes

- **Nombres en Mayúsculas**: Utiliza nombres en mayúsculas separados por guiones bajos.

  ```java
  public static final int MAX_USERS = 100;
  ```
- **Uso de la Palabra Clave final**: Asegúrate de usar final para garantizar que la constante no pueda ser reasignada.

  ```java
  public static final double PI = 3.14159;
  ```

- **Alcance Adecuado**: Define las constantes en el ámbito adecuado, como dentro de una clase específica o en una interfaz común si se comparte entre múltiples clases.

  ```java
  public class MathConstants {
      public static final double PI = 3.14159;
      public static final double E = 2.71828;
  }
  ```

- **Documentación**: Documenta las constantes usando comentarios o Javadoc para explicar su propósito.

  ```java
  /**
   * The maximum number of users allowed in the system.
   */
  public static final int MAX_USERS = 100;
  ```

# Concatenación

es el proceso de unir dos o más cadenas de texto (strings) en una sola. 

- **Uso del operador `+`**

El operador + es la forma más sencilla y común de concatenar cadenas en Java.

Ejemplo:
```java
public class ConcatenationExample {
    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;
        System.out.println("Full Name: " + fullName); // Output: Full Name: John Doe
    }
}
```

- **Uso del Método `concat()`**
  
El método concat() de la clase String concatena la cadena especificada al final de la cadena existente.

Ejemplo:
```java
public class ConcatenationExample {
    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName.concat(" ").concat(lastName);
        System.out.println("Full Name: " + fullName); // Output: Full Name: John Doe
    }
}
```

- **Uso de `StringBuilder` o `StringBuffer`**

**StringBuilder** y **StringBuffer** son clases utilizadas para construir cadenas de manera eficiente. **StringBuilder** es **más rápido** pero **no es seguro** para subprocesos, mientras que StringBuffer **es seguro** para subprocesos **pero más lento**.

Ejemplo con **StringBuilder**:
```java
public class ConcatenationExample {
    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Doe";
        StringBuilder fullName = new StringBuilder();
        fullName.append(firstName).append(" ").append(lastName);
        System.out.println("Full Name: " + fullName.toString()); // Output: Full Name: John Doe
    }
}
```

Ejemplo con StringBuffer:
```java
public class ConcatenationExample {
    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Doe";
        StringBuffer fullName = new StringBuffer();
        fullName.append(firstName).append(" ").append(lastName);
        System.out.println("Full Name: " + fullName.toString()); // Output: Full Name: John Doe
    }
}
```

## Consideraciones de Eficiencia

- **Operador +**: Adecuado para un número pequeño de concatenaciones. Para bucles o concatenaciones intensivas, su rendimiento puede degradarse debido a la creación de múltiples objetos String.
  
- **StringBuilder** y **StringBuffer**: Recomendados para operaciones de concatenación intensivas debido a su eficiencia en la modificación de cadenas.

# Booleans
el tipo de dato boolean es un tipo primitivo que puede contener uno de dos valores: true o false. Este tipo de datos se utiliza principalmente para representar estados lógicos y es fundamental en las estructuras de control, como las sentencias condicionales y los bucles.

## Declaración y Asignación de Booleanos

- **Declaración**

Para declarar una variable boolean, utilizas la palabra clave boolean seguida del nombre de la variable:
```java
boolean isJavaFun;
```
- **Asignación**

Puedes asignar un valor true o false a una variable boolean:
```java
isJavaFun = true;
boolean isFishTasty = false;
```

- También puedes combinar la declaración y la asignación en una sola línea:
  ```java
  boolean isJavaFun = true;
  boolean isFishTasty = false;
  ```