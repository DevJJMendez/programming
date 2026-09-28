# Abstracción
Es un mecanismo que permite simplificar la interacción con objetos al enfocarse solo en lo que es importante para el usuario, mientras que se ocultan los detalles complejos de implementación. **Está estrechamente relacionada con el concepto de ocultar detalles complejos para exponer solo lo esencial.**

## ¿Qué es la Abstracción?
La abstracción es el proceso de ocultar los detalles de implementación y mostrar solo la funcionalidad necesaria. En lugar de trabajar directamente con las implementaciones concretas, trabajas con una **representación simplificada** que permite que el programador enfoque su atención solo en lo que es relevante para la tarea en cuestión.

* Abstracción en programación significa trabajar con **interfaces** y **clases abstractas** para proporcionar una estructura común sin preocuparnos por las implementaciones específicas de las clases concretas.

## ¿Para qué sirve la Abstracción?
La abstracción sirve para:

* **Simplificar la complejidad**: Al ocultar los detalles de implementación, puedes interactuar con sistemas más complejos de manera sencilla y sin sobrecargar al usuario con información innecesaria.

* **Promover el diseño modular**: Permite crear sistemas más modulares al enfocarse en los comportamientos que un objeto debe proporcionar sin tener que conocer los detalles internos.

* **Mejorar la reutilización de código**: Al abstraer el comportamiento común, se pueden reutilizar las implementaciones sin necesidad de reescribir todo el código.

* **Fomentar la flexibilidad y mantenimiento**: Si los detalles internos de un sistema cambian, solo es necesario modificar la clase concreta, sin afectar a las interfaces que utilizan otras clases.

## ¿Qué resuelve la Abstracción?
* **Reducción de la complejidad**: La abstracción permite que el programador se enfoque en la interfaz y los comportamientos esenciales sin preocuparse por los detalles de bajo nivel.

* **Dependencia de implementación**: Gracias a la abstracción, puedes escribir código que dependa de una interfaz o clase abstracta sin saber qué implementación concreta se utilizará. Esto permite cambiar las implementaciones sin afectar el resto del sistema.

* **Falta de flexibilidad**: La abstracción permite que las implementaciones se puedan cambiar o extender sin interrumpir el sistema que depende de ellas.

* **Codificación repetitiva**: El uso de abstracciones elimina la necesidad de codificar comportamientos comunes varias veces. Al definir estos comportamientos en clases o interfaces abstractas, el código es más limpio y fácil de mantener.

## ¿Cómo lo resuelve?
La abstracción en C# se puede lograr principalmente a través de **interfaces y clases abstractas**. Ambas permiten definir comportamientos sin imponer una implementación concreta, permitiendo que las clases que las implementen o hereden proporcionen su propia implementación específica.

1. **Interfaces**: Una interfaz define un conjunto de métodos (sin implementación) que una clase puede implementar. Las interfaces proporcionan una estructura común sin necesidad de preocuparse por los detalles de cómo se implementa.

   * Sintaxis de una interfaz:
```csharp
public interface IVehiculo
{
    void Conducir();  // Método que debe ser implementado por las clases que implementen la interfaz
}
```

2. **Clases Abstractas**: Una clase abstracta es similar a una clase normal, pero no puede ser instanciada directamente. Puede tener métodos concretos (con implementación) y métodos abstractos (sin implementación). Las clases que hereden de una clase abstracta deben proporcionar implementaciones para los métodos abstractos.

   * Sintaxis de una clase abstracta:
```csharp
public abstract class Animal
{
    // Método concreto
    public void Comer()
    {
        Console.WriteLine("El animal está comiendo");
    }
    // Método abstracto
    public abstract void HacerSonido();  // Este debe ser implementado en las clases derivadas
}
```

## Ejemplo de Abstracción en C#
```csharp
using System;

// Interfaz que define el comportamiento común
public interface IConducible
{
    void Conducir();
}

// Clase abstracta que define un comportamiento común
public abstract class Vehiculo
{
    public abstract void Mover();  // Método abstracto que debe ser implementado

    public void Detener()
    {
        Console.WriteLine("El vehículo se ha detenido");
    }
}

// Clase concreta que implementa la interfaz y hereda de la clase abstracta
public class Coche : Vehiculo, IConducible
{
    public override void Mover()  // Implementación del método abstracto
    {
        Console.WriteLine("El coche se mueve");
    }

    public void Conducir()  // Implementación del método de la interfaz
    {
        Console.WriteLine("Conduciendo el coche");
    }
}

// Clase concreta que implementa la interfaz y hereda de la clase abstracta
public class Moto : Vehiculo, IConducible
{
    public override void Mover()  // Implementación del método abstracto
    {
        Console.WriteLine("La moto se mueve");
    }

    public void Conducir()  // Implementación del método de la interfaz
    {
        Console.WriteLine("Conduciendo la moto");
    }
}

public class Program
{
    public static void Main()
    {
        // Instanciando objetos concretos
        IConducible coche = new Coche();
        IConducible moto = new Moto();

        // Usando la interfaz para acceder a los comportamientos comunes
        coche.Conducir();
        moto.Conducir();

        // Usando los métodos de las clases concretas
        Vehiculo vehiculo1 = new Coche();
        vehiculo1.Mover();
        vehiculo1.Detener();

        Vehiculo vehiculo2 = new Moto();
        vehiculo2.Mover();
        vehiculo2.Detener();
    }
}
```
Explicación del ejemplo:
* **Interfaz IConducible**: Define un método `Conducir()` que debe ser implementado por cualquier clase que quiera proporcionar la funcionalidad de conducción.

* **Clase abstracta Vehiculo**: Define un método `Mover()` abstracto que debe ser implementado en las clases concretas, y un método concreto `Detener()` que puede ser heredado tal cual.

* **Clases Coche y Moto**: Son clases concretas que implementan la interfaz `IConducible` y heredan de la clase abstracta `Vehiculo`, proporcionando sus implementaciones específicas de los métodos.

## Ventajas de la Abstracción:
* **Reducción de la complejidad**: Al abstraer los detalles de implementación, solo se trabaja con las interfaces que definen lo que un objeto debe hacer, sin tener que entender cómo lo hace.

* **Desacoplamiento**: Las clases que usan la abstracción no dependen de la implementación específica de otras clases. Esto mejora la flexibilidad y hace que el sistema sea más fácil de cambiar.

* **Reutilización de código**: Las clases pueden reutilizar las interfaces o clases abstractas, lo que reduce la duplicación de código.

* **Mejor mantenimiento y extensión**: La abstracción permite cambiar o mejorar las implementaciones sin afectar a las clases que dependen de ellas.

## Consideraciones a tener en cuenta:
* **Demasiada abstracción puede ser contraproducente**: Si abstraes en exceso, podrías terminar con un diseño más complejo de lo necesario. Es importante encontrar un equilibrio.

* **Diseño de interfaces**: Asegúrate de que las interfaces proporcionen comportamientos relevantes y no sean demasiado específicas ni generales.

---
[](Interfaces.md)