#architecture
# Common Type System
El Common Type System (CTS) es un componente clave del .NET Framework, encargado de definir cómo los tipos de datos y objetos se deben declarar, usar y administrar en tiempo de ejecución dentro del ecosistema .NET. Es parte del diseño del Common Language Infrastructure (CLI) y asegura que los lenguajes compatibles con .NET puedan trabajar juntos de manera fluida.

El CTS establece un conjunto común de reglas y tipos de datos estándar que todos los lenguajes compatibles con .NET deben seguir, garantizando la interoperabilidad y consistencia entre ellos.

## ¿Para qué sirve el CTS?
* **Establecer interoperabilidad entre lenguajes**: Permite que los diferentes lenguajes de programación que funcionan sobre .NET (como C#, VB.NET, F#, etc.) puedan compartir y usar tipos de datos de manera uniforme.

* **Proveer un estándar para definir tipos**: Define cómo se crean, administran y usan los tipos de datos, lo que incluye estructuras, clases, interfaces y enumeraciones.

* **Unificar los sistemas de tipos**: Asegura que los tipos definidos en un lenguaje sean equivalentes a los de otro lenguaje al ejecutarse en el Common Language Runtime (CLR).

## ¿Qué resuelve el CTS?
* **Inconsistencias entre lenguajes**: En sistemas anteriores, los lenguajes de programación solían tener definiciones diferentes para los mismos tipos básicos (por ejemplo, int en C++ frente a Integer en VB). El CTS elimina estas diferencias definiendo tipos comunes.

* **Compatibilidad en la ejecución**: Garantiza que los lenguajes puedan usar tipos definidos en otros lenguajes sin problemas. Por ejemplo, una clase definida en C# puede ser heredada por una clase en VB.NET.

* **Problemas de interoperabilidad**: Resuelve conflictos de tipos al proporcionar un estándar compartido para todos los lenguajes .NET.

## ¿Cómo lo resuelve el CTS?
1. **Definición de tipos comunes**:
   * El CTS clasifica los tipos en dos grandes categorías:
     * Value Types (Tipos de valor): Almacenan directamente los datos y se asignan en la pila (stack). Ejemplo: int, float, bool.

     * Reference Types (Tipos de referencia): Almacenan una referencia a la ubicación de los datos y se asignan en el heap. Ejemplo: class, interface, string.

2. **Estandarización de tipos básicos**:
   * El CTS define un conjunto de tipos básicos que todos los lenguajes deben implementar, como:
     * System.Int32 (32 bits enteros, equivalente a int en C#).
     * System.String (cadenas de texto).
     * System.Object (raíz de todos los tipos en .NET).

3. **Definición de reglas para tipos personalizados**:
   * El CTS permite que los desarrolladores definan sus propios tipos de datos y establece cómo deben comportarse:
     * Clases: Con soporte para herencia, métodos y propiedades.
     
     * Interfaces: Para implementar contratos entre tipos.
     
     * Estructuras: Tipos de valor más ligeros que las clases.
     
     * Enumeraciones: Listados de valores constantes.

4. **Conversiones y compatibilidad de tipos**: Proporciona reglas para conversiones implícitas y explícitas entre tipos, asegurando que se mantenga la consistencia durante la ejecución.

## Tipos definidos en el CTS
1. **Tipos de Valor (Value Types)**:
   * Almacenan datos directamente.
   * Se asignan en la pila.

   * Ejemplos:
     * Tipos primitivos: int, float, bool, char.
     * Estructuras definidas por el usuario (struct en C#).

2. No soportan herencia directa.
   * Tipos de Referencia (Reference Types):
   * Almacenan una referencia a los datos.
   * Se asignan en el heap.

   * Ejemplos:
     * Clases: Tipos definidos con class.
     
     * Interfaces: Contratos para clases y estructuras.
     
     * Arrays: Estructuras de datos para colecciones de elementos.
     
     * Delegados: Representan referencias a métodos.

3. Otros tipos importantes:
   * Object: Raíz de todos los tipos.
   * String: Tipo especial para manejar cadenas de texto.

### Relación entre CTS y CLS (Common Language Specification)
* CTS: Define todos los tipos disponibles en .NET. Es el estándar más amplio.

* CLS: Es un subconjunto del CTS que especifica los tipos y características que todos los lenguajes compatibles con .NET deben soportar para garantizar la interoperabilidad.

**Por ejemplo:**
* El CTS permite métodos sobrecargados con diferencias en mayúsculas y minúsculas (Method y method).
* El CLS prohíbe esta práctica para garantizar que lenguajes que no distinguen mayúsculas de minúsculas (como VB.NET) sean compatibles.

## Ejemplo práctico del CTS
Imagina que definimos una clase en C# y la usamos en VB.NET. Gracias al CTS, los tipos son consistentes en ambos lenguajes.

En C#:
```c#
public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }
}
```
En VB.NET:
```vb
Dim p As New Persona()
p.Nombre = "Juan"
p.Edad = 25
```
El CTS asegura que string en C# y String en VB.NET se refieren al mismo tipo subyacente: `System.String`.