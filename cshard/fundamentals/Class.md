#OPP
#Classes
# Clases
En C#, una clase es un tipo de dato definido por el usuario que actúa como una plantilla o blueprint para crear objetos. Las clases encapsulan datos (atributos o propiedades) y comportamientos (métodos o funciones) en un solo lugar.

Las clases permiten modelar entidades del mundo real o conceptualizar soluciones a problemas mediante la creación de estructuras reutilizables y escalables.

## ¿Para qué sirven las clases?
Las clases sirven para:

* **Definir estructuras de datos complejas**: Permiten agrupar datos relacionados y comportamientos en una única unidad lógica.

* **Encapsular lógica y comportamiento**: Puedes ocultar detalles de implementación interna y exponer solo lo necesario mediante modificadores de acceso.

* **Reutilizar código**: A través de la herencia, puedes crear nuevas clases basadas en clases existentes.

* **Modelar entidades del mundo real**: Facilitan la representación de objetos y relaciones entre ellos en un programa.

## ¿Qué resuelven las clases?
* **Modularidad y organización**: Permiten dividir un programa en pequeñas partes manejables, cada una responsable de un aspecto específico.

* **Reutilización y mantenimiento**: Reducen la duplicación de código mediante herencia y composición.

* **Complejidad**: Al abstraer detalles internos, simplifican la interacción con sistemas complejos.

* **Escalabilidad**: Proveen una base sólida para desarrollar aplicaciones extensibles.

## ¿Cómo lo resuelven?
* **Agrupando datos y comportamientos**: Las propiedades almacenan datos, y los métodos definen cómo interactuar con esos datos.

* **Aplicando principios de `OOP`**: Las clases implementan conceptos como:

  * **Encapsulación**: Ocultan detalles internos.
  
  * Herencia: Reutilizan comportamiento.
  
  * Polimorfismo: Permiten diferentes implementaciones para una misma interfaz.
  
  * Abstracción: Modelan solo lo necesario.

* **Definiendo plantillas reutilizables**: Una vez definida una clase, puedes instanciarla múltiples veces para crear objetos que compartan las mismas características y comportamientos.

## Elementos Clave de una Clase
1. **Propiedades (Atributos)**: Son variables que definen las características o el estado de un objeto.
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }
}
```

2. **Métodos**: Son funciones definidas dentro de una clase que operan sobre las propiedades de esa clase.
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    public void Saludar()
    {
        Console.WriteLine($"Hola, mi nombre es {Nombre} y tengo {Edad} años.");
    }
}
```

3. **Constructores**: Son métodos especiales utilizados para inicializar un objeto. En C#, el constructor tiene el mismo nombre que la clase.
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    // Constructor
    public Persona(string nombre, int edad)
    {
        Nombre = nombre;
        Edad = edad;
    }

    public void Saludar()
    {
        Console.WriteLine($"Hola, mi nombre es {Nombre} y tengo {Edad} años.");
    }
}
```

4. **Modificadores de Acceso**: Definen quién puede acceder a los miembros de la clase (por ejemplo, `public`, `private`, etc.).
```c#
public class Persona
{
    private string Nombre { get; set; }
    public int Edad { get; set; }

    public void AsignarNombre(string nombre)
    {
        Nombre = nombre;
    }

    public void MostrarNombre()
    {
        Console.WriteLine($"Nombre: {Nombre}");
    }
}
```

5. **Herencia**: Permite que una clase derive de otra para reutilizar sus propiedades y métodos.
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    public void Saludar()
    {
        Console.WriteLine($"Hola, mi nombre es {Nombre}.");
    }
}

public class Estudiante : Persona
{
    public string Universidad { get; set; }

    public void MostrarUniversidad()
    {
        Console.WriteLine($"Estudio en {Universidad}.");
    }
}
```

6. **Polimorfismo**: Permite sobrescribir métodos en clases derivadas.
```c#
public class Persona
{
    public virtual void Saludar()
    {
        Console.WriteLine("Hola, soy una persona.");
    }
}

public class Estudiante : Persona
{
    public override void Saludar()
    {
        Console.WriteLine("Hola, soy un estudiante.");
    }
}
```

## ¿Cómo crear una clase?
1. Define la clase con la palabra clave `class`.

