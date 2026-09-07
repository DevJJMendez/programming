# Operadores de comparación
los operadores de comparación se utilizan para comparar dos valores y devuelven un resultado booleano (true o false). Estos operadores son fundamentales para el control del flujo del programa mediante sentencias condicionales y bucles. A continuación, revisaremos cada uno de los operadores de comparación en Java y veremos ejemplos de cómo se utilizan.

## Operadores de Comparación
- **Igual a** `(==)`
  - Compara si dos valores son iguales.
  - Devuelve **true** si los valores son iguales, de lo contrario, **false**.
  ```java
  int a = 5;
  int b = 5;
  int c = 10;

  System.out.println(a == b); // true
  System.out.println(a == c); // false
  ```

- **No igual a** `(!=)`
  - Compara si dos valores no son iguales.
  - Devuelve **true** si los valores no son iguales, de lo contrario, **false**.
  ```java
  System.out.println(a != b); // false
  System.out.println(a != c); // true
  ```

- **Mayor que** `(>)`
  - Compara si el primer valor es mayor que el segundo.
  - Devuelve **true** si el primer valor es mayor, de lo contrario, **false**.
  ```java
  System.out.println(c > a); // true
  System.out.println(a > c); // false
  ```

- **Menor que** `(<)`
  - Compara si el primer valor es menor que el segundo.
  - Devuelve **true** si el primer valor es menor, de lo contrario, **false**.
  ```java
  System.out.println(a < c); // true
  System.out.println(c < a); // false
  ```

- **Mayor o igual que** `(>=)`
  - Compara si el primer valor es mayor o igual que el segundo.
  - Devuelve **true** si el primer valor es mayor o igual, de lo contrario, **false**.
  ```java
  System.out.println(a >= b); // true
  System.out.println(c >= a); // true
  System.out.println(a >= c); // false
  ```

- **Menor o igual que** `(<=)`
  - Compara si el primer valor es menor o igual que el segundo.
  - Devuelve **true** si el primer valor es menor o igual, de lo contrario, **false**.
  ```java
  System.out.println(a <= b); // true
  System.out.println(a <= c); // true
  System.out.println(c <= a); // false
  ```

# Operadores Logicos
se utilizan para combinar múltiples expresiones booleanas y evaluar condiciones complejas. Devuelven un resultado booleano (true o false).

## Operadores Lógicos
- **AND Lógico** `(&&)`
  - Devuelve **true** si ambas expresiones son verdaderas.
  - Si la primera expresión es **false**, la segunda no se evalúa (cortocircuito).
  ```java
  boolean a = true;
  boolean b = false;
  boolean c = true;

  System.out.println(a && b); // false
  System.out.println(a && c); // true
  ```

- **OR Lógico** `(||)`
  - Devuelve **true** si al menos una de las expresiones es verdadera.
  - Si la primera expresión es **true**, la segunda no se evalúa (cortocircuito)
  ```java
  System.out.println(a || b); // true
  System.out.println(b || b); // false
  ```

- **NOT Lógico** `(!)`
  - Invierte el valor de la expresión booleana.
  - **!true** se convierte en **false** y **!false** se convierte en **true**
  ```java
  System.out.println(!a); // false
  System.out.println(!b); // true
  ```

# Operadores Aritmeticos

se utilizan para asignar valores a las variables. El operador de asignación más básico es el =, que simplemente asigna el valor del lado derecho al operando del lado izquierdo. Además de =, Java proporciona varios operadores de asignación compuesta que combinan una operación aritmética con la asignación, haciendo el código más conciso y legible.

## Operadores Aritméticos

- **Suma** `(+)`
  - Suma dos operandos.
  ```java
  int a = 10;
  int b = 20;
  int sum = a + b; // 30
  ```
- **Resta** `(-)`
  - Resta el segundo operando del primero.
  ```java
  int diff = a - b; // -10
  ```
- **Multiplicación** `(*)`
  - Multiplica dos operandos.
  ```java
  int product = a * b; // 200
  ```
- **División** `(/)`
  - Divide el primer operando por el segundo.
  ```java
  int quotient = b / a; // 2
  ```
