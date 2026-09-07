# Clases Abstractas
En C#, una clase abstracta es una clase que no puede ser instanciada directamente. Puede contener tanto miembros abstractos (sin implementación) como miembros concretos (con implementación). Las clases que heredan de una clase abstracta deben implementar los miembros abstractos, pero pueden reutilizar los miembros concretos.

Las clases abstractas ofrecen una forma de estructurar clases que no están destinadas a ser instanciadas directamente, pero pueden servir como base para otras clases. Son una herramienta fundamental para el diseño de sistemas jerárquicos y modulares.

## Características clave de las clases abstractas:
* **No instanciables**: No puedes crear instancias de una clase abstracta directamente.

* **Métodos abstractos**: Puedes definir métodos abstractos, que son métodos sin implementación. Las clases derivadas deben proporcionar su implementación.

* **Métodos concretos**: Puedes tener métodos con implementación completa, lo que significa que las clases derivadas pueden reutilizarlos.

* **Propósitos**: Las clases abstractas son útiles cuando quieres proporcionar una base común para varias clases, pero también quieres dejar que cada clase hija implemente detalles específicos.

* Sintaxis básica:
```csharp
public abstract class Animal
{
    public abstract void HacerSonido();  // Método abstracto (sin implementación)
    
    public void Dormir()  // Método concreto (con implementación)
    {
        Console.WriteLine("El animal está durmiendo");
    }
}
```
En este ejemplo, Animal es una clase abstracta. El método HacerSonido es abstracto, lo que significa que las clases derivadas deben implementarlo. El método Dormir tiene una implementación, por lo que las clases derivadas pueden usarlo directamente.

## ¿Para qué sirven las Clases Abstractas en C#?

Las clases abstractas tienen varios usos y ofrecen ventajas en el diseño de software. Principalmente:
* **Proporcionar una implementación base común**: Las clases abstractas pueden contener tanto implementación común (métodos concretos) como métodos que las clases derivadas deben implementar (métodos abstractos). Esto permite que las clases derivadas compartan comportamientos comunes, pero también tengan su propia lógica específica.

* **Definir un comportamiento común para todas las clases derivadas**: Permiten definir un contrato común para todas las clases que hereden de la clase abstracta, asegurando que todas tengan ciertas características o comportamientos.

* **Evitar la creación de objetos innecesarios**: Una clase abstracta es útil para evitar la creación de instancias de una clase que no tiene sentido por sí misma, como una clase base abstracta para diferentes tipos de animales o vehículos.

* **Hacer el código más limpio y extensible**: Las clases abstractas mejoran la extensibilidad de tu código, permitiendo la implementación de nuevas clases sin modificar el comportamiento común ya definido.

## ¿Qué resuelven las Clases Abstractas en C#?

Las clases abstractas resuelven varios problemas comunes en el diseño orientado a objetos:

1. Falta de reutilización de código: Sin las clases abstractas, tendrías que duplicar la implementación común en cada clase derivada. Las clases abstractas te permiten escribir código común una sola vez y reutilizarlo.

2. Diseño rígido: La herencia múltiple no es soportada por C#, lo que hace que una clase no pueda heredar de más de una clase base. Las clases abstractas permiten establecer una jerarquía de clases más flexible.

3. Problemas de control de implementación: Las clases abstractas permiten imponer que ciertas clases implementen métodos esenciales, como métodos abstractos, mientras les dan la libertad de implementar otros métodos por sí mismas.

## ¿Cómo lo resuelven?
Las clases abstractas resuelven los problemas anteriores proporcionando una forma de estructurar tu código en jerarquías que heredan comportamientos comunes mientras permiten la personalización de ciertos aspectos en clases derivadas.

1. Proporcionar un comportamiento común mientras permites la personalización
   * Las clases abstractas permiten que las clases derivadas reutilicen código común (métodos concretos) mientras que los métodos abstractos obligan a las clases derivadas a proporcionar su propia implementación.

   * Ejemplo de uso:
```csharp
public abstract class Vehiculo
{
    public abstract void Mover();  // Método abstracto (debe ser implementado por las clases derivadas)

    public void Detener()  // Método concreto (común para todas las clases derivadas)
    {
        Console.WriteLine("El vehículo se detiene");
    }
}

public class Coche : Vehiculo
{
    public override void Mover()  // Implementación específica para Coche
    {
        Console.WriteLine("El coche se mueve");
    }
}

public class Barco : Vehiculo
{
    public override void Mover()  // Implementación específica para Barco
    {
        Console.WriteLine("El barco se mueve");
    }
}
```
En este ejemplo, Vehiculo es una clase abstracta que proporciona el método concreto Detener, pero deja a las clases Coche y Barco la implementación del método abstracto Mover.

2. Evitar la creación de objetos de clases incompletas
   * La clase abstracta Vehiculo no puede ser instanciada directamente. Solo las clases derivadas Coche y Barco pueden ser instanciadas, lo que previene la creación de objetos de una clase base que no tiene sentido por sí sola.

```csharp
// Esto no es válido:
Vehiculo v = new Vehiculo();  // Error: no se puede instanciar una clase abstracta

// Esto sí es válido:
Coche coche = new Coche();
Barco barco = new Barco();
```

3. Definir un contrato obligatorio para las clases derivadas
   * Al declarar un método como abstracto en la clase base, las clases derivadas están obligadas a implementar este método, asegurando que todas las clases derivadas tengan una implementación para ese comportamiento.

```csharp
public abstract class Animal
{
    public abstract void HacerSonido();  // Las clases derivadas deben implementar este método
}

public class Perro : Animal
{
    public override void HacerSonido()
    {
        Console.WriteLine("¡Guau!");
    }
}

public class Gato : Animal
{
    public override void HacerSonido()
    {
        Console.WriteLine("¡Miau!");
    }
}
```

## ¿Cuándo usar una Clase Abstracta en lugar de una Interfaz?
Aunque tanto las clases abstractas como las interfaces son mecanismos para definir contratos en C#, existen diferencias clave que determinan cuándo usar cada uno:

* Usar una clase abstracta cuando:
  * Quieres proporcionar una implementación común para todas las clases derivadas.

  * Necesitas tener un comportamiento predeterminado y solo deseas que las clases derivadas modifiquen o amplíen ese comportamiento.

  * Quieres permitir que las clases derivadas reutilicen el código de la clase base.

* Usar una interfaz cuando:
  * No deseas proporcionar ninguna implementación, solo la declaración de los métodos.

  * Necesitas que varias clases que no tienen una relación jerárquica común implementen los mismos métodos.

# Inyección de Dependencias (DI)