2. Declara los atributos y métodos.

3. Usa instancias (objetos) para interactuar con la clase.

Ejemplo Básico:
```csharp
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
        Persona persona = new Persona();
        persona.Nombre = "Juan";
        persona.Edad = 25;
        persona.Saludar();
    }
}
```

### Ejemplo Completo: Modelando un Sistema Real
* Escenario: Una tienda de ecommerce con clases para productos, clientes y pedidos.
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

    public void MostrarInformacion()
    {
        Console.WriteLine($"Producto: {Nombre}, Precio: ${Precio}");
    }
}

public class Cliente
{
    public string Nombre { get; set; }
    public string CorreoElectronico { get; set; }

    public Cliente(string nombre, string correo)
    {
        Nombre = nombre;
        CorreoElectronico = correo;
    }

    public void MostrarInformacion()
    {
        Console.WriteLine($"Cliente: {Nombre}, Email: {CorreoElectronico}");
    }
}

public class Pedido
{
    public Cliente Cliente { get; set; }
    public List<Producto> Productos { get; set; }

    public Pedido(Cliente cliente)
    {
        Cliente = cliente;
        Productos = new List<Producto>();
    }

    public void AgregarProducto(Producto producto)
    {
        Productos.Add(producto);
    }

    public void MostrarPedido()
    {
        Console.WriteLine($"Pedido de {Cliente.Nombre}:");
        foreach (var producto in Productos)
        {
            producto.MostrarInformacion();
        }
    }
}

public class Program
{
    public static void Main()
    {
        Cliente cliente = new Cliente("Ana Pérez", "ana.perez@gmail.com");
        Producto producto1 = new Producto("Laptop", 1500.00m);
        Producto producto2 = new Producto("Mouse", 25.00m);

        Pedido pedido = new Pedido(cliente);
        pedido.AgregarProducto(producto1);
        pedido.AgregarProducto(producto2);

        pedido.MostrarPedido();
    }
}
```

# Diferencias entre Field y Property en C#
En C#, tanto los **Fields (campos)** como las **Properties (propiedades)** son miembros de una clase, pero tienen propósitos y comportamientos distintos.

## Fields
Un Field (campo) es una variable declarada directamente dentro de una clase o estructura. Los Fields generalmente almacenan datos o valores relacionados con el objeto o la clase. Los Fields no tienen la capacidad de control de acceso por sí mismos, aunque puedes controlar el acceso a ellos utilizando modificadores como `private`, `public`, etc.

* **Sintaxis**
```c#
public class Persona
{
    public string Nombre; // Field
    private int Edad; // Field privado
}
```

### Características de los Fields:
* Se definen directamente dentro de la clase.

* Tienen un tipo de datos que puede ser cualquier tipo válido en C# (tipos primitivos, clases, estructuras, etc.).

* Se accede a ellos directamente sin ningún tipo de control adicional (a menos que utilices métodos para manipularlos).
Pueden ser públicos o privados, dependiendo de la necesidad de encapsulación.

## ¿Para qué sirven los Fields?
Se utilizan para almacenar el estado o los datos internos de una clase.
Son útiles cuando no necesitas ningún tipo de validación o control de acceso especial para manipular los datos.

```c#
public class Persona
{
    public string Nombre;  // Field público
    private int Edad;      // Field privado

    public Persona(string nombre, int edad)
    {
        Nombre = nombre;
        Edad = edad;
    }
}
```
En este ejemplo, `Nombre` es un campo público, mientras que `Edad` es un campo privado, lo que significa que solo puede ser accedido desde dentro de la clase Persona.

## Property
Una Property (propiedad) en C# es una forma controlada de acceder a los Fields de una clase. Las propiedades permiten aplicar lógica adicional al obtener o establecer un valor, como validación o notificación de cambios. Las Properties se definen con la palabra clave `get` y `set` que permiten leer y escribir los valores.

* Sintaxis
```c#
public class Persona
{
    private string _nombre;  // Field privado

