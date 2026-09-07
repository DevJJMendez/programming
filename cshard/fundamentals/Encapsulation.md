# Encapsulamiento
Es un principio que tiene como objetivo principal **ocultar los detalles internos de una clase y exponer solo lo que es necesario** para interactuar con ella de una manera segura y controlada. El encapsulamiento proporciona control sobre los datos y garantiza que los objetos solo se modifiquen de manera controlada.

## ¿Qué es el Encapsulamiento?
El encapsulamiento es el proceso de restringir el acceso directo a algunos de los componentes de un objeto y permitir que se accedan o modifiquen solo a través de métodos específicos. Esto implica:

* **Ocultar los datos**: Los datos o atributos de una clase (también conocidos como campos) no deben ser accesibles directamente desde fuera de la clase.

* **Exponer métodos públicos (`getters` y `setters`)**: En lugar de acceder directamente a los atributos, los usuarios de la clase deben utilizar métodos para obtener o modificar el estado de esos atributos.

En términos más simples, el encapsulamiento proporciona "**protección**" a los datos y garantiza que no se puedan modificar de manera inapropiada.

## ¿Para qué sirve el Encapsulamiento?
* **Controlar el acceso a los datos**: Al encapsular los datos, puedes asegurarte de que solo se puedan modificar de manera controlada y bajo ciertas condiciones.

* **Ocultar la complejidad interna**: Los usuarios de la clase no necesitan saber cómo está implementada internamente. Solo necesitan interactuar con la interfaz pública proporcionada.

* **Mejorar la seguridad**: Al restringir el acceso directo a los datos, reduces el riesgo de que se modifiquen incorrectamente o de que los usuarios de la clase no autorizados puedan alterar el estado de un objeto.

* **Facilitar el mantenimiento y modificación del código**: Si los detalles internos de la clase cambian, los usuarios de la clase no se ven afectados, ya que interactúan solo con los métodos públicos. Esto hace que el código sea más fácil de modificar y mantener.

## ¿Qué resuelve el Encapsulamiento?
* **Acceso no autorizado a datos sensibles**: Evita que los datos de la clase sean modificados directamente sin las validaciones adecuadas. Esto ayuda a mantener la integridad del estado del objeto.

* **Dependencias externas no controladas**: Evita que otras clases o componentes del sistema dependan directamente de los detalles internos de una clase, lo que mejora la modularidad.

* **Modificaciones indeseadas**: Al restringir cómo y desde dónde se pueden modificar los datos, puedes garantizar que solo se realicen cambios válidos y esperados.

* **Exposición innecesaria de la implementación**: Al ocultar los detalles internos, reduces la complejidad de cómo los usuarios interactúan con tu clase. Esto hace que tu código sea más fácil de usar y menos propenso a errores.

## ¿Cómo lo resuelve?
El encapsulamiento se resuelve mediante el uso de modificadores de acceso (**access modifiers**) y **propiedades** en C#. Los modificadores de acceso controlan qué miembros de la clase (campos, métodos, propiedades) son accesibles desde fuera de la clase.

* **Modificadores de acceso más comunes en C#**:
  * `private`: Los miembros private solo pueden ser accedidos dentro de la propia clase.

  * `public`: Los miembros public son accesibles desde cualquier parte del programa.

  * `protected`: Los miembros protected son accesibles dentro de la propia clase y en clases que hereden de ella.

  * `internal`: Los miembros internal son accesibles dentro del mismo ensamblado (proyecto).

  * `protected internal`: Combinación de protected e internal, accesible en clases del mismo ensamblado o clases derivadas fuera de él.

## Uso de Getters y Setters
En lugar de acceder directamente a los campos (atributos) de una clase, se utilizan propiedades en C# para controlarlos. Estas propiedades sirven como accesores (getters) y mutadores (setters).

* **`Getter`**: Método que permite obtener el valor de un atributo.
* **`Setter`**: Método que permite modificar el valor de un atributo.

Ejemplo de Encapsulamiento en C#:
```csharp
using System;

public class Persona
{
    // Campo privado (no accesible directamente desde fuera de la clase)
    private string nombre;

    // Propiedad pública (con getter y setter)
    public string Nombre
    {
        get { return nombre; }  // Getter
        set { 
            if (!string.IsNullOrWhiteSpace(value))
            {
                nombre = value;  // Setter
            }
            else
            {
                throw new ArgumentException("El nombre no puede ser vacío");
            }
        }
    }

    // Constructor
    public Persona(string nombre)
    {
        Nombre = nombre;  // Se usa el setter para asignar el nombre
    }
}

public class Program
{
    public static void Main()
    {
        Persona persona = new Persona("Juan");

        // Acceso controlado al campo "nombre" a través de la propiedad "Nombre"
        Console.WriteLine(persona.Nombre);  // Output: Juan

        // Modificación del nombre a través del setter
        persona.Nombre = "Carlos";
        Console.WriteLine(persona.Nombre);  // Output: Carlos

        // Intentando asignar un valor inválido
        try
        {
            persona.Nombre = "";  // Esto lanzará una excepción
        }
        catch (ArgumentException ex)
        {
            Console.WriteLine(ex.Message);  // Output: El nombre no puede ser vacío
        }
    }
}
```
* **Explicación del Ejemplo:**
  * El campo `nombre` es privado (`private`), lo que significa que no puede ser accedido directamente desde fuera de la clase `Persona`.

  * La propiedad `Nombre` se usa para acceder y modificar el campo `nombre` de manera controlada. Tiene un `getter` para obtener el valor y un `setter` para modificarlo. En este caso, el `setter` verifica si el valor ingresado es válido antes de asignarlo.

  * Si intentas asignar un valor no válido (como una cadena vacía), el `setter` lanza una excepción para evitar la asignación de un valor incorrecto.

  * El encapsulamiento asegura que el campo `nombre` siempre se mantenga en un estado válido y que su acceso esté controlado.

## Ventajas del Encapsulamiento:
* **Protección de datos**: Los datos importantes de un objeto están protegidos del acceso directo, lo que garantiza su integridad.

* **Fácil mantenimiento**: Puedes cambiar la implementación interna de la clase sin afectar a otras clases que interactúan con ella, siempre que la interfaz pública (como las propiedades y métodos) se mantenga igual.

* **Flexibilidad**: Puedes agregar lógica a los métodos `get` y `set` (como validaciones o cálculos adicionales) sin cambiar la forma en que los usuarios interactúan con la clase.

* **Mejor control**: Permite un control más preciso sobre cómo se accede a los datos y cómo se modifican.

## Consideraciones a tener en cuenta:
* **No usar `public` en los campos**: Evita hacer los campos de una clase públicos; en su lugar, usa propiedades para asegurar un control adecuado.

* **Cuando usar `getter` y `setter`**: Si necesitas lógica adicional para obtener o establecer un valor (como validaciones o transformaciones), utiliza un getter y un setter en lugar de acceder directamente al campo.