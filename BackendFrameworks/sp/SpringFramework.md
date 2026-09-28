# Spring Framework
Spring es un framework para el desarrollo de aplicaciones Java. Proporciona una infraestructura completa para desarrollar aplicaciones empresariales robustas y de alto rendimiento.

**Caracteristicas**
1. **Inversión de Control (IoC)**: Gestiona la creación y el ciclo de vida de los objetos, promoviendo una mayor flexibilidad y facilidad de prueba.

2. **Programación Orientada a Aspectos (AOP)**: Permite la separación de preocupaciones transversales como la gestión de transacciones, la seguridad y el logging.

3. **Acceso a Datos**: Ofrece soporte para JDBC, JPA, Hibernate y otros, simplificando la interacción con bases de datos.

4. **Transacciones Declarativas**: Maneja transacciones de manera declarativa, sin necesidad de escribir código adicional.

5. **Integración con Otros Marcos**: Soporta la integración con otros marcos y tecnologías, como JPA, JMS, y servicios web.

## Estructura
La estructura del Spring Framework es modular, lo que permite a los desarrolladores utilizar solo los componentes que necesitan.

1. **Core Container**
   * `spring-core`: Contiene las clases y utilidades fundamentales del framework, incluyendo el contenedor de **inversión de control** (**IoC**).
   
   * `spring-beans`: Proporciona las clases de configuración de beans y las funcionalidades de acceso a estos.
   
   * `spring-context`: Extiende las capacidades del módulo spring-beans, ofreciendo soporte para la **programación orientada a aspectos** (**AOP**), el acceso a recursos y la internacionalización (i18n).
   
   * `spring-context-support`: Proporciona soporte adicional para el módulo **spring-context**.

2. **AOP (Aspect-Oriented Programming)**
   * `spring-aop`: Soporte para la programación orientada a aspectos, permitiendo la implementación de aspectos transversales como transacciones y seguridad.

   * `spring-aspects`: Integración con AspectJ para el uso de aspectos declarativos y más potentes.

3. **Data Access/Integration**
   * `spring-jdbc`: Simplifica el uso de JDBC y maneja las excepciones específicas de SQL.
   
   * `spring-tx`: Soporte para la gestión de transacciones declarativas y programáticas.
   
   * `spring-orm`: Integración con frameworks ORM como Hibernate, JPA, y otros.

   * `spring-oxm`: Proporciona soporte para la vinculación de objetos XML (Object/XML Mapping).

   * `spring-jms`: Soporte para la mensajería Java Message Service (JMS).

4. **Web (MVC/Remoting)**
   
   * `spring-web`: Proporciona las funcionalidades básicas para el desarrollo de aplicaciones web, incluyendo la carga de archivos y el uso de servlets.
   * `spring-webmvc`: Implementación del patrón Modelo-Vista-Controlador (MVC) para aplicaciones web, conocida como Spring MVC.
   * `spring-websocket`: Soporte para la comunicación basada en WebSocket.
   * `spring-webflux`: Soporte para aplicaciones web reactivas usando el modelo de programación reactiva.

5. **Instrumentation**
   * **spring-instrument**: Soporte para la instrumentación de la clase Java, útil para el uso con contenedores de aplicaciones.

6. **Messaging**
   * **spring-messaging**: Soporte para mensajería basada en mensajes y anotaciones.

7. **Test**
   * `spring-test`: Soporte para pruebas unitarias e integración con **JUnit** y **TestNG**, incluyendo soporte para pruebas de integración en entornos Spring.

**Diagrama de estructura**
```bash
spring-framework/
|-- core/
|   |-- spring-core
|   |-- spring-beans
|   |-- spring-context
|   |-- spring-context-support
|
|-- aop/
|   |-- spring-aop
|   |-- spring-aspects
|
|-- data-access/
|   |-- spring-jdbc
|   |-- spring-tx
|   |-- spring-orm
|   |-- spring-oxm
|   |-- spring-jms
|
|-- web/
|   |-- spring-web
|   |-- spring-webmvc
|   |-- spring-websocket
|   |-- spring-webflux
|
|-- instrumentation/
|   |-- spring-instrument
|
|-- messaging/
|   |-- spring-messaging
|
|-- test/
|   |-- spring-test
```

## Estructura de Directorios
La estructura de directorios de una aplicación Spring Framework bien organizada facilita el mantenimiento y la escalabilidad del proyecto. 

```bash
my-spring-app/
|-- src/
|   |-- main/
|   |   |-- java/
|   |   |   |-- com/
|   |   |       |-- example/
|   |   |           |-- myapp/
|   |   |               |-- MySpringApplication.java
|   |   |               |-- config/
|   |   |               |   |-- AppConfig.java
|   |   |               |-- controller/
|   |   |               |   |-- MyController.java
|   |   |               |-- service/
|   |   |               |   |-- MyService.java
|   |   |               |-- repository/
|   |   |               |   |-- MyRepository.java
|   |   |               |-- model/
|   |   |                   |-- MyModel.java
|   |   |-- resources/
|   |       |-- application.properties
|   |       |-- static/
|   |       |   |-- css/
|   |       |   |-- js/
|   |       |-- templates/
|   |       |-- messages.properties
|-- src/
|   |-- test/
|       |-- java/
|           |-- com/
|               |-- example/
|                   |-- myapp/
|                       |-- MySpringApplicationTests.java
|                       |-- controller/
|                       |-- service/
|                       |-- repository/
|-- pom.xml
|-- README.md
```
**Descripción de los Directorios y Archivos**

