# Tipos de datos
# Primitivos
En C#, los tipos de datos primitivos son los tipos fundamentales que permiten representar los valores básicos que la computadora puede manejar de manera directa. Son los bloques de construcción esenciales para cualquier programa en C# y se utilizan para definir variables y almacenar datos de forma eficiente. Estos tipos de datos están optimizados para la memoria y el rendimiento, y permiten que el código se ejecute de manera rápida y segura.

## ¿Qué son los tipos de datos primitivos en C#?
Los tipos de datos primitivos en C# son tipos predefinidos por el lenguaje que se utilizan para almacenar valores básicos como números, caracteres y valores lógicos. Estos tipos están incluidos en el lenguaje C# de forma estándar y forman la base de casi todas las operaciones que realizamos en un programa.

## Tipos de datos primitivos en C#
C# tiene varios tipos de datos primitivos que se pueden clasificar en dos grandes categorías: tipos de valor y tipos de referencia.

### Tipos de Valor
Los tipos de valor contienen el dato directamente y se almacenan en la pila (stack). Cuando se asignan a una nueva variable, se copian por valor, no por referencia.

int (Entero)

Tamaño: 4 bytes (32 bits)
Rango: de -2,147,483,648 a 2,147,483,647
Uso: Se utiliza para almacenar números enteros (sin decimales).
Ejemplo: int edad = 30;
long (Entero largo)

Tamaño: 8 bytes (64 bits)
Rango: de -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
Uso: Se utiliza para almacenar números enteros más grandes que los que puede almacenar int.
Ejemplo: long distancia = 10000000000L;
short (Entero corto)

Tamaño: 2 bytes (16 bits)
Rango: de -32,768 a 32,767
Uso: Se utiliza para almacenar números enteros pequeños.
Ejemplo: short temperatura = 25;
byte (Byte)

Tamaño: 1 byte (8 bits)
Rango: de 0 a 255
Uso: Se utiliza para almacenar números enteros pequeños sin signo.
Ejemplo: byte contador = 255;
float (Número de punto flotante simple precisión)

Tamaño: 4 bytes (32 bits)
Rango: Aproximadamente ±1.5 × 10^−45 a ±3.4 × 10^38 (con 7 dígitos decimales de precisión)
Uso: Se utiliza para almacenar números decimales, como medidas o valores con decimales. Es menos preciso que double.
Ejemplo: float altura = 5.75f;
double (Número de punto flotante doble precisión)

Tamaño: 8 bytes (64 bits)
Rango: Aproximadamente ±5.0 × 10^−324 a ±1.7 × 10^308 (con 15-16 dígitos decimales de precisión)
Uso: Se utiliza para almacenar números decimales con una mayor precisión que float.
Ejemplo: double pi = 3.14159265359;
decimal (Decimal)

Tamaño: 16 bytes (128 bits)
Rango: Aproximadamente ±1.0 × 10^−28 a ±7.9 × 10^28 (con 28-29 dígitos decimales de precisión)
Uso: Se utiliza principalmente para cálculos financieros, donde se requiere una alta precisión en los valores decimales.
Ejemplo: decimal precio = 19.99m;
char (Carácter)

Tamaño: 2 bytes (16 bits)
Rango: de '\u0000' a '\uffff' (Carácter Unicode)
Uso: Se utiliza para almacenar un solo carácter (letras, números, símbolos, etc.).
Ejemplo: char inicial = 'A';
bool (Booleano)

Tamaño: 1 byte (8 bits)
Valores posibles: true o false
Uso: Se utiliza para almacenar valores de verdad (lógicos), es decir, true o false.
Ejemplo: bool esActivo = true;

### Tipos de Referencia
Los tipos de referencia se almacenan en el montón (heap), y cuando se asignan a una nueva variable, se copian por referencia, no por valor. Los tipos de referencia más comunes son las cadenas de texto (string) y las clases, pero string es una clase especial en C#.

string (Cadena de texto)

