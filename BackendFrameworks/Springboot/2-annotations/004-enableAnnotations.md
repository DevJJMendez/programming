# `@Enable`
Las anotaciones `@Enable` son un grupo de anotaciones en Spring que se utilizan para habilitar características específicas. Estas anotaciones generalmente se aplican a las clases de configuración y permiten activar diversas capacidades de Spring sin necesidad de configuraciones manuales detalladas.

## `@EnableAutoConfiguration`
Se utiliza en aplicaciones Spring Boot para habilitar la configuración automática basada en las dependencias presentes en el **classpath**.
```java
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```
`@SpringBootApplication` incluye `@EnableAutoConfiguration`, lo que permite a Spring Boot configurar automáticamente la aplicación.

## `@EnableWebMvc`
Habilita la configuración de Spring MVC. Se utiliza para personalizar la configuración de Spring MVC y es equivalente a `<mvc:annotation-driven>` en la configuración XML.
```java
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    // Configuración personalizada de Spring MVC
}
```

## `@EnableScheduling`
Habilita la programación de tareas en Spring. Permite la creación de tareas programadas utilizando la anotación `@Scheduled`.
```java
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {
    
    @Scheduled(fixedRate = 5000)
    public void scheduleTask() {
        System.out.println("Tarea programada ejecutada cada 5 segundos");
    }
}
```