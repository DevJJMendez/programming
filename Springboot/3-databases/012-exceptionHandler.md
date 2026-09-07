## @ExceptionHandler
Se utiliza para manejar excepciones específicas en los métodos de los controladores. Proporciona una forma centralizada de gestionar excepciones y puede ser utilizada para personalizar las respuestas de error cuando ocurren excepciones durante la ejecución de un controlador.

Indica que un método en un controlador debe manejar una excepción específica. Cuando una excepción del tipo indicado ocurre en el ámbito de un controlador, el método anotado con `@ExceptionHandler` se invocará automáticamente para manejar esa excepción.

### Uso Básico de @ExceptionHandler
Debes definir un método en tu controlador que maneje la excepción específica. Ejemplo básico:

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class MyController {

    @GetMapping("/example")
    public String example() {
        // Simulando una excepción
        if (true) {
            throw new IllegalArgumentException("Argumento no válido");
        }
        return "Ejemplo exitoso";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
```
En este ejemplo:

* El método `example()` lanza una `IllegalArgumentException` de manera deliberada.

* El método `handleIllegalArgumentException` está anotado con `@ExceptionHandler` para manejar `IllegalArgumentException`.

* Cuando se lanza `IllegalArgumentException`, Spring invoca automáticamente el método `handleIllegalArgumentException`, que devuelve una respuesta con un estado **HTTP 400 (Bad Request)** y el mensaje de la excepción.

## @ControllerAdvice
`@ControllerAdvice` es una especialización de la anotación @Component, que permite declarar un componente de Spring que puede actuar como un asesor para controladores. Esto significa que cualquier lógica definida en una clase anotada con @ControllerAdvice se aplicará a los controladores en toda la aplicación.

La anotación `@ControllerAdvice` en Spring Framework es una poderosa herramienta para manejar excepciones de manera global en una aplicación. Permite definir lógica de manejo de excepciones que se aplica a múltiples controladores, centralizando el manejo de errores y haciendo que el código sea más mantenible y limpio.

### Uso Básico de @ControllerAdvice
La anotación `@ControllerAdvice` se utiliza en combinación con la anotación `@ExceptionHandler` para manejar excepciones globalmente. También puede utilizarse para otras tareas, como la adición de atributos modelo a todas las vistas y la configuración de manipuladores de datos de inicio y fin.

## Rest Global Exception Handling
REST Global Exception Handling permite manejar excepciones de manera centralizada para todos los controladores de la aplicación. Esto se puede lograr utilizando la anotación `@ControllerAdvice` junto con `@ExceptionHandler`.

### Ejemplo Básico

**POJO Class**
```java
public class ErrorResponse {
    private String message;
    private int status;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    // Getters y setters
}
```
**Clase Global Exception Handler:**
```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Otros métodos para manejar diferentes excepciones
}
```
En este ejemplo:

* `GlobalExceptionHandler` está anotado con `@ControllerAdvice`, lo que lo convierte en un asesor para todos los controladores.

* `handleIllegalArgumentException()` maneja `IllegalArgumentException` y devuelve una respuesta con un estado HTTP 400.

* `handleGeneralException()` maneja cualquier otra excepción genérica y devuelve una respuesta con un estado HTTP 500 (Internal Server Error).

## Rest Exception Handling
Rest Exception Handling se refiere a la captura y manejo de excepciones dentro de un controlador específico. Esto se puede lograr utilizando la anotación `@ExceptionHandler` en los métodos del controlador para manejar excepciones específicas.

Manejar excepciones en aplicaciones RESTful es crucial para garantizar que las API respondan adecuadamente a los errores y proporcionen información útil a los clientes.

### Ejemplo Básico

**POJO Class**
```java
public class ErrorResponse {
    private String message;
    private int status;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    // Getters y setters
}
```

**Controlador con Manejo de Excepciones:**

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        
        // Simular una excepción si el usuario no se encuentra
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID de usuario no válido");
        }

        // Código para obtener el usuario por ID
        User user = new User(); // Simulación de un usuario
        return user;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Otros métodos del controlador
}
```
En este ejemplo:

* `getUser()` lanza una IllegalArgumentException si el ID del usuario no es válido.

* `handleIllegalArgumentException()` maneja esta excepción y devuelve una respuesta adecuada con un mensaje de error y el estado HTTP 400 (Bad Request).

## Response Entity
Es una clase en Spring que representa una respuesta HTTP completa, incluyendo el cuerpo de la respuesta, los encabezados y el estado HTTP. Es una forma poderosa y flexible de controlar la respuesta que se envía al cliente desde un controlador.

`ResponseEntity<T>` es una clase genérica que hereda de HttpEntity y se utiliza para construir respuestas HTTP en controladores Spring. Permite configurar no solo el cuerpo de la respuesta, sino también los encabezados HTTP y el código de estado.