1. `src/main/java/`: Contiene el código fuente principal de la aplicación.

   * `com/example/myapp/`: El paquete base del proyecto.
     * `MySpringApplication.java`: La clase principal que inicia la aplicación Spring
     
     * `config/`: Contiene las clases de configuración.
        * `AppConfig.java`: Clase de configuración principal.
     
     * `service/`: Contiene las clases de servicio.
        * `MyService.java`: Un ejemplo de servicio.
     
     * `repository/`: Contiene las interfaces y clases de repositorio (DAO).
         * `MyRepository.java`: Un ejemplo de repositorio.
     
     * `model/`: Contiene las clases de modelo/entidad.
         * `MyModel.java`: Un ejemplo de modelo de datos.
   
2. `src/main/resources/`: Contiene los recursos de la aplicación.

   * `application.properties`: Archivo de configuración principal de la aplicación.
   
   * `static/`: Contiene recursos estáticos como CSS, JavaScript e imágenes
     * `css/`: Hojas de estilo CSS.
     * `js/`: Archivos JavaScript.
   
   * `templates/`: Contiene las plantillas HTML si se utiliza un motor de plantillas como **Thymeleaf**.
   
   * `messages.properties`: Archivo de propiedades para mensajes de internacionalización.

3. `src/test/java/`: Contiene el código de prueba.

   * `com/example/myapp/`: El paquete base para las pruebas
     * `MySpringApplicationTests.java`: Clase principal para pruebas de la aplicación.
     * `controller/`: Pruebas unitarias y de integración para los controladores.
     * `service/`: Pruebas unitarias y de integración para los servicios.
     * `repository/`: Pruebas unitarias y de integración para los repositorios.

4. `pom.xml`: Archivo de configuración de Maven que define las dependencias y plugins necesarios para el proyecto.

5. `README.md`: Archivo de documentación del proyecto.


## Ejemplo de Código

- **Clase Principal**
  ```java
  package com.example.myapp;

  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;

  @SpringBootApplication
  public class MySpringApplication {
      public static void main(String[] args) {
          SpringApplication.run(MySpringApplication.class, args);
      }
  }
  ```

- **Clase de Configuración**
   ```java
   package com.example.myapp.config;

   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

   @Configuration
   public class AppConfig implements WebMvcConfigurer {
      // Configuración adicional
   }
   ```

- **Controlador**
   ```java
   package com.example.myapp.controller;

   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.RestController;

   @RestController
   public class MyController {

      @GetMapping("/hello")
      public String sayHello() {
         return "Hello, World!";
      }
   }
   ```

- **Servicio**
   ```java
   package com.example.myapp.service;

   import org.springframework.stereotype.Service;

   @Service
   public class MyService {
      // Lógica del negocio
   }
   ```

- **Repositorio**
   ```java
   package com.example.myapp.repository;

   import org.springframework.data.jpa.repository.JpaRepository;
   import org.springframework.stereotype.Repository;
   import com.example.myapp.model.MyModel;

   @Repository
   public interface MyRepository extends JpaRepository<MyModel, Long> {
      // Métodos de acceso a datos
   }
   ```

- **Modelo**
   ```java
   package com.example.myapp.model;

   import javax.persistence.Entity;
   import javax.persistence.GeneratedValue;
   import javax.persistence.GenerationType;
   import javax.persistence.Id;

   @Entity
   public class MyModel {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String name;

      // Getters y Setters
   }
   ```

## `application.properties`
El archivo `application.properties` es un archivo de configuración utilizado en aplicaciones Spring Boot para definir propiedades de configuración que afectan el comportamiento de la aplicación. Spring Boot busca este archivo automáticamente en la raíz del `classpath` y lo utiliza para configurar varios aspectos del framework y de la propia aplicación.

**¿Qué es el application.properties?**

* **Descripción**: Es un archivo de propiedades estándar en formato `clave`-`valor` que se utiliza para externalizar la configuración de la aplicación.

* **Ubicación**: Generalmente se encuentra en el directorio `src/main/resources`.

* **Propósito**: Permite modificar la configuración de la aplicación sin necesidad de cambiar el código fuente. Esto facilita la gestión de diferentes configuraciones para distintos entornos (desarrollo, pruebas, producción).

**¿Qué se puede configurar en el `application.properties`?**

Se puede configurar prácticamente cualquier aspecto de una aplicación Spring Boot. 
Aquí hay algunas configuraciones comunes:

```java
// server port
server.port=8080

// application context
server.servlet.context-path=/miapp

// database config
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=secret
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

// hibernate config
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

// logs config
// global
logging.level.root=INFO

// specific package
logging.level.com.example=DEBUG

// format output
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n

// security config
// credentials
spring.security.user.name=admin
spring.security.user.password=secret

// config i18n
spring.messages.basename=messages

// messages codification
spring.messages.encoding=UTF-8

// email config
// SMTP server
spring.mail.host=smtp.example.com
spring.mail.port=587
spring.mail.username=user@example.com
spring.mail.password=secret
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

// cache config
spring.cache.type=simple

// EhCache
spring.cache.ehcache.config=classpath:ehcache.xml
```

**Configuración Avanzada**

- **Perfiles de Configuración**

Spring Boot permite definir diferentes archivos de propiedades para distintos perfiles de entorno, como `application-dev.properties` y `application-prod.properties`. Puedes activar un perfil específico con la siguiente propiedad:
```java
spring.profiles.active=dev
```