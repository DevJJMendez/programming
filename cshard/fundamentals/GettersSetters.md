#Classes
# Getters y Setters en C#
Los Getters y Setters son mecanismos fundamentales para controlar el acceso a las propiedades de una clase en la Programación Orientada a Objetos (OOP). En C#, estos son implementados a través de propiedades (**`Properties`**), aunque el concepto de `getter` y `setter` en otros lenguajes de programación, como Java, es más explícito. En C#, aunque a menudo no usamos métodos explícitos llamados `get` y `set`, estos métodos son, en efecto, las partes de la propiedad que permiten obtener y establecer valores.

* **Getter**: Es un método que permite acceder al valor de una propiedad o campo de una clase. En C#, esto corresponde al bloque get de una propiedad.

* **Setter**: Es un método que permite establecer el valor de una propiedad o campo de una clase. En C#, esto corresponde al bloque set de una propiedad.

En lugar de acceder directamente a los campos (**`fields`**), se utiliza el **getter** y **setter** para encapsular el acceso a los datos. Esto proporciona control sobre cómo se accede y modifica el estado de un objeto.

## Sintaxis de Getter y Setter en C#:
En C#, no necesitas definir métodos explícitos de **getter** y **setter** como en otros lenguajes (Java, C++), porque las propiedades ya actúan como tales.

```c#
public class Persona
{
    private string _nombre;  // Field privado

    // Propiedad con Getter y Setter
    public string Nombre
    {
        get { return _nombre; }  // Getter
        set { _nombre = value; } // Setter
    }
}
```
Aquí, `Nombre` es una propiedad de la clase `Persona`. El **getter** devuelve el valor del campo privado `_nombre`, mientras que el **setter** asigna un nuevo valor al campo `_nombre`.

## ¿Para qué sirven los Getters y Setters?
* **Encapsulación de datos**: Los **getters** y **setters** ayudan a encapsular los datos de una clase. En lugar de exponer directamente los campos de la clase, se usan estos métodos para controlar cómo se accede y se modifica la información.

* **Control de acceso**: Permiten agregar lógica en el acceso y la modificación de las propiedades. Esto es útil para validaciones, restricciones, o incluso realizar otras acciones cuando se obtiene o establece un valor.

* **Mantenimiento**: Cuando se necesita cambiar la lógica interna de una clase (como cambiar la forma en que se calcula un valor), puedes hacerlo sin afectar el código que usa la clase, siempre y cuando mantengas la misma interfaz pública (es decir, la propiedad).

* **Notificación de cambios**: A través de los **setters**, se pueden realizar acciones cuando el valor de una propiedad cambia, como enviar una notificación, actualizar el estado de otro componente o registrar el cambio.

## ¿Qué resuelven los Getters y Setters?
* **Acceso controlado a datos**: Sin los **getters** y **setters**, los campos de una clase serían accesibles directamente, lo que dificultaría la implementación de restricciones o validaciones. Los getters y setters permiten definir cómo y cuándo se pueden modificar los datos.

* **Validación de datos**: Puedes usar un **setter** para validar que el valor que se intenta asignar a una propiedad sea adecuado, evitando así la asignación de valores incorrectos o inválidos.

* **Protección de datos internos**: Permiten ocultar la implementación interna de la clase, haciendo que el acceso a los datos se haga de manera segura y controlada. Esto es un pilar fundamental de la encapsulación.

* **Manejo de lógica adicional**: Permiten la inclusión de lógica adicional cuando se obtienen o asignan valores, como realizar cálculos, manipular los datos antes de devolverlos o realizar una acción secundaria.

## ¿Cómo lo resuelven los Getters y Setters?
En C#, los **getters** y **setters** se resuelven mediante propiedades. Cuando defines una propiedad, el getter se encarga de devolver el valor de un campo y el setter se encarga de modificar ese valor, a menudo con controles adicionales.

Sintaxis Completa de una Propiedad:
```c#
public class Persona
{
    private string _nombre;

    // Propiedad con getter y setter
    public string Nombre
    {
        get
        {
            return _nombre;
        }
        set
        {
            if (string.IsNullOrWhiteSpace(value))
                throw new ArgumentException("El nombre no puede estar vacío.");
            _nombre = value;
        }
    }
}
```
En este ejemplo, la propiedad `Nombre` tiene tanto un **getter** como un **setter**. El **getter** simplemente devuelve el valor del campo privado `_nombre`, mientras que el **setter** incluye una validación para asegurarse de que el valor no esté vacío antes de asignarlo.

## Ejemplo con Getter y Setter Simplificado (Propiedad Auto-Implementada)
C# también ofrece una forma más sencilla de declarar propiedades sin la necesidad de definir explícitamente el campo privado y los métodos **get** y **set**. Este es el caso de las propiedades auto-implementadas.
```c#
public class Persona
{
    public string Nombre { get; set; }  // Propiedad auto-implementada
}
```
En este caso, C# crea automáticamente un campo privado detrás de la propiedad para almacenar el valor. El get y set son generados implícitamente.

## Tipos de Getters y Setters
En C#, los getters y setters pueden variar en su comportamiento dependiendo de los siguientes casos:

1. **Propiedades con solo `get` (solo lectura):**
   * Puedes tener propiedades de solo lectura que no permiten modificar el valor directamente.

   * Usadas cuando se desea que el valor sea calculado internamente, pero no se debe permitir que los usuarios cambien el valor.
```csharp
public class Persona
{
    private string _nombre;

    public string Nombre
    {
        get { return _nombre; }
    }

    public Persona(string nombre)
    {
        _nombre = nombre;
    }
}
```

2. **Propiedades con solo `set` (solo escritura)**:
   * Puedes tener propiedades de solo escritura, que permiten modificar el valor, pero no acceder a él directamente.

```csharp
public class Persona
{
    private string _nombre;

    public string Nombre
    {
        set { _nombre = value; }
    }
}
```

3. **Propiedades automáticas con validación**:
   * Se pueden usar validaciones dentro del **setter** de propiedades automáticas, agregando lógica al **setter** sin necesidad de definir un campo explícito.

```csharp
public class Persona
{
    private string _nombre;

    public string Nombre
    {
        get => _nombre;
        set
        {
            if (string.IsNullOrWhiteSpace(value))
                throw new ArgumentException("El nombre no puede estar vacío.");
            _nombre = value;
        }
    }
}
```
## Ventajas de Usar Getters y Setters
* **Encapsulación**: Te permite ocultar los detalles internos y exponer solo lo necesario.

* **Flexibilidad**: Te permite cambiar la implementación interna sin afectar al usuario de la clase.

* **Control**: Puedes agregar lógica de validación, transformación de datos o notificación de cambios dentro de los getters y setters.