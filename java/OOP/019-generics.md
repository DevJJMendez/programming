# Generics
Los Generics son una característica de Java que permite a las clases, interfaces y métodos manejar objetos de varios tipos sin necesidad de especificarlos explícitamente hasta el momento de su uso. Esto se logra al definir parámetros de tipo, lo que proporciona una forma de crear código que es flexible, reutilizable y seguro en tiempo de compilación.

Los Generics en Java nos permiten crear métodos y clases cuyos tipos de parámetros pueden ser **variables**, y por lo tanto, nos permiten implementar menos código para realizar nuestras funcionalidades. Esto proporciona flexibilidad al código al permitir que los tipos sean parametrizados cuando se utilizan estas estructuras.

## ¿Qué son los Generics?
Generics es un mecanismo de Java que permite trabajar con tipos de datos de manera abstracta sin definir un tipo específico desde el inicio. Esto significa que puedes crear clases, métodos e interfaces que operen sobre cualquier tipo de datos y definir el tipo real en el momento de la instancia o la llamada. Se implementa usando notación con ángulos `<>` (por ejemplo, `<T>`, `<E>`, `<K, V>`) para denotar un tipo de parámetro genérico.

## ¿Para qué sirven los Generics?
Los Generics sirven para:

1. **Reutilizar Código**: Permiten que el mismo código funcione para diferentes tipos de datos sin necesidad de redefinir clases o métodos.

2. **Seguridad de Tipos en Tiempo de Compilación**: Previenen errores de tipo al garantizar que solo se usen los tipos esperados, evitando ClassCastException.

3. **Legibilidad y Mantenibilidad del Código**: Hacen que el código sea más claro y fácil de entender, ya que los tipos son explícitos en tiempo de compilación.

4. **Eficiencia**: Reducen la necesidad de convertir tipos (casting), evitando así errores y mejorando la eficiencia.

## ¿Qué Problemas Resuelven los Generics?
1. **Error de Tipos en Tiempo de Ejecución**: Antes de los Generics, Java requería conversiones explícitas entre tipos de objetos en colecciones. Esto generaba posibles errores en tiempo de ejecución, ya que los elementos podían no ser del tipo esperado.

2. **Código Redundante**: Sin Generics, había que escribir la misma clase o método para diferentes tipos de datos, lo cual generaba duplicación.

3. **Flexibilidad y Escalabilidad**: Al no depender de un tipo específico, los Generics permiten que el código sea más fácil de modificar y escalar, ya que los cambios en el tipo de datos no afectan a la estructura del código.

## ¿Cómo Resuelven los Problemas?
Los Generics resuelven estos problemas a través de **parámetros de tipo**, que permiten especificar el tipo en el momento de uso, proporcionando seguridad de tipos y reutilización del código sin necesidad de conversiones o duplicación. Además, en tiempo de compilación, el compilador convierte los tipos genéricos en tipos reales mediante un proceso conocido como type erasure o borrado de tipos.

## Sintaxis Básica
La sintaxis básica para definir clases y métodos genéricos en Java utiliza paréntesis angulares `< >` para indicar el tipo genérico. Por ejemplo, una clase genérica `Box` que puede contener cualquier tipo de objeto se define de la siguiente manera:
```java
public class Box<T> {
    private T contenido;

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
}
```
**En este ejemplo**:
- `T` es el parámetro de tipo genérico.
- `Box<T>` indica que Box es una clase genérica que puede manejar un tipo **T**.
- `contenido` es una variable de instancia de tipo **T**.
- `setContenido` y `getContenido` son métodos que operan sobre el tipo **T**.

--- 

**Uso de Generics**: Al usar la clase `Box` genérica:
```java
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Box para Integer
        Box<Integer> integerBox = new Box<>();
        integerBox.setContenido(123);

        // Obtener el contenido y usarlo sin castings
        int contenido = integerBox.getContenido();
        System.out.println("Contenido de integerBox: " + contenido);

        // Crear una instancia de Box para String
        Box<String> stringBox = new Box<>();
        stringBox.setContenido("Hola Mundo");

        // Obtener el contenido y usarlo sin castings
        String contenidoString = stringBox.getContenido();
        System.out.println("Contenido de stringBox: " + contenidoString);
    }
}
```
En este caso, `Box<Integer>` y `Box<String>` son instancias diferentes de la clase `Box`, cada una parametrizada con un tipo específico (**Integer** y **String**, respectivamente). Esto garantiza que solo se puedan almacenar y recuperar valores del tipo especificado, proporcionando seguridad de tipo en tiempo de compilación.

