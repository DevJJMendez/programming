# Herencia
La herencia es un mecanismo que permite a una clase (llamada clase derivada o subclase) adquirir las propiedades y comportamientos de otra clase (llamada clase base o superclase).

En C#, la herencia se establece utilizando el símbolo de dos puntos `:`. Una clase derivada hereda todos los métodos, propiedades y campos públicos y protegidos de su clase base.

Ejemplo básico:
```csharp
public class Animal
{
    public void Eat()
    {
        Console.WriteLine("The animal is eating.");
    }
}

public class Dog : Animal
{
    public void Bark()
    {
        Console.WriteLine("The dog is barking.");
    }
}

class Program
{
    static void Main(string[] args)
    {
        Dog dog = new Dog();
        dog.Eat(); // Heredado de Animal
        dog.Bark(); // Definido en Dog
    }
}
```
En este ejemplo, la clase Dog hereda el método Eat de la clase Animal.

## ¿Para qué sirve la herencia?
1. Reutilización de código: Permite evitar duplicar el mismo código en varias clases.

2. Jerarquías lógicas: Facilita organizar las clases en jerarquías claras y naturales (por ejemplo, un sistema basado en "es un").

3. Extensibilidad: Permite a las clases derivadas extender o modificar el comportamiento de las clases base.

4. Facilidad de mantenimiento: Al tener funcionalidades comunes en una clase base, los cambios en estas funcionalidades afectan automáticamente a las clases derivadas.

## ¿Qué problemas resuelve la herencia?
1. Duplicación de código: Si varias clases comparten funcionalidades similares, estas pueden ser definidas en una clase base común.

2. Complejidad en diseño: Proporciona una manera clara y jerárquica de organizar las clases.

3. Dificultades para extender funcionalidades: Facilita agregar o modificar comportamientos en clases derivadas sin afectar la clase base.

## ¿Cómo resuelve estos problemas?
* Centralización del código compartido: Coloca los atributos y métodos comunes en una clase base, permitiendo que las clases derivadas los hereden automáticamente.

* Polimorfismo: Permite usar objetos de clases derivadas como si fueran de la clase base, simplificando la interacción con diferentes tipos de objetos.

## Tipos de herencia en C#
C# soporta herencia simple, es decir, una clase puede heredar de una sola clase base. Sin embargo, puede implementar múltiples interfaces.

* Herencia simple:
```csharp
public class Vehicle
{
    public void Move()
    {
        Console.WriteLine("The vehicle is moving.");
    }
}

public class Car : Vehicle
{
    public void Honk()
    {
        Console.WriteLine("The car is honking.");
    }
}
```

* Herencia múltiple (usando interfaces): Aunque no se puede heredar de múltiples clases, una clase puede implementar varias interfaces:
```csharp
public interface IDrivable
{
    void Drive();
}

public interface IFlyable
{
    void Fly();
}

public class FlyingCar : IDrivable, IFlyable
{
    public void Drive()
    {
        Console.WriteLine("The car is driving.");
    }

    public void Fly()
    {
        Console.WriteLine("The car is flying.");
    }
}
```

## Modificadores clave en la herencia

public: Las clases derivadas heredan miembros públicos.

protected: Los miembros protegidos son accesibles en la clase base y sus clases derivadas.

private: Los miembros privados no son accesibles para las clases derivadas.

sealed: Evita que una clase pueda ser heredada.
```csharp
public sealed class FinalClass
{
    public void DoWork() => Console.WriteLine("Doing work.");
}

// Esto provocará un error de compilación:
// public class AnotherClass : FinalClass {}
```
abstract: Define clases que no pueden ser instanciadas directamente, solo heredadas.
```csharp
public abstract class Animal
{
    public abstract void MakeSound();
}

public class Dog : Animal
{
    public override void MakeSound()
    {
        Console.WriteLine("Woof!");
    }
}
```
virtual y override: Permiten la modificación de métodos heredados.
```csharp
public class Animal
{
    public virtual void Speak()
    {
        Console.WriteLine("Animal is making a sound.");
    }
}

public class Cat : Animal
{
    public override void Speak()
    {
        Console.WriteLine("Meow!");
    }
}
```

## Buenas prácticas con la herencia

Usar herencia solo cuando tenga sentido: Asegúrate de que exista una relación clara de tipo "es un".

Ejemplo: Un Car es un tipo de Vehicle, pero un Car no es un tipo de Building.

Evitar jerarquías profundas: Diseñar jerarquías de herencia profundas puede dificultar el mantenimiento y comprensión del código.

Preferir composición sobre herencia: Si una relación "tiene un" tiene más sentido que una relación "es un", utiliza la composición.
Ejemplo:
```csharp
public class Engine
{
    public void Start() => Console.WriteLine("Engine started.");
}

public class Car
{
    private Engine _engine = new Engine();

    public void StartCar()
    {
        _engine.Start();
        Console.WriteLine("Car started.");
    }
}
```
No abusar del uso de protected: Prefiere encapsular miembros con private y exponerlos mediante métodos públicos o propiedades.

Polimorfismo sobrecargado: Siempre que trabajes con herencia, utiliza métodos virtuales para que las clases derivadas puedan personalizar el comportamiento.

Ejemplo avanzado de herencia con polimorfismo
```csharp
public abstract class Shape
{
    public abstract double CalculateArea();
}

public class Circle : Shape
{
    public double Radius { get; set; }

    public Circle(double radius)
    {
        Radius = radius;
    }

    public override double CalculateArea()
    {
        return Math.PI * Radius * Radius;
    }
}

public class Rectangle : Shape
{
    public double Width { get; set; }
    public double Height { get; set; }

    public Rectangle(double width, double height)
    {
        Width = width;
        Height = height;
    }

    public override double CalculateArea()
    {
        return Width * Height;
    }
}

class Program
{
    static void Main(string[] args)
    {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        Console.WriteLine($"Circle Area: {circle.CalculateArea()}");
        Console.WriteLine($"Rectangle Area: {rectangle.CalculateArea()}");
    }
}
```