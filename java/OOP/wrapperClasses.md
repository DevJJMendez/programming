## Wrapper Classes
En Java, las Wrapper Classes son clases que encapsulan (envuelven) tipos de datos primitivos en un objeto. Esto permite que los tipos primitivos, como `int`, `char`, `boolean`, etc., sean tratados como objetos, lo que es útil en contextos donde se requiere un objeto en lugar de un tipo primitivo, como en las colecciones de Java (por ejemplo, **ArrayList**, **HashMap**).

**Wrapper Classes Disponibles**: Para cada tipo de dato primitivo, existe una clase envolvente correspondiente:

| Tipo Primitivo | Clase Envolvente |
| -------------- | ---------------- |
| byte           | Byte             |
| short          | Short            |
| int            | Integer          |
| long           | Long             |
| float          | Float            |
| double         | Double           |
| char           | Character        |
| boolean        | Boolean          |


Sometimes you must use wrapper classes, for example when working with Collection objects, such as ArrayList, where primitive types cannot be used (the list can only store objects):
```java
ArrayList<int> myNumbers = new ArrayList<int>(); // Invalid

ArrayList<Integer> myNumbers = new ArrayList<Integer>(); // Valid
```

### Otros Ejemplos de Uso
**Crear un Objeto de una Wrapper Class**: Puedes crear un objeto de una clase envolvente utilizando su constructor o método estático `valueOf`.
```java
public class WrapperExample {
    public static void main(String[] args) {
        // Usando el constructor
        Integer integerObject = new Integer(5);
        // Usando el método valueOf
        Integer integerObject2 = Integer.valueOf(5);

        // Convertir de objeto a primitivo
        int intValue = integerObject.intValue();
        
        System.out.println("integerObject: " + integerObject);
        System.out.println("intValue: " + intValue);
    }
}
```

### Autoboxing y Unboxing
Java proporciona una característica llamada **autoboxing** y **unboxing** que automáticamente convierte entre tipos primitivos y sus correspondientes clases envolventes.

- **Autoboxing**: Convertir un tipo primitivo en su correspondiente clase envolvente automáticamente.

- **Unboxing**: Convertir un objeto de una clase envolvente en su correspondiente tipo primitivo automáticamente.

```java
public class AutoBoxingExample {
    public static void main(String[] args) {
        // Autoboxing: convertir int a Integer
        Integer integerObject = 10;

        // Unboxing: convertir Integer a int
        int intValue = integerObject;

        System.out.println("integerObject: " + integerObject);
        System.out.println("intValue: " + intValue);
    }
}
```

### Métodos Útiles en Wrapper Classes
Las clases envolventes proporcionan varios métodos útiles para trabajar con datos primitivos y sus representaciones en cadena.

- Conversiones de String a Tipo Primitivo y Viceversa:
    ```java
    public class ConversionExample {
        public static void main(String[] args) {
            // String a int
            int intValue = Integer.parseInt("123");
            // int a String
            String stringValue = Integer.toString(123);

            System.out.println("intValue: " + intValue);
            System.out.println("stringValue: " + stringValue);
        }
    }
    ```
- Comparación de Valores:
    ```java
    public class CompareExample {
        public static void main(String[] args) {
            Integer a = 10;
            Integer b = 20;

            int comparison = a.compareTo(b); // -1 porque a < b
            System.out.println("Comparison result: " + comparison);
        }
    }
    ```

### Buenas Prácticas
* **Usar Autoboxing/Unboxing Cuando Sea Apropiado**: La característica de autoboxing/unboxing hace que el código sea más limpio y legible, pero es importante ser consciente del rendimiento, ya que puede haber una sobrecarga al convertir entre tipos primitivos y objetos.

* **Evitar el Uso de Clases Envolventes en Bucles Críticos**: En situaciones donde el rendimiento es crítico, como en bucles intensivos, es mejor usar tipos primitivos para evitar la sobrecarga de la creación de objetos.