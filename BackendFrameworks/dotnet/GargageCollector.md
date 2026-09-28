# Garbage Collector
El Garbage Collector (GC) es un componente clave del Common Language Runtime (CLR) de .NET. Es un sistema automático de administración de memoria que se encarga de liberar memoria no utilizada por objetos que ya no son accesibles en un programa. Esto asegura que los recursos del sistema, como la memoria RAM, se utilicen de manera eficiente y se eviten fugas de memoria (memory leaks).

## ¿Para qué sirve el Garbage Collector?
El Garbage Collector tiene como propósito principal:

* **Administrar la memoria automáticamente**: Libera memoria ocupada por objetos que ya no están en uso sin intervención manual del desarrollador.

* **Evitar fugas de memoria**: Garantiza que los objetos que no tienen referencias activas sean eliminados, previniendo el consumo innecesario de recursos.

* **Simplificar la gestión de memoria**: Permite que los desarrolladores se concentren en la lógica de su aplicación sin preocuparse por la liberación manual de memoria.

* **Garantizar estabilidad y eficiencia**: Optimiza el uso de memoria para evitar que el sistema se quede sin recursos debido a un mal manejo de memoria en el código.

## ¿Qué resuelve el Garbage Collector?
* **Liberación manual de memoria**: En lenguajes como C o C++, el desarrollador debe liberar manualmente la memoria con `free` o `delete`. Esto puede provocar errores como:

  * Fugas de memoria: Cuando un programa no libera memoria que ya no necesita.

  * Acceso a memoria liberada: Intentar usar memoria ya liberada puede causar errores críticos (como segfaults).

**El Garbage Collector elimina esta responsabilidad del desarrollador, resolviendo estos problemas automáticamente.**

* **Gestión de referencias circulares**: Los objetos que se refieren entre sí y ya no son accesibles desde el código pueden ser eliminados gracias a los algoritmos del GC.

* **Optimización del rendimiento**: Identifica y compacta bloques de memoria fragmentados, maximizando el uso de memoria disponible.

## ¿Cómo lo resuelve el Garbage Collector?
El GC utiliza un algoritmo estructurado en varias fases para identificar y eliminar objetos no utilizados. Sus pasos son:

1. **Generaciones de objetos**: El GC organiza los objetos en tres generaciones:
   * Generación 0: Contiene objetos de vida corta (por ejemplo, variables locales).

   * Generación 1: Actúa como un área intermedia para objetos que sobreviven a la recolección de la generación 0.

   * Generación 2: Contiene objetos de vida larga (por ejemplo, objetos estáticos o singleton).

**Esto permite optimizar la recolección al centrarse en áreas de memoria que probablemente contengan basura.**

2. **Fase de marcación**: El GC recorre todos los objetos accesibles desde el punto de entrada del programa (raíces) y marca los que aún son accesibles.

3. **Fase de barrido**: Los objetos que no fueron marcados como accesibles son eliminados, liberando su memoria.

4. **Compactación (opcional)**: Rearranga los objetos en la memoria para eliminar fragmentación y mejorar la eficiencia de futuras asignaciones.

5. **Recolección incremental (si es necesario)**: En sistemas con alta carga de memoria, el GC puede realizar tareas en fragmentos pequeños para evitar interrupciones largas.

## Ventajas del Garbage Collector
1. **Automatización de la gestión de memoria**: Reduce la complejidad del desarrollo y elimina errores comunes relacionados con la memoria.

2. **Seguridad**: Previene errores como el uso de punteros colgantes o la sobreescritura de memoria.

3. **Optimización automática**: Realiza compactación y optimización de la memoria sin intervención manual.

4. **Reducción de fugas de memoria**: Identifica y elimina automáticamente objetos que ya no son accesibles.

## Desventajas del Garbage Collector
1. **Impacto en el rendimiento**: Durante la ejecución del GC, el programa puede experimentar una pausa (denominada "pausa del mundo") que afecta el rendimiento.

2. **Menor control**: Los desarrolladores no tienen control directo sobre cuándo se libera la memoria.

3. **Sobrecarga de memoria**: Puede requerir más memoria que un programa con gestión manual para operar de manera eficiente.

## Configuración del Garbage Collector en .NET
.NET proporciona configuraciones para adaptar el comportamiento del GC según las necesidades del sistema o la aplicación:

* **Workstation GC**: Optimizado para aplicaciones de escritorio. Minimiza las pausas pero puede ser menos eficiente en el uso de recursos.

* **Server GC**: Diseñado para aplicaciones en servidores con múltiples núcleos. Ofrece mayor rendimiento mediante recolección en paralelo.

* **Concurrent GC**: Realiza tareas de recolección en segundo plano para minimizar interrupciones.

**Estas configuraciones se pueden ajustar en el archivo de configuración de la aplicación o mediante código.**

## Conceptos clave del Garbage Collector
1. Generaciones: Comprender cómo las generaciones ayudan a optimizar el rendimiento del GC.

2. Raíces del objeto (Object Roots):
   * Variables locales en el stack
   
   * Variables estáticas
   
   * Referencias de objetos en registros.

3. **Finalización de objetos**: Los objetos pueden implementar el método Finalize para liberar recursos no administrados, aunque el uso de la interfaz IDisposable con using es preferido.

4. **Compactación de memoria**: Mejora el rendimiento mediante la eliminación de fragmentación en la memoria.

5. **Weak References**: Permiten que un objeto sea recolectado por el GC mientras todavía se puede acceder débilmente a él.

### Ejemplo práctico
```csharp
using System;

class Program
{
    static void Main()
    {
        // Crear objetos
        for (int i = 0; i < 1000; i++)
        {
            var obj = new object();
        }

        // Forzar la recolección de basura
        GC.Collect();
        GC.WaitForPendingFinalizers();

        Console.WriteLine("Recolección de basura completada.");
    }
}
```
Este ejemplo muestra cómo se puede invocar al GC manualmente (aunque generalmente no es necesario). El método GC.Collect fuerza la recolección de basura, pero su uso excesivo puede ser perjudicial para el rendimiento.

## Buenas prácticas relacionadas con el Garbage Collector
* Usar recursos administrados siempre que sea posible: Evita manejar manualmente la memoria y los recursos no administrados.

* Implementar la interfaz IDisposable: Para liberar recursos no administrados de forma explícita y controlada.

* Evitar referencias estáticas innecesarias: Los objetos con referencias estáticas nunca serán recolectados por el GC.

* Reducir la fragmentación de memoria: Crear y destruir objetos grandes con moderación.

* No abusar de GC.Collect: Permite que el GC administre la memoria automáticamente.