# Global Exception Handler
El `GlobalExceptionHandler` es una clase especial en aplicaciones Spring que se utiliza para manejar de manera centralizada todas las excepciones que se producen durante la ejecución de las solicitudes. Permite capturar errores y responder de manera uniforme sin tener que manejar cada excepción en cada controlador individualmente. 

## ¿Qué es el `GlobalExceptionHandler`?
Es una clase que actúa como un manejador centralizado de excepciones para los controladores de una aplicación Spring. Se define utilizando la anotación `@ControllerAdvice`, que permite interceptar y gestionar excepciones lanzadas en cualquier parte de los controladores o servicios de la aplicación.

El GlobalExceptionHandler suele ubicarse en un paquete como:
```bash
src/main/java
└── com
    └── example
        ├── controller        # Controladores (Controllers)
        ├── exception         # Manejadores de excepciones (Exception Handlers)
        ├── service           # Servicios (Services)
        ├── repository        # Repositorios (Repositories)
        ├── dto               # Clases DTO
        ├── model             # Entidades del modelo (Entities)
        └── config            # Configuraciones (e.g., Security, Swagger, etc.)

src/main/java
└── com
    └── example
        ├── controller
        │   └── UserController.java
        ├── exception
        │   ├── GlobalExceptionHandler.java    # Manejador global de excepciones
        │   ├── EntityNotFoundException.java   # Excepción personalizada
        │   ├── BadRequestException.java       # Excepción personalizada
        │   └── ErrorResponse.java             # Clase para estructurar respuestas de error
        ├── service
        │   └── UserService.java
        ├── repository
        │   └── UserRepository.java
        ├── model
        │   └── User.java
        └── dto
            └── UserDTO.java
```
Detalles del paquete exception
Dentro del paquete exception, puedes incluir las siguientes clases relacionadas con el manejo de excepciones:

GlobalExceptionHandler: Para capturar y gestionar todas las excepciones de manera centralizada.
Clases personalizadas de excepciones: Para definir excepciones específicas de tu dominio, como:
EntityNotFoundException
BadRequestException
ConflictException
Modelos para respuesta de error: Una clase como ErrorResponse para estructurar los errores que se envían al cliente.
## ¿Para qué sirve?
El `GlobalExceptionHandler` sirve para:

* Centralizar el manejo de errores en un solo lugar.
* Mejorar la consistencia de las respuestas de error de la API REST.
* Reducir la repetición de código en los controladores.
* Proveer respuestas detalladas o personalizadas a los clientes sobre los errores ocurridos.

**Lo ideal es tener un único GlobalExceptionHandler que gestione de forma centralizada las excepciones.**

Caso 2: Múltiples GlobalExceptionHandler (Escenarios avanzados)
En casos más complejos, podrías dividir los manejadores según contextos o dominios específicos.

Escenarios donde usar más de un manejador puede ser útil:
Múltiples módulos o microservicios:

Si la aplicación es modular o basada en microservicios, cada módulo o servicio puede tener su propio GlobalExceptionHandler dedicado.
Ejemplo:
Módulo de usuarios tiene su manejador.
Módulo de pagos tiene otro.
Separación por capas o responsabilidades:

Podrías tener un manejador dedicado para excepciones de API (RestController) y otro para manejar excepciones internas en servicios o repositorios. Esto es poco común pero válido en sistemas con alta especialización.
Manejo específico para integraciones externas:

Por ejemplo, si tienes excepciones específicas para interactuar con APIs de terceros o servicios externos, puedes crear un manejador global solo para esa funcionalidad.

Ejemplo de jerarquía con varios manejadores:
```bash
src/main/java
└── com
    └── example
        ├── exception
        │   ├── GlobalExceptionHandler.java              # General
        │   ├── UserExceptionHandler.java               # Manejador para usuarios
        │   ├── PaymentExceptionHandler.java            # Manejador para pagos
        │   ├── ExternalIntegrationExceptionHandler.java # Manejador para servicios externos
        │   ├── exceptions
        │   │   ├── EntityNotFoundException.java
        │   │   ├── BadRequestException.java
        │   │   └── ExternalServiceException.java
```
## ¿Qué problemas resuelve?
* Código repetitivo: Evita manejar excepciones en cada método de los controladores, centralizando la lógica de manejo de errores.
* Falta de consistencia: Sin un `GlobalExceptionHandler`, cada controlador podría devolver respuestas de error con formatos diferentes.
* Dificultad de depuración: Al centralizar el manejo de excepciones, es más fácil rastrear dónde se están generando errores.
* Mejora en la experiencia del cliente: Provee respuestas claras y específicas cuando ocurren errores.

## ¿Cómo lo resuelve?
Lo resuelve interceptando todas las excepciones lanzadas durante el procesamiento de una solicitud y gestionándolas en métodos dedicados. Cada método del `GlobalExceptionHandler` está diseñado para manejar un tipo específico de excepción y devolver una respuesta adecuada.

Por ejemplo:
* Si ocurre una excepción de tipo `EntityNotFoundException`, puede devolver un código HTTP 404 con un mensaje descriptivo.
* Si ocurre una excepción general, puede devolver un código HTTP 500 con un mensaje genérico.

## Implementación Básica del GlobalExceptionHandler
Ejemplo básico
```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }
}
```
Explicación
1. @ControllerAdvice: Marca esta clase como el manejador global de excepciones.
2. @ExceptionHandler: Se utiliza para especificar el tipo de excepción que maneja cada método.
3. Respuesta personalizada: Los métodos devuelven un ResponseEntity con un código HTTP adecuado y un mensaje descriptivo.

### Mejora Avanzada con una Clase de Respuesta Estandarizada
Para mayor consistencia en las respuestas, puedes crear una clase dedicada para estructurar los mensajes de error.

Clase de respuesta personalizada
```java
public class ErrorResponse {
    private String message;
    private int status;
    private String timestamp;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    // Getters y setters
}
```

GlobalExceptionHandler actualizado
```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
```

### Manejo de Excepciones Personalizadas
En aplicaciones robustas, es común crear excepciones personalizadas para manejar errores específicos.

Ejemplo de excepción personalizada
```java
public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
```
Manejo en el GlobalExceptionHandler
```java
@ExceptionHandler(InvalidInputException.class)
public ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException ex) {
    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
}
```

### Usando Validaciones con @Valid y @ExceptionHandler
Si usas validaciones con @Valid en tus controladores, puedes manejar errores de validación en el GlobalExceptionHandler.

Ejemplo en el controlador
```java
@PostMapping("/save")
public ResponseEntity<String> saveCategory(@Valid @RequestBody Category category) {
    categoryService.saveCategory(category);
    return ResponseEntity.status(HttpStatus.CREATED).body("Category created");
}
```
Manejo de errores de validación
```java
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
    StringBuilder message = new StringBuilder("Validation failed: ");
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
        message.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
    }
    ErrorResponse errorResponse = new ErrorResponse(message.toString(), HttpStatus.BAD_REQUEST.value());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
}
```

## Ejemplo Completo de GlobalExceptionHandler
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder message = new StringBuilder("Validation failed: ");
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            message.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
        }
        ErrorResponse errorResponse = new ErrorResponse(message.toString(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
```