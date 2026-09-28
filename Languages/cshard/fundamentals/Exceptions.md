# Excepciones
Las excepciones en C# son eventos inesperados o errores que ocurren durante la ejecución de un programa y que interrumpen su flujo normal. Estas se utilizan para manejar de forma controlada situaciones que podrían causar fallos, como divisiones por cero, accesos a índices fuera de rango, o conexiones fallidas a bases de datos.

En términos técnicos, una excepción es un objeto de la clase base `System.Exception` o una de sus clases derivadas.

## ¿Para qué sirven las excepciones?
* **Manejo de errores en tiempo de ejecución**: Permiten capturar y procesar errores sin que el programa se detenga abruptamente.

* **Diagnóstico de problemas**: Proveen información detallada del error, como mensajes, pila de llamadas y el tipo de excepción.

* **Flujo controlado**: Facilitan el manejo ordenado de errores mediante bloques de código específicos.

## ¿Qué resuelven las excepciones?
Las excepciones resuelven problemas asociados con:

* **Errores inesperados**: Como acceso a índices fuera de rango, división por cero, o conversiones inválidas de datos.

* **Validación de datos**: Aseguran que las entradas del programa cumplan con ciertos requisitos.

* **Recursos no disponibles**: Por ejemplo, fallos al acceder a archivos, redes o bases de datos.

* **Evitar caídas abruptas del programa**: Permiten capturar errores y reaccionar de forma controlada, mejorando la experiencia del usuario y la estabilidad de la aplicación.

## ¿Cómo lo resuelven las excepciones?
* **Mecanismo de manejo de errores**: Utilizan bloques de código específicos (try, catch, finally) para capturar y procesar errores.

* **Propagación jerárquica**: Si una excepción no se maneja en un nivel, se propaga hacia los niveles superiores hasta que sea capturada o el programa termine.

* **Mensajes detallados**: La excepción proporciona información clara sobre qué salió mal y dónde ocurrió.

## Estructura básica de manejo de excepciones
Sintaxis
```c#
try {
    // Código que puede lanzar una excepción
} 
catch (TipoDeExcepcion ex) {
    // Código para manejar la excepción
} 
finally {
    // Código que siempre se ejecuta (opcional)
}
```

## Ejemplo básico de manejo de excepciones
1. División por cero
```c#
class Program {
    static void Main(string[] args) {
        try {
            int numerador = 10;
            int denominador = 0;
            int resultado = numerador / denominador;
            Console.WriteLine($"Resultado: {resultado}");
        } 
        catch (DivideByZeroException ex) {
            Console.WriteLine($"Error: {ex.Message}");
        } 
        finally {
            Console.WriteLine("Operación finalizada.");
        }
    }
}
```
**Salida**
```bash
Error: Attempted to divide by zero.
Operación finalizada.
```

## Jerarquía de excepciones
En C#, todas las excepciones derivan de la clase base `System.Exception`. Puedes manejar excepciones específicas o generales dependiendo de tus necesidades.

Ejemplo de múltiples bloques `catch`:
```c#
try {
    // Código que puede lanzar varias excepciones
} 
catch (FormatException ex) {
    Console.WriteLine("Formato incorrecto.");
} 
catch (DivideByZeroException ex) {
    Console.WriteLine("Intento de división por cero.");
} 
catch (Exception ex) {
    Console.WriteLine($"Error desconocido: {ex.Message}");
}
```

## Cómo lanzar excepciones
Puedes lanzar tus propias excepciones usando la palabra clave throw:

Ejemplo: Lanzar una excepción personalizada
```c#
class Program {
    static void Main(string[] args) {
        try {
            ValidarEdad(-5);
        } 
        catch (ArgumentException ex) {
            Console.WriteLine($"Error: {ex.Message}");
        }
    }

    static void ValidarEdad(int edad) {
        if (edad < 0) {
            throw new ArgumentException("La edad no puede ser negativa.");
        }
    }
}
```
**Salida**
```bash
Error: La edad no puede ser negativa.
```

## Propiedades importantes de las excepciones
* `Message`: Describe el error.

* `StackTrace`: Proporciona una traza del error (dónde ocurrió).

* `InnerException`: Contiene excepciones anidadas (útil para rastrear errores internos).

```c#
try {
    throw new InvalidOperationException("Operación inválida.");
} 
catch (Exception ex) {
    Console.WriteLine($"Error: {ex.Message}");
    Console.WriteLine($"Traza: {ex.StackTrace}");
}
```

# Excepciones Personalizadas
En C#, las excepciones personalizadas son clases que se crean para representar errores o condiciones especiales que no son cubiertas por las excepciones estándar del lenguaje. Aunque C# proporciona un conjunto completo de excepciones predefinidas, en muchos casos es útil definir excepciones propias para representar situaciones de error específicas en el contexto de una aplicación.

## ¿Qué son las Excepciones Personalizadas?
Las excepciones personalizadas son clases que heredan de la clase base `Exception` (o una de sus subclases). Permiten capturar errores más específicos y proporcionar mensajes detallados sobre lo que salió mal en la aplicación, lo que facilita el manejo de errores y la depuración.

## ¿Por qué crear Excepciones Personalizadas?
* **Claridad y Semántica**: Las excepciones personalizadas te permiten definir errores más precisos y específicos, lo que hace que el código sea más fácil de entender. Por ejemplo, puedes tener excepciones como `ProductoNoDisponibleException` o `CuentaNoValidaException`, que son más descriptivas que una genérica `InvalidOperationException`.

