#Classes
# Constructores
En C#, un constructor es un método especial que se utiliza para inicializar un objeto recién creado de una clase. El constructor tiene el mismo nombre que la clase y no tiene tipo de retorno. Se invoca automáticamente cuando se crea un objeto, y su principal tarea es establecer los valores iniciales de las propiedades del objeto.

El propósito de un constructor es garantizar que los objetos estén correctamente inicializados antes de ser utilizados, lo que asegura la coherencia del estado del objeto.

## ¿Cuáles son los tipos de constructores?
1. **Constructor por defecto (sin parámetros)**: Es un constructor que no toma ningún parámetro. Si no defines un constructor en la clase, C# proporcionará automáticamente un constructor por defecto sin parámetros que inicializa el objeto con los valores predeterminados de sus miembros.

   * Ejemplo:
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    // Constructor por defecto
    public Persona()
    {
        Nombre = "Desconocido";
        Edad = 0;
    }
}

public class Program
{
    public static void Main()
    {
        Persona persona = new Persona(); // Llama al constructor por defecto
        Console.WriteLine($"Nombre: {persona.Nombre}, Edad: {persona.Edad}");
    }
}
```

2. **Constructor parametrizado**: Un constructor parametrizado toma uno o más parámetros para permitir la inicialización personalizada de un objeto. Este tipo de constructor permite asignar valores a las propiedades de un objeto al momento de su creación.

   * Ejemplo:
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    // Constructor parametrizado
    public Persona(string nombre, int edad)
    {
        Nombre = nombre;
        Edad = edad;
    }
}

public class Program
{
    public static void Main()
    {
        Persona persona = new Persona("Juan", 30); // Llama al constructor parametrizado
        Console.WriteLine($"Nombre: {persona.Nombre}, Edad: {persona.Edad}");
    }
}
```

3. **Constructor de copia**: Un constructor de copia crea una nueva instancia de un objeto a partir de otro objeto existente de la misma clase. Permite clonar el estado de un objeto.

   * Ejemplo
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    // Constructor de copia
    public Persona(Persona otraPersona)
    {
        Nombre = otraPersona.Nombre;
        Edad = otraPersona.Edad;
    }
}

public class Program
{
    public static void Main()
    {
        Persona persona1 = new Persona("Juan", 30);
        Persona persona2 = new Persona(persona1); // Llama al constructor de copia
        Console.WriteLine($"Nombre: {persona2.Nombre}, Edad: {persona2.Edad}");
    }
}
```

## ¿Para qué sirven los constructores?
* **Inicialización de objetos**: El propósito principal de los constructores es inicializar un objeto con valores predeterminados o proporcionados al momento de su creación. Esto garantiza que el objeto esté en un estado válido antes de ser utilizado.

* **Controlar la creación de instancias**: Los constructores proporcionan un mecanismo para controlar cómo se crean las instancias de una clase. Puedes usar constructores para imponer reglas sobre los valores iniciales o garantizar que los objetos siempre se creen de una manera específica.

* **Sobrecarga de la creación de objetos**: Mediante la sobrecarga de constructores, puedes proporcionar varias formas de inicializar un objeto, dependiendo de los parámetros proporcionados al momento de la creación.

* **Evitar el uso de valores predeterminados no deseados**: A través de constructores parametrizados, puedes evitar la necesidad de trabajar con valores predeterminados no deseados. Puedes asegurar que un objeto siempre se cree con los valores apropiados.

## ¿Qué resuelven los constructores?
* **Inicialización coherente**: Los constructores resuelven el problema de inicializar un objeto correctamente antes de su uso, lo que ayuda a evitar errores que pueden surgir cuando un objeto no tiene valores iniciales adecuados.

* **Encapsulamiento de la lógica de inicialización**: Los constructores permiten centralizar la lógica de inicialización de un objeto, lo que hace que el código sea más limpio, comprensible y fácil de mantener.

* **Creación de objetos con valores personalizados**: Los constructores parametrizados permiten crear objetos con valores específicos en el momento de su creación, en lugar de depender de valores predeterminados.

* **Prevención de la creación de objetos con estado inconsistente**: Los constructores garantizan que los objetos se creen con un estado consistente, evitando que un objeto se quede en un estado inválido o incompleto.

## ¿Cómo lo resuelven?
* **Uso de la palabra clave `new`**: Los constructores son invocados automáticamente cuando se utiliza la palabra clave `new` para crear un objeto de una clase. C# buscará el constructor correspondiente (por defecto o parametrizado) dependiendo de los parámetros proporcionados.

* **Inicialización de propiedades dentro del constructor**: Dentro del constructor, puedes inicializar las propiedades del objeto o ejecutar cualquier otra lógica necesaria para garantizar que el objeto esté listo para su uso.

* **Ejemplo de inicialización en el constructor**:
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    // Constructor parametrizado
    public Persona(string nombre, int edad)
    {
        // Lógica de inicialización personalizada
        if (edad < 0) throw new ArgumentException("La edad no puede ser negativa");
        Nombre = nombre;
        Edad = edad;
    }
}

public class Program
{
    public static void Main()
    {
        try
        {
            // Se pasa un valor válido al constructor
            Persona persona1 = new Persona("Ana", 25);
            Console.WriteLine($"Nombre: {persona1.Nombre}, Edad: {persona1.Edad}");

            // Intento de crear una persona con una edad negativa, se lanza una excepción
            Persona persona2 = new Persona("Luis", -5);
        }
        catch (ArgumentException e)
        {
            Console.WriteLine(e.Message);
        }
    }
}
```

* **Sobrecarga de constructores**: Puedes crear varios constructores dentro de la misma clase con diferentes firmas (diferentes números o tipos de parámetros). Esto permite crear objetos de diferentes maneras.
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    // Constructor por defecto
    public Persona()
    {
        Nombre = "Desconocido";
        Edad = 0;
    }

    // Constructor parametrizado
    public Persona(string nombre, int edad)
    {
        Nombre = nombre;
        Edad = edad;
    }
}

public class Program
{
    public static void Main()
    {
        Persona persona1 = new Persona(); // Constructor por defecto
        Persona persona2 = new Persona("Carlos", 35); // Constructor parametrizado

        Console.WriteLine($"Persona1: {persona1.Nombre}, {persona1.Edad} años");
        Console.WriteLine($"Persona2: {persona2.Nombre}, {persona2.Edad} años");
    }
}
```