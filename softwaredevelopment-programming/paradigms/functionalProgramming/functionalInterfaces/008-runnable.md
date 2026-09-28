# `Runnable`
**Runnable** es una interfaz funcional en Java que representa una tarea que puede ser ejecutada por un hilo (**thread**). La interfaz tiene un solo método abstracto, `run()`, que define el código que debe ejecutarse cuando el hilo se inicia.

**Definición de la interfaz**
```java
@FunctionalInterface
public interface Runnable {
    void run();
}
```

## ¿Para qué sirve?
**Runnable** es utilizado principalmente para definir el código que debe ejecutarse en paralelo o en segundo plano mediante un hilo. Sirve para separar la tarea de la ejecución, es decir, te permite definir la lógica de una tarea sin preocuparte de cómo y cuándo será ejecutada. Luego, esta tarea puede ser ejecutada en un hilo.

## ¿Qué resuelve?
**Runnable** resuelve el problema de la **concurrencia** y **paralelismo** en Java, al proporcionar una forma sencilla de definir y ejecutar tareas en hilos independientes. Al implementar **Runnable**, puedes permitir que tu programa realice múltiples tareas simultáneamente, lo que puede mejorar la eficiencia y el rendimiento en programas que requieren realizar muchas operaciones al mismo tiempo.

## ¿Cómo lo resuelve?
La interfaz **Runnable** resuelve este problema al permitirte encapsular una tarea dentro del método `run()`. Luego, puedes pasar una instancia de **Runnable** a un objeto **Thread**, que es el encargado de ejecutar la tarea en un hilo separado.

Esto proporciona una abstracción clara entre la tarea (la lógica del código en `run()`) y el mecanismo de ejecución (cómo se ejecuta el hilo).

## Uso de Runnable
A continuación, te muestro cómo puedes crear y ejecutar un hilo usando **Runnable**:

**Ejemplo**
```java
public class EjemploRunnable implements Runnable {

    @Override
    public void run() {
        // Código que se ejecutará en un hilo separado
        for (int i = 1; i <= 5; i++) {
            System.out.println("Ejecutando hilo: " + i);
            try {
                Thread.sleep(1000);  // Pausa de 1 segundo entre cada iteración
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        }
    }

    public static void main(String[] args) {
        // Crear una instancia de la clase que implementa Runnable
        EjemploRunnable runnable = new EjemploRunnable();

        // Crear un nuevo hilo que ejecutará el código de Runnable
        Thread hilo = new Thread(runnable);

        // Iniciar el hilo
        hilo.start();
    }
}
```
**Salida esperada**
```plaintext
Ejecutando hilo: 1
Ejecutando hilo: 2
Ejecutando hilo: 3
Ejecutando hilo: 4
Ejecutando hilo: 5
```
En este ejemplo, la clase **EjemploRunnable** implementa **Runnable** y define el código que se ejecutará en el método `run()`. Luego, en el `main()`, se crea un nuevo **hilo (Thread)** y se le pasa la instancia de Runnable. Al llamar a `start()`, se inicia el hilo y se ejecuta el código en `run()` en paralelo al hilo principal.

## Beneficios de Runnable
1. **Separación de responsabilidades**: La lógica de la tarea y la gestión de la ejecución (el hilo) están separadas, lo que permite un código más modular y reutilizable.

2. **Concurrencia**: Permite ejecutar varias tareas al mismo tiempo, mejorando el rendimiento de las aplicaciones, especialmente en escenarios donde hay operaciones bloqueantes (como operaciones de entrada/salida).

3. **Flexibilidad**: Runnable no obliga a que una clase extienda **Thread**, lo cual es útil porque en Java no se puede heredar de múltiples clases.

## Ejemplo con expresión Lambda
Dado que Runnable es una interfaz funcional (solo tiene un método abstracto), también se puede utilizar con expresiones lambda para reducir el código boilerplate y hacerlo más legible. Aquí te muestro cómo hacerlo:

```java
public class EjemploRunnableLambda {
    public static void main(String[] args) {
        // Crear un Runnable usando una expresión lambda
        Runnable runnable = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hilo con lambda: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }
            }
        };

        // Crear un nuevo hilo con el Runnable
        Thread hilo = new Thread(runnable);

        // Iniciar el hilo
        hilo.start();
    }
}
```
**Salida esperada:**
```plaintext
Hilo con lambda: 1
Hilo con lambda: 2
Hilo con lambda: 3
Hilo con lambda: 4
Hilo con lambda: 5
```
En este ejemplo, el uso de una expresión lambda simplifica la implementación de **Runnable**.

## Comparación con Callable
Otra interfaz funcional similar a Runnable es `Callable<V>`, pero la principal diferencia es que:

* **Runnable** no devuelve ningún valor, mientras que `Callable<V>` devuelve un valor de tipo `V`.

* **Runnable** no puede lanzar excepciones comprobadas, mientras que `Callable<V>` puede lanzar cualquier excepción.

Si necesitas que el hilo devuelva un resultado, es mejor usar **Callable** en lugar de **Runnable**.