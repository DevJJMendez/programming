#Classes
# Objetos
En C#, un objeto es una instancia de una clase. Mientras que una clase es una plantilla o blueprint, un objeto es una entidad específica que existe en la memoria con valores concretos para las propiedades definidas en esa clase.

Cuando creas un objeto de una clase, le asignas valores a sus propiedades y puedes interactuar con sus métodos. Los objetos permiten la manipulación de datos y comportamientos, y son el punto de interacción real en un programa orientado a objetos.

## ¿Para qué sirven los objetos?
* **Instanciar clases**: Los objetos permiten crear instancias de las clases y trabajar con ellas de manera concreta.

* **Almacenar datos específicos**: Los objetos contienen valores reales de propiedades, lo que permite representar entidades del mundo real en un programa.

* **Ejecutar comportamiento definido en las clases**: A través de los objetos, puedes invocar métodos que implementan la lógica de negocio de la clase.

* Gestionar memoria de manera eficiente: En la programación orientada a objetos (OOP), cada objeto es independiente en la memoria, lo que permite una mayor modularidad y control sobre el uso de recursos.

## ¿Qué resuelven los objetos?
* **Representación de entidades concretas**: Los objetos permiten representar instancias de entidades del mundo real, como personas, productos, empleados, etc. Cada objeto tiene su propio estado y comportamiento.

* **Abstracción de detalles internos**: Los objetos encapsulan datos y comportamientos, lo que significa que puedes interactuar con ellos sin preocuparte por cómo funcionan internamente. Solo necesitas conocer su interfaz pública (métodos y propiedades).

* **Organización y mantenimiento del código**: Los objetos permiten dividir el código en unidades lógicas que tienen responsabilidades bien definidas, lo que facilita la organización, mantenimiento y extensión del código.

* **Interacción con el programa de forma modular y flexible**: Puedes crear múltiples objetos de una misma clase para representar diferentes instancias, lo que aporta flexibilidad y reutilización del código.

## ¿Cómo lo resuelven?
1. **Instanciación de objetos**: Los objetos se crean mediante la palabra clave `new`, la cual invoca el constructor de la clase para inicializar el objeto.

   * Ejemplo básico de creación de objeto:
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    public void Saludar()
    {
        Console.WriteLine($"Hola, soy {Nombre} y tengo {Edad} años.");
    }
}

public class Program
{
    public static void Main()
    {
        // Creando un objeto de la clase Persona
        Persona persona1 = new Persona();
        persona1.Nombre = "Juan";
        persona1.Edad = 30;

        // Llamando al método Saludar del objeto
        persona1.Saludar();
    }
}
```

* **Acceso a las propiedades y métodos**: Una vez que tienes un objeto, puedes acceder a sus propiedades y métodos utilizando la notación de punto (`.`). Esto te permite manipular los datos internos y ejecutar su comportamiento.

* **Modificación del estado del objeto**: Los objetos pueden cambiar su estado durante su vida útil, es decir, puedes modificar las propiedades de los objetos a medida que interactúas con ellos.

* **Destrucción del objeto (Recolección de basura)**: En C#, la memoria utilizada por los objetos es gestionada automáticamente mediante el recolector de basura (**Garbage Collector**). Una vez que un objeto ya no tiene referencias activas, el recolector de basura lo elimina para liberar memoria.

## Cómo interactuar con objetos:
* **Declaración e inicialización**:

  * **Declaración**: Se declara una variable que apunta a un objeto de una clase.
  * Inicialización: Se usa el operador new para crear la instancia del objeto y llamar a su constructor.

  * **Ejemplo**:
```c#
// Declaración de un objeto
Persona persona1;

// Inicialización del objeto
persona1 = new Persona();
```

1. **Acceder a las propiedades del objeto**: Puedes asignar valores a las propiedades de un objeto o acceder a ellas usando el nombre del objeto seguido de un punto.

   * Ejemplo:
```c#
persona1.Nombre = "Juan";
persona1.Edad = 30;
```

2. **Llamar a métodos del objeto**: Los métodos de un objeto se invocan de manera similar a las propiedades, usando la notación de punto.

   * Ejemplo:
```c#
persona1.Saludar();
```

3. **Pasar objetos como parámetros a métodos**: Puedes pasar un objeto a otro método para que se manipule dentro de ese contexto.

   * Ejemplo:
```c#
public void MostrarInformacion(Persona persona)
{
    Console.WriteLine($"Nombre: {persona.Nombre}, Edad: {persona.Edad}");
}

public static void Main()
{
    Persona persona1 = new Persona();
    persona1.Nombre = "Ana";
    persona1.Edad = 28;
    
    MostrarInformacion(persona1);
}
```

4. **Creación de Objetos Complejos**: Los objetos pueden contener otros objetos dentro de ellos, lo que permite crear estructuras más complejas. Esto es útil para modelar relaciones más avanzadas.

   * Ejemplo:
```csharp
public class Producto
{
    public string Nombre { get; set; }
    public decimal Precio { get; set; }

    public Producto(string nombre, decimal precio)
    {
        Nombre = nombre;
        Precio = precio;
    }
}

public class Pedido
{
    public Producto Producto { get; set; }

    public Pedido(Producto producto)
    {
        Producto = producto;
    }

    public void MostrarPedido()
    {
        Console.WriteLine($"Pedido: {Producto.Nombre} - Precio: {Producto.Precio}");
    }
}

public class Program
{
    public static void Main()
    {
        Producto producto = new Producto("Laptop", 1500.00m);
        Pedido pedido = new Pedido(producto);

        pedido.MostrarPedido();
    }
}
```

## Ejemplo de Modificación de Objetos:
Los objetos tienen la capacidad de modificar su propio estado. En el siguiente ejemplo, modificamos los valores de las propiedades del objeto después de su creación.

```csharp
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    public void CumplirAños()
    {
        Edad++;
    }

    public void Saludar()
    {
        Console.WriteLine($"Hola, soy {Nombre} y tengo {Edad} años.");
    }
}

public class Program
{
    public static void Main()
    {
        Persona persona1 = new Persona();
        persona1.Nombre = "Carlos";
        persona1.Edad = 25;

        // Saluda
        persona1.Saludar();

        // Cumple años
        persona1.CumplirAños();

        // Vuelve a saludar
        persona1.Saludar();
    }
}
```