## Componentes de Generics
1. **Clases Genéricas**: Son clases que tienen parámetros de tipo, permitiendo almacenar o procesar cualquier tipo de dato.
```java
class Caja<T> {
    private T contenido;

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
}

// Uso
Caja<String> cajaDeTexto = new Caja<>();
cajaDeTexto.setContenido("Hola Generics");
```

2. **Métodos Genéricos**: Métodos que operan con tipos genéricos, permitiendo su uso dentro de cualquier clase.
```java
public <T> void imprimirElemento(T elemento) {
    System.out.println(elemento);
}
```

3. **Interfaces Genéricas**: Las interfaces también pueden ser genéricas, lo que permite definir interfaces para múltiples tipos de datos.
```java
interface Operador<T> {
    T operar(T a, T b);
}
```

4. **Bounded Generics (Generics Acotados)**: Permiten restringir el tipo de los parámetros genéricos para que solo acepten tipos específicos o subtipos de una clase.
```java
class CajaNumeros<T extends Number> {
    private T numero;

    public CajaNumeros(T numero) {
        this.numero = numero;
    }

    public double obtenerValor() {
        return numero.doubleValue();
    }
}
```

5. **Wildcards (`?`)**: Los `?` se usan en generics cuando el tipo no es importante o queremos trabajar con cualquier tipo que siga ciertas restricciones. Los wildcards se utilizan en dos formas principales:

   * **Unbounded Wildcard (`<?>`)**: Acepta cualquier tipo.

   * **Bounded Wildcard (`<? extends Tipo>`)**: Permite cualquier clase que sea Tipo o una subclase.

   * **Lower Bounded Wildcard (`<? super Tipo>`)**: Permite Tipo y cualquier superclase de este.

```java
public void procesarLista(List<?> lista) {
    for (Object elemento : lista) {
        System.out.println(elemento);
    }
}
```

## Ventajas de los Generics en la Construcción de Software Robusto
1. **Evita Errores de Conversión**: Al establecer el tipo en tiempo de compilación, se eliminan los errores de conversión que podrían ocurrir en tiempo de ejecución.

2. **Respeto al Principio de Responsabilidad Única (SRP)**: Los Generics ayudan a evitar que una clase tenga lógica adicional para múltiples tipos, permitiendo así que la clase esté enfocada en un solo tipo de comportamiento.

3. **Extensibilidad y Escalabilidad**: Al no depender de un tipo específico, las clases genéricas permiten que el código sea más fácil de escalar o modificar, incluso cuando se introducen nuevos tipos de datos.

## Convenciones Comunes para Nombres de Parámetros Genéricos
Es común sentir que el uso de letras para especificar parámetros de tipo genérico puede ser poco descriptivo, especialmente cuando se comienza a trabajar con Generics en Java. Sin embargo, hay ciertas convenciones que se utilizan para hacer el código más claro y legible, y es importante conocer estas convenciones y también saber cuándo es apropiado utilizar nombres más descriptivos.

- `E` - Element (usado ampliamente por la API de colecciones de Java)
- `K` - Key (llave, para mapas)
- `V` - Value (valor, para mapas)
- `N` - Number (número)
- `T` - Type (tipo)
- `S`, `U`, `V`, etc. - Usados para representar múltiples tipos.

**Ejemplo usando las Convenciones Comunes**
```java
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
```
En este ejemplo, `K` representa la llave y `V` representa el valor, lo cual es intuitivo al trabajar con un par de datos (como en un Map).

### Ejemplo Usando Nombres Más Descriptivos
En algunos casos, especialmente en clases o métodos más complejos, puede ser útil utilizar nombres de parámetros de tipo más descriptivos para mejorar la legibilidad del código. Aunque las convenciones comunes son útiles y reconocidas, no hay una regla estricta que impida usar nombres más largos y descriptivos si eso mejora la claridad.

```java
public class ResultWrapper<DataType, ErrorType> {
    private DataType data;
    private ErrorType error;

    public ResultWrapper(DataType data, ErrorType error) {
        this.data = data;
        this.error = error;
    }

    public DataType getData() {
        return data;
    }

    public ErrorType getError() {
        return error;
    }
}
```
En este ejemplo, `DataType` y `ErrorType` son nombres de parámetros de tipo que describen claramente su propósito dentro de la clase `ResultWrapper`.