Tamaño: Variable (dependiendo de la longitud de la cadena)
Uso: Se utiliza para almacenar texto.
Ejemplo: string nombre = "Juan";
object (Objeto genérico)

Tamaño: Depende del tipo de objeto
Uso: Es el tipo base de todos los tipos en C#. Puede contener cualquier tipo de datos (primitivos, clases, etc.).
Ejemplo: object obj = 42;

## ¿Para qué sirven los tipos de datos primitivos en C#?
Los tipos de datos primitivos permiten almacenar y manipular valores fundamentales que se utilizan en casi todos los programas. Sirven para:

Representar valores básicos: Como números enteros, decimales, caracteres y valores booleanos.
Realizar operaciones: Permiten realizar cálculos matemáticos, comparaciones lógicas, manipulación de cadenas, etc.
Optimización de recursos: Cada tipo primitivo está optimizado en términos de memoria y velocidad, lo que ayuda a hacer que el programa sea más eficiente.

## ¿Qué resuelven los tipos de datos primitivos?
Los tipos de datos primitivos resuelven la necesidad de representar los valores más básicos que se usan en cualquier tipo de programa:

Almacenamiento de datos: Permiten almacenar información de manera eficiente, ya sea numérica, de texto o booleana.
Operaciones matemáticas y lógicas: Permiten realizar operaciones de cálculo y comparación que son esenciales para el flujo de trabajo de cualquier programa.
Interacción con el usuario: Facilitan la representación de datos que el usuario puede ingresar, como números, texto, etc.

## ¿Cómo lo resuelven?
Los tipos de datos primitivos resuelven estos problemas de la siguiente manera:

Almacenando valores directamente: Los tipos de valor como int, char, float, etc., contienen el valor directamente en su espacio de memoria. Esto hace que la asignación y manipulación de estos tipos sea rápida.
Optimización de memoria: Cada tipo tiene un tamaño específico y se adapta para almacenar el tipo de dato de manera eficiente. Esto optimiza el uso de memoria y hace que el programa sea más rápido.
Flexibilidad de uso: Los tipos primitivos se pueden combinar para crear estructuras más complejas (por ejemplo, combinando int, double y string en una clase personalizada) y permitir que el programa realice tareas más complejas.

# No primitivos
Los tipos de datos no primitivos en C# son tipos que se basan en referencias, es decir, se almacenan en el montón (heap) en lugar de la pila (stack). Esto significa que cuando trabajamos con estos tipos, estamos manipulando una referencia a un objeto en memoria, no el valor mismo.

En términos simples, mientras que los tipos primitivos contienen directamente el valor (como un número entero o un carácter), los tipos no primitivos contienen referencias a objetos que pueden almacenar datos más complejos.

## ¿Cuáles son los tipos de datos no primitivos en C#?
En C#, los tipos no primitivos incluyen clases, interfaces, delegados, cadenas de texto y tipos definidos por el usuario. Los principales tipos de datos no primitivos son:

Clases (Classes)
Las clases son los tipos no primitivos más comunes. Son plantillas o moldes para crear objetos (instancias) que encapsulan tanto datos como comportamientos.
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    public void Saludar()
    {
        Console.WriteLine($"¡Hola, mi nombre es {Nombre} y tengo {Edad} años!");
    }
}

Persona p = new Persona();
p.Nombre = "Juan";
p.Edad = 30;
p.Saludar();
```

Estructuras (Structs)
Las estructuras son tipos similares a las clases pero con una diferencia importante: son tipos de valor en lugar de tipos de referencia. Aunque almacenan los datos en el mismo bloque de memoria, pueden contener múltiples campos de diferentes tipos.
```c#
public struct Punto
{
    public int X;
    public int Y;
}

