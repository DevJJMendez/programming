# Casting
El casting es el **proceso de convertir un tipo de datos en otro**. En C#, este proceso se utiliza para transformar valores entre tipos compatibles (como de int a float) o incluso entre tipos más complejos (como objetos de una jerarquía de clases).

Existen dos tipos principales de casting:
* **Casting implícito**: Cuando la conversión es segura y no existe pérdida de datos.

* **Casting explícito**: Cuando el programador fuerza la conversión, generalmente con la posibilidad de pérdida de datos o errores.

## ¿Para qué sirve?
El casting es esencial para:

* **Convertir tipos de datos** cuando trabajas con diferentes estructuras, como enteros, decimales, cadenas, etc.

* **Manipular objetos** en jerarquías de clases (por ejemplo, cuando usas herencia).

* Garantizar que los datos sean del tipo adecuado para realizar operaciones específicas.

## ¿Qué resuelve?
El casting resuelve problemas relacionados con:

* **Compatibilidad de tipos**: Permite operar entre tipos diferentes (por ejemplo, sumar un entero con un flotante).

* **Reutilización de código**: Trabajar con clases base y derivadas sin duplicar lógica.

* **Interoperabilidad**: Facilita la interacción entre APIs o bibliotecas que usan diferentes tipos.

## ¿Cómo lo resuelve?
El casting utiliza conversiones implícitas o explícitas según las necesidades del programador:

* **Implícitamente**: Cuando el compilador puede garantizar que no habrá pérdida de datos.

* **Explícitamente**: Cuando el programador asume la responsabilidad de garantizar que la conversión es válida.

## Tipos de Casting en C#:
1. **Casting Implícito**:  Se realiza automáticamente cuando no hay riesgo de pérdida de datos y los tipos son compatibles.

   * Ejemplo:
```csharp
int entero = 10;
double decimalValue = entero; // Conversión implícita de int a double
Console.WriteLine(decimalValue); // Salida: 10.0
```
   * Compatible con:
     * De tipos más pequeños a más grandes (`int` a `long`, `float` a `double`).
     * Cuando el compilador puede garantizar seguridad.

1. **Casting Explícito**: Requiere la intervención del programador mediante el uso de paréntesis (tipo).
   
   * Ejemplo:
```csharp
double decimalValue = 9.78;
int entero = (int)decimalValue; // Conversión explícita de double a int
Console.WriteLine(entero); // Salida: 9
```
   * Posibles problemas:
     * Pérdida de precisión (por ejemplo, truncamiento al convertir de `double` a `int`).
     * Posibilidad de excepciones si los tipos no son compatibles.

## Conversión con Métodos
Para conversiones más seguras o entre tipos no compatibles directamente, se utilizan métodos específicos.

1. `Convert Class`:
```csharp
string texto = "123";
int numero = Convert.ToInt32(texto);
Console.WriteLine(numero); // Salida: 123
```

2. Métodos específicos de tipos:
```csharp
string texto = "3.14";
double numero = double.Parse(texto);
Console.WriteLine(numero); // Salida: 3.14
```

3. Conversión segura con `TryParse`:
```csharp
string texto = "abc";
if (int.TryParse(texto, out int numero))
{
    Console.WriteLine($"Número válido: {numero}");
}
else
{
    Console.WriteLine("El texto no es un número válido.");
}
```

## Casting en Jerarquías de Clases
En sistemas orientados a objetos, el casting es común para trabajar con clases base y derivadas.

1. **Upcasting (Implícito)**: Conversiones de una clase derivada a su clase base. Siempre es seguro.
```csharp
class Animal { }
class Perro : Animal { }

Animal animal = new Perro(); // Upcasting implícito
```

2. Downcasting (Explícito): Conversiones de una clase base a su clase derivada. Requiere validación previa.
```csharp
Animal animal = new Perro();
Perro perro = (Perro)animal; // Downcasting explícito
```