- **Módulo** `(%)`
  - Devuelve el resto de la división de dos operandos.
  ```java
  int remainder = b % a; // 0
  ```
- **Incremento** `(++)`
  - Incrementa el valor de una variable en 1.
  - Puede ser utilizado en forma de prefijo (++a) o sufijo (a++).
  ```java
  a++; // a es ahora 11
  ++a; // a es ahora 12
  ```
- **Decremento** `(--)`
  - Decrementa el valor de una variable en 1.
  - Puede ser utilizado en forma de prefijo (--a) o sufijo (a--).
  ```java
  b--; // b es ahora 19
  --b; // b es ahora 18
  ```

# Operadores de asignación

## Operadores de Asignación
- **Asignación Simple** `(=)`
  - Asigna el valor del lado derecho al operando del lado izquierdo.
  ```java
  int a = 10; // a ahora tiene el valor de 10
  ```
- **Asignación Suma** `(+=)`
  - Suma el valor del lado derecho al operando del lado izquierdo y asigna el resultado al operando del lado izquierdo.
  ```java
  a += 5; // equivalente a a = a + 5; ahora a es 15
  ```
- **Asignación Resta** `(-=)`
  - Resta el valor del lado derecho al operando del lado izquierdo y asigna el resultado al operando del lado izquierdo.
  ```java
  a -= 3; // equivalente a a = a - 3; ahora a es 12
  ```
- **Asignación Multiplicación** `(*=)`
  - Multiplica el operando del lado izquierdo por el valor del lado derecho y asigna el resultado al operando del lado izquierdo.
  ```java
  a *= 2; // equivalente a a = a * 2; ahora a es 24
  ```
- **Asignación División** `(/=)`
  - Divide el operando del lado izquierdo por el valor del lado derecho y asigna el resultado al operando del lado izquierdo.
  ```java
  a /= 4; // equivalente a a = a / 4; ahora a es 6
  ```
- **Asignación Módulo** `(%=)`
  - Calcula el resto de dividir el operando del lado izquierdo por el valor del lado derecho y asigna el resultado al operando del lado izquierdo.
  ```java
  a %= 5; // equivalente a a = a % 5; ahora a es 1
  ```

---

# if
se utiliza para tomar decisiones en el código. Permite ejecutar un bloque de código solo si una condición específica se evalúa como true. Esta estructura de control es fundamental para implementar lógica condicional y es esencial para controlar el flujo de ejecución de un programa.

## Sintaxis Básica

```java
if (condición) {
    // Bloque de código a ejecutar si la condición es verdadera
}
```

- **Ejemplo Básico**
  ```java
  public class IfExample {
      public static void main(String[] args) {
          int number = 10;

          if (number > 5) {
              System.out.println("El número es mayor que 5.");
          }
      }
  }
  ```

# if - else
permite definir un bloque de código **alternativo** que se ejecutará si la condición es false.

```java
if (condición) {
    // Bloque de código a ejecutar si la condición es verdadera
} else {
    // Bloque de código a ejecutar si la condición es falsa
}
```
- **Ejemplo**
  ```java
  public class IfElseExample {
    public static void main(String[] args) {
        int number = 3;

        if (number > 5) {
            System.out.println("El número es mayor que 5.");
        } else {
            System.out.println("El número es 5 o menor.");
        }
    }
  }
  ```
# if - else if - else
se utiliza cuando se tienen múltiples condiciones para evaluar. Permite definir varios bloques de código condicionales.
```java
if (condición1) {
    // Bloque de código a ejecutar si la condición1 es verdadera
} else if (condición2) {
    // Bloque de código a ejecutar si la condición2 es verdadera
} else {
    // Bloque de código a ejecutar si ninguna de las condiciones anteriores es verdadera
}
```
- **Ejemplo**
  ```java
  public class IfElseIfElseExample {
    public static void main(String[] args) {
        int number = 10;

        if (number > 10) {
            System.out.println("El número es mayor que 10.");
        } else if (number == 10) {
            System.out.println("El número es igual a 10.");
        } else {
            System.out.println("El número es menor que 10.");
        }
    }
  } 
  ```

