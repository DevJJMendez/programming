# Programación Reactiva
La programación reactiva es un paradigma de programación que se centra en el manejo de flujos de datos asíncronos y en la propagación de cambios. En lugar de procesar datos de manera secuencial y sincrónica, la programación reactiva permite que las aplicaciones reaccionen a eventos a medida que ocurren, permitiendo un enfoque más flexible y eficiente para manejar flujos de datos que pueden ser impredecibles.

## ¿Qué es la Programación Reactiva?
* Es un estilo de programación asíncrono y orientado a eventos que se basa en flujos de datos reactivos.

* Los componentes de un sistema reactivo se comunican y reaccionan a eventos emitidos por otros componentes.

* Este enfoque se centra en manejar de manera eficiente las secuencias de datos que cambian con el tiempo, conocidas como streams, y en reaccionar a estos cambios.

## ¿Para Qué Sirve?
1. **Procesamiento Asíncrono**: Permite manejar eventos, solicitudes y respuestas de manera asíncrona, sin bloquear los hilos. Esto es útil para sistemas que requieren alta concurrencia y bajo tiempo de respuesta, como aplicaciones web, servidores de aplicaciones, servicios en la nube y sistemas de IoT.

2. **Propagación de Cambios**: Ideal para casos donde se necesitan actualizaciones en tiempo real, como interfaces de usuario que dependen de datos que cambian constantemente.

3. **Manejo de Flujos de Datos**: Permite manejar flujos de datos de forma eficiente, procesando eventos y datos a medida que se generan, lo cual es fundamental en aplicaciones como transmisiones de video, monitoreo de sensores, y análisis en tiempo real.

## ¿Qué Problemas Resuelve?
1. **Bloqueo y Eficiencia**: En un modelo de programación tradicional, las operaciones que tardan (como la lectura de archivos, consultas a bases de datos o llamadas a servicios web) pueden bloquear el hilo hasta que se completen. La programación reactiva resuelve esto permitiendo que el flujo de datos continúe sin interrupciones.

2. **Complejidad de la Concurrencia**: Manejar hilos manualmente para tareas concurrentes puede ser complicado y propenso a errores. La programación reactiva abstrae esta complejidad permitiendo que el programador se enfoque en manejar eventos en lugar de manejar hilos.

3. **Manejo de Errores**: Facilita el manejo de errores en sistemas distribuidos donde las fallas pueden ser frecuentes y difíciles de predecir.

## ¿Cómo Funciona?
El núcleo de la programación reactiva se basa en el concepto de streams (flujos de datos) y la propagación reactiva de cambios. Los flujos de datos pueden emitir tres tipos de eventos:

1. **Elementos de Datos**: Representan datos que se transmiten a través del flujo.

2. **Errores**: Si ocurre un error durante el procesamiento, se emite un evento de error que se puede manejar.

3. **Finalización**: Cuando el flujo de datos ha emitido todos los elementos y no se espera más, emite un evento de finalización.

## Conceptos Clave de la Programación Reactiva:
1. **Observable / Publisher**:

   * Es la fuente de datos que emite eventos. Puede ser un flujo continuo de datos que se emiten a lo largo del tiempo.

   * Se puede suscribir a un observable para recibir eventos a medida que ocurren.

2. **Observer / Subscriber**:

   * Es el componente que escucha o suscribe a los datos emitidos por el observable.

   * Recibe eventos (datos, errores, finalización) y ejecuta acciones basadas en esos eventos.

3. **Operadores**:

   * Son funciones que permiten transformar, filtrar y combinar flujos de datos. Ejemplos incluyen operadores para mapear datos, filtrar ciertos valores o combinar múltiples flujos en uno solo.

   * Ayudan a manipular los flujos de datos de manera declarativa.

4. **Backpressure**:

   * Es una estrategia para manejar situaciones en las que los productores de datos emiten eventos más rápido de lo que los consumidores pueden procesar. Permite equilibrar el flujo de datos para evitar sobrecarga y pérdida de datos.

## Ejemplos de Programación Reactiva:
1. **RxJava en Java**:
```java
import io.reactivex.rxjava3.core.Observable;

public class ReactiveExample {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Hola", "Mundo", "Reactivo");

        observable.subscribe(
            item -> System.out.println("Recibido: " + item),   // onNext
            error -> System.err.println("Error: " + error),    // onError
            () -> System.out.println("Completo")               // onComplete
        );
    }
}
```
**Explicación:**

* Se crea un `Observable` que emite tres elementos.

* `subscribe` se utiliza para manejar los eventos emitidos (`onNext`, `onError`, `onComplete`).

* Permite manejar datos a medida que se reciben sin bloquear el flujo de ejecución.

2. Uso de Operadores en RxJava:
```java
Observable<Integer> numbers = Observable.range(1, 10);

numbers
    .filter(n -> n % 2 == 0)   // Filtrar solo números pares
    .map(n -> n * 2)           // Multiplicar cada número por 2
    .subscribe(
        System.out::println,   // Imprimir el resultado
        Throwable::printStackTrace,
        () -> System.out.println("Finalizado")
    );
```
**Explicación:**

* Se utiliza `filter` para procesar solo números pares y map para transformarlos.

* Los operadores facilitan la manipulación de flujos de datos de forma concisa y declarativa.

## Librerías y Frameworks para Programación Reactiva:
* `RxJava`: La implementación más conocida de la programación reactiva en Java. Proporciona operadores y utilidades para manejar flujos de datos.

* `Reactor`: Parte del proyecto Spring, es una implementación para la JVM que sigue las especificaciones de Reactive Streams y se utiliza ampliamente en aplicaciones web.

* `Akka Streams`: Una implementación que combina actores y programación reactiva para sistemas distribuidos.

* `Project Reactor`: Implementación que se utiliza con Spring WebFlux para crear aplicaciones web reactivas.

## ¿Por Qué Usar Programación Reactiva?
1. **Eficiencia y Concurrencia**:
   * Permite aprovechar mejor los recursos, ya que las operaciones no se bloquean esperando una respuesta.


   * Es ideal para aplicaciones que manejan muchas operaciones concurrentes, como servidores que manejan múltiples solicitudes de usuarios simultáneamente.

2. **Manejo de Eventos**:
   * Se adapta bien a sistemas orientados a eventos donde los datos y eventos deben ser procesados a medida que ocurren, como sistemas de monitoreo o aplicaciones de tiempo real.

3. **Escalabilidad**:
   * Los sistemas construidos con programación reactiva pueden escalar mejor que las aplicaciones tradicionales basadas en hilos porque se gestionan eficientemente los recursos.

   * La programación reactiva se centra en manejar la carga de trabajo de manera eficiente sin bloquear los hilos, lo que permite que las aplicaciones escalen de forma más natural y económica.

## Patrón de Programación Reactiva:
1. **Proveer**: Se define un flujo de datos que puede ser continuo o finito.

2. **Suscribir**: Los componentes interesados se suscriben para recibir datos y eventos.

3. **Transformar**: Se pueden aplicar operadores para transformar los datos antes de que lleguen al consumidor.

4. **Procesar**: El consumidor reacciona a los datos a medida que se emiten.

5. **Finalizar**: Cuando el flujo de datos se completa, el sistema se cierra sin bloquear.