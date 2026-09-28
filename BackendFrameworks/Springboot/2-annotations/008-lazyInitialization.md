# `@Lazy`
La Lazy Initialization (inicialización perezosa) es un patrón de diseño en el cual la creación o inicialización de un objeto se retrasa hasta el momento en que se necesita por primera vez. En el contexto de Spring Framework, la inicialización perezosa puede ayudar a mejorar el rendimiento y a reducir el consumo de memoria al cargar solo los **Beans** que son necesarios.

**Ventajas de Lazy Initialization**
1. **Mejora del rendimiento**:

   * Reduce el tiempo de arranque de la aplicación al cargar solo los beans necesarios.

   * Útil en aplicaciones grandes con muchos **Beans** definidos.

2. **Ahorro de memoria**:

   * Evita la creación de objetos innecesarios que no se utilizan durante el ciclo de vida de la aplicación.

3. **Optimización de recursos**:

   * Especialmente beneficioso en entornos con recursos limitados, como aplicaciones desplegadas en la nube.


## Configuración de Lazy Initialization en Spring
La anotación `@Lazy` se puede utilizar en varios contextos:

1. **A nivel de clase**:Cuando se aplica a una clase anotada con `@Component`, `@Service`, `@Repository`, `@Controller`, etc., se indica que el **Bean** debe ser inicializado de manera perezosa.

```java
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
    public class MyLazyService {
        public MyLazyService() {
            System.out.println("MyLazyService initialized");
    }

    public void performService() {
            System.out.println("Service performed");
    }
}
```

1. **A nivel de método**: Cuando se aplica a un método de fábrica de **Beans** en una clase de configuración, se indica que el bean debe ser inicializado de manera perezosa.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

    @Configuration
    public class AppConfig {

        @Bean
        @Lazy
        public MyLazyService myLazyService() {
            return new MyLazyService();
        }
}
```

3. **Inyección perezosa**: Cuando se aplica a una dependencia inyectada, se indica que la dependencia debe ser inicializada de manera perezosa.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

    @Component
    public class MyComponent {

        private final MyLazyService myLazyService;

        @Autowired
        public MyComponent(@Lazy MyLazyService myLazyService) {
            this.myLazyService = myLazyService;
                System.out.println("MyComponent initialized");
        }

    public void useService() {
            myLazyService.performService();
        }
}
```

## Configuracion Global
Puedes configurar la inicialización perezosa (lazy initialization) globalmente a través del archivo `application.properties` o `application.yml`. Esto permite que todos los Beans de la aplicación sean creados de manera perezosa, excepto aquellos que explícitamente se configuren para ser creados de inmediato.

### Configuración de Lazy Initialization en `application.properties`
Para habilitar la inicialización perezosa globalmente, puedes agregar la siguiente propiedad en tu archivo `application.properties`:

```java
spring.main.lazy-initialization=true
```
Esta configuración asegura que todos los beans serán creados de manera perezosa por defecto. Esto puede ser especialmente útil en aplicaciones grandes donde el tiempo de inicio es crítico y muchos **Beans** no se utilizan inmediatamente.

### Configuración de Lazy Initialization en application.yml
De manera similar, puedes configurar la inicialización perezosa en un archivo `application.yml`:

```yml
spring:
  main:
    lazy-initialization: true
```