## Anidamiento de if
Las estructuras if se pueden anidar dentro de otras estructuras if para evaluar condiciones más complejas.

- **Ejemplo de Anidamiento**
  ```java
  public class NestedIfExample {
      public static void main(String[] args) {
          int number = 15;

          if (number > 10) {
              if (number < 20) {
                  System.out.println("El número está entre 10 y 20.");
              } else {
                  System.out.println("El número es 20 o mayor.");
              }
          } else {
              System.out.println("El número es 10 o menor.");
          }
      }
  }
  ```

# Guard Clauses
son una técnica de programación que se utiliza para mejorar la legibilidad y mantenibilidad del código, especialmente en métodos que tienen múltiples niveles de condiciones anidadas. La idea principal es verificar las condiciones negativas o excepcionales al inicio de un método y, si alguna de estas condiciones se cumple, salir inmediatamente del método (generalmente con un return o lanzando una excepción). Esto evita que el flujo principal del método se anide dentro de múltiples bloques **if-else**, haciendo que el código sea más directo y fácil de seguir.

## ¿Para qué sirve?
- **Mejorar la legibilidad**: Al manejar las condiciones excepcionales al principio, el flujo principal del método queda menos anidado y más fácil de entender.
- **Reducir la complejidad**: Evita múltiples niveles de anidamiento, lo que puede ser confuso y difícil de mantener.
- **Facilitar el mantenimiento**: Los métodos más cortos y directos son más fáciles de modificar y depurar.

## ¿Cómo usarlo?

Aquí hay un ejemplo que muestra cómo transformar un método tradicional con condiciones anidadas en un método utilizando cláusulas de guarda.

- **Método tradicional con condiciones anidadas**:
  ```java
  public void processOrder(Order order) {
      if (order != null) {
          if (order.isPaid()) {
              if (order.isInStock()) {
                  shipOrder(order);
              } else {
                  System.out.println("Order is out of stock.");
              }
          } else {
              System.out.println("Order is not paid.");
          }
      } else {
          System.out.println("Order is null.");
      }
  }
  ```

- **Método utilizando cláusulas de guarda**:
  ```java
  public void processOrder(Order order) {
      if (order == null) {
          System.out.println("Order is null.");
          return;
      }
      if (!order.isPaid()) {
          System.out.println("Order is not paid.");
          return;
      }
      if (!order.isInStock()) {
          System.out.println("Order is out of stock.");
          return;
      }
      shipOrder(order);
  }
  ```
En el segundo ejemplo, las condiciones excepcionales se manejan al principio, permitiendo que el flujo principal del método (el envío del pedido) quede claro y no anidado.

## ¿Cuándo usar Guard Clauses?

- **Validaciones de parámetros**: Verificar si los parámetros de entrada son válidos al comienzo de un método.
- **Verificación de precondiciones**: Asegurarse de que ciertas condiciones se cumplan antes de continuar con el flujo principal del método.
- **Manejo de errores temprano**: Salir de un método inmediatamente si se detecta una condición de error o una situación que impida continuar.

- **Ejemplo de Validación de parametros**:
```java
public void updateProfile(User user) {
    if (user == null) {
        throw new IllegalArgumentException("User cannot be null");
    }

    if (user.getName() == null || user.getName().isEmpty()) {
        throw new IllegalArgumentException("User name cannot be empty");
    }

    if (user.getEmail() == null || user.getEmail().isEmpty()) {
        throw new IllegalArgumentException("User email cannot be empty");
    }

    // Actualizar perfil
    saveUserProfile(user);
}
```

## ¿Cuándo no usar Guard Clauses?
- **Métodos muy simples**: Si el método es muy corto y no tiene condiciones complejas, el uso de guard clauses podría no ser necesario.
- **Código donde el flujo principal es más corto que las condiciones**: Si las condiciones de verificación son más complejas y largas que el propio flujo principal del método, podría no tener sentido usar guard clauses.

## Buenas prácticas con Guard Clauses