    public string Nombre    // Property
    {
        get { return _nombre; }
        set { _nombre = value; }
    }
}
```

### Características de las Properties:
* Las propiedades proporcionan un método de acceso controlado (a través de los métodos `get` y `set`).

* A menudo, las propiedades se usan para acceder a los Fields privados, protegiéndolos de accesos directos.

* Pueden incluir lógica adicional en los accesores `get` y set para manipular o validar los datos.

* La mayoría de las propiedades siguen el patrón encapsulación, que es uno de los pilares de la Programación Orientada a Objetos.

### ¿Para qué sirven las Properties?
* Se utilizan cuando se necesita controlar el acceso a los campos de la clase, como la validación de datos antes de asignarlos o realizar una acción cada vez que se obtiene o se establece un valor.

* Se usan para aplicar la encapsulación y proteger los Fields internos, manteniendo la flexibilidad de manipular datos de manera controlada.

Ejemplo de Property:
```c#
public class Persona
{
    private string _nombre;  // Field privado

    public string Nombre    // Property
    {
        get { return _nombre; }
        set 
        {
            if (value.Length > 0)  // Validación
                _nombre = value;
            else
                throw new ArgumentException("El nombre no puede estar vacío.");
        }
    }
}
```
### Diferencias Principales entre Field y Property
| Característica          | Field                                                                                                                                                                        | Property                                                                                                                |
| ----------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| Acceso Directo          | Acceso directo, no necesita un método get o set.                                                                                                                             | Acceso indirecto, usa métodos get y set para obtener o asignar valores.                                                 |
| Encapsulación           | No proporciona encapsulación de forma predeterminada.                                                                                                                        | Proporciona encapsulación al controlar el acceso mediante get y set.                                                    |
| Control de acceso       | No hay control adicional; los campos son simplemente datos.	Permite controlar el comportamiento cuando se obtiene o se asigna un valor (validaciones, acciones adicionales). |                                                                                                                         |
| Lógica adicional        | No puede tener lógica adicional al ser accedido.                                                                                                                             | Se puede agregar lógica a través de los métodos get y set.                                                              |
| Modificadores de acceso | Los campos pueden ser públicos o privados, pero no tienen control adicional sobre su acceso.                                                                                 | Las propiedades son generalmente públicas, pero pueden controlar el acceso con diferentes modificadores para get y set. |
| Uso común               | Se usa principalmente para almacenar datos.                                                                                                                                  | Se usa para proporcionar una forma controlada y flexible de acceder y modificar los datos de la clase.                  |
| Acceso en otras clases  | Si un campo es público, se puede acceder directamente desde fuera de la clase.                                                                                               | Se usa para controlar el acceso desde fuera de la clase, incluso si el campo subyacente es privado.                     |
### Cuándo Usar un Field y Cuándo Usar una Property
* **Usar Fields**:
  * Para almacenar valores simples o datos internos.
  * Cuando no se necesita lógica adicional o validación al acceder o asignar un valor.
  * Cuando la clase es sencilla y no requiere control sobre el acceso o modificación de sus miembros.

* **Usar Properties**:
  * Para garantizar la encapsulación y proteger los datos.
  * Cuando necesitas aplicar validación, restricciones o acciones adicionales al obtener o establecer valores.
  * Cuando se requiere acceso controlado a los campos internos, incluso si el valor es privado.

### Ejemplo Comparativo: Field vs Property
* Ejemplo con Field:
```csharp
public class Persona
{
    public string Nombre;  // Field público
    private int _edad;     // Field privado

    public Persona(string nombre, int edad)
    {
        Nombre = nombre;
        _edad = edad;
    }
}
```
* Ejemplo con Property:
```csharp
public class Persona
{
    private string _nombre;  // Field privado

    public string Nombre    // Property
    {
        get { return _nombre; }
        set 
        {
            if (value.Length > 0)
                _nombre = value;
            else
                throw new ArgumentException("El nombre no puede estar vacío.");
        }
    }

    private int _edad;      // Field privado

    public int Edad         // Property
    {
        get { return _edad; }
        set 
        {
            if (value >= 0)
                _edad = value;
            else
                throw new ArgumentException("La edad no puede ser negativa.");
        }
    }

    public Persona(string nombre, int edad)
    {
        Nombre = nombre;
        Edad = edad;
    }
}
```
En este ejemplo, `Nombre` y `Edad` son propiedades que incluyen validación para asegurar que los valores sean correctos antes de ser asignados a los Fields internos.


---
[](Objects.md)