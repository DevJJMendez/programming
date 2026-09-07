# String
Es una de las clases más utilizadas y fundamentales en el lenguaje. Representa una secuencia de caracteres y proporciona una amplia gama de métodos para manipular y trabajar con cadenas de texto. Aquí vamos a revisar algunos de los métodos más importantes y comunes de la clase **String**.

## Creación de Objetos String

Puedes crear objetos String de varias maneras:

```java
public class StringExample {
    public static void main(String[] args) {
        // Creación usando literales
        String str1 = "Hello, World!";
        
        // Creación usando el operador `new`
        String str2 = new String("Hello, World!");

        System.out.println(str1);
        System.out.println(str2);
    }
}
```

## Métodos Principales de la Clase String

- `length()`
  
Devuelve la longitud de la cadena.
```java
String str = "Hello, World!";
int length = str.length(); // 13
```

- `charAt(int index)`
  
Devuelve el carácter en la posición especificada.
```java
char ch = str.charAt(1); // 'e'
```

- `substring(int beginIndex)`

Devuelve una nueva cadena que es una subcadena de esta cadena.
```java
String sub = str.substring(7); // "World!"
```

- `substring(int beginIndex, int endIndex)`
  
Devuelve una nueva cadena que es una subcadena de esta cadena, desde beginIndex hasta endIndex - 1.
```java
String sub = str.substring(7, 12); // "World"
```

- `indexOf(String str)`
  
Devuelve el índice dentro de esta cadena de la primera aparición de la cadena especificada.
```java
int index = str.indexOf("World"); // 7
```

- `lastIndexOf(String str)`
  
Devuelve el índice dentro de esta cadena de la última aparición de la cadena especificada.
```java
int lastIndex = str.lastIndexOf("l"); // 10
```

- `contains(CharSequence s)`
  
Devuelve true si esta cadena contiene la secuencia de caracteres especificada.
```java
boolean contains = str.contains("World"); // true
```

- `equals(Object anObject)`
  
Compara esta cadena con el objeto especificado.
```java
boolean isEqual = str.equals("Hello, World!"); // true
```

- `equalsIgnoreCase(String anotherString)`
  
Compara esta cadena con otra cadena, ignorando las diferencias entre mayúsculas y minúsculas.
```java
boolean isEqualIgnoreCase = str.equalsIgnoreCase("hello, world!"); // true
```

- `toUpperCase()`
  
Convierte todos los caracteres de esta cadena a mayúsculas.
```java
String upper = str.toUpperCase(); // "HELLO, WORLD!"
```

- `toLowerCase()`

Convierte todos los caracteres de esta cadena a minúsculas.
```java
String lower = str.toLowerCase(); // "hello, world!"
```

- `trim()`

Elimina los espacios en blanco iniciales y finales de esta cadena.
```java
String trimmed = str.trim(); // "Hello, World!"
```

- `replace(char oldChar, char newChar)`

Devuelve una nueva cadena que es una copia de esta cadena con todas las ocurrencias del carácter antiguo reemplazadas por el carácter nuevo.
```java
String replaced = str.replace('l', 'x'); // "Hexxo, Worxd!"
```

- `split(String regex)`
  
Divide esta cadena alrededor de coincidencias del expresion regular dada.
```java
String[] parts = str.split(", "); // ["Hello", "World!"]
```

- `toCharArray()`
  
Convierte esta cadena a un nuevo arreglo de caracteres.
```java
char[] charArray = str.toCharArray(); // ['H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!']
```

