# `ResponseEntity<T>`
Es una clase en Spring que permite construir y devolver respuestas HTTP personalizadas desde un controlador REST. A través de ResponseEntity, puedes definir el cuerpo de la respuesta, el código de estado HTTP, y los encabezados de manera flexible. Es especialmente útil cuando necesitas un control detallado sobre la respuesta HTTP, ya que encapsula la respuesta completa y permite devolver diferentes tipos de datos, encabezados y códigos de estado.

## ¿Qué es ResponseEntity<T>?
Es una clase genérica en Spring que representa la respuesta HTTP completa, incluyendo:

* Cuerpo de la respuesta (`T`): el contenido de la respuesta, que puede ser cualquier tipo de objeto.

* Código de estado HTTP: el estado de la respuesta (como 200 OK, 404 Not Found, etc.).

* Encabezados HTTP: cualquier encabezado HTTP adicional que quieras enviar (como Content-Type, Authorization, entre otros).

Es parte del paquete org.springframework.http y se utiliza para que los métodos del controlador REST devuelvan una respuesta personalizada.

## ¿Para qué sirve?
* Personalizar respuestas HTTP de manera controlada.

* Definir el contenido del cuerpo, código de estado y encabezados en las respuestas del controlador REST.

* Manejar respuestas de errores y excepciones con diferentes códigos de estado HTTP.

Por ejemplo, ResponseEntity te permite responder con un código 201 Created cuando se crea un recurso, o un 404 Not Found cuando el recurso no se encuentra, en lugar de devolver simplemente un código 200 OK.

## ¿Qué problemas resuelve?
ResponseEntity resuelve varios problemas de control en la devolución de respuestas HTTP:

* Permite manejar errores HTTP de manera clara y precisa: sin ResponseEntity, deberías manejar códigos de estado y encabezados manualmente, lo cual es menos intuitivo y aumenta la probabilidad de errores.

* Permite especificar encabezados adicionales: sin esta capacidad, se reduciría la flexibilidad en las respuestas, especialmente cuando se requiere incluir encabezados personalizados (por ejemplo, en autenticación o manejo de sesiones).

* Ofrece flexibilidad en la respuesta HTTP: se puede especificar si la respuesta debe incluir un cuerpo, qué contenido devolver, y cómo debería comportarse en diferentes situaciones.

## ¿Cómo lo resuelve?
ResponseEntity lo resuelve proporcionando una API para construir respuestas HTTP detalladas. Se puede construir usando su constructor o a través de sus métodos de fábrica estáticos, que permiten establecer tanto el cuerpo como los encabezados y el código de estado.

### Ejemplo básico de uso de ResponseEntity
Supongamos que estamos desarrollando un sistema para gestionar usuarios. Veamos cómo ResponseEntity puede mejorar la respuesta en el caso de la obtención de un usuario por su ID.
```java
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get()); // Retorna 200 OK con el cuerpo del usuario
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found sin cuerpo
        }
    }
}
```