* Usar el operador `as`: Realiza un casting seguro, devolviendo `null` si la conversión no es posible.
```csharp
Animal animal = new Animal();
Perro perro = animal as Perro;
if (perro != null)
{
    Console.WriteLine("Conversión exitosa.");
}
else
{
    Console.WriteLine("La conversión falló.");
}
```

* Usar el operador `is`: Verifica si el objeto puede convertirse antes de hacerlo.
```csharp
if (animal is Perro perro)
{
    Console.WriteLine("El animal es un perro.");
}
```

## Consideraciones Importantes
1. **Evita las excepciones**: El casting explícito puede fallar y generar excepciones en tiempo de ejecución. Usa operadores como `is` o `as` para mayor seguridad.

2. **Pérdida de datos**: Cuando conviertes tipos numéricos más grandes a más pequeños (`double` a `int`), verifica los límites del tipo destino.

3. **Conversiones complejas**: Para tipos no directamente relacionados, utiliza métodos específicos o bibliotecas de conversión.

4. **Cadenas y números**: Convierte cadenas a números con cuidado, asegurándote de validar la entrada del usuario.

## Código de Ejemplo
```csharp
using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Ingresa un número decimal:");
        string entrada = Console.ReadLine();

        // Conversión usando TryParse
        if (double.TryParse(entrada, out double numeroDecimal))
        {
            // Casting explícito a entero
            int numeroEntero = (int)numeroDecimal;
            Console.WriteLine($"Número decimal: {numeroDecimal}");
            Console.WriteLine($"Número entero (tras casting): {numeroEntero}");
        }
        else
        {
            Console.WriteLine("Entrada inválida. No es un número.");
        }
    }
}
```

# Implicit Casting
El Implicit Casting (o conversión implícita) es el proceso automático mediante el cual el compilador de C# convierte un valor de un tipo a otro sin necesidad de intervención explícita por parte del programador. Este tipo de casting solo es posible cuando:

* No hay pérdida de datos.
* Los tipos son compatibles.

Ejemplo sencillo:
```csharp
int numero = 42;
double numeroDecimal = numero; // Implicit Casting de int a double
```
En este caso, el compilador realiza la conversión automáticamente porque `double` puede representar cualquier valor de `int` sin pérdida de precisión.

## ¿Para qué sirve?
El Implicit Casting es útil para:

* Simplificar el código, al eliminar la necesidad de realizar conversiones explícitas en situaciones seguras.

* Manejar operaciones entre tipos numéricos compatibles.

* Facilitar el manejo de jerarquías de clases en un contexto de herencia.

## ¿Qué resuelve?
* Complejidad en el código: Permite evitar la redundancia de escribir conversiones explícitas en operaciones comunes.

* Errores de programación: Al garantizar que la conversión es segura, reduce el riesgo de errores o pérdidas de datos.

* Compatibilidad entre tipos: Facilita trabajar con tipos más generales o flexibles, como float y double.

## ¿Cómo lo resuelve?
* El compilador de C# inspecciona los tipos involucrados en la operación y realiza el Implicit Casting solo si cumple con los siguientes criterios:

* El tipo de origen es más pequeño o menos preciso que el tipo de destino.

* Ejemplo: int (32 bits) a long (64 bits).

* El tipo de destino puede representar todos los valores posibles del tipo de origen.

## Casos de Uso Comunes del Implicit Casting
1. **Entre tipos numéricos**: Cuando un tipo más pequeño se convierte en un tipo más grande (más capacidad).
   
   * Ejemplo:
```csharp
int entero = 100;
float flotante = entero; // Implicit Casting de int a float
Console.WriteLine(flotante); // Salida: 100
```

2. En jerarquías de clases (Herencia): Cuando conviertes un objeto de una clase derivada a su clase base (conocido como `upcasting`).

   * Ejemplo:
