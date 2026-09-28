La anotación @RequiredArgsConstructor es una de las principales anotaciones proporcionadas por Lombok, diseñada para facilitar la creación de constructores en clases donde existen atributos finales (final) o atributos anotados con @NonNull. Es particularmente útil para reducir el código boilerplate y mejorar la legibilidad.

¿Qué es @RequiredArgsConstructor?
Es una anotación de Lombok que genera automáticamente un constructor con todos los campos requeridos de una clase, es decir:

Campos marcados como final.
Campos marcados con la anotación @NonNull.
Los demás atributos de la clase que no cumplen con estas condiciones no serán incluidos en el constructor generado.

¿Para qué sirve?
Sirve para simplificar la creación de constructores que solo deben inicializar los atributos esenciales (required arguments) de una clase. Esto es especialmente útil cuando trabajas con:

Clases inmutables (aquellas donde los atributos no pueden ser modificados después de ser establecidos en el constructor).
Inyección de dependencias en frameworks como Spring, donde se requiere un constructor que reciba los objetos necesarios para inicializar la clase.

Características de @RequiredArgsConstructor
Generación automática de constructores:

Crea un constructor con los argumentos necesarios para inicializar los campos marcados como final o @NonNull.
Compatibilidad con Spring y otros frameworks:

Se utiliza comúnmente para facilitar la inyección de dependencias a través del constructor.
Opcionalidad de atributos:

Solo incluye en el constructor los atributos marcados como final o @NonNull. Los demás atributos son ignorados.
Compatibilidad con inmutabilidad:

Es ideal para clases inmutables porque garantiza que los campos final se inicialicen solo una vez.
Interacción con otras anotaciones de Lombok:

Se complementa bien con anotaciones como @Data o @Getter para reducir aún más el código repetitivo.
No genera un constructor por defecto:

Si no hay campos final o @NonNull, no se generará ningún constructor.

¿Qué resuelve?
Eliminación del código repetitivo:

Evita escribir manualmente un constructor que inicialice solo los campos obligatorios, lo que mejora la legibilidad del código.
Facilita el trabajo con inyección de dependencias:

En frameworks como Spring, simplifica la configuración de clases al eliminar la necesidad de escribir un constructor explícito.
Evita errores humanos:

Asegura que todos los campos requeridos sean inicializados correctamente, reduciendo el riesgo de omisiones o errores en el código.

¿Cómo lo resuelve?
Análisis de los atributos de la clase:

Lombok identifica automáticamente los campos marcados como final o @NonNull durante la compilación.
Generación del constructor necesario:

Lombok genera un constructor con los parámetros necesarios para inicializar esos campos.
Validación de @NonNull:

Para campos marcados como @NonNull, Lombok genera verificaciones automáticas para asegurarse de que no se les pase un valor nulo.

## Ejemplo básico
Código sin Lombok:
```java
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }
}
```
Código con @RequiredArgsConstructor:
```java
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;
}
```
Qué hace Lombok aquí: Genera automáticamente el siguiente constructor:
```java
public UserService(UserRepository userRepository, NotificationService notificationService) {
    this.userRepository = userRepository;
    this.notificationService = notificationService;
}
```

## Ejemplo con @NonNull
Código sin Lombok:
```java
public class ProductService {
    private final ProductRepository productRepository;
    private String serviceName;

    public ProductService(ProductRepository productRepository) {
        if (productRepository == null) {
            throw new NullPointerException("productRepository is marked @NonNull but is null");
        }
        this.productRepository = productRepository;
    }
}
```
Código con @RequiredArgsConstructor y @NonNull:
```java
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {
    @NonNull
    private final ProductRepository productRepository;
    private String serviceName; // No se incluye en el constructor
}
```
Qué hace Lombok aquí:
Genera un constructor similar al anterior, incluyendo una validación automática para evitar que productRepository sea null.

Buenas prácticas al usar @RequiredArgsConstructor
Usar final para atributos que son obligatorios:

Esto garantiza que el constructor generado incluya esos campos y refuerza el concepto de inmutabilidad.
Usar junto con @NonNull cuando un campo no puede ser null:

Esto asegura que Lombok genere validaciones automáticas.
Evitar mezclar lógica en los constructores generados:

Si necesitas lógica adicional en el constructor, es mejor escribirlo manualmente.
Documentar atributos importantes:

Aunque @RequiredArgsConstructor reduce el código, asegúrate de que los atributos obligatorios estén bien documentados en la clase.
Usarlo con frameworks que soporten inyección de dependencias:

Es particularmente útil en Spring para la configuración de servicios o controladores.
