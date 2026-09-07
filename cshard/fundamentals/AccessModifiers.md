#Classes
# Modificadores de Acceso
Los Access Modifiers (Modificadores de Acceso) son una característica en C# que define la visibilidad o alcance de los miembros (clases, métodos, propiedades, campos, etc.) de un programa. Es decir, controlan qué partes del código pueden acceder a un determinado miembro o clase.

En esencia, los modificadores de acceso son un mecanismo de encapsulación, uno de los principios fundamentales de la Programación Orientada a Objetos (POO).

## ¿Cuáles son los Access Modifiers en C#?
C# ofrece los siguientes modificadores de acceso:

* **`public`**: El miembro o clase es accesible desde cualquier parte del programa.
  * **¿Qué hace?**: Permite acceso desde cualquier lugar del programa.
  
  * **¿Cuándo usarlo?**: Para miembros que deben estar disponibles públicamente, como métodos de una API.
```c#
public class Persona
{
    public string Nombre { get; set; }
    public void Saludar()
    {
        Console.WriteLine($"Hola, mi nombre es {Nombre}.");
    }
}
```

* **`private`**: El miembro es accesible solo dentro de la clase o estructura donde fue definido.
  * ¿Qué hace?: Restringe el acceso al miembro, haciéndolo accesible solo dentro de la clase que lo define.
  
  * ¿Cuándo usarlo? Para campos o métodos que forman parte de la implementación interna.
```c#
public class Persona
{
    private int edad;

    public void SetEdad(int nuevaEdad)
    {
        if (nuevaEdad > 0) edad = nuevaEdad;
    }

    public int GetEdad()
    {
        return edad;
    }
}
```

* **`protected`**: El miembro es accesible dentro de la clase donde fue definido y en clases derivadas (herencia).
  * ¿Qué hace?: Permite el acceso solo desde la clase donde se define y desde clases derivadas.
  
  * ¿Cuándo usarlo?: Para miembros que deben ser accesibles por subclases, pero no desde fuera.
```c#
public class Persona
{
    protected string Identificacion;

    public void MostrarIdentificacion()
    {
        Console.WriteLine($"Identificación: {Identificacion}");
    }
}

public class Estudiante : Persona
{
    public void AsignarIdentificacion(string id)
    {
        Identificacion = id; // Acceso permitido
    }
}
```

* **`internal`**: El miembro es accesible solo dentro del mismo ensamblado (proyecto).
  * ¿Qué hace?: Permite el acceso solo dentro del mismo ensamblado (proyecto).
  
  * ¿Cuándo usarlo?: Para miembros que no deben ser accesibles desde otros proyectos.
```c#
internal class Utilidades
{
    internal static void ImprimirMensaje(string mensaje)
    {
        Console.WriteLine(mensaje);
    }
}
```

* **`protected internal`**: Una combinación de protected e internal. El miembro es accesible dentro del mismo ensamblado y en clases derivadas, incluso si están en un ensamblado diferente.
  * ¿Qué hace?: Permite el acceso dentro del mismo ensamblado o desde clases derivadas en otros ensamblados.
  
  * ¿Cuándo usarlo?: Para miembros que deben ser accesibles por herencia y también dentro del ensamblado.
```c#
public class Persona
{
    protected internal string Nombre { get; set; }
}
```

* **`private protected`**: El miembro es accesible solo dentro de la clase que lo define y en clases derivadas, pero únicamente si están en el mismo ensamblado.
  * ¿Qué hace?: Permite el acceso solo dentro de la clase que lo define y en clases derivadas, pero solo si están en el mismo ensamblado.
  
  * ¿Cuándo usarlo?: Para miembros que deben ser accesibles solo dentro del ensamblado, incluso con herencia.
```c#
public class Persona
{
    private protected string DatosInternos;

    public void MostrarDatos()
    {
        Console.WriteLine(DatosInternos);
    }
}
```

## ¿Para qué sirven?
* Controlar el acceso a los miembros de una clase: Permiten ocultar detalles de implementación al resto del código y exponer solo lo necesario.

* Proteger la integridad de los datos: Reducen la posibilidad de errores al limitar qué partes del código pueden modificar o acceder a ciertos miembros.

* Implementar encapsulación: Ayudan a mantener el código modular, organizado y más fácil de entender.

## ¿Qué resuelven?
* Exposición innecesaria de detalles de implementación: Sin modificadores de acceso, todos los miembros de una clase serían accesibles desde cualquier lugar, lo que aumenta el riesgo de errores y dificulta el mantenimiento.

* Violación de la integridad de los datos: Los modificadores de acceso restringen qué partes del código pueden acceder o modificar ciertos datos, evitando cambios no controlados.

* Falta de modularidad y claridad: Facilitan la creación de componentes independientes y reutilizables, exponiendo solo lo necesario.

## ¿Cómo lo resuelven?
* Definiendo límites claros: Usar private oculta detalles de implementación; usar public expone lo estrictamente necesario.

* Controlando el acceso con herencia: Los modificadores como protected y protected internal permiten un acceso controlado a los miembros desde clases derivadas.

* Segmentando el acceso por ensamblado: Con internal y combinaciones como protected internal, puedes controlar qué partes del código (dentro o fuera del proyecto) pueden interactuar con los miembros.

## Errores Comunes con Access Modifiers
* Usar public innecesariamente: Esto expone detalles de implementación y aumenta el acoplamiento.

* Olvidar especificar un modificador: En ausencia de un modificador, el miembro será private por defecto, lo que puede causar confusión.

* Usar protected sin considerar las implicaciones de herencia: Puede exponer más de lo necesario a las clases derivadas.

## Buenas Prácticas
* Aplica el principio de menor acceso: Usa el modificador más restrictivo posible que aún permita cumplir con los requisitos funcionales.

* Define interfaces públicas claras: Expón solo lo necesario para que otros desarrolladores interactúen con tu clase.

* Refactoriza los accesos regularmente: Durante el desarrollo, revisa los modificadores de acceso para asegurarte de que cumplen con los requisitos actuales.