* **Manejo de Errores Más Detallado**: Las excepciones personalizadas permiten manejar ciertos tipos de errores de manera específica, sin tener que capturar excepciones genéricas. Esto mejora la calidad del código, ya que puedes manejar diferentes tipos de excepciones de forma independiente.

* **Rastreo Mejorado**: Al incluir propiedades personalizadas en la excepción (como un código de error o el nombre de un usuario), puedes proporcionar más contexto al usuario final o al equipo de desarrollo.

## ¿Qué resuelven las Excepciones Personalizadas?
* **Errores específicos**: En lugar de capturar una excepción genérica, puedes capturar una excepción que tenga un significado específico en tu aplicación.

* **Manejo de errores más controlado**: Puedes usar excepciones personalizadas para hacer que tu aplicación sea más robusta, porque puedes anticipar y manejar distintos tipos de errores de manera más precisa.

* **Mejor trazabilidad**: Puedes incluir detalles adicionales en las excepciones personalizadas, como códigos de error o estados internos, que te ayuden a rastrear la causa del error de manera más eficaz.

## ¿Cómo crear Excepciones Personalizadas en C#?
Para crear una excepción personalizada en C#, debes seguir estos pasos:

1. **Crear una clase que herede de `Exception`**:
   * La clase personalizada debe heredar de la clase base **`Exception`** o de alguna de sus subclases (como `ApplicationException` o `SystemException`).

2. **Incluir constructores**:
   * Es común que las excepciones personalizadas incluyan varios constructores para facilitar su creación, proporcionando diferentes niveles de detalle.

3. **Agregar propiedades adicionales (opcional)**:
   * Puedes agregar propiedades personalizadas para incluir información adicional sobre el error, como códigos de error, nombres de usuario, etc.

### Ejemplo básico de una Excepción Personalizada
Supongamos que estás trabajando en una aplicación de banca y deseas crear una excepción personalizada llamada `SaldoInsuficienteException` para indicar que una transacción no se puede completar debido a un saldo insuficiente.

```csharp
using System;

public class SaldoInsuficienteException : Exception
{
    // Propiedad adicional para incluir el saldo restante
    public decimal SaldoRestante { get; }

    // Constructor por defecto
    public SaldoInsuficienteException() 
        : base("Saldo insuficiente para completar la transacción.") 
    { 
    }

    // Constructor con mensaje personalizado
    public SaldoInsuficienteException(string mensaje) 
        : base(mensaje) 
    { 
    }

    // Constructor con el saldo restante
    public SaldoInsuficienteException(decimal saldoRestante)
        : base($"Saldo insuficiente. El saldo restante es: {saldoRestante}")
    {
        SaldoRestante = saldoRestante;
    }

    // Constructor con mensaje y una excepción interna
    public SaldoInsuficienteException(string mensaje, Exception innerException) 
        : base(mensaje, innerException) 
    { 
    }
}
```
1. **Herencia de `Exception`**:
   * `SaldoInsuficienteException` hereda de `Exception`, lo que le permite comportarse como cualquier otra excepción en C#.

2. **Constructores**:
   * Se proporcionan varios constructores para cubrir diferentes casos: un constructor por defecto, un constructor que permite pasar un mensaje personalizado y uno que recibe el saldo restante como parámetro para proporcionar más contexto sobre el error.

3. **Propiedad personalizada (`SaldoRestante`)**:
   * `SaldoRestante` es una propiedad adicional que se incluye en la excepción, proporcionando información adicional útil para el manejo del error.

* **Uso de la Excepción Personalizada**
  * Una vez que has creado la excepción personalizada, puedes usarla en tu código de la siguiente manera:

```csharp
public class CuentaBancaria
{
    public decimal Saldo { get; set; }

    public void Retirar(decimal cantidad)
    {
        if (cantidad > Saldo)
        {
            // Lanza la excepción personalizada
            throw new SaldoInsuficienteException(Saldo);
        }

        Saldo -= cantidad;
    }
}
```

* Manejo de la Excepción Personalizada
  * El bloque de manejo de excepciones (try-catch) se utiliza para capturar y manejar la excepción personalizada:

```csharp
public class Program
{
    public static void Main()
    {
        CuentaBancaria cuenta = new CuentaBancaria { Saldo = 100m };

        try
        {
            cuenta.Retirar(200m);
        }
        catch (SaldoInsuficienteException ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
            Console.WriteLine($"Saldo restante: {ex.SaldoRestante}");
        }
    }
}
```

## Consideraciones al Crear Excepciones Personalizadas
1. **No crear excepciones sin necesidad**:
   * Solo crea excepciones personalizadas cuando haya un escenario específico que no esté cubierto por las excepciones estándar de C#. Si el tipo de error puede ser manejado por una excepción estándar, no es necesario crear una excepción personalizada.

2. **Incluir constructores adecuados**:
   * Asegúrate de que tu excepción personalizada tenga constructores adecuados. Los constructores más comunes incluyen:
     * Constructor vacío.

     * Constructor que recibe un mensaje.

     * Constructor que recibe un mensaje y una excepción interna.

3. **Documentación**:
   * Es importante documentar las excepciones personalizadas para que los desarrolladores que usen tu código entiendan cuándo y cómo deben manejarlas.

4. **Mantener la jerarquía de excepciones**:
   * Si tienes excepciones personalizadas, asegúrate de que sigan una jerarquía lógica. Por ejemplo, podrías tener una excepción base llamada `BancoException` y luego derivar excepciones más específicas como `SaldoInsuficienteException`.