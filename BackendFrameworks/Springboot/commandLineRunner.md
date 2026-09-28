¿Qué es CommandLineRunner?
CommandLineRunner es una interfaz funcional proporcionada por Spring Boot que permite ejecutar un bloque de código específico después de que la aplicación ha iniciado completamente, pero antes de que comience a aceptar solicitudes.

Es útil para ejecutar tareas personalizadas al inicio de la aplicación, como inicialización de datos, configuraciones específicas, o lógica de prueba.

## ¿Para qué sirve?
El objetivo principal de CommandLineRunner es ejecutar código inmediatamente después de que el contenedor de Spring (ApplicationContext) esté listo, pero antes de que la aplicación quede completamente operativa.

Usos comunes:
Inicialización de datos en una base de datos.
Configuración de recursos externos al iniciar la aplicación.
Ejecución de tareas administrativas o temporales.
Validación de configuraciones o dependencias necesarias para el arranque de la aplicación.

## ¿Qué resuelve?
CommandLineRunner simplifica la necesidad de ejecutar código al inicio de una aplicación Spring Boot sin tener que configurar manualmente escuchadores de eventos o métodos adicionales para el inicio del contenedor.

## ¿Cómo lo resuelve?
La interfaz CommandLineRunner define un único método:
```java
void run(String... args) throws Exception;
```
Cuando se implementa en un @Component, Spring Boot detecta automáticamente la clase y ejecuta el método run() después de que el contenedor esté listo. Además, permite recibir argumentos de línea de comandos si se especifican al ejecutar la aplicación.

## Características principales
Automáticamente detectado por Spring Boot:

Si una clase que implementa CommandLineRunner está marcada con @Component, será ejecutada automáticamente.
Admite múltiples implementaciones:

Si existen múltiples clases que implementan CommandLineRunner, todas serán ejecutadas en orden (puedes establecer el orden con @Order).
Acceso a argumentos de línea de comandos:

Los argumentos pasados al iniciar la aplicación (por ejemplo, java -jar app.jar arg1 arg2) están disponibles en el método run().

## Ejemplo básico de uso
```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("La aplicación ha iniciado correctamente.");
        for (String arg : args) {
            System.out.println("Argumento: " + arg);
        }
    }
}
```
Salida al ejecutar:
```bash
$ java -jar app.jar arg1 arg2
La aplicación ha iniciado correctamente.
Argumento: arg1
Argumento: arg2
```

## Control del orden de ejecución
Si tienes varias clases que implementan CommandLineRunner, puedes controlar el orden de ejecución usando la anotación @Order o implementando la interfaz Ordered.

# Ejemplo
```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class FirstRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Primero en ejecutarse.");
    }
}

@Component
@Order(2)
public class SecondRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Segundo en ejecutarse.");
    }
}

```

## Uso con inicialización de datos
Es común usar CommandLineRunner para inicializar datos en la base de datos al iniciar la aplicación.

Ejemplo:
```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("John", "Doe", "john.doe@example.com"));
        userRepository.save(new User("Jane", "Smith", "jane.smith@example.com"));
        System.out.println("Usuarios inicializados en la base de datos.");
    }
}
```

## Ventajas de CommandLineRunner
Fácil de usar y configurar: No requiere configuración adicional, Spring Boot lo detecta automáticamente.
Ideal para lógica de inicialización: Permite ejecutar código antes de que la aplicación quede completamente operativa.
Soporte para múltiples runners: Puedes dividir tareas en diferentes CommandLineRunner y controlarlas fácilmente.

## Diferencias con ApplicationRunner
ApplicationRunner es otra interfaz en Spring Boot que también se usa para ejecutar código al inicio de la aplicación. La principal diferencia es que ApplicationRunner proporciona acceso a un objeto ApplicationArguments en lugar de un arreglo de String:
```java
public interface ApplicationRunner {
    void run(ApplicationArguments args) throws Exception;
}
```
Ventaja de ApplicationRunner:

ApplicationArguments permite trabajar con los argumentos de línea de comandos de manera más estructurada, separando los argumentos opcionales y no opcionales.

Ejemplo
```java
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Aplicación iniciada con ApplicationRunner.");
        System.out.println("Opcionales: " + args.getOptionNames());
    }
}
```

## Casos de uso recomendados
Configuración inicial:

Establecer propiedades, verificar dependencias externas o inicializar servicios al inicio.
Carga de datos en la base de datos:

Insertar datos iniciales en la base de datos (útil en entornos de desarrollo o prueba).
Lógica temporal:

Ejecutar código específico de forma temporal, como migraciones de datos o configuraciones iniciales.

## Buenas prácticas al usar CommandLineRunner
Evitar lógica compleja:

No coloques lógica de negocio extensa; mejor delega a servicios o componentes externos.
Usa @Order si tienes varios runners:

Define claramente el orden de ejecución para evitar dependencias no deseadas.
Hazlo reutilizable:

Si el código necesita ejecutarse varias veces en diferentes contextos, considera separarlo en un servicio.