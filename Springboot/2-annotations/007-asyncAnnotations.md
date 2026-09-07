# `@EnableAsync`
La anotación `@EnableAsync` habilita la ejecución asincrónica de métodos. Permite que los métodos anotados con `@Async` se ejecuten de forma asincrónica en un hilo separado.

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Async;

@Configuration
@EnableAsync
public class AsyncConfig {
    
    @Async
    public void asyncMethod() {
        System.out.println("Método asíncrono ejecutado");
    }
}
```

## `@EnableCaching`
La anotación `@EnableCaching` habilita la funcionalidad de caché en Spring. Permite el uso de anotaciones de caché como `@Cacheable`, `@CachePut` y `@CacheEvict`.

```java
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {
    // Configuración de caché
}
```

## `@Async`
se utiliza para marcar métodos que deben ejecutarse de manera asincrónica, es decir, en un hilo separado del hilo principal de la aplicación. Esto es útil para mejorar el rendimiento y la capacidad de respuesta de las aplicaciones al permitir que tareas de larga duración se ejecuten en segundo plano.

Cuando un método anotado con `@Async` se invoca, Spring crea un nuevo hilo y ejecuta el método en ese hilo en lugar de en el hilo de la solicitud principal.

**Configuración para Habilitar Asincronía**, Para usar `@Async`, primero necesitas habilitar el soporte de ejecución asincrónica en tu configuración de Spring mediante la anotación `@EnableAsync`.

**Ejemplo**
```java
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AsyncConfig {
    // Configuración adicional si es necesario
}
```
**Uso de `@Async`**

Una vez que has habilitado la asincronía, puedes anotar cualquier método con `@Async` para que se ejecute en un hilo separado.

**Ejemplo Básico**
```java
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void executeAsyncTask() {
        System.out.println("Ejecutando tarea asincrónica: " + Thread.currentThread().getName());
    }
}
```
**En este ejemplo:**
* `executeAsyncTask` se ejecutará en un hilo diferente al hilo principal de la aplicación.

**Devolviendo Resultados Asincrónicos**, Puedes hacer que un método asincrónico devuelva un `Future` o `CompletableFuture` para obtener el resultado de la operación asincrónica.

**Ejemplo con `CompletableFuture`**
```java
import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public CompletableFuture<String> asyncMethodWithReturn() {
        try {
            // Simular una operación de larga duración
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Resultado de la tarea asincrónica");
    }
}
```
**En este ejemplo:**
* `asyncMethodWithReturn` devuelve un CompletableFuture que se completará con el resultado de la operación asincrónica.

**Manejo de Excepciones**
Si un método anotado con `@Async` lanza una excepción, puedes manejarla utilizando el `CompletableFuture` o un `AsyncUncaughtExceptionHandler`.

**Ejemplo con `AsyncUncaughtExceptionHandler`**
```java
import java.lang.reflect.Method;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }

    class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
            System.err.println("Excepción capturada en el método asincrónico: " + method.getName());
            throwable.printStackTrace();
        }
    }
}
```
**En este ejemplo:**
* `CustomAsyncExceptionHandler` maneja las excepciones lanzadas por métodos asincrónicos que no devuelven un Future.