# Polimorfismo
El polimorfismo es uno de los pilares fundamentales de la programación orientada a objetos (POO). En C#, el polimorfismo permite que los objetos de diferentes tipos derivados puedan ser tratados como si fueran de un tipo base común, habilitando el comportamiento dinámico de métodos en tiempo de ejecución.

1. ¿Qué es el polimorfismo?
La palabra "polimorfismo" proviene del griego y significa "muchas formas". En el contexto de la programación, se refiere a la capacidad de un objeto para comportarse de diferentes maneras según el contexto en el que se utilice.

En C#, hay dos tipos principales de polimorfismo:

Polimorfismo en tiempo de compilación (también llamado sobrecarga).
Polimorfismo en tiempo de ejecución (también llamado sobrescritura).
2. ¿Para qué sirve el polimorfismo?
Reutilización del código: Permite escribir código más general y reutilizable al trabajar con clases base en lugar de clases específicas.
Extensibilidad: Facilita agregar nuevos comportamientos sin modificar el código existente.
Flexibilidad: Permite a los desarrolladores tratar los objetos de diferentes tipos de manera uniforme mediante un tipo base común.
Mantenimiento: Simplifica el mantenimiento al permitir realizar cambios en una clase base sin afectar directamente las clases derivadas.
3. ¿Qué problemas resuelve?
Código rígido y no reutilizable: Sin polimorfismo, habría que escribir código diferente para cada tipo derivado.
Dificultad para trabajar con jerarquías de clases: Sin polimorfismo, sería complejo gestionar comportamientos comunes entre clases relacionadas.
Falta de extensibilidad: El polimorfismo facilita que el código acepte nuevos tipos en el futuro sin necesidad de reescribir la lógica existente.
4. ¿Cómo lo resuelve?
El polimorfismo en C# se logra mediante los conceptos de herencia y el uso de los modificadores virtual, override, abstract y interfaces. Estos permiten que:

Una clase base defina un comportamiento general.
Las clases derivadas sobrescriban o implementen un comportamiento específico.
Los objetos sean tratados uniformemente como si fueran del tipo base, pero ejecuten el comportamiento definido en la clase derivada.
5. Tipos de polimorfismo en C#
A. Polimorfismo en tiempo de compilación (Sobrecarga)
Este tipo de polimorfismo se logra mediante la sobrecarga de métodos y operadores. Se decide cuál método invocar en el momento de la compilación.

Ejemplo: Sobrecarga de métodos
```c#
public class Calculator
{
    public int Add(int a, int b)
    {
        return a + b;
    }

    public double Add(double a, double b)
    {
        return a + b;
    }
}

class Program
{
    static void Main(string[] args)
    {
        Calculator calc = new Calculator();
        Console.WriteLine(calc.Add(5, 10));        // Output: 15
        Console.WriteLine(calc.Add(5.5, 10.3));   // Output: 15.8
    }
}
```

Polimorfismo en tiempo de ejecución (Sobrescritura)
Se logra mediante la sobrescritura de métodos en clases derivadas. El método que se ejecuta se decide en tiempo de ejecución según el tipo real del objeto.

Ejemplo básico:
```C#
public class Animal
{
    public virtual void Speak()
    {
        Console.WriteLine("The animal makes a sound.");
    }
}

public class Dog : Animal
{
    public override void Speak()
    {
        Console.WriteLine("Woof!");
    }
}

public class Cat : Animal
{
    public override void Speak()
    {
        Console.WriteLine("Meow!");
    }
}

class Program
{
    static void Main(string[] args)
    {
        Animal myAnimal = new Dog();
        myAnimal.Speak(); // Output: Woof!

        myAnimal = new Cat();
        myAnimal.Speak(); // Output: Meow!
    }
}
```

## Implementación práctica del polimorfismo
A. Polimorfismo con interfaces
Las interfaces permiten definir un contrato común para diferentes clases. Todas las clases que implementen la interfaz deben proporcionar su propia implementación de los métodos definidos.

Ejemplo:
```c#
public interface IShape
{
    double CalculateArea();
}

public class Circle : IShape
{
    public double Radius { get; set; }

    public Circle(double radius)
    {
        Radius = radius;
    }

    public double CalculateArea()
    {
        return Math.PI * Radius * Radius;
    }
}

public class Rectangle : IShape
{
    public double Width { get; set; }
    public double Height { get; set; }

    public Rectangle(double width, double height)
    {
        Width = width;
        Height = height;
    }

    public double CalculateArea()
    {
        return Width * Height;
    }
}

class Program
{
    static void Main(string[] args)
    {
        IShape circle = new Circle(5);
        IShape rectangle = new Rectangle(4, 6);

        Console.WriteLine($"Circle Area: {circle.CalculateArea()}");       // Output: 78.54
        Console.WriteLine($"Rectangle Area: {rectangle.CalculateArea()}"); // Output: 24
    }
}
```

## Reglas importantes sobre polimorfismo
La clase base debe usar virtual o abstract: Para sobrescribir un método, la clase base debe marcarlo como virtual o abstract.
La clase derivada debe usar override: Los métodos sobrescritos en las clases derivadas deben usar el modificador override.
El polimorfismo funciona con referencias de la clase base: Aunque el objeto es de una clase derivada, se puede tratar como si fuera del tipo base.
Invocación de métodos base: Si se requiere, puedes llamar a la implementación de la clase base usando base.