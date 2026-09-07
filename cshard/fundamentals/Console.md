# `Console`
La clase `Console` es parte del espacio de nombres `System` en C#. Es una clase estática que proporciona métodos para interactuar con la consola, permitiendo la entrada y salida de texto desde o hacia la consola.

## ¿Qué es?
`Console` es una clase estática que actúa como un puente entre la aplicación y la consola del sistema operativo. No se necesita instanciar la clase para usarla, ya que todos sus métodos son estáticos.

## ¿Para qué sirve?
Permite realizar **salidas** en la consola, como mostrar mensajes, resultados, y otros datos al usuario.Tambien permite realizar **entradas**, como leer datos ingresados por el usuario en la consola.

Es útil para:
* Prototipos de programas.
* Aplicaciones de línea de comandos.
* Depuración simple mostrando valores en tiempo de ejecución.

## ¿Qué resuelve?
La clase `Console` resuelve la necesidad de interactuar directamente con el usuario a través de un entorno de texto, como:

* Mostrar información.
* Recibir y procesar datos de entrada.
* Manejar errores mediante mensajes claros.
* Proveer un método sencillo y rápido de depurar programas.

## ¿Cómo lo resuelve?
A través de métodos específicos para **entrada/salida (`input/output`)** estándar de texto, como `WriteLine` para salida y `ReadLine` para entrada.

Ofrece control sobre:
* El flujo de salida estándar (`Console.Out`).
* El flujo de entrada estándar (`Console.In`).
* El flujo de error estándar (`Console.Error`).

## Métodos Principales de la Clase `Console`
### `Output` de datos
1. Mostrar datos en la consola
   * `Console.Write(string value)`: Escribe un texto en la consola sin añadir un salto de línea al final.
```csharp
Console.Write("Hola");
Console.Write(" Mundo");
// Salida: Hola Mundo (en la misma línea)
```

2. `Console.WriteLine(string value)`: Escribe un texto en la consola y añade un salto de línea al final.
```csharp
Console.WriteLine("Hola");
Console.WriteLine("Mundo");
// Salida:
// Hola
// Mundo
```

3. Uso de interpolación de cadenas con `WriteLine`:
```csharp
string nombre = "Juan";
int edad = 25;
Console.WriteLine($"Hola {nombre}, tienes {edad} años.");
```

### `input` de datos
1. `Console.ReadLine()`: Lee una línea completa de texto ingresada por el usuario.
```csharp
Console.WriteLine("Escribe tu nombre:");
string nombre = Console.ReadLine();
Console.WriteLine($"Hola, {nombre}!");
```

2. `Console.ReadKey()`: Lee una tecla presionada por el usuario sin necesidad de pulsar Enter.
```csharp
Console.WriteLine("Presiona cualquier tecla para continuar...");
Console.ReadKey();
```

### Cambiar el color de la consola
1. Puedes personalizar la apariencia de la consola para mejorar la experiencia del usuario: Cambiar el color del texto:
```csharp
Console.ForegroundColor = ConsoleColor.Green;
Console.WriteLine("Texto en color verde");
Console.ResetColor(); // Restablecer colores predeterminados
```

2. Cambiar el color del fondo:
```csharp
Console.BackgroundColor = ConsoleColor.Yellow;
Console.ForegroundColor = ConsoleColor.Red;
Console.WriteLine("Texto rojo con fondo amarillo");
Console.ResetColor(); // Restablecer colores predeterminados
```

### Limpieza y posicionamiento en la consola
1. `Console.Clear()`: Limpia todo el contenido de la consola.
```csharp
Console.Clear();
```

2. `Console.SetCursorPosition(int left, int top)`: Establece la posición del cursor en la consola.
```csharp
Console.SetCursorPosition(10, 5);
Console.WriteLine("Texto en posición específica");
```

### Manejo de errores
1. `Console.Error`: Permite escribir mensajes de error en un flujo de salida diferente al estándar.
```csharp
Console.Error.WriteLine("Ha ocurrido un error.");
```

### Leer caracteres individuales
1. `Console.Read()`: Lee el siguiente carácter del flujo de entrada.
```csharp
Console.WriteLine("Escribe algo:");
int ascii = Console.Read(); // Devuelve el código ASCII del carácter
Console.WriteLine($"Código ASCII: {ascii}");
```

## Consideraciones Avanzadas
1. **Redirección de Flujos**: Puedes redirigir la salida de la consola a un archivo o a otro flujo.
```csharp
using (var writer = new StreamWriter("salida.txt"))
{
    Console.SetOut(writer);
    Console.WriteLine("Este texto se guardará en un archivo.");
}
```

2. **Codificación**: Puedes cambiar la codificación de entrada/salida.
```csharp
Console.OutputEncoding = System.Text.Encoding.UTF8;
Console.WriteLine("Texto con caracteres especiales: á, é, í, ó, ú.");
```

3. **Detección de Teclas Sincrónica y Asincrónica**:
   * `ReadKey` permite detectar una tecla inmediatamente.
   * Puedes implementar funcionalidades interactivas más avanzadas con este método.