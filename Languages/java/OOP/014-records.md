# Records
Los records en Java son una característica introducida en Java 14 (en fase preliminar) y formalmente en Java 16. Los records simplifican la creación de clases inmutables que representan "data carriers" o estructuras de datos con atributos inmutables. Un record define automáticamente características como métodos de acceso, `equals()`, `hashCode()` y `toString()`.

## Qué Son los Records?
Un record es una estructura de datos que encapsula un conjunto fijo de atributos, ofreciendo una manera concisa de declarar clases de datos que son esencialmente inmutables. Al usar un record, Java genera automáticamente métodos típicos para el acceso y la comparación de datos, eliminando la necesidad de escribir estos métodos de forma manual.

Los records se definen con la palabra clave record y tienen una estructura similar a las clases, pero con una sintaxis reducida y enfocada en representar datos.

## ¿Para Qué Sirven los Records?
1. **Definir Clases de Datos Inmutables**: Los records son ideales para representar objetos cuya finalidad es almacenar y transferir datos sin modificarlos después de su creación, como en configuraciones, **DTOs (Data Transfer Objects)**, o respuestas de API.

2. **Reducir el Código Boilerplate**: La declaración de un record reduce la necesidad de escribir código repetitivo, como los métodos `equals()`, `hashCode()`, `toString()` y los métodos de acceso (getters), ya que Java los genera automáticamente.

## ¿Qué Problema Resuelven?
1. **Problema: Complejidad de Crear Clases Inmutables**: Crear una clase inmutable en Java requiere definir atributos finales (`final`), métodos de acceso, y asegurarse de que los datos no se modifiquen. Esto conlleva a escribir código repetitivo. Los records resuelven esto al crear automáticamente todos estos métodos y atributos de manera concisa y eficiente.

2. **Problema: Implementación de Métodos Básicos**: Crear métodos como `equals()`, `hashCode()` y `toString()` manualmente es propenso a errores y consume tiempo. Los records generan estos métodos automáticamente, basándose en los atributos que definen el record.

## ¿Cómo Lo Resuelven?
1. **Declaración Concisa**: Los records se declaran de forma compacta y sencilla. Al definir un record, Java automáticamente crea el constructor, los métodos de acceso, y los métodos `equals()`, `hashCode()` y `toString()`.

2. **Inmutabilidad Predeterminada**: Los atributos en un record son automáticamente final, lo que significa que no se pueden modificar una vez que el objeto ha sido creado. Esto refuerza la inmutabilidad de los datos, mejorando la integridad del sistema.

## Ejemplo de Uso de Records

**Declaración Básica**
```java
public record Persona(String nombre, int edad) {}
```
**En este ejemplo:**

* `Persona` es un record que tiene dos atributos: nombre (de tipo String) y edad (de tipo int).

* No es necesario declarar getters, ya que el record los proporciona automáticamente.

* Los métodos `equals()`, `hashCode()` y `toString()` se generan automáticamente.

**Uso del Record**
```java
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 25);
        
        // Acceder a los datos
        System.out.println("Nombre: " + persona.nombre()); // Salida: Nombre: Juan
        System.out.println("Edad: " + persona.edad());     // Salida: Edad: 25

        // toString, equals, y hashCode son generados automáticamente
        System.out.println(persona); // Salida: Persona[nombre=Juan, edad=25]
    }
}
```

## Características Importantes de los Records
1. **Constructor Compacto**: Los records generan automáticamente un constructor que acepta todos los atributos en el mismo orden en que se definen.

2. **Inmutabilidad y Finalidad de Atributos**: Los atributos en un record son final por defecto, lo que significa que los valores asignados a estos campos no pueden modificarse después de la creación del objeto.

3. **Implementación de Interfaces**: Los records pueden implementar interfaces, pero no pueden extender otras clases (ni siquiera `Record`, ya que ya lo hacen implícitamente).

3. **Limitaciones**:

   * No se puede declarar un record como abstracto.

  * Los records son inmutables por defecto y, aunque se pueden añadir métodos personalizados, no se pueden redefinir métodos como setters para modificar los atributos.

## Consideraciones al Usar Records
1. **Limitaciones en Flexibilidad**: Si necesitas mutabilidad o herencia, los records no son la opción adecuada, ya que están diseñados para ser inmutables y no se pueden extender.

2. **Solo Para Clases de Datos**: Los records están diseñados para ser utilizados como contenedores de datos inmutables y pueden no ser adecuados si se requiere lógica compleja o comportamientos más allá de la representación de datos.

3. **Uso en Entornos de Programación Concurrente**: Los records son una buena opción para entornos concurrentes debido a su inmutabilidad.