Punto p1 = new Punto { X = 10, Y = 20 };
Console.WriteLine($"Punto: ({p1.X}, {p1.Y})");
```

Cadenas (Strings)
El tipo string es un tipo de referencia que representa una secuencia de caracteres. Aunque internamente es un tipo de referencia, C# tiene un manejo especial de cadenas debido a su uso extendido en las aplicaciones.
```c#
string saludo = "¡Hola, Mundo!";
Console.WriteLine(saludo);
```

Interfaces (Interfaces)
Una interfaz define un contrato que las clases pueden implementar. Las interfaces contienen solo definiciones de métodos, propiedades, eventos, etc., pero no implementaciones.
```c#
public interface IHablar
{
    void Hablar();
}

public class Persona : IHablar
{
    public void Hablar()
    {
        Console.WriteLine("¡Hola!");
    }
}
```

Delegados (Delegates)
Los delegados son tipos que representan referencias a métodos con una firma específica. Se utilizan para implementar eventos o pasar métodos como parámetros.
```c#
public delegate void SaludoDelegado(string mensaje);

public class Program
{
    public static void Saludar(string mensaje)
    {
        Console.WriteLine(mensaje);
    }

    public static void Main()
    {
        SaludoDelegado saludo = new SaludoDelegado(Saludar);
        saludo("¡Hola desde el delegado!");
    }
}
```

Arrays (Arreglos)
Los arreglos son colecciones de elementos de un mismo tipo. Aunque los arreglos tienen un tipo primitivo cuando se crean, en sí mismos son tipos de referencia.
```c#
int[] numeros = { 1, 2, 3, 4, 5 };
Console.WriteLine(numeros[0]); // Imprime 1
```

Tipos definidos por el usuario (Custom Types)
C# también permite definir tipos personalizados mediante clases y estructuras que son más complejas que los tipos primitivos. Estos tipos pueden contener múltiples campos y métodos, y encapsulan la lógica relacionada.
```c#
public class Rectangulo
{
    public int Largo { get; set; }
    public int Ancho { get; set; }

    public int Area()
    {
        return Largo * Ancho;
    }
}

Rectangulo r = new Rectangulo { Largo = 5, Ancho = 3 };
Console.WriteLine($"Área del rectángulo: {r.Area()}");
```

## ¿Para qué sirven los tipos de datos no primitivos en C#?
Los tipos no primitivos sirven para representar estructuras de datos más complejas que van más allá de los simples valores primitivos. Permiten almacenar información más rica, realizar operaciones más complejas y ofrecer una mayor flexibilidad en el diseño de aplicaciones.

## ¿Qué resuelven los tipos de datos no primitivos?
Los tipos no primitivos resuelven problemas como:

Representación de objetos complejos: Permiten modelar entidades y objetos del mundo real (como personas, productos, transacciones, etc.) con múltiples propiedades y comportamientos.
Reutilización de código: A través de clases, interfaces y delegados, podemos encapsular lógica y reutilizarla en diferentes partes de una aplicación.
Abstracción: Las interfaces y las clases permiten abstraer detalles de implementación y concentrarse en el comportamiento general de los objetos.
Estructuras de datos dinámicas: Los arreglos, listas, pilas y otras colecciones permiten manejar grandes cantidades de datos de manera eficiente.

## ¿Cómo lo resuelven?
Los tipos de datos no primitivos resuelven estos problemas de la siguiente manera:

Clases: Las clases encapsulan propiedades y métodos que representan comportamientos complejos. Pueden ser instanciadas múltiples veces para crear objetos que mantengan su estado.
Estructuras: Las estructuras permiten representar conjuntos de datos relacionados y realizar operaciones sobre ellos. Son más eficientes en términos de memoria para pequeños conjuntos de datos.
Interfaces: Las interfaces permiten que diferentes clases implementen el mismo conjunto de métodos, promoviendo la reutilización de código y el polimorfismo.
Delegados: Los delegados permiten manejar referencias a métodos y funciones, facilitando la creación de eventos y la programación orientada a eventos.
Cadenas: Las cadenas son fundamentales para manejar texto de manera eficiente y flexible, facilitando la manipulación de datos alfanuméricos.
Arreglos: Los arreglos permiten almacenar múltiples elementos del mismo tipo, lo que es útil para representar listas, colecciones o conjuntos de datos.