```csharp
class Animal
{
    public void Hablar() => Console.WriteLine("El animal hace un sonido.");
}

class Perro : Animal
{
    public void Ladrar() => Console.WriteLine("El perro ladra.");
}

Animal animal = new Perro(); // Implicit Casting (Upcasting)
animal.Hablar();
```
   * En este caso, el objeto Perro es tratado como su clase base Animal sin necesidad de casting explícito.

## Reglas del Implicit Casting
1. Tipos numéricos compatibles:
   * Conversión de tipos más pequeños a tipos más grandes.
   * Ejemplo: byte → short → int → long → float → double.

2. Tipos de datos no compatibles:
   * No se realiza Implicit Casting entre tipos no relacionados.
   * Por ejemplo, no puedes convertir int a string implícitamente.

3. No hay pérdida de datos: El casting es seguro porque el tipo de destino siempre puede contener todos los valores posibles del tipo de origen.

# Explicit Casting
El Explicit Casting (o conversión explícita) es el proceso manual en el que el programador indica al compilador que convierta un tipo de dato en otro. Esto ocurre cuando los tipos involucrados no son completamente compatibles o cuando existe riesgo de pérdida de datos.

Ejemplo sencillo:
```csharp
double numeroDecimal = 42.5;
int numeroEntero = (int)numeroDecimal; // Explicit Casting de double a int
Console.WriteLine(numeroEntero); // Salida: 42
```
En este caso, el programador usa (`int`) para convertir explícitamente un `double` a un `int`, consciente de que se perderá la parte decimal.

## ¿Para qué sirve?
El Explicit Casting es útil cuando:

* Necesitas convertir tipos incompatibles de forma controlada.

* Quieres manejar conversiones en las que puede haber pérdida de datos.

* Trabajas con jerarquías de clases y necesitas convertir de una clase base a una clase derivada (downcasting).

## ¿Qué resuelve?
* Control de conversiones inseguras: Permite realizar conversiones entre tipos incompatibles que no se pueden hacer implícitamente.

* Flexibilidad en el manejo de datos: Facilita trabajar con estructuras complejas o jerarquías de objetos.

* Personalización de conversiones: Permite al programador decidir cómo y cuándo se realiza una conversión, evitando errores automáticos.

## ¿Cómo lo resuelve?
El Explicit Casting requiere que el programador especifique la conversión utilizando paréntesis y el tipo de destino. Esto indica al compilador que:

* Se asume la responsabilidad de la conversión.
* Se comprende que puede haber pérdida de datos o posibles errores de ejecución.

## Casos de Uso del Explicit Casting
1. Conversión entre tipos numéricos incompatibles: Cuando se convierte de un tipo más grande o más preciso a uno más pequeño.

   * Ejemplo
```csharp
double numeroDecimal = 123.45;
int numeroEntero = (int)numeroDecimal; // Explicit Casting de double a int
Console.WriteLine(numeroEntero); // Salida: 123
```
   * En este caso, la parte decimal (.45) se pierde.

2. Conversión de clases en jerarquías (Downcasting): Cuando necesitas convertir un objeto de una clase base a una clase derivada.

   * Ejemplo:
```csharp
class Animal
{
    public void Hablar() => Console.WriteLine("El animal hace un sonido.");
}

class Perro : Animal
{
    public void Ladrar() => Console.WriteLine("El perro ladra.");
}

Animal animal = new Perro(); // Upcasting implícito
Perro perro = (Perro)animal; // Downcasting explícito
perro.Ladrar(); // Salida: El perro ladra.
```
   * En este caso, el downcasting convierte animal de tipo Animal a su tipo específico Perro, permitiendo acceder a métodos propios de la clase Perro.

## Reglas del Explicit Casting
1. El tipo de origen debe ser compatible con el tipo de destino.
   * Si no hay compatibilidad, el casting generará una excepción en tiempo de ejecución.

2. El programador asume la responsabilidad de la conversión.
   * Esto implica ser consciente de los riesgos, como la pérdida de datos o excepciones.

3. Requiere especificar el tipo de destino.
   * Ejemplo: (int)valor.
