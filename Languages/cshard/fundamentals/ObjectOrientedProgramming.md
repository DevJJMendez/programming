#OPP
# Programación Orientada a Objetos
La POO es una técnica de programación que permite estructurar un programa en términos de objetos que interactúan entre sí.

**Un objeto es una instancia de una clase, y las clases definen las propiedades (atributos) y los métodos (comportamientos) de los objetos.**

* **Clases**: Definen los tipos de objetos, sus atributos y sus métodos.

* **Objetos**: Son instancias de una clase. Cada objeto tiene su propio estado (valores de atributos) y puede realizar acciones definidas por los métodos.

* **Atributos (propiedades)**: Son las características de los objetos. Por ejemplo, el color o el tamaño de un coche.

* **Métodos (funciones)**: Son las acciones que un objeto puede realizar. Los métodos definen los comportamientos del objeto.

## Pilares de la Programación Orientada a Objetos:
* **Encapsulamiento**: Es la ocultación de los detalles internos de una clase, proporcionando una interfaz pública para interactuar con ella.

* **Herencia**: Es el mecanismo mediante el cual una clase puede heredar propiedades y métodos de otra clase, permitiendo la reutilización de código.

* **Polimorfismo**: Permite que una misma acción pueda realizarse de diferentes maneras, dependiendo del objeto con el que se interactúe.

* **Abstracción**: Permite crear clases que representan conceptos abstractos y ocultar la complejidad del sistema.

## ¿Para qué sirve la Programación Orientada a Objetos?
* **Modelar el mundo real**: POO facilita la representación de entidades del mundo real (por ejemplo, un coche, una persona, una cuenta bancaria) como objetos en el código, lo que hace más natural el diseño de las aplicaciones.

* **Mejor organización y estructuración del código**: Al dividir el código en clases y objetos, la POO organiza el software en componentes pequeños y manejables, lo que facilita su desarrollo y mantenimiento.

* **Reutilización de código**: Gracias a la herencia y el polimorfismo, el código puede ser reutilizado en distintas partes del programa, lo que reduce la duplicación y facilita el mantenimiento.

* **Facilita el mantenimiento y evolución**: La modularidad de los objetos permite que se pueda modificar o ampliar el sistema sin afectar otras partes del código.

* **Mejor escalabilidad**: POO permite el desarrollo de sistemas más grandes y complejos, manteniendo el código claro y fácil de gestionar.

## ¿Qué resuelve la Programación Orientada a Objetos?
* **Complejidad en el código**: La POO ayuda a manejar la complejidad dividiendo el código en objetos, cada uno con responsabilidades claras y bien definidas.

* **Duplicación de código**: La herencia y la reutilización de clases permiten evitar la duplicación de código, lo que mejora la mantenibilidad del software.

* **Falta de flexibilidad**: Con el polimorfismo, los objetos pueden comportarse de diferentes maneras, lo que permite que el programa sea flexible y capaz de manejar diversas situaciones.

* **Errores difíciles de depurar**: El encapsulamiento ayuda a proteger los datos internos de un objeto, reduciendo la probabilidad de que otras partes del programa alteren su estado de forma inesperada.

## ¿Cómo lo resuelve la Programación Orientada a Objetos?
* **Encapsulando datos y comportamientos**:
  * Los datos (atributos) y los comportamientos (métodos) se agrupan dentro de clases. De esta manera, cada clase actúa como una cápsula que organiza y protege sus propios datos.

  * El acceso a los atributos de un objeto se hace a través de métodos, lo que garantiza que los datos solo se modifiquen de manera controlada.
```c#
public class Coche
{
    private string color;
    private int velocidad;

    // Constructor
    public Coche(string color)
    {
        this.color = color;
        this.velocidad = 0;
    }

    // Método para cambiar la velocidad
    public void Acelerar(int incremento)
    {
        velocidad += incremento;
    }

    // Método para obtener la velocidad
    public int ObtenerVelocidad()
    {
        return velocidad;
    }
}
```

* **Uso de la herencia para reutilizar código**:
  * Las clases pueden heredar atributos y métodos de otras clases, lo que permite que el código se reutilice sin duplicarse.

  * Una clase hija puede ampliar o modificar el comportamiento de una clase base.
```C#
public class Vehiculo
{
    public int Velocidad { get; set; }
    public string Color { get; set; }

    public void Acelerar(int incremento)
    {
        Velocidad += incremento;
    }
}

public class Coche : Vehiculo
{
    public void MostrarVelocidad()
    {
        Console.WriteLine($"El coche va a {Velocidad} km/h.");
    }
}
```

* **Polimorfismo para manejar diferentes tipos de objetos**:
  * El polimorfismo permite que un mismo método se ejecute de diferentes maneras dependiendo del tipo de objeto con el que se esté trabajando.

  * Esto permite una mayor flexibilidad y extensibilidad en el software.
```c#
public class Animal
{
    public virtual void HacerSonido()
    {
        Console.WriteLine("El animal hace un sonido.");
    }
}

public class Perro : Animal
{
    public override void HacerSonido()
    {
        Console.WriteLine("El perro ladra.");
    }
}

public class Gato : Animal
{
    public override void HacerSonido()
    {
        Console.WriteLine("El gato maúlla.");
    }
}

// Uso de polimorfismo
Animal miAnimal = new Perro();
miAnimal.HacerSonido();  // Output: El perro ladra.
```

* **Abstracción para ocultar detalles complejos**:
  * La abstracción permite que las clases oculten la implementación compleja de sus métodos y sólo expongan una interfaz sencilla de usar.

  * Las interfaces y clases abstractas se utilizan para definir contratos que las clases deben cumplir.
```C#
public abstract class Vehiculo
{
    public abstract void Moverse();
}

public class Coche : Vehiculo
{
    public override void Moverse()
    {
        Console.WriteLine("El coche se mueve.");
    }
}

public class Barco : Vehiculo
{
    public override void Moverse()
    {
        Console.WriteLine("El barco navega.");
    }
}
```

## Ventajas de la Programación Orientada a Objetos
* **Modularidad**: La POO permite dividir el software en partes más pequeñas y fáciles de manejar (objetos), lo que mejora la organización del código.

* **Reutilización de código**: Gracias a la herencia y el polimorfismo, el código puede ser reutilizado y extendido sin tener que duplicarse.

* **Mantenibilidad**: Los sistemas orientados a objetos son más fáciles de mantener, ya que los objetos y clases están bien definidos y encapsulan su propia funcionalidad.

* **Escalabilidad**: La POO facilita la creación de aplicaciones grandes y complejas sin perder control sobre la estructura del código.

* **Abstracción**: Los detalles internos del sistema se ocultan, lo que hace que la interacción con los objetos sea más sencilla.

## Desventajas de la Programación Orientada a Objetos
* **Curva de aprendizaje**: Para los nuevos programadores, la POO puede ser más difícil de entender debido a conceptos como clases, objetos, herencia y polimorfismo.

* **Sobrecarga de abstracción**: A veces, la implementación de POO puede resultar en un exceso de abstracción que complica el diseño, especialmente en aplicaciones más simples.

* **Rendimiento**: El uso excesivo de objetos y la creación de muchas instancias pueden afectar el rendimiento en aplicaciones con recursos limitados.

---
[](Class.md)

[](Encapsulation.md)
[](Inheritance.md)
[](Abstraction.md)
[](Polymorphims.md)