**Ejemplo completo**
```java
public class StringMethodsExample {
    public static void main(String[] args) {
        String str = "  Hello, World!  ";

        // Longitud de la cadena
        System.out.println("Length: " + str.length());

        // Caracter en una posición específica
        System.out.println("Char at 1: " + str.charAt(1));

        // Subcadena
        System.out.println("Substring (7): " + str.substring(7));
        System.out.println("Substring (7, 12): " + str.substring(7, 12));

        // Índice de una subcadena
        System.out.println("Index of 'World': " + str.indexOf("World"));

        // Contiene una subcadena
        System.out.println("Contains 'Hello': " + str.contains("Hello"));

        // Comparación de cadenas
        System.out.println("Equals '  Hello, World!  ': " + str.equals("  Hello, World!  "));
        System.out.println("Equals ignore case '  hello, world!  ': " + str.equalsIgnoreCase("  hello, world!  "));

        // Conversión a mayúsculas y minúsculas
        System.out.println("To upper case: " + str.toUpperCase());
        System.out.println("To lower case: " + str.toLowerCase());

        // Eliminar espacios en blanco
        System.out.println("Trim: '" + str.trim() + "'");

        // Reemplazar caracteres
        System.out.println("Replace 'l' with 'x': " + str.replace('l', 'x'));

        // Dividir cadena
        String[] parts = str.split(", ");
        System.out.println("Split: " + String.join(" | ", parts));

        // Convertir a arreglo de caracteres
        char[] charArray = str.toCharArray();
        System.out.println("To char array: " + new String(charArray));
    }
}
```

---

# Math Class
La clase Math en Java es una utilidad que proporciona métodos estáticos para realizar operaciones matemáticas, como funciones trigonométricas, logaritmos, raíces cuadradas y más. Esta clase está en el paquete `java.lang`, por lo que no es necesario importarla explícitamente. Vamos a explorar algunos de los métodos más importantes y comunes que ofrece la clase Math.

## Métodos de la Clase Math

- `Math.abs()`
  
Devuelve el valor absoluto de un número.
```java
int a = -10;
int absA = Math.abs(a); // 10

double b = -5.5;
double absB = Math.abs(b); // 5.5
```

- `Math.max()` y `Math.min()`

Devuelven el valor máximo y mínimo entre dos números, respectivamente.
```java
int max = Math.max(10, 20); // 20
int min = Math.min(10, 20); // 10

double maxDouble = Math.max(10.5, 20.5); // 20.5
double minDouble = Math.min(10.5, 20.5); // 10.5
```

- `Math.ceil()` y `Math.floor()`

**Math.ceil()** redondea un número hacia arriba al entero más cercano, mientras que **Math.floor()** redondea hacia abajo.
```java
double ceilValue = Math.ceil(5.3); // 6.0
double floorValue = Math.floor(5.7); // 5.0
```

- `Math.round()`

Redondea un número al entero más cercano.
```java
long roundValue = Math.round(5.5); // 6
int roundValueFloat = Math.round(5.5f); // 6
```

- `Math.sqrt()`

Devuelve la raíz cuadrada de un número.
```java
double sqrtValue = Math.sqrt(16); // 4.0
```

- `Math.pow()`

Eleva un número a la potencia de otro número.
```java
double powValue = Math.pow(2, 3); // 8.0
```

- `Math.exp()` y `Math.log()`

**Math.exp()** devuelve el número e elevado a la potencia del argumento dado, mientras que **Math.log()** devuelve el logaritmo natural (base e) del argumento.
```java
double expValue = Math.exp(1); // 2.718281828459045
double logValue = Math.log(Math.E); // 1.0
```

- `Math.sin()`, `Math.cos()`, `Math.tan()`

Devuelven el seno, coseno y tangente del argumento en radianes, respectivamente.
```java
double sinValue = Math.sin(Math.PI / 2); // 1.0
double cosValue = Math.cos(0); // 1.0
double tanValue = Math.tan(Math.PI / 4); // 1.0
```

- `Math.toRadians()` y `Math.toDegrees()`

Convertir ángulos entre grados y radianes.
```java
double radians = Math.toRadians(180); // 3.141592653589793
double degrees = Math.toDegrees(Math.PI); // 180.0
```

- `Math.random()`

Devuelve un número aleatorio entre 0.0 y 1.0.
```java
double randomValue = Math.random(); // Ejemplo: 0.37444887175646646
```