- **Mantenlo simple**: No abuses de las guard clauses al punto de hacer el código difícil de seguir. Deben simplificar, no complicar.
- **Manejo de excepciones adecuado**: En lugar de múltiples mensajes System.out.println, considera lanzar excepciones para condiciones que representan errores del programa.
- **Comentarios claros**: Si las guard clauses manejan casos excepcionales que no son obvios, añade comentarios explicativos.

- **Ejemplo de buenas practicas**:
```java
public void validateAndProcessOrder(Order order) {
    if (order == null) {
        throw new IllegalArgumentException("Order cannot be null");
    }

    if (!order.isPaid()) {
        throw new IllegalStateException("Order must be paid before processing");
    }

    if (!order.isInStock()) {
        throw new IllegalStateException("Order cannot be processed because it is out of stock");
    }

    // Proceed with processing the order
    process(order);
}
```

# Operador Ternario
El operador ternario en Java, también conocido como el operador condicional, es una forma compacta de evaluar una expresión y devolver uno de dos valores, basado en el resultado de la evaluación de una condición. Es útil para simplificar ciertas estructuras if-else en una sola línea, mejorando la concisión y, en muchos casos, la legibilidad del código.

## Sintaxis del Operador Ternario

La sintaxis básica del operador ternario es la siguiente:
```java
condición ? valor_si_verdadero : valor_si_falso;
```

- **Donde**:
  - **condición** es una expresión booleana que se evalúa.
  - **valor_si_verdadero** es el valor que se devuelve si la condición es true.
  - **valor_si_falso** es el valor que se devuelve si la condición es false.

## Ejemplo básico
```java
int a = 10;
int b = 20;
int max = (a > b) ? a : b;
System.out.println("El valor máximo es: " + max);
```
En este ejemplo, `max` se asigna a `a` si `a` es mayor que `b`, de lo contrario, se asigna a `b`. Como `a` no es mayor que `b`, `max` tendrá el valor de `b`, que es **20**

##  Usos Comunes del Operador Ternario

- **Asignación de Variables**

El operador ternario se usa comúnmente para la asignación de variables basada en una condición.

```java
int age = 18;
String eligibility = (age >= 18) ? "Adult" : "Minor";
System.out.println("Eligibility: " + eligibility);
```
En este caso, la variable `eligibility` se asigna a "`Adult`" si `age` es 18 o mayor, de lo contrario, se asigna a "`Minor`".

- **Retorno de Valores en Métodos**

También es útil para devolver valores directamente desde un método.

```java
public String getGreeting(boolean isMorning) {
    return isMorning ? "Good morning!" : "Good evening!";
}
```
Este método devuelve **"Good morning!"** si `isMorning` es `true`, y **"Good evening!"** si `isMorning` es `false`.

## Ventajas y Desventajas del Operador Ternario

- **Ventajas**:
  - **Concisión**: Permite reducir el número de líneas de código.
  - **Legibilidad**: En situaciones simples, puede hacer que el código sea más fácil de leer.

- **Desventajas**:
  - **Complejidad**: En condiciones complejas, puede hacer que el código sea difícil de leer y mantener.
  - **Debugging**: Puede ser más difícil de depurar que las estructuras if-else tradicionales, especialmente para los desarrolladores menos experimentados.

## Buenas Prácticas

- **Manténlo simple**: Usa el operador ternario solo para condiciones simples. Evita anidar operadores ternarios o usarlos para condiciones complejas.

- **Legibilidad**: Prioriza la legibilidad del código. Si el uso del operador ternario hace que el código sea difícil de entender, considera usar una estructura if-else tradicional.

- **Comentarios**: Si la expresión ternaria no es obvia, añade comentarios para explicar la lógica

## Ejemplos Adicionales
- **Ejemplo con Cálculos**
```java
int num = 7;
String parity = (num % 2 == 0) ? "even" : "odd";
System.out.println("The number is " + parity);
```
Este ejemplo determina si un número es par o impar y almacena el resultado en la variable `parity`.

- **Ejemplo con Objetos**

```java
String status = (user.isActive()) ? "Active" : "Inactive";
System.out.println("User status: " + status);
```
Aquí, se verifica el estado de un usuario y se asigna una cadena correspondiente basada en si el usuario está activo o no.

---

