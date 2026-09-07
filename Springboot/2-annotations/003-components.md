## `@Component`, `@Repository`, `@Service`, `@Controller`
Estas anotaciones son estereotipos que indican a Spring que las clases anotadas son candidatos para ser administrados como **beans** dentro del contexto de la aplicación. Ayudan a definir el rol de un componente dentro de la arquitectura de la aplicación.

## `@Component`
es un estereotipo genérico para cualquier componente gestionado por Spring. Se utiliza para clases que no encajan en roles más específicos como `@Repository`, `@Service` o `@Controller`.

**Ejemplo**
```java
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}
```

## `@Repository`
se utiliza para marcar la clase en la capa de persistencia, que interactúa directamente con la base de datos. 

Se aplica a clases que acceden a la base de datos, como los Data Access Objects (DAOs).

`@Repository` proporciona una traducción automática de las excepciones específicas de la tecnología de persistencia a excepciones de Spring no verificadas (unchecked exceptions).

**Ejemplo**
```java
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
    public void save() {
        // lógica de persistencia
    }
}
```

## `@Service`
se utiliza para marcar las clases en la capa de servicio. Se aplica a clases que contienen la lógica de negocio. Esta anotación sirve como indicación de que la clase es un servicio.

**Ejemplo**
```java
import org.springframework.stereotype.Service;

@Service
public class MyService {
    public void performService() {
        System.out.println("Performing service...");
    }
}
```

## `@Controller`
se utiliza para marcar las clases en la capa de presentación.

Se aplica a clases que manejan solicitudes web (**HTTP**). Las clases anotadas con `@Controller` se utilizan junto con `@RequestMapping` para definir controladores web en aplicaciones Spring MVC.

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello, World!";
    }
}
```
**Diferencias y Usos Apropiados**
* `@Component`: Genérico, para cualquier componente de Spring.

* `@Repository`: Específico para la capa de persistencia, con beneficios adicionales de manejo de excepciones.

* `@Service`: Específico para la capa de servicio, contiene lógica de negocio.

* `@Controller`: Específico para la capa de presentación, maneja solicitudes web.

**Escaneo de Componentes**

Para que Spring registre automáticamente estas clases como beans, debes habilitar el escaneo de componentes:

**Ejemplo**
```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    // configuración adicional
}
```
**En este ejemplo:**
* `@ComponentScan` escaneará el paquete `com.example` y todos sus subpaquetes para encontrar clases anotadas con `@Component`, `@Repository`, `@Service` y `@Controller`.