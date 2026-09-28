Executor Service
Future
# `Callable<>`
`Callable<V>` es una interfaz genérica en Java que representa una tarea que puede ser ejecutada por un hilo y que devuelve un resultado o puede lanzar una excepción. Esta interfaz es similar a **Runnable**, pero con la diferencia clave de que **Callable** puede devolver un valor genérico (`V`) y lanzar excepciones comprobadas (**checked exceptions**).

**Definición de la interfaz**
```java
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
```
* **Método principal**: `call()`, que devuelve un valor de tipo `V` y puede lanzar excepciones comprobadas.

## ¿Para qué sirve?
**Callable** se utiliza cuando necesitas que una tarea concurrente devuelva un resultado después de su ejecución. A diferencia de **Runnable**, que solo ejecuta una tarea sin retornar ningún valor, **Callable** permite realizar operaciones más complejas que deben devolver un valor o que pueden fallar y lanzar excepciones.


## ¿Qué resuelve?
Callable resuelve el problema de ejecutar tareas que necesitan devolver un resultado o que pueden fallar durante su ejecución y **lanzar excepciones comprobadas**. Esto es útil cuando necesitas realizar cálculos o tareas en segundo plano y, al finalizar, necesitas el resultado de esa operación.

## ¿Cómo lo resuelve?
**Callable** lo resuelve proporcionando el método `call()`, que te permite escribir el código para la tarea y especificar el tipo de resultado que retornará al finalizar. Luego, el resultado de Callable se puede obtener utilizando futuros (**Future**), lo que te permite gestionar la ejecución de manera asincrónica.

A diferencia de **Runnable**, que no puede devolver ningún valor ni lanzar excepciones comprobadas, **Callable** tiene un mayor control sobre la ejecución y los resultados de las tareas.

## Ejemplo básico de Callable:
```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EjemploCallable {

    public static void main(String[] args) {
        // Crear un executor service para manejar los hilos
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // Crear una instancia de Callable
        Callable<Integer> tarea = () -> {
            // Simular una tarea larga
            Thread.sleep(2000);  // Simular espera
            return 42;  // Retornar el resultado de la tarea
        };

        // Enviar la tarea al executor y recibir un Future que contiene el resultado
        Future<Integer> resultado = executor.submit(tarea);

        try {
            // Obtener el resultado de la tarea (bloquea hasta que la tarea se complete)
            System.out.println("Resultado de la tarea: " + resultado.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Apagar el executor
            executor.shutdown();
        }
    }
}
```
**Salida esperada**
```plaintext
Resultado de la tarea: 42
```
En este ejemplo:

* Se crea una instancia de `Callable<Integer>` que simula una tarea larga (2 segundos de espera) y luego retorna el número 42.

* Se utiliza un `ExecutorService` para gestionar los hilos y se envía la tarea utilizando `submit()`.

* El `Future` que devuelve `submit()` se usa para recuperar el resultado de la tarea una vez que se ha completado.

## ¿Qué es `Future<V>`?
* `Future<V>` es una clase que representa el resultado futuro de una tarea que puede completarse en algún momento.

* Puedes usar `Future` para consultar si la tarea ya se completó, obtener el resultado (bloquea el hilo principal si la tarea aún no ha terminado) o incluso cancelar la tarea.

## Ejemplo con múltiples tareas Callable
A continuación, te muestro un ejemplo en el que se ejecutan varias tareas Callable y se obtienen sus resultados de manera asincrónica:

```java
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EjemploMultipleCallable {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Crear una lista de tareas Callable
        List<Callable<Integer>> tareas = Arrays.asList(
                () -> {
                    Thread.sleep(1000);
                    return 1;
                },
                () -> {
                    Thread.sleep(2000);
                    return 2;
                },
                () -> {
                    Thread.sleep(3000);
                    return 3;
                }
        );

        try {
            // Ejecutar todas las tareas y obtener los Futuros
            List<Future<Integer>> resultados = executor.invokeAll(tareas);

            // Imprimir los resultados de las tareas
            for (Future<Integer> resultado : resultados) {
                System.out.println("Resultado de la tarea: " + resultado.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
```
**Salida esperada**
```plaintext
Resultado de la tarea: 1
Resultado de la tarea: 2
Resultado de la tarea: 3
```
En este ejemplo, las tres tareas se ejecutan en paralelo en diferentes hilos, y se obtienen sus resultados a través de `Future.get()`.

## Beneficios de Callable:
1. **Devolución de resultados**: A diferencia de Runnable, Callable permite devolver un valor cuando la tarea se completa, lo que es esencial para tareas que producen resultados.

2. **Gestión de excepciones**: Callable permite manejar excepciones comprobadas, lo que lo hace más adecuado para tareas complejas que pueden fallar.

3. **Soporte para programación concurrente**: Se puede usar con Future y ExecutorService para gestionar la ejecución concurrente de múltiples tareas y obtener los resultados de manera asincrónica.

## Casos de uso en aplicaciones del mundo real:
1. **Cálculos complejos**: Para tareas que requieren realizar cálculos matemáticos o procesamiento intensivo en segundo plano.

2. **Operaciones de entrada/salida**: Para operaciones que requieren la lectura de datos, como leer archivos grandes o realizar consultas a bases de datos.

3. **Tareas concurrentes**: Cuando necesitas ejecutar varias tareas al mismo tiempo y combinar sus resultados al finalizar.