# Switch
se utiliza para seleccionar uno de varios bloques de código que se ejecutarán en función del valor de una expresión. Es una alternativa a la cadena de sentencias if-else if y puede hacer que el código sea más legible y fácil de mantener cuando se maneja con múltiples condiciones basadas en el mismo valor.

## Sintaxis del switch

La estructura básica de un switch es la siguiente:

```java
switch (expresión) {
    case valor1:
        // Bloque de código para el caso valor1
        break;
    case valor2:
        // Bloque de código para el caso valor2
        break;
    // Puedes tener tantos casos como necesites
    default:
        // Bloque de código para el caso por defecto
}
```

## Puntos Clave
- **Expresión**: La expresión dentro del switch se evalúa una vez y su valor se compara con los valores de cada caso.

- **Casos**: Cada case representa un posible valor que puede tener la expresión. Si la expresión coincide con un valor de caso, el bloque de código correspondiente se ejecuta.

- **Break**: La sentencia break se usa para salir del switch después de ejecutar un caso. Si se omite, la ejecución continuará con el siguiente caso (**fall-through**).

- **Default**: El bloque default se ejecuta si ninguno de los valores de caso coincide con la expresión. Es opcional pero recomendable para manejar casos imprevistos.

## Ejemplo Básico

```java
public class SwitchExample {
    public static void main(String[] args) {
        int day = 3;
        String dayName;

        switch (day) {
            case 1:
                dayName = "Sunday";
                break;
            case 2:
                dayName = "Monday";
                break;
            case 3:
                dayName = "Tuesday";
                break;
            case 4:
                dayName = "Wednesday";
                break;
            case 5:
                dayName = "Thursday";
                break;
            case 6:
                dayName = "Friday";
                break;
            case 7:
                dayName = "Saturday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }

        System.out.println("The day is " + dayName);
    }
}
```
En este ejemplo, el valor de `day` es 3, por lo que el switch ejecutará el caso correspondiente a 3 y asignará "Tuesday" a `dayName`.

## Switch con Strings

Desde Java 7, el switch también puede usarse con cadenas (String).

```java
public class SwitchStringExample {
    public static void main(String[] args) {
        String fruit = "Apple";
        String color;

        switch (fruit) {
            case "Apple":
                color = "Red";
                break;
            case "Banana":
                color = "Yellow";
                break;
            case "Grapes":
                color = "Purple";
                break;
            default:
                color = "Unknown";
                break;
        }

        System.out.println("The color of the fruit is " + color);
    }
}
```

## Switch con Enums
El switch es particularmente útil con **enums** porque garantiza que todas las posibles constantes se manejan explícitamente.
```java
public class SwitchEnumExample {
    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        Day day = Day.WEDNESDAY;
        String activity;

        switch (day) {
            case SUNDAY:
                activity = "Rest";
                break;
            case MONDAY:
                activity = "Work";
                break;
            case TUESDAY:
                activity = "Work";
                break;
            case WEDNESDAY:
                activity = "Meeting";
                break;
            case THURSDAY:
                activity = "Work";
                break;
            case FRIDAY:
                activity = "Work";
                break;
            case SATURDAY:
                activity = "Sports";
                break;
            default:
                activity = "Unknown";
                break;
        }

        System.out.println("The activity for " + day + " is " + activity);
    }
}
```

## Ventajas del switch
- **Claridad**: Es más claro y más legible que una cadena larga de `if-else if`.

- **Rendimiento**: En algunos casos, puede ser más eficiente que if-else debido a cómo está implementado internamente.

- **Mantenimiento**: Facilita la adición de nuevos casos o la modificación de casos existentes.

## Desventajas del switch
- **Limitaciones de tipos**: Solo puede usarse con ciertos tipos (int, char, byte, short, String, y enum).

- **Fall-through no deseado**: Puede llevar a errores si se olvida la sentencia `break`.

## Buenas Prácticas
- **Usar default**: Siempre incluye un caso default para manejar valores inesperados.

- **Evitar fall-through**: Usa `break` para evitar la ejecución de casos no deseados.

- **Mantén el switch simple**: Evita hacer lógica compleja dentro de los casos del switch.


---

